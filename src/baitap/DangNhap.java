package baitap;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DangNhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên Đăng Nhập");
		lblNewLabel.setBounds(76, 50, 254, 14);
		contentPane.add(lblNewLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(76, 75, 279, 20);
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("Mật Khẩu");
		lblMtKhu.setBounds(76, 120, 254, 14);
		contentPane.add(lblMtKhu);
		
		JButton btnNewButton = new JButton("->Trang Đăng Ký");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DangKy();
				dispose();
			}
		});
		btnNewButton.setBounds(295, 227, 129, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Đăng Nhập");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = JDBC.connect();
				String query = "SELECT `password` FROM `user` WHERE username = '"+usernameTextField.getText()+"'";
				try {
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					while(rs.next()) {
						
						if(rs.getString(1).equals(MaHoa.mahoa(passwordField.getText()))) {
							
							new TrangChu();
							dispose();
							return;
						}
					}
					JOptionPane.showMessageDialog(btnNewButton_1, "Sai tên đăng nhập hoặc mật khẩu!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(76, 186, 279, 30);
		contentPane.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(76, 145, 279, 20);
		contentPane.add(passwordField);
		setVisible(true);
	}

}
