package com.vishnevskiypro.cleanarchitectkiparo.presantation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vishnevskiypro.cleanarchitectkiparo.data.repository.UserRepositoryImpl
import com.vishnevskiypro.cleanarchitectkiparo.databinding.ActivityMainBinding
import com.vishnevskiypro.cleanarchitectkiparo.domain.models.SaveUserNameParam
import com.vishnevskiypro.cleanarchitectkiparo.domain.models.UserName
import com.vishnevskiypro.cleanarchitectkiparo.domain.usecases.GetUserNameUseCase
import com.vishnevskiypro.cleanarchitectkiparo.domain.usecases.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val userRepository by lazy (LazyThreadSafetyMode.NONE){ UserRepositoryImpl(context = applicationContext) }
    //private val getUserNameUseCase by lazy {GetUserNameUseCase(userRepository = userRepository)}
    //private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = userRepository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.getData.setOnClickListener {
            val userName: UserName = userRepository.getName()
            binding.displayText.text = "${userName.firstName} ${userName.lastName}"

        }

        binding.saveData.setOnClickListener {
            val text = binding.inputText.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = userRepository.saveName(params)
            binding.displayText.text = "Save result = $result"
        }


    }
}