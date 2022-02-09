package com.bigbrother.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bigbrother.data.database.dao.ProjectDao
import com.bigbrother.data.database.dao.TagsDao
import com.bigbrother.data.database.dao.TaskDao
import com.bigbrother.data.database.model.ProjectEntity
import com.bigbrother.data.database.model.TaskEntity

@Database(
    entities = [ProjectEntity::class, TaskEntity::class, TaskEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListStringConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun projectDao(): ProjectDao
    abstract fun tagsDao(): TagsDao
}