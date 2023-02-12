package codes.hipporasy.pettoapp.common

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.IgnoredOnParcel

actual interface Parcelable : Parcelable

actual typealias Parcelize = Parcelize

actual typealias IgnoredOnParcel = IgnoredOnParcel