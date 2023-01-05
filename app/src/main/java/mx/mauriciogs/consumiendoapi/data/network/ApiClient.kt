package mx.mauriciogs.consumiendoapi.data.network

import mx.mauriciogs.consumiendoapi.data.model.Characters
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    /*
        Método para obtener todos los personajes de una página cualquiera, esta llega como
        parametro Int al llamar a getAllCharacters()
     */
    @GET("character")
    suspend fun getAllCharacters( @Query("page") page: Int): Characters

    // Agregar método para obtener sólo un personaje (character) enviando el id de dicho personaje
    @GET("character/{id}")
    suspend fun getOneCharacter( @Path("id") id: Int): mx.mauriciogs.consumiendoapi.data.model.Character

}