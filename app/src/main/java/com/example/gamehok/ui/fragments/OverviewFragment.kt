package com.example.gamehok.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gamehok.R
import com.example.gamehok.databinding.FragmentOverviewBinding
import com.example.gamehok.databinding.FragmentTournamentDetailsBinding

class OverviewFragment : Fragment() {
    private var _binding: FragmentOverviewBinding? = null
    private val binding
        get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        return binding.root

    }

}