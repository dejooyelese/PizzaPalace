/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Pizzas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p")
    , @NamedQuery(name = "Pizza.findByOrderNumber", query = "SELECT p FROM Pizza p WHERE p.orderNumber = :orderNumber")})

public class Pizza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pizzaNumber")
    private Integer pizzaNumber;
    @Basic(optional = false)
    @Column(name = "orderNumber")
    private Integer orderNumber;
    @Basic(optional = false)
    @Column(name = "pizzaSize")
    private String pizzaSize;
    @Basic(optional = false)
    @Column(name = "bPrice")
    private double bPrice;
    
    @JoinColumn(name = "Owner", referencedColumnName = "orderNumber")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Order owner;

    public Pizza() {
    }

    public Pizza(Integer pizzaNumber) {
        this.pizzaNumber = pizzaNumber;
    }

    public Pizza (Integer pizzaNumber, String pizzaSize, double bPrice, Integer orderNumber) {
        this.pizzaNumber = pizzaNumber;
        this.pizzaSize = pizzaSize;
        if (this.pizzaSize.equals("Large")){
            this.bPrice = 16;
        }
        if (this.pizzaSize.equals("Medium")){
            this.bPrice = 14;
        }
        if (this.pizzaSize.equals("Small")){
            this.bPrice = 12;
        }
        this.orderNumber = orderNumber;
    }

    public Integer getPizzaNumber() {
        return pizzaNumber;
    }

    public void setPizzaNumber(Integer pizzaNumber) {
        this.pizzaNumber = pizzaNumber;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public double getbPrice() {
        return bPrice;
    }

    public void setBPrice(double bPrice) {
        this.bPrice = bPrice;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public Order getOwner() {
        return owner;
    }

    public void setOwner(Order owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pizzaNumber != null ? pizzaNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pizza)) {
            return false;
        }
        Pizza other = (Pizza) object;
        if ((this.pizzaNumber == null && other.pizzaNumber != null) || (this.pizzaNumber != null && !this.pizzaNumber.equals(other.pizzaNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Pizza[ pizzaNumber = " + pizzaNumber  + " ]";
    }
    
}
