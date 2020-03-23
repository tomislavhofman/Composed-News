package hr.hofman.composednews

import android.app.Activity
import android.content.Context
import hr.hofman.composednews.base.AppNavigator
import javax.inject.Inject

open class ComposedNewsAppNavigator @Inject constructor(
    private val context: Context
) : AppNavigator {
    override fun startArticleInBrowser(url: String) {
        // TODO() start browser activity
    }
}

open class ComposedNewsAppActivityNavigator(private val activity: Activity) : ComposedNewsAppNavigator(activity)