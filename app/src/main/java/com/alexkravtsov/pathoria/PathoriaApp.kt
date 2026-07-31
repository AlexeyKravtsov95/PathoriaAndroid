package com.alexkravtsov.pathoria

import android.content.res.Configuration
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
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
    heightDp = 640,
    fontScale = 2.0f
)
@Composable
private fun PathoriaAppPreview() {
    PathoriaTheme {
        PathoriaApp()
    }
}

@Preview(
    name = "Large font",
    widthDp = 360,
    heightDp = 640,
    fontScale = 3.0f,
    showSystemUi = true
)
@Composable
private fun PathoriaAppLargePreview() {
    PathoriaTheme {
        PathoriaApp()
    }
}

@Preview(
    name = "Landscape",
    widthDp = 640,
    heightDp = 360,
    showSystemUi = true
)
@Composable
private fun PathoriaAppLandscapePreview() {
    PathoriaTheme {
        PathoriaApp()
    }
}

@Preview(
    name = "Long strings",
    widthDp = 360,
    heightDp = 640,
    locale = "en-rGB",
    showSystemUi = true
)
@Composable
private fun PathoriaAppAdaptivePreview() {
    val configuration = Configuration(LocalConfiguration.current).apply {
        setLocale(java.util.Locale.UK)
    }
    val context = LocalContext.current.createConfigurationContext(configuration)
    CompositionLocalProvider(
        LocalContext provides context,
        LocalConfiguration provides configuration
    ) {
        PathoriaTheme {
            PathoriaApp()
        }
    }
}