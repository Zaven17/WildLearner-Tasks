package com.myapp.wildlearnertasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.myapp.wildlearnertasks.databinding.ActivityDisplayLongArrayBinding
import com.myapp.wildlearnertasks.databinding.ActivityNlengthArrayBinding

class DisplayLongArrayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisplayLongArrayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_display_long_array)

        val intent = intent
        binding.longArrayTxt.text = intent.extras?.getString("arrayToDisplay") ?: "no string was passed"
    }
}