package kr.ac.kumoh.s20201414.w0501carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20201414.w0501carddealer.databinding.ActivityMainBinding
import kotlin.math.log
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        //binding.card1.setImageResource(R.drawable.c_10_of_diamonds)

        /*
        binding.btnDeal.setOnClickListener{
            val res = resources.getIdentifier(getCardName(Random.nextInt(52)), "drawable", packageName);
            binding.card1.setImageResource(res)
            binding.card2.setImageResource(res)
            binding.card3.setImageResource(res)
            binding.card4.setImageResource(res)
            binding.card5.setImageResource(res)
        }
         */
        binding.btnDeal.setOnClickListener{
            val c = IntArray(5)
            val res = IntArray(5)

            for(i in res.indices){
                c[i] = Random.nextInt(52)
                res[i] = resources.getIdentifier(getCardName(c[i]), "drawable", packageName)
            }
            binding.card1.setImageResource(res[0])
            binding.card2.setImageResource(res[1])
            binding.card3.setImageResource(res[2])
            binding.card4.setImageResource(res[3])
            binding.card5.setImageResource(res[4])
        }


    }

    private fun getCardName(c: Int) : String{

        val shape = when(c/13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }
        Log.i("getCardName", shape)
        val number = when (c % 13){
            0 -> "ace"
            in 1..9 -> (c % 13 + 1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }
        return "c_${number}_of_${shape}"
    }
}