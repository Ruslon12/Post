package com.example.post.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.post.R
import com.example.post.databinding.FragmentAddPostBinding
import com.example.post.dto.SetPost
import com.example.post.viewmodel.AddState
import com.example.post.viewmodel.AddViewModel

class AddFragment: Fragment(R.layout.fragment_add_post) {
    private lateinit var binding: FragmentAddPostBinding
    private val viewModel : AddViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentAddPostBinding.bind(view)

        binding.createbtn.setOnClickListener {
            val name : String = binding.author.toString()
            val text : String = binding.content.toString()
            if (name.isNotEmpty() && text.isNotEmpty()){
                val post = SetPost(name,text)
                viewModel.setPost(post)
            }
        }

        viewModel.liveData.observe(viewLifecycleOwner) {state ->
            when (state){
                is AddState.Done -> {
                    findNavController().popBackStack()
                }
                is AddState.Error -> {
                    Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                }
                is AddState.Loading -> {}
            }
        }
    }
}