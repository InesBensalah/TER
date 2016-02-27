
public class CalculeDistance {
	
	private final int Ligne;
    private final int Colone;

    public CalculeDistance(int Ligne, int Colone) {
        this.Ligne = Ligne;
        this.Colone = Colone;
    }

    public int getLigne() {
        return Ligne;
    }

    public int getColone() {
        return Colone;
    }
    
    public static CalculeDistance coordonnee(int k) {
	    int nbrColonne = Plateau.getNbrColonne();

		int j = k % nbrColonne;
    	int i = (k-j) / nbrColonne;

        return new CalculeDistance(i, j);
    }
    
    public static int indice(int i,int j) {
	    int nbrColonne = Plateau.getNbrColonne();
    	int k= i * nbrColonne + j; 
        return k;
    }
    
   
	

	
	public static int CalculeDistanceManhattan (int p1, int p2){
		CalculeDistance case1 = coordonnee(p1);
		CalculeDistance case2 = coordonnee(p2);
	       int distance = Math.abs(case1.getColone() - case2.getColone()) + Math.abs(case1.getLigne() - case2.getLigne());

			return distance;			
	}
	public static Integer[] CalculeVoisin(int i,String [] plateau){
		CalculeDistance case1 = coordonnee(i);
		int indice;
		Integer[]voisin = new Integer [4];
		if(case1.getLigne()>0){
			indice = indice((case1.getLigne()-1),case1.getColone());
			if(plateau[indice].substring(0, 2)=="00"){
				voisin[0]= indice;
			}else{
				voisin[0]= indice;
			}
			
		}else{
			voisin[0]= null;
		}
		if((case1.getColone()+1)<3){
			indice = indice(case1.getLigne(),(case1.getColone()+1));

			if(plateau[indice].substring(0, 2)=="00"){
				
				voisin[1]=indice;
			}else{
				voisin[1]=indice;
			}
			
		}else{
			voisin[1]=null;
		}
		if((case1.getLigne()+1)<3){

			indice = indice((case1.getLigne()+1),case1.getColone());

			if(plateau[indice].substring(0, 2)=="00"){
				voisin[2]=indice;
			}else{
				voisin[2]=indice;
			}
		}else{
			voisin[2]=null;
		}
		if(case1.getColone()>0){
			indice = indice(case1.getLigne(),(case1.getColone()-1));

			if(plateau[indice].substring(0, 2)=="00"){
				voisin[3]=indice;
			}else{
				voisin[3]=indice;
			}
		}else{
			voisin[3]=null;
		}
		
        
		return voisin;

	    

		
	}
	public static int MinimiseVoisin(Integer voisin[],int PositionBut){
		
		 boolean max_val_present = false;  
	
		 int min = Integer.MAX_VALUE;
		 int PositionMin=-1;
		 int DistanceAParcourir;
	
		 for(int i=0;i<voisin.length;i++) // Loop to find the smallest number in array[]
		 {
			if(voisin[i] != null && voisin[i] > 0){
			DistanceAParcourir = CalculeDistance.CalculeDistanceManhattan(voisin[i],PositionBut);

		      if(min > DistanceAParcourir){
		         min=DistanceAParcourir;
		      	PositionMin=voisin[i];
		      }
			
		      //Edge Case, if all numbers are negative and a MAX value is present
		      if(DistanceAParcourir == Integer.MAX_VALUE)
		        max_val_present = true;
			}
		 }
	
		 if(min == Integer.MAX_VALUE && !max_val_present && PositionMin==-1) 
		 //no positive value found and Integer.MAX_VALUE 
		 //is also not present, return -1 as indicator
		    return -1; 
	
		 return PositionMin; //return min positive if -1 is not returned
	}
	
public static int [][] Disance( String plateau[]){
		
        int[][] distance = new int [plateau.length][plateau.length];
        int d;
        int i=0;
        int j=0;
        
        // initialisation de la matrix de distance
        for(i=0;i<distance.length;i++){
        	for(j=0;j<distance.length;j++){
        		if(i==j){
        			distance[i][j]=0;
        		}else{
        			distance[i][j]=-1;
        		}
        	}
        }
        
        
     // d va nous permettre de remplir le tableau des plus petit distance au plus grand
     int distanceManh ;
     int modif=0 ; // je sais pas a quoi ca sert du coup je l utilise pas 
     Integer []voisin = new Integer  [4];

     for(d=0;d<114;d++){
    	 
    	 for(i=0 ;i<plateau.length ;i++){ 
			for(j=0 ;j<plateau.length ;j++){
				
				
				distanceManh = CalculeDistance.CalculeDistanceManhattan(i,j) ;
				if(distanceManh == d){ 
					voisin = CalculeDistance.CalculeVoisin(j,plateau) ;	

					for(int v=0;v<voisin.length ;v++){
						if(voisin[v] != null){
							CalculeDistance case1 = CalculeDistance.coordonnee(voisin[v]);
							if(distance[i][voisin[v]]==-1){
								distance[i][voisin[v]]=d+1;
							}
						}

					}

				}
			}
    	 }

     }
     
        
 	return distance;

	}
}
