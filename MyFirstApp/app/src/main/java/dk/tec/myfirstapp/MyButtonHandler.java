package dk.tec.myfirstapp;

import android.util.Log;
import android.view.View;

import dk.tec.myfirstapp.MainActivity;

public class MyButtonHandler implements View.OnClickListener
{
    private MainActivity mainActivity;

    public MyButtonHandler(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view)
    {
        Log.d("MyTag", "Eventhandler kaldt");

        mainActivity.txtTrykOK.setText("Der er trykket på knappen");

    }
}
