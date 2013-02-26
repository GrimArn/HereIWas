package com.example.hereiwas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class MesAmisActivity extends Activity {

	// Declaration des variables base de donnee
	private SQLiteDatabase bdd;
	private BaseDonnee maBaseSQLite;

	// Declaration de la listView
	ListView ListFriend;
	List<CUser> FriendList = new ArrayList<CUser>();

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_amis);

		// Récupération du ListView présent dans notre IHM
		ListFriend = (ListView) findViewById(R.id.ListFriend);

		/*
		 * // Changement de police 
		 * 	PoliceAmis();
		 * 
		 * // Interaction entre les activites grace aux boutons 
		 * 	// declaration de l'image clickable
		 * 
		 * 
		 * // declaration du click sur l'image id/imageIamHere pour revenir a lactivite home 
		 * .setOnClickListener (new View.OnClickListener() {
		 * 
		 * 	@Override public void onClick(View v) {
		 * 
		 * 	Intent t = new Intent(MenuActivity.this, HomeActivity.class);
		 * startActivity(t); } });
		 */

		// Affichage des utilisateurs dans la listViews
		AddUsr();
		UserAdapter adapter = new UserAdapter(this, FriendList);
		
		// On passe nos données au composant ListView
		ListFriend.setAdapter(adapter);
	}

	// Partie AJOUT USER
	private void AddUsr() {
		FriendList.clear();
		Date Now = new Date();

		/**
		 * Fonction a modifier !!
		 */
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd-MM-yy");
		formater.format(Now);
		FriendList.add(new CUser("0616797537", "Nono", "Grima", "Arnaud", Now, "toto@tat.fr", "la path"));
		FriendList.add(new CUser("0616797537", "Nono", "Vial", "Pauline", Now, "toto@tat.fr", "la path"));
		FriendList.add(new CUser("0616797537", "Nono", "Bernardi", "Hugo", Now,"toto@tat.fr", "la path"));
		FriendList.add(new CUser("0616797537", "Nono", "Thoretton", "Matthieu", Now, "toto@tat.fr", "la path"));
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

	public void PoliceAmis() {

		// declaration des TextView pour les boutons
		TextView textViewBillabongDeconnexion = (TextView) findViewById(R.id.textViewAmis);

		// declaration de la police
		Typeface fontBillabong = Typeface.createFromAsset(getAssets(),
				"Billabong.ttf");

		// initialisation de la police sur les TextView
		textViewBillabongDeconnexion.setTypeface(fontBillabong);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}
}