package com.bsuir.todolist

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.lifecycle.SavedStateHandle
import com.bsuir.todolist.ui.edit.AddEditTodoScreen
import com.bsuir.todolist.ui.theme.TodoListTheme
import org.junit.Rule
import org.junit.Test

class AddEditTodoScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun checkUIElementsAreDisplayed() {
        val fakeRepository = FakeTaskRepository()
        val fakeViewModel = FakeAddEditTodoViewModel(
            repository = fakeRepository,
            savedStateHandle = SavedStateHandle()
        )

        composeTestRule.setContent {
            TodoListTheme {
                AddEditTodoScreen(
                    onPopBackStack = {},
                    viewModel = fakeViewModel
                )
            }
        }

        composeTestRule.onNodeWithText("Title").assertIsDisplayed()
        composeTestRule.onNodeWithText("Description").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Save").assertIsDisplayed()
    }

    @Test
    fun checkInteractionWithViewModel() {
        val fakeRepository = FakeTaskRepository()
        val fakeViewModel = FakeAddEditTodoViewModel(
            repository = fakeRepository,
            savedStateHandle = SavedStateHandle()
        )

        composeTestRule.setContent {
            TodoListTheme {
                AddEditTodoScreen(
                    onPopBackStack = {},
                    viewModel = fakeViewModel
                )
            }
        }

        composeTestRule.onNodeWithText("Title").performTextInput("New Task Title")
        assert(fakeViewModel.title == "New Task Title")

        composeTestRule.onNodeWithText("Description").performTextInput("New Task Description")
        assert(fakeViewModel.description == "New Task Description")

        composeTestRule.onNodeWithContentDescription("Save").performClick()
        assert(fakeViewModel.isSaveClicked)
    }
}
