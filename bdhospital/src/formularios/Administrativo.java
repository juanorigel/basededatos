package formularios;
import clases.Badedatos;
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
import java.sql.*;
import java.awt.event.ActionEvent;

public class Administrativo extends JFrame {

	private JPanel contentPane;
	private JTextField codigoadmini;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField hora_entrada;
	private JTextField hora_salida;
	private JTextField numero_social;
	private Connection conexion = null;
	private Badedatos bd = null;
	private ResultSet rs = null;
	private JTextField foliomedico;
	private JTextField Foliopaciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrativo frame = new Administrativo();
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
	public Administrativo() {
		setTitle("Personal Administrativo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 407, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		codigoadmini = new JTextField();
		codigoadmini.setBounds(168, 25, 144, 20);
		contentPane.add(codigoadmini);
		codigoadmini.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(168, 56, 144, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(168, 94, 144, 20);
		contentPane.add(apellido);
		apellido.setColumns(10);
		
		hora_entrada = new JTextField();
		hora_entrada.setBounds(168, 125, 144, 20);
		contentPane.add(hora_entrada);
		hora_entrada.setColumns(10);
		
		hora_salida = new JTextField();
		hora_salida.setBounds(168, 156, 144, 20);
		contentPane.add(hora_salida);
		hora_salida.setColumns(10);
		
		numero_social = new JTextField();
		numero_social.setBounds(168, 187, 144, 20);
		contentPane.add(numero_social);
		numero_social.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo Administrativo");
		lblNewLabel.setBounds(33, 28, 125, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(33, 59, 125, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(33, 90, 125, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Horario Entrada");
		lblNewLabel_3.setBounds(33, 121, 125, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Horario Salida");
		lblNewLabel_4.setBounds(33, 152, 125, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Numero Social");
		lblNewLabel_5.setBounds(33, 183, 125, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
					
					String id= codigoadmini.getText();
					String nomb= nombre.getText();
					String ape= apellido.getText();
					String horaE= hora_entrada.getText();
					String horaS= hora_salida.getText();
					String numeroS= numero_social.getText();
					String foliome= Foliopaciente.getText();
					String foliopa= foliomedico.getText();
				
						
						
					Statement st=conexion.createStatement();
								
					String sql = "insert into personal_administrativo values ('"+id+"','"+nomb+"','"+ape+"','"+horaE+"','"+horaS+"','"+numeroS+"','"+foliopa+"','"+foliome+"')";
					st.executeUpdate(sql);
					
					JOptionPane.showMessageDialog(null,"Regristro con exito","Aviso",JOptionPane.INFORMATION_MESSAGE);
						
						}catch(SQLException ex)
						{
							JOptionPane.showMessageDialog(null,"Error de ingreso","Error",JOptionPane.ERROR_MESSAGE);
						}catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null,"No se ha establecido conexion a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
						}		
					
				 codigoadmini.setText(" ");
				 nombre.setText(" ");
				 apellido.setText(" ");
				 hora_entrada.setText(" ");
				 hora_salida.setText(" ");
				 numero_social.setText(" ");
				 foliomedico.setText(" ");
				 Foliopaciente.setText(" ");
				
			}
		});
		btnNewButton.setBounds(20, 278, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
					String id= codigoadmini.getText();
					Statement st=conexion.createStatement();
				
					String sql = "DELETE FROM personal_administrativo  WHERE  codigo_trabajador = " + id +"";
					st.executeUpdate(sql); 
					
					JOptionPane.showMessageDialog(null,"Se ha eliminado con exito","Aviso",JOptionPane.DEFAULT_OPTION);
				}catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(null,"Error no se ha eliminado","Error",JOptionPane.ERROR_MESSAGE);
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"No se ha establecido conexion a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnNewButton_1.setBounds(134, 278, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					bd = new Badedatos();
					String id= codigoadmini.getText();
					
					String sql = "select * from paciente where codigo_paciente='"+id+"'";
					rs = bd.Consultar(sql);
					while(rs.next()){
						codigoadmini.setText(rs.getString("codigo_trabajador"));
						nombre.setText(rs.getString("nombre"));
						apellido.setText(rs.getString("apellidos"));
						hora_entrada.setText(rs.getTime("horarioe") + "");
						hora_salida.setText(rs.getTime("horarioS") + "");
						numero_social.setText(String.valueOf(rs.getInt("numero_segurosocial")));
						
						
					
					 }
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"No se encontrado","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_3.setBounds(246, 278, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Regresar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal nuevoPrincipal=new Principal();
				nuevoPrincipal.setVisible(true);
				
			}
		});
		btnNewButton_4.setBounds(134, 309, 89, 23);
		contentPane.add(btnNewButton_4);
		
		foliomedico = new JTextField();
		foliomedico.setBounds(168, 215, 144, 20);
		contentPane.add(foliomedico);
		foliomedico.setColumns(10);
		
		Foliopaciente = new JTextField();
		Foliopaciente.setBounds(162, 247, 150, 20);
		contentPane.add(Foliopaciente);
		Foliopaciente.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Folio medico");
		lblNewLabel_6.setBounds(33, 218, 125, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Folio paciente");
		lblNewLabel_7.setBounds(33, 250, 125, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton_2 = new JButton("Consultar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostarAdministrativo adminis=new MostarAdministrativo();
				adminis.main(true);
				
			}
		});
		btnNewButton_2.setBounds(20, 312, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}
