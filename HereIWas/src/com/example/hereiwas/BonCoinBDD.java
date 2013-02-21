package com.example.hereiwas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BonCoinBDD {

	 // Declaration des colonnes de la base de donnée
		public static final String 	TABLE_BONCOIN 	= "table_boncoins";
		public static final String 	COL_IDBONCOIN 	= "id boncoins";
		public static final int 	NUM_COL_ID		= 0;
		public static final String 	COL_NOM 		= "Nom lieu";
		public static final int 	NUM_COL_NOM 	= 1;
		public static final String 	COL_PHOTO		= "Photo";
		public static final int		NUM_COL_ANNIV	= 2;
		public static final String	COL_DESCRIPTION	= "Description";
		public static final int 	NUM_COL_MAIL	= 3;

		
	  // Declaration des variables pour la base de donnée	
		private SQLiteDatabase bdd;
		private BaseDonnee maBaseSQLite;
		
		public BonCoinBDD (Context context) {
		//On créer la BDD et sa table
			maBaseSQLite = new BaseDonnee(context);
		}
}
