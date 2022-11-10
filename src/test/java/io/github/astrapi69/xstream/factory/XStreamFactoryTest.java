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
package io.github.astrapi69.xstream.factory;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The unit test class for the class {@link XStreamFactory}
 */
public class XStreamFactoryTest
{

	/**
	 * Test method for {@link XStreamFactory#newXStream(XStream, Map, String...)}
	 */
	@Test
	public void testNewXStreamMapString()
	{
		XStream xStream;
		Map<String, Class<?>> aliases;

		aliases = new HashMap<>();
		aliases.put("employee", Employee.class);
		aliases.put("person", Person.class);

		xStream = XStreamFactory.newXStream(XStreamFactory.newXStream(), aliases, "java.**",
			"javax.**");
		assertNotNull(xStream);
	}

	/**
	 * Test method for {@link XStreamFactory#newXStream(XStream, Map, String...)}
	 */
	@Test
	public void testNewXStreamMapStringWithNoVarArgs()
	{
		XStream xStream;
		Map<String, Class<?>> aliases;

		aliases = new HashMap<>();
		aliases.put("employee", Employee.class);
		aliases.put("person", Person.class);

		xStream = XStreamFactory.newXStream(XStreamFactory.newXStream(), aliases);
		assertNotNull(xStream);
	}

	/**
	 * Test method for {@link XStreamFactory#newXStream()}
	 */
	@Test
	public void testNewXStream()
	{
		XStream xStream = XStreamFactory.newXStream();
		assertNotNull(xStream);
	}

	/**
	 * Test method for
	 * {@link XStreamFactory#newXStream(com.thoughtworks.xstream.io.HierarchicalStreamDriver)}
	 */
	@Test
	public void testNewXStreamWithHierarchicalStreamDriver()
	{
		XStream xStream = XStreamFactory.newXStream(new StaxDriver());
		assertNotNull(xStream);
	}

	/**
	 * Test method for {@link XStreamFactory}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(XStreamFactory.class);
	}

}
