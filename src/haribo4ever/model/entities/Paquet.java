package haribo4ever.model.entities;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import net.entetrs.commons.uuid.GeneratedUUID;
import net.entetrs.commons.uuid.UUIDRepresentation;

@SuppressWarnings("serial")
@Dependent
@Entity
@Table(name = "PAQUET")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NamedQuery(name = "READ_ALL_PAQUETS", query = "SELECT p FROM Paquet p ORDER BY p.nom")
public class Paquet implements Serializable {

	@Id
	@Inject
	@GeneratedUUID(representation=UUIDRepresentation.HEXA_STRING)
	@Getter
	String id;

	@Column(name = "LIBELLE", nullable = false)
	@NotNull
	@Getter
	@Setter
	String nom;

	/**
	 * En grammes
	 */
	@Column(name = "POIDS", nullable = false)
	@NotNull
	@Min(0)
	@Max(50000)
	@Getter
	@Setter
	Integer poids;

	/**
	 * LOB large object,
	 */
	@Column(name = "DESCRIPTION")
	@Lob
	@Getter
	@Setter
	String description;

	@Column(name = "BROUZOUF", nullable = false)
	@Min(1)
	@Max(100)
	@NotNull
	@Getter
	@Setter
	Integer brouzouf;

	@Enumerated(EnumType.STRING)
	@Column(name = "GENRE_BONBON", nullable = false)
	@NotNull
	@Getter
	@Setter
	GenreBonbon genre;

}
