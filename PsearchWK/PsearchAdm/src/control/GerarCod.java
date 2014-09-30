package control;

import java.util.Random;

public class GerarCod {

	String r = null;
	public String  gerarCod(){
		String[] n = {"1","2","3","4","5","6","7","8","9","10"};
		String[] l = {"A", "B", "C", "D","E", "F"," G", "H","I","J", "K","L","M", "N","O", "P"," Q", 		
						"R", "S","T"," U"," V", "W", "X", "Y", "Z"};
		Random rx = new Random();
	int v=	rx.nextInt(9);
		
	int y = rx.nextInt(23);
		 r = n[v];
		 r=r+l[y];
		
		
	return r;
	}

	
}
