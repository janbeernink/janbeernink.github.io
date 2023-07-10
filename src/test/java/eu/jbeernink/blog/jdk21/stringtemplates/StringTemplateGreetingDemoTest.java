package eu.jbeernink.blog.jdk21.stringtemplates;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringTemplateGreetingDemoTest {


	@Nested
	@DisplayName("with formatter")
	class WithFormatter {

		@Test
		@DisplayName("generateGreeting(String) generates expected greeting.")
		void generateGreeting_generatesExpectedGreeting() {
			var formatter = new StringTemplateGreetingDemo.Formatter();

			String greeting = formatter.generateGreeting("world");

			assertEquals("Hello, world!", greeting);
		}
	}

	@Nested
	@DisplayName("with StringTemplate")
	class WithStringTemplate {

		@Test
		@DisplayName("generateGreeting(String) generates expected greeting.")
		void generateGreeting_generatesExpectedGreeting() {
			var formatter = new StringTemplateGreetingDemo.Formatter();

			String greeting = formatter.generateGreeting("everyone");

			assertEquals("Hello, everyone!", greeting);
		}
	}
}