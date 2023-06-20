package mirosimo_examples.bidirection.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table
@Entity
public class MenuItem {
	@Id
	@SequenceGenerator(
			name = "menu_item_sequence",
			sequenceName = "menu_item_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "menu_item_sequence"
	)
	public int id;
	public String name;
	
    @ManyToOne(
			fetch=FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    @JsonBackReference
	public MenuItem parentItem;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "parentItem", 
	fetch = FetchType.LAZY, 
	cascade = CascadeType.ALL)
	public List<MenuItem> nestedItems;

	public MenuItem() { super(); }
	
    public MenuItem(final int id, final String name, final MenuItem menuItem) {
        this.id = id;
        this.name = name;
        this.parentItem = menuItem;
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

	public MenuItem getParentItem() {
		return parentItem;
	}
	public void setParentItem(MenuItem parentItem) {
		this.parentItem = parentItem;
	}

	public List<MenuItem> getNestedItems() {
		return nestedItems;
	}
	public void setNestedItems(List<MenuItem> nestedItems) {
		this.nestedItems = nestedItems;
	}
}
