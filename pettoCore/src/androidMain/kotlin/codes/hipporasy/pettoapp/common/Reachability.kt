package codes.hipporasy.pettoapp.common

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build

actual class Reachability(private val context: Context) {

    @SuppressLint("MissingPermission")
    actual fun connectionStatus(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> {
                val cap: NetworkCapabilities =
                    cm.getNetworkCapabilities(cm.activeNetwork) ?: return false
                return cap.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            }
            else -> {
                val networks: Array<NetworkInfo> = cm.allNetworkInfo
                for (nInfo in networks) {
                    if (nInfo.isConnected) return true
                }
            }
        }
        return false
    }

}
