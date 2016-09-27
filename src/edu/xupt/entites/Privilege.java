package edu.xupt.entites;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_privilege")
public class Privilege implements Serializable{

	private int id;
	private String name;
	private String url;

	private Privilege parent;
	private Set<Privilege> children = new HashSet<Privilege>();
	private Set<Role> roles = new HashSet<Role>();
	
	
	public Privilege() {
		super();
	}

	public Privilege(String name, String url, Privilege parent) {
		super();
		this.name = name;
		this.url = url;
		this.parent = parent;
	}
	
	
	
	@Id
	@GeneratedValue
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@ManyToOne
	public Privilege getParent() {
		return parent;
	}

	public void setParent(Privilege parent) {
		this.parent = parent;
	}

	@OneToMany(mappedBy = "parent", fetch=FetchType.EAGER)
	public Set<Privilege> getChildren() {
		return children;
	}

	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}

	

	@ManyToMany(mappedBy="privileges")
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
