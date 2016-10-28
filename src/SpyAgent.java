import java.util.*;

public class SpyAgent implements Agent {

	private String players; //the string of players
	private String spy; //the string of spies
	private int myLoc; // the index location of this agent in the players String
	private int mission; //the number of missions passed this game 
	private int failures; //number of failures this game
	private String nominated; //the String of players that were nominated by the leader
	
	//A sorted list of the players from lowest suspicion to highest.
	private char[] sortedListSpy;
	private char[] sortedListResistance;
	
	
	public void get_status(String name, String players, String spies, int mission, int failures) {
		this.players = players;
	}

	/*
	 * check the probability/suspicion of all players
	 * group the lowest suspicion spy/spies and resistance together
	 * this can be done by a priorityQueue or by a sorted list.
	 * if first mission, then nominate yourself and people next to you.
	 */
	public String do_Nominate(int number) {
		String nom = "";
		if(mission==0){
			int curr =0;
			while(curr<number){
				for(int i=0; i<players.length();i++){
					nom = nom+players.charAt((myLoc+i)%players.length());
					curr++;
				}
			}
		}else{
			int curr = 0;
			while(curr<number){
				for(int i=0; i<(players.length()-(number/3));i++){
					nom = nom+sortedListSpy[i];
					curr++;
				}
				for(int i=0; i<players.length(); i++){
					nom = nom+sortedListResistance[i];
					curr++;
				}
			}
		}
		return nom;
	}


	public void get_ProposedMission(String leader, String mission) {
		this.nominated = mission;
	}
	
	
	/* If there's no spies in the nominated mission, then return false.
	 * If the spies in the mission have the highest suspicion, vote against
	 * Therefore, if there is a spy in the proposed mission and that spy isn't the most suspicious
	 */
	public boolean do_Vote() {
		for(int i=0;i<spy.length();i++){
			int spySus = nominated.indexOf(spy.charAt(i));
			if((spySus == -1)||(spySus == 0)){
				return false;
			}
		}
		return true;
	}

	
	public void get_Votes(String yays) {

	}

	
	public void get_Mission(String mission) {
		// TODO Auto-generated method stub

	}

	/*
	 * 50/50 on betraying, unless there's already been 2 successes or failures, in which it'll always betray.
	 */
	public boolean do_Betray() {
		Random rand = new Random();
		if((mission-failures)==2 || failures==2){
			return true;
		}else if(rand.nextInt(2)==1){
				return true;
		}
		return false;
	}

	
	public void get_Traitors(int traitors) {

	}

	
	public String do_Accuse() {
		return null;
	}

	
	public void get_Accusation(String accuser, String accused) {

	}

}
