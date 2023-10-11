package codes.hipporasy.pettoapp.common

import kotlinx.cinterop.UIntVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.cValue
import kotlinx.cinterop.convert
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.reinterpret
import kotlinx.cinterop.sizeOf
import kotlinx.cinterop.value
import platform.CoreFoundation.CFRelease
import platform.CoreFoundation.kCFAllocatorDefault
import platform.SystemConfiguration.SCNetworkReachabilityCreateWithAddress
import platform.SystemConfiguration.SCNetworkReachabilityGetFlags
import platform.SystemConfiguration.SCNetworkReachabilityRef
import platform.SystemConfiguration.kSCNetworkReachabilityFlagsConnectionOnDemand
import platform.SystemConfiguration.kSCNetworkReachabilityFlagsConnectionOnTraffic
import platform.SystemConfiguration.kSCNetworkReachabilityFlagsConnectionRequired
import platform.SystemConfiguration.kSCNetworkReachabilityFlagsInterventionRequired
import platform.SystemConfiguration.kSCNetworkReachabilityFlagsIsWWAN
import platform.SystemConfiguration.kSCNetworkReachabilityFlagsReachable
import platform.posix.AF_INET
import platform.posix.sockaddr_in

actual class Reachability {

    private var _reachabilityRef: SCNetworkReachabilityRef? = null

    fun finalize() {
        if (_reachabilityRef != null) {
            CFRelease(_reachabilityRef)
        }
    }


    actual fun connectionStatus(): Boolean {
        val flags = getFlags() ?: return false

        if ((flags and kSCNetworkReachabilityFlagsReachable) == 0u) {
            return false
        }

        if ((flags and kSCNetworkReachabilityFlagsConnectionRequired) == 0u) {
            return true
        }

        if ((((flags and kSCNetworkReachabilityFlagsConnectionOnDemand) != 0u) ||
                    (flags and kSCNetworkReachabilityFlagsConnectionOnTraffic) != 0u)
        ) {
            if ((flags and kSCNetworkReachabilityFlagsInterventionRequired) == 0u) {
                return true
            }
        }

        if ((flags and kSCNetworkReachabilityFlagsIsWWAN) == kSCNetworkReachabilityFlagsIsWWAN) {
            return true
        }
        return false
    }

    private fun getFlags(): UInt? {
        return memScoped {
            val flag = alloc<UIntVar>()
            if (!SCNetworkReachabilityGetFlags(_reachabilityRef, flag.ptr)) {
                return null
            }
            flag.value
        }
    }

    companion object {
        fun reachabilityForInternetConnection(): Reachability {
            val zeroAddress = cValue<sockaddr_in> {
                sin_len = sizeOf<sockaddr_in>().convert()
                sin_family = AF_INET.convert()
            }
            val reachability = memScoped {
                SCNetworkReachabilityCreateWithAddress(
                    kCFAllocatorDefault,
                    zeroAddress.ptr.reinterpret()
                )
            }
            var returnedValue: Reachability? = null

            if (reachability != null) {
                returnedValue = Reachability()
                returnedValue._reachabilityRef = reachability
            } else {
                CFRelease(reachability)
            }
            return returnedValue!!
        }
    }

}