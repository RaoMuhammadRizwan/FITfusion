package com.example.fitfusion.Diet

import android.os.Parcel
import android.os.Parcelable

data class DietPlan(
    val name: String,
    val imageResId: Int,
    val overview: String,
    val healthBenefits: String,
    val otherBenefits: String,
    val downsides: String,
    val websiteUrl: String?,
    val youtubeUrl: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(imageResId)
        parcel.writeString(overview)
        parcel.writeString(healthBenefits)
        parcel.writeString(otherBenefits)
        parcel.writeString(downsides)
        parcel.writeString(websiteUrl)
        parcel.writeString(youtubeUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DietPlan> {
        override fun createFromParcel(parcel: Parcel): DietPlan {
            return DietPlan(parcel)
        }

        override fun newArray(size: Int): Array<DietPlan?> {
            return arrayOfNulls(size)
        }
    }
}
