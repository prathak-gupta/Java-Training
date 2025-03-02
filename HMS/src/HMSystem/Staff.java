package HMSystem;

public class Staff {
	private int id;
	private String name, role, contact;
	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", role=" + role + ", contact=" + contact + "]";
	}

	public Staff()
	{}
	
	public Staff(int id, String name, String role, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.contact = contact;
	}
	
	public Staff(String name, String role, String contact) {
		this.name = name;
		this.role = role;
		this.contact = contact;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
