package dk.tec.myfirstappw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtTryk = findViewById(R.id.txtTryk);
        Button btnTryk = findViewById(R.id.btnTryk);

        btnTryk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTryk.setText("Der blev trykket på knappen");
            }
        });
    }
}