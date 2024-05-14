package baitap;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DangKy extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField passTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKy frame = new DangKy();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangKy() {
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
		
		passTextField = new JTextField();
		passTextField.setColumns(10);
		passTextField.setBounds(76, 145, 279, 20);
		contentPane.add(passTextField);
		
		JButton btnNewButton = new JButton("->Trang Đăng Nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DangNhap();
				dispose();
			}
		});
		btnNewButton.setBounds(257, 227, 167, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Đăng Ký");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = JDBC.connect();
				String query = "INSERT INTO `user`(`username`, `password`) VALUES (?,?)";
				try {
					PreparedStatement sta = con.prepareStatement(query);
					sta.setNString(1, usernameTextField.getText());
					sta.setNString(2, MaHoa.mahoa(passTextField.getText()));
					sta.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton_1, "Đăng ký thành công!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(76, 186, 279, 30);
		contentPane.add(btnNewButton_1);
		setVisible(true);
	}
}
