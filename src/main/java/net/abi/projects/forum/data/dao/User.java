package net.abi.projects.forum.data.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {
	
	@Id
    String id;
	
	String handle;
	Long numberOfPosts;
	boolean banned;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public Long getNumberOfPosts() {
		return numberOfPosts;
	}
	public void setNumberOfPosts(Long numberOfPosts) {
		this.numberOfPosts = numberOfPosts;
	}
	public boolean isBanned() {
		return banned;
	}
	public void setBanned(boolean banned) {
		this.banned = banned;
	}
	

}
