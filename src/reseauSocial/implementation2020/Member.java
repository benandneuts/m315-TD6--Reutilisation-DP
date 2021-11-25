package reseauSocial.implementation2020;

import reseauSocial.core.MemberInterface;

public class Member implements MemberInterface{

	String nom;
	String localisation;
	
	public Member(String nom) {
		this.nom = nom;
	}

	@Override
	public String getLocation() {
		return localisation;
	}

	@Override
	public void setLocation(String s) {
		localisation = s;
		
	}

	@Override
	public String getName() {
		return nom;
	}

}
