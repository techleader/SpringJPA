package onetomanyunidirectional;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Transactional
public class Card {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   // @JoinColumn(name = "cid", referencedColumnName = "id", insertable = false, updatable = false)
    @Column(name = "cid")
    private Long cid;

    protected Card() {}

    @Column(name = "name")
    private String name;

    public Card(String Name) {
        this.name = Name;
    }

    @Override
    public String toString() {
        return "Card :" + name + " cid :" + cid;
    }
}
