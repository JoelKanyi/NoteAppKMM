package com.joelkanyi.noteappkmm.data.note

import com.joelkanyi.noteappkmm.database.NoteDatabase
import com.joelkanyi.noteappkmm.domain.note.Note
import com.joelkanyi.noteappkmm.domain.note.NoteDataSource
import com.joelkanyi.noteappkmm.domain.time.DateTimeUtil

class SqlDelightNoteDataSource(
    db: NoteDatabase,
) : NoteDataSource {

    private val queries = db.noteQueries

    override suspend fun addNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colorHex = note.colorHex,
            dateCreated = DateTimeUtil.toEpochMillis(note.createdAt),
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries.getNoteById(id)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries.getAllNotes()
            .executeAsList()
            .map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteNoteById(id)
    }
}
