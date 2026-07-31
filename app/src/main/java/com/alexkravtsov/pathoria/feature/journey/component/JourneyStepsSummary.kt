package com.alexkravtsov.pathoria.feature.journey.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaSpacing
import com.alexkravtsov.pathoria.feature.journey.theme.JourneyArtworkColors

@Composable
fun JourneyStepsSummary(
    todayLabel: String,
    todaySteps: String,
    streakLabel: String,
    streakValue: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = JourneyArtworkColors.panelContainer
        ),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(
            width = 1.dp,
            color = JourneyArtworkColors.panelBorder
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PathoriaSpacing.medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            JourneyStatItem(
                label = todayLabel,
                value = todaySteps,
                modifier = Modifier.weight(1f)
            )
            VerticalDivider()
            JourneyStatItem(
                label = streakLabel,
                value = streakValue,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun JourneyStatItem(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = JourneyArtworkColors.secondaryText
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = JourneyArtworkColors.accent
        )
    }
}