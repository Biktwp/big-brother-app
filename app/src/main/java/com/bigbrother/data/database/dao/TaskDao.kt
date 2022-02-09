package com.bigbrother.data.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.bigbrother.data.database.model.TaskEntity

@Dao
interface TaskDao {
    @Insert(onConflict = REPLACE)
    fun addTask(taskEntity: TaskEntity)

    @Delete
    fun deleteTask(taskEntity: TaskEntity)

    @Update
    fun updateTask(taskEntity: TaskEntity)

    @Query("SELECT * FROM tasks WHERE id = :taskId")
    fun getTask(taskId: String): TaskEntity

    @Query("SELECT * FROM tasks WHERE project_id = :projectId")
    fun getTasksFromProject(projectId: String): List<TaskEntity>
}