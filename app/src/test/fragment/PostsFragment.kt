package com.example.post.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.post.R
import com.example.post.adapters.PostAdapter
import com.example.post.databinding.FragmentPostsBinding
import com.example.post.viewmodel.PostViewModel
import com.example.post.viewmodel.PostsState

class PostsFragment: Fragment(R.layout.fragment_posts) {
    private lateinit var binding: FragmentPostsBinding

    private val viewModel: PostViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentPostsBinding.bind(view)

        binding.add.setOnClickListener {
            findNavController().navigate(R.id.from_posts_to_add)
        }

        binding.postRecucler.layoutManager = LinearLayoutManager(requireContext())

        viewModel.liveData.observe(viewLifecycleOwner) { state ->
            when(state) {
                is PostsState.Success -> {
                    val list = state.posts
                    binding.postRecucler.adapter = PostAdapter(list)
                }
                is PostsState.Error -> {
                    Toast.makeText(requireContext(), "Error: ${state.message}" , Toast.LENGTH_SHORT).show()
                }
                is PostsState.Loading -> {
                }
            }
        }

        viewModel.fetch()

    }
}