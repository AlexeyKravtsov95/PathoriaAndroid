package com.alexkravtsov.pathoria.core.designsystem.component

import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        modifier = modifier,
        color = color,
        trackColor = trackColor,
        strokeCap = StrokeCap.Round,
        gapSize = ProgressIndicatorHeight
    )
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 640,
)
@Composable
fun PathoriaProgressIndicatorPreview() {
    PathoriaTheme {
        PathoriaProgressIndicator(
            progress = 0f,
        )
    }
    PathoriaTheme {
        PathoriaProgressIndicator(
            progress = 0.61f,
        )
    }
    PathoriaTheme {
        PathoriaProgressIndicator(
            progress = 1f,
        )
    }
}