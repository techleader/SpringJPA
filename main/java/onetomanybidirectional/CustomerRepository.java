package onetomanybidirectional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    @Query(value = "SELECT distinct c FROM Customer c LEFT JOIN FETCH c.cards where c.lastName=:lastName")
  //  @Query(value = "SELECT distinct c FROM Customer c where c.lastName=:lastName")
    List<Customer> findByLastNameWithCards(String lastName);


/*    @Query("SELECT p FROM Person p JOIN FETCH p.roles WHERE p.id = (:id)")
    public Person findByIdAndFetchRolesEagerly(@Param("id") Long id);*/
}
