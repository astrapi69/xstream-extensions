package io.github.astrapi69.xstream;

import io.github.astrapi69.xml.api.ObjectToXml;
import lombok.NonNull;

public class ObjectToXmlConverter  implements ObjectToXml
{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> String toXml(final @NonNull T object)
	{
		return ObjectToXmlExtensions.toXml(object);
	}

}
