package habsida.ygrit0s.RestClient;

import habsida.ygrit0s.RestClient.client.RestClient;
import habsida.ygrit0s.RestClient.configs.AppConfig;
import habsida.ygrit0s.RestClient.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

	public static void main(String[] args) {
	var context = new AnnotationConfigApplicationContext(AppConfig.class);
		RestClient restClient = context.getBean(RestClient.class);
		String sessionID = restClient.userList()
				.getHeaders()
				.getValuesAsList("Set-Cookie")
				.get(0);
		
		User userCreate = new User(3, "James", "Brown", (byte) 55);
		User userUpdate = new User(3, "Thomas", "Shelby", (byte) 64);
		User userDelete = new User();
		userDelete.setId(3);

		String secret1 = restClient.addUser(userCreate, sessionID).getBody();
		String secret2 = restClient.updateUser(userUpdate, sessionID).getBody();
		String secret3 = restClient.removeUser(userDelete, sessionID).getBody();

		System.out.println(secret1 + secret2 + secret3);
	}
}
