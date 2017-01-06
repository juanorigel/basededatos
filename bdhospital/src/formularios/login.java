package formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import clases.Badedatos;
import java.sql.*;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JPasswordField txtpassword;
	private Badedatos bd = null;
	private ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 474, 209);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(156, 38, 114, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(156, 69, 114, 20);
		contentPane.add(txtpassword);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(34, 41, 67, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("contrase\u00F1a");
		lblNewLabel_1.setBounds(34, 69, 67, 17);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean respuesta = false;
				bd = new Badedatos();
				String id = txtID.getText();
				String password = new String(txtpassword.getPassword());
				String sql = "SELECT * FROM login WHERE  Usuario ='"+id+"'AND  Password ='"+password+"'";
				rs = bd.Consultar(sql);
				
				
				try
				{
					while(rs.next())
					{
						respuesta = true;
						
					}
					if(respuesta)
					{
						Principal nuevoP = new Principal();
						nuevoP.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Error de credenciales","Mensaje",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(null,"No ","Error",JOptionPane.ERROR_MESSAGE);
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"No se a conectado bd","Error",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnNewButton.setBounds(115, 116, 83, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(225, 116, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
