import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class KoinInitializer(
    private val application: Application
) {

    actual fun init() {
         startKoin {
            androidContext(application)
            modules(appModule, ViewModelModule)
         }
    }
}