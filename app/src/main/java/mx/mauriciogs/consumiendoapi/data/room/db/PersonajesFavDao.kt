package mx.mauriciogs.consumiendoapi.data.room.db

import androidx.room.*
import mx.mauriciogs.consumiendoapi.data.room.db.dbConstants.DATABASE_PFAVORITES_TABLE
import mx.mauriciogs.consumiendoapi.data.room.entity.PersonajeEntity

@Dao
interface PersonajesFavDao {
    @Insert
    suspend fun insertPersonaje(personajeEntity: PersonajeEntity)

    @Query("SELECT * FROM $DATABASE_PFAVORITES_TABLE")
    fun getAllFavorites(): List<PersonajeEntity>

    @Update
    suspend fun updateFavorites(personajeEntity: PersonajeEntity)

    @Delete
    suspend fun deleteFavorites(personajeEntity: PersonajeEntity)

}

object dbConstants{
    const val DATABASE_NAME="personajes_favoritos_room"
    const val DATABASE_PFAVORITES_TABLE="personajes_favoritos"
}