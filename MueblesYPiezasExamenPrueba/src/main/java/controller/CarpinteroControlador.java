package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Carpintero;
import model.Tipomueble;



public class CarpinteroControlador {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MueblesYPiezasExamenPrueba");
	
	/**
	 * 
	 * @param sql
	 * @return
	 */
	public static Carpintero findBySQL(String sql) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery(sql, Carpintero.class);
		Carpintero p = null;
		try {
			p = (Carpintero) q.getSingleResult();
		}
		catch(Exception ex) {
			System.out.println("No se ha encontrado Carpintero para la sql: " + sql);
		}
		
		em.close();
		return p;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Carpintero findFirst () {
		return findBySQL("select * from carpintero order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Carpintero findLast () {
		return findBySQL("select * from carpintero order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Carpintero findNext (int idActual) {
		return findBySQL("select * from carpintero where id > " + idActual + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Carpintero findPrevious (int idActual) {
		return findBySQL("select * from carpintero where id < " + idActual + " order by id desc limit 1");
	}

	
	/**
	 * 
	 * @param a
	 */
	public static void eliminar (Carpintero a) {
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
	public static void nuevo (Carpintero a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

	/**
	 * 
	 * @param a
	 */
	public static void modificar (Carpintero a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
	}

	/**
	 * 
	 */
	public static void guardar (Carpintero a) {
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
	public static List<Carpintero> findAll() {	
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM carpintero", Carpintero.class);
		List<Carpintero> l = (List<Carpintero>) q.getResultList();
		
		em.close();
		return l;
	}
	
}
