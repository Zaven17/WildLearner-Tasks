package com.myapp.wildlearnertasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.myapp.wildlearnertasks.databinding.ActivityNlengthArrayBinding
import java.lang.StringBuilder
import java.util.*

class NLengthArrayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNlengthArrayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_nlength_array)
        onEnterClick()
    }

    private fun onEnterClick() {
        binding.enterNumberBtn.setOnClickListener {
            //here I check if the input is a number and if it is not I toast the user about it
            try {
                val userInput = binding.userEntry.text.toString()
                //here i check if the number will fir on the screen
                if (userInput.toInt() > 47) {
                    Toast.makeText(
                            this,
                            "the array this size does not fit on the screen",
                            Toast.LENGTH_SHORT).show()
                    //here I check if the system can handle the given number, if not Toast the user
                    try{
                        //and here we go to another activity to display the number
                        startActivity(Intent(this, DisplayLongArrayActivity::class.java)
                            .putExtra("arrayToDisplay", createAndFormatArray(userInput)))
                    }
                    catch (e: java.lang.RuntimeException){
                        Toast.makeText(
                                this,
                                "your input was too large and it cause system failure",
                                Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    //if the number does fit on the screen it will be displayed here
                    binding.answerTxt.text = createAndFormatArray(userInput)
                }

            } catch (e: java.lang.NumberFormatException) {
                Toast
                    .makeText(
                        this,
                        "your input is not an integer, please replace it with an integer",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
        }
    }

    private fun createAndFormatArray(userInput: String): String {
        val n = userInput.toInt()
        var resultArray = IntArray(n)

        //this will fill the array with numbers from 0 to n because each number is unique
        for ((i, item) in resultArray.withIndex()) {
            resultArray[i] = i
        }
        //this will return a beautifully formatted string with the array

        return resultArray.contentToString()
    }

}