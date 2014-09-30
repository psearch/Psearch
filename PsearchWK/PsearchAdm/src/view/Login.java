package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import control.PessoaDAO;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JPasswordField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Login frame = new Login();
					frame.setLocationRelativeTo(null);  
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
	public Login() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("i\\adi_icon.png"));
		setResizable(false);
		
		setType(Type.UTILITY);
		setTitle("Professional Position Admin ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setHorizontalAlignment(SwingConstants.LEFT);
		btnLimpar.setIcon(new ImageIcon("i\\clean.png"));
		btnLimpar.setBounds(172, 123, 102, 34);
		contentPane.add(btnLimpar);

		txtusuario = new JTextField();
		txtusuario.setBounds(105, 32, 102, 26);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);

		
		
		txtsenha = new JPasswordField();
		txtsenha.setBounds(105, 75, 102, 25);
		contentPane.add(txtsenha);

		
		JLabel lblUsurio = new JLabel("Usuário");
		lblUsurio.setBounds(43, 38, 69, 14);
		contentPane.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(43, 80, 46, 14);
		contentPane.add(lblSenha);

		ImageIcon icon = new ImageIcon("i/ADM.png"); 

		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.setBounds(217, 11, 106, 107);
		contentPane.add(lblNewLabel);

		JButton btnLogin = new JButton("Login");
		btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogin.setIcon(new ImageIcon("i\\key.png"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogin.setBounds(43, 123, 116, 34);
		contentPane.add(btnLogin);

		JCheckBox cbgravaruser = new JCheckBox("Gravar usuuário");
		cbgravaruser.setBounds(90, 164, 131, 23);
		contentPane.add(cbgravaruser);
		
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal m = new MenuPrincipal();
				PessoaDAO d = new PessoaDAO();
		String email = txtsenha.getText();
		String senha =txtusuario.getText();
				if(d.Autenticarr(email,senha)==true){
					m.setVisible(true);
					m.setLocationRelativeTo(null); 
					
				}else{
					JOptionPane.showMessageDialog(null,"Usuário ou senha incorretos");
					System.out.println(d.Autenticarr(email,senha));
				}
			}
			
		});


		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtusuario.setText("");
				txtsenha.setText("");
			}
		});
	}


}
