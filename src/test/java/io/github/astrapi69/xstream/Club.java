package io.github.astrapi69.xstream;

import java.util.List;

import lombok.Data;

@Data
public class Club
{
	List<Person> personsList;
	private String name;
	private String location;

}
