package com.example.hereiwas;

//2
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//1
import android.widget.Toast;

public class LoginActivity extends Activity {

	// Declaration des variables base de donnee
	private SQLiteDatabase bdd;
	private BaseDonnee maBaseSQLite;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signin);

		// Changement de police
		PoliceLogin();

		// Interaction entre les activites grace aux boutons

		// declaration des boutons
		Button Connexion = (Button) findViewById(R.id.LoginButton);

		// declaration du click sur le bouton id/LoginButton pour la connexion
		// sur le menu
		Connexion.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// Declaration des variables
				EditText ChampLogin = (EditText) findViewById(R.id.champHintLogin);
				EditText ChampPasswd = (EditText) findViewById(R.id.champHintPassword);
				String Login = ChampLogin.getText().toString();
				String Mdp = ChampPasswd.getText().toString();

				// verifie si les champs sont vides, si oui msg erreur sinon
				// clic button
				if (Login.equals("") || Mdp.equals("")) {

					Toast.makeText(LoginActivity.this, "Tous les champs ne sont pas remplis", Toast.LENGTH_SHORT).show();
				}

				else {
					Intent t = new Intent(LoginActivity.this, MenuActivity.class);
					startActivity(t);
				}

			}
		});
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

	public void PoliceLogin() {

		// declaration des TextView pour les boutons
		TextView textViewBillabongLoginButton = (TextView) findViewById(R.id.LoginButton);

		TextView textViewRobotoBILogin = (TextView) findViewById(R.id.champLogin);
		TextView textViewRobotoBIPassword = (TextView) findViewById(R.id.champPassword);

		TextView textViewRobotoLightLogin = (TextView) findViewById(R.id.champHintLogin);
		TextView textViewRobotoLightPassword = (TextView) findViewById(R.id.champHintPassword);

		// declaration de la police
		Typeface fontBillabong = Typeface.createFromAsset(getAssets(),
				"Billabong.ttf");
		Typeface fontRobotoBlackItalic = Typeface.createFromAsset(getAssets(),
				"Roboto-BlackItalic.ttf");
		Typeface fontRobotoLight = Typeface.createFromAsset(getAssets(),
				"Roboto-Light.ttf");

		// initialisation de la police sur les TextView
		textViewBillabongLoginButton.setTypeface(fontBillabong);

		textViewRobotoBIPassword.setTypeface(fontRobotoBlackItalic);
		textViewRobotoBILogin.setTypeface(fontRobotoBlackItalic);

		textViewRobotoLightLogin.setTypeface(fontRobotoLight);
		textViewRobotoLightPassword.setTypeface(fontRobotoLight);
	}
}
