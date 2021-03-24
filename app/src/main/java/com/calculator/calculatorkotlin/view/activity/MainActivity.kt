package com.calculator.calculatorkotlin.view.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.calculator.calculatorkotlin.view.fragment.AddDirectionFragment
import com.calculator.calculatorkotlin.view.fragment.BaseFragment
import com.calculator.calculatorkotlin.view.fragment.HomeFragment
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class MainActivity : SingleFragmentActivity() {
    override fun getFragment(): Fragment {
        return HomeFragment()
    }
}