package com.example.app.web.`___`

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


//@ControllerAdvice
class ProblemDetailsExceptionHandler : ResponseEntityExceptionHandler() {
//    @ExceptionHandler([InvalidTokenException::class, AuthenticationException::class])
//    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
//    @ResponseBody
//    fun handleAuthenticationException(ex: Exception): RestError {
//        var errorCode: Int = AegisErrorCode.GenericAuthenticationError
//        if (ex is AegisException) {
//            errorCode = (ex as AegisException).getCode()
//        }
//        return RestError(
//            HttpStatus.UNAUTHORIZED,
//            errorCode,
//            "...",
//            ex.message
//        )
//    }

    override fun handleExceptionInternal(
        ex: Exception,
        body: Any?,
        headers: HttpHeaders,
        statusCode: HttpStatusCode,
        request: WebRequest,
    ): ResponseEntity<Any>? {

        return super.handleExceptionInternal(ex, body, headers, statusCode, request)
    }

    override fun createResponseEntity(
        body: Any?,
        headers: HttpHeaders,
        statusCode: HttpStatusCode,
        request: WebRequest,
    ): ResponseEntity<Any> {
        return super.createResponseEntity(body, headers, statusCode, request)
    }

}
