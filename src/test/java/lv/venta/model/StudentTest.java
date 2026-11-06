package lv.venta.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	public void testStudentConstructor() {
		Student student = new Student("Karina", "Šķirmante");
		assertEquals("Karina", student.getName());
		assertEquals("Šķirmante", student.getSurname());
	}
	
	@Test
	public void testToString() {
		Student student = new Student("Karina", "Šķirmante");
		assertNotNull(student.toString());
	}
	
	public void testDefaultConstructor() {
		Student student = new Student();
		student.setName("Jānis");
		student.setSurname("Bērziņš");
		assertEquals("Jānis", student.getName());
		assertEquals("Bērziņš", student.getSurname());
	}

}
