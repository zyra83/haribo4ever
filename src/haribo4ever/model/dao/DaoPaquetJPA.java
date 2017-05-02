package haribo4ever.model.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import haribo4ever.model.entities.Paquet;

@Stateless
@LocalBean
public class DaoPaquetJPA {
	@PersistenceContext
	private EntityManager em;

	public void create(Paquet k) {
		em.persist(k);
	}

	public void delete(String id) {
		Paquet ref = em.getReference(Paquet.class, id);
		em.remove(ref);
	}

	public void update(Paquet p) {
		em.merge(p);
	}

	public List<Paquet> readAll() {
		TypedQuery<Paquet> m = em.createNamedQuery("READ_ALL_PAQUETS", Paquet.class);
		return m.getResultList();
	}

}
