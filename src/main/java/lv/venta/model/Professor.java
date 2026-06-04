package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.venta.model.enums.Degree;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ProfessorTable") //jāaizkomēt, ja inheratance stratēģija ir SINGLE_TABLE
@Entity
public class Professor extends Person{

	
	@NotNull
	@Column(name = "Degree")
	@Enumerated(EnumType.STRING)
	private Degree degree;
	
	
	//mappedBy jaliek uz otras klases mainīgā nosaukumu
	@OneToOne(mappedBy = "professor")
	@ToString.Exclude //neiekļaut šo mainīgo toString funkcijas veidošanā
	//@JsonIgnore <-līdzīgi ka @ToString.Exclude, lai neveidojas cirkulārie izsaukumi
	private Course course;
	
	
	public Professor(String name, String surname, Degree degree) {
		super(name, surname);//so var izdarīt arī tad, ja super klasē ir @MappedSuperClass
		setDegree(degree);
	}
}
