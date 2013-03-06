package com.activity.hereiwas;

import com.bd.hereiwas.BaseDonnee;
import com.example.hereiwas.R;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ActualiteActivity extends Activity {

	// Declaration des variables base de donnee
	private SQLiteDatabase bdd;
	private BaseDonnee maBaseSQLite;
		
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualite);

   /*  // Changement de police 
        
        
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
	
	// Partie BASE DE DONNEE
	
	// Ouverture de la base de donnée en écriture
	public void open() {

		bdd = maBaseSQLite.getWritableDatabase();
	}

	// Fermeture acces de la base de donnée
	public void close() {

		bdd.close();
	}

	public SQLiteDatabase getBDD() {

		return bdd;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}
	
	public void PoliceActu() {
		
		// declaration des TextView pour les boutons
        TextView textViewBillabongDeconnexion = (TextView) findViewById(R.id.textViewActu);
     
        // declaration de la police
        Typeface fontBillabong 	= Typeface.createFromAsset(getAssets(), "Billabong.ttf");
        
        // initialisation de la police sur les TextView
        textViewBillabongDeconnexion.setTypeface(fontBillabong);
	}

}
