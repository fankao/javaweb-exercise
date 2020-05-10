package www.bt07.test;

import www.bt07.dao.StudentDAO;
import www.bt07.dao.StudentDAOImpl;

public class Testing {

	public static void main(String[] args) {
		StudentDAO studentDAO = new StudentDAOImpl();
//		Student st1 = new Student("Chien",true, "Binh Phuoc", "0852369741");
//		Student st2 = new Student("Khang", true, "Long An", "085693214");
//		Student st3 = new Student("Thu Hong",false,"TPHCM","07412563258");
//		
//		studentDAO.save(st1);
//		studentDAO.save(st2);
//		studentDAO.save(st3);

		System.out.println(studentDAO.findAll());
	}

}
