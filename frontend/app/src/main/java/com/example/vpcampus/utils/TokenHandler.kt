package com.example.vpcampus.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.vpcampus.MainActivity
import com.example.vpcampus.models.Tokens
import org.json.JSONException

class TokenHandler {

    companion object{

        private var prefs:SharedPreferences? = null
        private var edit:SharedPreferences.Editor?= null

        fun getTokens(context: Context): Map<String,String> {
            prefs = context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            val accessToken: String = prefs?.getString(Constants.ACCESS_TOKEN, "")!!
            val refreshToken: String = prefs?.getString(Constants.REFRESH_TOKEN, "")!!

            val tokens = HashMap<String,String>()

            tokens[Constants.AUTHORIZATION] = accessToken
            tokens[Constants.REFRESH_TOKEN] = refreshToken

            return tokens

        }


        fun saveTokenInSharedPreference(context: Context, tokens: Tokens){
            prefs= context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            edit= prefs?.edit()
            try {
                edit?.putString("accessToken", tokens.accessToken)
                edit?.putString("refreshToken", tokens.refreshToken)
                edit?.apply()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }

    }

}