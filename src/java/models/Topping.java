
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
@Table(name = "Toppings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Topping.findAll", query = "SELECT i FROM Topping i")})

public class Topping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "toppingName")
    private String toppingName;
    @Basic(optional = false)
    @Column(name = "sPrice")
    private double sPrice;
    @Basic(optional = false)
    @Column(name = "mPrice")
    private double mPrice;
    @Basic(optional = false)
    @Column(name = "lPrice")
    private double lPrice;
  
    public Topping() {
    }

    public Topping(String toppingName) {
        this.toppingName = toppingName;
    }

    public Topping (String toppingName, double sPrice, double mPrice, double lPrice) {
        this.toppingName = toppingName;
        this.sPrice = sPrice;
        this.mPrice = mPrice;
        this.lPrice = lPrice;

    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public double getsPrice() {
        return sPrice;
    }

    public void setsPrice(double sPrice) {
        this.sPrice = sPrice;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public double getlPrice() {
        return lPrice;
    }

    public void setlPrice(double lPrice) {
        this.lPrice = lPrice;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toppingName != null ? toppingName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Topping)) {
            return false;
        }
        Topping other = (Topping) object;
        if ((this.toppingName == null && other.toppingName != null) || (this.toppingName != null && !this.toppingName.equals(other.toppingName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Topping[ toppingName = " + toppingName + " ]";
    }
    
}
