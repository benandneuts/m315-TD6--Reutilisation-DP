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


public class SocialNetWorkImpl implements SocialNetworkInterface<Member> {

	ArrayList<Member> members;
	String name;
	GrapheSimple graphe;
	
	public SocialNetWorkImpl(String name) {
		this.name = name;
		graphe = new GrapheSimple();
		members = new ArrayList<>();
	}
	
	@Override
	public Member getMember(String identifier) {
		for(Member m : members) {
			if(identifier.equals(((Member) m).getName())) {
				return m;
			}
		}
		return null;
	}

	@Override
	public Collection<Member> getMembers() {
		return members;
	}

	@Override
	public void addMember(Member membre) {
		members.add(membre);
		graphe.ajouterSommet((Member) membre);
	}

	@Override
	public Member addMember(String ident, FacebookGhostNetwork fg) {
		Member m = new Member(ident);
		ArrayList<User> fam = fg.getUser(ident).getFamily();
		ArrayList<User> frr = fg.getUser(ident).getFriends();
		Member user;
		for(User u : fam) {
			if((user = this.getMember(u.getName())) != (Member) null) {
				this.relate(Strength.HIGH, m, user);
				this.relate(Strength.HIGH, user, m);
			}
		}
		for(User u : frr) {
			if((user = this.getMember(u.getName())) != (Member) null) {
				this.relate(Strength.MEDIUM, m, user);
				this.relate(Strength.MEDIUM, user, m);
			}
		}
		
		return m;
	}

	@Override
	public Member addMember(String identifier) {
		return null;
	}

	@Override
	public void relate(Strength force, Member member, Member friend) {
		graphe.ajouterArc(member, friend, force.getValue());
	}

	@Override
	
	public Set<Member> relatedToRank(Member member, int rank) {
		return graphe.voisinsAuRang(member, rank);
	}

	@Override
	public int distance(Member member1, Member member2) {
		return graphe.cheminLePlusCourt(member1, member2).distance();
	}

}
