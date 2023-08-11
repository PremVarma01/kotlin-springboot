package com.example.kotlinspringboot.exception

import java.lang.Exception

internal class MovieException(override val message: String?) : Exception(message) {
}