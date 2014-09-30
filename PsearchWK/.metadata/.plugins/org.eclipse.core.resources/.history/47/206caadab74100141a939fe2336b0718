package banco;

import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class TableGrade
{
	private static JTable table;

	public static JTable getTable(BD bd, String sql) {
		try 
		{
			Vector<String> cabecalho = new Vector<String>();
			Vector<Vector<String>> linhas = new Vector<Vector<String>>();
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			bd.rs.next();
			// busca os cabeçalhos 
			ResultSetMetaData rsmd = bd.rs.getMetaData();
			for ( int i = 1; i <= rsmd.getColumnCount(); i++ ) 
				cabecalho.addElement( rsmd.getColumnName( i ) );
	
			// busca dados das linhas
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
	//					default:System.out.println(rsmd.getColumnType(i));   
					}
				}
				linhas.addElement(linhaAtual);     
			} 
			while (bd.rs.next());       

			table = new JTable(linhas,cabecalho);
		}
		catch (SQLException erro) 
		{ 
			System.out.println(erro.toString());
			return null;
		}
		return table;
	}
}


