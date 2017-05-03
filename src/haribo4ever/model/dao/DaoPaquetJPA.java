package haribo4ever.model.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import haribo4ever.model.entities.Paquet;
import net.entetrs.commons.jpa.AbstractDaoEntrepriseEdition;

@Stateless
@LocalBean
public class DaoPaquetJPA extends AbstractDaoEntrepriseEdition<Paquet> {
	@PersistenceContext
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
