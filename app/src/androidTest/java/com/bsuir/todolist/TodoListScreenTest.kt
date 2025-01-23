package com.bsuir.todolist

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.bsuir.todolist.data.Task
import com.bsuir.todolist.ui.list.TodoListScreen
import com.bsuir.todolist.ui.theme.TodoListTheme
import org.junit.Rule
import org.junit.Test

class TodoListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testTodoListScreenDisplaysTasks() {
        val fakeRepository = FakeTaskRepository().apply {
            setInitialData(
                listOf(
                    Task("Task 1", "Description 1", false),
                    Task("Task 2", "Description 2", true)
                )
            )
        }
        val viewModel = FakeTodoListViewModel(fakeRepository)

        composeTestRule.setContent {
            TodoListTheme {
                TodoListScreen(
                    onNavigate = {},
                    viewModel = viewModel
                )
            }
        }

        composeTestRule.onNodeWithText("Task 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Description 1").assertIsDisplayed()
    }

    @Test
    fun testFloatingActionButtonIsClickable() {
        val fakeRepository = FakeTaskRepository()
        val viewModel = FakeTodoListViewModel(fakeRepository)

        composeTestRule.setContent {
            TodoListTheme {
                TodoListScreen(
                    onNavigate = {},
                    viewModel = viewModel
                )
            }
        }

        composeTestRule.onNodeWithContentDescription("Add").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Add").performClick()
    }
}
