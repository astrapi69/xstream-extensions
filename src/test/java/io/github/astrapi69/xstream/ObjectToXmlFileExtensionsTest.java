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


import com.thoughtworks.xstream.XStream;
import io.github.astrapi69.collection.list.ListFactory;
import io.github.astrapi69.file.delete.DeleteFileExtensions;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.auth.AccessRight;
import io.github.astrapi69.test.object.auth.Role;
import io.github.astrapi69.test.object.auth.Roles;
import io.github.astrapi69.test.object.enumtype.Gender;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The unit test class for the class {@link ObjectToXmlFileExtensions}
 */
public class ObjectToXmlFileExtensionsTest
{


	/**
	 * Test method for {@link ObjectToXmlFileExtensions#toXml(Object, File)}
	 */
	@Test
	public void testToXmlWithXStreamObject()
	{
		Employee actual;
		Employee expected;
		Person person;
		Employee employee;
		File xmlFile;
		// new scenario ...
		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "employee.xml");
		ObjectToXmlFileExtensions.toXml(employee, xmlFile);
		actual = XmlFileToObjectExtensions.toObject(xmlFile);
		assertNotNull(actual);
		expected = employee;
		assertEquals(actual, expected);
		RuntimeExceptionDecorator.decorate(() -> DeleteFileExtensions.delete(xmlFile));
	}

	/**
	 * Test method for {@link ObjectToXmlFileExtensions#toXml(Object, Map, File)}
	 */
	@Test
	public void testToXmlWithXStreamObjectMapOfStringClass()
	{
		Employee actual;
		Employee expected;
		Person person;
		Employee employee;
		Map<String, Class<?>> aliases;
		Set<Role> rs;
		Roles roles;
		Role role;
		Set<AccessRight> rights;
		AccessRight right;
		File xmlFile;

		// new scenario ...
		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();

		employee = Employee.builder().id("23").person(person).build();

		aliases = new HashMap<>();
		String lqSimpleName = Employee.class.getSimpleName().toLowerCase();
		aliases.put(lqSimpleName, Employee.class);

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "employee.xml");
		ObjectToXmlFileExtensions.toXml(employee, aliases, xmlFile);
		actual = XmlFileToObjectExtensions.toObject(xmlFile, aliases);
		assertNotNull(actual);
		expected = employee;
		assertEquals(actual, expected);
		RuntimeExceptionDecorator.decorate(() -> DeleteFileExtensions.delete(xmlFile));
	}

	/**
	 * Test method for {@link ObjectToXmlFileExtensions#toXml(Object, Map, File)}
	 */
	@Test
	public void testToXmlWithXStreamObjectMapOfStringClassSecondUseCase()
	{
		Roles actual;
		Roles expected;
		Person person;
		Employee employee;
		Map<String, Class<?>> aliases;
		Set<Role> rs;
		Roles roles;
		Role role;
		Set<AccessRight> rights;
		AccessRight right;
		File xmlFile;

		// new scenario ...
		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();

		employee = Employee.builder().id("23").person(person).build();

		aliases = new HashMap<>();
		String lqSimpleName = Employee.class.getSimpleName().toLowerCase();
		aliases.put(lqSimpleName, Employee.class);

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
		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "roles.xml");
		ObjectToXmlFileExtensions.toXml(roles, aliases, xmlFile);
		actual = XmlFileToObjectExtensions.toObject(xmlFile, aliases);
		assertNotNull(actual);
		expected = roles;
		assertEquals(actual, expected);
		RuntimeExceptionDecorator.decorate(() -> DeleteFileExtensions.delete(xmlFile));
	}

	/**
	 * Test method for {@link ObjectToXmlFileExtensions#toXml(XStream, Object, File)}
	 */
	@Test
	public void testToXmlWithXStreamXStreamObject()
	{
		Employee actual;
		Employee expected;
		Person person;
		Employee employee;
		File xmlFile;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();

		employee = Employee.builder().id("23").person(person).build();

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "employee.xml");
		ObjectToXmlFileExtensions.toXml(new XStream(), employee, xmlFile);

		actual = XmlFileToObjectExtensions.toObject(xmlFile);
		assertNotNull(actual);
		expected = employee;
		assertEquals(actual, expected);
		RuntimeExceptionDecorator.decorate(() -> DeleteFileExtensions.delete(xmlFile));
	}

	/**
	 * Test method for {@link ObjectToXmlFileExtensions#toXml(XStream, Object, File)} with a
	 * {@link List}
	 */
	@Test
	public void testToXmlWithXStreamXStreamObjectWithList()
	{
		List<Person> actual;
		List<Person> expected;
		Person person;
		Person person2;
		List<Person> personList;
		File xmlFile;

		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();
		person2 = Person.builder().gender(Gender.MALE).name("Anton").nickname(null).married(null)
			.about(null).build();

		personList = ListFactory.newArrayList(person, person2);

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "employees.xml");
		ObjectToXmlFileExtensions.toXml(personList, xmlFile);

		actual = XmlFileToObjectExtensions.toObject(xmlFile);
		assertNotNull(actual);
		expected = personList;
		assertEquals(actual, expected);
		RuntimeExceptionDecorator.decorate(() -> DeleteFileExtensions.delete(xmlFile));
	}

	/**
	 * Test method for {@link ObjectToXmlFileExtensions#toXml(XStream, Object, Map, File)}
	 */
	@Test
	public void testToXmlWithXStreamXStreamTMapOfStringClassOfQ()
	{
		Employee actual;
		Employee expected;
		Person person;
		Employee employee;
		Map<String, Class<?>> aliases;
		Set<Role> rs;
		Roles roles;
		Role role;
		Set<AccessRight> rights;
		AccessRight right;
		File xmlFile;

		// new scenario ...
		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();

		employee = Employee.builder().id("23").person(person).build();

		aliases = new HashMap<>();
		String lqSimpleName = Employee.class.getSimpleName().toLowerCase();
		aliases.put(lqSimpleName, Employee.class);

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "employee.xml");
		ObjectToXmlFileExtensions.toXml(new XStream(), employee, aliases, xmlFile);

		actual = XmlFileToObjectExtensions.toObject(xmlFile, aliases);
		assertNotNull(actual);
		expected = employee;
		assertEquals(actual, expected);
		RuntimeExceptionDecorator.decorate(() -> DeleteFileExtensions.delete(xmlFile));

	}

	/**
	 * Test method for {@link ObjectToXmlFileExtensions#toXml(XStream, Object, Map, File)}
	 */
	@Test
	public void testToXmlWithXStreamXStreamTMapOfStringClassOfQSecondUseCase()
	{
		Roles actual;
		Roles expected;
		Person person;
		Employee employee;
		Map<String, Class<?>> aliases;
		Set<Role> rs;
		Roles roles;
		Role role;
		Set<AccessRight> rights;
		AccessRight right;
		File xmlFile;

		// new scenario ...
		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();

		employee = Employee.builder().id("23").person(person).build();

		aliases = new HashMap<>();
		String lqSimpleName = Employee.class.getSimpleName().toLowerCase();
		aliases.put(lqSimpleName, Employee.class);

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "roles.xml");

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

		ObjectToXmlFileExtensions.toXml(new XStream(), roles, aliases, xmlFile);
		actual = XmlFileToObjectExtensions.toObject(xmlFile, aliases);
		assertNotNull(actual);
		expected = roles;
		assertEquals(actual, expected);
		RuntimeExceptionDecorator.decorate(() -> DeleteFileExtensions.delete(xmlFile));
	}

	/**
	 * Test method for {@link ObjectToXmlFileExtensions}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ObjectToXmlFileExtensions.class);
	}

}
