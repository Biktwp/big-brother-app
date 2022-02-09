package com.bigbrother.presentation.common

fun <T : Any> T?.notNull(f: (it: T) -> Unit){
    if(this != null) f(this)
}