package com.namu.oauth

import android.app.Activity
import android.content.Context
import com.namu.oauth.naver.NaverOAuthClient
import io.reactivex.Single

object OAuthManager {

    fun loginByKakao() {

    }

    fun loginByNaver(applicationContext: Context, activity: Activity): Single<Boolean> {
        return NaverOAuthClient(applicationContext).login(activity)
    }

    fun loginByFacebook() {

    }

    fun loginByGoogle() {

    }

}