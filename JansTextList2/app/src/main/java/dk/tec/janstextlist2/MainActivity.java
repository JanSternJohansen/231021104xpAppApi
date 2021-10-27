package dk.tec.janstextlist2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView txtChosen;
    String[] persons;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        persons = new String[]{"Emil", "Emil Eldahl", "Emi. Godtfredsen", "Mustafa",
                "Jan", "Janus", "Victor", "Emirhan", "Jacob", "Oliver", "Haidar","Anil"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                                                 android.R.layout.simple_list_item_1,
                                                 persons);
        ListView lst = findViewById(R.id.lstPersons);
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(this);

        txtChosen = findViewById(R.id.txtChosen);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        txtChosen.setText(persons[i]);
    }
}