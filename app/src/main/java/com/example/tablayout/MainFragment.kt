package com.example.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.tablayout.databinding.MainFragmentBinding


class MainFragment : Fragment() {
lateinit var binding: MainFragmentBinding
private val model: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bRoze.setOnClickListener{
            model.plant.value = PlantModel(R.drawable.im_roze,"Роза розовая", "Букет роз розовых")
            (activity as AppCompatActivity).supportFragmentManager.beginTransaction().replace(R.id.holder, ContentFragment.newInstance()).commit()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()

    }
}