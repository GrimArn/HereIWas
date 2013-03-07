package com.bd.hereiwas;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class UserBDD {

  // Declaration des colonnes de la base de donnée
	public static final String 	TABLE_USER 		= "table_utilisateurs";
	public static final String 	COL_NUMUTIL 	= "Num Utilisateur";
	public static final int 	NUM_COL_ID		= 0;
	public static final String 	COL_PATH 		= "Path";
	public static final int 	NUM_PATH 		= 1;
	public static final String 	COL_PSEUDO 		= "Pseudo";
	public static final int 	NUM_PSEUDO 		= 2;
	public static final String 	COL_PRENOM 		= "Prenom";
	public static final int 	NUM_COL_PRENOM	= 3;
	public static final String 	COL_NOM 		= "Nom";
	public static final int 	NUM_COL_NOM 	= 4;
	public static final String 	COL_ANNIV		= "Anniversaire";
	public static final int		NUM_COL_ANNIV	= 5;
	public static final String	COL_MAIL		= "Mail";
	public static final int 	NUM_COL_MAIL	= 6;
	public static final String	COL_MDP			= "Mot de passe";
	public static final int		NUM_COL_MDP		= 7;

	
  // Declaration des variables pour la base de donnée	
	private SQLiteDatabase bdd;
	private BaseDonnee maBaseSQLite;
	
	public UserBDD (Context context) {
	//On créer la BDD et sa table
		maBaseSQLite = new BaseDonnee(context);
	}
}
