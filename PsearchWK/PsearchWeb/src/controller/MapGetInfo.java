package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import banco.BD;

public class MapGetInfo {
	
	private BD bd;
	
	public MapGetInfo() {
	
	}
public static void main(String[] args) {

String latlong = "(-23.1128839, -47.238054499999976)";
String lx= latlong.replace("(", "");
String lat = null;
String log = null;
String ltlong = lx.replace(")", "");
int tamanho = ltlong.length();
for(int i=0;i<tamanho;i++){
	char v = ltlong.charAt(i);
	if(v==','){
		System.out.println(i);
 lat =ltlong.substring(0,i);
	 log = ltlong.substring(i+1,tamanho);
	}
		double longitude = Double.parseDouble(lat);
		double latitude = Double.parseDouble(log);
		
		
		
	System.out.println(latitude);
	System.out.println(longitude);
	
	
	}
}


}
