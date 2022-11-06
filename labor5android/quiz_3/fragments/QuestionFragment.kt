package com.example.quiz_3.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.quiz_3.R
import com.example.quiz_3.databinding.FragmentQuestionBinding
import com.example.quiz_3.model.QuizViewModel

class QuestionFragment : Fragment() {

    private lateinit var viewModel: QuizViewModel
    private lateinit var binding: FragmentQuestionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[QuizViewModel::class.java]
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        viewModel.currentQuestion.observe(requireActivity()) { (question, isLast) ->
            binding.textView.text = question?.text
            binding.radioButton2.text = question?.answers?.get(0) ?: "A"
            binding.radioButton3.text = question?.answers?.get(1) ?: "B"
            binding.radioButton4.text = question?.answers?.get(2) ?: "C"
            binding.radioButton5.text = question?.answers?.get(3) ?: "D"
            if (isLast) {
                binding.button2.text = "Következő"
                binding.button2.setOnClickListener {
                    val fragmentManager = parentFragmentManager.beginTransaction()
                    fragmentManager.replace(R.id.fragment_container_view, QuizEndFragment())
                    fragmentManager.commit()
                }
            }
        }
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.text = "NEXT"
        binding.button2.setOnClickListener {
            val checkedId = binding.radioGroup2.checkedRadioButtonId;
            if (checkedId == -1) {
                return@setOnClickListener
            }
            if (requireView().findViewById<RadioButton>(checkedId).text == viewModel.currentQuestion.value?.first?.correctAnswer) {
                viewModel.numCorrect++

            }
            viewModel.getNextQuestion()
            binding.radioGroup2.clearCheck()
            Log.d("Question", viewModel.numCorrect.toString())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(
            true
        ) {
            override fun handleOnBackPressed() {
                alertUser()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(),
            callback
        )
    }

    fun alertUser() {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("WARNING!")
        builder.setMessage("Are you sure you want to finish the quiz? Your progress will be lost!")
        builder.setPositiveButton("Yes") { dialog, which ->
            viewModel.resetQuiz()
            val fragmentManager = parentFragmentManager.beginTransaction()
            fragmentManager.replace(R.id.fragment_container_view, QuizStartFragment())
            fragmentManager.commit()
        }
        builder.setNegativeButton("No, I want to continue") { dialog, which ->
            dialog.cancel()
        }
        builder.show()
    }
}