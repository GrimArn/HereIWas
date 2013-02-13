package com.example.hereiwas;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
//3

public class SignUpActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
 
     // Changement de police 
        
       /* // declaration des TextView pour les boutons
        TextView textViewBillabongLoginButton 	= (TextView) findViewById(R.id.LoginButton);
        
        TextView textViewRobotoBIBirthday 	 = (TextView) findViewById(R.id.textViewBirthday);
        TextView textViewRobotoBIPseudo 	 = (TextView) findViewById(R.id.TextViewPseudo);
        TextView textViewRobotoBIPasswd 	 = (TextView) findViewById(R.id.TextViewPassword);
        TextView textViewRobotoBIConfPasswd	 = (TextView) findViewById(R.id.TextViewConfirmPasswd);
        
        TextView textViewRobotoLightLogin 	 		= (TextView) findViewById(R.id.champHintLogin);
        TextView textViewRobotoLightPassword 		= (TextView) findViewById(R.id.champHintPassword);
        TextView textViewRobotoLightConfirmPasswd = (TextView) findViewById(R.id.champHintConfirmPasswd);
        
        // declaration de la police
        Typeface fontBillabong 			= Typeface.createFromAsset(getAssets(), "Billabong.ttf");
        Typeface fontRobotoBlackItalic 	= Typeface.createFromAsset(getAssets(), "Roboto-BlackItalic.ttf");
        Typeface fontRobotoLight 		= Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        
        // initialisation de la police sur les TextView
        textViewBillabongLoginButton.setTypeface(fontBillabong);
        
        textViewRobotoBIBirthday.setTypeface(fontRobotoBlackItalic);
        textViewRobotoBIPseudo.setTypeface(fontRobotoBlackItalic);
        textViewRobotoBIPasswd.setTypeface(fontRobotoBlackItalic);
        textViewRobotoBIConfPasswd.setTypeface(fontRobotoBlackItalic);
        
        textViewRobotoLightLogin.setTypeface(fontRobotoLight);
        textViewRobotoLightPassword.setTypeface(fontRobotoLight);
        textViewRobotoLightConfirmPasswd.setTypeface(fontRobotoLight); */
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

	
}

