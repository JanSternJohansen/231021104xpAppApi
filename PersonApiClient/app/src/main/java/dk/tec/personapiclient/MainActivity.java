package dk.tec.personapiclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtPersonName = findViewById(R.id.txtPersonName);

        IPersonService service = ServiceBuilder.buildService(IPersonService.class);
        Call<Person> request = service.getPersonById(1007);

        request.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response)
            {
                Person p = response.body();
                txtPersonName.setText(p.getName());
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t)
            {
                txtPersonName.setText(t.getMessage());
            }
        });

    }
}