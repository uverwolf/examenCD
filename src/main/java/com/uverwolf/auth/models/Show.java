package com.uverwolf.auth.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@Table(name="shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Size(min=3)
	@Pattern(regexp="[a-zA-Z][a-zA-Z ]*",message = "Solo letras para el nombre")
	private String name;
	private Integer average;

	@Size(min=3)
	
	@Pattern(regexp="^[a-zA-Z]+$",message = "Solo letras para el cadena")
	private String network;
	   @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "shows_users", 
	        joinColumns = @JoinColumn(name = "show_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )  
	   private List<User> users;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    public Show() {
    	
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public List<User> getUsers() {
		return users;
	}
 
	public Integer getAverage() {
		return average;
	}
	public void setAverage(Integer average) {
		this.average = average;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
