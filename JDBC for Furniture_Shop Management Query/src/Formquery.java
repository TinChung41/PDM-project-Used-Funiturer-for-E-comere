import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Formquery extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Formquery() {
		setBackground(new Color(128, 128, 192));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 856);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(56, 112, 112));
		contentPane.setForeground(new Color(56, 114, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FURNITURE_SHOP MANAGEMENT");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel.setBounds(436, 25, 362, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 104, 90, 33);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(86, 106, 953, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(86, 202, 953, 562);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("Execute");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBackground(new Color(173, 179, 138));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				        String query = textField.getText();
				       
				        if (query.trim().isEmpty()) {
				            JOptionPane.showMessageDialog(null, "Truy xuất dữ liệu đi nào ", "Message", JOptionPane.WARNING_MESSAGE);
				            return;
				        }
				        else
				        	JOptionPane.showMessageDialog(null, "Truy xuất thành công ", "Message", JOptionPane.PLAIN_MESSAGE);
				        	
				        
				        try (Connection connection = getConnection();
				             Statement stmt = connection.createStatement();
				             ResultSet rs = stmt.executeQuery(query)) {
				            
				            // Iterate through the data in the result set and display it.
				            // process query results
				            StringBuilder results = new StringBuilder();
				            ResultSetMetaData metaData = rs.getMetaData();
				            int numberOfColumns = metaData.getColumnCount();
				            for (int i = 1; i <= numberOfColumns; i++) {
				                results.append(metaData.getColumnName(i)).append("\t");
				            }
				            results.append("\n");
				            //  Metadata
				            while (rs.next()) {
				                for (int i = 1; i <= numberOfColumns; i++) {
				                    results.append(rs.getObject(i)).append("\t");
				                }
				                results.append("\n");
				            }
				            textArea.setText(results.toString());
				            
				        } catch (SQLException ex) {            
				            textArea.setText(ex.getMessage());
				        }
				    
				

			}
		});
		btnNewButton.setBounds(950, 154, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
	public static Connection getConnection() // connection to database
	{
		Connection connection = null;
		try {
			connection  = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Furniture_Shop;user=Furniture;password=123456");
		}
		catch( Exception ex)
		{
			ex.printStackTrace();
			   
		
			     }
		return connection;
		
	}
}
