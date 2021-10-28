package dk.tec.activitynavigation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtFromSecond;
    EditText txtWriteToSecond;
    Button btnGoToSecond;

    public static final String TextFromMain = "FromMain";
    public static final int REQUEST_SECOND = 1;
    public static final int REQUEST_THIRD= 2;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFromSecond = findViewById(R.id.txtFromSecond);
        txtWriteToSecond = findViewById(R.id.txtWriteToSecond);
        btnGoToSecond = findViewById(R.id.btnGoToSecond);

        btnGoToSecond.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);

        //String text = txtWriteToSecond.getText().toString();
        //intent.putExtra("FromMain", text);

        intent.putExtra(TextFromMain, txtWriteToSecond.getText().toString());
        //startActivity(intent);
        startActivityForResult(intent, REQUEST_SECOND);
        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_SECOND)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                String strFromSecond = data.getStringExtra("FromSecond");
                txtFromSecond.setText(strFromSecond);
            }
        }
    }
}