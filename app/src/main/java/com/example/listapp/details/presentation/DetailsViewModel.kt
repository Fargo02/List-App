package com.example.listapp.details.presentation

import androidx.lifecycle.ViewModel
import com.example.listapp.details.presentation.state.DetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(

) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailsState())
    val uiState: StateFlow<DetailsState> get() = _uiState.asStateFlow()
}