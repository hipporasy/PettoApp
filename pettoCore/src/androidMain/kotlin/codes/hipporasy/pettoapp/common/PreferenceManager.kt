package codes.hipporasy.pettoapp.common

import android.content.Context
import android.content.SharedPreferences

actual class PreferenceManager(context: Context) {

    private val preferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    companion object {
        private const val PREF_NAME = "Store.Core.Android.Preferences"
        private const val AUTHORIZATION_TOKEN = "Store.Core.Authorization.Token"
    }

    actual var token: String?
        get() = preferences.getString(AUTHORIZATION_TOKEN, "")
        set(value) {
            preferences
                .edit()
                .putString(AUTHORIZATION_TOKEN, value)
                .apply()
        }

}
