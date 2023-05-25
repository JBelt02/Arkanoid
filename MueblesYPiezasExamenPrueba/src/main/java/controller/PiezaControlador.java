package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Pieza;


public class PiezaControlador {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MueblesYPiezasExamenPrueba");

	
	/**
	 * 
	 * @param sql
	 * @return
	 */
	public static Pieza findBySQL(String sql) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery(sql, Pieza.class);
		Pieza p = null;
		try {
			p = (Pieza) q.getSingleResult();
		}
		catch(Exception ex) {
			System.out.println("No se ha encontrado Piezas para la sql: " + sql);
		}
		
		em.close();
		return p;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Pieza findFirst () {
		return findBySQL("select * from pieza order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Pieza findLast () {
		return findBySQL("select * from pieza order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Pieza findNext (int idActual) {
		return findBySQL("select * from pieza where id > " + idActual + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Pieza findPrevious (int idActual) {
		return findBySQL("select * from pieza where id < " + idActual + " order by id desc limit 1");
	}

	
	/**
	 * 
	 * @param a
	 */
	public static void eliminar (Pieza a) {
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
	public static void nuevo (Pieza a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

	/**
	 * 
	 * @param a
	 */
	public static void modificar (Pieza a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
	}

	/**
	 * 
	 */
	public static void guardar (Pieza a) {
		if (a.getId() == 0) {
			nuevo(a);
		}
		else {
			modificar(a);
		}
	}
}
