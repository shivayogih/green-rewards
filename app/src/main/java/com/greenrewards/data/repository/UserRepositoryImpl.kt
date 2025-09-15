
package com.greenrewards.data.repository

import com.greenrewards.data.User
import com.greenrewards.data.UserQueries

class UserRepositoryImpl(private val userQueries: UserQueries) : UserRepository {
    override suspend fun getUser(): User? {
        return userQueries.selectAll().executeAsOneOrNull()
    }

    override suspend fun saveUser(user: User) {
        userQueries.insert(user.id, user.email)
    }
}
