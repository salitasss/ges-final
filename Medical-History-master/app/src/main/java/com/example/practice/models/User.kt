//replaced data class SleepNight with data class User
//replaced kotlinx.android,parcel.Parcelize with kotlinx.parcelize.Parcelize
//breaks when @ColumnInfo added
package com.example.practice.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val stat_id: Int,
    val date_tv: String,
    val weight_tv: String,
    val hour_tv: String,
    val colon_tv: String,
    val minutes_tv: String,
    val bg_tv: String,
    val systolic_tv: String,
    val slash_tv: String,
    val diastolic_tv: String,
    val med1_tv: String,
    val med2_tv: String,
    val med3_tv: String,
    val med4_tv: String,
    val med5_tv: String,
    val med6_tv: String,
    val med7_tv: String,
    val med8_tv: String,
    val med9_tv: String,
    val med10_tv: String,
    val comment_tv: String
): Parcelable