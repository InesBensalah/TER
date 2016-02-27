import java.io.IOException;

public class Agent {
	
	
	public  int Position(String [] plateau){
		Integer occupent[] = new Integer[plateau.length]; 
	    occupent = Plateau.getOccupent();
		
		int distanceManh = plateau.length ;
		return distanceManh;

    }
	public static  void Deplacement(String[] plateau, int[][] distance){
		
		Integer occupent[] = new Integer[plateau.length]; 
	    occupent = Plateau.getOccupent();
	    
	    Integer but[] = new Integer[plateau.length]; 
		but = Plateau.getBut();
		String tempPlateau;
	    int distanceTotale = 0;
	    int distanceParcouru=0;
	    int distanceManh ;
	    int PositionVoisinMinimise;
	    int v=0;
	    Integer[]voisin = new Integer [4];
	    int positionAgent;
	    for (positionAgent=0;positionAgent<occupent.length;positionAgent++){
        	if(occupent[positionAgent]!=null){
        		distanceTotale = CalculeDistance.CalculeDistanceManhattan(occupent[positionAgent],but[positionAgent]) ;
        		break;
        	}
	    }
	    int tempPosition=positionAgent;



		//int distanceManh = Position(occupent, but);
		//calculer distance a son but 
	    //System.out.println(occupent[tempPosition] + " " + but[positionAgent]);
		do{
					
			distanceManh = CalculeDistance.CalculeDistanceManhattan(occupent[positionAgent],but[positionAgent]) ;
			
			voisin = CalculeDistance.CalculeVoisin(tempPosition,plateau);
			int DistanceAParcourir = CalculeDistance.CalculeDistanceManhattan(v,but[positionAgent]);
			PositionVoisinMinimise = CalculeDistance.MinimiseVoisin(voisin,but[positionAgent]);		
			if(PositionVoisinMinimise!=-1){
				tempPlateau = plateau[tempPosition].substring(2, 4);
				plateau[tempPosition] = "00" + tempPlateau;
				tempPosition = PositionVoisinMinimise;
				tempPlateau = plateau[tempPosition].substring(2, 4);
				plateau[tempPosition] = "01" + tempPlateau;
				occupent[positionAgent] = PositionVoisinMinimise;
				distanceParcouru++;
			}
			
			for(int h=0;h<3;h++){
				System.out.print(plateau[h] + " "); 
			}
			System.out.println(" ");
			for(int h=3;h<6;h++){
				System.out.print(plateau[h] + " "); 
			}
			System.out.println(" ");
			for(int h=6;h<9;h++){
				System.out.print(plateau[h] + " "); 
			}
			System.out.println(" ");
			System.out.println(" ");
	     }while(occupent[positionAgent]!=but[positionAgent]);
	}
	
}
