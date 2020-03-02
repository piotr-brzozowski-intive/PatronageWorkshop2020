package com.intive.androidplayground.match.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.intive.androidplayground.R
import com.intive.androidplayground.databinding.MatchResultActivityBinding
import com.intive.androidplayground.match.viewmodel.MatchResultViewModel
import kotlinx.android.synthetic.main.match_result_activity.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MatchResultActivity : AppCompatActivity() {

    private val matchResultViewModel: MatchResultViewModel by viewModel()
    private val matchResultListAdapter: MatchResultListAdapter by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MatchResultActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.match_result_activity)
        binding.lifecycleOwner = this
        binding.matchResultsViewModel = matchResultViewModel
        setupRecyclerView()
        //TODO: alternative implementation without bindings
        //observeViewModel()
        //matchResultViewModel.createView()

    }

    //TODO: alternative implementation without bindings
    private fun observeViewModel() {
        matchResultViewModel.items.observe(this, Observer { newItems ->
            matchResultListAdapter.updateMatchResults(newItems)
        })
        matchResultViewModel.error.observe(this, Observer { error ->
            if (error) Toast.makeText(this@MatchResultActivity, "error", Toast.LENGTH_LONG).show()
        })
    }

    private fun setupRecyclerView() {
        matchResultRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MatchResultActivity)
            adapter = matchResultListAdapter
        }
    }
}
