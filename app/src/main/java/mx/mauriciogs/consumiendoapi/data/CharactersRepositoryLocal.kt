package mx.mauriciogs.consumiendoapi.data

import androidx.annotation.WorkerThread
import androidx.room.Insert
import mx.mauriciogs.consumiendoapi.data.room.db.PersonajesFavDao
import mx.mauriciogs.consumiendoapi.data.room.entity.PersonajeEntity

class CharactersRepositoryLocal(
    private val personajesDao : PersonajesFavDao
) {
    @WorkerThread
    suspend fun insertPersonajeFavorito(personajeEntity: PersonajeEntity){
        personajesDao.insertPersonaje(personajeEntity)
    }
}