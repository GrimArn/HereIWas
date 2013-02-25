package com.example.hereiwas;

import java.util.Date;

public class CUser {
	String mNumUtil;
	String mPseudo;
	String mNom;
	String mPrenom;
	String mMdp;
	Date mDatenaissance;
	String mEmail;
	String mPath;

	/****
	 * 
	 * Constructeurs CUser
	 * 
	 ****/

	public CUser (String NumUser, String Pseudo, String Nom, String Prenom,
			String Mdp, Date DateNaiss, String Mail, String Path) {
		mNumUtil = NumUser;
		mPseudo = Pseudo;
		mNom = Nom;
		mPrenom = Prenom;
		mMdp = Mdp;
		mEmail = Mail;
		mDatenaissance = DateNaiss;
		mPath = Path;
	}

	public CUser(String NumUser, String Pseudo, String Nom, String Prenom,
			Date DateNaiss, String Mail, String Path) {
		mNumUtil = NumUser;
		mPseudo = Pseudo;
		mNom = Nom;
		mPrenom = Prenom;
		mEmail = Mail;
		mDatenaissance = DateNaiss;
		mPath = Path;
	}

	/****
	 * 
	 * Getter et Setter pour NumUtil
	 * 
	 ****/
	
	public String getUtilisateurId() {
		return mNumUtil;
	}

	public void setUtilisateurId(String utilisateurId) {
		mNumUtil = utilisateurId;
	}

	/****
	 * 
	 * Getter et Setter pour Pseudo
	 * 
	 ****/

	public String getPseudo() {
		return mPseudo;
	}

	public void setmPseudo(String Pseudo) {
		this.mPseudo = Pseudo;
	}

	/****
	 * 
	 * Getter et Setter pour Nom
	 * 
	 ****/
	
	public String getNom() {
		return mNom;
	}

	public void setNom(String nom) {
		mNom = nom;
	}

	/****
	 * 
	 * Getter et Setter pour Prenom
	 * 
	 ****/

	public String getPrenom() {
		return mPrenom;
	}

	public void setPrenom(String Prenom) {
		mPrenom = Prenom;
	}

	/****
	 * 
	 * Getter et Setter pour Mdp
	 * 
	 ****/

	public String getMdp() {
		return mMdp;
	}

	public void setMdp(String Mdp) {
		this.mMdp = Mdp;
	}

	/****
	 * 
	 * Getter et Setter pour DateNaiss
	 * 
	 ****/

	public void setDate(Date Date) {
		this.mDatenaissance = Date;
	}

	public Date getDateNaiss() {
		return mDatenaissance;
	}

	/****
	 * 
	 * Getter et Setter pour PathPhoto
	 * 
	 ****/
	
	public String getPath() {
		return mPath;
	}

	public void setPath(String Path) {
		this.mPath = Path;
	}

	/****
	 * 
	 * Getter et Setter pour Email
	 * 
	 ****/

	public String getEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

}
