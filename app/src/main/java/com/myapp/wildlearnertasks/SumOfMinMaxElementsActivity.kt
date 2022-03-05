package com.myapp.wildlearnertasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.myapp.wildlearnertasks.databinding.ActivityMainBinding
import com.myapp.wildlearnertasks.databinding.ActivitySumOfMinMaxElementsBinding

class SumOfMinMaxElementsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySumOfMinMaxElementsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sum_of_min_max_elements)
        onEnterClick()
    }

    private fun onEnterClick() {
        binding.enterArrayBtn.setOnClickListener {
            //here we handle the case of NumberFormatException if the user inputs a non integer
            try {
                binding.answerTxt.text = findSum(binding.userEntry.text.toString()).toString()

            } catch (e: java.lang.NumberFormatException) {
                Toast
                    .makeText(
                        this,
                        "your input contains a non-integer, please replace it with an integer",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
        }
    }

    private fun findSum(userInput: String): Int {
        //splitting the userInput with space as a delimiter, then mapping each element into a list
        val userInputList: List<Int> = userInput.split(" ").map { it.toInt() }
        //then using kotlin toTypedArray function in order to create an array with the numbers given
        //by the user
        val userInputArray: Array<Int> = userInputList.toTypedArray()
        //then we use kotlin sort function to sort the array
        userInputArray.sort()

        //and here simply picking the first and last elements of the array and adding them together
        return userInputArray.first() + userInputArray.last()

    }


}