package com.example.enviromentapp.UI

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.enviromentapp.R
import com.example.enviromentapp.databinding.FragmentAddBinding
import com.example.enviromentapp.Data.*
import java.util.*

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.date.setOnClickListener {
            showDatePickerDialog()
        }

        binding.buttonSave.setOnClickListener {

            val activityName = binding.activityName.text.toString()
            val category = binding.category.text.toString()
            val amount = binding.amount.text.toString().toFloatOrNull() ?: Float.NaN
            val date = binding.date.text.toString()
            val impactLevel = binding.impactLevel.text.toString()

            if (activityName.isEmpty() || category.isEmpty() || amount.isNaN() || date.isEmpty() || impactLevel.isEmpty()) {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Error")
                builder.setMessage("Please fill out all fields")
                builder.setPositiveButton("OK") { _, _ -> }
                builder.show()
                return@setOnClickListener

            }

            val newActivity = EnvActivity(activityName, category, amount, date, impactLevel)
            (activity as MainActivity).repository.addActivity(newActivity)

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)

        }


        binding.buttonCancel.setOnClickListener {

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)


        }
    }

    private fun  showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                binding.date.text = selectedDate
            },
            year, month, day
        )
        datePickerDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}