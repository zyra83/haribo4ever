package components;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent(createTag = true, tagName = "localDate", namespace = "http://prsi/taglib")
public class LocalDateTag extends UIComponentBase {

	/**
	 * Sert à rein
	 */
	@Override
	public String getFamily() {
		// ce truc OSEF...
		return "prsi.custom.component";
	}

	/**
	 * Traitement du tag JSF
	 */
	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		LocalDate date = (LocalDate) this.getAttributes().get("value");
		if (date != null) {
			ResponseWriter writer = context.getResponseWriter();
			String pattern = (String) this.getAttributes().get("pattern");

			writer.write(date.format(DateTimeFormatter.ofPattern(pattern)));
		}

	}

}