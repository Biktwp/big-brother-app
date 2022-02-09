package com.bigbrother.data.di

import androidx.room.Room
import com.bigbrother.data.database.AppDataBase
import com.bigbrother.data.datasource.project.IProjectDataSource
import com.bigbrother.data.datasource.project.ProjectDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataSourceModule = module {
    factory<IProjectDataSource> { ProjectDataSource(get(), get(), get()) }
}

val dataBaseModule = module {
    single { Room.databaseBuilder(androidApplication(), AppDataBase::class.java, "big_brother_db") }

    //Dao
    single { get<AppDataBase>().projectDao() }
    single { get<AppDataBase>().tagsDao() }
    single { get<AppDataBase>().taskDao() }
}