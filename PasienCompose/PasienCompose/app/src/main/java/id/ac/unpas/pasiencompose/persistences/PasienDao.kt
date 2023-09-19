package id.ac.unpas.pasiencompose.persistences

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.ac.unpas.pasiencompose.model.Pasien

@Dao
interface PasienDao {

    @Query("SELECT * FROM Pasien")
    fun loadAll() : LiveData<List<Pasien>>

    @Query("SELECT * FROM Pasien WHERE id = :id")
    fun find(id: String): Pasien?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: Pasien)

    @Delete
    fun delete(item: Pasien)
}