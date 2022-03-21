package bit.max.portfolio.di

import bit.max.portfolio.domain.repository.UserRepository
import bit.max.portfolio.domain.usecases.GetUserNameUseCase
import bit.max.portfolio.domain.usecases.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
        return GetUserNameUseCase(userRepository = userRepository)
    }
}