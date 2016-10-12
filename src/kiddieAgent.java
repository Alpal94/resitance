//import java.util.*;


public class kiddieAgent implements Agent {

	private char myName;
	private boolean spy;
	private int turn;
	private int success;
	private int failure = turn - success;
	private int playerNum;
	private char[] spyNames;
	private char[] playerNames;
	private int myLoc;
	private int myLocSpy;
	private char[] nominees;
	private int[] suspicion;
	private boolean firstTime = true;
	
	public void get_status(String name, String players, String spies, int mission, int failures) {
		if(firstTime){
			this.myName =  name.charAt(0);
			playerNames = players.toCharArray();
		    spy = spies.indexOf(name)!=-1;
		    if(spy){
		    	spyNames = spies.toCharArray();
			    myLocSpy = spies.indexOf(name);
		    }
		    myLoc = players.indexOf(name);
		    playerNum = players.length();
		    suspicion = new int[playerNum];
		    firstTime = false;
		}
		turn = mission;
	    failure = failures;
	}

	
	public String do_Nominate(int number) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void get_ProposedMission(String leader, String mission) {
		nominees = mission.toCharArray();
	}

	
	public boolean do_Vote() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void get_Votes(String yays) {
		// TODO Auto-generated method stub

	}

	
	public void get_Mission(String mission) {
		// TODO Auto-generated method stub

	}

	
	public boolean do_Betray() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void get_Traitors(int traitors) {
		// TODO Auto-generated method stub

	}

	
	public String do_Accuse() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void get_Accusation(String accuser, String accused) {
		// TODO Auto-generated method stub

	}

}
