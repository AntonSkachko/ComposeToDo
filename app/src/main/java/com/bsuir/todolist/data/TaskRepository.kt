package com.bsuir.todolist.data

import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun insertTodo(task: Task)

    suspend fun deleteTodo(task: Task)

    suspend fun getTodoById(id: Int): Task?

    fun getTodos(): Flow<List<Task>>
}