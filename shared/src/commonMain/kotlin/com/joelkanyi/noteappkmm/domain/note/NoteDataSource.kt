package com.joelkanyi.noteappkmm.domain.note

interface NoteDataSource {
    suspend fun addNote(note: Note)
    suspend fun getNoteById(id: Long): Note?
    suspend fun getAllNotes(): List<Note>
    suspend fun deleteNoteById(id: Long)
}
