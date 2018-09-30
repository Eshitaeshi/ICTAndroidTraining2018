package com.example.alpha.class5_project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView senX, senY, senZ, sen_mX, sen_mY, sen_mZ, light_view, prox_view;
    SensorManager sensorManager;
    Sensor accel, mag, prox, light;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Accelerometer
        senX = findViewById(R.id.senX);
        senY = findViewById(R.id.senY);
        senZ = findViewById(R.id.senZ);
//        Magnetometer
        sen_mX = findViewById(R.id.sen_mX);
        sen_mY = findViewById(R.id.sen_mY);
        sen_mZ = findViewById(R.id.sen_mZ);
//        Light
        light_view = findViewById(R.id.light);
//        Prox
        prox_view = findViewById(R.id.prox);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        Accelerometer Sensor Init
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accel != null){
            sensorManager.registerListener(MainActivity.this, accel, SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            senY.setText("Accelerometer not supported");
        }
//        Magnetometer Sensor Init
        mag = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (accel != null){
            sensorManager.registerListener(MainActivity.this, mag, SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            senY.setText("Magnetometer not supported");
        }
//        Accelerometer Sensor Init
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (accel != null){
            sensorManager.registerListener(MainActivity.this, light, SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            senY.setText("Light sensor not supported");
        }
//        Accelerometer Sensor Init
        prox = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (accel != null){
            sensorManager.registerListener(MainActivity.this, prox, SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            senY.setText("Temperature not supported");
        }

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sens = event.sensor;

        if (sens.getType() == Sensor.TYPE_ACCELEROMETER){
            senX.setText("AxisX: " + event.values[0]);
            senY.setText("AxisY: " + event.values[1]);
            senZ.setText("AxisZ: " + event.values[2]);
        } if (sens.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            sen_mX.setText("AxisX: " + event.values[0]);
            sen_mY.setText("AxisY: " + event.values[1]);
            sen_mZ.setText("AxisZ: " + event.values[2]);
        } if(sens.getType() == Sensor.TYPE_LIGHT){
            light_view.setText("Light: " + Arrays.toString(event.values));
        } if(sens.getType() == Sensor.TYPE_PROXIMITY){
            prox_view.setText("Proximity: " + Arrays.toString(event.values));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
