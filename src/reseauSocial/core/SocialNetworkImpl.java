package reseauSocial.core;

import java.util.Collection;
import java.util.Set;

import facebookGhost.FacebookGhostNetwork;

public class SocialNetworkImpl<T> implements SocialNetworkInterface<T> {

	@Override
	public T getMember(String identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<T> getMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMember(T membre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T addMember(String ident, FacebookGhostNetwork fg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T addMember(String identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void relate(Strength force, T member, T friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<T> relatedToRank(T member, int rank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int distance(T member1, T member2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
