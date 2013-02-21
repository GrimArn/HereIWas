package com.example.hereiwas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ActuBDD {

	 // Declaration des colonnes de la base de donnée
		public static final String 	TABLE_ACTU 		= "table_actu";
		public static final String 	COL_IDACTU	 	= "id actu";
		public static final int 	NUM_COL_ID		= 0;
		public static final String 	COL_DATE 		= "date publication";
		public static final int 	NUM_COL_DATE 	= 1;
		public static final String 	COL_STATUT		= "statut";
		public static final int		NUM_COL_STATUT	= 2;

	  // Declaration des variables pour la base de donnée	
		private SQLiteDatabase bdd;
		private BaseDonnee maBaseSQLite;
		
		public ActuBDD (Context context) {
		//On créer la BDD et sa table
			maBaseSQLite = new BaseDonnee(context);
		}
}
