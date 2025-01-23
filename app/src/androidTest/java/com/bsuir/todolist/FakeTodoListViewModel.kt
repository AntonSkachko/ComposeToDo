package com.bsuir.todolist

import com.bsuir.todolist.data.Task
import com.bsuir.todolist.data.TaskRepository
import com.bsuir.todolist.ui.list.TodoListEvent
import com.bsuir.todolist.ui.list.TodoListViewModel
import kotlinx.coroutines.flow.Flow

class FakeTodoListViewModel(
    repository: TaskRepository
) : TodoListViewModel(repository) {
    private val _todos = repository.getTodos()
    override val todos: Flow<List<Task>> = _todos

    override fun onEvent(event: TodoListEvent) {

    }
}