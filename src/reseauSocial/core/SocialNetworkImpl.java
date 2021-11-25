package reseauSocial.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import facebookGhost.FacebookGhostNetwork;

public class SocialNetworkImpl<MemberInterface> implements SocialNetworkInterface<MemberInterface> {

	ArrayList<MemberInterface> members = new ArrayList<MemberInterface>();
	
	@Override
	public MemberInterface getMember(String identifier) {
		for(MemberInterface m : members) {
			if(((Member) m).getName() == identifier) {
				return m;
			}
		}
		return null;
	}

	@Override
	public Collection<MemberInterface> getMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMember(MemberInterface membre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberInterface addMember(String ident, FacebookGhostNetwork fg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberInterface addMember(String identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void relate(Strength force, MemberInterface member, MemberInterface friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<MemberInterface> relatedToRank(MemberInterface member, int rank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int distance(MemberInterface member1, MemberInterface member2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
