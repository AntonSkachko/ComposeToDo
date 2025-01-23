package com.bsuir.todolist.data

import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val dao: TaskDao
) : TaskRepository {

    override suspend fun insertTodo(task: Task) {
        dao.insertTask(task)
    }

    override suspend fun deleteTodo(task: Task) {
        dao.deleteTask(task)
    }

    override suspend fun getTodoById(id: Int): Task? {
        return dao.getTaskById(id)
    }

    override fun getTodos(): Flow<List<Task>> {
        return dao.getTasks()
    }
}