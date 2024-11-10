package com.example.enviromentapp.UI

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.enviromentapp.Data.EnvActivity
import com.example.enviromentapp.R
import com.example.enviromentapp.databinding.FragmentEditBinding
import java.util.Calendar

private const val ARG_ACTIVITY = "activity_position"

class EditFragment : Fragment() {
    private var envactivity: EnvActivity? = null
    private var position: Int? = null
    private var _binding: FragmentEditBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(ARG_ACTIVITY)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        envactivity = (activity as MainActivity).repository.activities[position!!]

        binding.date.setOnClickListener {
            showDatePickerDialog()
        }

        envactivity?.let {
            binding.activityName.setText(it.activityName)
            binding.category.setText(it.category)
            binding.amount.setText(it.amount.toString())
            binding.date.setText(it.date)
            binding.impactLevel.setText(it.impactLevel)
        }

        binding.buttonSave.setOnClickListener {
            envactivity?.let {
                it.activityName = binding.activityName.text.toString()
                it.category = binding.category.text.toString()
                it.amount = binding.amount.text.toString().toFloat()
                it.date = binding.date.text.toString()
                it.impactLevel = binding.impactLevel.text.toString()
            }
            (activity as MainActivity).repository.updateActivity(position!!, envactivity!!)
            findNavController().navigate(R.id.action_editFragment_to_FirstFragment)
        }

        binding.buttonDelete.setOnClickListener {
            showDeleteConfirmationDialog()
        }

        binding.buttonCancel.setOnClickListener {
            findNavController().navigate(R.id.action_editFragment_to_FirstFragment)
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

    private fun showDeleteConfirmationDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setMessage("Are you sure you want to delete this activity?")
            .setPositiveButton("Yes") { _, _ ->
                (activity as MainActivity).repository.removeActivity(position!!)
                findNavController().navigate(R.id.action_editFragment_to_FirstFragment)
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
        builder.create().show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
