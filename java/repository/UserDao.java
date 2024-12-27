package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.User;
import hibernatecfg.HibernateUtil;


public class UserDao {
	
	//Save User Details
	public void saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the user object
			session.save(user);
			// commit transaction
//			transaction.commit();
			if (transaction != null && transaction.isActive()) {
	            transaction.commit();
	        }

		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	public boolean userValidate(String name, String password) {
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			user = (User) session.createQuery("FROM User a WHERE a.name = :name").setParameter("name", name)
					.uniqueResult();
			if (user != null && user.getPassword().equals(password)) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;

	}

//	public boolean userValidate(String email, String password) {
//	    Transaction transaction = null;
//	    User user = null;
//	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//	        // Start a transaction
//	        transaction = session.beginTransaction();
//
//	        // Query to fetch user by email (using TypedQuery for type safety)
//	        user = (User) session.createQuery("FROM User u WHERE u.email = :email")
//	                             .setParameter("email", email)
//	                             .uniqueResult(); // Fetching the single result
//
//	        // Check if user exists and password matches
//	        if (user != null && user.getPassword().equals(password)) {
//	            // Commit the transaction (though, it's already done as the session is closed at the end)
//	            transaction.commit();
//	            return true;
//	        }
//
//	    } catch (Exception e) {
//	        if (transaction != null) {
//	            transaction.rollback();
//	        }
//	        e.printStackTrace();
//	    }
//	    return false;
//	}

	

	//Update User Details
	 
	public void updateUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the user object
			session.update(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	//Delete User Details
	public void deleteUser(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			User user = session.get(User.class, id);
			if (user != null) {
				session.delete(user);
				System.out.println("user is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	//Display  Specific User Details
	public User getUser(int id) {

		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = session.get(User.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}
	
	//Display  ALL User Details
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {

		Transaction transaction = null;
		List<User> listOfUser = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			listOfUser = session.createQuery("from User").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfUser;
	}
}
