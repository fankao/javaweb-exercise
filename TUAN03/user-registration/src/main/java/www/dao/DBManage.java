package www.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class DBManage {
	private static DBManage instance = null;
	private EntityManager em = null;
	public DBManage() {
		em = Persistence.createEntityManagerFactory("user-registration").createEntityManager();
	}
	public synchronized static DBManage getInstance() {
		if(instance == null) {
			instance = new DBManage();
		}
		return instance;
	}
	public EntityManager getEntityManager() {
		return em;
	}

}
