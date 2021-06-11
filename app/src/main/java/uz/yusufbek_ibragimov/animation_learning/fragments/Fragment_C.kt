package uz.yusufbek_ibragimov.animation_learning.fragments

import android.graphics.Interpolator
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.yusufbek_ibragimov.animation_learning.R
import uz.yusufbek_ibragimov.animation_learning.databinding.FragmentCBinding

/**
 * Bismillah
 * Ibragimov Yusufbek
 * 08.06.2021
 * ibragimovy390@gmail.com
 * */

class Fragment_C : Fragment() {

    private var _binding: FragmentCBinding? = null
    val binding get() = _binding!!
    private var isClicked = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.animateMaker.setOnLongClickListener{
            findNavController().navigate(R.id.action_fragment_C_to_fragment_D)
            true
        }

        binding.animateMaker.setOnClickListener {
            if (!isClicked) {
                binding.floatBtn1
                    .animate()
                    .setDuration(400)
                    .setInterpolator(LinearInterpolator())
                    .yBy(-200f)
                    .start()

                binding.floatBtn2
                    .animate()
                    .setDuration(800)
                    .setInterpolator(LinearInterpolator())
                    .yBy(-400f)
                    .start()

                binding.floatBtn3
                    .animate()
                    .setDuration(400)
                    .setInterpolator(LinearInterpolator())
                    .xBy(-200f)
                    .start()
                isClicked = true
            }
        }

    }

}