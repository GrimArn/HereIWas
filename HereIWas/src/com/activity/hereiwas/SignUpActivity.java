package com.activity.hereiwas;

import java.util.regex.Pattern;

import com.bd.hereiwas.BaseDonnee;
import com.example.hereiwas.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
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
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends Activity {

  // Declaration des variables base de donnee
	private SQLiteDatabase bdd;
	private BaseDonnee maBaseSQLite;

  // Declaration variable pour le dialogAlert
	private static final int DIALOG_ALERT = 10;

  // Declaration pour l'avatar
    private static final int SELECT_PICTURE = 1;
    private static final int PIC_CROP = 2;
	private Uri picUri;

  // Declaration patern pour verifier le champ email
	public final Pattern EMAIL_ADDRESS_PATTERN = Pattern .compile("[a-zA-Z0-9+._%-+]{1,256}" + "@"
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
		Button Inscription = (Button)    findViewById(R.id.InscriptionButton);
		ImageView BAvatar  = (ImageView) findViewById(R.id.imageAvatar);

		// declaration du click sur le bouton id/InscriptionBouton
		Inscription.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// Verification des donnees du formulaire
				VerificationFormulaireInscription();
			}
		});

		BAvatar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				if (v.getId() == R.id.imageAvatar) {     
		        	try {
		        		//use standard intent to capture an image
						Intent intent = new Intent();
		                intent.setType("image/*");
		                intent.setAction(Intent.ACTION_GET_CONTENT);

			        	//we will handle the returned data in onActivityResult
			            startActivityForResult(intent, SELECT_PICTURE);
		        	}
		            catch(ActivityNotFoundException anfe){
		        		//display an error message
		        		String errorMessage = "Whoops - your device doesn't support capturing images!";
		        		Toast toast = Toast.makeText(SignUpActivity.this, errorMessage, Toast.LENGTH_SHORT);
		        		toast.show();
		        	}
		        }
			}
		});
	}

  // Pour selectionner une image pour l'avatar
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if (resultCode == RESULT_OK) {
    		//user is returning from capturing an image using the camera
    		if(requestCode == SELECT_PICTURE){
    			//get the Uri for the captured image
    			picUri = data.getData();
    			//carry out the crop operation
    			performCrop();
    		}
    		//user is returning from cropping the image
    		else if(requestCode == PIC_CROP){
    			//get the returned data
    			Bundle extras = data.getExtras();
    			//get the cropped bitmap
    			Bitmap thePic = extras.getParcelable("data");
    			//retrieve a reference to the ImageView
    			ImageView picView = (ImageView)findViewById(R.id.imageAvatar);
    			//display the returned cropped image
    			picView.setImageBitmap(thePic);
    		}
    	}
    }
    
    /**
     * Helper method to carry out crop operation
     */
    private void performCrop(){
    	//take care of exceptions
    	try {
    		//call the standard crop action intent (the user device may not support it)
	    	Intent cropIntent = new Intent("com.android.camera.action.CROP"); 
	    	//indicate image type and Uri
	    	cropIntent.setDataAndType(picUri, "image/*");
	    	//set crop properties
	    	cropIntent.putExtra("crop", "true");
	    	//indicate aspect of desired crop
	    	cropIntent.putExtra("aspectX", 1);
	    	cropIntent.putExtra("aspectY", 1);
	    	//indicate output X and Y
	    	cropIntent.putExtra("outputX", 256);
	    	cropIntent.putExtra("outputY", 256);
	    	//retrieve data on return
	    	cropIntent.putExtra("return-data", true);
	    	//start the activity - we handle returning in onActivityResult
	        startActivityForResult(cropIntent, PIC_CROP);  
    	}
    	//respond to users whose devices do not support the crop action
    	catch(ActivityNotFoundException anfe){
    		//display an error message
    		String errorMessage = "Whoops - your device doesn't support the crop action!";
    		Toast toast = Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT);
    		toast.show();
    	}
    }    
    
// Fonction pour l'AlertDialog
    
	@SuppressWarnings("deprecation")
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
	
// Fonction pour le sous menu

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

// Fonction de verification

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
