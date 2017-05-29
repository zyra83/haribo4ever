package haribo4ever.model.presenters;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import haribo4ever.model.entities.Paquet;
import lombok.Getter;
import lombok.Setter;
import net.entetrs.commons.jsf.JsfUtils;

@SuppressWarnings("serial")
@Named
@ViewScoped // reste la même vue tant qu'il y a des probelems de saisie pour l'utilisateur
public class AffichePaquetFlashScopePageBean implements Serializable {

	@Getter
	@Setter
	private Paquet paquet;
	
	@PostConstruct
	public void init(){
		paquet = (Paquet) JsfUtils.getFromFlashScope(ListerPaquetsFlashScopePageBean.FLASH_PARAM_PAQUET);
	}

}
