package formularios;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MostrarMedico {

	public static void main(boolean b) {
		mostrarM  fa= new mostrarM();
		
		fa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fa.setVisible(true);

	}

}

class mostrarM extends JFrame
{
	
	
	public mostrarM ()
	{
		
		setBounds(500,100,600 ,600 ); 
		mostrar p=new mostrar();
		add(p);
	}
	
}

class mostrar extends JPanel{
	
	public mostrar(){
		setLayout(new BorderLayout());
		try
		{	
			String id,nombre,apellido,especialidad,puesto,seguro,horaE,horaS,foliop,folioA;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
			Statement st=conexion.createStatement();
			ResultSet rs= st.executeQuery("select * from  medico_especialista");
			String[]  columnas={"Codigo medico","Nombres","Apellidos","Especialidad","Puesto","Numero seguro social","Hora entrada","Hora salida","Folio paciente","Folio administrativo"};
			JTable tabla=new JTable();
			DefaultTableModel modelo=new DefaultTableModel();
			modelo.setColumnIdentifiers(columnas);
			tabla.setModel(modelo);
			while (rs.next())
			{
				id=rs.getString("codigo_medico");
				nombre=rs.getString("Nombre");
				apellido=rs.getString("apellidos");
				especialidad=rs.getString("especialidad");
				puesto=rs.getString("puesto");
				seguro=rs.getString("numero_seguro social");
				horaE=rs.getString("horarioe");
				horaS=rs.getString("horariosal");
				foliop=rs.getString("folioP");
				folioA=rs.getString("FolioA");
				modelo.addRow(new Object[]{id,nombre,apellido,especialidad,puesto,seguro,horaE,horaS,foliop,folioA});
			}
			JScrollPane scoll=new JScrollPane(tabla);
			add(scoll,BorderLayout.CENTER);
			
			
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error de ingreso","Error",JOptionPane.ERROR_MESSAGE);

		}
	}
}
