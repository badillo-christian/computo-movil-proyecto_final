package com.mamon.bankingapp.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mamon.bankingapp.R
import com.mamon.bankingapp.data.Transaction
import com.mamon.bankingapp.databinding.CardSettingsBinding
import com.mamon.bankingapp.databinding.ResetPinBinding
import com.mamon.bankingapp.databinding.TransactionsBinding
import com.mamon.bankingapp.screens.card_settings.CardSettingsViewModel
import com.mamon.bankingapp.screens.home.Home
import com.mamon.bankingapp.screens.home.TransactionsAdapter
import com.mamon.bankingapp.utils.*

class Transactions : Fragment() {

    private lateinit var binding: TransactionsBinding
    private val transactionsAdapter = TransactionsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TransactionsBinding.inflate(inflater, container, false)


        setViews()

        return binding.root
    }

    private fun setViews() {
        setTransactionAdapter()
        setButtons()
        setTabs()

    }

    private fun setTabs(){
        binding.apply {

            val tabTitles = arrayOf("MOVIMIENTOS", "SALDOS", "ESTADOS DE CUENTA")
            tabTitles.forEachIndexed { index, title ->
                tabLayoutMovimientos.addTab(tabLayoutMovimientos.newTab().setText(title))

                tabLayoutMovimientos.getTabAt(index)?.view?.setOnClickListener {
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
        binding.tituloTab.text = "Movimientos"
        binding.containerMovimientos.visibility = View.VISIBLE
        binding.containerSaldos.visibility = View.GONE
        binding.containerSaldos.visibility = View.GONE
    }

    private fun showSaldos(){
        binding.tituloTab.text = "Saldos"
        binding.containerMovimientos.visibility = View.GONE
        binding.containerSaldos.visibility = View.VISIBLE
        binding.containerEC.visibility = View.GONE
    }

    private fun showEC(){
        binding.tituloTab.text = "Estados de Cuenta"
        binding.containerMovimientos.visibility = View.GONE
        binding.containerSaldos.visibility = View.GONE
        binding.containerEC.visibility = View.VISIBLE

    }


    private fun setButtons() {
        binding.apply {
            btnBack.setOnClickListener { back() }


        }
    }

    private fun setTransactionAdapter(){
        transactionsAdapter.submitList(transactionsData())
        transactionsAdapter.listener = object: TransactionsAdapter.TransactionListener{
            override fun onClick(data: Transaction) {
                showMessage(data.name)
            }
        }

        binding.rvTransactions2.adapter = transactionsAdapter

    }
}

