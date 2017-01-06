package formularios;
import clases.Badedatos;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Paciente extends JFrame {

	private JPanel contentPane;
	private JTextField tid;
	private JTextField textNombre;
	private JTextField textA;
	private JTextField textE;
	private JTextField textPe;
	private JTextField textPr;
	private JTextField textT;
	private JTextField textEn;
	private Connection conexion = null;
	private Badedatos bd = null;
	private ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paciente frame = new Paciente();
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
	public Paciente() {
		setTitle("Paciente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 583, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tid = new JTextField();
		tid.setBounds(222, 33, 156, 20);
		contentPane.add(tid);
		tid.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(222, 64, 156, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textA = new JTextField();
		textA.setBounds(222, 95, 156, 20);
		contentPane.add(textA);
		textA.setColumns(10);
		
		textE = new JTextField();
		textE.setBounds(222, 126, 156, 20);
		contentPane.add(textE);
		textE.setColumns(10);
		
		textPe = new JTextField();
		textPe.setBounds(222, 157, 156, 20);
		contentPane.add(textPe);
		textPe.setColumns(10);
		
		textPr = new JTextField();
		textPr.setBounds(222, 188, 156, 20);
		contentPane.add(textPr);
		textPr.setColumns(10);
		
		textT = new JTextField();
		textT.setBounds(222, 219, 156, 20);
		contentPane.add(textT);
		textT.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo Paciente");
		lblNewLabel.setBounds(49, 36, 102, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(49, 67, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(49, 95, 102, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Edad");
		lblNewLabel_3.setBounds(49, 129, 102, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Peso");
		lblNewLabel_4.setBounds(49, 160, 102, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Presion Arterial");
		lblNewLabel_5.setBounds(49, 191, 102, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Temperatura Corporal");
		lblNewLabel_6.setBounds(49, 222, 134, 14);
		contentPane.add(lblNewLabel_6);
		
		textEn = new JTextField();
		textEn.setBounds(222, 250, 156, 20);
		contentPane.add(textEn);
		textEn.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Enfermedad");
		lblNewLabel_7.setBounds(49, 253, 102, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
					String id= tid.getText();
					String nom= textNombre.getText();
					String ape= textA.getText();
					String ed= textE.getText();
					String pe= textPe.getText();
					String pr= textPr.getText();
					String te= textT.getText();
					String en= textEn.getText();
						
						
					Statement st=conexion.createStatement();
						
						
						
					String sql = "insert into paciente values ('"+id+"','"+nom+"','"+ape+"','"+ed+"','"+pe+"','"+pr+"','"+te+"','"+en+"')";
						
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Regristro con exito","Aviso",JOptionPane.INFORMATION_MESSAGE);
						
						}catch(SQLException ex)
						{
							JOptionPane.showMessageDialog(null,"Error de ingreso","Error",JOptionPane.ERROR_MESSAGE);
						}catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null,"No se ha establecido conexion a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
						}		
					
				 tid.setText(" ");
				 textNombre.setText(" ");
				 textA.setText(" ");
				 textE.setText(" ");
				 textPe.setText(" ");
				 textPr.setText(" ");
				 textT.setText(" ");
				 textEn.setText(" ");
				
				
				
			}
		});
		btnNewButton.setBounds(22, 300, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
					String id= tid.getText();
					Statement st=conexion.createStatement();
					
				
					String sql = "DELETE FROM paciente WHERE codigo_paciente = " + id+ "";
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"Se ha eliminado con exito","Aviso",JOptionPane.DEFAULT_OPTION);
				}catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(null,"Error no se ha eliminado","Error",JOptionPane.ERROR_MESSAGE);
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"No se ha establecido conexion a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
				}
				tid.setText("");
				
			}
			
		});
		btnNewButton_1.setBounds(121, 300, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					bd = new Badedatos();
					String id= tid.getText();
					
					String sql = "select * from paciente where codigo_paciente='"+id+"'";
					rs = bd.Consultar(sql);
					while(rs.next()){
						tid.setText(rs.getString("codigo_paciente"));
						textNombre.setText(rs.getString("nombre"));
						textA.setText(rs.getString("apellidos"));
						textE.setText(rs.getString("edad"));
						textPe.setText(String.valueOf(rs.getInt("peso")));
						textPr.setText(String.valueOf(rs.getInt("presion_arterial")));
						textT.setText(String.valueOf(rs.getInt("temperatura_corporal")));
						textEn.setText(rs.getString("enfermedad"));
					
					 }
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"No se ha encontrado","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_3.setBounds(321, 300, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Regresar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal nuevoPrincipal=new Principal();
				nuevoPrincipal.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(420, 300, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("Consultar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				MostarPaciente mostrarPac=new MostarPaciente();
				mostrarPac.main(true);
				
			}
		});
		btnNewButton_2.setBounds(222, 300, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
