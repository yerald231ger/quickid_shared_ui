package org.gsh.qid

import App
import KoinInitializer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import core.infrastructure.FileRepository
import infrastructure.di.AppContainer
import infrastructure.di.QuickIdDatabaseFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KoinInitializer(application).init()
        setContent {
            App()
        }
    }
}
