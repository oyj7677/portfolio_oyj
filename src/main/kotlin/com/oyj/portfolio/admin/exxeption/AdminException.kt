package com.oyj.portfolio.admin.exxeption

import org.springframework.http.HttpStatus

abstract class AdminException(
    httpStatus: HttpStatus,
    message: String
) : RuntimeException(message) {
    val httpStatus: HttpStatus = httpStatus
}

class AdminBadRequestException(message: String) : AdminException(
    message = message,
    httpStatus = HttpStatus.BAD_REQUEST
) {

}

class AdminInternalServerErrorException(message: String) : AdminException(
    message = message,
    httpStatus = HttpStatus.INTERNAL_SERVER_ERROR
) {

}