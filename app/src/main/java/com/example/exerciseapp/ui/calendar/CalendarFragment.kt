package com.example.exerciseapp.ui.calendar

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.exerciseapp.R
import com.example.exerciseapp.databinding.FragmentCalendarBinding
import com.example.exerciseapp.ui.login.LoginActivity
import java.text.SimpleDateFormat
import java.util.*

class CalendarFragment : Fragment() {

    private lateinit var calendarViewModel: CalendarViewModel
    private var _binding: FragmentCalendarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create check token thin here!
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        calendarViewModel =
            ViewModelProvider(this).get(CalendarViewModel::class.java)

        // val view = inflater.inflate(R.layout.fragment_calendar,container,false)


        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val calendar = root.findViewById<CalendarView>(R.id.calendarView)
        val selectedDate = root.findViewById<TextView>(R.id.text_selectedDate)
        val dateFormatter = SimpleDateFormat("dd/MM/yyyy")
        selectedDate.text = dateFormatter.format(Date(calendar.date))
        calendar.setOnDateChangeListener { view, year, month, day ->
            selectedDate.text = "$day/$month/$year"
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}