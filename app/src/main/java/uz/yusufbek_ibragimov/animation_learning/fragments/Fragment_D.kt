package uz.yusufbek_ibragimov.animation_learning.fragments

import android.content.Context
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import uz.yusufbek_ibragimov.animation_learning.R
import uz.yusufbek_ibragimov.animation_learning.Sports
import uz.yusufbek_ibragimov.animation_learning.adapters.SportsAdapter
import uz.yusufbek_ibragimov.animation_learning.databinding.FragmentABinding
import uz.yusufbek_ibragimov.animation_learning.databinding.FragmentDBinding

/**
 * Bismillah
 * Ibragimov Yusufbek
 * 08.06.2021
 * ibragimovy390@gmail.com
 * */

class Fragment_D : Fragment() {

    private var _binding: FragmentDBinding? = null
    val binding get() = _binding!!
    private var adapter: SportsAdapter? = null
    private var listData: ArrayList<Sports>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDBinding.inflate(inflater, container, false)

        sharedElementReturnTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
        binding.recyclerView.layoutManager=GridLayoutManager(requireContext(),2)
        adapter= SportsAdapter(listData!!,sportsItemListener)
        binding.recyclerView.adapter=adapter

        // When user hits back button transition takes backward
        postponeEnterTransition()
        binding.recyclerView.doOnPreDraw {
            startPostponedEnterTransition()
        }

    }

    private fun loadData() {
        listData= ArrayList<Sports>()
        listData=getList(requireContext())
    }

    private fun getList(context: Context):ArrayList<Sports>{
        return arrayListOf(
            Sports(
                0,
                R.drawable.ic_rugby,
                context.getString(R.string.title_rugby),
                context.getString(R.string.about_rugby)
            ),
            Sports(
                1,
                R.drawable.ic_cricket,
                context.getString(R.string.title_cricket),
                context.getString(R.string.about_cricket)
            ),
            Sports(
                2,
                R.drawable.ic_hockey,
                context.getString(R.string.title_hockey),
                context.getString(R.string.about_hockey)
            ),
            Sports(
                3,
                R.drawable.ic_basketball,
                context.getString(R.string.title_basketball),
                context.getString(R.string.about_basketball)
            ),
            Sports(
                4,
                R.drawable.ic_volleyball,
                context.getString(R.string.title_volleyball),
                context.getString(R.string.about_volleyball)
            ),
            Sports(
                5,
                R.drawable.ic_esports,
                context.getString(R.string.title_esports),
                context.getString(R.string.about_esports)
            ),
            Sports(
                6,
                R.drawable.ic_kabaddi,
                context.getString(R.string.title_kabbadi),
                context.getString(R.string.about_kabbadi)
            ),
            Sports(
                7,
                R.drawable.ic_baseball,
                context.getString(R.string.title_baseball),
                context.getString(R.string.about_baseball)
            ),
            Sports(
                8,
                R.drawable.ic_mma,
                context.getString(R.string.title_mma),
                context.getString(R.string.about_mma)
            ),
            Sports(
                9,
                R.drawable.ic_soccer,
                context.getString(R.string.title_soccer),
                context.getString(R.string.about_soccer)
            ),
            Sports(
                10,
                R.drawable.ic_handball,
                context.getString(R.string.title_handball),
                context.getString(R.string.about_handball)
            ),
            Sports(
                11,
                R.drawable.ic_tennis,
                context.getString(R.string.title_tennis),
                context.getString(R.string.about_tennis)
            )
        )
    }

    private val sportsItemListener = SportsAdapter.OnImgClickListener { sports, imageView, textView ->
        val direction: NavDirections =
            Fragment_DDirections.actionFragmentDToFragmentE(sports.banner,sports.title,sports.about)

        val extras = FragmentNavigatorExtras(
            imageView to sports.banner.toString(),
            textView to sports.title
        )

        findNavController().navigate(direction, extras)
    }

}