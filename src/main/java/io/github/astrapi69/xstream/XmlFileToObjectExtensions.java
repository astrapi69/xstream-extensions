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
import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Objects;

/**
 * The class {@link XmlFileToObjectExtensions} provides algorithms for transform a given xml file to
 * a java object
 */
public final class XmlFileToObjectExtensions
{

	private XmlFileToObjectExtensions()
	{
	}

	/**
	 * Creates from the given xml string an java object.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param xmlFile
	 *            the xml file
	 * @return the created object from the given xml file
	 */
	public static <T> T toObject(final File xmlFile)
	{
		Objects.requireNonNull(xmlFile);
		return XmlToObjectExtensions.toObject(null,
			RuntimeExceptionDecorator.decorate(() -> ReadFileExtensions.fromFile(xmlFile)));
	}

	/**
	 * Creates from the given xml file a java object. The given map hold the aliases. For more
	 * information with aliasing see documation of xstream.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param xmlFile
	 *            the xml file
	 * @param aliases
	 *            the aliases
	 * @return the created object from the given xml file
	 */
	public static <T> T toObject(final File xmlFile, final Map<String, Class<?>> aliases)
	{
		Objects.requireNonNull(xmlFile);
		return XmlToObjectExtensions.toObject(null,
			RuntimeExceptionDecorator.decorate(() -> ReadFileExtensions.fromFile(xmlFile)),
			aliases);
	}

	/**
	 * Creates from the given xml file a java object
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param xstream
	 *            the xstream object.
	 * @param xmlFile
	 *            the xml file
	 * @return the created object from the given xml file
	 */
	public static <T> T toObject(final XStream xstream, final File xmlFile)
	{
		Objects.requireNonNull(xmlFile);
		return XmlToObjectExtensions.toObject(xstream,
			RuntimeExceptionDecorator.decorate(() -> ReadFileExtensions.fromFile(xmlFile)), null);
	}

	/**
	 * Creates from the given xml file a java object. The given map hold the aliases. For more
	 * information with aliasing see documentation of xstream.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param xstream
	 *            the xstream object.
	 * @param xmlFile
	 *            the xml file
	 * @param aliases
	 *            the aliases
	 * @return the created object from the given xml file
	 */
	public static <T> T toObject(XStream xstream, final File xmlFile,
		final Map<String, Class<?>> aliases)
	{
		Objects.requireNonNull(xmlFile);
		return XmlToObjectExtensions.toObject(xstream,
			RuntimeExceptionDecorator.decorate(() -> ReadFileExtensions.fromFile(xmlFile)),
			aliases);
	}

	/**
	 * Creates from the given xml file a java object. The given map hold the aliases. For more
	 * information with aliasing see documentation of xstream.
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param xstream
	 *            the xstream object.
	 * @param xmlFile
	 *            the xml file
	 * @param charsetName
	 *            the encoding name of the charset form the given xml file
	 * @param aliases
	 *            the aliases
	 * @return the created object from the given xml file
	 */
	public static <T> T toObject(XStream xstream, final File xmlFile, final String charsetName,
		final Map<String, Class<?>> aliases)
	{
		Objects.requireNonNull(xmlFile);
		return XmlToObjectExtensions.toObject(xstream, RuntimeExceptionDecorator.decorate(
			() -> ReadFileExtensions.fromFile(xmlFile, Charset.forName(charsetName))), aliases);
	}

}
