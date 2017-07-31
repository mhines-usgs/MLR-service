package gov.usgs.wma.messaging;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * A factory class for the construction of properly configured Gson objects for
 * JSON serialization and deserialization.
 * 
 * @author thongsav
 */
public class MlrGsonFactory {

	/**
	 * Returns a Gson object that is properly configured for use in AQCU.
	 * 
	 * @return
	 */
	public static Gson getConfiguredGson() {
		return new GsonBuilder()
				//TODO may need Time adapters, see AQCU's GSON Factory if so
		.disableHtmlEscaping()
		.setPrettyPrinting().create();
	}
}
