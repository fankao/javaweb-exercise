package www.test;

import www.dao.PersonDAO;
import www.dao.PersonDAOImpl;

public class Testing {
	public static void main(String[] args) {
		PersonDAO personDAO = new PersonDAOImpl();
		/*
		 * Person p1 = new Person("John", "America"); Person p2 = new Person("Kazuki",
		 * "Japan"); Person p3 = new Person("Chien", "Vietnam"); Person p4 = new
		 * Person("Emanuen", "Franch");
		 * 
		 * 
		 * 
		 * personDAO.save(p1); personDAO.save(p2); personDAO.save(p3);
		 * personDAO.save(p4);
		 */
		
		//findAll
		System.out.println(personDAO.findAll());

		/*//Edit person
		 * Person personEdit = personDAO.findById(new
		 * ObjectId("5eb604d144e7743ba8b13bb4")); System.out.println(personEdit);
		 * 
		 * personEdit.setName("Minh Chien");
		 * System.out.println(personDAO.save(personEdit));
		 */
		
	

	}
}
