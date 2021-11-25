package reseauSocial.implementation2020;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import facebookGhost.FacebookGhostNetwork;
import grapheSimple.GrapheSimple;
import grapheX.Sommet;
import reseauSocial.core.SocialNetworkInterface;
import reseauSocial.core.Strength;


public class SocialNetWorkImpl<MemberInterface> implements SocialNetworkInterface<MemberInterface> {

	ArrayList<MemberInterface> members;
	String name;
	GrapheSimple graphe;
	
	public SocialNetWorkImpl(String name) {
		this.name = name;
		graphe = new GrapheSimple();
		members = new ArrayList<>();
	}
	
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
		return members;
	}

	@Override
	public void addMember(MemberInterface membre) {
		members.add(membre);
		graphe.ajouterSommet((Member) membre);
	}

	@Override
	public MemberInterface addMember(String ident, FacebookGhostNetwork fg) {
		return null;
	}

	@Override
	public MemberInterface addMember(String identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void relate(Strength force, MemberInterface member, MemberInterface friend) {
		graphe.ajouterArc((Member) member, friend, force);
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
