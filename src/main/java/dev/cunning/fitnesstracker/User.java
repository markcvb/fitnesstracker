package dev.cunning.fitnesstracker;

import java.util.Calendar; 

public class User {
	//private String email;
	private int uuid;
    private String username;
	private String password;
	private String name;
    private boolean age;
	
	public User(int uuid, String username, String password, String name, boolean age) {
	    //this.email = email;
        this.uuid = uuid;
	    this.username = username;
	    this.password = password;
	    this.name = name;
        this.age = age;
	}

    //public String getEmail(){
    //    return email;
    //}
    public int getUuid(){
        return uuid;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public boolean getAge(){
        return age;
    }
}	
