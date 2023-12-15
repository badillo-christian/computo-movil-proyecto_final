package com.mamon.bankingapp.screens.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mamon.bankingapp.R
import com.mamon.bankingapp.data.Transaction
import com.mamon.bankingapp.databinding.ProfileBinding
import com.mamon.bankingapp.screens.home.TransactionsAdapter
import com.mamon.bankingapp.utils.*

class Profile : Fragment() {

    private lateinit var viewModel: ProfileViewModel
    private val profileViewModel by activityViewModels<ProfileViewModel>()

    private lateinit var binding: ProfileBinding

    private val transactionsAdapter = TransactionsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = ProfileBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        setViews()

        return binding.root
    }

    private fun setViews() {
        setTransactionAdapter()
        binding.apply {
            profileVM = profileViewModel
            lifecycleOwner = this@Profile
        }
        setButtons()
    }

    private fun setButtons() {
        binding.apply {
            btnInbox.setOnClickListener { navigateProfileToTransactions() }
            btnDocument.setOnClickListener {  navigateProfileToTransfers()}
            btnPayments.setOnClickListener { navigateProfileToPayments() }
            btnCardSettings.setOnClickListener { navigateProfileToCardSettings() }
            btnSettings.setOnClickListener { navigateProfileToShopping() }
            btnSecurity.setOnClickListener { navigateProfileToCredits() }
            btnNotification.setOnClickListener { showMessage("Cargando Maps") }
            btnHelpCenter.setOnClickListener { showMessage("Pantalla Ajustes Seguridad") }
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



    }
}


