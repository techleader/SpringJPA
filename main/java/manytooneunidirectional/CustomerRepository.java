package manytooneunidirectional;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    @Query(value = "SELECT c FROM Customer c LEFT JOIN FETCH c.cards where c.lastName=:lastName")
    List<Customer> findByLastNameWithCards(String lastName);

/*    @Query("SELECT p FROM Person p JOIN FETCH p.roles WHERE p.id = (:id)")
    public Person findByIdAndFetchRolesEagerly(@Param("id") Long id);*/
}
