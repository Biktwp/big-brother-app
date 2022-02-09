package com.bigbrother.data.database.dao

import androidx.room.*
import com.bigbrother.data.database.model.ProjectEntity

@Dao
interface ProjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProject(projectEntity: ProjectEntity)

    @Query("DELETE FROM projects WHERE id = :projectId")
    fun deleteProject(projectId: String)

    @Update
    fun updateProject(projectEntity: ProjectEntity)

    @Query("SELECT * FROM projects WHERE id = :projectId")
    fun getProject(projectId: String): ProjectEntity?

    @Query("SELECT * FROM projects")
    fun getProjects(): List<ProjectEntity>
}