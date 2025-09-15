pluginManagement {
    repositories {
        google() // Add this line
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google() // And also ensure it's here
        mavenCentral()
    }
}
rootProject.name = "GreenRewards"

include(":app")
include(":core:ui")
include(":feature:auth")
include(":feature:home")
include(":feature:challenges")
include(":feature:marketplace")
include(":feature:wallet")



