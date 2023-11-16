@file:OptIn(ExperimentalMaterial3Api::class)

package com.cristianpopica.singincristian.ui.Screens
import android.icu.text.SimpleDateFormat
import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.*
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import java.util.Calendar
import java.util.Locale




val nameRegex = Regex("^([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+)(\\s+([A-Za-zÑñÁáÉéÍíÓóÚú]+['\\-]{0,1}[A-Za-zÑñÁáÉéÍíÓóÚú]+))*\$")
val emailRegex = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
val phoneRegex = Regex("^\\d{9}\$")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun appContent() {

    var name by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var birthDate = rememberDatePickerState(initialSelectedDateMillis = Calendar.getInstance().timeInMillis)
    var scrollState = rememberScrollState(0)

    var buttonSubmitEnabled by rememberSaveable {
        mutableStateOf(false)
    }
    var showAlertDialog by rememberSaveable {
        mutableStateOf(false)
    }


   Column(

       modifier = Modifier
           .padding(10.dp)
           .verticalScroll(scrollState)
   ){
       Row(
           verticalAlignment = Alignment.CenterVertically
       ) {
           //Chips
       }
       customInputField(
           ImageVectorIcon = Icons.Default.Person,
           valid =  validateField(name, nameRegex) ,
           errorString = "Solo puede contener mayusculas, minusculas. Debe comenzar con mayuscula",
           value = name,
           label = "Nombre")
       {
           name = it
           buttonSubmitEnabled = validateFields(name, lastName, email, phoneNumber)
       }
       customInputField(
           ImageVectorIcon = Icons.Default.Person,
           valid =  validateField(lastName, nameRegex),
           errorString = "Solo puede contener mayusculas, minusculas. Debe comenzar con mayuscula",
           value = lastName,
           label = "Apellidos",
           onValueChange = {
           lastName = it
               buttonSubmitEnabled = validateFields(name, lastName, email, phoneNumber)
       })
       customInputField(
           ImageVectorIcon = Icons.Default.Email,
           valid =  validateField(email, emailRegex),
           errorString = "Introduce un correo electronico valido. Ejemplo: jhon@doe.com",
           value = email,
           label = "Correo electronico",
           onValueChange = {
               email = it
           buttonSubmitEnabled = validateFields(name, lastName, email, phoneNumber)
       } )
       customInputField(
           ImageVectorIcon = Icons.Default.Phone,
           valid =  validateField(phoneNumber, phoneRegex),
           errorString = "Debes introducir un numero con nueve digitos",
           value = phoneNumber,
           label = "Telefono",
           onValueChange =  {
           phoneNumber = it
               buttonSubmitEnabled = validateFields(name, lastName, email, phoneNumber)
       })

           DatePicker(state = birthDate, showModeToggle = true)

       Row {
           Button(onClick = {
               name = "";
               lastName = "";
               email = "";
               phoneNumber = ""
               birthDate.selectedDateMillis = Calendar.getInstance().timeInMillis
           }) {
               Text(text = "Resetear")
           }

           Button(
               enabled = buttonSubmitEnabled,
               onClick = {
                   showAlertDialog = !showAlertDialog
           }
           ) {
               Text(text = "Enviar")
           }


       }
   }

    if(showAlertDialog) {
        AlertDialog(
            onDismissRequest = {
                Log.i("Alerta", "Se ha cerrado")
                showAlertDialog = false
            },
            confirmButton = {
                TextButton(onClick = {
                    Log.i("Alerta", "Se ha aceptado")
                    showAlertDialog = false
                }) {
                    Text(text = "Aceptar")
                }
            },
            text = {
                Text(text ="""
               |Nombre $name
               |Apellidos $lastName
               |Correo electronico $email
               |Telefono $phoneNumber
               |Fecha nacimiento: ${SimpleDateFormat("dd/MM/yy", Locale.getDefault()).format(birthDate.selectedDateMillis)}
               
            """.trimMargin())
            }
        )
    }

}
@Composable
fun customInputField(ImageVectorIcon : ImageVector, valid : Boolean, errorString : String, value : String, label: String, onValueChange: (String) -> Unit) {
    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(text = "$label")

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Icon(
                modifier = Modifier.align(Alignment.CenterVertically),
                imageVector = ImageVectorIcon,
                contentDescription = "Icono")
            TextField(
                isError = !valid && value != "",
                modifier = Modifier.fillMaxWidth(),
                value = value,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                onValueChange = onValueChange)


        }

        if(!valid && value != "") {
            Text(
                color = Color.Red,
                text = errorString)
        }


    }
}

fun validateField(
    value : String,
    regex : Regex,
): Boolean {
    return value.matches(regex)
}

fun validateFields(
    name : String,
    lastName : String,
    email : String,
    phoneNumber : String
): Boolean {
    val validName = validateField(name, nameRegex)
    val validLastName = validateField(lastName, nameRegex)
    val validEmail = validateField(email, emailRegex)
    val validPhoneNumber = validateField(phoneNumber, phoneRegex)
    return validName && validLastName && validEmail && validPhoneNumber
}