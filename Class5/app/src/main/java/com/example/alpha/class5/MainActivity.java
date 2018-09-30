package com.example.alpha.class5;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView senX, senY, senZ, sen_mX, sen_mY, sen_mZ;
    SensorManager sensorManager;
    Sensor accel, mag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        senX = findViewById(R.id.sen1);
        senY = findViewById(R.id.sen2);
        senZ = findViewById(R.id.sen3);

        sen_mX = findViewById(R.id.sen_m1);
        sen_mY = findViewById(R.id.sen_m2);
        sen_mZ = findViewById(R.id.sen_m3);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accel != null){
            sensorManager.registerListener(MainActivity.this, accel, SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            senY.setText("Accelerometer not supported");
        }

        mag = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (mag != null){
            sensorManager.registerListener(MainActivity.this, mag, SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            sen_mY.setText("Magnetometer not supported");
        }


    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        Sensor sens = event.sensor;

/*
        senX.setText("AxisX: " + event.values[0]);
        senY.setText("AxisY: " + event.values[1]);
        senZ.setText("AxisZ: " + event.values[2]);
*/
        if (sens.getType() == Sensor.TYPE_ACCELEROMETER){
            senX.setText("AxisX: " + event.values[0]);
            senY.setText("AxisY: " + event.values[1]);
            senZ.setText("AxisZ: " + event.values[2]);

        } if (sens.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            sen_mX.setText("AxisX: " + event.values[0]);
            sen_mY.setText("AxisY: " + event.values[0]);
            sen_mZ.setText("AxisZ: " + event.values[0]);

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
