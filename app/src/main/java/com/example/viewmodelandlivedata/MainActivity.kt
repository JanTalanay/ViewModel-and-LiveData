package com.example.viewmodelandlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.viewmodelandlivedata.databinding.ActivityMainBinding
import com.example.viewmodelandlivedata.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(MyObserver())

        val viewModel by viewModels<MainViewModel>()


        viewModel.Qty.observe(this){
            binding.txtQty.text = "QTY: $it"
        }

        viewModel.description.observe(this){
            binding.txtDesc.text = "$it"
        }

        viewModel.message.observe(this){
            binding.txtfee.text = "$it"
        }


        binding.bttnpos.setOnClickListener{
            viewModel.apples(1)
        }
        binding.bttnneg.setOnClickListener{
            viewModel.apples(2)
        }

        binding.bttncheck.setOnClickListener(){
            viewModel.totalAmount()
            viewModel.total.observe(this){
                Snackbar.make(binding.root, "Your total amount is $it",Snackbar.LENGTH_LONG).show()
            }
        }
    }
}