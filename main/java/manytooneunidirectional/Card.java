package manytooneunidirectional;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Transactional
public class Card {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cid", insertable = false, updatable = false)
    private Customer customer;

    protected Card() {}

    @Column(name = "name")
    private String name;

    public Card(String Name) {
        this.name = Name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Card :" +  id + " name : " + name + " cid :" + customer.getId();
    }
}
