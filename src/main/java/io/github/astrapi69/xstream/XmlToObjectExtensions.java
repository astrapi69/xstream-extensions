package io.github.astrapi69.xstream;

import java.util.Map;
import java.util.Objects;

import com.thoughtworks.xstream.XStream;

import io.github.astrapi69.xstream.factory.XStreamFactory;

/**
 * The class {@link XmlToObjectExtensions} provides methods for convert xml string objects to java
 * objects
 */
public final class XmlToObjectExtensions
{

	private XmlToObjectExtensions()
	{
	}

	/**
	 * Creates from the given xml string an java object.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param xmlString
	 *            the xml as string object
	 * @return the xml string
	 */
	public static <T> T toObject(final String xmlString)
	{
		return toObject(null, xmlString);
	}

	/**
	 * Creates from the given xml string an Object. The given map hold the aliases. For more
	 * information with aliasing see documation of xstream.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param xmlString
	 *            the xml as string object
	 * @param aliases
	 *            the aliases
	 * @return the created object from the given xml string.
	 */
	public static <T> T toObject(final String xmlString, final Map<String, Class<?>> aliases)
	{
		return toObject(null, xmlString, aliases);
	}

	/**
	 * Creates from the given xml string an java object.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param xstream
	 *            the xstream object.
	 * @param xmlString
	 *            the xml as string object
	 * @return the object
	 */
	public static <T> T toObject(final XStream xstream, final String xmlString)
	{
		return toObject(xstream, xmlString, null);
	}

	/**
	 * Creates from the given xml string an java object. The given map hold the aliases. For more
	 * information with aliasing see documentation of xstream.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param xstream
	 *            the xstream object.
	 * @param xmlString
	 *            the xml
	 * @param aliases
	 *            the aliases
	 * @return the object
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toObject(XStream xstream, final String xmlString,
		final Map<String, Class<?>> aliases)
	{
		Objects.requireNonNull(xmlString);
		xstream = XStreamFactory.initializeXStream(xstream, aliases);
		return (T)xstream.fromXML(xmlString);
	}

}
