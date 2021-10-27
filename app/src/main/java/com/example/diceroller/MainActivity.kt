package com.example.diceroller

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {

            rollDice()
        }
    }

     private fun rollDice() {
        // here we created object dice with possibility of 6 numbers
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        val text = "${diceRoll + diceRoll2}"
        val duration = Toast.LENGTH_SHORT

         var sound1= MediaPlayer.create(applicationContext,R.raw.dice)
         sound1?.start()
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()

//        when (diceRoll) {
//            1 -> diceImage.setImageResource(R.drawable.dice_1)
//            2 -> diceImage.setImageResource(R.drawable.dice_2)
//            3 -> diceImage.setImageResource(R.drawable.dice_3)
//            4 -> diceImage.setImageResource(R.drawable.dice_4)
//            5 -> diceImage.setImageResource(R.drawable.dice_5)
//            6 -> diceImage.setImageResource(R.drawable.dice_6)
//        }
        val drawableResource1 = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource1)

        diceImage.setImageResource(drawableResource2)
    }

}


class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}