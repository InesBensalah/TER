
public class Plateau {
	private static Integer occupent[] = new Integer[9]; 
    private static Integer obstacle[] = new Integer[9];
    private static Integer but[] = new Integer[9]; 
    private static String plateau[] = new String[9]; 
    private static int nbrColonne;

    public Plateau(String []plateau, Integer occupent[], Integer obstacle[],Integer but[],int nbrColonne) {
    	this.plateau = plateau;
        this.obstacle = obstacle;
        this.occupent = occupent;
        this.but = but;
        this.nbrColonne =nbrColonne;
    }

	public static int getNbrColonne() {
		return nbrColonne;
	}

	public static void setNbrColone(int nbrColonne) {
		Plateau.nbrColonne = nbrColonne;
	}

	public static Integer[] getBut() {
		return but;
	}

	public static void setBut(Integer[] but) {
		Plateau.but = but;
	}

	public static Integer[] getOccupent() {
		return occupent;
	}

	public void setOccupent(Integer[] occupent) {
		this.occupent = occupent;
	}

	public static Integer[] getObstacle() {
		return obstacle;
	}

	public void setObstacle(Integer[] obstacle) {
		this.obstacle = obstacle;
	}
	
	public static Plateau AgentBut(String [] plateau) {
		int positionAgent=0;
		int butAgent=0;
		Integer occupent[] = new Integer[plateau.length]; 
		Integer obstacle[] = new Integer[plateau.length]; 
		Integer but[]= new Integer[plateau.length];

		String ctn_occupent;
        String ctn_but;
        int l=0; // plateau‡
        int j=0; // but
        int n=0; // obstacle
        
		for (int i=0;i<plateau.length;i++){
        	ctn_occupent = plateau[i].substring(0, 2);
        	ctn_but = plateau[i].substring(2, 4);
        	if(ctn_occupent!="00"){
        		
            	if(ctn_occupent=="-1"){
            		obstacle[n]=i;
            	}else{
            		occupent[l]= i;
            		l++;
            	}
            }
            if(ctn_but!="00"){
            	but[j]=i;
            	j++;
            }	
        }
    	
    	
        return new Plateau(plateau,occupent,obstacle,but,nbrColonne);
    }

	public static String[] getPlateau() {
		return plateau;
	}

	public void setPlateau(String[] plateau) {
		this.plateau = plateau;
	}
}
