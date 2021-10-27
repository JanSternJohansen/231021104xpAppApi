package dk.tec.simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    String[] persons;
    TextView txtChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        persons = new String[]{ "Anil","Haidar", "Emil B", "Emil E", "Victor", "Mathias", "Musti", "Emil G", "Peter S", "Jan S"};

        List list2 = Arrays.asList(persons);

        ArrayList<String> persons2 = new ArrayList<String>();
        persons2.addAll(list2);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                                                        android.R.layout.simple_list_item_1,
                                                                        persons2);
        ListView listView = findViewById(R.id.lstPersons);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        txtChosen = findViewById(R.id.txtChosen);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l)
    {
        String chosen = persons[pos];
        txtChosen.setText(chosen);
    }
}