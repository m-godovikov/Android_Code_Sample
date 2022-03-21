package bit.max.portfolio.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val applicationContext: Context){
    @Provides
    fun provideContext(): Context {
        return applicationContext
    }
}