package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Distribuidor;
import model.Tipomueble;


public class TipomuebleControlador {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MueblesYPiezasExamenPrueba");
	
	/**
	 * 
	 * @param sql
	 * @return
	 */
	public static Tipomueble findBySQL(String sql) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery(sql, Tipomueble.class);
		Tipomueble p = null;
		try {
			p = (Tipomueble) q.getSingleResult();
		}
		catch(Exception ex) {
			System.out.println("No se ha encontrado Tipomueble para la sql: " + sql);
		}
		
		em.close();
		return p;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Tipomueble findFirst () {
		return findBySQL("select * from tipomueble order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Tipomueble findLast () {
		return findBySQL("select * from tipomueble order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Tipomueble findNext (int idActual) {
		return findBySQL("select * from tipomueble where id > " + idActual + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Tipomueble findPrevious (int idActual) {
		return findBySQL("select * from tipomueble where id < " + idActual + " order by id desc limit 1");
	}

	
	/**
	 * 
	 * @param a
	 */
	public static void eliminar (Tipomueble a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		a = em.merge(a);	
		em.remove(a);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param a
	 */
	public static void nuevo (Tipomueble a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

	/**
	 * 
	 * @param a
	 */
	public static void modificar (Tipomueble a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
	}

	/**
	 * 
	 */
	public static void guardar (Tipomueble a) {
		if (a.getId() == 0) {
			nuevo(a);
		}
		else {
			modificar(a);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static List<Tipomueble> findAll() {	
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM tipomueble", Tipomueble.class);
		List<Tipomueble> l = (List<Tipomueble>) q.getResultList();
		
		em.close();
		return l;
	}

}
