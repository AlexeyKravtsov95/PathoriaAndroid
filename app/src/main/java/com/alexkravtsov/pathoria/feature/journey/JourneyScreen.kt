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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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

@Composable
fun JourneyScreen(modifier: Modifier = Modifier) {
    val remainingSteps = 2720
    val surfaceColor = MaterialTheme.colorScheme.surface
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(surfaceColor)
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
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.00f to surfaceColor.copy(alpha = 0.1f),
                            0.20f to surfaceColor.copy(alpha = 0.2f),
                            0.40f to Color.Transparent,
                            0.62f to Color.Transparent,
                            0.82f to surfaceColor.copy(alpha = 0.2f),
                            1.00f to surfaceColor.copy(alpha = 0.3f)
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
            Column(verticalArrangement = Arrangement.spacedBy(PathoriaSpacing.small)) {
                Text(
                    text = stringResource(R.string.journey_next_point),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = stringResource(R.string.journey_current_distance),
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.tertiary
                )
                Text(
                    text = stringResource(R.string.journey_steps_left, remainingSteps),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}