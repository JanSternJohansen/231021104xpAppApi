package dk.tec.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    public TextView txtTrykOK;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTrykOK = findViewById(R.id.txtTrykOK);
        //txtTrykOK.setText("Nu er vi i gang");

        View.OnClickListener o;

        Button btnOK = findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new MyButtonHandler(this));

    }
}

