package eu.jbeernink.blog.jdk21.stringtemplates.processor;

import java.util.Map;

public class MapProcessor<T> implements StringTemplate.Processor<Map<String, T>, RuntimeException> {
	@Override
	public Map<String, T> process(StringTemplate stringTemplate) throws RuntimeException {

		return null;
	}
}
