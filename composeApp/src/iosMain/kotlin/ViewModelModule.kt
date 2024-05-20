import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val ViewModelModule = module {
    singleOf(::MainViewModel)
}