package mx.mauriciogs.consumiendoapi.data.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mx.mauriciogs.consumiendoapi.data.room.db.dbConstants.DATABASE_NAME
import mx.mauriciogs.consumiendoapi.data.room.entity.PersonajeEntity

@Database(entities = [PersonajeEntity::class], version = 1)

abstract class PersonajesFavRoom : RoomDatabase() {
    abstract fun personajesFavDao(): PersonajesFavDao

    companion object{
        @Volatile
        private var INSTANCE:PersonajesFavRoom?=null

        fun getDabase(context:Context):PersonajesFavRoom{
            // Si la instancia no es nula, entonces se retorna
            // Si es nula, se crea la base de datos (en patron Singleton)
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonajesFavRoom::class.java,
                    DATABASE_NAME)
                    // permite a Room recrear las tablas de la BD si las migraciones para migrar
                    // al esquema más reciente no son encontradas
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}