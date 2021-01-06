package com.namu.simpletodo.ui.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.viewbinding.library.activity.viewBinding
import androidx.appcompat.app.AppCompatActivity
import com.namu.oauth.OAuthManager
import com.namu.simpletodo.databinding.ActivityLoginBinding
import io.reactivex.rxkotlin.subscribeBy

class LoginActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "LoginActivity"
    }

    private val viewBinding: ActivityLoginBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.buttonNaverLogin.setOnClickListener {
            OAuthManager.loginByNaver(this, this)
                .subscribeBy(
                    onSuccess = { aBoolean ->
                        Log.d(TAG, "onCreate() called with: aBoolean = $aBoolean")
                    },
                    onError = { exception ->
                        Log.d(TAG, "onCreate() called with: exception = $exception")
                    }
                )
        }
    }

}