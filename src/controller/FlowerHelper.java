package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Flower;


public class FlowerHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PartnerProjectWeek6");
	
	public void insertFlower(Flower f) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Flower>showAllFlowers(){
		EntityManager em = emfactory.createEntityManager();
		List<Flower> allFlowers = em.createQuery("SELECT i FROM Flower i").getResultList();
		return allFlowers;
	}

	public void deleteFlower(Flower toDelete) {
		// TODO Auto-generated method stub
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Flower> typedQuery = em.createQuery(
				"select f from Flower f where f.flowerName = :selectedFlowerName and f.colors = :selectedColors",
				Flower.class);
		
		typedQuery.setParameter("selectedFlowerName", toDelete.getFlowerName());
		typedQuery.setParameter("selectedColors", toDelete.getColors());
		typedQuery.setMaxResults(1);
		
		Flower result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public Flower searchForFlowerById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Flower found = em.find(Flower.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateFlower(Flower toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Flower> searchForFlowerByName(String flowerName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Flower> typedQuery = em.createQuery("select f from Flower f where f.flowerName = :selectedFlowerName", Flower.class);
		typedQuery.setParameter("selectedFlowerName", flowerName);

		List<Flower> foundFlowers = typedQuery.getResultList();
		em.close();
		return foundFlowers;
	}
	
	public List<Flower> searchForFlowerByColor(String flowerColor) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Flower> typedQuery = em.createQuery("select f from Flower f where f.colors = :selectedColors", Flower.class);
		typedQuery.setParameter("selectedColors", flowerColor);

		List<Flower> foundFlowers = typedQuery.getResultList();
		em.close();
		return foundFlowers;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
