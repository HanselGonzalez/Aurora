package com.sign.aurora.ui.Rueda

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.sign.aurora.R
import com.sign.aurora.databinding.FragmentRuedaBinding

class RuedaFragment : Fragment() {

    private var _binding: FragmentRuedaBinding? = null
    private val binding get() = _binding!!
    private lateinit var dialogInformation: Dialog

    //ADS
    private var adCount = 0
    private var interstitial: InterstitialAd? = null






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
        initDialogs()
        initAds()
        initListeners()
    }


    private fun initAds() {
        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(requireContext(), getString(R.string.ADMOB_ID_ADS), adRequest, object : InterstitialAdLoadCallback(){
            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                interstitial = interstitialAd
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                interstitial = null
            }

        })
    }


    private fun checkCount(){
        if(adCount == 14){
            showAds()
            adCount = 0
            initAds()
        }
    }

    private fun showAds(){
        interstitial?.show(requireActivity())
    }



    private fun initDialogs() {
        dialogInformation = Dialog(requireContext()).apply {
            setContentView(R.layout.dialog_information)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    private fun initListeners() {
        //AD
        interstitial?.fullScreenContentCallback = object : FullScreenContentCallback(){
            override fun onAdDismissedFullScreenContent() {
            }

            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
            }

            override fun onAdShowedFullScreenContent() {
                interstitial = null
            }

        }

        buttonDialog()
        buttonArrow()
    }

    private fun buttonDialog() {
        binding.ivInformation2.setOnClickListener {
            zoomAnimation(binding.ivInformation2)
        }
    }

    private fun buttonArrow() {

        binding.ivArrowLeft.setOnClickListener {
            disableButtonArrow()

            zoomAnimationArrow(binding.ivArrowLeft, binding.ivRuedaBehind)
            adCount+=1
            checkCount()

        }



        binding.ivArrowRigh.setOnClickListener {

            disableButtonArrow()
            zoomAnimationArrow(binding.ivArrowRigh, binding.ivRuedaBehind)
            adCount+=1
            checkCount()

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


    private fun zoomAnimation(view: View) {
        val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f)
        val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f)

        scaleX.duration = 300
        scaleY.duration = 300

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(scaleX, scaleY)
        animatorSet.start()


        animatorSet.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                openDialogInfo()
            }

            override fun onAnimationCancel(animation: Animator) {
            }

            override fun onAnimationRepeat(animation: Animator) {
            }

        })
    }

    private fun zoomAnimationArrow(viewButton: View, viewRueda: View) {
        var rotation: ObjectAnimator? = null
        var rotationButtonX: ObjectAnimator? = null
        var rotationButtonY: ObjectAnimator? = null

        when (viewButton) {
            binding.ivArrowLeft -> {
                rotation = ObjectAnimator.ofFloat(
                    viewRueda,
                    "rotation",
                    binding.ivRuedaBehind.rotation - 9
                )
                rotationButtonX = ObjectAnimator.ofFloat(viewButton, "scaleX", 1.0f, 1.1f, 1.0f)
                rotationButtonY = ObjectAnimator.ofFloat(viewButton, "scaleY", 1.0f, 1.1f, 1.0f)
            }

            binding.ivArrowRigh -> {
                rotation = ObjectAnimator.ofFloat(
                    viewRueda,
                    "rotation",
                    binding.ivRuedaBehind.rotation + 9
                )
                rotationButtonX = ObjectAnimator.ofFloat(viewButton, "scaleX", 1.0f, 1.1f, 1.0f)
                rotationButtonY = ObjectAnimator.ofFloat(viewButton, "scaleY", 1.0f, 1.1f, 1.0f)
            }
        }

        rotation?.duration = 250
        rotationButtonX?.duration = 250
        rotationButtonY?.duration = 250

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(rotationButtonX,rotationButtonY,rotation)
        animatorSet.start()

        animatorSet.addListener(object : Animator.AnimatorListener {
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

    }

    private fun openDialogInfo() {
        val backButtonInfo = dialogInformation.findViewById<ImageButton>(R.id.btnBackDialogInfo)
        backButtonInfo.setOnClickListener { dialogInformation.dismiss() }
        dialogInformation.show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}

