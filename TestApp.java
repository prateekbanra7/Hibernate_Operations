package in.abc.main;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.abc.Model.Employee;

public class TestApp {

	public static void main(String[] args) {

		// Step 1. Creating a configuration object
		Configuration cfg = new Configuration();

		// Step 2. configure hibernate.cfg.xml file to Configuration object
		cfg.configure();

		// Step 3. Create SessionFactory Object
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		// Step 4. Get the Session Object from SessionFactory
		Session session = sessionFactory.openSession();

		// Step 5. Begin the Transaction within a session
		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmpId(10);
		employee.setEmpName("sachin");
		employee.setEmpSal(6453.7);

		// Step 6. Perform operations
		Serializable object = session.save(employee);
		System.out.println(object);

		// Step 7. Performing Transaction operations
		transaction.commit();

		// Step 8. Close the session
		session.close();

	}

}
