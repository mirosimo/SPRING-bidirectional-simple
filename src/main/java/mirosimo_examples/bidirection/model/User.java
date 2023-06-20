package mirosimo_examples.bidirection.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "users")
@Entity
public class User {	
	
	@Id
	@SequenceGenerator(
			name = "user_sequence",
			sequenceName = "user_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_sequence"
	)
	public int id;
	public String name;

	@JsonManagedReference
	@OneToMany(mappedBy = "owner", 
	fetch = FetchType.LAZY, 
	cascade = CascadeType.ALL)
	public List<Item> userItems;

	    public User() {
	        super();
	    }	    	    
	    
	    public User(final int id, final String name) {
	        this.id = id;
	        this.name = name;
	        userItems = new ArrayList<>();
	    }
	    
	    

	    public void addItem(final Item item) {
	        userItems.add(item);
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

		public List<Item> getUserItems() {
			return userItems;
		}

		public void setUserItems(List<Item> userItems) {
			this.userItems = userItems;
		}
}
