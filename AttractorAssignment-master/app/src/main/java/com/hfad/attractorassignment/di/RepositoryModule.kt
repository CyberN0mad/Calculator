package com.hfad.attractorassignment.di
import com.hfad.attractorassignment.repository.MainRepo
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepo() }
}