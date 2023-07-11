package eu.jbeernink.blog.jdk21.stringtemplates;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringTemplateDemoTest {

	@Test
	@DisplayName("stringTemplateSyntax() produces expected String")
	void stringTemplateSyntax_producesExpectedString() {
		var demo = new StringTemplateDemo();

		String result = demo.stringTemplateSyntax();

		assertEquals("1 + 2 = 3", result);
	}

	@Test
	@DisplayName("strProcessorExample() returns expected result")
	void strProcessorExample_returnsExpectedResult() {
		var demo = new StringTemplateDemo();

		String result = demo.strProcessorExample("world");

		assertEquals("Hello, world!", result);
	}

	@Test
	@DisplayName("fmtProcessorExample() returns expected result")
	void fmtProcessorExample_returnsExpectedResult() {
		var demo = new StringTemplateDemo();

		String result = demo.fmtProcessorExample(15);

		assertEquals("0F", result);
	}
}