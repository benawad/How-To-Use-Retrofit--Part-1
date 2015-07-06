package com.example.benawad.walkthroughretrofitlol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;


public class MainActivity extends AppCompatActivity {

    public EditText mInput;
    public Button mButton;
    public TextView mOutput;
    public String API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        API_KEY = getResources().getString(R.string.riot);

        mInput = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);
        mOutput = (TextView) findViewById(R.id.textView);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String encodedText = TextUtils.htmlEncode(mInput.getText().toString().replaceAll("\\s", "").toLowerCase());

                Gson gson = new GsonBuilder().registerTypeAdapterFactory(new ItemTypeAdapterFactory(encodedText)).create();

                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setConverter(new GsonConverter(gson))
                        .setEndpoint("https://na.api.pvp.net")
                        .build();

                Riot service = restAdapter.create(Riot.class);

                service.getSummonerId(encodedText, API_KEY, new Callback<Summoner>() {
                    @Override
                    public void success(Summoner summoner, Response response) {
                        mOutput.setText(summoner.getId()+"");
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        //do something when failure strikes!
                    }
                });

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
