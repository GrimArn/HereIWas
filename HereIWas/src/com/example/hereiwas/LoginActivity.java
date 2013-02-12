package com.example.hereiwas;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;


public class LoginActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
 
     // Changement de police 
        
        // declaration des TextView pour les boutons
        TextView textViewBillabongLoginButton 	= (TextView) findViewById(R.id.LoginButton);
        TextView textViewBillabongCancelButton 	= (TextView) findViewById(R.id.CancelButton);
        
        TextView textViewRobotoBILogin 		 = (TextView) findViewById(R.id.champLogin);
        TextView textViewRobotoBIPassword 	 = (TextView) findViewById(R.id.champPassword);
        
        TextView textViewRobotoLightLogin 	 = (TextView) findViewById(R.id.champHintLogin);
        TextView textViewRobotoLightPassword = (TextView) findViewById(R.id.champHintPassword);
        
        // declaration de la police
        Typeface fontBillabong 			= Typeface.createFromAsset(getAssets(), "Billabong.ttf");
        Typeface fontRobotoBlackItalic 	= Typeface.createFromAsset(getAssets(), "Roboto-BlackItalic.ttf");
        Typeface fontRobotoLight 		= Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        
        // initialisation de la police sur les TextView
        textViewBillabongLoginButton.setTypeface(fontBillabong);
        textViewBillabongCancelButton.setTypeface(fontBillabong);
        
        textViewRobotoBIPassword.setTypeface(fontRobotoBlackItalic);
        textViewRobotoBILogin.setTypeface(fontRobotoBlackItalic);
        
        textViewRobotoLightLogin.setTypeface(fontRobotoLight);
        textViewRobotoLightPassword.setTypeface(fontRobotoLight);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

	
}

