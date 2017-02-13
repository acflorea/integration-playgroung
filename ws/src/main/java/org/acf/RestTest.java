package org.acf;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * @author aflorea.
 */

@RestController
@RequestMapping("/RESTTest")
public class RestTest {

	final static Logger logger = Logger.getLogger(RestTest.class);

	@RequestMapping(method = PUT)
	public String greeting(@RequestBody String input) {
		if (logger.isInfoEnabled()) {
			logger.info("Received request for correlationId " + input);
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String result = input + " - Hurray from the service at " + new java.util.Date();

		if (logger.isInfoEnabled()) {
			logger.info("Request processed for correlationId " + input);
		}

		return result;
	}

}