
package com.greenrewards.auth.data

data class User(val id: String, val email: String)

interface AuthRepository {
    suspend fun login(email: String, pass: String) : User
}
