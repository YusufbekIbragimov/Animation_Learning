package uz.yusufbek_ibragimov.animation_learning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import uz.yusufbek_ibragimov.animation_learning.databinding.ActivityMainBinding
import uz.yusufbek_ibragimov.animation_learning.fragments.Fragment_B

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}