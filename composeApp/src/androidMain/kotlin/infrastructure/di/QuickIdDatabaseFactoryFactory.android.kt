package infrastructure.di/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.Application
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import infrastructure.database.QuickIdDatabase
import infrastructure.database.dbFileName
import kotlinx.coroutines.Dispatchers

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class QuickIdDatabaseFactory(private val app: Application) {

    actual fun createRoomDatabase(): QuickIdDatabase {
        val dbFile = app.getDatabasePath(dbFileName)
        return Room.databaseBuilder<QuickIdDatabase>(app, dbFile.absolutePath)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}