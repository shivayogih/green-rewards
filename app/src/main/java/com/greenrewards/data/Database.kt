package com.greenrewards.data

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

fun createAppDatabase(context: Context): AppDatabase {
    val driver: SqlDriver = AndroidSqliteDriver(AppDatabase.Schema, context, "app.db")
    return AppDatabase(driver)
}
