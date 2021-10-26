package dk.tec.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    public TextView txtTrykOK;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTrykOK = findViewById(R.id.txtTrykOK);
        //txtTrykOK.setText("Nu er vi i gang");

        OnClickListener o;

        btnOK = findViewById(R.id.btnOK);
        //btnOK.setOnClickListener(new MyButtonHandler(this));

        btnOK.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view)
            {
                txtTrykOK.setText("Eventhandler Anonymous");
            }
        });

        btnOK.setOnClickListener(view ->
                {
                    txtTrykOK.setText("Eventhandler i Lambda-udtryk");
                });


       // Button b = new TextView(this);
        //TextView tv = new Button(this);

        //btnOK.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view == btnOK){}

        switch(view.getId()) {
            case R.id.btnOK:
                txtTrykOK.setText("Eventhandler i samme klasse");
        }

    }
}

