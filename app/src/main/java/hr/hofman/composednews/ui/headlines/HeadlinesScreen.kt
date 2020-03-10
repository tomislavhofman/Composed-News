package hr.hofman.composednews.ui.headlines

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column

@Composable
fun HeadlinesScreen() {
    Column {
        VerticalScroller(modifier = LayoutFlexible(1f)) {
            Column {
                Text(text = "Headlines")
            }
        }
    }
}