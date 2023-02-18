package com.joelkanyi.noteappkmm.android.noteslist

import com.joelkanyi.noteappkmm.domain.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false,
)
