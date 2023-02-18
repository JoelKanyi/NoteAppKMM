package com.joelkanyi.noteappkmm.android.noteslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joelkanyi.noteappkmm.domain.note.Note
import com.joelkanyi.noteappkmm.domain.time.DateTimeUtil

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NoteItem(
    note: Note,
    onNoteClick: (Note) -> Unit,
    onDeleteClick: (Note) -> Unit,
    modifier: Modifier = Modifier,
) {
    val formattedDate = remember {
        DateTimeUtil.formatNoteDate(note.createdAt)
    }

    Card(
        modifier = modifier.padding(8.dp),
        onClick = { onNoteClick(note) },
        backgroundColor = Color(note.colorHex),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = note.title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                )

                Icon(
                    modifier = Modifier.clickable(MutableInteractionSource(), null) {
                        onDeleteClick(note)
                    },
                    imageVector = Icons.Default.Close,
                    contentDescription = "Delete Note",
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = note.content,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = formattedDate,
                textAlign = TextAlign.End,
                fontSize = 12.sp,
                fontWeight = FontWeight.ExtraLight,
            )
        }
    }
}
