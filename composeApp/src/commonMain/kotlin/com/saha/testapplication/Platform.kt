package com.saha.testapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform