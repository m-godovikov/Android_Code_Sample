package bit.max.portfolio.domain.usecases

import bit.max.portfolio.domain.models.InputUserName
import bit.max.portfolio.domain.models.UserName
import bit.max.portfolio.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(inputUserName: InputUserName): Boolean {
        val userName =
            UserName(firstName = inputUserName.firstName, lastName = inputUserName.lastName)
        return userRepository.saveName(userName = userName)
    }
}