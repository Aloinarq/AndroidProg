package com.example.quiz_3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.quiz_3.R
import com.example.quiz_3.databinding.FragmentQuizEndBinding
import com.example.quiz_3.model.QuizViewModel

class QuizEndFragment : Fragment() {
    private lateinit var viewModel: QuizViewModel
    private lateinit var binding: FragmentQuizEndBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity())[QuizViewModel::class.java]
        binding = FragmentQuizEndBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewNumCorrect.text = viewModel.numCorrect.toString()

        binding.buttonToStart.setOnClickListener {
            viewModel.resetQuiz()
            val fragmentManager = parentFragmentManager.beginTransaction()
            fragmentManager.replace(R.id.fragment_container_view, QuizStartFragment())
            fragmentManager.commit()
        }
    }
}