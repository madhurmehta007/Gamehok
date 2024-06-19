package com.example.gamehok.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.gamehok.R
import com.example.gamehok.adapters.CommentsAdapter
import com.example.gamehok.adapters.GamesAdapter
import com.example.gamehok.adapters.ProfileAdapter
import com.example.gamehok.adapters.RelatedGamesAdapter
import com.example.gamehok.adapters.TournamentsAdapter
import com.example.gamehok.databinding.FragmentGamesBinding
import com.example.gamehok.databinding.FragmentHomeBinding
import com.example.gamehok.models.Comments
import com.example.gamehok.models.Games
import com.example.gamehok.models.Tournaments


class GamesFragment : Fragment() {
    private var _binding: FragmentGamesBinding? = null
    private val binding
        get() = _binding!!
    private lateinit var relatedGamesAdapter: RelatedGamesAdapter
    private lateinit var commentsAdapter: CommentsAdapter
    private lateinit var tournamentsAdapter: TournamentsAdapter
    var commentsList = mutableListOf<Comments>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val relatedGamesList = mutableListOf(
            Games("Call of Duty Mobile", 0),
            Games("Valorent", 0),
            Games("Apex Legends", 0),
        )
        relatedGamesAdapter = RelatedGamesAdapter(requireContext(), relatedGamesList)
        val adapter = relatedGamesAdapter
        binding.rvRelatedGames.setHasFixedSize(true)
        binding.rvRelatedGames.adapter = adapter
        binding.rvRelatedGames.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        commentsList = mutableListOf(
            Comments("Amazing graphics and smooth gameplay. Love it!", "Sam", "19th June, 2024"),
            Comments("Great game modes and customization options!", "John", "15th June, 2024"),
            Comments("Engaging and fun! A must-try for FPS fans.", "Alexandra", "10th May, 2024"),
            Comments(
                "Thrilling gameplay and stunning graphics, a must-play!",
                "Robert",
                "5th April, 2024"
            )
        )

        binding.btnPostComment.setOnClickListener {
            if (binding.etComment.text.isNotEmpty()) {
                val newComment =
                    Comments(binding.etComment.text.toString(), "Madhur", "19th June, 2024")
                commentsList.add(0, newComment)
                commentsAdapter.notifyItemInserted(0)
                binding.etComment.text.clear()
                binding.rvComments.scrollToPosition(0)
            }
        }

        commentsRecyclerViewSetup()

        val tournamentsList = mutableListOf(
            Tournaments("PUBG Tournament By Red Bull"),
            Tournaments("PUBG Tournament By Red Bull"),
            Tournaments("PUBG Tournament By Red Bull"),
            Tournaments("PUBG Tournament By Red Bull"),
        )

        tournamentsAdapter = TournamentsAdapter(requireContext(), tournamentsList)
        val adapter3 = tournamentsAdapter
        binding.rvTournaments.setHasFixedSize(true)
        binding.rvTournaments.adapter = adapter3
        binding.rvTournaments.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }

    private fun commentsRecyclerViewSetup() {
        commentsAdapter = CommentsAdapter(requireContext(), commentsList)
        val adapter2 = commentsAdapter
        binding.rvComments.setHasFixedSize(true)
        binding.rvComments.adapter = adapter2
        binding.rvComments.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
    }

}