package com.bigbrother.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "tasks",
    foreignKeys = [ForeignKey(
        entity = ProjectEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("project_id"),
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
data class TaskEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "project_id")
    val projectId: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "column")
    val column: String,

    @ColumnInfo(name = "creation_date")
    val creationDate: Long,

    @ColumnInfo(name = "end_date")
    val endDate: Long?,

    @ColumnInfo(name = "tags")
    val tags: List<String>
)