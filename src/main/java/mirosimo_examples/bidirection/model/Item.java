package mirosimo_examples.bidirection.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Table
@Entity
public class Item {
	
	@Id
	@SequenceGenerator(
			name = "item_sequence",
			sequenceName = "item_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "item_sequence"
	)
    public int id;
    public String itemName;
    
    @ManyToOne(
			fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    public User owner;

    public Item() {
        super();
    }

    public Item(final int id, final String itemName) {
        this.id = id;
        this.itemName = itemName;
    }
    
    public Item(final int id, final String itemName, final User owner) {
        this.id = id;
        this.itemName = itemName;
        this.owner = owner;
    }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
}
