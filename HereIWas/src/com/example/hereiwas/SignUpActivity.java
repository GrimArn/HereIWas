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
        
        // declaration des TextView pour les boutons
        TextView textViewBillabongInscription  = (TextView) findViewById(R.id.InscriptionButton);
        TextView textViewBillabongPersonnelle 	 = (TextView) findViewById(R.id.textViewPersonnelle);
        TextView textViewBillabongConfidentielle = (TextView) findViewById(R.id.textViewConfidentielle);
        
        TextView textViewRobotoBIEmail	 	 = (TextView) findViewById(R.id.textViewEmail);
        TextView textViewRobotoBIBirthday 	 = (TextView) findViewById(R.id.textViewBirthday);
        TextView textViewRobotoBIPseudo 	 = (TextView) findViewById(R.id.TextViewPseudo);
        TextView textViewRobotoBIPasswd 	 = (TextView) findViewById(R.id.TextViewPassword);
        TextView textViewRobotoBIConfPasswd	 = (TextView) findViewById(R.id.TextViewConfirmPasswd);
        
        TextView textViewRobotoLightPrenom 	 		= (TextView) findViewById(R.id.champHintPrenom);
        TextView textViewRobotoLightNom 	 		= (TextView) findViewById(R.id.champHintNom);
        TextView textViewRobotoLightMail	 		= (TextView) findViewById(R.id.champHintMail);
        TextView textViewRobotoLightAnniv 	 		= (TextView) findViewById(R.id.champHintDateAnniv);
        TextView textViewRobotoLightPseudo 	 		= (TextView) findViewById(R.id.champHintPseudo);
        TextView textViewRobotoLightPassword 		= (TextView) findViewById(R.id.champHintPassword);
        TextView textViewRobotoLightConfirmPasswd 	= (TextView) findViewById(R.id.champHintConfirmPasswd);
        
        // declaration de la police
        Typeface fontBillabong 			= Typeface.createFromAsset(getAssets(), "Billabong.ttf");
        Typeface fontRobotoBlackItalic 	= Typeface.createFromAsset(getAssets(), "Roboto-BlackItalic.ttf");
        Typeface fontRobotoLight 		= Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        
        // initialisation de la police sur les TextView
        textViewBillabongInscription.setTypeface(fontBillabong);
        textViewBillabongPersonnelle.setTypeface(fontBillabong);
        textViewBillabongConfidentielle.setTypeface(fontBillabong);
        
        textViewRobotoBIEmail.setTypeface(fontRobotoBlackItalic);
        textViewRobotoBIBirthday.setTypeface(fontRobotoBlackItalic);
        textViewRobotoBIPseudo.setTypeface(fontRobotoBlackItalic);
        textViewRobotoBIPasswd.setTypeface(fontRobotoBlackItalic);
        textViewRobotoBIConfPasswd.setTypeface(fontRobotoBlackItalic);
        
        textViewRobotoLightPrenom.setTypeface(fontRobotoLight);
        textViewRobotoLightNom.setTypeface(fontRobotoLight);
        textViewRobotoLightMail.setTypeface(fontRobotoLight);
        textViewRobotoLightAnniv.setTypeface(fontRobotoLight);
        textViewRobotoLightPseudo.setTypeface(fontRobotoLight);
        textViewRobotoLightPassword.setTypeface(fontRobotoLight);
        textViewRobotoLightConfirmPasswd.setTypeface(fontRobotoLight);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

	
}

