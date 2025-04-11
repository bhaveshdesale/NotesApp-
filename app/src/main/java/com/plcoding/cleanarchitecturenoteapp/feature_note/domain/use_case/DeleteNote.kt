package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
//Use Cases are like bridges between ViewModel and the Repository.
// ViewModel → UseCase → Repository → DAO → DB works.
//Layer	Role
//ViewModel->	Handles UI & state
//Use Case->	Executes specific business logic
//Repository->	Talks to data sources (DB, network, etc.)
class DeleteNote(
    private val repository: NoteRepository
)
{
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)

    }
}