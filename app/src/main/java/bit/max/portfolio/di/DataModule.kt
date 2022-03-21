package bit.max.portfolio.di

import android.content.Context
import bit.max.portfolio.data.repository.UserRepositoryImpl
import bit.max.portfolio.data.storage.UserStorage
import bit.max.portfolio.data.storage.shared_prefs.SharedPrefsUserStorage
import bit.max.portfolio.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefsUserStorage(context = context)
    }

    @Singleton
    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}
