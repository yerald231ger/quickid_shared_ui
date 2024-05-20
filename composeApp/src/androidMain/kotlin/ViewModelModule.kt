import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

actual val ViewModelModule = module {
    viewModelOf(::MainViewModel)
}