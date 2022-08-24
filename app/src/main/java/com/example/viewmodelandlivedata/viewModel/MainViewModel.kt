package com.example.viewmodelandlivedata.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodelandlivedata.LOG_TAG
import com.example.viewmodelandlivedata.helper.MainHelper

class MainViewModel:ViewModel() {
    private val _message = MutableLiveData<String>()
    private val _description = MutableLiveData<String>()
    private val _amount = MutableLiveData<Int>(1) //how many apples
    private val _money = MutableLiveData<Int>() //how much is apple
    private val _qty = MutableLiveData<Int>()
    private val _total = MutableLiveData<Int>()//total of apples


    private var apples: Int = 1
    private var deliveryfee: Int = 45


    val message: LiveData<String> = _message
    val description: LiveData<String> = _description
    val Qty: LiveData<Int> = _qty
    val total: LiveData<Int> = _total

    init {
        _money.value = MainHelper.getApplePrice()
        _description.value = MainHelper.getAppleDesc()
        _message.value = MainHelper.getMessageFee()
    }

    fun apples(amountType: Int){
        _amount.value = when(amountType){
            1 -> apples++
            2 -> apples--
            else -> 0
        }
        if(apples in 1..10) {
            if(apples  > 1){
                _qty.value = apples
                loadMessage()

            }
            else{
                _qty.value = apples
                loadMessage()
            }

        }
    }

    fun totalAmount(){
        if(apples < 10){
            _total.value = _money.value!! * _qty.value!! + deliveryfee
        }
        else{
            _total.value = _money.value!! * _qty.value!!
        }
    }

    fun loadMessage(){
        if(apples < 10){
            _message.value = MainHelper.getMessageFee()
        }
        else{
            _message.value = MainHelper.getMessageFree()
        }
    }
}