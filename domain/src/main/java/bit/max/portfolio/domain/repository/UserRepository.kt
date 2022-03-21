package bit.max.portfolio.domain.repository

import bit.max.portfolio.domain.models.UserName

interface UserRepository {

    fun getName(): UserName

    fun saveName(userName: UserName): Boolean
}