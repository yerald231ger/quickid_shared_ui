package org.gsh.qid

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import infrastructure.di.AppContainer
import infrastructure.di.QuickIdDatabaseFactory

class MainActivity : ComponentActivity() {

    private lateinit var container : AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        container = AppContainer(QuickIdDatabaseFactory(application))
        setContent {
            App(container.fileRepository)
        }
    }
}
