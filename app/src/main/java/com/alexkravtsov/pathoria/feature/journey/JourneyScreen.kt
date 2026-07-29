package com.alexkravtsov.pathoria.feature.journey

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.alexkravtsov.pathoria.R
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaSpacing
import com.alexkravtsov.pathoria.feature.journey.component.JourneyLocationHeader
import com.alexkravtsov.pathoria.feature.journey.component.JourneyProgressCard
import com.alexkravtsov.pathoria.feature.journey.theme.JourneyArtworkColors

@Composable
fun JourneyScreen(modifier: Modifier = Modifier) {
    val remainingSteps = 2720
    val scrimColor = JourneyArtworkColors.scrim
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(scrimColor)
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.journey_forest_crossing
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.00f to scrimColor.copy(alpha = 0.65f),
                            0.20f to scrimColor.copy(alpha = 0.55f),
                            0.40f to Color.Transparent,
                            0.62f to Color.Transparent,
                            0.82f to scrimColor.copy(alpha = 0.25f),
                            1.00f to scrimColor.copy(alpha = 0.55f)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .padding(PathoriaSpacing.large),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            JourneyLocationHeader(
                title = stringResource(R.string.journey_forest_crossing_title),
                subtitle = stringResource(R.string.journey_forest_crossing_subtitle)
            )
            JourneyProgressCard(
                label = stringResource(R.string.journey_next_point),
                distance = stringResource(R.string.journey_current_distance),
                remainingSteps = stringResource(R.string.journey_steps_left, remainingSteps)
            )
        }
    }
}