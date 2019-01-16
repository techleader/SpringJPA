package onetomanybidirectional;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Transactional
public class Card {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cid", referencedColumnName = "id")
    private Customer customer;

    //@Column(name = "cid")
    //private Long cid;

    protected Card() {}

    @Column(name = "name")
    private String name;

    public Card(String Name) {
        this.name = Name;
    }

    @Override
    public String toString() {
        return "Card :" + name + " customer :" + customer;
    }
}
