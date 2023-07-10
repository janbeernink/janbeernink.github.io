package eu.jbeernink.blog.jdk21.stringtemplates;

import static java.util.FormatProcessor.FMT;

public class StringTemplateGreetingDemo {

	static class Formatter {

		// tag::formatter[]
		String generateGreeting(String name) {
			return String.format("Hello, %s!", name);
		}
		// end::formatter[]
	}
	static class StringTemplates {

		// tag::stringTemplate[]
		String generateGreeting(String name) {
			return FMT."Hello, \{name}!";
		}
		// end::stringTemplate[]
	}
}
