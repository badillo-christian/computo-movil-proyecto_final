package com.mamon.bankingapp.utils

import android.widget.EditText
import androidx.fragment.app.Fragment
import com.mamon.bankingapp.R
import com.mamon.bankingapp.data.Transaction
import com.mamon.bankingapp.data.User
import java.util.*

val daysList = listOf("LUN", "MAR", "MIE", "JUE", "VIE", "SAB","DOM")


// fake date
fun transactionsData(): List<Transaction> {
    return listOf(
        Transaction("", "SubWay", Calendar.getInstance().time, R.drawable.ic_train,50.15f),
        Transaction("", "Restaurant", Calendar.getInstance().time, R.drawable.ic_resturant,15.01f),
        Transaction("", "Coffee", Calendar.getInstance().time, R.drawable.ic_coffee,14.00f),
        Transaction("", "Shopping", Calendar.getInstance().time, R.drawable.ic_shop,9.50f),
        Transaction("", "FOOD", Calendar.getInstance().time, R.drawable.ic_fast_food,23.00f),
        Transaction("", "SubWay", Calendar.getInstance().time, R.drawable.ic_train,50.99f),
        Transaction("", "Restaurant", Calendar.getInstance().time, R.drawable.ic_resturant,150f),
        Transaction("", "Coffee", Calendar.getInstance().time, R.drawable.ic_coffee,20.5f),
        Transaction("", "Shopping", Calendar.getInstance().time, R.drawable.ic_shop,80.15f),
        Transaction("", "FOOD", Calendar.getInstance().time, R.drawable.ic_fast_food,17.00f)
    ).shuffled()
}


fun EditText.showErrorIfEmpty(): String {
    var v = text.trim().toString()
    if (v.isEmpty()){
        error = "required"
        requestFocus()
        v = ""
    }
    return v
}


object Constant {
    const val KEY_USER = "user"
    const val KEY_IS_LOGIN = "isLogin"
    const val KEY_EMAIL = "email"
    const val KEY_PASSWORD = "password"
}


fun Fragment.getUserData() = try { arguments?.get(Constant.KEY_USER) as User } catch (ex: Exception){ null }



