package com.quizzapp.Question.Model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class QuestionModel(
    val id: Int,
    val question: String?,
    val answer1: String?,
    val answer2: String?,
    val answer3: String?,
    val answer4: String?,
    val correctAnswer : String?,
    val score: Int,
    val picPath: String?,
    val clickedAnswer : String?
) : Parcelable
