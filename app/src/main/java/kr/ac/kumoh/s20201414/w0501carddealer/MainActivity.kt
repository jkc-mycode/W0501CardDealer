package kr.ac.kumoh.s20201414.w0501carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20201414.w0501carddealer.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.card1.setImageResource(R.drawable.c_10_of_diamonds)
        getCardName(32)
    }

    private fun getCardName(c: Int) : String{

        val shape = when(c/13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            else -> "error"
        }
        Log.i("getCardName", shape)
        return "c_4_of_spades"
    }
}