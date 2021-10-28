package dk.tec.activitynavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
    TextView txtFromMain;
    EditText txtWriteToMain;
    Button btnGoToMain;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtFromMain = findViewById(R.id.txtFromMain);
        txtWriteToMain = findViewById(R.id.txtWriteToMain);
        btnGoToMain = findViewById(R.id.btnGoToMain);

        intent = getIntent();

        btnGoToMain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent.putExtra("FromSecond",txtWriteToMain.getText().toString());
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
        String strFromMain = intent.getStringExtra(MainActivity.TextFromMain); //"FromMain
        txtFromMain.setText(strFromMain);
    }
}