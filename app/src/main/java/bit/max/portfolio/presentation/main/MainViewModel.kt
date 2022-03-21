package bit.max.portfolio.presentation.main

import androidx.lifecycle.ViewModel
import bit.max.portfolio.domain.models.InputUserName
import bit.max.portfolio.domain.usecases.GetUserNameUseCase
import bit.max.portfolio.domain.usecases.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
) : ViewModel() {


    fun saveUserName(firstName: String, lastName: String) {
        val userName = InputUserName(firstName = firstName, lastName = lastName)
        val savedSuccessful = saveUserNameUseCase.execute(inputUserName = userName)

    }

    fun fetchUserName() {
        val userName = getUserNameUseCase.execute()

    }
}