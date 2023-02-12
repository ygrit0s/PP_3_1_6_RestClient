package habsida.ygrit0s.RestClient.entity;

public class User {
	private int id;

	private String name;

	private String lastName;

	private Byte age;

	public User() {
	}

	public User(int id, String name, String lastName, Byte age) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Byte getAge() {
		return age;
	}
	
	public void setAge(Byte age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return  """
                
                User  [ ID =        %s,
                        Name =      %s,
                        LastName =  %s,
                        Age =       %s,
                """
				.formatted(id, name, lastName, age);
	}
}
