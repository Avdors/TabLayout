package com.example.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.tablayout.databinding.ContentFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator


class ContentFragment : Fragment() {
    private lateinit var binding: ContentFragmentBinding
    private val fragList = listOf(InfoFragment.newInstance(), UseCaseFragment.newInstance())
    private val fragListTitle = listOf("Описание", "Применение")
    private val model: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ContentFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.plant.observe(viewLifecycleOwner) {
            binding.imvPlant.setImageResource(it.imageid)
        }
        val adapter = VpAdapter(activity as AppCompatActivity, fragList)
        binding.vp2.adapter = adapter
        TabLayoutMediator(binding.tbMain, binding.vp2){
                tab, pos -> tab.text = fragListTitle[pos]
        }.attach()
    }
    companion object {
        @JvmStatic
        fun newInstance() = ContentFragment()

    }
}