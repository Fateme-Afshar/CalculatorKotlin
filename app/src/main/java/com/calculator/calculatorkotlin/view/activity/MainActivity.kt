package com.calculator.calculatorkotlin.view.activity

import androidx.fragment.app.Fragment
import com.calculator.calculatorkotlin.view.fragment.AddDirectionFragment
import com.calculator.calculatorkotlin.view.fragment.BaseFragment
import com.calculator.calculatorkotlin.view.fragment.HomeFragment

class MainActivity : SingleFragmentActivity() {
    override fun getFragment(): Fragment {
        return HomeFragment()
    }
}