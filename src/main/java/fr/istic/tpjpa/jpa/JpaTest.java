package fr.istic.tpjpa.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

		Calendar c = Calendar.getInstance();
		//create entity of PERSON
		Person person1 = new Person("Dupont1", "Jean1", "mail@test.com1", "Homme", c, "Profil1");
		Person person2 = new Person("Dupont2", "Jean2", "mail@test.com2", "Homme", c, "Profil2");
		Person person3 = new Person("Dupont3", "Jean3", "mail@test.com3", "Homme", c, "Profil3");
		Person person4 = new Person("Dupont4", "Jean4", "mail@test.com4", "Homme", c, "Profil4");
		Person person5 = new Person("Dupont5", "Jean5", "mail@test.com5", "Homme", c, "Profil5");
		Person person6 = new Person("Dupont6", "Jean6", "mail@test.com6", "Homme", c, "Profil6");
		Person person7 = new Person("Dupont", "Simone", "mailSimone@test.com", "Femme", c, "YATA");
		
		//create entity of HOME
		
		Home home1 = new Home("21 av Prof Charles Foulon", "123.12.12.34", 20.23 );
		Home home2 = new Home("29 av Prof Charles Foulon", "123.12.12.35", 25.5 );
		
	      try
	      {
	        System.out.println( "Ajout des champ dans la base en cours..." );
	        
	        //Persistence of PERSON
	        manager.persist(person1);
	        manager.persist(person2);
	        manager.persist(person3);
	        manager.persist(person4);
	        manager.persist(person5);
	        manager.persist(person6);
	        manager.persist(person7);
	        
	        
	        //Persistence of HOME
	        manager.persist(home1);
	        manager.persist(home2);
	        
	        
	        
	        tx.commit();
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

}
