/**
 * 
 */
package meta.codeanywhere.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Biao Zhang
 * @version 0.1 10/03/2006
 * This util is used to initialize the Hibernate session and make it thread safe
 */
public class HIbernateSessionUtil {
	public static final SessionFactory sessionFactory;

	public static final Configuration config;

	static {
		config = new Configuration().configure();
		sessionFactory = config.buildSessionFactory();
	}

	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	public static Session currentSession() {
		Session s = (Session) session.get();

		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;

	}

	public static void closeSession() {
		Session s = (Session) session.get();
		if (s != null)
			s.close();
		session.set(null);
	}

	public static void onDestruction() {
		sessionFactory.close();
	}
}
