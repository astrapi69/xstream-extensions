package io.github.astrapi69.xstream;

import java.util.Map;

import com.thoughtworks.xstream.XStream;

import io.github.astrapi69.xstream.factory.XStreamFactory;

/**
 * The class {@link ObjectToXmlExtensions} provides methods for convert java objects to xml string
 * objects
 */
public class ObjectToXmlExtensions
{

	/**
	 * Creates from the given Object an xml string.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param objectToXML
	 *            the object to xml
	 * @return the xml string
	 */
	public static <T> String toXml(final T objectToXML)
	{
		return toXml(null, objectToXML);
	}

	/**
	 * Creates from the given Object an xml string.
	 *
	 * @param <T>
	 *            the generic type of the object that will be transformed to xml
	 * @param xstream
	 *            the xstream object.
	 * @param objectToXML
	 *            the object to xml
	 * @return the xml string
	 */
	public static <T> String toXml(final XStream xstream, final T objectToXML)
	{
		return toXml(xstream, objectToXML, null);
	}

	/**
	 * Creates from the given Object an xml string. The given map hold the aliases. For more
	 * information with aliasing see documation of xstream.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param xstream
	 *            the xstream
	 * @param objectToXML
	 *            the object to xml
	 * @param aliases
	 *            the aliases
	 * @return the xml string
	 */
	public static <T> String toXml(XStream xstream, final T objectToXML,
		final Map<String, Class<?>> aliases)
	{
		xstream = XStreamFactory.initializeXStream(xstream, aliases);
		return xstream.toXML(objectToXML);
	}

	/**
	 * Creates from the given Object an xml string. The given map hold the aliases. For more
	 * information with aliasing see documation of xstream.
	 *
	 * @param <T>
	 *            the generic type of the object that will be transformed to xml
	 * @param objectToXML
	 *            the object to xml
	 * @param aliases
	 *            the aliases
	 * @return the xml string
	 */
	public static <T> String toXml(final T objectToXML,
		final Map<String, Class<?>> aliases)
	{
		return toXml(null, objectToXML, aliases);
	}
}
