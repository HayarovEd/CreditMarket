package com.edurda77.creditmarket.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.edurda77.creditmarket.R
import com.edurda77.creditmarket.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.allData.observe(this) {
            when (it) {
                is MainViewState.Success -> {
                    binding.progress.isVisible = false
                    binding.listRv.isVisible = true
                    //initRecyclerView(it.data)
                }
                is MainViewState.Failure -> {
                    binding.progress.isVisible = false
                    binding.listRv.isVisible = false
                    Toast.makeText(this, it.error, Toast.LENGTH_LONG).show()
                }
                is MainViewState.Loading -> {
                    binding.progress.isVisible = true
                    binding.listRv.isVisible = false
                }
            }
        }
    }
}