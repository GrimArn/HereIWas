package com.activity.hereiwas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bd.hereiwas.BaseDonnee;
import com.example.hereiwas.R;
import com.outils.hereiwas.CUser;
import com.outils.hereiwas.UserAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("SimpleDateFormat")
public class MesAmisActivity extends Activity {

	// Declaration des variables base de donnee
	private SQLiteDatabase bdd;
	private BaseDonnee maBaseSQLite;

	// Declaration de la listView
	ListView ListFriend;
	static List<CUser> FriendList = new ArrayList<CUser>();

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_amis);

		/*
		 // Changement de police 
		  	PoliceAmis();
		*/
		
		// Recuperation du ListView present dans notre IHM
		ListFriend = (ListView) findViewById(R.id.ListFriend);

		// Affichage des utilisateurs dans la listViews
		AddUsr();
		UserAdapter adapter = new UserAdapter(this, FriendList);
		
		// On passe nos donn�es au composant ListView
		ListFriend.setAdapter(adapter);
		
		ListFriend.setOnItemClickListener(new OnItemClickListener() {
	          public void onItemClick(AdapterView<?> parent, View view,
	              int position, long id) {
	              TextView Nom = (TextView) view.findViewById(R.id.flNomPrenom);
	              String Nom2 = Nom.getText().toString();
	 
	              // Launching new Activity on selecting single List Item
	              Intent i = new Intent(getApplicationContext(), ProfilAmiActivity.class);
	              // sending data to new activity
	              i.putExtra("Nom", Nom2);
	              startActivity(i);
	          }
	          });
		

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
		FriendList.add(new CUser("0616797537", "Nono", "Grima"		, "Arnaud"	, Now, "toto@tat.fr", "la path"));
		FriendList.add(new CUser("0616797537", "Nono", "Vial"		, "Pauline"	, Now, "toto@tat.fr", "la path"));
		FriendList.add(new CUser("0616797537", "Nono", "Bernardi"	, "Hugo"	, Now, "toto@tat.fr", "la path"));
		FriendList.add(new CUser("0616797537", "Nono", "Thoretton"	, "Mathieu", Now, "toto@tat.fr", "la path"));

	}

	// Partie BASE DE DONNEE

	// Ouverture de la base de donn�e en �criture
	public void open() {

		bdd = maBaseSQLite.getWritableDatabase();
	}

	// Fermeture acces de la base de donn�e
	public void close() {

		bdd.close();
	}

	public SQLiteDatabase getBDD() {

		return bdd;
	}

	/*public void PoliceAmis() {

		// declaration des TextView pour les boutons
		TextView textViewBillabongDeconnexion = (TextView) findViewById(R.id.ListFriend);

		// declaration de la police
		Typeface fontBillabong = Typeface.createFromAsset(getAssets(), "Billabong.ttf");

		// initialisation de la police sur les TextView
		textViewBillabongDeconnexion.setTypeface(fontBillabong);
	} */
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}
}