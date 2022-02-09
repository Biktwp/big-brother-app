package com.bigbrother.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tags")
data class TagsEntity(
    @PrimaryKey
    @ColumnInfo(name = "name")
    val title: String
)