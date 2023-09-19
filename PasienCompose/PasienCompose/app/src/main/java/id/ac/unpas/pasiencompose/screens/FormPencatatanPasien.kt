package id.ac.unpas.pasiencompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import id.ac.unpas.pasiencompose.model.Pasien
import id.ac.unpas.pasiencompose.persistences.PasienDao
import id.ac.unpas.pasiencompose.ui.theme.Purple700
import id.ac.unpas.pasiencompose.ui.theme.Teal200
import kotlinx.coroutines.launch

@Composable
fun FormPencatatanPasien(pasienDao: PasienDao) {

    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val riwayat = remember { mutableStateOf(TextFieldValue("")) }
    val kode_dokter = remember { mutableStateOf(TextFieldValue("")) }
    val alamat = remember { mutableStateOf(TextFieldValue("")) }
    val no_hp = remember { mutableStateOf(TextFieldValue("")) }

    val scope = rememberCoroutineScope()
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {

        OutlinedTextField(
            label = { Text(text = "Nama") },
            value = nama.value,
            onValueChange = {
                nama.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "XXXXX") }
        )
        OutlinedTextField(
            label = { Text(text = "Riwayat") },
            value = riwayat.value,
            onValueChange = {
                riwayat.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text(text = " ") }
        )
        OutlinedTextField(
            label = { Text(text = "Kode Dokter") },
            value = kode_dokter.value,
            onValueChange = {
                kode_dokter.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text(text = " ") }
        )
        OutlinedTextField(
            label = { Text(text = "Alamat") },
            value = alamat.value,
            onValueChange = {
                alamat.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            placeholder = { Text(text = " ") }
        )
        OutlinedTextField(
            label = { Text(text = "No Handphone") },
            value = no_hp.value,
            onValueChange = {
                no_hp.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "") }
        )
        val loginButtonColors = ButtonDefaults.buttonColors(
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            contentColor = Purple700
        )
        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()
                val item = Pasien(id,  nama.value.text,riwayat.value.text,
                    kode_dokter.value.text, alamat.value.text,no_hp.value.text)
                scope.launch {
                    pasienDao.insertAll(item)
                }
                nama.value = TextFieldValue("")
                riwayat.value = TextFieldValue("")
                kode_dokter.value = TextFieldValue("")
                alamat.value = TextFieldValue("")
                no_hp.value = TextFieldValue("")
            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                nama.value = TextFieldValue("")
                riwayat.value = TextFieldValue("")
                kode_dokter.value = TextFieldValue("")
                alamat.value = TextFieldValue("")
                no_hp.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}