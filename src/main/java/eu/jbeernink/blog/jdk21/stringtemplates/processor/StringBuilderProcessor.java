package eu.jbeernink.blog.jdk21.stringtemplates.processor;

// tag::processor[]
import java.util.Iterator;

public class StringBuilderProcessor implements StringTemplate.Processor<String, RuntimeException>{
	@Override
	public String process(StringTemplate stringTemplate) throws RuntimeException {
		var stringBuilder = new StringBuilder();

		Iterator<String> fragmentsIterator = stringTemplate.fragments().iterator();
		Iterator<Object> valuesIterator = stringTemplate.values().iterator();

		while (fragmentsIterator.hasNext()) { // <1>
			stringBuilder.append(fragmentsIterator.next()); // <2>

			if (valuesIterator.hasNext()) { // <3>
				stringBuilder.append(valuesIterator.next());
			}
		}

		return stringBuilder.toString();
	}
}
// end::processor[]
