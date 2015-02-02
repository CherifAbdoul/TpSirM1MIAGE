package fr.istic.tpjpa.jpa;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.istic.tpjpa.domain.ElectronicDevice;
import fr.istic.tpjpa.domain.Heater;
import fr.istic.tpjpa.domain.Home;
import fr.istic.tpjpa.domain.Person;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		
		
	
		
		
	      try
	      {
	        System.out.println( "Ajout des champ dans la base en cours..." );
	        
	        test.createHomes();
	        
	    	
	     
	        
	        
	        
	        tx.commit();
	        test.listHome();
	        System.out.println( "Transactions validées");
	      }
	      catch ( Exception e )
	      {
	        System.out.println( "Erreur :" + e.getMessage() );
	        tx.rollback();
	        System.out.println( "Transaction annulée");
	      }
	      
	      finally
	      {
	    
	        manager.close();
	        factory.close();
	      }



		System.out.println(".. done");
	}
	
	private void createHomes(){
	//	this.createDevice();
		int numOfHome = manager.createQuery("SELECT h FROM Home h", Home.class).getResultList().size();
		if(numOfHome == 0){
			
			
			
			
			//create entity of Device
			//Electronic Device
			for(int i=0; i<10; i++){
				ElectronicDevice electro = new ElectronicDevice();
				electro.setNomDevice("electro"+i);
				electro.setConsoMoyen(20+i);
				manager.persist(electro);
			}
			
			for(int i=0; i<10; i++){
				Heater heater = new Heater();
				heater.setNomDevice("heater"+i);
				heater.setConsoMoyen(20+i);
				manager.persist(heater);
			}
			
			
//			ElectronicDevice electro1 = new ElectronicDevice();
//				electro1.setNomDevice("electro1");
//				electro1.setConsoMoyen(20);
//			   
//			ElectronicDevice electro2 = new ElectronicDevice();
//				electro2.setNomDevice("electro2");
//				electro2.setConsoMoyen(19.5);
//			ElectronicDevice electro3 = new ElectronicDevice();
//				electro3.setNomDevice("electro3");
//				electro3.setConsoMoyen(18);
//				
//			//Heater
//			Heater heater1 = new Heater();
//				heater1.setNomDevice("heater1");
//				heater1.setConsoMoyen(15);
//			Heater heater2 = new Heater();
//				heater2.setNomDevice("heater2");
//				heater2.setConsoMoyen(19.80);
//			Heater heater3 = new Heater();
//				heater3.setNomDevice("heater3");
//				heater3.setConsoMoyen(16.7);
//				
//				  // electro1.setHomeDevice(new Home());
//		        //Persistence of Devices
//		        manager.persist(electro1);
//		        manager.persist(electro2);
//		        manager.persist(electro3);
//		        manager.persist(heater1);
//		        manager.persist(heater2);
//		        manager.persist(heater3);
//			
//			
			
			
			Calendar c = Calendar.getInstance();		
			for(int i=0; i<10; i++){
				Person person = new Person("Dupont"+i, "Jean"+i, "mail@test.com"+i, "Homme", c, "Profil"+i);
				manager.persist(person);
			}
			for(int i=0; i<10; i++){
				Person person = new Person("Durant"+i, "Jeanne"+i, "mailskjd@test.com"+i, "Femme", c, "Profil2"+i);
				manager.persist(person);
			}
			
			
			
			
			//create entity of PERSON
			Person person1 = new Person("Dupont1", "Jean1", "mail@test.com1", "Homme", c, "Profil1");
			Person person2 = new Person("Dupont2", "Jean2", "mail@test.com2", "Homme", c, "Profil2");
			Person person3 = new Person("Dupont3", "Jean3", "mail@test.com3", "Homme", c, "Profil3");
			Person person4 = new Person("Dupont4", "Jean4", "mail@test.com4", "Homme", c, "Profil4");
			Person person5 = new Person("Dupont5", "Jean5", "mail@test.com5", "Homme", c, "Profil5");
			Person person6 = new Person("Dupont6", "Jean6", "mail@test.com6", "Homme", c, "Profil6");
			Person person7 = new Person("Dupont", "Simone", "mailSimone@test.com", "Femme", c, "YATA");
			
			//Persistence of PERSON
	        manager.persist(person1);
	        manager.persist(person2);
	        manager.persist(person3);
	        manager.persist(person4);
	        manager.persist(person5);
	        manager.persist(person6);
	        manager.persist(person7);
			
	        
	    	//create entity of HOME
			
			Home home1 = new Home("21 av Prof Charles Foulon", "123.12.12.34", 20.23 ,3, person1);
			Home home2 = new Home("29 av Prof Charles Foulon", "123.12.12.35", 25.5, 5, person2 );
			Home home23 = new Home("65 rennes Charles Foulon", "123.122.12.35", 25.5, 5, person2 );
			Home home3 = new Home("30 av Prof Charles Foulon", "123.12.12.36", 19, 2, person3 );
			Home home22 = new Home("29 av Prof Charles Foulon", "123.12.12.35", 25.5, 5, person2 );
			Home home72 = new Home("29 av Prof Charles Foulon", "123.12.12.35", 25.5, 5, person7 );
			Home home4 = new Home("223 av Prof Charles Foulon", "123.12.12.30", 21, 3, person4 );
			Home home5 = new Home("291 av Prof Charles Foulon", "123.12.12.39", 30.5, 7, person5 );
			Home home6 = new Home("209 av Prof Charles Foulon", "123.12.12.38", 32.5, 9, person7 );
			Home home7 = new Home("212 av Prof Charles Foulon", "123.12.12.98", 9.5, 1, person6 );
			
			
			
	        //Persistence of HOME
	        manager.persist(home1);
	        manager.persist(home2);
	        manager.persist(home3);
	        manager.persist(home4);
	        manager.persist(home5);
	        manager.persist(home6);
	        manager.persist(home7);
	        manager.persist(home22);
	        manager.persist(home23);
	        manager.persist(home72);
			
		}
	}
	
	public void createDevice(){
		//create entity of Device
				//Electronic Device
				ElectronicDevice electro1 = new ElectronicDevice();
					electro1.setNomDevice("electro1");
					electro1.setConsoMoyen(20);
				   
				ElectronicDevice electro2 = new ElectronicDevice();
					electro2.setNomDevice("electro2");
					electro2.setConsoMoyen(19.5);
				ElectronicDevice electro3 = new ElectronicDevice();
					electro3.setNomDevice("electro3");
					electro3.setConsoMoyen(18);
					
				//Heater
				Heater heater1 = new Heater();
					heater1.setNomDevice("heater1");
					heater1.setConsoMoyen(15);
				Heater heater2 = new Heater();
					heater2.setNomDevice("heater2");
					heater2.setConsoMoyen(19.80);
				Heater heater3 = new Heater();
					heater3.setNomDevice("heater3");
					heater3.setConsoMoyen(16.7);
					
					  // electro1.setHomeDevice(new Home());
			        //Persistence of Devices
			        manager.persist(electro1);
			        manager.persist(electro2);
			        manager.persist(electro3);
			        manager.persist(heater1);
			        manager.persist(heater2);
			        manager.persist(heater3);
				
	}
	
	private void listHome(){
		List<Home> resultList = manager.createQuery("SELECT h FROM Home h" , Home.class).getResultList();
		System.out.println("nomber of Home : "+resultList.size());
		for(Home next : resultList){
			System.out.println("next home : "+ next.getAdresse());
		}
		
	}

}
