package com.myapp.wildlearnertasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.myapp.wildlearnertasks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        onPalindromeBtnClick()
        onSumOfMinMaxBtnClick()
        onNLengthArrayBtnClick()
        onSnakeCaseToCamelCaseBtnClick()
    }
    private fun onPalindromeBtnClick(){
        binding.palindromeTaskBtn.setOnClickListener {
            startActivity(Intent(this, PalindromeActivity::class.java))
        }
    }
    private fun onSumOfMinMaxBtnClick(){
        binding.minMaxSumBtn.setOnClickListener {
            startActivity(Intent(this,SumOfMinMaxElementsActivity::class.java))
        }
    }
    private fun onNLengthArrayBtnClick(){
        binding.nLengthBtn.setOnClickListener {
            startActivity(Intent(this,NLengthArrayActivity::class.java))
        }
    }
    private fun onSnakeCaseToCamelCaseBtnClick(){
        binding.snakeToCamelBtn.setOnClickListener {
            startActivity(Intent(this,SnakeCaseToCamelCaseActivity::class.java))
        }
    }
}