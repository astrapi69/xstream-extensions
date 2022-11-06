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


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.github.astrapi69.collection.list.ListFactory;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import com.thoughtworks.xstream.XStream;

import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.auth.AccessRight;
import io.github.astrapi69.test.object.auth.Role;
import io.github.astrapi69.test.object.auth.Roles;
import io.github.astrapi69.test.object.enumtype.Gender;

/**
 * The unit test class for the class {@link ObjectToXmlExtensions}
 */
public class ObjectToXmlExtensionsTest
{


	/**
	 * Test method for {@link ObjectToXmlExtensions#toXml(Object)}
	 */
	@Test
	public void testToXmlWithXStreamObject()
	{
		String actual;
		String expected;
		Person person;
		Employee employee;
		// new scenario ...
		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();

		employee = Employee.builder().id("23").person(person).build();

		actual = ObjectToXmlExtensions.toXml(employee);
		expected = "<io.github.astrapi69.test.object.Employee>\n" + "  <id>23</id>\n"
			+ "  <person>\n" + "    <gender>FEMALE</gender>\n" + "    <name>Anna</name>\n"
			+ "  </person>\n" + "  <subOrdinates class=\"empty-set\"/>\n"
			+ "</io.github.astrapi69.test.object.Employee>";
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ObjectToXmlExtensions#toXml(Object, Map)}
	 */
	@Test
	public void testToXmlWithXStreamObjectMapOfStringClass()
	{
		String actual;
		String expected;
		Person person;
		Employee employee;
		Map<String, Class<?>> aliases;
		Set<Role> rs;
		Roles roles;
		Role role;
		Set<AccessRight> rights;
		AccessRight right;

		// new scenario ...
		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();

		employee = Employee.builder().id("23").person(person).build();

		aliases = new HashMap<>();
		String lqSimpleName = Employee.class.getSimpleName().toLowerCase();
		aliases.put(lqSimpleName, Employee.class);

		actual = ObjectToXmlExtensions.toXml(employee, aliases);
		expected = "<employee>\n" + "  <id>23</id>\n" + "  <person>\n"
			+ "    <gender>FEMALE</gender>\n" + "    <name>Anna</name>\n" + "  </person>\n"
			+ "  <subOrdinates class=\"empty-set\"/>\n" + "</employee>";
		assertEquals(expected, actual);

		// new scenario ...
		rs = new HashSet<>();
		roles = Roles.builder().roles(rs).build();

		role = Role.builder().build();
		rs.add(role);
		rights = new HashSet<>();
		role.setRights(rights);
		right = AccessRight.builder().build();
		right.setDescription("bla");
		rights.add(right);
		aliases = new HashMap<>();
		lqSimpleName = Roles.class.getSimpleName().toLowerCase();
		aliases.put(lqSimpleName, Roles.class);
		lqSimpleName = Role.class.getSimpleName().toLowerCase();
		aliases.put(lqSimpleName, Role.class);
		lqSimpleName = AccessRight.class.getSimpleName().toLowerCase();
		aliases.put(lqSimpleName, AccessRight.class);

		actual = ObjectToXmlExtensions.toXml(roles, aliases);
		expected = "<roles>\n" + "  <roles class=\"empty-set\"/>\n" + "</roles>";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ObjectToXmlExtensions#toXml(XStream, Object)}.
	 */
	@Test
	public void testToXmlWithXStreamXStreamObject()
	{
		String actual;
		String expected;
		Person person;
		Employee employee;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();

		employee = Employee.builder().id("23").person(person).build();

		actual = ObjectToXmlExtensions.toXml(new XStream(), employee);
		expected = "<io.github.astrapi69.test.object.Employee>\n" + "  <id>23</id>\n"
			+ "  <person>\n" + "    <gender>FEMALE</gender>\n" + "    <name>Anna</name>\n"
			+ "  </person>\n" + "  <subOrdinates class=\"empty-set\"/>\n"
			+ "</io.github.astrapi69.test.object.Employee>";
		assertNotNull(actual);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ObjectToXmlExtensions#toXml(XStream, Object)} with a {@link List}
	 */
	@Test
	public void testToXmlWithXStreamXStreamObjectWithList()
	{
		String actual;
		String expected;
		Person person;
		Person person2;
		List<Person> personList;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();
		person2 = Person.builder().gender(Gender.MALE).name("Anton").nickname(null).married(null)
			.about(null).build();

		personList = ListFactory.newArrayList(person, person2);
		actual = ObjectToXmlExtensions.toXml(personList);
		expected = "<list>\n" + "  <io.github.astrapi69.test.object.Person>\n"
			+ "    <gender>FEMALE</gender>\n" + "    <name>Anna</name>\n"
			+ "  </io.github.astrapi69.test.object.Person>\n"
			+ "  <io.github.astrapi69.test.object.Person>\n" + "    <gender>MALE</gender>\n"
			+ "    <name>Anton</name>\n" + "  </io.github.astrapi69.test.object.Person>\n"
			+ "</list>";
		assertNotNull(actual);
		assertEquals(expected, actual);

		List<Person> personList2 = XmlToObjectExtensions.toObject(actual);
		assertEquals(personList2, personList);
	}

	/**
	 * Test method for {@link ObjectToXmlExtensions#toXml(XStream, Object, Map)}.
	 */
	@Test
	public void testToXmlWithXStreamXStreamTMapOfStringClassOfQ()
	{
		String actual;
		String expected;
		Person person;
		Employee employee;
		Map<String, Class<?>> aliases;
		Set<Role> rs;
		Roles roles;
		Role role;
		Set<AccessRight> rights;
		AccessRight right;

		// new scenario ...
		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();

		employee = Employee.builder().id("23").person(person).build();

		aliases = new HashMap<>();
		String lqSimpleName = Employee.class.getSimpleName().toLowerCase();
		aliases.put(lqSimpleName, Employee.class);

		actual = ObjectToXmlExtensions.toXml(new XStream(), employee, aliases);
		expected = "<employee>\n" + "  <id>23</id>\n" + "  <person>\n"
			+ "    <gender>FEMALE</gender>\n" + "    <name>Anna</name>\n" + "  </person>\n"
			+ "  <subOrdinates class=\"empty-set\"/>\n" + "</employee>";
		assertEquals(expected, actual);

		// new scenario ...
		rs = new HashSet<>();
		roles = Roles.builder().roles(rs).build();

		role = Role.builder().build();
		rs.add(role);
		rights = new HashSet<>();
		role.setRights(rights);
		right = AccessRight.builder().build();
		right.setDescription("bla");
		rights.add(right);
		aliases = new HashMap<>();
		lqSimpleName = Roles.class.getSimpleName().toLowerCase();
		aliases.put(lqSimpleName, Roles.class);
		lqSimpleName = Role.class.getSimpleName().toLowerCase();
		aliases.put(lqSimpleName, Role.class);
		lqSimpleName = AccessRight.class.getSimpleName().toLowerCase();
		aliases.put(lqSimpleName, AccessRight.class);

		actual = ObjectToXmlExtensions.toXml(new XStream(), roles, aliases);
		expected = "<roles>\n" + "  <roles class=\"empty-set\"/>\n" + "</roles>";
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ObjectToXmlExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ObjectToXmlExtensions.class);
	}

}
