package reseauSocial.implementation2020;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import facebookGhost.FacebookGhostNetwork;
import facebookGhost.User;
import grapheSimple.GrapheSimple;
import grapheX.Sommet;
import reseauSocial.core.SocialNetworkInterface;
import reseauSocial.core.Strength;


public class SocialNetWorkImpl<MemberInterface> implements SocialNetworkInterface<MemberInterface> {

	ArrayList<MemberInterface> members;
	String name;
	GrapheSimple graphe;
	
	public SocialNetWorkImpl(String nme) {
		this.name = name;
		graphe = new GrapheSimple();
		members = new ArrayList<>();
	}
	
	@Override
	public MemberInterface getMember(String identifier) {
		for(MemberInterface m : members) {
			if(identifier.equals(((Member) m).getName())) {
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
		MemberInterface m = (MemberInterface) new Member(ident);
		ArrayList<User> fam = fg.getUser(ident).getFamily();
		ArrayList<User> frr = fg.getUser(ident).getFriends();
		MemberInterface user;
		for(User u : fam) {
			if((user = this.getMember(u.getName())) != (MemberInterface) null) {
				this.relate(Strength.HIGH, m, user);
				this.relate(Strength.HIGH, user, m);
			}
		}
		for(User u : frr) {
			if((user = this.getMember(u.getName())) != (MemberInterface) null) {
				this.relate(Strength.MEDIUM, m, user);
				this.relate(Strength.MEDIUM, user, m);
			}
		}
		
		return m;
	}

	@Override
	public MemberInterface addMember(String identifier) {
		return null;
	}

	@Override
	public void relate(Strength force, MemberInterface member, MemberInterface friend) {
		graphe.ajouterArc((Member) member, (Member) friend, force.getValue());
	}

	@Override
	
	public Set<MemberInterface> relatedToRank(MemberInterface member, int rank) {
		return graphe.voisinsAuRang((Member) member, rank);
	}

	@Override
	public int distance(MemberInterface member1, MemberInterface member2) {
		return graphe.cheminLePlusCourt((Member) member1, (Member) member2).distance();
	}

}
