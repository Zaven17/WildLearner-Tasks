package com.myapp.wildlearnertasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.myapp.wildlearnertasks.databinding.ActivityPalindromeBinding

class PalindromeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPalindromeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_palindrome)
        onCheckClick()

    }

    //Function to check if a given string is a palindrome,
    private fun isPalindrome(inputStr: String): Boolean {
        return if (inputStr.isNotEmpty()) {
            val sBuilder = StringBuilder(inputStr)
            val reverseStr = sBuilder.reverse().toString()

            inputStr.equals(reverseStr, ignoreCase = true)
        } else {
            false
        }
    }


    private fun onCheckClick() {
        binding.checkPalindromeBtn.setOnClickListener {
            //here if the user clicks the check button, I save the input from the edittext
            //and then pass it to isPalindrome function, if the outcome is true, user gets a toast
            //message that their input is a palindrome, if not, they get a toast that input is not
            //a palindrome
            val userInput = binding.userEntry.text.toString()

            if (isPalindrome(userInput)) {
                Toast
                    .makeText(
                        this,
                        "$userInput is a Palindrome String",
                        Toast.LENGTH_LONG
                    )
                    .show()
            } else {
                Toast
                    .makeText(
                        this,
                        "$userInput is not a Palindrome String",
                        Toast.LENGTH_LONG
                    )
                    .show()

            }
        }
    }

}