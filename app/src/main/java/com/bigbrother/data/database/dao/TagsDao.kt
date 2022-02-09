package com.bigbrother.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bigbrother.data.database.model.TagsEntity

@Dao
interface TagsDao {
    @Insert
    fun addTag(tagsEntity: TagsEntity)

    @Delete
    fun deleteTag(tagsEntity: TagsEntity)

    @Query("SELECT * FROM tags")
    fun getTags()
}