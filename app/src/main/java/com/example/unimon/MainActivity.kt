package com.example.unimon

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
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
import kotlin.math.sqrt

class MainActivity : ComponentActivity(), SensorEventListener {
    private var sensorManager: SensorManager? = null
    private var running: Boolean = false
    private var totalSteps: Float = 0f
//    lateinit var stepsTaken : TextView
    lateinit var stepsTaken : String
    private var previousTotalSteps = 0f
    private var magnitudePreviousStep = 0.0
    
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
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onAccuracyChanged(event: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
//        stepsTaken = findViewById<TextView>(androidx.core.R.id.text)

        if (event!!.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val xaccelerometer: Float = event.values[0]
            val yaccelerometer: Float = event.values[1]
            val zaccelerometer: Float = event.values[2]
            val magnitude: Double = sqrt((xaccelerometer*xaccelerometer+yaccelerometer*yaccelerometer+zaccelerometer*zaccelerometer).toDouble())

            val magnitudeDelta: Double = magnitude - magnitudePreviousStep
            magnitudePreviousStep = magnitude

            if(magnitudeDelta > 6) {
                totalSteps++
            }
            val step: Int = totalSteps.toInt()
            stepsTaken = step.toString()
//            stepsTaken.text = step.toString()
//            var stepBar = Steps()
//            stepBar.apply{setProgressWithAnimation(step.toFloat())}

        } else {
            if(running) {
                totalSteps = event!!.values[0]
                val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()
                stepsTaken = currentSteps.toString()
//                stepsTaken.text = currentSteps.toString()
//                var stepBar = Steps()
//                stepBar.apply{setProgressWithAnimation(step.toFloat())}
            }
        }
    }

    override fun onResume() {
        super.onResume()
        running = true

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        val detectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)
        val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        when {
            countSensor != null -> {
                sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI)
            }
            detectorSensor != null -> {
                sensorManager.registerListener(this, detectorSensor, SensorManager.SENSOR_DELAY_UI)
            }
            accelerometer != null -> {
                sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI)
            }
            else -> {
                Toast.makeText(this, "Auf diesem Gerät konnte kein Sensor gefunden werden", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        running = false
        sensorManager?.unregisterListener(this)
    }

    fun resetSteps() {
        TODO("Nimmt Uhrzeit des Systems und resetet die Schritte immer um 0 Uhr")
    }
}

@Preview
@Composable
fun DefaultPreview() {
    UnimonApp()
}