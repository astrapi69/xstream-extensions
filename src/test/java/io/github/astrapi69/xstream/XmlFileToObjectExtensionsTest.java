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
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.enumtype.Gender;
import io.github.astrapi69.xstream.factory.XStreamFactory;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The unit test class for the class {@link XmlFileToObjectExtensions}
 */
public class XmlFileToObjectExtensionsTest
{

	/**
	 * Test method for {@link XmlFileToObjectExtensions#toObject(File)}
	 */
	@Test
	void toObjectFile()
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).about(null)
			.married(null).build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "newtest.xml");
		actual = XmlFileToObjectExtensions.toObject(xmlFile);
		assertNotNull(actual);
		expected = employee;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link XmlFileToObjectExtensions#toObject(XStream, File)}
	 */
	@Test
	void toObjectXStreamFile()
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).about(null)
			.married(null).build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "newtest.xml");
		actual = XmlFileToObjectExtensions.toObject(XStreamFactory.newXStream(), xmlFile);
		assertNotNull(actual);
		expected = employee;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link XmlFileToObjectExtensions#toObject(File, Map)}
	 */
	@Test
	void toObjectFileMap()
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;
		Map<String, Class<?>> aliases;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).about(null)
			.married(null).build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(),
			"test-employee.xml");
		aliases = new HashMap<>();
		aliases.put("employee", Employee.class);
		aliases.put("person", Person.class);
		actual = XmlFileToObjectExtensions.toObject(xmlFile, aliases);
		assertNotNull(actual);
		expected = employee;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link XmlFileToObjectExtensions#toObject(XStream, File, Map)}
	 */
	@Test
	void toObjectXStreamFileMap()
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;
		Map<String, Class<?>> aliases;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).about(null)
			.married(null).build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(),
			"test-employee.xml");
		aliases = new HashMap<>();
		aliases.put("employee", Employee.class);
		aliases.put("person", Person.class);
		actual = XmlFileToObjectExtensions.toObject(XStreamFactory.newXStream(), xmlFile, aliases);
		assertNotNull(actual);
		expected = employee;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link XmlFileToObjectExtensions#toObject(XStream, File, Map)}
	 */
	@Test
	void toObjectXStreamFileStringMap()
	{
		Employee actual;
		Employee expected;
		File xmlFile;
		Person person;
		Employee employee;
		Map<String, Class<?>> aliases;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).about(null)
			.married(null).build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(),
			"test-employee.xml");
		aliases = new HashMap<>();
		aliases.put("employee", Employee.class);
		aliases.put("person", Person.class);
		actual = XmlFileToObjectExtensions.toObject(XStreamFactory.newXStream(), xmlFile, "UTF-8",
			aliases);
		assertNotNull(actual);
		expected = employee;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link XmlFileToObjectExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(XmlFileToObjectExtensions.class);
	}

}
