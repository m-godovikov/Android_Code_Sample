package bit.max.portfolio.domain.usecases

import bit.max.portfolio.domain.models.UserName
import bit.max.portfolio.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}