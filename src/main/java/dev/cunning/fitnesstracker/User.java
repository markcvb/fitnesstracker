package dev.cunning.fitnesstracker;

import java.util.Calendar; 

public class User {
	private String email;
	private String username;
	private String password;
	private String name;
	private Calendar dob;
	
	public User(String email, String username, String password, String name, Calendar dob) {
	    this.email = email;
	    this.username = username;
	    this.password = password;
	    this.name = name;
	    this.dob = dob;
	}

    public String getEmail(){
        return email;
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

    
    private void returnDOB() {
        System.out.print(dob);
    }
    
    public static void main(String args[]) 
    { 
        Calendar b = Calendar.getInstance(); 
        b.add(Calendar.DATE, -15); 
        User t = new User("d", "d", "d", "d", b);
        t.returnDOB();
    } 
}	
