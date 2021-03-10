
package com.a1_1801040189.sharedreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String P_lang="Lang";

    TextView langView ;
    private static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        langView =findViewById(R.id.language);

        //
  sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        String lang=sharedPreferences.getString(P_lang,null);
        if(lang!=null){
            langView.setText(lang);
        }else{
            selectLang();
        }
    }

    public void selectLang(){

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_btn_speak_now).setTitle("Language Selection")
                .setMessage("Choose a language bro!")
                .setPositiveButton("Viet Nam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                setLanguage("VietNamese");
                    }
                }).setNegativeButton("English", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setLanguage("Enlish");
            }
        }).show();
    }
public void setLanguage(String language){

        sharedPreferences.edit().putString(P_lang,language).apply();
        langView.setText(language);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inlater = getMenuInflater() ;
        inlater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {



        switch(item.getItemId()){
            case R.id.VN:
                Toast.makeText(this,"Vietnam",Toast.LENGTH_LONG).show();
              langView.setText("Vietnamese");
                break;
            case R.id.Eng:
                Toast.makeText(this,"English",Toast.LENGTH_LONG).show();
                langView.setText("Ennglish");
                break;
            case R.id.clear:
                sharedPreferences.edit().clear().apply();
                break;
            



        }


        return super.onOptionsItemSelected(item);
    }
}