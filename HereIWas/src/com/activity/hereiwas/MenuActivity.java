package com.activity.hereiwas;

import com.example.hereiwas.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

     // Changement de police 
        PoliceMenu();
        
     // Interaction entre les activites grace aux boutons
        // declaration des image button
        ImageView 	ButtonActu 		= (ImageView) findViewById(R.id.imageViewActu);
        ImageView 	ButtonMesAmis	= (ImageView) findViewById(R.id.imageViewAmis);
        ImageView 	ButtonMesInfos	= (ImageView) findViewById(R.id.imageViewMesInfos);
        ImageView 	ButtonJeSuisIci	= (ImageView) findViewById(R.id.imageViewJsuisIci);        
        
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

	// Changement de police
	public void PoliceMenu () {
		
        // declaration des TextView pour les boutons
        TextView textViewBillabongDeconnexion = (TextView) findViewById(R.id.LogOutButton);
     
        // declaration de la police
        Typeface fontBillabong 	= Typeface.createFromAsset(getAssets(), "Billabong.ttf");
        
        // initialisation de la police sur les TextView
        textViewBillabongDeconnexion.setTypeface(fontBillabong);
	}
}
