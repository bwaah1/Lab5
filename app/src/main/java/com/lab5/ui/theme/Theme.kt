package com.lab5.ui.theme

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1A1A1A), // Темно-сірий для основного кольору
    secondary = Color(0xFF333333), // Трохи світліший сірий для вторинного кольору
    tertiary = Color(0xFF4B4B4B), // Середньо-сірий для акценту
    background = Color(0xFF0D0D0D), // Майже чорний для фону
    surface = Color(0xFF1F1F1F), // Темно-сірий для поверхонь
    onPrimary = Color(0xFFE0E0E0), // Світло-сірий текст на темному фоні
    onSecondary = Color(0xFFE0E0E0), // Те ж саме для вторинного
    onTertiary = Color(0xFFE0E0E0), // Те ж саме для акценту
    onBackground = Color(0xFFF5F5F5), // Трохи яскравіший текст для контрасту
    onSurface = Color(0xFFF5F5F5) // Текст на поверхнях
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF333333), // Темно-сірий для основного кольору (у світлій темі)
    secondary = Color(0xFF4B4B4B), // Середньо-сірий для вторинного
    tertiary = Color(0xFF666666), // Світліший сірий для акценту
    background = Color(0xFF1A1A1A), // Темний фон навіть для світлої теми
    surface = Color(0xFF2A2A2A), // Темний колір поверхонь
    onPrimary = Color(0xFFF5F5F5), // Світлий текст на темному фоні
    onSecondary = Color(0xFFF5F5F5), // Текст для вторинного кольору
    onTertiary = Color(0xFFE0E0E0), // Ледь яскравіший текст
    onBackground = Color(0xFFF5F5F5), // Контрастний текст
    onSurface = Color(0xFFE0E0E0) // Контрастний текст на поверхнях
)
@Composable
fun Lab5Theme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
