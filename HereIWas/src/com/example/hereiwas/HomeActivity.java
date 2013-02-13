package com.example.hereiwas;
//2

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HomeActivity extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
   
     // Changement de police 
        // declaration des TextView pour les boutons
        TextView textViewBillabongConnectButton  = (TextView) findViewById(R.id.ConnectButton);
        TextView textViewBillabongRegisterButton = (TextView) findViewById(R.id.RegisterButton);
        
        // declaration de la police
        Typeface fontBillabong = Typeface.createFromAsset(getAssets(), "Billabong.ttf");
        
        // initialisation de la police sur les TextView
        textViewBillabongConnectButton.setTypeface(fontBillabong);
        textViewBillabongRegisterButton.setTypeface(fontBillabong);
        
     // Interaction entre les activites grace aux boutons
        // declaration des boutons
        Button Connexion 	= (Button)findViewById(R.id.RegisterButton);
        Button Inscription 	= (Button)findViewById(R.id.ConnectButton);
        
        // declaration du click sur le bouton id/RegisterButton pour la connexion
        Connexion.setOnClickListener (new View.OnClickListener() {
 
			@Override
			public void onClick(View v) {
				
				Intent t = new Intent(HomeActivity.this, LoginActivity.class);
				startActivity(t);
			}
		});
        
        // declaration du click sur le bouton id/ConnectButton pour l'inscription
        Inscription.setOnClickListener (new View.OnClickListener() {
        	 
			@Override
			public void onClick(View v) {
				
				Intent t = new Intent(HomeActivity.this, SignUpActivity.class);
				startActivity(t);
			}
		});
    }
        
/*   // Recuperation du bouton defini dans fichier layout/activity_signin
        Button loginButton = (Button) findViewById(R.id.RegisterButton);
        
   // Declaration d'un listener sur l'evenement OnClick du bouton
        loginButton.setOnClickListener (new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// Recuperation des valeurs saisie par l'utilisateur
				
				
				// Transmission des informations a l'activity
				
				Intent intent = new Intent (getApplicationContext()), LoginActivity.class);
        		intent.putExtra();
        		
        		// Lancement activité
        		
        		startActivity(intent);
			}
		}); 
        
    } */
    

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }
    
}
