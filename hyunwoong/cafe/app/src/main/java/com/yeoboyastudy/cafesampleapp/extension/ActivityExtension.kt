package com.yeoboyastudy.cafesampleapp.extension

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager


fun FragmentActivity.addFragment(
    @IdRes containerId: Int,
    fragment: Fragment?,
    addBackStack: Boolean = false
) {
    requireNotNull(fragment)

    val transaction = supportFragmentManager.beginTransaction()
    transaction.add(containerId, fragment).apply {
        if (addBackStack) addToBackStack(null)
    }
    transaction.commitAllowingStateLoss()
}

fun Fragment.addFragment(
    @IdRes containerId: Int,
    fragment: Fragment?,
    addBackStack: Boolean = false
) {
    requireNotNull(fragment)

    val transaction = childFragmentManager.beginTransaction()
    transaction.add(containerId, fragment).apply {
        if (addBackStack) addToBackStack(null)
    }
    transaction.commitAllowingStateLoss()
}

fun Fragment.removeFragment(
    @IdRes containerId: Int,
    fragment: Fragment?,
    fragmentManager: FragmentManager = childFragmentManager,
    popBackStack : Boolean = true
) {
    if (fragmentManager.findFragmentById(containerId) == fragment) {
        requireNotNull(fragment)
        val transaction = fragmentManager.beginTransaction()
        transaction.remove(fragment).commitAllowingStateLoss()
        if(popBackStack) fragmentManager.popBackStack()
    }
}