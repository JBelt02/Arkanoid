package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Mueble;



public class MuebleControlador {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MueblesYPiezasExamenPrueba");

	/**
	 * 
	 * @return
	 */
	public static List<Mueble> findAll() {	
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM mueble", Mueble.class);
		List<Mueble> l = (List<Mueble>) q.getResultList();
		
		em.close();
		return l;
	}
	
	/**
	 * 
	 * @param sql
	 * @return
	 */
	public static Mueble findBySQL(String sql) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery(sql, Mueble.class);
		Mueble p = null;
		try {
			p = (Mueble) q.getSingleResult();
		}
		catch(Exception ex) {
			System.out.println("No se ha encontrado Mueble para la sql: " + sql);
		}
		
		em.close();
		return p;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Mueble findFirst () {
		return findBySQL("select * from mueble order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Mueble findLast () {
		return findBySQL("select * from mueble order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Mueble findNext (int idActual) {
		return findBySQL("select * from mueble where id > " + idActual + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Mueble findPrevious (int idActual) {
		return findBySQL("select * from mueble where id < " + idActual + " order by id desc limit 1");
	}

	
	/**
	 * 
	 * @param a
	 */
	public static void eliminar (Mueble a) {
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
	public static void nuevo (Mueble a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

	/**
	 * 
	 * @param a
	 */
	public static void modificar (Mueble a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
	}

	/**
	 * 
	 */
	public static void guardar (Mueble a) {
		if (a.getId() == 0) {
			nuevo(a);
		}
		else {
			modificar(a);
		}
	}
}
