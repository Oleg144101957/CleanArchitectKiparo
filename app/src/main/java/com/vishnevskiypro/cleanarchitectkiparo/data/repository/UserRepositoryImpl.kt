package com.vishnevskiypro.cleanarchitectkiparo.data.repository

import android.content.Context
import com.vishnevskiypro.cleanarchitectkiparo.domain.models.SaveUserNameParam
import com.vishnevskiypro.cleanarchitectkiparo.domain.models.UserName
import com.vishnevskiypro.cleanarchitectkiparo.domain.repository.UserRepository

private const val SHARED_PREF_NAME = "shared_ref"
private const val KEY_FISRST_NAME = "firstName_ref"
private const val KEY_LAST_NAME = "lastName_ref"
private const val DEFAULT_NAME = "Default last name"

class UserRepositoryImpl(context: Context) : UserRepository{

    private val sharedPref = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveUserNameParam: SaveUserNameParam): Boolean{
        sharedPref.edit().putString(KEY_FISRST_NAME, saveUserNameParam.name).apply()
        return true
    }

    override fun getName(): UserName{
        val firstName = sharedPref.getString(KEY_FISRST_NAME, "") ?: ""
        val lastName = sharedPref.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME

        return UserName(firstName = firstName, lastName = lastName)
    }

}