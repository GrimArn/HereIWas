package com.activity.hereiwas;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;

import android.database.sqlite.SQLiteDatabase;

import android.graphics.Bitmap;
import android.graphics.Typeface;

import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bd.hereiwas.BaseDonnee;
import com.example.hereiwas.R;

public class SignUpActivity extends Activity {

/* Declaration des differentes variables */	
	
	// Declaration des variables base de donnee

	private SQLiteDatabase bdd;
	private BaseDonnee maBaseSQLite;

	// Declaration variable pour le dialogAlert

	private static final int DIALOG_ALERT = 10;

	// Declaration pour l'avatar

	private static final int SELECT_PICTURE = 1;
	private static final int PIC_CROP = 2;
	private Uri picUri;

	// Reponse JSON

	private static String KEY_SUCCESS = "success";

	// Declaration patern pour verifier le champ email

	public final Pattern EMAIL_ADDRESS_PATTERN = Pattern
			.compile("[a-zA-Z0-9+._%-+]{1,256}" + "@"
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" + "(" + "."
					+ "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" + ")+");

	
/* Fonction onCreate */

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);

	// Changement de police
		PoliceSU();

	// Interaction entre les activites grace aux boutons

		// Importation caracteristiques champ et boutons cliquable

		Button Inscription = (Button) findViewById(R.id.InscriptionButton);
		ImageView BAvatar = (ImageView) findViewById(R.id.imageAvatar);

		// Declaration du click sur le bouton id/InscriptionBouton

		Inscription.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// Verification et Recuperation des donnees du formulaire

				VerificationEtRecuperationdesDonnees();
			}
		});

		// Declaration du click sur le bouton id/Avatar

		BAvatar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				if (v.getId() == R.id.imageAvatar) {
					try {
						
						// use standard intent to capture an image
						Intent intent = new Intent();
						intent.setType("image/*");
						intent.setAction(Intent.ACTION_GET_CONTENT);

						// we will handle the returned data in onActivityResult
						startActivityForResult(intent, SELECT_PICTURE);
					} 
					
					catch (ActivityNotFoundException anfe) {
						
						// display an error message
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
			
			// user is returning from capturing an image using the camera
			if (requestCode == SELECT_PICTURE) {
				
				// get the Uri for the captured image
				picUri = data.getData();
				// carry out the crop operation
				performCrop();
			}
			// user is returning from cropping the image
			else if (requestCode == PIC_CROP) {
				
				// get the returned data
				Bundle extras = data.getExtras();
				// get the cropped bitmap
				Bitmap thePic = extras.getParcelable("data");
				// retrieve a reference to the ImageView
				ImageView picView = (ImageView) findViewById(R.id.imageAvatar);
				// display the returned cropped image
				picView.setImageBitmap(thePic);
			}
		}
	}

	// Methode pour crop image

	private void performCrop() {
		
		try {

			Intent cropIntent = new Intent("com.android.camera.action.CROP");
			// indicate image type and Uri
			cropIntent.setDataAndType(picUri, "image/*");
			// set crop properties
			cropIntent.putExtra("crop", "true");
			// indicate aspect of desired crop
			cropIntent.putExtra("aspectX", 1);
			cropIntent.putExtra("aspectY", 1);
			// indicate output X and Y
			cropIntent.putExtra("outputX", 256);
			cropIntent.putExtra("outputY", 256);
			// retrieve data on return
			cropIntent.putExtra("return-data", true);
			// start the activity - we handle returning in onActivityResult
			startActivityForResult(cropIntent, PIC_CROP);
		}
		
		catch (ActivityNotFoundException anfe) {

			// display an error message
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
			Intent t = new Intent(SignUpActivity.this, LoginActivity.class);
			t.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(t);
			finish();
		}
	}

 // Fonction pour le sous menu

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

	

 // Recuperation des donnees en JSON

	protected void VerificationEtRecuperationdesDonnees () {
       
     // Declaration des variables pour recuperation des donnees
        
        EditText C_Pseudo     	 = (EditText)  findViewById(R.id.champHintPseudo);
        EditText C_Password   	 = (EditText)  findViewById(R.id.champHintPassword);
        EditText C_ConfirmPasswd = (EditText)  findViewById(R.id.champHintConfirmPasswd);
        EditText C_Nom        	 = (EditText)  findViewById(R.id.champHintNom);
        EditText C_Prenom     	 = (EditText)  findViewById(R.id.champHintPrenom);
        EditText C_Mail       	 = (EditText)  findViewById(R.id.champHintMail);
        EditText C_Anniv      	 = (EditText)  findViewById(R.id.champHintDateAnniv);

     // Recuperation du contenu des EditText
        
        String Pseudo        = C_Pseudo.getText().toString();
        String Password      = C_Password.getText().toString();
        String ConfirmPasswd = C_ConfirmPasswd.getText().toString();
        String Nom           = C_Nom.getText().toString();
        String Prenom        = C_Prenom.getText().toString();
        String Mail          = C_Mail.getText().toString();
        String Anniv         = C_Anniv.getText().toString();
        
        JSONObject jobj;
        
     // Verification des donnees
		        
        // Test si le formulaire n'est pas vide
        
        if (isValidFormulaire(Pseudo, Password, ConfirmPasswd, Nom, Prenom, Mail, Anniv)) {
            
            if (isValidEmail(Mail)) {
                
                if (isValidAnniv(Anniv)) {
                    
                    if (isValidPseudo(Pseudo)) {
                        
                        if (isValidPassword(Password)) {
                            
                            if (isValidComparePwd(Password, ConfirmPasswd)) {
                                
                            	// On construit la liste des parametres de la requete
                                
                                ArrayList <NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
                                nameValuePair.add(new BasicNameValuePair("tag", "register"));
                                nameValuePair.add(new BasicNameValuePair("PSEUDO", Pseudo));
                                nameValuePair.add(new BasicNameValuePair("NOM", Nom));
                                nameValuePair.add(new BasicNameValuePair("PRENOM", Prenom));
                                nameValuePair.add(new BasicNameValuePair("ANNIV", Anniv));
                                nameValuePair.add(new BasicNameValuePair("MAIL", Mail));
                                nameValuePair.add(new BasicNameValuePair("MDP", Password));
                                
                                try {
                                    
                                    // Execute la requete vers le serveur
                                    
                                    HttpClient httpclient = new DefaultHttpClient();
                                    HttpPost httppost = new HttpPost("http://localhost:8080/android_connect/index.php");
                                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePair));
                                    HttpResponse reponse = httpclient.execute(httppost);
                                    HttpEntity entity = reponse.getEntity();
                                    InputStream input = entity.getContent();
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(input, "iso-8859-1"),8);
                                    StringBuilder sb = new StringBuilder();
                                    String line = reader.readLine();
                                    sb.append(line + "\n");
                                    input.close();
                                    
                                    // Resultat de la requete
                                    
                                    String result = sb.toString();
                                    jobj = new JSONObject(result);
                                    
                                    // Si le resultat de la requete n'est pas nul
                                    
                                    if (jobj.getString(KEY_SUCCESS) != null) {
                                        
                                        String res = jobj.getString(KEY_SUCCESS);
                                        
                                        // Si res = 1 - L'utilisateur est maintenant inscrit
                                        
                                        if (Integer.parseInt(res) == 1) {
                                            
                                            showDialog(DIALOG_ALERT);
                                        }
                                        
                                        else {
                                            
                                            Toast.makeText(getApplicationContext(), jobj.get("msg_error").toString(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                } //try
                                
                                catch (Exception e) {
                                    
                                }
                            } //isValidComparePwd
                            
                            else
                               Toast.makeText(SignUpActivity.this, "Les mots de passes sont differents", Toast.LENGTH_SHORT).show(); 
                        } // isValidPassword
                        
                        else
                            Toast.makeText(SignUpActivity.this, "Mot de passe trop court", Toast.LENGTH_SHORT).show();
                    } // isValidPseudo
                    
                    else
                        Toast.makeText(SignUpActivity.this, "Pseudo trop court", Toast.LENGTH_SHORT).show();
                } // isValidAnniv
                
                else
                    Toast.makeText(SignUpActivity.this, "Date de naissance incorrect", Toast.LENGTH_SHORT).show();
            } // isValidMail
            
            else
                Toast.makeText(SignUpActivity.this, "Email incorrect", Toast.LENGTH_SHORT).show();
        } // isValidFormulaire
        
        else
            Toast.makeText(SignUpActivity.this, "Le formulaire n'est pas rempli correctement", Toast.LENGTH_SHORT).show(); 
	} //VerificationEtRecuperationdesDonnees()

 // Fonction private pour tester les differents champs
	
	private boolean isValidFormulaire(String Pseudo, String Password,
			String ConfirmPasswd, String Nom, String Prenom, String Mail,
			String Anniv) {

		if (Pseudo.equals("") || Password.equals("") || ConfirmPasswd.equals("") || Nom.equals("")
				|| Prenom.equals("") || Mail.equals("") || Anniv.equals("")) {

			return false;
		} 
		
		else {

			return true;
		}
	}

	private boolean isValidAnniv(String Anniv) {

		if (Anniv.length() >= 8)
			return true;
		else
			return false;
	}

	private boolean isValidPseudo(String Pseudo) {

		if (Pseudo.length() >= 4)
			return true;
		else
			return false;
	}

	private boolean isValidPassword(String Password) {

		if (Password.length() >= 4)
			return true;
		else
			return false;
	}

	private boolean isValidComparePwd(String Password, String ConfirmPasswd) {

		if (Password.compareTo(ConfirmPasswd) < 0)
			return true;
		else
			return false;
	}
	
	private boolean isValidEmail(String email) {
		
		return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
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

// Changement police

	public void PoliceSU() {

		// declaration des TextView pour les boutons

		TextView textViewBillabongInscription 	 = (TextView) findViewById(R.id.InscriptionButton);
		TextView textViewBillabongPersonnelle 	 = (TextView) findViewById(R.id.textViewPersonnelle);
		TextView textViewBillabongConfidentielle = (TextView) findViewById(R.id.textViewConfidentielle);

		TextView textViewRobotoBIEmail 		= (TextView) findViewById(R.id.textViewEmail);
		TextView textViewRobotoBIBirthday 	= (TextView) findViewById(R.id.textViewBirthday);
		TextView textViewRobotoBIPseudo 	= (TextView) findViewById(R.id.TextViewPseudo);
		TextView textViewRobotoBIPasswd 	= (TextView) findViewById(R.id.TextViewPassword);
		TextView textViewRobotoBIConfPasswd = (TextView) findViewById(R.id.TextViewConfirmPasswd);

		TextView textViewRobotoLightPrenom 	= (TextView) findViewById(R.id.champHintPrenom);
		TextView textViewRobotoLightNom 	= (TextView) findViewById(R.id.champHintNom);
		TextView textViewRobotoLightMail 	= (TextView) findViewById(R.id.champHintMail);
		TextView textViewRobotoLightAnniv 	= (TextView) findViewById(R.id.champHintDateAnniv);
		TextView textViewRobotoLightPseudo 	= (TextView) findViewById(R.id.champHintPseudo);
		TextView textViewRobotoLightPassword = (TextView) findViewById(R.id.champHintPassword);
		TextView textViewRobotoLightConfirmPasswd = (TextView) findViewById(R.id.champHintConfirmPasswd);

		// declaration de la police

		Typeface fontBillabong 		= Typeface.createFromAsset(getAssets(), "Billabong.ttf");
		Typeface fontRobotoBlackItalic  = Typeface.createFromAsset(getAssets(), "Roboto-BlackItalic.ttf");
		Typeface fontRobotoLight 	= Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");

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
