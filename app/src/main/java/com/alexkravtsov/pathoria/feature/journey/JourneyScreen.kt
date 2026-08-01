package com.alexkravtsov.pathoria.feature.journey

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.alexkravtsov.pathoria.R
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaSpacing
import com.alexkravtsov.pathoria.feature.journey.component.JourneyCollectiblePreview
import com.alexkravtsov.pathoria.feature.journey.component.JourneyLocationHeader
import com.alexkravtsov.pathoria.feature.journey.component.JourneyProgressCard
import com.alexkravtsov.pathoria.feature.journey.component.JourneyStepsSummary
import com.alexkravtsov.pathoria.feature.journey.theme.JourneyArtworkColors

@Composable
fun JourneyScreen(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues()
) {
    val remainingSteps = 2720
    val scrimColor = JourneyArtworkColors.scrim
    val journeyProgress = 0.61f

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

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .consumeWindowInsets(contentPadding)
                .padding(PathoriaSpacing.large),
        ) {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .heightIn(min = maxHeight),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                JourneyLocationHeader(
                    title = stringResource(R.string.journey_forest_crossing_title),
                    subtitle = stringResource(R.string.journey_forest_crossing_subtitle)
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(PathoriaSpacing.small)
                ) {
                    JourneyCollectiblePreview(
                        label = stringResource(R.string.journey_collectible_label),
                        title = stringResource(R.string.journey_collectible_moon_flower_title),
                        distance = stringResource(R.string.journey_collectible_distance),
                        description = stringResource(R.string.journey_collectible_description),
                        modifier = Modifier.fillMaxWidth()
                    )
                    JourneyStepsSummary(
                        todayLabel = stringResource(R.string.journey_today),
                        todaySteps = stringResource(R.string.journey_current_today_steps),
                        streakLabel = stringResource(R.string.journey_streak),
                        streakValue = stringResource(R.string.journey_current_streak),
                        modifier = Modifier.fillMaxWidth()
                    )
                    JourneyProgressCard(
                        label = stringResource(R.string.journey_next_point),
                        distance = stringResource(R.string.journey_current_distance),
                        remainingSteps = stringResource(
                            R.string.journey_steps_left, remainingSteps
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        progress = journeyProgress
                    )
                }
            }
        }
    }
}