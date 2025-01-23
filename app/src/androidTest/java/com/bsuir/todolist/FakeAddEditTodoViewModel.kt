package com.bsuir.todolist

import androidx.lifecycle.SavedStateHandle
import com.bsuir.todolist.data.TaskRepository
import com.bsuir.todolist.ui.edit.AddEditTodoEvent
import com.bsuir.todolist.ui.edit.AddEditTodoViewModel
import com.bsuir.todolist.util.UiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class FakeAddEditTodoViewModel(
    repository: TaskRepository,
    savedStateHandle: SavedStateHandle
) : AddEditTodoViewModel(repository, savedStateHandle) {
    var isSaveClicked: Boolean = false

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    override val uiEvent = _uiEvent.asSharedFlow()

    override fun onEvent(event: AddEditTodoEvent) {
        when (event) {
            is AddEditTodoEvent.OnTitleChange -> title = event.title
            is AddEditTodoEvent.OnDescriptionChange -> description = event.description
            is AddEditTodoEvent.OnSaveTodoClick -> isSaveClicked = true
        }
    }
}
