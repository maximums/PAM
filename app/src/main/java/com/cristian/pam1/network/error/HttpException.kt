package com.cristian.pam1.network.error

import java.io.IOException

sealed class HttpException(apiError: ApiError) : IOException(apiError.error)

class BadRequestException(apiError: ApiError) : HttpException(apiError)
class UnauthorizedAccessException(apiError: ApiError) : HttpException(apiError)