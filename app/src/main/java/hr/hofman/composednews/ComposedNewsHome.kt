package hr.hofman.composednews

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.animation.Crossfade
import androidx.ui.core.Alignment.BottomCenter
import androidx.ui.foundation.Icon
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutHeight
import androidx.ui.material.BottomNavigation
import androidx.ui.material.BottomNavigationItem
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import hr.hofman.composednews.Screen.Following
import hr.hofman.composednews.Screen.Headlines
import hr.hofman.composednews.Screen.Home
import hr.hofman.composednews.ui.following.FollowingScreen
import hr.hofman.composednews.ui.headlines.HeadlinesScreen
import hr.hofman.composednews.ui.home.HomeScreen

@Composable
fun ComposedNewsApp() {
    MaterialTheme(
        colors = lightThemeColors
    ) {
        Container {
            AppContent()
        }
        Container(alignment = BottomCenter, expanded = true) {
            BottomBar()
        }
    }
}

@Composable
private fun AppContent() {
    Crossfade(ComposedNewsStatus.currentScreen) { screen ->
        Surface(color = (MaterialTheme.colors()).background) {
            when (screen) {
                is Home -> HomeScreen()
                is Headlines -> HeadlinesScreen()
                is Following -> FollowingScreen()
            }
        }
    }
}

@Composable
private fun BottomBar() {

    var selectedItem: Screen by state { Home }
    val items = listOf(Home, Headlines, Following)

    Surface(elevation = 2.dp) {
        Container(modifier = LayoutHeight(56.dp), expanded = true) {
            BottomNavigation {
                items.forEachIndexed { index, screen ->
                    BottomNavigationItem(icon = {
                        when (screen) {
                            Home -> Icon(icon = vectorResource(id = R.drawable.ic_outline_account_circle_24))
                            Headlines -> Icon(icon = vectorResource(id = R.drawable.ic_baseline_language_24))
                            Following -> Icon(icon = vectorResource(id = R.drawable.ic_baseline_star_border_24))
                        }
                    }, selected = selectedItem == screen, onSelected = {
                        selectedItem = screen
                        navigateTo(screen)
                    })
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        ComposedNewsApp()
    }
}