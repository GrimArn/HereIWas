package com.example.hereiwas;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.util.Log;
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
       
    // --- BILLABONG --- Changement de police pour les button    
      
      // declaration        
        TextView textViewBillabongOkButton = (TextView) findViewById(R.id.OkButton);
        TextView textViewBillabongCancelButton = (TextView) findViewById(R.id.CancelButton);
        TextView textViewBillabongBtnLogin = (TextView) findViewById(R.id.LoginButton);
        TextView textViewBillabongBtnCancel = (TextView) findViewById(R.id.CancelButton);
        
      //initialisation
        Typeface fontBillabong = Typeface.createFromAsset(getAssets(), "Billabong.ttf");
        textViewBillabongOkButton.setTypeface(fontBillabong);
        textViewBillabongCancelButton.setTypeface(fontBillabong);
        textViewBillabongBtnLogin.setTypeface(fontBillabong);
        textViewBillabongBtnCancel.setTypeface(fontBillabong);  
        
        
   // --- ROBOTO BLACK-ITALIC ---- Changement de la police des champs, texte
      
        // declaration
        TextView textViewRobotoBILogin = (TextView) findViewById(R.id.champLogin);
        TextView textViewRobotoBIPassword = (TextView) findViewById(R.id.champPassword);
        
        //initialisation
        Typeface fontRobotoBlackItalic = Typeface.createFromAsset(getAssets(), "Roboto-BlackItalic.ttf");
        textViewRobotoBIPassword.setTypeface(fontRobotoBlackItalic);
        textViewRobotoBILogin.setTypeface(fontRobotoBlackItalic);
        
    
    // --- ROBOTO-LIGHT --- Police pour les hint des editText 
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
