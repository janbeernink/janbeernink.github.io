package eu.jbeernink.blog.jdk21.stringtemplates.processor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringBuilderProcessorTest {

	@Test
	@DisplayName("process(StringTemplate) returns expected string.")
	void process_returnsExpectedString() {
		var processor = new StringBuilderProcessor();

		String result = processor."\{1 + 2} foo bar \{3 + 4} bla \{5 + 6}";

		assertEquals("3 foo bar 7 bla 11", result);
	}

}