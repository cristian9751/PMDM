package com.cristianpopica.statisticscristian

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cristianpopica.statisticscristian.ui.theme.StatisticsCristianTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatisticsCristianTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content()
                }
            }
        }
    }
}


val add : (Int) -> Int = {num ->
    num + 1
}
fun minusDo(num : Int) : Int {
    if(num > 0) {
        return num -1
    } else {
        return num
    }
}

fun allCounterCalc(persons : Int, scouters : Int, cars : Int) : Int {
    return persons + scouters + cars
}


fun getPrecentage(counter : Int, allCounter : Int) :  Int{
    if(allCounter > 0) {
        return counter * 100 / allCounter
    } else {
        return 0
    }
}


@Composable
fun Content() {
    var personCounter : Int by rememberSaveable { mutableStateOf(0) }
    var scouterCounter : Int by rememberSaveable { mutableStateOf(0) }
    var carCounter : Int by rememberSaveable { mutableStateOf(0) }
    var allCounter : Int by rememberSaveable {
        mutableStateOf(0)
    }

    val red = 0xFFE53935
    val green= 0xFF008f4c

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            fontSize = 35.sp,
            text = "Estadisticas cristian")
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            Text(
                fontSize = 35.sp,
                text = "Total: $allCounter"
            )
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                          allCounter = 0
                    personCounter = 0
                    scouterCounter = 0
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(
                    modifier = Modifier.padding(7.dp),
                    fontSize = 20.sp,
                    text ="Resetear todos")
            }
        }
        Spacer(modifier=Modifier.height(20.dp))
        Text("Personas:")
        Row() {
            Text(
                fontSize = 30.sp,
                text = "$personCounter")
            Spacer(modifier= Modifier.width(10.dp))
            Button(
                onClick = {
                  personCounter = add(personCounter)
                   allCounter =  allCounterCalc(personCounter, scouterCounter, carCounter)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(green)
                )
            ) {
                Text(
                    fontSize = 20.sp,
                    text ="+1")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    personCounter = minusDo(personCounter)
                    allCounter = allCounterCalc(personCounter, scouterCounter, carCounter)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red)
                )
            ) {
                Text(
                    fontSize = 20.sp,
                    text = "-1"
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                          personCounter = 0
                     allCounter = allCounterCalc(personCounter, carCounter, scouterCounter)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(
                    fontSize = 20.sp,
                    text = "Resetear"
                )
            }

        }
        Spacer(modifier=Modifier.height(20.dp))
        Text("Patinetes:")
        Row() {
            Text(
                fontSize = 30.sp,
                text = "$scouterCounter")
            Spacer(modifier= Modifier.width(10.dp))
            Button(
                onClick = {
                    scouterCounter = add(scouterCounter)
                    allCounter =  allCounterCalc(personCounter, scouterCounter, carCounter)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(green)
                )
            ) {
                Text(
                    fontSize = 20.sp,
                    text ="+1")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    scouterCounter = minusDo(scouterCounter)
                    allCounter = allCounterCalc(personCounter, scouterCounter, carCounter)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red)
                )
            ) {
                Text(
                    fontSize = 20.sp,
                    text = "-1"
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    scouterCounter = 0
                    allCounter = allCounterCalc(personCounter, carCounter, scouterCounter)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(
                    fontSize = 20.sp,
                    text = "Resetear"
                )
            }

        }
        Spacer(modifier=Modifier.height(20.dp))
        Text("Coches:")
        Row() {
            Text(
                fontSize = 30.sp,
                text = "$carCounter")
            Spacer(modifier= Modifier.width(10.dp))
            Button(
                onClick = {
                    carCounter = add(carCounter)
                    allCounter =  allCounterCalc(personCounter, carCounter, scouterCounter)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(green)
                )
            ) {
                Text(
                    fontSize = 20.sp,
                    text ="+1")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    carCounter = minusDo(carCounter)
                    allCounter = allCounterCalc(personCounter, carCounter, scouterCounter)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red)
                )
            ) {
                Text(
                    fontSize = 20.sp,
                    text = "-1"
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    carCounter = 0
                    allCounter = allCounterCalc(personCounter, carCounter, scouterCounter)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(
                    fontSize = 20.sp,
                    text = "Resetear"
                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Text("Estadisticas")
        Row {
            Text(text = "Patinetes : ${getPrecentage(scouterCounter, allCounter)} %")
        }
        Row {
            Text(text = "Coches : ${getPrecentage(carCounter, allCounter)}%" )
        }

        Row {
            Text(text = "Personas : ${getPrecentage(personCounter, allCounter)}%")
        }
    }



}