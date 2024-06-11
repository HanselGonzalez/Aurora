package com.sign.aurora.ui.Rueda

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.sign.aurora.R
import com.sign.aurora.databinding.FragmentRuedaBinding

class RuedaFragment : Fragment() {

    private var _binding: FragmentRuedaBinding? = null
    private val binding get() = _binding!!
    private var moveButton = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRuedaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        initListeners()
    }

    private fun initListeners() {
        buttonArrow()
    }

    private fun buttonArrow() {

        binding.ivArrowLeft.setOnClickListener {
            disableButtonArrow()
            Log.i("dimelow", "segundo $moveButton")


            val animArrowLeft = ObjectAnimator.ofFloat(
                binding.ivRuedaBehind,
                "rotation",
                binding.ivRuedaBehind.rotation - 9
            )
            animArrowLeft.duration = 250

            animArrowLeft.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {

                }

                override fun onAnimationEnd(animation: Animator) {
                    enableButtonArrow()
                    Log.i("dimelow", "tercero $moveButton")

                }

                override fun onAnimationCancel(animation: Animator) {
                }

                override fun onAnimationRepeat(animation: Animator) {
                }

            })

            animArrowLeft.start()

        }



        binding.ivArrowRigh.setOnClickListener {

            disableButtonArrow()

            val animArrowRight = ObjectAnimator.ofFloat(
                binding.ivRuedaBehind,
                "rotation",
                binding.ivRuedaBehind.rotation + 9
            )
            animArrowRight.duration = 250

            animArrowRight.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                }

                override fun onAnimationEnd(animation: Animator) {
                    enableButtonArrow()
                }

                override fun onAnimationCancel(animation: Animator) {
                }

                override fun onAnimationRepeat(animation: Animator) {
                }
            })

            animArrowRight.start()

        }
    }

    private fun disableButtonArrow() {
        binding.ivArrowLeft.isEnabled = false
        binding.ivArrowRigh.isEnabled = false
    }

    private fun enableButtonArrow() {
        binding.ivArrowLeft.isEnabled = true
        binding.ivArrowRigh.isEnabled = true
    }





override fun onDestroyView() {
    super.onDestroyView()
}

override fun onDestroy() {
    super.onDestroy()
}

}

