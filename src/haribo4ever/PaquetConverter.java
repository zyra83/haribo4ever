package haribo4ever;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import haribo4ever.model.dao.DaoPaquetJPA;
import haribo4ever.model.entities.Paquet;

@Named // equivalent du ManagedBean JEE6
@ApplicationScoped
public class PaquetConverter implements Converter {

	@Inject
	private DaoPaquetJPA dao;

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		return dao.read(value);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Paquet) arg2).getId();
		} else {
			return null;
		}
	}

}
