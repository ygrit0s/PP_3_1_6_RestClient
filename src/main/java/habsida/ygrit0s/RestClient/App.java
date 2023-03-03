package habsida.ygrit0s.RestClient;

import habsida.ygrit0s.RestClient.client.RestClient;
import habsida.ygrit0s.RestClient.configs.AppConfig;
import habsida.ygrit0s.RestClient.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(AppConfig.class);
		var restClient = context.getBean(RestClient.class);

		String sessionID = restClient.getResourse()
				.getHeaders().getValuesAsList ("Set-Cookie").get(0);

		User userCreate = new User(3, "James", "Brown", (byte) 55);
		User userUpdate = new User(3, "Thomas", "Shelby", (byte) 64);
		User userDelete = new User(3);

		String code_1 = restClient.addUser(userCreate, sessionID).getBody();
		String code_2 = restClient.updateUser(userUpdate, sessionID).getBody();
		String code_3 = restClient.removeUser(userDelete, sessionID).getBody();

		System.out.println(code_1 + code_2 + code_3);
	}
}
