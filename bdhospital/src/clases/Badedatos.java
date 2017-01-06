package clases;
import java.sql.*;

import javax.swing.JOptionPane;

public class Badedatos 
{	private Connection conexion = null;
	
	//Conectar
	public void Conectar()
	{
		
		try
		{
			//Codigo Conexion
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
			
			
			
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null,"Error MSQL","Error",JOptionPane.ERROR_MESSAGE);
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"No se ha establecido conexion a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	//Consultar
	public ResultSet Consultar(String SQL)
	{
		 
		 this.Conectar();
		 ResultSet rs = null;
		 Statement sentencia = null;
		 
		 try
		 {	
			 sentencia = conexion.createStatement();
			 rs = sentencia.executeQuery(SQL);			 
		 }
		catch(SQLException ex)
			{
				JOptionPane.showMessageDialog(null,"No se ha establecido conexion a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"No se ha establecido conexion a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
			}
		 
		 return rs;
		
	}
	
	
	
	
	
}