package mx.mauriciogs.consumiendoapi.application

import android.app.Application
import mx.mauriciogs.consumiendoapi.data.CharactersRepositoryLocal
import mx.mauriciogs.consumiendoapi.data.room.db.PersonajesFavRoom

class PersonajesApplication: Application() {
    private val database by lazy {
        PersonajesFavRoom.getDabase(this@PersonajesApplication)
    }
    val repository by lazy { CharactersRepositoryLocal(database.personajesFavDao()) }
}