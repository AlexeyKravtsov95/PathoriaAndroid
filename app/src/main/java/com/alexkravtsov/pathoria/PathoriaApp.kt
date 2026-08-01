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
import java.util.Locale

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
    name = "Long strings",
    widthDp = 360,
    heightDp = 640,
    showSystemUi = true
)
@Composable
private fun PathoriaAppAdaptivePreview() {
    val configuration = Configuration(LocalConfiguration.current).apply {
        setLocale(Locale.UK)
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

@Preview(
    name = "Compact",
    widthDp = 360,
    heightDp = 640,
    showSystemUi = true
)
@Preview(
    name = "Tall",
    widthDp = 412,
    heightDp = 915,
    showSystemUi = true
)
@Preview(
    name = "Large font",
    widthDp = 360,
    heightDp = 640,
    fontScale = 2.0f,
    showSystemUi = true
)
@Preview(
    name = "Landscape",
    widthDp = 640,
    heightDp = 360,
    showSystemUi = true
)
@Preview(
    name = "Dark",
    widthDp = 360,
    heightDp = 640,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Composable
private fun PathoriaAppPreview() {
    PathoriaTheme {
        PathoriaApp()
    }
}