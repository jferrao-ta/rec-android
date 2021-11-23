package com.viator.android.rec.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.viator.android.rec.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var btPressHere: Button? = null
    private var message: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews(view)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java].apply {
            state.observe(viewLifecycleOwner, ::onStateChanged)
        }
    }

    private fun setupViews(view: View) {
        btPressHere = view.findViewById(R.id.btPressHere)
        message = view.findViewById(R.id.message)

        btPressHere?.setOnClickListener { viewModel.onButtonClicked() }
    }

    private fun onStateChanged(state: MainViewModel.State) {
        message?.isVisible = state.visible
    }
}
