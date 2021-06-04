package hello.hellospring;

import java.awt.EventQueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import view.Main;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
