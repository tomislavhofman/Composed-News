package hr.hofman.composednews.ui.following

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column

@Composable
fun FollowingScreen() {
    Column {
        VerticalScroller(modifier = LayoutFlexible(1f)) {
            Column {
                Text(text = "Following")
            }
        }
    }
}