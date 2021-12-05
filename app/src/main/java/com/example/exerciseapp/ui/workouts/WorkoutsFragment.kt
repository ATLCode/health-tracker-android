package com.example.exerciseapp.ui.workouts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exerciseapp.R
import com.example.exerciseapp.WorkoutAdapter
import com.example.exerciseapp.databinding.FragmentWorkoutsBinding

class WorkoutsFragment : Fragment() {

    private lateinit var workoutsViewModel: WorkoutsViewModel
    private var _binding: FragmentWorkoutsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        workoutsViewModel =
            ViewModelProvider(this).get(WorkoutsViewModel::class.java)

        _binding = FragmentWorkoutsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val recyclerView = root.findViewById<RecyclerView>(R.id.rv_workouts)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = WorkoutAdapter()

        recyclerView.addItemDecoration(
            DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL)
        )

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}