package hello;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";

	@Autowired
	private GreetingIdRepository greetingIdRepository;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		Iterator<GreetingId> greetingidIterator = greetingIdRepository.findAll().iterator();

		GreetingId greetingId = null;
		if (greetingidIterator.hasNext()) {
			greetingId = greetingidIterator.next();
		} else {
			greetingId = GreetingId.CREATE_FIRST_GREETING_ID();
			greetingIdRepository.save(greetingId);
		}

		Greeting result = new Greeting(greetingId.incrementAndCount(), String.format(template, name));
		greetingIdRepository.save(greetingId);
		return result;
	}

}