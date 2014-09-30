package control;


import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JTable;

import com.jgoodies.forms.layout.ColumnSpec;

import model.BD;

public class TableGradeCons  
{
	public static JTable tableCons;
	

	static Vector<String> cabecalho = new Vector<String>();
	static Vector<Vector<String>> linhas = new Vector<Vector<String>>();
	public static boolean v = true;
	 
	public static JTable getTable(BD bd, String sqlc)  {

		cabecalho.removeAllElements();
		linhas.removeAllElements();	
			try 
			{
	
			bd.st = bd.con.prepareStatement(sqlc);
			bd.rs = bd.st.executeQuery();
			
			// busca os cabeçalhos 
			ResultSetMetaData rsmd = bd.rs.getMetaData();
			for ( int i = 1; i <= rsmd.getColumnCount(); i++ ) 
				cabecalho.addElement( rsmd.getColumnName( i ) );
	if(!bd.rs.next()){
		v = false;
	}
			
			
			do 
			{
				Vector<String> linhaAtual = new Vector<String>();
				DecimalFormat df = new DecimalFormat("R$ 00.00");
				for ( int i = 1; i <= rsmd.getColumnCount(); i++ )
				{
					switch( rsmd.getColumnType(i)) 
					{
					case Types.VARCHAR:
						linhaAtual.addElement(bd.rs.getString(i));break;
					case Types.TIMESTAMP:
						linhaAtual.addElement(""+bd.rs.getDate(i));break;
					case Types.DOUBLE:
						linhaAtual.addElement(""+bd.rs.getDouble(i));break;
					case Types.INTEGER:
						linhaAtual.addElement(""+bd.rs.getInt(i));break;
					case Types.NUMERIC:
						linhaAtual.addElement(""+df.format(bd.rs.getDouble(i)));break;
					case Types.SMALLINT:
						linhaAtual.addElement(""+bd.rs.getInt(i));break;
 
					case Types.CHAR:
						linhaAtual.addElement(""+bd.rs.getString(i));break;
					case Types.DATE:
						linhaAtual.addElement(""+bd.rs.getString(i));break;
					case Types.DECIMAL:
						linhaAtual.addElement(""+Double.parseDouble(bd.rs.getString(i)));break;
					}
				}
				linhas.addElement(linhaAtual);     
			  
				

			} 
			while (bd.rs.next());       

			tableCons = new JTable(linhas,cabecalho);
			
			
			
		}
		catch (SQLException erro) 
		{ 
			System.out.println(erro.toString());
			return null;
		}
		
		return tableCons;
	}
	
		
		public static int linhaSelecionada(){
			return tableCons.getSelectedRow();		
		}
		

		public static String getCid(){
			
		
		if(	getemail()!=null){
			return  (String) tableCons.getValueAt(tableCons.getSelectedRow(), 1);
		}
		return  (String) tableCons.getValueAt(tableCons.getSelectedRow(), 1);
		
		}
		
		
		
		
public static String getemail(){
			
			return   (String) tableCons.getValueAt(tableCons.getSelectedRow(), 0);
		
		}

public boolean isCellEditable(int row, int col){ 
if (col == 1) { 
return false; 
} 
return true; 
} 

} 

