package com.example.app.web

import com.example.app.domain.api.queries.FindUserRootQuery
import com.example.app.domain.handle.UserService
import com.example.app.model.User
import jakarta.annotation.Resource
import jakarta.servlet.http.HttpServletRequest
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.extensions.kotlin.query
import org.axonframework.queryhandling.QueryGateway
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.servlet.support.RequestContextUtils


@Controller
@RequestMapping(path = ["/user"])
class UserController {

    private var logger: Logger = LoggerFactory.getLogger(UserController::class.java)

//    @Resource
//    lateinit var queryBus: QueryBus
//
//    @Resource
//    lateinit var commandBus: CommandBus

    @Resource
    lateinit var queryGateway: QueryGateway

    @Resource
    lateinit var commandGateway: CommandGateway

    @Resource
    lateinit var userService: UserService

    fun info(request: HttpServletRequest) {
        logger.info("Utils: {}", RequestContextUtils.findWebApplicationContext(request))
        logger.info("Holder: {}", RequestContextHolder.currentRequestAttributes())
        logger.info("gateway: {}", queryGateway)
        logger.info("gateway: {}", commandGateway)
//        logger.info("jpa: {}", userJpaRepository)
//        logger.info("foo: {}", userJpaRepository.foo())
    }

    @GetMapping("/info")
    fun getInfo(): HttpEntity<Any> {

//        WebUtils.DEFAULT_WEB_APP_ROOT_KEY
//        RequestContextUtils.REQUEST_DATA_VALUE_PROCESSOR_BEAN_NAME
//        RequestContext.WEB_APPLICATION_CONTEXT_ATTRIBUTE
//        RequestContextHolder.currentRequestAttributes().sessionId

//        var pageable: Pageable?
//        var assembler: PagedResourcesAssembler<*>
//        WebMvcLinkBuilder.linkTo(UserController::class.java).slash(1L).withSelfRel()

        val model = CollectionModel.empty<Any>()

        val controller = WebMvcLinkBuilder.methodOn(UserController::class.java)

        model.add(
            WebMvcLinkBuilder.linkTo(controller.getInfo()).withSelfRel()
//                .andAfford(
//                    controller.createCustomer(null)
//                )
        )

//        model.addIf(true) {
//            WebMvcLinkBuilder.linkTo(controller.getInfo())
//                .withSelfRel()
//        }

        return ResponseEntity.ok(
            model
        )
    }

    @GetMapping
    fun home(request: HttpServletRequest): ResponseEntity<Any> {
        val root = queryGateway.query<User, FindUserRootQuery>(FindUserRootQuery()).get()

        logger.info("service: {}", userService)

//        val fff: CompletableFuture<Any> = commandGateway.send(
//            GenericCommandMessage
//                .asCommandMessage<Any>("")
//                .andMetaData(MetaData.with("", ""))
//        )

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(
                buildMap {
                    put("username", "undancer")
                    with(root) {
                        put("_id", id)
                        put("_user", this)
                    }
                }
            )

    }
}
