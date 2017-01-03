import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {

	public static void main(String[] args) {
		Json obj = new Json();
		obj.run();
	}

	private void run() {
		ObjectMapper mapper = new ObjectMapper();
		Quickstart qs=new Quickstart();
		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(new File("/home/bridgeit/com/QuickStart.json"), qs);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}