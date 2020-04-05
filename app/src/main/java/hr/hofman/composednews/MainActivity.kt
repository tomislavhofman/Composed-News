package hr.hofman.composednews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.navigation.NavController
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import hr.hofman.composednews.base.setupWithNavController
import hr.hofman.composednews.databinding.ActivityHomeBinding
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Any>
    private lateinit var binding: ActivityHomeBinding
    private var currentNavController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.ComposedNewsTheme_NoActionBar_Fullscreen)
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if(savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        binding.bottomNavigation.setupWithNavController(
            listOf(
                R.navigation.home_nav_graph,
                R.navigation.headlines_nav_graph,
                R.navigation.saved_nav_graph
            ),
            supportFragmentManager,
            R.id.home_nav_container
        ).observe(this) { navController ->
            currentNavController = navController
        }
    }

    override fun onSupportNavigateUp(): Boolean =
        currentNavController?.navigateUp() ?: super.onSupportNavigateUp()

    override fun androidInjector(): AndroidInjector<Any> = fragmentInjector
}