package bit.max.portfolio.data.repository


import bit.max.portfolio.data.storage.UserStorage
import bit.max.portfolio.data.storage.models.User
import bit.max.portfolio.domain.models.UserName
import bit.max.portfolio.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun getName(): UserName {
        val user = userStorage.load()
        return mapToDomain(user = user)
    }

    override fun saveName(userName: UserName): Boolean {
        val user = mapToData(userName = userName)
        return userStorage.save(user = user)
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(
            firstName = user.firstName,
            lastName = user.lastName
        )
    }

    private fun mapToData(userName: UserName): User {
        return User(
            firstName = userName.firstName,
            lastName = userName.lastName
        )
    }
}