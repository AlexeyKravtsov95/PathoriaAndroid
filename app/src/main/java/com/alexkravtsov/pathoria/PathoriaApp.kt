package com.alexkravtsov.pathoria

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaTheme
import com.alexkravtsov.pathoria.feature.journey.JourneyScreen
import com.alexkravtsov.pathoria.ui.navigation.PathoriaBottomBar
import com.alexkravtsov.pathoria.ui.navigation.PathoriaDestination

@Composable
fun PathoriaApp() {
    Scaffold(
        bottomBar = {
            PathoriaBottomBar(
                selectedDestination = PathoriaDestination.JOURNEY,
                onDestinationSelected = {}
            )
        }
    ) { innerPadding ->
        JourneyScreen(contentPadding = innerPadding)
    }
}

@Preview(
    showSystemUi = true,
    widthDp = 360,
    heightDp = 640
)
@Composable
private fun PathoriaAppPreview() {
    PathoriaTheme {
        PathoriaApp()
    }
}