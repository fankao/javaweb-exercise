package www.bt.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MovieEntityManager {
	public static MovieEntityManager instance = null;
	private EntityManager em;
	
	public MovieEntityManager() {
		em  = Persistence.createEntityManagerFactory("movies-crud").createEntityManager();
	}
	
	public synchronized static MovieEntityManager getInstance() {
		if(instance == null) {
			instance = new MovieEntityManager();
		}
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return em;
	}

}
