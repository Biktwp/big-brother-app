package com.bigbrother.domain.usecase

import com.bigbrother.Result
import com.bigbrother.domain.base.UseCase
import com.bigbrother.domain.model.ProjectBo
import com.bigbrother.domain.repository.IProjectRepository

class GetProjectsUseCase(private val repository: IProjectRepository) :
    UseCase<Unit, List<ProjectBo>>() {
    override suspend fun run(params: Unit): Result<List<ProjectBo>> {
        return repository.getProjects()
    }
}