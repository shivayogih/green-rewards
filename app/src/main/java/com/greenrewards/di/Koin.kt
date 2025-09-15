package com.greenrewards.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.greenrewards.auth.AuthViewModel
import com.greenrewards.data.AppDatabase
import com.greenrewards.data.createAppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<AppDatabase> {
        createAppDatabase(androidContext())
    }
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    viewModel { AuthViewModel(get()) }
}
