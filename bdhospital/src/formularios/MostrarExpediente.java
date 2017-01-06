package formularios;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MostrarExpediente {

	public static void main(boolean b) {
		mostrarE  ce= new mostrarE();
		
		ce.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ce.setVisible(true);

	}

}

class mostrarE extends JFrame
{
	
	
	public mostrarE ()
	{
		
		setBounds(500,100,600 ,600 ); 
		consultarE con=new consultarE();
		add(con);
	}
	
}

class consultarE extends JPanel{
	
	public consultarE (){
		setLayout(new BorderLayout());
		try
		{	

			String id,historial;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
			Statement st=conexion.createStatement();
			ResultSet rs= st.executeQuery("select * from  expediente");
			String[]  columnas={"Folio","Historal"};
			JTable tabla=new JTable();
			DefaultTableModel modelo=new DefaultTableModel();
			modelo.setColumnIdentifiers(columnas);
			tabla.setModel(modelo);
			while (rs.next())
			{
				id=rs.getString("folio");
				historial=rs.getString("historial");
				
				modelo.addRow(new Object[]{id,historial});
			}
			JScrollPane scoll=new JScrollPane(tabla);
			add(scoll,BorderLayout.CENTER);
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error de ingreso","Error",JOptionPane.ERROR_MESSAGE);

		}
	}
}
