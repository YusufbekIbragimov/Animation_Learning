package uz.yusufbek_ibragimov.animation_learning.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import uz.yusufbek_ibragimov.animation_learning.databinding.FragmentABinding
import uz.yusufbek_ibragimov.animation_learning.databinding.FragmentDBinding
import uz.yusufbek_ibragimov.animation_learning.databinding.FragmentEBinding
import java.util.concurrent.TimeUnit

/**
 * Bismillah
 * Ibragimov Yusufbek
 * 08.06.2021
 * ibragimovy390@gmail.com
 * */

class Fragment_E : Fragment() {

    private var _binding: FragmentEBinding? = null
    val binding get() = _binding!!
    val args:Fragment_EArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentEBinding.inflate(inflater,container,false)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        postponeEnterTransition(250, TimeUnit.MILLISECONDS)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailImageView.setImageResource(args.ImageResurs)
        binding.titleDetailTextView.text=args.Title
        binding.aboutDetailTextView.text=args.about

        binding.detailImageView.transitionName= args.ImageResurs.toString()
        binding.titleDetailTextView.transitionName= args.Title

    }

}