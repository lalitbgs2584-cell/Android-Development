package com.example.app0ftheday.view

import CountViewModel
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.LiveData
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.app0ftheday.R
import com.example.app0ftheday.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val countView: CountViewModel by activityViewModels() // shared ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        // Observe LiveData
        countView.count.observe(viewLifecycleOwner) { value ->
            binding.textviewCount.text = "Count: $value"
            Log.i("GET", "Received Value: $value")
            Toast.makeText(requireContext(), "Received Value: $value", Toast.LENGTH_SHORT).show()
        }

        // Button click listeners
        binding.increaseCount.setOnClickListener { countView.increment() }
        binding.decreaseCount.setOnClickListener { countView.decrement() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
