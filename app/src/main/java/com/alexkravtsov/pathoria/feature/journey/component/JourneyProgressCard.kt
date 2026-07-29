package com.alexkravtsov.pathoria.feature.journey.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaSpacing
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaTheme
import com.alexkravtsov.pathoria.feature.journey.theme.JourneyArtworkColors

@Composable
fun JourneyProgressCard(
    label: String,
    distance: String,
    remainingSteps: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = JourneyArtworkColors.progressCardContainer
        ),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(
            width = 1.dp,
            color = JourneyArtworkColors.progressCardBorder
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PathoriaSpacing.medium),
            verticalArrangement = Arrangement.spacedBy(PathoriaSpacing.small)
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = JourneyArtworkColors.secondaryText
            )
            Text(
                text = distance,
                style = MaterialTheme.typography.displaySmall,
                color = JourneyArtworkColors.accent
            )
            Text(
                text = remainingSteps,
                style = MaterialTheme.typography.bodyMedium,
                color = JourneyArtworkColors.primaryText
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 640,
)
@Composable
private fun JourneyProgressCardPreview() {
    PathoriaTheme {
        JourneyProgressCard(
            label = "До следующей точки",
            distance = "2,1км",
            remainingSteps = "Шагов осталось: 2720",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 640,
    fontScale = 2.0f
)
@Composable
private fun JourneyProgressCardLargeFontPreview() {
    PathoriaTheme {
        JourneyProgressCard(
            label = "До следующей точки",
            distance = "2,1км",
            remainingSteps = "Шагов осталось: 2720",
            modifier = Modifier.fillMaxWidth()
        )
    }
}