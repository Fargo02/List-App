package com.example.listapp.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listapp.core.domain.usecase.api.GetAppsInfoUseCase
import com.example.listapp.home.presentation.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAppsInfoUseCase: GetAppsInfoUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val appList = getAppsInfoUseCase()
            _uiState.update { it.copy(appList = appList) }
        }
    }
}