package id.ac.unpas.pasiencompose.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pasien (
    @PrimaryKey val id: String,
    val nama: String,
    val riwayat: String,
    val kode_dokter: String,
    val alamat : String,
    val no_hp : String
        )
