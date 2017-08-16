package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



/*import org.hibernate.Session;   // naudojamos tik tiesiogiai per main klase jungiantis prie duomenų bazės
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;*/

import dataBase.*;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
			JFrame frame=new MainFrame("Hello");
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(500, 500);
			}
		});   // taip
		
		
		
/*		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Zmogus zmogus1 = new Zmogus(5, "Jons", "Kapitons");
        session.persist(zmogus1);
        t.commit();
        session.close();
        System.out.println("Data inserted successfully"); */
		
		//ZmogusDao zmogusDao = new ZmogusDao();
		//Zmogus kazys = new Zmogus(5, "Kazys", "Kaziukas");
		
		//zmogusDao.addZmogus(kazys);
        //zmogusDao.updateZmogus(kazys);
        //zmogusDao.deleteZmogus(5);
		//System.out.println(zmogusDao.getZmogusById(2).getPavarde());
		
		// int i = 0;
/*	     for (Zmogus zmogus : zmogusDao.getAllZmones()) {
	    	 System.out.println(++i + " " + zmogus.getVardas());
	     	} */
/*	     for (Zmogus zmogus : zmogusDao.getZmogusByVardas("Petras")) {
	            System.out.println(++i + " " + zmogus.getPavarde());
	     	} */
		
		//System.out.println("Data inserted successfully");
		  

	}

}
