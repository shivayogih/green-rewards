
package com.greenrewards.auth.data

class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(email: String, pass: String): User {
        return User("1", "test@test.com")
    }
}
