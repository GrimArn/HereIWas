package com.activity.hereiwas;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hereiwas.R;

public class ProfilAmiActivity extends Activity{
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_profil_ami);
 
        TextView txtNom = (TextView) findViewById(R.id.NomAmi);
        
        Intent i = getIntent();
        // getting attached intent data
        String Nom = i.getStringExtra("Nom");
        // displaying selected product name

        txtNom.setText(Nom);

 
    }
}
