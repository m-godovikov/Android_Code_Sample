package bit.max.portfolio.data.storage

import bit.max.portfolio.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun load(): User
}