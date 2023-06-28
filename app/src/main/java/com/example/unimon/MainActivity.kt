package com.example.unimon

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unimon.ui.UnimonApp
import com.example.unimon.ui.theme.TestTheme
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity(), SensorEventListener {
    private val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private var running: Boolean = false

    private var totalSteps = 0f
    private var previousTotalSteps = 0f
    private val stepsTaken: TextView = findViewById(androidx.core.R.id.text)

    val sdf = SimpleDateFormat("dd-mm-yyyy")
    private var oldDate = sdf.format(Date())

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnimonApp()
                }
            }
        }

        oldDate = sdf.format(Date())
        resetSteps()
//        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onAccuracyChanged(event: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
            if (running) {
                totalSteps = event!!.values[0]
                val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()
                stepsTaken.text = ("$currentSteps")
            }
        }

    override fun onResume() {
        super.onResume()
        running = true

//        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val stepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepCounterSensor != null) {
            sensorManager.registerListener(this, stepCounterSensor, SensorManager.SENSOR_DELAY_UI)
        } else {
            Toast.makeText(this,"Auf diesem Gerät konnte kein Sensor gefunden werden", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
        running = false
        sensorManager.unregisterListener(this)
    }

    private fun resetSteps() {
        val currentDate = sdf.format(Date())
        val compared = currentDate.compareTo(oldDate)
        if (compared > 0) {
            stepsTaken.text = ("0")
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    UnimonApp()
}