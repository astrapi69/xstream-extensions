/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.xstream.factory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.security.WildcardTypePermission;

import java.util.Map;

/**
 * The factory class {@link XStreamFactory} for creating {@link XStream} objects for serializing
 * java beans to xml string and back
 */
public final class XStreamFactory
{
	private XStreamFactory()
	{
	}

	/**
	 * Initialize the given {@link XStream} object with the given aliases
	 *
	 * @param xstream
	 *            the {@link XStream} object
	 * @param aliases
	 *            the aliases
	 * @return the initialized {@link XStream} object
	 */
	public static XStream initializeXStream(XStream xstream, Map<String, Class<?>> aliases)
	{
		if (xstream == null)
		{
			xstream = newXStream();
		}
		if (aliases != null)
		{
			for (final Map.Entry<String, Class<?>> alias : aliases.entrySet())
			{
				xstream.alias(alias.getKey(), alias.getValue());
			}
		}
		xstream.allowTypesByWildcard(new String[] { "io.github.astrapi69.**" });
		return xstream;
	}

	/**
	 * Factory method for create a new {@link XStream} object
	 *
	 * @return the new {@link XStream} object
	 */
	public static XStream newXStream()
	{
		return new XStream();
	}

	/**
	 * Factory method for create a new {@link XStream} object
	 *
	 * @param hierarchicalStreamDriver
	 *            the {@link HierarchicalStreamDriver} object
	 *
	 * @return the initialized {@link XStream} object
	 */
	public static XStream newXStream(HierarchicalStreamDriver hierarchicalStreamDriver)
	{
		return new XStream(hierarchicalStreamDriver);
	}

	/**
	 * Factory method for create a new {@link XStream} object
	 *
	 * @param xstream
	 *            the {@link XStream} object
	 * @param aliases
	 *            the aliases map
	 * @param allowTypesByWildcard
	 *            the allowed types by wildcard
	 *
	 * @return the initialized {@link XStream} object
	 */
	public static XStream newXStream(XStream xstream, Map<String, Class<?>> aliases,
		String... allowTypesByWildcard)
	{
		if (0 < allowTypesByWildcard.length)
		{
			xstream.addPermission(new WildcardTypePermission(allowTypesByWildcard));
		}
		initializeXStream(xstream, aliases);
		return xstream;
	}
}
