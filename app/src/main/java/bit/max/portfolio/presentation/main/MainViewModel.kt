package bit.max.portfolio.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bit.max.portfolio.domain.models.InputUserName
import bit.max.portfolio.domain.usecases.GetUserNameUseCase
import bit.max.portfolio.domain.usecases.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
) : ViewModel() {

    private val _fullUserName = MutableLiveData<String>()
    private val _savedSuccessful = MutableLiveData<Boolean?>()

    val fullUserName: LiveData<String> = _fullUserName
    val savedSuccessful: LiveData<Boolean?> = _savedSuccessful

    fun saveUserName(firstName: String, lastName: String) {
        val userName = InputUserName(firstName = firstName, lastName = lastName)
        _savedSuccessful.value = saveUserNameUseCase.execute(inputUserName = userName)

        // Resets completion result to prevent multiple message showing
        _savedSuccessful.value = null
    }

    fun fetchUserName() {
        val userName = getUserNameUseCase.execute()
        val fullName = "${userName.firstName} ${userName.lastName}"
        _fullUserName.postValue(fullName)
    }
}