package com.bsuir.todolist.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Task::class],
    version = 2
)
abstract class TaskDatabase: RoomDatabase() {

    abstract val dao: TaskDao
}