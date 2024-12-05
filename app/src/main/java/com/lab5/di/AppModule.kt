package com.lab5.di

import com.lab5.data.db.DatabaseStorage
import com.lab5.ui.viewmodel.SubjectViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { DatabaseStorage.getDatabase(get()).subjectsDao }
    single { DatabaseStorage.getDatabase(get()).subjectLabsDao }
    viewModel { SubjectViewModel(get(), get()) }
}
