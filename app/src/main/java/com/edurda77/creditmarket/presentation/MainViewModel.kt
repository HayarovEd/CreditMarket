package com.edurda77.creditmarket.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edurda77.creditmarket.domain.repository.CreditMarketRepository
import com.edurda77.creditmarket.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: CreditMarketRepository) :
    ViewModel() {

    private val _allData =
        MutableLiveData<MainViewState>(MainViewState.Loading)
    val allData = _allData

    init {
        getAllData()
    }

    private fun getAllData() {
        viewModelScope.launch {
            when (val result = repository.getAllData()) {
                is Resource.Success -> {
                    _allData.value = MainViewState.Success(result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _allData.value = MainViewState.Failure(result.message.toString())
                }
            }
        }
    }
}