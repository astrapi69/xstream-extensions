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
import io.github.astrapi69.file.write.WriteFileExtensions;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import io.github.astrapi69.xstream.factory.XStreamFactory;
import lombok.NonNull;

import java.io.File;
import java.util.Map;

/**
 * The class {@link ObjectToXmlFileExtensions} provides methods for convert java objects to xml and
 * save them to file objects
 */
public class ObjectToXmlFileExtensions
{

	/**
	 * Converts the given object to a xml string and write it to the given file object
	 *
	 * @param <T>
	 *            the generic type of the return type
	 * @param object
	 *            the object to convert to xml
	 * @param file
	 *            the file object
	 */
	public static <T> void toXml(final @NonNull T object, final @NonNull File file)
	{
		toXml(null, object, file);
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
	 * @param file
	 *            the file object
	 */
	public static <T> void toXml(final XStream xstream, final @NonNull T objectToXML,
		final @NonNull File file)
	{
		toXml(xstream, objectToXML, null, file);
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
	 * @param file
	 *            the file object
	 */
	public static <T> void toXml(final XStream xstream, final @NonNull T objectToXML,
		final Map<String, Class<?>> aliases, final @NonNull File file)
	{
		RuntimeExceptionDecorator.decorate(() -> WriteFileExtensions.string2File(file,
			XStreamFactory.initializeXStream(xstream, aliases).toXML(objectToXML), "UTF-8"));
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
	 * @param file
	 *            the file object
	 */
	public static <T> void toXml(final @NonNull T objectToXML, final Map<String, Class<?>> aliases,
		final @NonNull File file)
	{
		toXml(null, objectToXML, aliases, file);
	}

}
