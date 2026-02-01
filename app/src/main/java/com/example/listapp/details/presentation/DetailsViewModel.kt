package com.example.listapp.details.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listapp.core.domain.api.ExternalNavigator
import com.example.listapp.details.domain.usecase.api.GetApkSha1UseCase
import com.example.listapp.details.domain.usecase.api.GetAppInfoByPackageUseCase
import com.example.listapp.details.presentation.state.DetailsAction
import com.example.listapp.details.presentation.state.DetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getAppInfoByPackageUseCase: GetAppInfoByPackageUseCase,
    private val getApkSha1UseCase: GetApkSha1UseCase,
    private val externalNavigator: ExternalNavigator,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val packageName = savedStateHandle.get<String>("packageName") ?: ""

    private val _uiState = MutableStateFlow(DetailsState())
    val uiState: StateFlow<DetailsState> get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val appInfo = getAppInfoByPackageUseCase(packageName = packageName)
            val sha1 = getApkSha1UseCase.invoke(appInfo?.apkPath ?: "")

            _uiState.update {
                it.copy(
                    appInfo = appInfo,
                    checksum = sha1
                )
            }
        }
    }

    fun actionHandler(action: DetailsAction) {
        when (action) {
            DetailsAction.LaunchApp -> launchApp()
        }
    }

    private fun launchApp() {
        _uiState.value.appInfo?.packageName?.let {
            externalNavigator.launchTheApp(it)
        }
    }
}