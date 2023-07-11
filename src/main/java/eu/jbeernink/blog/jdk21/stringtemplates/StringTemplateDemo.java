package eu.jbeernink.blog.jdk21.stringtemplates;

import static java.util.FormatProcessor.FMT;

public class StringTemplateDemo {

	String stringTemplateSyntax() {
		var processor = StringTemplate.STR;
		return
				// tag::syntax[]
				processor."1 + 2 = \{1 + 2}"; // <1>
		// end::syntax[]
	}

	String textBlockTemplateSyntax(String name) {
		var processor = StringTemplate.STR;
		return
				// tag::textBlockTemplate[]
				processor."""
				This is the first line.
				This is the second.
				Insert \{name} here.
				""";
		// end::textBlockTemplate[]
	}

	String strProcessorExample(String name) {
		// tag::strProcessorExample[]
		String message = STR."Hello, \{name}!"; // <1>
		// end::strProcessorExample[]
		return message;
	}

	String fmtProcessorExample(int number) {
		// tag::fmtProcessorExample[]
		String output = FMT."%02X\{number}"; // <1>
		// end::fmtProcessorExample[]

		return output;
	}
}
