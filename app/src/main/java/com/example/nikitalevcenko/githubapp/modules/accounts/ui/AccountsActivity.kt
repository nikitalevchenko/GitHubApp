package com.example.nikitalevcenko.githubapp.modules.accounts.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.nikitalevcenko.githubapp.R
import kotlinx.android.synthetic.main.activity_accounts.*

class AccountsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accounts)
        setSupportActionBar(toolbar)
    }

}
