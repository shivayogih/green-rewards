package com.greenrewards.data

import java.util.Date

data class User(
    val id: String,
    val email: String,
    val displayName: String,
    val profilePictureUrl: String? = null,
    val ecoPoints: Int = 0
)

data class Activity(
    val id: String,
    val userId: String,
    val type: ActivityType,
    val details: Map<String, String>,
    val timestamp: Date
)

enum class ActivityType {
    WALKING,
    CYCLING,
    RECYCLED_ITEM,
    NO_PLASTIC_USED
}

data class Reward(
    val id: String,
    val name: String,
    val description: String,
    val cost: Int,
    val imageUrl: String? = null
)

data class Challenge(
    val id: String,
    val name: String,
    val description: String,
    val goal: Int,
    val reward: Int
)
