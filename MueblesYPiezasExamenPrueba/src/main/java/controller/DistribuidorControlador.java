package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Distribuidor;
import model.Mueble;



public class DistribuidorControlador {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MueblesYPiezasExamenPrueba");
	
	/**
	 * 
	 * @param sql
	 * @return
	 */
	public static Distribuidor findBySQL(String sql) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery(sql, Distribuidor.class);
		Distribuidor p = null;
		try {
			p = (Distribuidor) q.getSingleResult();
		}
		catch(Exception ex) {
			System.out.println("No se ha encontrado Distribuidor para la sql: " + sql);
		}
		
		em.close();
		return p;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Distribuidor findFirst () {
		return findBySQL("select * from distribuidor order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Distribuidor findLast () {
		return findBySQL("select * from distribuidor order by id desc limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Distribuidor findNext (int idActual) {
		return findBySQL("select * from distribuidor where id > " + idActual + " order by id limit 1");
	}

	/**
	 * 
	 * @return
	 */
	public static Distribuidor findPrevious (int idActual) {
		return findBySQL("select * from distribuidor where id < " + idActual + " order by id desc limit 1");
	}

	
	/**
	 * 
	 * @param a
	 */
	public static void eliminar (Distribuidor a) {
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
	public static void nuevo (Distribuidor a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

	/**
	 * 
	 * @param a
	 */
	public static void modificar (Distribuidor a) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
	}

	/**
	 * 
	 */
	public static void guardar (Distribuidor a) {
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
	public static List<Distribuidor> findAll() {	
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM distribuidor", Distribuidor.class);
		List<Distribuidor> l = (List<Distribuidor>) q.getResultList();
		
		em.close();
		return l;
	}
	
}
