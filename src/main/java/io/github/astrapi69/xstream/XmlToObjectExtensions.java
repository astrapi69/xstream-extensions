/**
 * The MIT License
 * <p>
 * Copyright (C) 2021 Asterios Raptis
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.xstream;

import com.thoughtworks.xstream.XStream;
import io.github.astrapi69.xstream.factory.XStreamFactory;

import java.util.Map;
import java.util.Objects;

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
	 * Creates from the given xml string a java object.
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
