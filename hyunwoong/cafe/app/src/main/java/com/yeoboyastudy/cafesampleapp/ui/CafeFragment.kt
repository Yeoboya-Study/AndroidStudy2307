package com.yeoboyastudy.cafesampleapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.yeoboyastudy.cafesampleapp.R
import com.yeoboyastudy.cafesampleapp.data.Americano
import com.yeoboyastudy.cafesampleapp.data.CoffeeOption
import com.yeoboyastudy.cafesampleapp.data.Latte
import com.yeoboyastudy.cafesampleapp.data.MenuData
import com.yeoboyastudy.cafesampleapp.data.Temperature
import com.yeoboyastudy.cafesampleapp.data.VanillaCreamFrappuccino
import com.yeoboyastudy.cafesampleapp.data.VanillaLatte
import com.yeoboyastudy.cafesampleapp.databinding.FragmentCafeBinding
import com.yeoboyastudy.cafesampleapp.extension.showToast
import com.yeoboyastudy.cafesampleapp.ui.MenuListFragment.Companion.MENU_LIST
import com.yeoboyastudy.cafesampleapp.ui.MenuOptionDialog.Companion.MENU
import com.yeoboyastudy.cafesampleapp.util.ListLiveData
import com.yeoboyastudy.cafesampleapp.util.asLiveData

class CafeFragment: Fragment() {

    private var _binding: FragmentCafeBinding? = null
    private val binding get() = _binding!!
    private var optionDialog: MenuOptionDialog? = null
    private var _menuList = ListLiveData<MenuData>()
    val menuListData = _menuList.asLiveData()


        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCafeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val value = arguments?.getString("woong") ?: ""
        requireContext().showToast(value)

        setOnClick()

        menuListData.observe(viewLifecycleOwner) {
            binding.menuList.text = it.size.toString()
        }
    }

    private fun addFragment(
        @IdRes containerId: Int,
        fragment: Fragment?,
        fragmentManager: FragmentManager = childFragmentManager,
        addBackStack: Boolean = false
    ) {
        requireNotNull(fragment)

        val transaction = fragmentManager.beginTransaction()
        transaction.add(containerId, fragment).apply {
            if(addBackStack) addToBackStack(null)
        }
        transaction.commitAllowingStateLoss()
    }

    private fun setOnClick() = with(binding) {
        americano.setOnClickListener {
            showOptionDialog(Americano().menuName, isAmericano = true)
        }

        cafeLatte.setOnClickListener {
            showOptionDialog(Latte().menuName)
        }

        vanillaLatte.setOnClickListener {
            showOptionDialog(VanillaLatte().menuName)
        }

        vanillaCreamFrappuccino.setOnClickListener {
            showOptionDialog(VanillaCreamFrappuccino().menuName)
        }

        grapeFruitAde.setOnClickListener {
            val grapeFruitAde = MenuData.Beverage(
                "grapeFruitAde",
                6000
            )
            addMenu(grapeFruitAde)
        }

        grapeFruitHoneyTea.setOnClickListener {
            val grapeFruitHoneyTea = MenuData.Beverage(
                "grapeFruitHoneyTea",
                5500
            )
            addMenu(grapeFruitHoneyTea)
        }

        menuButton.setOnClickListener {
            showMenuList()
        }
    }

    private fun showOptionDialog(menu: String, isAmericano: Boolean = false) = with(binding) {
        optionDialog = MenuOptionDialog(isAmericano).apply {
            arguments = bundleOf(MENU to menu)
        }

        optionContainer.isVisible = true
        addFragment(R.id.optionContainer, optionDialog, addBackStack = true)

        optionDialog?.dismissResult = {
            addMenu(it)
            childFragmentManager.popBackStack()
            optionDialog?.dismiss()
            optionDialog = null
        }
    }

    private fun showMenuList()  = with(binding) {
        val menuListFragment = MenuListFragment().apply {
            arguments = bundleOf(MENU_LIST to menuListData.value)
        }
        addFragment(R.id.menuListContainer, menuListFragment, addBackStack = true)
        menuListContainer.isVisible = true
    }

    private fun addMenu(menuData: MenuData) {
        _menuList.add(menuData)
        context?.showToast("${menuData.name} 추가 완료")
    }
}