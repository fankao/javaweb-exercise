package www.bt07.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class StudentEntityManager {
	public static StudentEntityManager instance = null;
	private EntityManager em;

	public StudentEntityManager() {
		em = Persistence.createEntityManagerFactory("student-management-crud").createEntityManager();
	}

	public synchronized static StudentEntityManager getInstance() {
		if (instance == null) {
			instance = new StudentEntityManager();
		}
		return instance;
	}

	public EntityManager getEnityManager() {
		return em;
	}
}
