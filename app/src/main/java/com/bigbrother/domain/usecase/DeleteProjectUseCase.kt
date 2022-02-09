package com.bigbrother.domain.usecase

import com.bigbrother.Result
import com.bigbrother.domain.base.UseCase
import com.bigbrother.domain.repository.IProjectRepository

class DeleteProjectUseCase(private val repository: IProjectRepository) :
    UseCase<DeleteProjectUseCase.Params, Unit>() {

    override suspend fun run(params: Params): Result<Unit> {
        repository.deleteProject(params.projectId)
        return Result.Success(Unit)
    }

    class Params(val projectId: String)

}