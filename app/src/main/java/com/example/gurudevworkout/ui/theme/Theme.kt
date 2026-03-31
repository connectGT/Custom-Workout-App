package com.example.gurudevworkout.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = NeonGreen,
    secondary = ElectricBlue,
    tertiary = WhiteText,
    background = DeepBlack,
    surface = DarkSurface,
    surfaceVariant = LightSurface,
    onPrimary = DeepBlack,
    onSecondary = DeepBlack,
    onBackground = WhiteText,
    onSurface = WhiteText,
    onSurfaceVariant = GreyText
)

private val LightColorScheme = lightColorScheme(
    primary = NeonGreen,
    secondary = ElectricBlue,
    tertiary = DeepBlack,
    background = WhiteText,
    surface = WhiteText,
    surfaceVariant = GreyText,
    onPrimary = DeepBlack,
    onSecondary = DeepBlack,
    onBackground = DeepBlack,
    onSurface = DeepBlack,
    onSurfaceVariant = DarkSurface
)

@Composable
fun GuruDevWorkoutTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // We disable dynamic color by default for our intense fitness theme
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> DarkColorScheme // Force dark theme everywhere for the intense vibe
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        val window = (view.context as Activity).window
        window.statusBarColor = colorScheme.primary.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
