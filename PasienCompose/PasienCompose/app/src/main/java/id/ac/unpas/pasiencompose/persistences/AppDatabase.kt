package id.ac.unpas.pasiencompose.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.pasiencompose.model.Pasien

@Database(entities = [Pasien::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pasienDao(): PasienDao
}
