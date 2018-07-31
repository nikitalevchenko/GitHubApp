package com.example.nikitalevcenko.githubapp.modules.main.ui

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import androidx.navigation.fragment.NavHostFragment
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.nikitalevcenko.githubapp.R
import com.example.nikitalevcenko.githubapp.modules.auth.ui.AuthActivity
import com.example.nikitalevcenko.githubapp.modules.main.presentation.MainPresenter
import com.example.nikitalevcenko.githubapp.modules.main.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        presenter.onOnNavigationItemSelected(item.itemId)
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    // MainView
    override fun navigateToAuth() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

    override fun popBack() {
        NavHostFragment.findNavController(navHostFragment).popBackStack()
        bottomNavigationView.menu.getItem(0).isChecked = true
    }

    override fun navigateToSettings() {
        NavHostFragment.findNavController(navHostFragment).navigate(R.id.action_reportFragment_to_settingsFragment)
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }

    override fun exitApp() {
        finish()
    }
}
