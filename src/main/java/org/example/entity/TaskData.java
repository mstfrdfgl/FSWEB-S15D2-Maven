package org.example.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks=new HashSet<>();
    private Set<Task> bobsTasks=new HashSet<>();
    private Set<Task> carolsTasks=new HashSet<>();
    private Set<Task> unassignedTasks=new HashSet<>();

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getUnassignedTasks(){
        return unassignedTasks;
    }

    public Set<Task> getDuplicateTasks(){
        Set<Task> intersect1=getIntersection(annsTasks,bobsTasks);
        Set<Task> intersect2=getIntersection(annsTasks,carolsTasks);
        Set<Task> intersect3=getIntersection(bobsTasks,carolsTasks);

        Set<Task> union=getUnion(intersect1,intersect2);
        return getUnion(union,intersect3);


    }

    public Set<Task> getTasks(String name){
        switch (name) {
            case "ann" -> {
                return annsTasks;
            }
            case "bob" -> {
                return bobsTasks;
            }
            case "carol" -> {
                return carolsTasks;
            }
            case "all" -> {
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                return allTasks;
            }
        }
        return new HashSet<>();
    }

    public Set<Task> getUnion(Set<Task> set1,Set<Task> set2){
        Set<Task> result=new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
    public Set<Task> getIntersection(Set<Task> set1,Set<Task> set2){
        Set<Task> result=new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }
    public Set<Task> getDifferences(Set<Task> set1,Set<Task> set2){
        Set<Task> result=new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }

}
