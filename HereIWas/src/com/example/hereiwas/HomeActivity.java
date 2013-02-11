package com.example.hereiwas;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);
        setContentView(R.layout.activity_signup);
       
    // Changement de police pour le titre    
      
      // declaration        
        TextView textViewBillabongTitle = (TextView) findViewById(R.id.Title);
        TextView textViewBillabongTitle2 = (TextView) findViewById(R.id.Title2);
        TextView textViewBillabongBtnLogin = (TextView) findViewById(R.id.LoginButton);
        //TextView textViewBillabongBtnCancel = (TextView) findViewById(R.id.CancelButton);
        
      //initialisation
        Typeface fontBillabong = Typeface.createFromAsset(getAssets(), "Billabong.ttf");
        textViewBillabongTitle.setTypeface(fontBillabong);
        textViewBillabongTitle2.setTypeface(fontBillabong);
        textViewBillabongBtnLogin.setTypeface(fontBillabong);
        //textViewBillabongBtnCancel.setTypeface(fontBillabong);    
        
        
   // Changement de la police des champs, texte
      
        // declaration
        TextView textViewRobotoBILogin = (TextView) findViewById(R.id.champLogin);
        TextView textViewRobotoBIPassword = (TextView) findViewById(R.id.champPassword);
      
        //initialisation
        Typeface fontRobotoBlackItalic = Typeface.createFromAsset(getAssets(), "Roboto-BlackItalic.ttf");
        textViewRobotoBILogin.setTypeface(fontRobotoBlackItalic);
        textViewRobotoBIPassword.setTypeface(fontRobotoBlackItalic);
    
    // Police pour les hint des editText 
        // declaration
        TextView textViewRobotoLightLogin = (TextView) findViewById(R.id.champHintLogin);
        TextView textViewRobotoLightPassword = (TextView) findViewById(R.id.champHintPassword);
      
        //initialisation
        Typeface fontRobotoLight = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        textViewRobotoLightLogin.setTypeface(fontRobotoLight);
        textViewRobotoLightPassword.setTypeface(fontRobotoLight); 
        
    
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }
    
}
