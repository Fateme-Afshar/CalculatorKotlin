package com.calculator.calculatorkotlin.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.calculator.calculatorkotlin.R

abstract class SingleFragmentActivity : AppCompatActivity() {

    abstract fun getFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment: Fragment? = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)

        if (fragment == null)
            supportFragmentManager.beginTransaction().add(R.id.nav_host_fragment, getFragment())
                .commit()
    }
}