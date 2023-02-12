package codes.hipporasy.pettoapp.common

import platform.Foundation.NSUserDefaults

actual class PreferenceManager {
    private val userDefault: NSUserDefaults = NSUserDefaults(suiteName = SUITE_NAME)

    companion object {
        private const val SUITE_NAME = "Store.Core.UserDefaults"
        private const val AUTHORIZATION_TOKEN = "Store.Core.Authorization.Token"
    }

    actual var token: String?
        get() = userDefault.stringForKey(AUTHORIZATION_TOKEN)
        set(value) {
            userDefault.setObject(value, AUTHORIZATION_TOKEN)
        }
}
