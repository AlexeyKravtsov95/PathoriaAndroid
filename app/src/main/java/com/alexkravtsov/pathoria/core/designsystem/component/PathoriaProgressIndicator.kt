package com.alexkravtsov.pathoria.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaSpacing
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaTheme

private val ProgressIndicatorHeight = 8.dp

@Composable
fun PathoriaProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.tertiary,
    trackColor: Color = MaterialTheme.colorScheme.surfaceVariant
) {
    LinearProgressIndicator(
        progress = { progress },
        modifier = modifier.height(ProgressIndicatorHeight),
        color = color,
        trackColor = trackColor,
        strokeCap = StrokeCap.Round,
        gapSize = 0.dp,
        drawStopIndicator = {}
    )
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 640,
)
@Composable
private fun PathoriaProgressIndicatorPreview() {
    PathoriaTheme {
        Column(
            modifier = Modifier
                .padding(PathoriaSpacing.medium),
            verticalArrangement = Arrangement.spacedBy(PathoriaSpacing.medium)
        ) {
            Text("0%")
            PathoriaProgressIndicator(
                progress = 0f,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text("61%")
            PathoriaProgressIndicator(
                progress = 0.61f,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text("100%")
            PathoriaProgressIndicator(
                progress = 1f,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}