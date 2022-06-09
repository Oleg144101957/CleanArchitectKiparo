package com.vishnevskiypro.cleanarchitectkiparo.domain.repository

import com.vishnevskiypro.cleanarchitectkiparo.domain.models.SaveUserNameParam
import com.vishnevskiypro.cleanarchitectkiparo.domain.models.UserName

interface UserRepository{
    fun saveName(saveUserNameParam: SaveUserNameParam): Boolean
    fun getName(): UserName


}