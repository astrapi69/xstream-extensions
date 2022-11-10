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
package io.github.astrapi69.xstream;

import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.enumtype.Gender;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The unit test class for the class {@link XmlToObjectExtensions}
 */
public class XmlToObjectExtensionsTest
{

	/**
	 * Test method for {@link XmlToObjectExtensions#toObject(String)}
	 */
	@Test
	void toObject()
	{
		Employee actual;
		Employee expected;
		Person person;
		String xmlString;

		Map<String, Class<?>> aliases;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").married(false)
			.about("").build();

		expected = Employee.builder().id("23").person(person).build();

		xmlString = "<io.github.astrapi69.test.object.Employee>\n" + "  <id>23</id>\n"
			+ "  <person>\n" + "    <about/>\n" + "    <gender>FEMALE</gender>\n"
			+ "    <married/>\n" + "    <name>Anna</name>\n" + "    <nickname/>\n" + "  </person>\n"
			+ "  <subOrdinates class=\"empty-set\"/>\n"
			+ "</io.github.astrapi69.test.object.Employee>\n";

		actual = XmlToObjectExtensions.toObject(xmlString);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link XmlToObjectExtensions#toObject(String, Map)}
	 */
	@Test
	void toObjectStringMap()
	{
		Employee actual;
		Employee expected;
		Person person;
		String xmlString;

		Map<String, Class<?>> aliases;

		aliases = new HashMap<>();
		aliases.put("Employee", Employee.class);

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname("").married(false)
			.about("").build();

		expected = Employee.builder().id("23").person(person).build();

		xmlString = "<Employee>\n" + "  <id>23</id>\n" + "  <person>\n" + "    <about/>\n"
			+ "    <gender>FEMALE</gender>\n" + "    <married/>\n" + "    <name>Anna</name>\n"
			+ "    <nickname/>\n" + "  </person>\n" + "  <subOrdinates class=\"empty-set\"/>\n"
			+ "</Employee>\n";

		actual = XmlToObjectExtensions.toObject(xmlString, aliases);
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link XmlToObjectExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(XmlToObjectExtensions.class);
	}
}
