@file:OptIn(ExperimentalMaterial3Api::class)

package com.cristianpopica.singincristian.ui
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.Calendar


val actionMovies = listOf("Die Hard", "Mad Max", "The Dark Knight", "John Wick", "Mission: Impossible")
val nameRegex = Regex("^[A-Z]+[a-z]\$")
val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
val phoneRegex = Regex("^\\d{9}\$")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterForm() {

    var name by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var birthDate = rememberDatePickerState(initialSelectedDateMillis = Calendar.getInstance().timeInMillis)
    var scrollState = rememberScrollState(0)


   Column(
       modifier = Modifier
           .fillMaxSize()
           .padding(10.dp)
           .verticalScroll(scrollState)
   ){
       customInputField(valid =  validateField(name, nameRegex) ,
           errorString = "Solo puede contener mayusculas y minusculas. Debe comenzar con mayuscula",
           value = name,
           label = "Nombre")
       { name = it }
       customInputField(
           valid =  validateField(lastName, nameRegex),
           errorString = "Solo puede contener mayusculas y minusculas. Debe comenzar con mayuscula",
           value = lastName,
           label = "Apellidos",
           onValueChange = {
           lastName = it
       })
       customInputField(
           valid =  validateField(email, emailRegex),
           errorString = "Introduce un correo electronico valido. Ejemplo: jhon@doe.com",
           value = email,
           label = "Correo electronico",
           onValueChange = {
           email = it
       } )
       customInputField(valid =  validateField(phoneNumber, phoneRegex), errorString = "", value = phoneNumber, label = "Telefono", onValueChange =  {
           phoneNumber = it
       })
       DatePicker(state = birthDate, showModeToggle = true)

       Row {
           Button(onClick = {
               name = "";
               lastName = "";
               email = "";
               phoneNumber = ""
           }) {
               Text(text = "Resetear")
           }

           Button(onClick = {
           }) {
               Text(text = "Enviar")
           }
       }
   }


}

@Composable
fun customInputField(valid : Boolean, errorString : String,  value : String, label: String, onValueChange: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "$label")

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Icon(imageVector = Icons.Default.Person, contentDescription = "Icono")
            TextField(
                isError = !valid,
                modifier = Modifier.fillMaxWidth(),
                value = value,
                onValueChange = onValueChange)


        }

        if(!valid) {
            Text(
                text = errorString)
        }


    }
}

fun validateField(
    value : String,
    regex : Regex
): Boolean {
    return value.matches(regex)
}


