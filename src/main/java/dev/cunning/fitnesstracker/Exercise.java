package dev.cunning.fitnesstracker;
import java.util.ArrayList;

public class Exercise {
    private String name;
    private String type;
    private String sets;
    private String reps;
    private boolean complete;

    public Exercise(String name, String type, String sets, String reps){
        this.name = name;
        this.type = type;
        this.sets = sets;
        this.reps = reps;
        complete = false;
    }

    public String getName(){ return name;}
    public String getType(){ return type;}
    public String getSets(){return sets;}
    public String getReps(){return reps;}
    public boolean getComplete(){return complete;}

    public void changeName(String newName){
        name = newName;
    }
    public void changeType(String newType){
        type = newType;
    }
    public void changeSets(String newSets){
        sets = newSets;
    }
    public void changeReps(String newReps){
        reps = newReps;
    }
    public void changeComplete(boolean newComplete){
        complete = newComplete;
    }




 }
 
