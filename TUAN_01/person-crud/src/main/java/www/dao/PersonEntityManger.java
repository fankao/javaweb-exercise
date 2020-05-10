package www.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PersonEntityManger {
	public static PersonEntityManger instance = null;
	private EntityManager em;

	public PersonEntityManger() {
		em = Persistence.createEntityManagerFactory("person-crud-ogm").createEntityManager();
	}

	public synchronized static PersonEntityManger getInstance() {
		if (instance == null) {
			instance = new PersonEntityManger();
		}
		return instance;
	}

	public EntityManager getEntityManager() {
		return em;
	}
}
