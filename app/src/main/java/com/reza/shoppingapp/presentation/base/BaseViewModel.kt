package com.reza.shoppingapp.presentation.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<Event : ViewEvent, UiState : ViewState, Effect : ViewSideEffect> :
    ViewModel() {

    private val initialState: UiState by lazy { setInitialState() }
    abstract fun setInitialState(): UiState

    /**
     * View States
     */
    private val _viewState: MutableState<UiState> = mutableStateOf(initialState)
    val viewState: State<UiState> = _viewState

    /**
     * View Events
     */
    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()

    /**
     * Side Effects
     */
    private val _effect: Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()

    /**
     * To set events from UI
     */
    fun setEvent(event: Event) {
        viewModelScope.launch { _event.emit(event) }
    }

    /**
     * Setting States
     */
    protected fun setState(reducer: UiState.() -> UiState) {
        val newState = viewState.value.reducer()
        _viewState.value = newState
    }

    /**
     * Setting Side Effects
     */
    protected fun setEffect(builder: () -> Effect) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }
}

interface ViewEvent
interface ViewState
interface ViewSideEffect