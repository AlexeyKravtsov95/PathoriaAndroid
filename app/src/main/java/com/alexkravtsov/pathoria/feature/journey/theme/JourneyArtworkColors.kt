package com.alexkravtsov.pathoria.feature.journey.theme

import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaDarkTertiary
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaDeepIndigo
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaWarmCream
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaParchment

internal object JourneyArtworkColors {
    val primaryText = PathoriaWarmCream
    val secondaryText = PathoriaParchment
    val accent = PathoriaDarkTertiary
    val scrim = PathoriaDeepIndigo
    val panelContainer = scrim.copy(alpha = 0.8f)
    val panelBorder = secondaryText.copy(alpha = 0.2f)
    val progressTrack = secondaryText.copy(alpha = 0.3f)
    val collectibleMarkerContainer = accent.copy(alpha = 0.15f)
}
