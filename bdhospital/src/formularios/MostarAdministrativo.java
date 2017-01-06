package formularios;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MostarAdministrativo {

	public static void main(boolean b) {
		mostrarA  ca= new mostrarA();
		
		ca.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ca.setVisible(true);

	}

}

class mostrarA extends JFrame
{
	
	
	public mostrarA ()
	{
		
		setBounds(500,100,600 ,600 ); 
		consultarA consu=new consultarA();
		add(consu);
	}
	
}

class consultarA extends JPanel{
	
	public consultarA (){
		setLayout(new BorderLayout());
		try
		{	
			String id,nombre,apellido,horae,horaS,seguro,folioM,folioP;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
			Statement st=conexion.createStatement();
			ResultSet rs= st.executeQuery("select * from  personal_administrativo");
			String[]  columnas={"Codigo administrativo","Nombres","Apellidos","Horario Entrada","Horario Salida","Numero Seguro Social","Folio Medico","Folio Paciente"};
			JTable tabla=new JTable();
			DefaultTableModel modelo=new DefaultTableModel();
			modelo.setColumnIdentifiers(columnas);
			tabla.setModel(modelo);
			while (rs.next())
			{
				id=rs.getString("codigo_trabajador");
				nombre=rs.getString("nombre");
				apellido=rs.getString("apellidos");
				horae=rs.getString("horarioe");
				horaS=rs.getString("HorarioS");
				seguro=rs.getString("numero_segurosocial");
				folioM=rs.getString("folioM");
				folioP=rs.getString("FolioP");
				modelo.addRow(new Object[]{id,nombre,apellido,horae,horaS,seguro,folioM,folioP});
			}
			JScrollPane scoll=new JScrollPane(tabla);
			add(scoll,BorderLayout.CENTER);
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error de ingreso","Error",JOptionPane.ERROR_MESSAGE);

		}
	}
}
