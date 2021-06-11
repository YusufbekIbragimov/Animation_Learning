package uz.yusufbek_ibragimov.animation_learning.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.yusufbek_ibragimov.animation_learning.R
import uz.yusufbek_ibragimov.animation_learning.databinding.FragmentABinding

/**
 * Bismillah
 * Ibragimov Yusufbek
 * 08.06.2021
 * ibragimovy390@gmail.com
 * */

class Fragment_A : Fragment() {

    private var _binding: FragmentABinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val inflater=TransitionInflater.from(requireContext())
//        exitTransition=inflater.inflateTransition(R.transition.fade)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        ViewCompat.setTransitionName(binding.animatedBtn,binding.animatedBtn.transitionName)

        binding.animatedMakerBtn.setOnClickListener {
            binding.animatedBtn
                .animate()
                .setDuration(2_000)
                .yBy(400f)
                .xBy(200f)
                .start()
        }

        binding.animatedMakerBtn.setOnLongClickListener {
            findNavController().navigate(R.id.action_fragment_A_to_fragment_B)
            true
        }

    }

}