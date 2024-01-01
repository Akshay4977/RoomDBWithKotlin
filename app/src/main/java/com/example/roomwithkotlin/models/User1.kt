package com.example.roomwithkotlin.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "user")
data class User1(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age: Int
) : Parcelable