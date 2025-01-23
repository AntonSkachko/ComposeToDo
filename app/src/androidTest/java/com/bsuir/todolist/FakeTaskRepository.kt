package com.bsuir.todolist


import com.bsuir.todolist.data.Task
import com.bsuir.todolist.data.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeTaskRepository : TaskRepository {

    private val todos = MutableStateFlow<List<Task>>(emptyList())

    override fun getTodos(): Flow<List<Task>> {
        return todos
    }

    override suspend fun insertTodo(task: Task) {
        todos.value = todos.value + task
    }

    override suspend fun deleteTodo(task: Task) {
        todos.value = todos.value.filter { it.id != task.id }
    }

    override suspend fun getTodoById(id: Int): Task? {
        TODO("Not yet implemented")
    }

    fun setInitialData(tasks: List<Task>) {
        todos.value = tasks
    }
}
