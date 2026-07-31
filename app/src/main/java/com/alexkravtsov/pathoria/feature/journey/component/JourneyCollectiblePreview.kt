package com.alexkravtsov.pathoria.feature.journey.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaSpacing
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaTheme
import com.alexkravtsov.pathoria.feature.journey.theme.JourneyArtworkColors

private val CollectibleMarkerSize = 48.dp

@Composable
fun JourneyCollectiblePreview(
    label: String,
    title: String,
    distance: String,
    description: String,
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
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PathoriaSpacing.medium),
            horizontalArrangement = Arrangement.spacedBy(PathoriaSpacing.medium),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(CollectibleMarkerSize)
                    .background(
                        color = JourneyArtworkColors.collectibleMarkerContainer,
                        shape = CircleShape
                    )
                    .clearAndSetSemantics { },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "✦",
                    color = JourneyArtworkColors.accent,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(PathoriaSpacing.medium)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(PathoriaSpacing.small)
                ) {
                    Text(
                        text = label,
                        color = JourneyArtworkColors.secondaryText,
                        style = MaterialTheme.typography.labelMedium
                    )
                    Text(
                        text = title,
                        color = JourneyArtworkColors.primaryText,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(PathoriaSpacing.small)
                ) {
                    Text(
                        text = distance,
                        color = JourneyArtworkColors.accent,
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = description,
                        color = JourneyArtworkColors.secondaryText,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
)
@Composable
private fun JourneyCollectiblePreviewPreview() {
    PathoriaTheme {
        JourneyCollectiblePreview(
            label = "Ближайшая находка",
            title = "Лунный цветок",
            distance = "Через 850 шагов",
            description = "Светится у старого моста",
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
private fun JourneyCollectiblePreviewLargeFontPreview() {
    PathoriaTheme {
        JourneyCollectiblePreview(
            label = "Ближайшая находка",
            title = "Лунный цветок",
            distance = "Через 850 шагов",
            description = "Светится у старого моста",
            modifier = Modifier.fillMaxWidth()
        )
    }
}