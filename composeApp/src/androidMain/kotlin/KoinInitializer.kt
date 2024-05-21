import android.app.Application
import core.infrastructure.FileRepository
import infrastructure.di.AppContainer
import infrastructure.di.QuickIdDatabaseFactory
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class KoinInitializer(
    private val application: Application
) {
    actual fun init() {
        val container = AppContainer(QuickIdDatabaseFactory(application))
        val repository = container.fileRepository

        val moduleRepository = module {
            single<FileRepository> { repository }
        }

        startKoin {
            androidContext(application)
            androidLogger()
            modules(moduleRepository, ViewModelModule)
        }
    }


}