package haribo4ever.model.entities;

public enum GenreBonbon {

	CROCODILE("crocodile", "cro"), FRAISE_TAGADA("fraise tagada", "fra"), TINOURS("tinours", "ti"), DRAGIBUS("dragibus",
			"dra");

	private final String libelle;
	private final String url;

	GenreBonbon(String s, String s2) {
		this.libelle = s;
		this.url = s2;
	}

	public String getUrl() {
		return url;
	}

	public String getLibelle() {
		return libelle;
	}

	@Override
	public String toString() {
		return this.libelle;
	}
}
