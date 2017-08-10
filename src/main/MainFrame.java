package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dataBase.Zmogus;
import dataBase.ZmogusDao;

public class MainFrame extends JFrame implements ActionListener {
	
	private TextField id; 
	private TextField vardas;
	private TextField pavarde;
	
	JButton mygtukas=new JButton("add");
	JButton mygtukas1=new JButton("update");
	JButton mygtukas2=new JButton("delete");
	JButton mygtukas3=new JButton("show");
	JButton mygtukas4=new JButton("showAll");
	
	JTable table = new JTable(new DefaultTableModel(new Object[]{"Nr", "Id", "Vardas", "Pavarde"}, 0));
	DefaultTableModel model = (DefaultTableModel) table.getModel();
	
	
	public void actionPerformed(ActionEvent event){
		
	int id=0;
	
	try {
	  id = Integer.parseInt(this.id.getText().toString());
	} catch(NumberFormatException nfe) {
	}
	
	String vardas = this.vardas.getText().toString();
	String pavarde = this.pavarde.getText().toString();	
	
	ZmogusDao zmogusDao = new ZmogusDao();
	Zmogus zmogus = new Zmogus(id, vardas, pavarde);
	
	if(event.getSource() == mygtukas){
		zmogusDao.addZmogus(zmogus);
	} else if (event.getSource() == mygtukas2){
		zmogusDao.deleteZmogus(id);
	} else if (event.getSource() == mygtukas1){
		zmogusDao.updateZmogus(zmogus);
	} else if (event.getSource() == mygtukas3){
		JOptionPane.showMessageDialog(this, "Vardas " +zmogusDao.getZmogusById(id).getVardas());
		System.out.println(zmogusDao.getZmogusById(id).getVardas());
	} else if(event.getSource() == mygtukas4){ 
		model.setRowCount(0);
		java.util.List<Zmogus> users;
			  users = zmogusDao.getAllZmones();
		  
		  Object[] data;
		  int rowNumber = 0;
		  for (Zmogus user : users) {
			  if(!users.isEmpty()) {    // list with results
				  data = new Object[users.size()];
				  data[0] = ++rowNumber;
				  data[1] = user.getId();
				  data[2] = user.getVardas();
				  data[3] = user.getPavarde();
				  
				  model.addRow(data);
			  } else { // empty list
				  model.setRowCount(0);
			  }
		  } 
	}
	}
	
	public MainFrame(String title){
		
		Container vidus = getContentPane();
		setBounds(new Rectangle(200, 0, 300, 400));
		vidus.setLayout(new GridLayout(5, 1, 10, 10));
		vidus.setBackground(Color.lightGray);
		
		JPanel ivadas= new JPanel();
		ivadas.setBackground(Color.lightGray);
		ivadas.setForeground(Color.black);
		
		JPanel klausim6 = new JPanel();
		klausim6.setBorder(new TitledBorder("Id"));
		this.id = new TextField("", 20);
		klausim6.add(id);
		vidus.add(klausim6);
		
		JPanel klausim1 = new JPanel(); 
		klausim1.setBorder(new TitledBorder("Vardas:"));
		this.vardas = new TextField("", 20);
		klausim1.add(vardas);
		vidus.add(klausim1);
		
		JPanel klausim2 = new JPanel();
		klausim2.setBorder(new TitledBorder("Pavardė:"));
		this.pavarde = new TextField("", 20);
		klausim2.add(pavarde);
		vidus.add(klausim2);
		
		JPanel klausim9 = new JPanel();
		klausim9.setBorder(new TitledBorder("Veiksmas:"));
		klausim9.add(mygtukas);
		klausim9.add(mygtukas1);
		klausim9.add(mygtukas2);
		klausim9.add(mygtukas3);
		klausim9.add(mygtukas4);
		vidus.add(klausim9);
		
		//JPanel klausim10 = new JPanel();
        JScrollPane scrollPane = JTable.createScrollPaneForTable(table);
	    scrollPane.setPreferredSize(new Dimension(400, 100));
	    vidus.add(scrollPane);
		
		mygtukas.addActionListener(this);
		mygtukas1.addActionListener(this);
		mygtukas2.addActionListener(this);
		mygtukas3.addActionListener(this);
		mygtukas4.addActionListener(this);
		
	}
}
