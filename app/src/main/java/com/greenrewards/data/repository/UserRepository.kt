
package com.greenrewards.data.repository

import com.greenrewards.data.User

interface UserRepository {
    suspend fun getUser(): User?
    suspend fun saveUser(user: User)
}
