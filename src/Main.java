import java.io.IOException;

public class Main {
	
	

	    public static void main(String[] args) throws IOException 
	    {
	    	String filename = "entré.txt";
	    	saveFile.read(filename);
	    	String[] plateau = Plateau.getPlateau();
	        int[][] distance = new int [plateau.length][plateau.length];
	        distance = CalculeDistance.Disance(plateau);
	        
	        Agent.Deplacement(plateau,distance);
	        
	        /* Affichage de la matrice distance
	         System.out.println(" distance : ");

	          for(int i=0 ;i<plateau.length ;i++){ 
	         
				for(int j=0 ;j<plateau.length ;j++){ 
					System.out.print(distance[i][j] + " ");
				}
				System.out.println(" ");
	        }
	         */
	       // System.out.println(distance[0]);
	    	//saveFile.write("test9.txt",matrix);

	    }
	    

	    
}