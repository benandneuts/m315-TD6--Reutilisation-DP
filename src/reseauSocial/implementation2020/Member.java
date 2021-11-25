package reseauSocial.implementation2020;

import grapheX.Sommet;
import reseauSocial.core.MemberInterface;

public class Member extends Sommet implements MemberInterface{

	String localisation;
	
	public Member(String nom) {
		super(nom);
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
		return super.identifiant();
	}

}
