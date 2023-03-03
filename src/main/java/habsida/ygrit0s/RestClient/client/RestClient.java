package habsida.ygrit0s.RestClient.client;

import habsida.ygrit0s.RestClient.entity.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RestClient {

	private final RestTemplate restTemplate;
	private final String URL = "http://94.198.50.185:7081/api/users";
	private final HttpHeaders httpHeaders = new HttpHeaders();


	public RestClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ResponseEntity<String> getResourse() {
		return restTemplate
				.getForEntity(URL, String.class);
	}

	public ResponseEntity<String> addUser(User user, String sessionID) {
		httpHeaders.set("Cookie", sessionID);
		return restTemplate.exchange(URL, HttpMethod.POST,
				new HttpEntity<>(user, httpHeaders), String.class);
	}

	public ResponseEntity<String> updateUser(User user, String sessionID) {
		httpHeaders.set("Cookie", sessionID);
		return restTemplate.exchange(URL, HttpMethod.PUT,
				new HttpEntity<>(user, httpHeaders), String.class);
	}

	public ResponseEntity<String> removeUser(User user, String sessionID) {
		httpHeaders.set("Cookie", sessionID);
		return restTemplate.exchange(URL + "/" + user.getId(),
				HttpMethod.DELETE,
				new HttpEntity<>(user, httpHeaders), String.class);
	}

	public ResponseEntity<List<User>> userList() {
		return restTemplate.exchange(URL, HttpMethod.GET,
				null, new ParameterizedTypeReference<>() {
				});
	}


//	public void addUser(User user) {
//		restTemplate.postForEntity(URL, user, String.class);
//		LOGGER.log(Level.INFO, "User {0} добавлен в базу данных%n", new Object[]{user});
//		System.out.println(request);
//	}
//
//	public void updateUser(User user) {
//		restTemplate.put(URL, user);
//		LOGGER.log(Level.INFO, "User c ID {0} был обновлен%n", new Object[]{user.getId()});
//	}
//
//	public void removeUser(@PathVariable int id) {
//		restTemplate.delete(URL + "/" + id);
//		LOGGER.log(Level.INFO, "User c ID {0} был удален%n", new Object[]{id});
//	}
//
//	public User getUser(int id) {
//		return restTemplate.getForObject(URL + "/" + id, User.class);
//	}
}
