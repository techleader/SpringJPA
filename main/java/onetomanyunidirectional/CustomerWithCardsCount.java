// tag::sample[]
package onetomanyunidirectional;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Set;

@Entity
@Transactional
public class CustomerWithCardsCount {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    private long noOfcards;

    protected CustomerWithCardsCount() {}

    public CustomerWithCardsCount(String firstName, String lastName, long noOfcards) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.noOfcards = noOfcards;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

// end::sample[]

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}


    public long getNoOfcards() {
        return noOfcards;
    }

    public void setNoOfcards(long noOfcards) {
        this.noOfcards = noOfcards;
    }
}

