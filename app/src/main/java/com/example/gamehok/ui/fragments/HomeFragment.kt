package com.example.gamehok.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.gamehok.R
import com.example.gamehok.adapters.BannerAdapter
import com.example.gamehok.adapters.GamesAdapter
import com.example.gamehok.adapters.ProfileAdapter
import com.example.gamehok.adapters.TournamentsAdapter
import com.example.gamehok.databinding.FragmentHomeBinding
import com.example.gamehok.models.Games
import com.example.gamehok.models.Profile
import com.example.gamehok.models.Tournaments
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = _binding!!
    private lateinit var gamesAdapter: GamesAdapter
    private lateinit var tournamentsAdapter: TournamentsAdapter
    private lateinit var profileAdapter: ProfileAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private val handler = Handler(Looper.getMainLooper())
    private val imageChangeRunnable = object : Runnable {
        override fun run() {
            viewPager.currentItem =
                (viewPager.currentItem + 1) % (viewPager.adapter?.itemCount ?: 1)
            handler.postDelayed(this, 4000)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = binding.viewPagerBanner
        tabLayout = binding.tabLayout

        val images = listOf(
            R.drawable.banner_1,
            R.drawable.banner_1,
            R.drawable.banner_1,
        )

        val adapter = BannerAdapter(images)
        binding.viewPagerBanner.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Create a custom view for the tab to show the dot indicator
            tab.customView =
                LayoutInflater.from(context).inflate(R.layout.tab_custom_view, tabLayout, false)
        }.attach()

        handler.postDelayed(imageChangeRunnable, 4000)

        val gamesList = mutableListOf(
            Games("PUBG", R.drawable.ic_pubg),
            Games("Valorent", R.drawable.ic_valorent),
            Games("Apex Legends", R.drawable.ic_apex_legends),
            Games("Call of Duty", R.drawable.ic_codm),
            Games("Counter Strike", R.drawable.ic_counter_strike),
            Games("PUBG", R.drawable.ic_pubg)
        )

        gamesAdapter = GamesAdapter(requireContext(), gamesList)
        val adapter2 = gamesAdapter
        binding.rvGames.setHasFixedSize(true)
        binding.rvGames.adapter = adapter2
        binding.rvGames.layoutManager =
            GridLayoutManager(context, 3)

        gamesAdapter.onItemClick = {
            findNavController().navigate(R.id.action_homeFragment_to_gamesFragment)
        }

        val tournamentsList = mutableListOf(
            Tournaments("PUBG Tournament By Red Bull"),
            Tournaments("PUBG Tournament By Red Bull"),
            Tournaments("PUBG Tournament By Red Bull"),
            Tournaments("PUBG Tournament By Red Bull"),
        )

        tournamentsAdapter = TournamentsAdapter(requireContext(),tournamentsList)
        val adapter3 = tournamentsAdapter
        binding.rvTournaments.setHasFixedSize(true)
        binding.rvTournaments.adapter = adapter3
        binding.rvTournaments.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        tournamentsAdapter.onItemClick = {
            findNavController().navigate(R.id.action_homeFragment_to_tournamentDetailsFragment)
        }

        val profileList = mutableListOf(
            Profile("Legend Gamer", R.drawable.ic_person),
            Profile("Legend Gamer", R.drawable.ic_person_2),
            Profile("Legend Gamer", R.drawable.ic_person_3)
        )

        profileAdapter = ProfileAdapter(requireContext(),profileList)
        val adapter4 = profileAdapter
        binding.rvProfiles.setHasFixedSize(true)
        binding.rvProfiles.adapter = adapter4
        binding.rvProfiles.layoutManager =
            LinearLayoutManager(context)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(imageChangeRunnable)
        _binding = null
    }

}