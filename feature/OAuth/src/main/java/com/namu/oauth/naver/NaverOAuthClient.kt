package com.namu.oauth.naver

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import com.nhn.android.naverlogin.OAuthLogin
import com.nhn.android.naverlogin.OAuthLoginHandler
import io.reactivex.Single

class NaverOAuthClient(
    private val context: Context
) {

    private val naverOAuthModule = OAuthLogin.getInstance()
    private val clientId = "HttOc833Mu7x6gZM7TjE"
    private val clientSecret = "AbI4a5b18y"
    private val applicationName = "SimpleTodo"

    init {
        naverOAuthModule.init(
            context,
            clientId,
            clientSecret,
            applicationName
        )
    }

    fun login(activity: Activity): Single<Boolean> {
        return Single.create { singleEmitter ->
            try {
                naverOAuthModule.startOauthLoginActivity(
                    activity,
                    @SuppressLint("HandlerLeak")
                    object : OAuthLoginHandler() {
                        override fun run(success: Boolean) {
                            singleEmitter.onSuccess(success)
                        }
                    }
                )
            } catch (exception: Exception) {
                singleEmitter.onError(exception)
            }
        }
    }

    fun logout() {
        naverOAuthModule.logout(context)
    }

}