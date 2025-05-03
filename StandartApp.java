package in.abc.main;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.abc.Model.Employee;

public class StandartApp {

	public static void main(String[] args) {

		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		Integer idValue = null;
		boolean flag = false;

		cfg = new Configuration();
		cfg.configure();
		System.out.println(cfg.getProperties());

		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();

		Employee employee = new Employee();
		employee.setEmpId(10);
		employee.setEmpName("sachin");
		employee.setEmpSal(6453.7);

		try {
			transaction = session.beginTransaction();// connection.setAutoCommit(fasle)
			idValue = (Integer) session.save(employee);
			System.out.println("Generated idValue is :: " + idValue);
			flag = true;
			System.out.println(" id Value is :: " + employee.getEmpId());
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (flag == true) {
				transaction.commit();// con.commit()
			} else {
				transaction.rollback();// con.rollback()
			}
			session.close();
			sessionFactory.close();
		}

	}

}
