package jboss.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.util.List;

import jboss.model.Person;

@ApplicationScoped
public class PersonRepository {

    @Inject
    private EntityManager entityManager;

    /*list all persons method*/
    public List<Person> findAll() {
    	@SuppressWarnings("unchecked")
		final List<Person> results = entityManager.createQuery("select p from Person p order by p.name").getResultList();
    	return results;
    }
    
    /*find by ID method*/
    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    /*add new Person method*/
    public void add(Person person) throws Exception {
    	entityManager.persist(person);
    }
    
    /*update Person method*/   
    public Person update (Person person) {
        return entityManager.merge(person);
    }
        
    /*delete Person by id method*/   
    public void delete (Long id) {
    	Person person = findById(id);
		if (person!=null) {
			entityManager.remove(person);
		}
    }
    
    
}
