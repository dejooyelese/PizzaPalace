
package database;

import models.Pizza;
import models.Order;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PizzaDB {
    
    public Pizza getPizza(int pizzaNumber){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Pizza pizza = em.find(Pizza.class, pizzaNumber);
            return pizza;
        } finally {
            em.close();
        }
    }
    
    public int insert(Pizza pizza) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            Order owner = pizza.getOwner();
            owner.getPizzaList().add(pizza);
            
            trans.begin();
            em.persist(pizza);
            em.merge(owner);
            trans.commit();
            
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(PizzaDB.class.getName()).log(Level.SEVERE, "Cannot insert " + pizza.toString(), ex);

        } finally {
            em.close();
        }
        return 0;
    }

    public int delete(Pizza pizza){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            Order owner = pizza.getOwner();
            owner.getPizzaList().remove(pizza);
            
            trans.begin();
            em.merge(owner);
            em.remove(em.merge(pizza));
            trans.commit();
            return 1;
        } catch (Exception ex) {
            trans.rollback();
            Logger.getLogger(PizzaDB.class.getName()).log(Level.SEVERE, "Cannot delete " + pizza.toString(), ex);
        } finally {
            em.close();
        }
        return 0;
    }

    public List<Pizza> getAllForOrder(String orderNumber) throws PizzaPalaceDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Pizza> pizzas = em.createNamedQuery("Pizza.findAllByOwner", Pizza.class).setParameter("orderNumber", orderNumber).getResultList();
            return pizzas;                
        } finally {
            em.close();
        }
    }
    
    public List<Pizza> getAll() throws PizzaPalaceDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            List<Pizza> pizzas = em.createNamedQuery("Pizza.findAll", Pizza.class).getResultList();
            return pizzas;                
        } finally {
            em.close();
        }
    }
    
    public int update(Pizza pizza) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(pizza);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
        return 1;
    }
}