package formularios;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MostarPaciente {

	public static void main(boolean b) {
		mostrarP  fa= new mostrarP();
		
		fa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fa.setVisible(true);

	}

}

class mostrarP extends JFrame
{
	
	
	public mostrarP ()
	{
		
		setBounds(500,100,600 ,600 ); 
		consultarP consu=new consultarP();
		add(consu);
	}
	
}

class consultarP extends JPanel{
	
	public consultarP (){
		setLayout(new BorderLayout());
		try
		{	
			String id,nombre,apellido,edad,peso,presion,temperatura,enfermedad,folioM,folioA;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
			Statement st=conexion.createStatement();
			ResultSet rs= st.executeQuery("select * from  paciente");
			String[]  columnas={"Codigo paciente","Nombres","Apellidos","Edad","Peso","Presion Arterial","Temperatura Corporal ","Enfermedad","Folio Medico","Folio administrativo"};
			JTable tabla=new JTable();
			DefaultTableModel modelo=new DefaultTableModel();
			modelo.setColumnIdentifiers(columnas);
			tabla.setModel(modelo);
			while (rs.next())
			{
				id=rs.getString("codigo_paciente");
				nombre=rs.getString("nombre");
				apellido=rs.getString("apellidos");
				edad=rs.getString("edad");
				peso=rs.getString("peso");
				presion=rs.getString("presion_arterial");
				temperatura=rs.getString("temperatura_corporal");
				enfermedad=rs.getString("enfermedad");
				folioM=rs.getString("folioM");
				folioA=rs.getString("FolioA");
				modelo.addRow(new Object[]{id,nombre,apellido,edad,peso,presion,temperatura,enfermedad,folioM,folioA});
			}
			JScrollPane scoll=new JScrollPane(tabla);
			add(scoll,BorderLayout.CENTER);
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error de ingreso","Error",JOptionPane.ERROR_MESSAGE);

		}
	}
}
