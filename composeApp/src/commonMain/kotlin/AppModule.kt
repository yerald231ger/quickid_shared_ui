import core.infrastructure.FileRepository
import infrastructure.repositores.QuickIdFileRepository
import org.koin.dsl.module

val appModule = module {

    single<FileRepository> {
        QuickIdFileRepository(
            database = get(),
            scope = get()
        )
    }
}