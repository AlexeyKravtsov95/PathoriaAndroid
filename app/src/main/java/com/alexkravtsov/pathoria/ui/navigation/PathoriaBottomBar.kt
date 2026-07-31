package com.alexkravtsov.pathoria.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexkravtsov.pathoria.R
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaNavigationColors
import com.alexkravtsov.pathoria.core.designsystem.theme.PathoriaTheme

enum class PathoriaDestination(
    @StringRes val labelResId: Int,
    val symbol: String
) {
    JOURNEY(R.string.navigation_journey, "✦"),
    JOURNAL(R.string.navigation_journal, "▤"),
    PROFILE(R.string.navigation_profile, "●")
}

@Composable
fun PathoriaBottomBar(
    selectedDestination: PathoriaDestination,
    onDestinationSelected: (PathoriaDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = PathoriaNavigationColors.container,
        tonalElevation = 0.dp
    ) {
        PathoriaDestination.entries.forEach { destination ->
            NavigationBarItem(
                selected = destination == selectedDestination,
                onClick = {
                    onDestinationSelected(destination)
                },
                icon = {
                    Text(
                        text = destination.symbol,
                        modifier = Modifier.clearAndSetSemantics { },
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                label = {
                    Text(
                        text = stringResource(destination.labelResId),
                        style = MaterialTheme.typography.labelMedium
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = PathoriaNavigationColors.selectedIcon,
                    selectedTextColor = PathoriaNavigationColors.selectedText,
                    indicatorColor = PathoriaNavigationColors.selectedIndicator,
                    unselectedIconColor = PathoriaNavigationColors.unselectedIcon,
                    unselectedTextColor = PathoriaNavigationColors.unselectedText
                )
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 360
)
@Composable
private fun PathoriaBottomBarPreview() {
    PathoriaTheme {
        PathoriaBottomBar(
            selectedDestination = PathoriaDestination.JOURNAL,
            onDestinationSelected = { },
            modifier = Modifier.fillMaxWidth()
        )
    }
}