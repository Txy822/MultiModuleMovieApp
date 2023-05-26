package com.sample.features.profile.data


data class UserProfile(
    val name: String,
    val email: String,
    val bio: String
)

fun getDummyUserProfile(): UserProfile {
    return UserProfile(
        name = "John Doe",
        email = "johndoe@example.com",
        bio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac leo scelerisque, commodo est nec, semper mi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac leo scelerisque, commodo est nec, semper mi."
    )
}