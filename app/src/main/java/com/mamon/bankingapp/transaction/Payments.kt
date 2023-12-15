package com.mamon.bankingapp.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mamon.bankingapp.databinding.PaymentsBinding
import com.mamon.bankingapp.databinding.TransfersBinding
import com.mamon.bankingapp.screens.home.TransactionsAdapter
import com.mamon.bankingapp.utils.back

class Payments : Fragment() {
    private lateinit var binding: PaymentsBinding
    private val transactionsAdapter = TransactionsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PaymentsBinding.inflate(inflater, container, false)


        setViews()

        return binding.root
    }

    private fun setViews() {
        setButtons()
        setTabs()

    }

    private fun setTabs(){
        binding.apply {

            val tabTitles = arrayOf("NUEVO SERVICIO", "CFE", "SIAPA")
            tabTitles.forEachIndexed { index, title ->
                tabLayoutPayments.addTab(tabLayoutPayments.newTab().setText(title))

                tabLayoutPayments.getTabAt(index)?.view?.setOnClickListener {
                    when (index) {
                        0 -> { showMovimientos() }
                        1 -> { showSaldos() }
                        2 -> { showEC() }
                    }
                }

            }

        }
    }

    private fun showMovimientos(){
        binding.tituloTab.text = "Nuevo Servicio"
        binding.containerMovimientos.visibility = View.VISIBLE
        binding.containerSaldos.visibility = View.GONE
        binding.containerSaldos.visibility = View.GONE
    }

    private fun showSaldos(){
        binding.tituloTab.text = "CFE"
        binding.containerMovimientos.visibility = View.GONE
        binding.containerSaldos.visibility = View.VISIBLE
        binding.containerEC.visibility = View.GONE
    }

    private fun showEC(){
        binding.tituloTab.text = "SIAPA"
        binding.containerMovimientos.visibility = View.GONE
        binding.containerSaldos.visibility = View.GONE
        binding.containerEC.visibility = View.VISIBLE

    }


    private fun setButtons() {
        binding.apply {
            btnBack.setOnClickListener { back() }
        }
    }


}