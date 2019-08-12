/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import models.Order;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Pizza;

public class OrderDB {
    
    public int insertOrder(Order order) throws PizzaPalaceDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        trans.begin();
        try {
            em.persist(order);
            trans.commit();
        } catch (Exception e) {
             Logger.getLogger(OrderDB.class.getName()).log(Level.SEVERE, "Cannot insert " + order.toString(), e);
                trans.rollback();
        } finally {
            em.close();
        }
        return 0;
    }
    
    
    
    public int update(Order order) throws PizzaPalaceDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(order);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
        return 1;
    }
    
    public List<Order> getAll() throws PizzaPalaceDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Order> orders = em.createNamedQuery("Order.findAll", Order.class).getResultList();
            return orders;                
        } finally {
            em.close();
        }
    }
    
    public Order getOrder(Integer orderNumber) throws PizzaPalaceDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
                Order order = em.find(Order.class, orderNumber);
                return order;
        } finally {
                em.close();
        }
    }
    
    public int deletePizza(Pizza pizza) throws PizzaPalaceDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(pizza));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
        return 1;
    }
    
    public int delete(Order order) throws PizzaPalaceDBException {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(order));
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