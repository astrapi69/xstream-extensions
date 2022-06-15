package io.github.astrapi69.xstream;

import io.github.astrapi69.xml.api.XmlToGenericObject;
import io.github.astrapi69.xml.api.XmlToObject;
import lombok.NonNull;

/**
 * The class {@link XmlToObjectConverter} can convert a given xml string to an object
 */
public class XmlToObjectConverter implements XmlToGenericObject
{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T toObject(final @NonNull String xmlString)
	{
		return XmlToObjectExtensions.toObject(xmlString);
	}
}
