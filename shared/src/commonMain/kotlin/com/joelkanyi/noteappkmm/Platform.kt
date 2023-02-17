package com.joelkanyi.noteappkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform