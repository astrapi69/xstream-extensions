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

import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.enumtype.Gender;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The unit test class for the class {@link XmlFileToObjectConverter}
 */
public class XmlFileToObjectConverterTest
{

	/**
	 * Test method for {@link XmlFileToObjectConverter#toObject(File)}
	 */
	@Test
	void toObjectFile()
	{
		io.github.astrapi69.test.object.Employee actual;
		io.github.astrapi69.test.object.Employee expected;
		File xmlFile;
		io.github.astrapi69.test.object.Person person;
		io.github.astrapi69.test.object.Employee employee;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).about(null)
			.married(null).build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "newtest.xml");

		XmlFileToObjectConverter converter = new XmlFileToObjectConverter();
		actual = converter.toObject(xmlFile);
		assertNotNull(actual);
		expected = employee;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link XmlFileToObjectConverter}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(XmlFileToObjectConverter.class);
	}
}
