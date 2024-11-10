package com.example.enviromentapp.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.enviromentapp.R
import com.example.enviromentapp.databinding.FragmentListBinding
import com.example.enviromentapp.Data.*
import java.io.Console

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        populateList()

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val bundle = Bundle()
            bundle.putInt("activity_position", position)
            findNavController().navigate(R.id.action_FirstFragment_to_editFragment, bundle)
        }

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun populateList() {
        val list = (activity as MainActivity).repository.activities
        val adapter =
            ArrayAdapter<EnvActivity>(requireContext(), android.R.layout.simple_list_item_1, list)
        binding.listView.adapter = adapter

    }




}