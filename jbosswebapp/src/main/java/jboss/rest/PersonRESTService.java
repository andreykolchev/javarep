package jboss.rest;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import jboss.data.PersonRepository;
import jboss.model.Person;

@Path("/persons")
@RequestScoped
public class PersonRESTService {

	@Inject
	private PersonRepository repository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> listAllPersons() {
		return repository.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person lookupPersonById(@PathParam("id") long id) {
		Person person = repository.findById(id);
		if (person == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return person;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createPerson(Person person) {
		try {
			repository.add(person);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Person person) {
		repository.update(person);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") long id) {
		Person person = repository.findById(id);
		if (null != person) {
			repository.update(person);
		}
	}
}