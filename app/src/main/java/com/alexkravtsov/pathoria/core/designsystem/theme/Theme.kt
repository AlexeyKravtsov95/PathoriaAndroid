package com.alexkravtsov.pathoria.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = PathoriaDarkPrimary,
    secondary = PathoriaDarkSecondary,
    tertiary = PathoriaDarkTertiary,
    tertiaryContainer = PathoriaDarkTertiaryContainer,
    background = PathoriaDarkSurface,
    surface = PathoriaDarkSurface,
    onPrimary = PathoriaDeepIndigo,
    secondaryContainer = PathoriaDarkSecondaryContainer,
    onSecondaryContainer = PathoriaDarkOnSecondaryContainer,
    onTertiary = PathoriaDarkOnTertiary,
    onTertiaryContainer = PathoriaDarkOnTertiaryContainer,
    onBackground = PathoriaWarmCream,
    onSurface = PathoriaWarmCream,
    primaryContainer = PathoriaTwilightBlue,
    onPrimaryContainer = PathoriaWarmCream,
    surfaceVariant = PathoriaDeepIndigo,
    onSurfaceVariant = PathoriaDarkOnSurfaceVariant,
    outline = PathoriaDustyBlue
)

private val LightColorScheme = lightColorScheme(
    primary = PathoriaDeepIndigo,
    secondary = PathoriaForestGreen,
    tertiary = PathoriaDarkGold,
    tertiaryContainer = PathoriaLightTertiaryContainer,
    background = PathoriaLightSurface,
    surface = PathoriaLightSurface,
    onPrimary = PathoriaWarmCream,
    onSecondary = Color.White,
    onSecondaryContainer = PathoriaGreenOnSecondaryContainer,
    onTertiary = Color.White,
    onTertiaryContainer = PathoriaOnTertiaryContainer,
    onBackground = PathoriaDeepIndigo,
    onSurface = PathoriaDeepIndigo,
    primaryContainer = PathoriaLightPrimaryContainer,
    onPrimaryContainer = PathoriaDeepOnPrimaryContainer,
    surfaceVariant = PathoriaParchment,
    onSurfaceVariant = PathoriaTwilightBlue,
    outline = PathoriaDustyBlue,
    secondaryContainer = PathoriaLightSecondaryContainer
)

@Composable
fun PathoriaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = PathoriaTypography,
        content = content
    )
}