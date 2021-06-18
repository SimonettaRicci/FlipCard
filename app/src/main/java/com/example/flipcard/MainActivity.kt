package com.example.flipcard

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flipcard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var front_anim: AnimatorSet
    lateinit var back_anim: AnimatorSet
    var isFront = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //settare le animazioni
        front_anim = AnimatorInflater.loadAnimator(applicationContext, R.animator.front_anim) as AnimatorSet
        back_anim = AnimatorInflater.loadAnimator(applicationContext, R.animator.back_anim) as AnimatorSet

        //settare gli event listener
        binding.btnFlip.setOnClickListener(){
            if(isFront) {
                front_anim.setTarget(binding.tvFront)
                back_anim.setTarget(binding.tvBack)
                front_anim.start()
                back_anim.start()
                isFront = false
            }else{
                front_anim.setTarget(binding.tvBack)
                back_anim.setTarget(binding.tvFront)
                back_anim.start()
                front_anim.start()
                isFront = true
            }
        }


    }
}