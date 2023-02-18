package com.joelkanyi.noteappkmm.domain.note

import com.joelkanyi.noteappkmm.presentation.BabyBlueHex
import com.joelkanyi.noteappkmm.presentation.LightGreenHex
import com.joelkanyi.noteappkmm.presentation.RedOrangeHex
import com.joelkanyi.noteappkmm.presentation.RedPinkHex
import com.joelkanyi.noteappkmm.presentation.VioletHex
import kotlinx.datetime.LocalDateTime

data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val createdAt: LocalDateTime,
) {
    companion object {
        private val colors = listOf(RedOrangeHex, RedPinkHex, BabyBlueHex, VioletHex, LightGreenHex)

        fun randomColor(): Long {
            return colors.random()
        }
    }
}
