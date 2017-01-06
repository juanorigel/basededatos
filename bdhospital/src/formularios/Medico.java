package formularios;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import clases.Badedatos;
import java.awt.Panel;

public class Medico extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textA;
	private JTextField textE;
	private JTextField textP;
	private JTextField textNum;
	private JTextField textHE;
	private JTextField textHS;
	private Connection conexion = null;
	private JTextField textFP;
	private JTextField textFA;
	private Badedatos bd = null;
	private ResultSet rs = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medico frame = new Medico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Medico() {
		setTitle("Medico Especialista");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 591, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(218, 29, 182, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(218, 60, 182, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textA = new JTextField();
		textA.setBounds(218, 91, 182, 20);
		contentPane.add(textA);
		textA.setColumns(10);
		
		textE = new JTextField();
		textE.setBounds(218, 122, 182, 20);
		contentPane.add(textE);
		textE.setColumns(10);
		
		textP = new JTextField();
		textP.setBounds(218, 153, 182, 20);
		contentPane.add(textP);
		textP.setColumns(10);
		
		textNum = new JTextField();
		textNum.setBounds(218, 184, 182, 20);
		contentPane.add(textNum);
		textNum.setColumns(10);
		
		textHE = new JTextField();
		textHE.setBounds(218, 215, 182, 20);
		contentPane.add(textHE);
		textHE.setColumns(10);
		
		textHS = new JTextField();
		textHS.setBounds(218, 246, 182, 20);
		contentPane.add(textHS);
		textHS.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo Medico");
		lblNewLabel.setBounds(66, 32, 114, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(66, 60, 114, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(65, 94, 115, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Especialidad");
		lblNewLabel_3.setBounds(66, 122, 114, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Puesto");
		lblNewLabel_4.setBounds(65, 153, 115, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Numero Social");
		lblNewLabel_5.setBounds(66, 187, 114, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Horario Entrada");
		lblNewLabel_6.setBounds(66, 218, 114, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Horario Salida");
		lblNewLabel_7.setBounds(65, 249, 115, 14);
		contentPane.add(lblNewLabel_7);
		
		textFP = new JTextField();
		textFP.setBounds(218, 277, 182, 20);
		contentPane.add(textFP);
		textFP.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Folio Paciente");
		lblNewLabel_8.setBounds(66, 274, 114, 14);
		contentPane.add(lblNewLabel_8);
		
		textFA = new JTextField();
		textFA.setBounds(218, 308, 182, 20);
		contentPane.add(textFA);
		textFA.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Folio Administrativo");
		lblNewLabel_9.setBounds(66, 311, 114, 14);
		contentPane.add(lblNewLabel_9);
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
								
				try{
				Class.forName("com.mysql.jdbc.Driver");
				conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
				String id= textCodigo.getText();
				String nom= textNombre.getText();
				String ape= textA.getText();
				String esp= textE.getText();
				String pues= textP.getText();
				String numS= textNum.getText();
				String horE= textHE.getText();
				String horS= textHS.getText();	
				String fP = textFP.getText();
				String fa= textFA.getText();
				
				Statement st=conexion.createStatement();
				
				
				
				String sql = "insert into medico_especialista values ('"+id+"','"+nom+"','"+ape+"','"+esp+"','"+pues+"','"+numS+"','"+horE+"','"+horS+"','"+fP+"','"+fa+"')";
				
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(null,"Regristro con exito","Aviso",JOptionPane.INFORMATION_MESSAGE);
				}catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(null,"Error de ingreso","Error",JOptionPane.ERROR_MESSAGE);
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"No se ha establecido conexion a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
				}		
					 
				
				textCodigo.setText("");
				
				textNombre.setText(" ");
				
				textA.setText("");
				
				textE.setText("");
				
				textP.setText(" ");
			
				textNum.setText(" ");
				
				textHE.setText("");
					
				textHS.setText("");
				
				textFP.setText("");
				
				textFA.setText("");
				
			}

		
		});
		btnNewButton.setBounds(10, 341, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
					String id= textCodigo.getText();
					Statement st=conexion.createStatement();
					
				
					String sql = "DELETE FROM medico_especialista WHERE codigo_medico = " + id+ "";
					st.executeUpdate(sql);
				}catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(null,"Error no se ha eliminado","Error",JOptionPane.ERROR_MESSAGE);
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"No se ha establecido conexion a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				textCodigo.setText("");
				
					
				
				
			}
		});
		btnNewButton_1.setBounds(118, 341, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						
			try
			{bd = new Badedatos();
				String id= textCodigo.getText();
				
				String sql = "select * from medico_especialista where codigo_medico='"+id+"'";
				rs = bd.Consultar(sql);
				while(rs.next()){
					textNombre.setText(rs.getString("nombre"));
					textA.setText(rs.getString("apellidos"));
					textE.setText(rs.getString("especialidad"));
					textP.setText(rs.getString("puesto"));
					textNum.setText(String.valueOf(rs.getInt("numero_seguro social")));
					textHE.setText(rs.getTime("horarioe") + "");
					textHS.setText(rs.getTime("horariosal") + "");
					textFP.setText(rs.getInt("folioP") + "");
					textFA.setText(rs.getInt("folioA") + "");
				 }
			}catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"No se ha establecido conexion a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			;
	
				
			}
		});
		btnNewButton_3.setBounds(228, 341, 89, 23);
		contentPane.add(btnNewButton_3);
		
		
		JButton btnNewButton_4 = new JButton("Regresar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Principal nuevoPrincipal=new Principal();
				nuevoPrincipal.setVisible(true);
				
				
			}
		});
		btnNewButton_4.setBounds(426, 341, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("Consultar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MostrarMedico nuevomostrar =new MostrarMedico();
				MostrarMedico.main(true);

			}
		});
		btnNewButton_2.setBounds(327, 341, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("Actualizar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					
					String nom= textNombre.getText();
					String ape= textA.getText();
					String esp= textE.getText();
					String pues= textP.getText();
					String numS= textNum.getText();
					String horE= textHE.getText();
					String horS= textHS.getText();	
					String fP = textFP.getText();
					String fa= textFA.getText();
					Class.forName("com.mysql.jdbc.Driver");
					conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
					String id= textCodigo.getText();
					Statement st=conexion.createStatement();
					
					
					String sql = "UPDATE medico_especialista SET "
							+ "Nombre='"+nom+"',"
							+ "apellidos='"+ape+"',"
							+ "especialidad='"+esp+"',"
							+ "puesto='"+pues+"',"
							+ "numero_seguro social='"+numS+"',"
							+ "horarioe='"+horE+"',"
							+ "horariosal='"+horS+"',"
							+ "folioP='"+fP+"',"
							+ "FolioA ='"+fa+"'"
							+ " WHERE codigo_medico=" + id+ "";
				
					st.executeUpdate(sql);
				
					
				}catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(null,"Error no se ha modificado","Error",JOptionPane.ERROR_MESSAGE);
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"No se ha establecido conexion a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnNewButton_5.setBounds(426, 307, 89, 23);
		contentPane.add(btnNewButton_5);
		
	
	}
}
