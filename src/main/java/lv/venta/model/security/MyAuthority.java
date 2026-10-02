package lv.venta.model.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "MyAuthorityTable")
@Entity
public class MyAuthority {
	@Column(name = "Ida")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)//priekš ids nebūs set funkcija
	private long ida;
	
	@Column(name = "Title", unique = true)
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z_]{3,10}")
	private String title;
	
	//TODO uztaisīt konstruktoru
}
