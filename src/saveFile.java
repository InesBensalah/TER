import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;


public class saveFile {
	
	
	public static void write (String filename, int x[]) throws IOException{
		try {
			File yourFile = new File("filename.txt");
			 if(!yourFile.exists()) {
			      yourFile.createNewFile();
			 } 
			 BufferedWriter oFile = new BufferedWriter(new FileWriter(yourFile)); 
			  
			 for(int i=0;i<x.length;i++){
	             for( int j=0;j<x.length;j++){
	            	  oFile.write(Integer.toString(x[i]));
	              }
	              oFile.newLine();
	          }

			  oFile.flush();  
			  oFile.close(); 
		}catch (IOException e) {
		    System.out.println("Erreur");
		}	   
	}
	
	// lit et transcrit le fichier txt dans different tableau 
	public static Plateau read (String filename) throws IOException{
		File fil = new File(filename);
        FileReader inputFil = new FileReader(fil);
		BufferedReader in = new BufferedReader(inputFil);
       
        String s = in.readLine();
        String line = s;
        int hauteur = countLines(filename); // fonction qui récupère le nombre de ligne du fichier
        int longeur = s.length();
        int nbrColonne = (longeur%4)+1;
        String[] plateau = new String[nbrColonne*hauteur];

        // tableau qui vont regrouper les indices de chaque objet du plateau 
        Integer occupent[] = new Integer[nbrColonne*hauteur]; 
        Integer obstacle[] = new Integer[nbrColonne*hauteur]; 
        Integer but[]= new Integer[nbrColonne*hauteur];
        
        // compteur 
        String ctn_occupent;
        String ctn_but;
        
        // variable utilisé pour gérer les different tableau 
        int l=0; // plateau‡
        int i= 0; // 
        int j=0; // but
        int n=0; // obstacle
        
		try {
            
            // rempli le tableau plateau
            while(line != null) {
                for ( i=0;i<longeur;i=i+5){
                    plateau[l] = line.substring(i, i + 4); // on récupère les données sur les agents ainsi que les but
                    l++;
                }
                line = in.readLine();
            }
            
            l=0;
            
            // rempli les tableau occupent et but grace au tableau plateau
            for (i=0;i<plateau.length;i++){
            	ctn_occupent = plateau[i].substring(0, 2);
            	ctn_but = plateau[i].substring(2, 4);
            	if(!ctn_occupent.equals("00")){
	            	if(ctn_occupent.equals("-1")){
	            		obstacle[n]=i;
	            	}else{
	            		occupent[l]= i;
	            		l++;
	            	}
	            }
	            if(!ctn_but.equals("00")){
	            	but[j]=i;
	            	j++;
	            }	
            }
            }catch (IOException e1){
                e1.printStackTrace();

            }
		in.close();
		
		Plateau p = new Plateau(plateau,occupent,obstacle,but,nbrColonne);
		return p;


        }
	
	// fonction qui calcule le nombre de line d'un fichier text 
	public static int countLines(String filename) throws IOException {
	    LineNumberReader reader  = new LineNumberReader(new FileReader(filename));
		int cnt = 0;
		String lineRead = "";
		while ((lineRead = reader.readLine()) != null) {}
		cnt = reader.getLineNumber(); 
		reader.close();
		return cnt;
	}
	
}

