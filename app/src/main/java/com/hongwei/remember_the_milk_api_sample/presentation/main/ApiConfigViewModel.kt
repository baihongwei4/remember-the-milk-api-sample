package com.hongwei.remember_the_milk_api_sample.presentation.main

import androidx.lifecycle.MutableLiveData
import com.hongwei.remember_the_milk_api_sample.ApiConfig.Validation.LENGTH_API_KEY
import com.hongwei.remember_the_milk_api_sample.ApiConfig.Validation.LENGTH_SHARED_SECRET
import com.hongwei.remember_the_milk_api_sample.domain.usecase.SaveApiConfigUseCase
import com.hongwei.remember_the_milk_api_sample.presentation.base.BaseViewModel
import javax.inject.Inject

class ApiConfigViewModel @Inject constructor() : BaseViewModel() {
    companion object {
        const val TAG = "rtm.api-config"
    }

    @Inject
    lateinit var saveApiCondigUseCase: SaveApiConfigUseCase

    val buttonEnableState: MutableLiveData<Boolean> = MutableLiveData()

    fun validate(apiKey: String, secret: String) {
        buttonEnableState.value = LENGTH_API_KEY == apiKey.trim().length && LENGTH_SHARED_SECRET == secret.trim().length
    }

    fun submit(activity: ApiConfigActivity, apiKey: String, secret: String) {
        saveApiCondigUseCase.execute(apiKey, secret)

        activity.finish()
    }
}