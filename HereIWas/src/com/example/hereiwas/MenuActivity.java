package com.example.hereiwas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

     // Changement de police 
        // declaration des TextView pour les boutons
        TextView textViewBillabongDeconnexion = (TextView) findViewById(R.id.LogOutButton);
     
        // declaration de la police
        Typeface fontBillabong 	= Typeface.createFromAsset(getAssets(), "Billabong.ttf");
        
        // initialisation de la police sur les TextView
        textViewBillabongDeconnexion.setTypeface(fontBillabong);
        
     // Interaction entre les activites grace aux boutons
        // declaration des image button
        ImageButton ButtonActu 		= (ImageButton) findViewById(R.id.imageButtonActu);
        ImageButton ButtonMesAmis	= (ImageButton) findViewById(R.id.imageButtonMesAmis);
        ImageButton ButtonMesInfos	= (ImageButton) findViewById(R.id.imageButtonMesInfos);
        ImageButton ButtonJeSuisIci	= (ImageButton) findViewById(R.id.imageButtonJeSuisIci);        
        
        // declaration du click sur l'image id/imageButtonActu
        ButtonActu.setOnClickListener (new View.OnClickListener() {
 
			@Override
			public void onClick(View v) {
				
				Intent t = new Intent(MenuActivity.this, ActualiteActivity.class);
				startActivity(t);
			}
		});
     
        // declaration du click sur l'image id/imageButtonMesAmis    
        ButtonMesAmis.setOnClickListener (new View.OnClickListener() {
        	 
			@Override
			public void onClick(View v) {
				
				Intent t = new Intent(MenuActivity.this, MesAmisActivity.class);
				startActivity(t);
			}
		});
        
        // declaration du click sur l'image id/imageButtonMesInfos         
        ButtonMesInfos.setOnClickListener (new View.OnClickListener() {
       	 
			@Override
			public void onClick(View v) {
				
				Intent t = new Intent(MenuActivity.this, MesInfosActivity.class);
				startActivity(t);
			}
		});
        
        // declaration du click sur l'image id/imageButtonJeSuisIci         
        ButtonJeSuisIci.setOnClickListener (new View.OnClickListener() {
          	 
   			@Override
   			public void onClick(View v) {
   				
   				Intent t = new Intent(MenuActivity.this, JeSuisIciActivity.class);
   				startActivity(t);
   			}
   		});
        
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

}
