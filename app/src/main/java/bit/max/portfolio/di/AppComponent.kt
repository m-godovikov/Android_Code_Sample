package bit.max.portfolio.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent