package com.vishnevskiypro.cleanarchitectkiparo.domain.usecases

import com.vishnevskiypro.cleanarchitectkiparo.domain.models.UserName
import com.vishnevskiypro.cleanarchitectkiparo.domain.repository.UserRepository


class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName{

        return userRepository.getName()
    }
}