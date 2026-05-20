package lv.venta.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter //visiem klases mainīgajiem tiek uzģeneretas get funkcijas no lombok
@Setter //visiem klases mainīgajiem tiek uzģeneretas set funkcijas no lombok
@NoArgsConstructor//no lombok
@ToString//no lombok
public class Student {
	
	//TODO pievienot data JPA anotācijas
	//TODO pievienot validāciju anotācijas
	@Setter(value = AccessLevel.NONE)//priekš ids nebūs set funkcija
	private long ids;
	
	
	private String name;
	private String surname;
	
	public Student(String name, String surname) {
		setName(name);
		setSurname(surname);
	}

}
