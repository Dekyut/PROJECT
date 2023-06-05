import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RepairMenu extends JFrame {

    private JPanel contentPane;
    private JTextField customerNameTextField;
    private JTextField contactNoTextField;
    private JTextField emailTextField;
    private JTextField productTextField;
    private JTextField productIssueTextField;
    private JTextField dateReceivedTextField;
    private JTextField estimatedTextField;
    private JTable repairTable;
    private JScrollPane scrollPane;
    private JLabel BackGroundLabel;
    private JLabel NameLabel;
    private JLabel ContactLabel;
    private JLabel EmailLabel;
    private JLabel ProductLabel;
    private JLabel IssueLabel;
    private JLabel dateReceivedLabel;
    private JLabel EstLabel;
    private JLabel EstLabel2;
    private JButton UpdateButton;
    private JLabel InventoryBtn;
    private JLabel RepairBtn;
    private JLabel LogoutBtn;
    private JLabel InventoryBtn_3;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RepairMenu frame = new RepairMenu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RepairMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        customerNameTextField = new JTextField();
        customerNameTextField.setBounds(354, 242, 174, 26);
        contentPane.add(customerNameTextField);
        customerNameTextField.setColumns(10);

        contactNoTextField = new JTextField();
        contactNoTextField.setColumns(10);
        contactNoTextField.setBounds(354, 296, 174, 26);
        contentPane.add(contactNoTextField);

        emailTextField = new JTextField();
        emailTextField.setColumns(10);
        emailTextField.setBounds(354, 351, 174, 26);
        contentPane.add(emailTextField);

        productTextField = new JTextField();
        productTextField.setColumns(10);
        productTextField.setBounds(354, 402, 174, 26);
        contentPane.add(productTextField);

        productIssueTextField = new JTextField();
        productIssueTextField.setColumns(10);
        productIssueTextField.setBounds(713, 242, 174, 26);
        contentPane.add(productIssueTextField);

        dateReceivedTextField = new JTextField();
        dateReceivedTextField.setColumns(10);
        dateReceivedTextField.setBounds(713, 296, 174, 26);
        contentPane.add(dateReceivedTextField);

        estimatedTextField = new JTextField();
        estimatedTextField.setColumns(10);
        estimatedTextField.setBounds(713, 351, 174, 26);
        contentPane.add(estimatedTextField);

        JPanel panel = new JPanel();
        panel.setBounds(315, 30, 645, 158);
        contentPane.add(panel);
        panel.setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 0, 645, 125);
        panel.add(scrollPane);

        repairTable = new JTable();
        scrollPane.setViewportView(repairTable);
        repairTable.setFont(new Font("Segoe UI Variable", Font.PLAIN, 11));
        repairTable.setBorder(new LineBorder(new Color(0, 0, 0)));
        repairTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Customer Name", "Contact Number", "Email", "Product", "Product Issue", "Date Received", "Est. Completion Date"
        	}
        ));

        JButton saveButton = new JButton("SAVE");
        saveButton.setBackground(new Color(153, 204, 51));
        saveButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (customerNameTextField.getText().isEmpty() || contactNoTextField.getText().isEmpty()
                        || emailTextField.getText().isEmpty() || productTextField.getText().isEmpty()
                        || productIssueTextField.getText().isEmpty() || dateReceivedTextField.getText().isEmpty()
                        || estimatedTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter Every Data Needed");
                } else {
                    String customerName = customerNameTextField.getText();
                    String contactNo = contactNoTextField.getText();
                    String customerEmail = emailTextField.getText();
                    String productName = productTextField.getText();
                    String productIssue = productIssueTextField.getText();
                    String dateReceived = dateReceivedTextField.getText();
                    String estimateDate = estimatedTextField.getText();

                    try (FileWriter writer = new FileWriter("RepairData.txt", true)) {
                        writer.write(customerName + "," + contactNo + "," + customerEmail + "," + productName + ","
                                + productIssue + "," + dateReceived + "," + estimateDate + System.lineSeparator());
                        writer.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    DefaultTableModel repairTblModel = (DefaultTableModel) repairTable.getModel();

                    repairTblModel.addRow(new Object[] { customerName, contactNo, customerEmail, productName,
                            productIssue, dateReceived, estimateDate });
                }
            }
        });
        saveButton.setBounds(263, 458, 117, 37);
        contentPane.add(saveButton);

        JButton removeButton = new JButton("REMOVE");
        removeButton.setBackground(new Color(255, 0, 0));
        removeButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = repairTable.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel repairTblModel = (DefaultTableModel) repairTable.getModel();
                    String rowContent = "";
                    for (int i = 0; i < repairTblModel.getColumnCount(); i++) {
                        rowContent += repairTblModel.getValueAt(selectedRow, i);
                        if (i < repairTblModel.getColumnCount() - 1) {
                            rowContent += ",";
                        }
                    }
                    repairTblModel.removeRow(selectedRow);
                    removeRowFromFile(rowContent);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to remove.");
                }
            }
        });
        removeButton.setBounds(806, 458, 117, 37);
        contentPane.add(removeButton);
        
        
        NameLabel = new JLabel("Enter Name:");
        NameLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
        NameLabel.setBounds(227, 241, 115, 20);
        contentPane.add(NameLabel);
        
        ContactLabel = new JLabel("Contact No. :");
        ContactLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
        ContactLabel.setBounds(227, 295, 115, 20);
        contentPane.add(ContactLabel);
        
        EmailLabel = new JLabel("Email:");
        EmailLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
        EmailLabel.setBounds(227, 350, 115, 20);
        contentPane.add(EmailLabel);
        
        ProductLabel = new JLabel("Product:");
        ProductLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
        ProductLabel.setBounds(227, 402, 115, 20);
        contentPane.add(ProductLabel);
        
        IssueLabel = new JLabel("Product Issue:");
        IssueLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
        IssueLabel.setBounds(577, 242, 115, 20);
        contentPane.add(IssueLabel);
        
        dateReceivedLabel = new JLabel("Date Received:");
        dateReceivedLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
        dateReceivedLabel.setBounds(577, 295, 115, 20);
        contentPane.add(dateReceivedLabel);
        
        EstLabel = new JLabel("Est. Date of ");
        EstLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
        EstLabel.setBounds(577, 338, 115, 20);
        contentPane.add(EstLabel);
        
        EstLabel2 = new JLabel("Completion:");
        EstLabel2.setFont(new Font("Segoe UI Variable", Font.BOLD, 15));
        EstLabel2.setBounds(577, 357, 115, 20);
        contentPane.add(EstLabel2);
        
        
        
        UpdateButton = new JButton("VIEW");
        UpdateButton.setBackground(new Color(0, 204, 255));
        UpdateButton.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
        UpdateButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DefaultTableModel repairTblModel = (DefaultTableModel) repairTable.getModel();
                repairTblModel.setRowCount(0); // Clear existing rows

                try (BufferedReader bufferedReader = new BufferedReader(new FileReader("RepairData.txt"))) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] values = line.split(",");
                        repairTblModel.addRow(values);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        	}
        });
        UpdateButton.setBounds(450, 458, 117, 37);
        contentPane.add(UpdateButton);
        
        
        InventoryBtn = new JLabel("");
        InventoryBtn.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		MainMenu mainMen = new MainMenu();
        		mainMen.setVisible(true);
        		dispose();
        	}
        });
        InventoryBtn.setBounds(22, 198, 141, 37);
        contentPane.add(InventoryBtn);
        
        RepairBtn = new JLabel("");
        RepairBtn.setBounds(22, 263, 141, 37);
        contentPane.add(RepairBtn);
        
        LogoutBtn = new JLabel("");
        LogoutBtn.setBounds(22, 333, 141, 37);
        contentPane.add(LogoutBtn);
        
        JButton btnClear = new JButton("CLEAR");
        btnClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 customerNameTextField.setText("");
                 contactNoTextField.setText("");
                 emailTextField.setText("");
                 productTextField.setText("");
                 productIssueTextField.setText("");
                 dateReceivedTextField.setText("");
                 estimatedTextField.setText("");
        		
        	}
        });
        btnClear.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
        btnClear.setBackground(new Color(204, 255, 51));
        btnClear.setBounds(625, 458, 117, 37);
        contentPane.add(btnClear);
        
        InventoryBtn_3 = new JLabel("");
        InventoryBtn_3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		JOptionPane.showMessageDialog(null, "You have Logged Out!");
				dispose();
        	}
        });
        InventoryBtn_3.setBounds(22, 531, 141, 37);
        contentPane.add(InventoryBtn_3);
        
        
        BackGroundLabel = new JLabel("");
        BackGroundLabel.setIcon(new ImageIcon("C:\\Users\\Lovely\\eclipse-workspace\\Y1T3_ByPassEPIR_Finals\\img\\bg\\RepairBG.png"));
        BackGroundLabel.setBounds(0, 0, 986, 613);
        contentPane.add(BackGroundLabel);
        
    
        // Contact Number Input Validation
        contactNoTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) || contactNoTextField.getText().length() >= 11) {
                    evt.consume();
                }
            }
        });
    }

    private void removeRowFromFile(String rowContent) {
        try {
            File inputFile = new File("RepairData.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (!currentLine.equals(rowContent)) {
                    writer.write(currentLine + System.lineSeparator());
                }
            }
            writer.close();
            reader.close();

            // Rename the temporary file to the original file
            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
