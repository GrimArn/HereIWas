package com.activity.hereiwas;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bd.hereiwas.BaseDonnee;
import com.example.hereiwas.R;

public class JeSuisIciActivity extends Activity {

/* Declaration des differentes variables */	
	
	// Declaration des variables base de donnee
	
	private SQLiteDatabase bdd;
	private BaseDonnee maBaseSQLite;

	// Declaration des variables pour capturer une photo
	
	final int CAMERA_CAPTURE = 1;
	final int PIC_CROP = 2;
	// captured picture uri
	private Uri picUri;

/* Fonction PRINCIPAL */
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jesuisici);

	// Changement de police
		PoliceJSI();

	// Interaction entre les activites grace aux boutons
		
		// Declaration des interactions
		
		Button CapturePicture = (Button) findViewById(R.id.captureButton);
		Button Publier		  = (Button) findViewById(R.id.PublierButton);

		// Declaration de l'evenement prise de photo
		
		CapturePicture.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				if (v.getId() == R.id.captureButton) {
					try {
						 //use standard intent to capture an image
					    Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
					    //we will handle the returned data in onActivityResult
					    startActivityForResult(captureIntent, CAMERA_CAPTURE);
					    
					} 
					catch (ActivityNotFoundException anfe) {
						// display an error message
						String errorMessage = "Whoops - your device doesn't support capturing images!";
						Toast toast = Toast.makeText(JeSuisIciActivity.this, errorMessage, Toast.LENGTH_SHORT);
						toast.show();
					}
				}
			}
		});
		
		// Declaration de l'evenement de publication du lieu
		
		Publier.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				// TO DO
				// alertdialog pour dire que la publication a bien ete publie 
			}
		});
	}

 // Fonction pour la capture de photo 	
	
	//Handle user returning from both capturing and cropping the image
	 
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			// user is returning from capturing an image using the camera
			if (requestCode == CAMERA_CAPTURE) {
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
				ImageView picView = (ImageView) findViewById(R.id.imageLieux);
				// display the returned cropped image
				picView.setImageBitmap(thePic);
			}
		}
	}

	
	 // Helper method to carry out crop operation
	 
	private void performCrop() {
		// take care of exceptions
		try {
			// call the standard crop action intent (the user device may not
			// support it)
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
		// respond to users whose devices do not support the crop action
		catch (ActivityNotFoundException anfe) {
			// display an error message
			String errorMessage = "Whoops - your device doesn't support the crop action!";
			Toast toast = Toast
					.makeText(this, errorMessage, Toast.LENGTH_SHORT);
			toast.show();
		}
	}

 // Partie BASE DE DONNEE
	
	// Ouverture de la base de donnee en ecriture
	public void open() {

		bdd = maBaseSQLite.getWritableDatabase();
	}

	// Fermeture acces de la base de donnee
	public void close() {

		bdd.close();
	}

	public SQLiteDatabase getBDD() {

		return bdd;
	}

// Fonction pour le sous menu
	
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

 // Fonction pour le changement de police
	
	public void PoliceJSI() {

		// declaration des TextView pour les boutons
		
		TextView textViewBillabongJesuisici 	= (TextView) findViewById(R.id.textViewJeSuisIci);
		TextView textViewBillabongPublier		= (TextView) findViewById(R.id.PublierButton);
		TextView textViewBillabongCapture		= (TextView) findViewById(R.id.captureButton);
		TextView textViewRobotoBICom 			= (TextView) findViewById(R.id.textViewCommentaire);

		// declaration de la police
		
		Typeface fontBillabong 			= Typeface.createFromAsset(getAssets(), "Billabong.ttf");
		Typeface fontRobotoBlackItalic 	= Typeface.createFromAsset(getAssets(), "Roboto-BlackItalic.ttf");
		
		// initialisation de la police sur les TextView
		
		textViewBillabongJesuisici.setTypeface(fontBillabong);
		textViewBillabongPublier.setTypeface(fontBillabong);
		textViewBillabongCapture.setTypeface(fontBillabong);
		textViewRobotoBICom.setTypeface(fontRobotoBlackItalic);
	}

}