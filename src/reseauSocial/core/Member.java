package reseauSocial.core;

public class Member implements MemberInterface{

	String nom;
	String localisation;
	
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
