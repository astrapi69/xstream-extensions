package io.github.astrapi69.xstream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class XmlToObjectConverterTest
{

	@Test
	void toObjectClub()
	{
		Club actual;
		Club expected;
		expected = TestDataFactory.newClub();

		ObjectToXmlConverter converter = new ObjectToXmlConverter();
		String xml = converter.toXml(expected);

		XmlToObjectConverter xmlToObjectConverter = new XmlToObjectConverter();
		actual = xmlToObjectConverter.toObject(xml);
		assertEquals(expected, actual);
	}

	@Test
	void toObjectCompany()
	{
		Company actual;
		Company expected;
		expected = TestDataFactory.newCompany();

		ObjectToXmlConverter converter = new ObjectToXmlConverter();
		String xml = converter.toXml(expected);

		XmlToObjectConverter xmlToObjectConverter = new XmlToObjectConverter();
		actual = xmlToObjectConverter.toObject(xml);
		assertEquals(expected, actual);
	}
}