package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import clases.Badedatos;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Expediente extends JFrame {

	private JPanel Expediente;
	private JTextField folio;
	private JTextField historial;
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
					Expediente frame = new Expediente();
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
	public Expediente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Expediente = new JPanel();
		Expediente.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		Expediente.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Expediente);
		Expediente.setLayout(null);
		
		folio = new JTextField();
		folio.setBounds(117, 48, 145, 20);
		Expediente.add(folio);
		folio.setColumns(10);
		
		historial = new JTextField();
		historial.setBounds(117, 79, 307, 124);
		Expediente.add(historial);
		historial.setColumns(10);
		
		JLabel lblFolio = new JLabel("Folio");
		lblFolio.setBounds(20, 51, 84, 14);
		Expediente.add(lblFolio);
		
		JLabel lblHistorial = new JLabel("Historial");
		lblHistorial.setBounds(10, 104, 94, 33);
		Expediente.add(lblHistorial);
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
					
					String id=folio.getText();
					String hist= historial.getText();
					
				
						
						
					Statement st=conexion.createStatement();
								
					String sql = "insert into expediente values ('"+id+"','"+hist+"')";
					st.executeUpdate(sql);
					
					
					JOptionPane.showMessageDialog(null,"Regristro con exito","Aviso",JOptionPane.INFORMATION_MESSAGE);
						
						}catch(SQLException ex)
						{
							JOptionPane.showMessageDialog(null,"Error de ingreso","Error",JOptionPane.ERROR_MESSAGE);
						}catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null,"No se ha establecido conexion a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
						}		
					
				 folio.setText(" ");
				 historial.setText(" ");
				
			}
		});
		btnNewButton.setBounds(10, 215, 89, 23);
		Expediente.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					bd = new Badedatos();
					String id= folio.getText();
					
					String sql = "select * from paciente where folio ='"+id+"'";
					rs = bd.Consultar(sql);
					while(rs.next()){
						
						folio.setText(String.valueOf(rs.getInt("folio")));
						historial.setText(rs.getString("historial"));

						
						
						
					
					 }
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"No se ha establecido conexion a la base de datos","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(127, 215, 89, 23);
		Expediente.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gestion_hospitalaria","root","");
					String id=folio.getText();
					Statement st=conexion.createStatement();
				
					String sql = "DELETE FROM expediente  WHERE  folio = " + id +"";
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
		btnNewButton_2.setBounds(226, 214, 89, 23);
		Expediente.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Regresar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal nuevoPrincipal=new Principal();
				nuevoPrincipal.setVisible(true);
				
			}
		});
		btnNewButton_3.setBounds(325, 214, 89, 23);
		Expediente.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Consultar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarExpediente mostrarex=new MostrarExpediente();
				mostrarex.main(true);
			}
		});
		btnNewButton_4.setBounds(288, 47, 89, 23);
		Expediente.add(btnNewButton_4);
	}

}
