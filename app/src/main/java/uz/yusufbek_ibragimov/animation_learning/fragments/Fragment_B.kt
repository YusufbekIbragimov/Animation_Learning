package uz.yusufbek_ibragimov.animation_learning.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.yusufbek_ibragimov.animation_learning.R
import uz.yusufbek_ibragimov.animation_learning.databinding.FragmentABinding
import uz.yusufbek_ibragimov.animation_learning.databinding.FragmentBBinding

/**
 * Bismillah
 * Ibragimov Yusufbek
 * 08.06.2021
 * ibragimovy390@gmail.com
 * */

class Fragment_B : Fragment() {

    private var _binding: FragmentBBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val inflater= TransitionInflater.from(requireContext())
//        exitTransition=inflater.inflateTransition(R.transition.slide_right)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentBBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        ViewCompat.setTransitionName(binding.animatedBtn,binding.animatedBtn.transitionName)
//
//        val width_view=binding.animatedBtn.width
//        val x=binding.animatedBtn.x
//        val y=binding.animatedBtn.y

//        Log.d("MyTag", "onViewCreated: width=$width_view x=$x y=$y")


        binding.animatedBtn.setOnTouchListener { v, event ->
/*
            Log.d("MyTag", "onViewCreated: x=${event.x} y=${event.y}  xPrecision=${event.xPrecision} yPrecision=${event.yPrecision}")
            Log.d("MyTag", "onViewCreated: event.size=${event.size} event.rawX=${event.rawX}  event.rawY=${event.rawY}")
            Log.d("MyTag", "onViewCreated: v.scr=${v.scrollBarSize} v.pivotX=${v.pivotX}  v.pivotY=${v.pivotY}  v.width=${v.width}  v.height=${v.height}")
*/

                if (v.width/2 < event.x){
                    Log.d("MyTag", "onViewCreated: o'ng")
                    Log.d("MyTag", "onViewCreated: x=${event.x} y=${event.y}")
                    Log.d("MyTag", "onViewCreated: v.width=${v.width}  v.height=${v.height}")
                    binding.animatedBtn.animate()
                        .rotationBy(360f)
                        .setDuration(1000)
                        .start()
                }else{
                    Log.d("MyTag", "onViewCreated: chap")
                    Log.d("MyTag", "onViewCreated: x=${event.x} y=${event.y}")
                    Log.d("MyTag", "onViewCreated: v.width=${v.width}  v.height=${v.height}")
                    binding.animatedBtn.animate()
                        .rotationBy(-360f)
                        .setDuration(1000)
                        .start()
                }

            false
        }

        binding.animatedMakerBtn.setOnClickListener {

            binding.animatedBtn.animate()
                .rotationBy(3600f)
                .setDuration(3000)
                .start()

        }

        binding.animatedMakerBtn.setOnLongClickListener {

            findNavController().navigate(R.id.action_fragment_B_to_fragment_C)

            true
        }

    }

}