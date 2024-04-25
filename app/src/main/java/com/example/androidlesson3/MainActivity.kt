package com.example.androidlesson3

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidlesson3.databinding.ActivityMainBinding
import kotlin.random.Random


fun randomRange(from: Int? = null, until: Int? = null): Int {
    return from?.let { start ->
        until?.let { end ->
            Random.nextInt(start, end)
        }
    } ?:0
}




class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
        var randomnumber: Int? = 0

        var live: Int = 5

        binding.LifetextView.text = "Live: ${live.toString()}"

        binding.RandomButton.setOnClickListener {

            val choose =binding.radioGroup.checkedRadioButtonId

            when(choose){

                R.id.radioButton ->{

                    randomnumber = randomRange(1, 99)

                    Log.e("random",randomnumber.toString())
                }

                R.id.radioButton2 ->{

                    randomnumber = randomRange(101, 199)

                    Log.e("random",randomnumber.toString())
                }

                R.id.radioButton3 ->{

                    randomnumber = randomRange(201, 299)

                    Log.e("random",randomnumber.toString())
                }
            }


        }


        binding.Checkbutton.setOnClickListener {

            val editTextValue = binding.editTextText.text.toString()

            if (editTextValue.isNotBlank()) {
                binding.LifetextView.text = "Live: ${live--.toString()}"

                if (live > 0) {
                    if (editTextValue.toInt() < randomnumber!!.toInt()) {
                        binding.InfotextView.text ="${binding.editTextText.text.toString().toInt()} < randomnumber"
                    }
                    if (editTextValue.toInt() > randomnumber!!.toInt()) {
                        binding.InfotextView.text = "${binding.editTextText.text.toString().toInt()} > randomnumber"


                    }
                    if (editTextValue.toInt() == randomnumber!!.toInt()) {
                        binding.InfotextView.text = "${binding.editTextText.text.toString().toInt()} = randomnumber"
                    }
                }
                if (live <= 0) {

                    binding.LifetextView.text = "Live: ${live.toString()}"
                    binding.InfotextView.text = "Random number: ${randomnumber}"
                    live = 5
                }

            } else {

                binding.InfotextView.text = "Generate random"
            }
        }
    }
}