package dev.cunning.fitnesstracker;
import java.util.ArrayList;

public class Exercise {
    private ArrayList<String> muscleGroups;
    private String ExRxLink;
    private String type;
    private int difficulty;
 
 
    public Exercise(ArrayList<String> muscleGroups, String ExRxLink, String type, int difficulty) {
        this.muscleGroups = muscleGroups;
        this.ExRxLink = ExRxLink;
        this.type = type;
        this.difficulty = difficulty;
    }

    public ArrayList<String> getMuscleGroup(){
        return muscleGroups;
    }

    public String getExRxLink(){
        return ExRxLink;
    }

    public String getType(){
        return type;
    }

    public int getDifficulty(){
        return difficulty;
    }
 }
 
