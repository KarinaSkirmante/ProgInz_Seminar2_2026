package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//piemērs, kad mantosana ir tikai java līmenī, līdz ar to nebūs ne @table, ne @Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor//visu argumentu konstruktors, jo abi mainīgie būs jāauzstāda caur konstruktoru
@ToString
@MappedSuperclass//jo taisam kā super klasi, kuru mantos entītijas klases
public class Person {
	
	//id nevajag, jo sī klases nebūs tabula DB
	
	@Column(name = "Name")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Ž]{1}[a-ž]{2,20}([ ]{1}([A-Ž]{1}[a-ž]{2,20}))?")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Ž]{1}[a-ž]{2,20}([ -]{1}([A-Ž]{1}[a-ž]{2,20}))?")
	private String surname;

}
