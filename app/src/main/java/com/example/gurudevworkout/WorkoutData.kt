package com.example.gurudevworkout

import androidx.annotation.DrawableRes

data class Exercise(
    val name: String,
    val primaryMuscles: String,
    @DrawableRes val gifResourceId: Int
)

data class MovementPattern(
    val name: String,
    val exercises: List<Exercise>
)

val dailyWorkout = listOf(
    MovementPattern(
        name = "Horizontal Push",
        exercises = listOf(
            Exercise("Push-ups", "Chest, Triceps, Shoulders", R.drawable.ic_launcher_foreground), // Placeholder
            Exercise("Dumbbell Bench Press", "Chest, Triceps, Shoulders", R.drawable.ic_launcher_foreground)
        )
    ),
    MovementPattern(
        name = "Horizontal Pull",
        exercises = listOf(
            Exercise("Dumbbell Row", "Back, Biceps, Rear Delts", R.drawable.ic_launcher_foreground)
        )
    ),
    MovementPattern(
        name = "Vertical Push",
        exercises = listOf(
            Exercise("Dumbbell Shoulder Press", "Shoulders, Triceps", R.drawable.ic_launcher_foreground)
        )
    ),
    MovementPattern(
        name = "Squat",
        exercises = listOf(
            Exercise("Goblet Squat", "Quads, Glutes, Core", R.drawable.ic_launcher_foreground)
        )
    ),
    MovementPattern(
        name = "Hip Hinge",
        exercises = listOf(
            Exercise("Dumbbell Romanian Deadlift", "Hamstrings, Glutes, Lower Back", R.drawable.ic_launcher_foreground)
        )
    )
)
