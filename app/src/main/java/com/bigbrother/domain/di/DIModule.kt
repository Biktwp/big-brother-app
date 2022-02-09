package com.bigbrother.domain.di

import com.bigbrother.domain.repository.IProjectRepository
import com.bigbrother.domain.repository.ProjectRepository
import com.bigbrother.domain.usecase.AddProjectUseCase
import com.bigbrother.domain.usecase.DeleteProjectUseCase
import com.bigbrother.domain.usecase.GetProjectsUseCase
import org.koin.dsl.module

val repositoryModule = module {
    factory<IProjectRepository> { ProjectRepository(get()) }
}

val useCaseModule = module {
    factory { AddProjectUseCase(get()) }
    factory { GetProjectsUseCase(get()) }
    factory { DeleteProjectUseCase(get()) }
}