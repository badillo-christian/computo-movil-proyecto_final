package com.mamon.bankingapp.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mamon.bankingapp.data.Transaction
import com.mamon.bankingapp.databinding.TransactionsBinding
import com.mamon.bankingapp.databinding.TransfersBinding
import com.mamon.bankingapp.screens.home.TransactionsAdapter
import com.mamon.bankingapp.utils.back
import com.mamon.bankingapp.utils.showMessage
import com.mamon.bankingapp.utils.transactionsData

class Transfers : Fragment() {

    private lateinit var binding: TransfersBinding
    private val transactionsAdapter = TransactionsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TransfersBinding.inflate(inflater, container, false)


        setViews()

        return binding.root
    }

    private fun setViews() {
        setButtons()
        setTabs()

    }

    private fun setTabs(){
        binding.apply {

            val tabTitles = arrayOf("MISMO BANCO", "OTROS BANCOS", "TARJETAS DE CREDITO")
            tabTitles.forEachIndexed { index, title ->
                tabLayoutTransferencias.addTab(tabLayoutTransferencias.newTab().setText(title))

                tabLayoutTransferencias.getTabAt(index)?.view?.setOnClickListener {
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
        binding.tituloTab.text = "Transferencias Mismo Banco"
        binding.containerMovimientos.visibility = View.VISIBLE
        binding.containerSaldos.visibility = View.GONE
        binding.containerSaldos.visibility = View.GONE
    }

    private fun showSaldos(){
        binding.tituloTab.text = "Transferencias Otros Bancos"
        binding.containerMovimientos.visibility = View.GONE
        binding.containerSaldos.visibility = View.VISIBLE
        binding.containerEC.visibility = View.GONE
    }

    private fun showEC(){
        binding.tituloTab.text = "Transferencias Tarjetas de Crédito"
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