package com.bsuir.todolist.ui.list

import com.bsuir.todolist.data.Task

sealed class TodoListEvent {
    data class OnDeleteTodoClick(val task: Task): TodoListEvent()
    data class OnDoneChange(val task: Task, val isDone: Boolean): TodoListEvent()
    object OnUndoDeleteClick: TodoListEvent()
    data class OnTodoClick(val task: Task): TodoListEvent()
    object OnAddTodoClick: TodoListEvent()
}
