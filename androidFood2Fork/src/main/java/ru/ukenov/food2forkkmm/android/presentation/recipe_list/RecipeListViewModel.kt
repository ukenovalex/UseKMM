package ru.ukenov.food2forkkmm.android.presentation.recipe_list;

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class RecipeListViewModel
@Inject
constructor(
        private val savedStateHandle: SavedStateHandle,
): ViewModel()
{

}
