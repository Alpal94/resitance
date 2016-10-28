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
	private String playersStr;
	private int myLoc;
	private int myLocSpy;
	private char[] nominees;
	private int[] suspicion;
	private boolean firstTime = true;
	
	public void get_status(String name, String players, String spies, int mission, int failures) {
		if(firstTime){
			this.myName =  name.charAt(0);
			this.playerNames = players.toCharArray();
		    this.spy = spies.indexOf(name)!=-1;
		    this.playersStr = players;
		    if(spy){
		    	spyNames = spies.toCharArray();
			    myLocSpy = spies.indexOf(name);
		    }
		    this.myLoc = players.indexOf(name);
		    this.playerNum = players.length();
		    this.suspicion = new int[playerNum];
		    firstTime = false;
		}
		turn = mission;
	    failure = failures;
	}

	/* Improved the nominate method from newbieAgent by checking is there was enough spies to all go on a mission
	 * if there needs to be more than the number of spies, (eg. 3 needed on mission and only 2 spies), then it'll select one non-spy closest to A
	 */
	public String do_Nominate(int number) {
		System.out.println(myName+" is at do_nominate, it's "+spy+" that I'm a spy.");
		int curr = 0;
		String nom = ""+myName;
		while(curr<number){
			if(spy){
				if(number>spyNames.length){
					for(int i=0;i<(playerNum-1-spyNames.length);i++){
						if(!contains(playerNames[i],spyNames)){
							nom=nom+playerNames[i];
							curr++;
						}
					}
				}
				for(int i=0;i<number-1;i++){
					if(spyNames[i] != myName){
						nom=nom+spyNames[(myLocSpy+i)%playerNum];
						curr++;
					}
				}
			}else{
			for(int i=0;i<number-1;i++){
				if(playerNames[i] != myName){
					nom=nom+playerNames[(myLoc+i)%playerNum];
					curr++;
				}
			}
		}
		}	
		return nom;
	}

	
	public void get_ProposedMission(String leader, String mission) {
		nominees = mission.toCharArray();
	}

	/* Checks the suspicion level for each mission member and sums it up.
	 * If the team's suspicion level is more than an arbitrary number (failures x2 +1), then it votes against it.
	*/
	public boolean do_Vote() {
		int teamSus = 0;
		for(char c:nominees){
			int n = playersStr.indexOf(c);
			teamSus = teamSus + suspicion[n];
			System.out.println("Team suspicion: "+teamSus+"  Threshold: "+(2*failure+1));
		}
		if(teamSus<(2*failure+1)){
			return true;
		}
		return false;
	}

	
	public void get_Votes(String yays) {

	}

	
	public void get_Mission(String mission) {

	}

	public boolean do_Betray() {
		if(spy){
			
				return true;
		}
		return false;
	}

	/*Adds suspicion to the players who went on a mission that failed
	 * if more than one betrayed then more suspicion is added to the members
	*/
	public void get_Traitors(int traitors) {
		for(int i=0; i<playerNum; i++){
			for(int j=0; j<nominees.length; j++){
				if(playerNames[i]==nominees[j]){
					suspicion[i] = suspicion[i]+traitors;
				}
			}
		}
	}

	
	public String do_Accuse() {
		return null;
	}

	
	public void get_Accusation(String accuser, String accused) {

	}

	boolean contains(char c, char[] array) {
	    for (char x : array) {
	        if (x == c) {
	            return true;
	        }
	    }
	    return false;
	}
}
