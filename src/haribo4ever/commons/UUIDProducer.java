package haribo4ever.commons;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;


/**
 * Un producteur de UUID au format String
 * @author Mickaël Benoit
 *
 */
@ApplicationScoped
public class UUIDProducer {

	@Produces
	@UUIDString
	public String generateUUID(){
		return UUID.randomUUID().toString();
	}
}
