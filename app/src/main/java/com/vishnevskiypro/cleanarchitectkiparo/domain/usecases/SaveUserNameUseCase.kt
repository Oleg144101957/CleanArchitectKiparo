package com.vishnevskiypro.cleanarchitectkiparo.domain.usecases

import com.vishnevskiypro.cleanarchitectkiparo.domain.models.SaveUserNameParam
import com.vishnevskiypro.cleanarchitectkiparo.domain.repository.UserRepository

class SaveUserNameUseCase(private var userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam) : Boolean {
        if (param.name.isEmpty()){
            return false
        } else {
            return true
        }
    }

}