package dev.cunning.fitnesstracker;

import java.util.ArrayList;

public class Workout {
    private ArrayList<Exercise> sequence;
    private ArrayList<Integer> reps;
    private ArrayList<Integer> sets;


    public Workout(ArrayList<Exercise> sequence, ArrayList<Integer> reps, ArrayList<Integer> sets) {
        this.sequence = sequence;
        this.reps = reps;
        this.sets = sets;
    }
 
 
    public void removeExercise(int index) {
        sequence.remove(index);
        reps.remove(index);
        sets.remove(index);
    }
 
 
    public void addExercise(int index, Exercise e, int rep, int set){
        sequence.add(index, e);
        reps.add(index, rep);
        sets.add(index, set);
    }
 
 
 //  make sure that if the user doesnt change one or more of these that our gui will just send the already
 //  existing exercise, rep, or set to be used in this method (because leaving it blank would break the code)
    public void modifyExcercise(int index, Exercise e, int rep, int set){
        sequence.set(index, e);
        reps.set(index, rep);
        sets.set(index, set);
    }
 }
 
