package io.github.astrapi69.xstream;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class Person
{
	/**
	 * The name.
	 */
	private String name;

	/**
	 * The about.
	 */
	private String gender;

	/**
	 * The married flag.
	 */
	private Boolean married;

	/**
	 * The nickname.
	 */
	private String nickname;

}
