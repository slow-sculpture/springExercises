package exercises.exercise1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

		ApplicationContext context = new ClassPathXmlApplicationContext("scopes.xml");

		Student student = (Student) context.getBean("student");
		Student student2 = (Student) context.getBean("student");
		//rzutowanie niezbedne bo funkcja zwraca obiekt - trzeba wskazac ktory to konkretnie obiekt

		student.setName("John");
		student.setSurname("Bow");
		student.setAge(23);
		student.setSex("male");

		System.out.println(student);
		System.out.println(student2);
		//przez scope = singleton -> to bedzie zawsze ta sama instancja klasy
		// prototype - bedzie osobno

		Klasa klasa = (Klasa) context.getBean("klasa");
		klasa.getStudent1().setName("Joe");
		System.out.println(klasa);
	}
}
