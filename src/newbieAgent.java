//import java.util.*;

public class newbieAgent implements Agent{
	
	private char myName;
	private boolean spy;
	//private int turn;
	//private int success;
	//private int failure = turn - success;
	private int playerNum;
	private char[] spyNames;
	private char[] playerNames;
	private int myLoc;
	private int myLocSpy;
	//private char[] nominees;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void get_status(String name, String players, String spies, int mission, int failures) {
		this.myName =  name.charAt(0);
		playerNames = players.toCharArray();
	    spy = spies.indexOf(name)!=-1;
	    if(spy){
	    	spyNames = spies.toCharArray();
		    myLocSpy = spies.indexOf(name);
	    }
	    myLoc = players.indexOf(name);
	    playerNum = players.length();
	    
	}
	
	public String do_Nominate(int number) {
		String nom = ""+myName;
		if(spy){
			for(int i=0;i<number-1;i++){
				if(spyNames[i] != myName){
					nom=nom+spyNames[(myLocSpy+i)%playerNum];
				}
			}
		} else{
			for(int i=0;i<number-1;i++){
				if(playerNames[i] != myName){
					nom=nom+playerNames[(myLoc+i)%playerNum];
				}
			}
		}
		
		return nom;
	}
	
	public void get_ProposedMission(String leader, String mission) {
		
	}
	
	public boolean do_Vote() {

	return true;
	}
	
	public void get_Votes(String yays) {
		// TODO Auto-generated method stub
		
	}
	
	public void get_Mission(String mission) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean do_Betray() {
		if(spy){
			return true;
		}
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
