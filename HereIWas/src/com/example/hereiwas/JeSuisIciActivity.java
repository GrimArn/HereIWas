package com.example.hereiwas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class JeSuisIciActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jesuisici);

   /*  // Changement de police 
        // declaration des TextView pour les boutons
        TextView textViewBillabongDeconnexion = (TextView) findViewById(R.id.);
     
        // declaration de la police
        Typeface fontBillabong 	= Typeface.createFromAsset(getAssets(), "Billabong.ttf");
        
        // initialisation de la police sur les TextView
        textViewBillabongDeconnexion.setTypeface(fontBillabong);
        
     // Interaction entre les activites grace aux boutons
        // declaration de l'image clickable
        
        
     // declaration du click sur l'image id/imageIamHere pour revenir a lactivite home
        .setOnClickListener (new View.OnClickListener() {
 
			@Override
			public void onClick(View v) {
				
				Intent t = new Intent(MenuActivity.this, HomeActivity.class);
				startActivity(t);
			}
		}); */
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

}
