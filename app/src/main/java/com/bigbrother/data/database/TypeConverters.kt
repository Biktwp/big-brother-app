package com.bigbrother.data.database

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListStringConverter {
    fun toList(data: String): List<String> {
        val list = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(data, list)
    }

    fun fromList(data: List<String>): String {
        return Gson().toJson(data)
    }
}