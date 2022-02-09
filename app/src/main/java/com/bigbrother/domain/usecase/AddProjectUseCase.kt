package com.bigbrother.domain.usecase

import com.bigbrother.Result
import com.bigbrother.domain.base.UseCase
import com.bigbrother.domain.model.ProjectBo
import com.bigbrother.domain.repository.IProjectRepository

class AddProjectUseCase(private val repository: IProjectRepository) :
    UseCase<AddProjectUseCase.Params, Unit>() {

    override suspend fun run(params: Params): Result<Unit> {
        with(params) {
            repository.addProject(ProjectBo(id, name, columns))
        }
        return Result.Success(Unit)
    }

    class Params(
        val name: String,
        val id: String,
        val columns: List<String>
    )

}