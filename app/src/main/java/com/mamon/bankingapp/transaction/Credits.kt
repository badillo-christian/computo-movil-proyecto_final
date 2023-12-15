package com.mamon.bankingapp.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mamon.bankingapp.databinding.CreditsBinding
import com.mamon.bankingapp.databinding.TransfersBinding
import com.mamon.bankingapp.screens.home.TransactionsAdapter
import com.mamon.bankingapp.utils.back

class Credits : Fragment() {

    private lateinit var binding: CreditsBinding
    private val transactionsAdapter = TransactionsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CreditsBinding.inflate(inflater, container, false)


        setViews()

        return binding.root
    }

    private fun setViews() {
        setButtons()
        setTabs()

    }

    private fun setTabs(){
        binding.apply {

            val tabTitles = arrayOf("HIPOTECA", "NOMINA")
            tabTitles.forEachIndexed { index, title ->
                tabLayoutTransferencias.addTab(tabLayoutTransferencias.newTab().setText(title))

                tabLayoutTransferencias.getTabAt(index)?.view?.setOnClickListener {
                    when (index) {
                        0 -> { showSaldos() }
                        1 -> { showEC() }
                    }
                }

            }

        }
    }

    private fun showSaldos(){
        binding.tituloTab.text = "Crédito Hipotecario"
        binding.containerSaldos.visibility = View.VISIBLE
        binding.containerEC.visibility = View.GONE
    }

    private fun showEC(){
        binding.tituloTab.text = "Crédito de Nómina"
        binding.containerSaldos.visibility = View.GONE
        binding.containerEC.visibility = View.VISIBLE

    }


    private fun setButtons() {
        binding.apply {
            btnBack.setOnClickListener { back() }
        }
    }


}