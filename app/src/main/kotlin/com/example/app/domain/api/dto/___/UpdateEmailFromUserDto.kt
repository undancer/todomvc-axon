package com.example.app.domain.api.dto.`___`

import java.util.*

class UpdateEmailFromUserDto {
    var emailAddress: String? = null
    var formerEmailAddress: String? = null
    var userId: UUID? = null

    constructor(emailAddress: String?, formerEmailAddress: String?) {
        this.emailAddress = emailAddress
        this.formerEmailAddress = formerEmailAddress
    }

    constructor()
}
