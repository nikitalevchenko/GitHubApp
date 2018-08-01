package com.example.nikitalevcenko.githubapp.modules.main.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.nikitalevcenko.githubapp.R
import com.example.nikitalevcenko.githubapp.modules.accounts.ui.AccountsActivity
import com.example.nikitalevcenko.githubapp.modules.auth.ui.AuthActivity
import com.example.nikitalevcenko.githubapp.modules.main.presentation.MainPresenter
import com.example.nikitalevcenko.githubapp.modules.main.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    // MainView
    override fun navigateToAuth() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

    override fun navigateToSettings() {
        startActivity(Intent(this, AccountsActivity::class.java))
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                presenter.onSettingsClick()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
