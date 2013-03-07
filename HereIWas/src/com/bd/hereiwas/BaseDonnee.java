package com.bd.hereiwas;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDonnee extends SQLiteOpenHelper {
	
  // Declaration des variables
	
	private static final String NOM_BDD = "HereIWas.db";
	private static final int VERSION_BDD = 1;
	
  // Declaration de la creation de la base
	// TABLE USERBDD
	private static final String CREATE_BDD_USER = "CREATE TABLE " + UserBDD.TABLE_USER + " (" + 
			UserBDD.COL_NUMUTIL + " TEXT NOT NULL PRIMARY KEY AUTOINCREMENT, " + 
			UserBDD.COL_PATH 	+ " TEXT NOT NULL, " 	+
			UserBDD.COL_PSEUDO 	+ " TEXT NOT NULL, " 	+ 
			UserBDD.COL_NOM 	+ " TEXT NOT NULL, " 	+  
			UserBDD.COL_PRENOM 	+ " TEXT NOT NULL, " 	+ 
			UserBDD.COL_ANNIV 	+ " INTEGER, " 			+  
			UserBDD.COL_MAIL 	+ " TEXT NOT NULL, "   	+ 
			UserBDD.COL_MDP 	+ " TEXT NOT NULL, " 	+ ");";
	
	// TABLE BONCOINS
	private static final String CREATE_BDD_BONCOIN = "CREATE TABLE" + BonCoinBDD.TABLE_BONCOIN + " (" +
			BonCoinBDD.COL_IDBONCOIN 	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
			BonCoinBDD.COL_NOM 			+ " TEXT NOT NULL, " 	+  
			BonCoinBDD.COL_PHOTO 		+ " TEXT NOT NULL, " 	+ 
			BonCoinBDD.COL_DESCRIPTION 	+ " TEXT NOT NULL, " 	+ ");";
	
	// TABLE ACTU
	private static final String CREATE_BDD_ACTU = "CREATE TABLE" + ActuBDD.TABLE_ACTU + " (" +
			ActuBDD.COL_IDACTU	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
			ActuBDD.COL_DATE	+ " INTEGER, "			+  
			ActuBDD.COL_STATUT 	+ " TEXT NOT NULL, "	+  ");";

	// TABLE JAIME
	private static final String CREATE_BDD_JAIME = "CREATE TABLE" + JaimeBDD.TABLE_JAIME + " (" +
			JaimeBDD.COL_IDJAIME	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + ");";
	
	// TABLE JAIME
	private static final String CREATE_BDD_COM = "CREATE TABLE" + CommentaireBDD.TABLE_COM + " (" +
			CommentaireBDD.COL_IDCOM	+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + ");";
					
		
		
	// Constructeur de BaseDonnee
	public BaseDonnee(Context context) {
		super(context, NOM_BDD, null, VERSION_BDD);
	}
	
	/**
	* Création de la base
	*/
	@Override
	public void onCreate(SQLiteDatabase db) {
	
		db.execSQL(CREATE_BDD_USER);
		db.execSQL(CREATE_BDD_BONCOIN);
		db.execSQL(CREATE_BDD_ACTU);
		db.execSQL(CREATE_BDD_JAIME);
		db.execSQL(CREATE_BDD_COM);
	}
	
	/**
	* Mise à jour de la base
	*/
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE " + UserBDD.TABLE_USER 		+ ";");
		db.execSQL("DROP TABLE " + BonCoinBDD.TABLE_BONCOIN + ";");
		db.execSQL("DROP TABLE " + ActuBDD.TABLE_ACTU 		+ ";");
		db.execSQL("DROP TABLE " + JaimeBDD.TABLE_JAIME 	+ ";");
		db.execSQL("DROP TABLE " + CommentaireBDD.TABLE_COM + ";");
		onCreate(db);
	}
}
