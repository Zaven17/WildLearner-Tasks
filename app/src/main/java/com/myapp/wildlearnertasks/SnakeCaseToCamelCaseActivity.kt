package com.myapp.wildlearnertasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.myapp.wildlearnertasks.databinding.ActivityNlengthArrayBinding
import com.myapp.wildlearnertasks.databinding.ActivitySnakeCaseToCamelCaseBinding
import java.util.*

class SnakeCaseToCamelCaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySnakeCaseToCamelCaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_snake_case_to_camel_case)
        onEnterClick()
    }

    private fun onEnterClick() {
        binding.enterStringBtn.setOnClickListener {
            binding.answerTxt.text = binding.userEntry.text.toString().snakeToCamelCase()
        }
    }


    private fun String.snakeToCamelCase(): String {
        val snakeRegex = "_[a-zA-Z]".toRegex()
        return snakeRegex.replace(this) { matchRes ->
            matchRes.value.replace("_", "")
                .uppercase(Locale.getDefault())

        }.capitalize()
    }
}