package com.example.hereiwas;

import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends Activity {

	// Declaration des variables base de donnee
	private SQLiteDatabase bdd;
	private BaseDonnee maBaseSQLite;

	// Declaration variable pour le dialogAlert
	private static final int DIALOG_ALERT = 10;

	// Declaration variable pour l'avatar
	private static int RESULT_LOAD_IMAGE = 1;

	// Declaration patern pour verifier le champ email
	public final Pattern EMAIL_ADDRESS_PATTERN = Pattern
			.compile("[a-zA-Z0-9+._%-+]{1,256}" + "@"
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" + "(" + "."
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" + ")+");
	
// Appel des fonctions	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);

		// Changement de police
		PoliceSU();

		// Interaction entre les activites grace aux boutons
		// declaration des boutons
		Button Inscription = (Button) findViewById(R.id.InscriptionButton);
		QuickContactBadge Avatar = (QuickContactBadge) findViewById(R.id.imageAvatar);

		// declaration du click sur le bouton id/InscriptionBouton
		Inscription.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// Verification des donnees du formulaire
				VerificationFormulaireInscription();
			}
		});

		Avatar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				intent.putExtra("crop", "true");
				intent.putExtra("outputX", 150);
				intent.putExtra("outputY", 150);
				intent.putExtra("aspectX", 1);
				intent.putExtra("aspectY", 1);
				intent.putExtra("scale", true);
				intent.putExtra("return-data", true);
				startActivityForResult(intent, RESULT_LOAD_IMAGE);

			}
		});
	}

// Fonction pour l'AlertDialog
	@SuppressWarnings("deprecation")
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_ALERT:
			// Create out AlterDialog
			Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("	Felicitation !\n\n		Vous etes maintenant inscrit\n");
			builder.setCancelable(true);
			builder.setPositiveButton("OK", new OkOnClickListener());
			AlertDialog dialog = builder.create();
			dialog.show();
		}
		return super.onCreateDialog(id);
	}

	private final class OkOnClickListener implements
			DialogInterface.OnClickListener {
		public void onClick(DialogInterface dialog, int which) {
			SignUpActivity.this.finish();
			Intent t = new Intent(SignUpActivity.this, MenuActivity.class);
			startActivity(t);
		}
	}

// Fonction pour le choix de l'image de l'avatar
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
				&& null != data) {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();

			QuickContactBadge QCBavatar = (QuickContactBadge) findViewById(R.id.imageAvatar);
			QCBavatar.setImageBitmap(BitmapFactory.decodeFile(picturePath));

		}
	}

	public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
		int width = bm.getWidth();
		int height = bm.getHeight();
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;

		// create a matrix for the manipulation
		Matrix matrix = new Matrix();

		// resize the bit map
		matrix.postScale(scaleWidth, scaleHeight);

		// recreate the new Bitmap
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
				matrix, false);

		return resizedBitmap;
	}

// Fonction pour le sous menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

// Fonction de verification
	@SuppressWarnings("deprecation")
	protected void VerificationFormulaireInscription() {

		// Declaration des variables pour controle des données
		EditText ChampPseudo = (EditText) findViewById(R.id.champHintPseudo);
		String Pseudo = ChampPseudo.getText().toString();

		EditText ChampPasswd = (EditText) findViewById(R.id.champHintPassword);
		String Passwd = ChampPasswd.getText().toString();

		EditText ChampConfirmPasswd = (EditText) findViewById(R.id.champHintConfirmPasswd);
		String ConfirmPasswd = ChampConfirmPasswd.getText().toString();

		EditText ChampNom = (EditText) findViewById(R.id.champHintNom);
		String Nom = ChampNom.getText().toString();

		EditText ChampPrenom = (EditText) findViewById(R.id.champHintPrenom);
		String Prenom = ChampPrenom.getText().toString();

		EditText ChampMail = (EditText) findViewById(R.id.champHintMail);
		String Mail = ChampMail.getText().toString();

		EditText ChampAnniv = (EditText) findViewById(R.id.champHintDateAnniv);
		String Anniv = ChampAnniv.getText().toString();

		// Verification
		if (Pseudo.equals("") || Passwd.equals("") || ConfirmPasswd.equals("")
				|| Nom.equals("") || Prenom.equals("") || Mail.equals("")
				|| Anniv.equals("")) {
			Toast.makeText(SignUpActivity.this,
					"Le formulaire n'est pas rempli correctement",
					Toast.LENGTH_SHORT).show();
		} else if (!checkEmail(Mail)) {
			Toast.makeText(SignUpActivity.this, "Email incorrect",
					Toast.LENGTH_SHORT).show();
		} else if (Anniv.length() < 8) {
			Toast.makeText(SignUpActivity.this, "Date de naissance incorrect",
					Toast.LENGTH_SHORT).show();
		} else if (Pseudo.length() < 4) {
			Toast.makeText(SignUpActivity.this, "Pseudo trop court",
					Toast.LENGTH_SHORT).show();
		} else if (Passwd.length() < 4) {
			Toast.makeText(SignUpActivity.this, "Mot de passe trop court",
					Toast.LENGTH_SHORT).show();
		} else if (Passwd.compareTo(ConfirmPasswd) < 0) {
			Toast.makeText(SignUpActivity.this,
					"Les mots de passes sont differents", Toast.LENGTH_SHORT)
					.show();
		} else {
			showDialog(DIALOG_ALERT);
		}
	}

	private boolean checkEmail(String email) {
		return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
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

// Changement police
	public void PoliceSU() {

		// declaration des TextView pour les boutons

		TextView textViewBillabongInscription = (TextView) findViewById(R.id.InscriptionButton);
		TextView textViewBillabongPersonnelle = (TextView) findViewById(R.id.textViewPersonnelle);
		TextView textViewBillabongConfidentielle = (TextView) findViewById(R.id.textViewConfidentielle);

		TextView textViewRobotoBIEmail = (TextView) findViewById(R.id.textViewEmail);
		TextView textViewRobotoBIBirthday = (TextView) findViewById(R.id.textViewBirthday);
		TextView textViewRobotoBIPseudo = (TextView) findViewById(R.id.TextViewPseudo);
		TextView textViewRobotoBIPasswd = (TextView) findViewById(R.id.TextViewPassword);
		TextView textViewRobotoBIConfPasswd = (TextView) findViewById(R.id.TextViewConfirmPasswd);

		TextView textViewRobotoLightPrenom = (TextView) findViewById(R.id.champHintPrenom);
		TextView textViewRobotoLightNom = (TextView) findViewById(R.id.champHintNom);
		TextView textViewRobotoLightMail = (TextView) findViewById(R.id.champHintMail);
		TextView textViewRobotoLightAnniv = (TextView) findViewById(R.id.champHintDateAnniv);
		TextView textViewRobotoLightPseudo = (TextView) findViewById(R.id.champHintPseudo);
		TextView textViewRobotoLightPassword = (TextView) findViewById(R.id.champHintPassword);
		TextView textViewRobotoLightConfirmPasswd = (TextView) findViewById(R.id.champHintConfirmPasswd);

		// declaration de la police

		Typeface fontBillabong = Typeface.createFromAsset(getAssets(),
				"Billabong.ttf");
		Typeface fontRobotoBlackItalic = Typeface.createFromAsset(getAssets(),
				"Roboto-BlackItalic.ttf");
		Typeface fontRobotoLight = Typeface.createFromAsset(getAssets(),
				"Roboto-Light.ttf");

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

}
