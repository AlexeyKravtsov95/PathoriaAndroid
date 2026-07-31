package com.alexkravtsov.pathoria.feature.journey.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaSpacing
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaTheme
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
                .height(IntrinsicSize.Min)
                .padding(PathoriaSpacing.medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            JourneyStatItem(
                label = todayLabel,
                value = todaySteps,
                valueColor = JourneyArtworkColors.primaryText,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = PathoriaSpacing.small)
            )
            VerticalDivider(
                modifier = Modifier.fillMaxHeight(),
                thickness = 1.dp,
                color = JourneyArtworkColors.panelBorder
            )
            JourneyStatItem(
                label = streakLabel,
                value = streakValue,
                valueColor = JourneyArtworkColors.accent,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = PathoriaSpacing.small)
            )
        }
    }
}

@Composable
private fun JourneyStatItem(
    label: String,
    value: String,
    valueColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = JourneyArtworkColors.secondaryText
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = valueColor
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 360
)
@Composable
private fun JourneyStepsSummaryPreview() {
    PathoriaTheme {
        JourneyStepsSummary(
            todayLabel = "Сегодня",
            todaySteps = "6 430 шагов",
            streakLabel = "Серия",
            streakValue = "4 дня",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
    fontScale = 2.0f
)
@Composable
private fun JourneyStepsSummaryLargePreview() {
    PathoriaTheme {
        JourneyStepsSummary(
            todayLabel = "Сегодня",
            todaySteps = "6 430 шагов",
            streakLabel = "Серия",
            streakValue = "4 дня",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
