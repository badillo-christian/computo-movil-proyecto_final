package com.mamon.bankingapp.transaction

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mamon.bankingapp.data.Transaction
import com.mamon.bankingapp.databinding.ShoppingBinding
import com.mamon.bankingapp.databinding.TransactionsBinding
import com.mamon.bankingapp.screens.home.TransactionsAdapter
import com.mamon.bankingapp.utils.back
import com.mamon.bankingapp.utils.showMessage
import com.mamon.bankingapp.utils.transactionsData

class Shopping() : Fragment() {

    private lateinit var binding: ShoppingBinding
    private val transactionsAdapter = TransactionsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ShoppingBinding.inflate(inflater, container, false)


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

            val tabTitles = arrayOf("Compras")
            tabTitles.forEachIndexed { index, title ->
                tabLayoutMovimientos.addTab(tabLayoutMovimientos.newTab().setText(title))

                tabLayoutMovimientos.getTabAt(index)?.view?.setOnClickListener {
                    when (index) {
                        0 -> { showMovimientos() }
                    }
                }

            }

        }
    }

    private fun showMovimientos(){
        binding.tituloTab.text = "Listado de Compras"
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