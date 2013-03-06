package com.bd.hereiwas;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CommentaireBDD {

	 // Declaration des colonnes de la base de donnée
		public static final String 	TABLE_COM 		= "table_COM";
		public static final String 	COL_IDCOM		= "id commentaire";
		public static final int 	NUM_COL_IDJAIME	= 0;

	  // Declaration des variables pour la base de donnée	
		private SQLiteDatabase bdd;
		private BaseDonnee maBaseSQLite;
		
		public CommentaireBDD (Context context) {
		//On créer la BDD et sa table
			maBaseSQLite = new BaseDonnee(context);
		}
}
