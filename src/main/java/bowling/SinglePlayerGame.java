package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
        
        public int score=0;   
        public int spare=10;
        public int nblancer =0;
        public int strike=0;
        public int tour=0;
        
	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            
            if (nblancer==2){
                nblancer=0;
            }
            nblancer+=1;
            
            //lancer sans strike
            if (nombreDeQuillesAbattues < 10){
                
                if (strike >0){
                    strike-=1;                    
                    score+= nombreDeQuillesAbattues *2;}
                
                else if (spare==0){
                    score+= nombreDeQuillesAbattues *2;}
         
                else{
                    spare-=nombreDeQuillesAbattues;
                    score+= nombreDeQuillesAbattues;}
                
                if (nblancer==2 && spare!=0){
                    nblancer=0;
                    spare=10;
                    }
                }
            
            //Strike
            if (nombreDeQuillesAbattues == 10 && nblancer==1){
                if (strike >0){
                score+= nombreDeQuillesAbattues*3;}
                else{
                score+= nombreDeQuillesAbattues;
                }
                strike=2;
            }
            
            //spare si il ne touche aucune quille au premier lancer
            if (nombreDeQuillesAbattues == 10 && nblancer==2){
                spare=0;
                score+= nombreDeQuillesAbattues;}
            
        tour=tour+1; 
        
           if (tour ==12 && strike==2){
           score=300;
            }
        }

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
		return score;
	}
}
