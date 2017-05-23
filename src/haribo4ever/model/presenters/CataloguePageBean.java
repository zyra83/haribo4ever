package haribo4ever.model.presenters;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.spi.CDI;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import haribo4ever.model.dao.DaoPaquetJPA;
import haribo4ever.model.entities.GenreBonbon;
import haribo4ever.model.entities.Paquet;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Named
@ViewScoped // reste la même vue tant qu'il y a des probelems de saisie pour
			// l'utilisateur
@ManagedBean
public class CataloguePageBean implements Serializable {
	@Getter
	@Setter
	private String text;
	 
	@Getter
	@Setter
	LocalDate dateNow;
	
	@PostConstruct
	public void initialize(){
		dateNow = LocalDate.now();
	}
	
	@Inject
	private DaoPaquetJPA daoPaquet;

	@Inject
	@Getter // pour y acceder depuis la page web
	private Paquet nouveauPaquet;

	public void ajouterPaquet() {
		daoPaquet.create(nouveauPaquet);
		// grace à CDI remet un paquet neuf 
		nouveauPaquet = CDI.current().select(Paquet.class).get();
		// TODO envoyer un message de succes JSF
	}

	public List<Paquet> listerPaquets() {
		return daoPaquet.readAll();
	}
	
	public GenreBonbon[] getGenresBonbon(){
		return GenreBonbon.values();
	}
	
	public void suppression(Paquet p){
		daoPaquet.delete(p);
		// TODO envoyer un message de succes JSF
	}
	
	

}
