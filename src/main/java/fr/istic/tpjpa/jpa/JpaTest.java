package fr.istic.tpjpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

		// TODO create entity
		Person person = new Person();
		
	      try
	      {
	        System.out.println( "Ajout d'une personne dans la base en cours..." );
	        manager.persist(person);
	        tx.commit();
	        System.out.println( "Transaction validée");
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
