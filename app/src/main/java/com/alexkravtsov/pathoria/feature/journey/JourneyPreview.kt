package com.alexkravtsov.pathoria.feature.journey

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaTheme

@Preview(showBackground = true)
@Composable
fun JourneyScreenPreview() {
    PathoriaTheme {
        JourneyScreen()
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 640,
)
@Composable
fun JourneyScreenCompactPreview() {
    PathoriaTheme {
        JourneyScreen()
    }
}

@Preview(
    showBackground = true,
    widthDp = 412,
    heightDp = 915, device = "spec:width=412px,height=915px,dpi=440"
)
@Composable
fun JourneyScreenTallPreview() {
    PathoriaTheme {
        JourneyScreen()
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 640,
    fontScale = 2.0F,
)
@Composable
fun JourneyScreenLargeFontPreview() {
    PathoriaTheme {
        JourneyScreen()
    }
}

@Preview(
    showBackground = true,
    widthDp = 360,
    heightDp = 640,
)
@Composable
fun JourneyScreenDarkPreview() {
    PathoriaTheme(darkTheme = true) {
        JourneyScreen()
    }
}

