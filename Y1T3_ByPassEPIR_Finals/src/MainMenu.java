
//This is the Main Class and the Main Menu of the system. This is where the system is launched and initialized.
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class MainMenu extends Products {

	getImages images = new getImages();
	DecimalFormat df = new DecimalFormat("#,###.00");

	private String[] Products = { "[SONY] LED TV", "[AudioVox] LED TV", "[Panasonic] Video Camera",
			"[SONY] U-Matic Player", "[Fender] Audio Amplifier", "[SAMSUNG] LED TV",
			"[ALLEN & HEATH] Digital Audio Mixer", "[Whirlpool] Microwave", "[Panasonic] Tape Player",
			"[Sakura] Audio Amplifier" };

	private JFrame frameMain;
	private Map<String, ImageIcon> imageMap;
	private JTextField textField_Filter;
	private JList listProducts = createJList();
	JLabel lblProductInfo;
	JTextField lblProductStockData, lblProductCurrentPrice;
	private static String printInfo, textFieldValue = "";
	JTabbedPane tabbedPaneMain;

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frameMain = new JFrame();
		frameMain.getContentPane().setBackground(new Color(162, 174, 187));
		frameMain.setBounds(100, 100, 1000, 650);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);
		frameMain.setResizable(false);
		frameMain.setVisible(true);

		// This makes the window open on the center of the screen//
		frameMain.setLocationRelativeTo(null);
		
		JButton btnProducts = new JButton("");
		btnProducts.setBounds(20, 218, 120, 34);
		btnProducts.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnProducts.setOpaque(false);
		btnProducts.setContentAreaFilled(false);
		btnProducts.setBorderPainted(false);
		frameMain.getContentPane().add(btnProducts);
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPaneMain.setSelectedIndex(0);
			}
			
		});
		
		JButton btnRepair = new JButton("");
		btnRepair.setBounds(20, 284, 120, 34);
		btnRepair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRepair.setOpaque(false);
		btnRepair.setContentAreaFilled(false);
		btnRepair.setBorderPainted(false);
		frameMain.getContentPane().add(btnRepair);
		btnRepair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepairMenu rprMen = new RepairMenu();
				rprMen.setVisible(true);
				frameMain.dispose();
			}
			
		});
		
		JButton btnAbout = new JButton("");
		btnAbout.setBounds(20, 350, 120, 34);
		btnAbout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAbout.setOpaque(false);
		btnAbout.setContentAreaFilled(false);
		btnAbout.setBorderPainted(false);
		frameMain.getContentPane().add(btnAbout);
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPaneMain.setSelectedIndex(1);
			}
			
		});
		
		JButton btnLogout = new JButton("");
		btnLogout.setBounds(20, 550, 120, 34);
		btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogout.setOpaque(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		frameMain.getContentPane().add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You have Logged Out!");
				frameMain.dispose();
			}
			
		});
		
		// ------------------------------------------------------//

		JLabel lblBtnLogout_img = new JLabel("");
		lblBtnLogout_img.setIcon(images.logoutIMG);
		lblBtnLogout_img.setBounds(0, 478, 200, 200);
		frameMain.getContentPane().add(lblBtnLogout_img);

		JLabel lblBtnAbout_img = new JLabel("");
		lblBtnAbout_img.setIcon(images.aboutIMG);
		lblBtnAbout_img.setBounds(0, 284, 200, 200);
		frameMain.getContentPane().add(lblBtnAbout_img);

		JLabel lblBtnRepair_img = new JLabel("");
		lblBtnRepair_img.setIcon(images.repairIMG);
		lblBtnRepair_img.setBounds(0, 218, 200, 200);
		frameMain.getContentPane().add(lblBtnRepair_img);

		JLabel lblBtnInventory_img = new JLabel("");
		lblBtnInventory_img.setIcon(images.inventoryIMG);
		lblBtnInventory_img.setBounds(0, 152, 200, 200);
		frameMain.getContentPane().add(lblBtnInventory_img);

		JLabel lblLogo_img = new JLabel("");
		lblLogo_img.setIcon(images.logoIMG);
		lblLogo_img.setBounds(0, 10, 200, 200);
		frameMain.getContentPane().add(lblLogo_img);

		tabbedPaneMain = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneMain.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPaneMain.setBackground(new Color(162, 174, 187));
		tabbedPaneMain.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		tabbedPaneMain.setBounds(164, -26, 822, 639);
		frameMain.getContentPane().add(tabbedPaneMain);

		JPanel panelInventory = new JPanel();
		panelInventory.setBorder(null);
		panelInventory.setBackground(new Color(114, 132, 152));
		tabbedPaneMain.addTab("Available Products", null, panelInventory, null);
		panelInventory.setLayout(null);

		JPanel panelProductList = new JPanel();
		panelProductList.setBorder(null);
		panelProductList.setBackground(new Color(114, 132, 152));
		panelProductList.setBounds(10, 10, 492, 590);
		panelInventory.add(panelProductList);
		panelProductList.setLayout(null);

		imageMap = createImageMap(Products);

		listProducts.setCellRenderer(new Renderer());
		listProducts.setBorder(new LineBorder(new Color(0, 0, 0)));
		listProducts.setVisibleRowCount(-1);
		listProducts.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listProducts.setFont(new Font("Segoe UI Variable", Font.BOLD, 5));
		listProducts.setBackground(new Color(162, 174, 187));
		listProducts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProducts.setBounds(10, 10, 472, 570);
		listProducts.setSelectedIndex(-1);
		listProducts.setFixedCellWidth(230);
		listProducts.setFixedCellHeight(150);
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) listProducts.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);
		panelProductList.add(listProducts);

		listProducts.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					printInfo = (String) listProducts.getSelectedValue();
					lblProductStockData.setEditable(true);
					if ((printInfo == null)) {
						printInfo = "";
					} else {
						switch (printInfo) {
						case "[SONY] LED TV":
							lblProductInfo.setText("<html>Product: " + sonyLedTV.getProduct() +
									"<br>Brand: " + sonyLedTV.getProductBrand() + 
									"<br>Name: " + sonyLedTV.getProductName() + 
									"<br>Original Price: P" + df.format(sonyLedTV.getOriginalPrice()) + "</html>");
							lblProductCurrentPrice.setText("P"+ df.format(sonyLedTV.getCurrentPrice()));
							if(!(sonyLedTV.getNumOfStocks() == 0)) {
								lblProductStockData.setText(""+ sonyLedTV.getNumOfStocks());
							}
							else {
								lblProductStockData.setText("Out of Stock");
							}
							break;
							
						case "[AudioVox] LED TV":
							lblProductInfo.setText("<html>Product: " + audioVoxLedTV.getProduct() +
									"<br>Brand: " + audioVoxLedTV.getProductBrand() + 
									"<br>Name: " + audioVoxLedTV.getProductName() + 
									"<br>Original Price: P" + df.format(audioVoxLedTV.getOriginalPrice()) + "</html>");
							lblProductCurrentPrice.setText("P"+ df.format(audioVoxLedTV.getCurrentPrice()));
							if(!(audioVoxLedTV.getNumOfStocks() == 0)) {
								lblProductStockData.setText(""+ audioVoxLedTV.getNumOfStocks());
							}
							else {
								lblProductStockData.setText("Out of Stock");
							}
							break;
							
						case "[Panasonic] Video Camera":
							lblProductInfo.setText("<html>Product: " + panasonicVideoCamera.getProduct() +
									"<br>Brand: " + panasonicVideoCamera.getProductBrand() + 
									"<br>Name: " + panasonicVideoCamera.getProductName() + 
									"<br>Original Price: P" + df.format(panasonicVideoCamera.getOriginalPrice()) + "</html>");
							lblProductCurrentPrice.setText("P"+ df.format(panasonicVideoCamera.getCurrentPrice()));
							if(!(panasonicVideoCamera.getNumOfStocks() == 0)) {
								lblProductStockData.setText(""+ panasonicVideoCamera.getNumOfStocks());
							}
							else {
								lblProductStockData.setText("Out of Stock");
							}
							break;
							
						case "[SONY] U-Matic Player":
							lblProductInfo.setText("<html>Product: " + sonyUMaticPlayer.getProduct() +
									"<br>Brand: " + sonyUMaticPlayer.getProductBrand() + 
									"<br>Name: " + sonyUMaticPlayer.getProductName() + 
									"<br>Original Price: P" + df.format(sonyUMaticPlayer.getOriginalPrice()) + "</html>");
							lblProductCurrentPrice.setText("P"+ df.format(sonyUMaticPlayer.getCurrentPrice()));
							if(!(sonyUMaticPlayer.getNumOfStocks() == 0)) {
								lblProductStockData.setText(""+ sonyUMaticPlayer.getNumOfStocks());
							}
							else {
								lblProductStockData.setText("Out of Stock");
							}
							break;
							
						case "[Fender] Audio Amplifier":
							lblProductInfo.setText("<html>Product: " + fenderAudioAmplifier.getProduct() +
									"<br>Brand: " + fenderAudioAmplifier.getProductBrand() + 
									"<br>Name: " + fenderAudioAmplifier.getProductName() + 
									"<br>Original Price: P" + df.format(fenderAudioAmplifier.getOriginalPrice()) + "</html>");
							lblProductCurrentPrice.setText("P"+ df.format(fenderAudioAmplifier.getCurrentPrice()));
							if(!(fenderAudioAmplifier.getNumOfStocks() == 0)) {
								lblProductStockData.setText(""+ fenderAudioAmplifier.getNumOfStocks());
							}
							else {
								lblProductStockData.setText("Out of Stock");
							}
							break;
							
						case "[SAMSUNG] LED TV":
							lblProductInfo.setText("<html>Product: " + samsungLedTV.getProduct() +
									"<br>Brand: " + samsungLedTV.getProductBrand() + 
									"<br>Name: " + samsungLedTV.getProductName() + 
									"<br>Original Price: P" + df.format(samsungLedTV.getOriginalPrice()) + "</html>");
							lblProductCurrentPrice.setText("P"+ df.format(samsungLedTV.getCurrentPrice()));
							if(!(samsungLedTV.getNumOfStocks() == 0)) {
								lblProductStockData.setText(""+ samsungLedTV.getNumOfStocks());
							}
							else {
								lblProductStockData.setText("Out of Stock");
							}
							break;
							
						case "[ALLEN & HEATH] Digital Audio Mixer":
								lblProductInfo.setText("<html>Product: " + allenHeathDigitalAudioMixer.getProduct() +
										"<br>Brand: " + allenHeathDigitalAudioMixer.getProductBrand() + 
										"<br>Name: " + allenHeathDigitalAudioMixer.getProductName() + 
										"<br>Original Price: P" + df.format(allenHeathDigitalAudioMixer.getOriginalPrice()) +
										"<br>Current Price: P" + df.format(allenHeathDigitalAudioMixer.getCurrentPrice()) + "</html>");
								lblProductCurrentPrice.setText("P"+ df.format(allenHeathDigitalAudioMixer.getCurrentPrice()));
								if(!(allenHeathDigitalAudioMixer.getNumOfStocks() == 0)) {
									lblProductStockData.setText(""+ allenHeathDigitalAudioMixer.getNumOfStocks());
								}
								else {
									lblProductStockData.setText("Out of Stock");
								}
							break;
							
						case "[Whirlpool] Microwave":
							lblProductInfo.setText("<html>Product: " + whirlpoolMicrowave.getProduct() +
									"<br>Brand: " + whirlpoolMicrowave.getProductBrand() + 
									"<br>Name: " + whirlpoolMicrowave.getProductName() + 
									"<br>Original Price: P" + df.format(whirlpoolMicrowave.getOriginalPrice()) + "</html>");
							lblProductCurrentPrice.setText("P"+ df.format(whirlpoolMicrowave.getCurrentPrice()));
							if(!(whirlpoolMicrowave.getNumOfStocks() == 0)) {
								lblProductStockData.setText(""+ whirlpoolMicrowave.getNumOfStocks());
							}
							else {
								lblProductStockData.setText("Out of Stock");
							}
							break;
							
						case "[Panasonic] Tape Player":
							lblProductInfo.setText("<html>Product: " + panasonicTapePlayer.getProduct() +
									"<br>Brand: " + panasonicTapePlayer.getProductBrand() + 
									"<br>Name: " + panasonicTapePlayer.getProductName() + 
									"<br>Original Price: P" + df.format(panasonicTapePlayer.getOriginalPrice()) + "</html>");
							lblProductCurrentPrice.setText("P"+ df.format(panasonicTapePlayer.getCurrentPrice()));
							if(!(panasonicTapePlayer.getNumOfStocks() == 0)) {
								lblProductStockData.setText(""+ panasonicTapePlayer.getNumOfStocks());
							}
							else {
								lblProductStockData.setText("Out of Stock");
							}
							break;
							
						case "[Sakura] Audio Amplifier":
							lblProductInfo.setText("<html>Product: " + sakuraAudioAmplifier.getProduct() +
									"<br>Brand: " + sakuraAudioAmplifier.getProductBrand() + 
									"<br>Name: " + sakuraAudioAmplifier.getProductName() + 
									"<br>Original Price: P" + df.format(sakuraAudioAmplifier.getOriginalPrice()) + "</html>");
							lblProductCurrentPrice.setText("P"+ df.format(sakuraAudioAmplifier.getCurrentPrice()));
							if(!(sakuraAudioAmplifier.getNumOfStocks() == 0)) {
								lblProductStockData.setText(""+ sakuraAudioAmplifier.getNumOfStocks());
							}
							else {
								lblProductStockData.setText("Out of Stock");
							}
							break;
							
						default:
							System.out.println("Data null");
							break;
						}
					}
				}

			}

		});

		JScrollPane scrollPane = new JScrollPane(listProducts);
		scrollPane.setBounds(0, 40, 492, 550);
		/*
		 * scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
		 * 
		 * @Override protected void configureScrollBarColors() { this.thumbColor =
		 * Color.decode("#DFE0E2"); } });
		 * scrollPane.getVerticalScrollBar().setBackground(Color.decode("#949E9E"));
		 * scrollPane.getHorizontalScrollBar().setBackground(Color.decode("#949E9E"));
		 */
		panelProductList.add(scrollPane);
		panelProductList.add(createTextField(), BorderLayout.PAGE_END);

		JPanel panelProductInfo = new JPanel();
		panelProductInfo.setBackground(new Color(162, 174, 187));
		panelProductInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelProductInfo.setBounds(512, 10, 295, 428);
		panelInventory.add(panelProductInfo);
		panelProductInfo.setLayout(null);
		
		lblProductInfo = new JLabel("Select a Product");
		lblProductInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductInfo.setVerticalAlignment(SwingConstants.TOP);
		lblProductInfo.setBounds(10, 10, 275, 381);
		panelProductInfo.add(lblProductInfo);

		JPanel panelProductOthers = new JPanel();
		panelProductOthers.setBackground(new Color(162, 174, 187));
		panelProductOthers.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelProductOthers.setBounds(512, 448, 295, 152);
		panelInventory.add(panelProductOthers);
		panelProductOthers.setLayout(null);
		
		JLabel lblProductStock = new JLabel("<html>Available Stock:<br><br>Current Price:<html>");
		lblProductStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductStock.setBounds(10, 23, 117, 72);
		panelProductOthers.add(lblProductStock);
		
		lblProductStockData = new JTextField("");
		lblProductStockData.setEditable(false);
		lblProductStockData.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductStockData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductStockData.setBounds(137, 23, 142, 31);
		panelProductOthers.add(lblProductStockData);
		
		lblProductCurrentPrice = new JTextField("");
		lblProductCurrentPrice.setEditable(false);
		lblProductCurrentPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductCurrentPrice.setBounds(137, 64, 142, 31);
		panelProductOthers.add(lblProductCurrentPrice);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(137, 105, 142, 31);
		panelProductOthers.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentValue = lblProductStockData.getText();
				if(!(printInfo == null)) {
					if(!currentValue.isEmpty()) {
						if(currentValue.matches("\\d+")) {
							if(!currentValue.matches(textFieldValue)) {
								textFieldValue = currentValue;
								int updated = Integer.parseInt(textFieldValue);
								
								switch (printInfo){
								case "[SONY] LED TV":
									sonyLedTV.setNumOfStocks(updated);
									break;
									
								case "[AudioVox] LED TV":
									
									break;
									
								case "[Panasonic] Video Camera":
									
									break;
									
								case "[SONY] U-Matic Player":
									
									break;
									
								case "[Fender] Audio Amplifier":
									
									break;
									
								case "[SAMSUNG] LED TV":
									
									break;
									
								case "[ALLEN & HEATH] Digital Audio Mixer":
										
									break;
									
								case "[Whirlpool] Microwave":
									
									break;
									
								case "[Panasonic] Tape Player":
									
									break;
									
								case "[Sakura] Audio Amplifier":
									
									break;
									
								default:
									System.out.println("Data null");
									break;
								}
								JOptionPane.showMessageDialog(null, "Updated.",
										"Error", JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								JOptionPane.showMessageDialog(null, "You have made no changes to the field.",
										"Error", JOptionPane.WARNING_MESSAGE);
							}
						}
						else if(currentValue.equals("Out of Stock")) {
							JOptionPane.showMessageDialog(null, "You have made no changes to the field.",
									"Error", JOptionPane.WARNING_MESSAGE);
						}
						else {
						JOptionPane.showMessageDialog(null, "Please only enter numbers.", "Error", JOptionPane.WARNING_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Field is Empty",
								"Error", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				else {
						JOptionPane.showMessageDialog(null, "There is no selected product.", "Error", JOptionPane.WARNING_MESSAGE);
					}
			}
		});

		JPanel panelRepair = new JPanel();
		panelRepair.setBackground(new Color(223, 224, 226));
		tabbedPaneMain.addTab("Products in Repair", null, panelRepair, null);

		JPanel panelAbout = new JPanel();
		panelAbout.setBackground(new Color(223, 224, 226));
		FlowLayout flowLayout = (FlowLayout) panelAbout.getLayout();
		tabbedPaneMain.addTab("About Us", null, panelAbout, null);

		JLabel lblBackBG_img = new JLabel("");
		lblBackBG_img.setIcon(images.backBG);
		lblBackBG_img.setBounds(0, 0, 986, 613);
		frameMain.getContentPane().add(lblBackBG_img);
	}

	public class Renderer extends DefaultListCellRenderer {

		Font font = new Font("helvitica", Font.BOLD, 12);

		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {

			JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.BOTTOM);
			label.setFont(font);
			label.setIcon(imageMap.get((String) value));
			return label;
		}
	}

	private Map<String, ImageIcon> createImageMap(String[] list) {
		Map<String, ImageIcon> map = new HashMap<>();
		try {
			map.put("[SONY] LED TV", new ImageIcon(images.SonyTV));
			map.put("[AudioVox] LED TV", new ImageIcon(images.AudioVoxTV));
			map.put("[Panasonic] Video Camera", new ImageIcon(images.PanasonicVidCam));
			map.put("[SONY] U-Matic Player", new ImageIcon(images.SonyUMaticPlayer));
			map.put("[Fender] Audio Amplifier", new ImageIcon(images.FenderAudioAmp));
			map.put("[SAMSUNG] LED TV", new ImageIcon(images.SamsungTV));
			map.put("[ALLEN & HEATH] Digital Audio Mixer", new ImageIcon(images.AllenHeathDigiAudMix));
			map.put("[Whirlpool] Microwave", new ImageIcon(images.WhirlpoolMicrowave));
			map.put("[Panasonic] Tape Player", new ImageIcon(images.PanasonicTapePlayer));
			map.put("[Sakura] Audio Amplifier", new ImageIcon(images.SakuraAudioAmp));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}

	private JTextField createTextField() {
		final JTextField txtSearch = new JTextField(15);
		txtSearch.setForeground(Color.LIGHT_GRAY);
		txtSearch.setText(" Search");
		txtSearch.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		txtSearch.setBounds(0, 0, 492, 30);
		txtSearch.setColumns(10);
		txtSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listProducts.clearSelection();
				txtSearch.setForeground(Color.BLACK);
				txtSearch.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
				txtSearch.setText("");
			}
		});
		txtSearch.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				filter();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				filter();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}

			private void filter() {
				String filter = txtSearch.getText();
				filterModel((DefaultListModel<String>) listProducts.getModel(), filter);
			}
		});
		return txtSearch;
	}

	private JList createJList() {
		JList list = new JList(createDefaultListModel());
		list.setVisibleRowCount(-1);
		return list;
	}

	private ListModel<String> createDefaultListModel() {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (String s : Products) {
			model.addElement(s);
		}
		return model;
	}

	public void filterModel(DefaultListModel<String> model, String filter) {

		for (String s : Products) {
			if (!s.contains(filter)) {
				if (model.contains(s)) {
					model.removeElement(s);
				}
			} else {
				if (!model.contains(s)) {
					model.addElement(s);
				}
			}
		}
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
