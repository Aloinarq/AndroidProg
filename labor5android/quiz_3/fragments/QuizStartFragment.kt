package com.example.quiz_3.fragments

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz_3.LOG_I_MAIN
import com.example.quiz_3.R
import com.example.quiz_3.databinding.FragmentQuizStartBinding

class QuizStartFragment : Fragment() {
    lateinit var binding: FragmentQuizStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = binding.button
        val contactsButton: Button = binding.contactsButton
        val nameInput = binding.nameInput
        button.setOnClickListener {
            val name = nameInput.text.toString()
            if (name.isNotBlank()) {
                val fragmentTransaction = parentFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container_view,QuestionFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit()
            }
        }
//        contactsButton.setOnClickListener {
//            getContent.launch(null);
//        }
    }
}