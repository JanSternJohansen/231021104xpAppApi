package dk.tec.sensorsacceleration;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SensorEventListener
{
    SensorManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (SensorManager)getSystemService(this.SENSOR_SERVICE);

        manager.registerListener(
                this,
                manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                300000);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)
    {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            // Løfter højre side +, løfter venstre side -.
            Log.d("Sensor", "XY: " + String.format("%10.2f", sensorEvent.values[0]));
            // Løfter top +, løfter bund -
            //Log.d("Sensor", "XZ: " + String.format("%10.2f", sensorEvent.values[1]));
            //Log.d("Sensor", "ZY: " + String.format("%10.2f",sensorEvent.values[2]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {    }
}