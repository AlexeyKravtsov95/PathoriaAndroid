package com.alexkravtsov.pathoria.feature.journey.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaSpacing
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaTheme
import com.alexkravtsov.pathoria.feature.journey.theme.JourneyArtworkColors

@Composable
fun JourneyLocationHeader(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(PathoriaSpacing.small)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = JourneyArtworkColors.primaryText
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.labelLarge,
            color = JourneyArtworkColors.secondaryText
        )
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 640,
)
@Composable
private fun JourneyLocationHeaderLongTitlePreview() {
    PathoriaTheme {
        JourneyLocationHeader(
            title = "Заброшенная лесная переправа у северной реки",
            subtitle = "Глава 12 · Путь через туманные холмы"
        )
    }
}