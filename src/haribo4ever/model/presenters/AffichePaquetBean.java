package haribo4ever.model.presenters;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import haribo4ever.model.entities.Paquet;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Named
@ViewScoped // reste la même vue tant qu'il y a des probelems de saisie pour
			// l'utilisateur
@ManagedBean
public class AffichePaquetBean implements Serializable {

	@Getter
	@Setter
	String uuid;

	@Getter
	@Setter
	private Paquet paquet;

}
