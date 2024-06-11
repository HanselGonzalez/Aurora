package com.sign.aurora.ui.Principal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import com.sign.aurora.R
import com.sign.aurora.databinding.FragmentPrincipalBinding

class PrincipalFragment : Fragment() {


    private var _binding: FragmentPrincipalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPrincipalBinding.inflate(layoutInflater, container, false)
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
        var itemSelected = R.array.spHipertension


        //Spinner Patologia

        val spPatItems = resources.getStringArray(R.array.spPatologia)
        val spPatAdapter = ArrayAdapter(
            requireContext(),
            R.layout.spinner_selected_item,
            spPatItems
        )
        spPatAdapter.setDropDownViewResource(R.layout.spinner_selected_item)

        binding.spPatologia.adapter = spPatAdapter


        binding.spPatologia.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                when (position) {
                    0 -> itemSelected = R.array.spHipertension
                    1 -> itemSelected = R.array.spObesidad
                    2 -> itemSelected = R.array.spDiabetes
                    3 -> itemSelected = R.array.spTabaquismo
                    4 -> itemSelected = R.array.spDolorCabeza
                    5 -> itemSelected = R.array.spMedicamentos
                    6 -> itemSelected = R.array.spVih
                    7 -> itemSelected = R.array.spTransmisionSexual
                    8 -> itemSelected = R.array.spEpi
                    9 -> itemSelected = R.array.spSepsis
                    10 -> itemSelected = R.array.spPosparto
                    11 -> itemSelected = R.array.spNuliparida
                    12 -> itemSelected = R.array.spAdolescentes
                    13 -> itemSelected = R.array.spSangradoVaginal
                    14 -> itemSelected = R.array.spFibromasUterinos
                    15 -> itemSelected = R.array.spNeoplasiaCervical
                    16 -> itemSelected = R.array.spCancerCervical
                    17 -> itemSelected = R.array.spCancerMama
                    18 -> itemSelected = R.array.spHepaticas
                    19 -> itemSelected = R.array.spTVenenoso
                    20 -> itemSelected = R.array.spCardiopatias
                }

                updateSpAnti(itemSelected)
                Log.i("asdas","asdasdja")

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }


    }

    private fun updateSpAnti(itemSelected: Int) {
        //Spinner Anticonceptivo

        val spAntiItems = resources.getStringArray(itemSelected)
        val spAntiAdapter = ArrayAdapter(
            requireContext(),
            R.layout.spinner_selected_item,
            spAntiItems
        )
        spAntiAdapter.setDropDownViewResource(R.layout.spinner_selected_item)

        binding.spAnticonceptivo.adapter = spAntiAdapter

        binding.spAnticonceptivo.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {


                    when (itemSelected) {

                        R.array.spHipertension -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num
                                )

                                1 -> updateNumberImg(
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num
                                )
                            }

                        }

                        R.array.spObesidad -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num
                                )
                            }

                        }

                        R.array.spDiabetes -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num
                                )
                            }

                        }

                        R.array.spTabaquismo -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num
                                )

                                1 -> updateNumberImg(
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num
                                )
                            }

                        }

                        R.array.spDolorCabeza -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num
                                )

                                1 -> updateNumberImg(
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num
                                )
                            }

                        }

                        R.array.spMedicamentos -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num1s2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num
                                )

                                1 -> updateNumberImg(
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num1s2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num
                                )

                                2 -> updateNumberImg(
                                    R.drawable.ic_num1s2,
                                    R.drawable.ic_num1s2,
                                    R.drawable.ic_num1s2,
                                    R.drawable.ic_num1s2,
                                    R.drawable.ic_num2s3,
                                    R.drawable.ic_num2s3
                                )
                            }

                        }

                        R.array.spVih -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num3
                                )
                            }

                        }

                        R.array.spTransmisionSexual -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num4
                                )

                                1 -> updateNumberImg(
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2
                                )

                                2 -> updateNumberImg(
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num2s3,
                                    R.drawable.ic_num2s3
                                )
                            }

                        }

                        R.array.spEpi -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num4
                                )
                            }

                        }

                        R.array.spSepsis -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num4
                                )
                            }

                        }

                        R.array.spPosparto -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num
                                )

                                1 -> updateNumberImg(
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num3
                                )

                                2 -> updateNumberImg(
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num
                                )

                                3 -> updateNumberImg(
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num
                                )
                            }

                        }

                        R.array.spNuliparida -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2
                                )

                            }

                        }

                        R.array.spAdolescentes -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2
                                )
                            }

                        }

                        R.array.spSangradoVaginal -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num4
                                )
                            }

                        }

                        R.array.spFibromasUterinos -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num
                                )
                            }

                        }

                        R.array.spNeoplasiaCervical -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num
                                )
                            }

                        }

                        R.array.spCancerCervical -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num4
                                )
                            }

                        }

                        R.array.spCancerMama -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num
                                )
                            }

                        }

                        R.array.spHepaticas -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num
                                )

                                1 -> updateNumberImg(
                                    R.drawable.ic_num3s4,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num,
                                    R.drawable.ic_num
                                )
                            }

                        }

                        R.array.spTVenenoso -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num
                                )

                                1 -> updateNumberImg(
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num
                                )

                                2 -> updateNumberImg(
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num
                                )
                            }

                        }

                        R.array.spCardiopatias -> {
                            when (position) {
                                0 -> updateNumberImg(
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num
                                )

                                1 -> updateNumberImg(
                                    R.drawable.ic_num4,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num
                                )

                                2 -> updateNumberImg(
                                    R.drawable.ic_num3s4,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num3,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num2,
                                    R.drawable.ic_num
                                )
                            }

                        }

                    }


                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }

            }
    }


    private fun updateNumberImg(
        drawNum1: Int,
        drawNum2: Int,
        drawNum3: Int,
        drawNum4: Int,
        drawNum5: Int,
        drawNum6: Int
    ) {


        binding.ivNum1.background = ContextCompat.getDrawable(requireContext(), drawNum1)
        binding.ivNum2.background = ContextCompat.getDrawable(requireContext(), drawNum2)
        binding.ivNum3.background = ContextCompat.getDrawable(requireContext(), drawNum3)
        binding.ivNum4.background = ContextCompat.getDrawable(requireContext(), drawNum4)
        binding.ivNum5.background = ContextCompat.getDrawable(requireContext(), drawNum5)
        binding.ivNum6.background = ContextCompat.getDrawable(requireContext(), drawNum6)
    }


    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


}