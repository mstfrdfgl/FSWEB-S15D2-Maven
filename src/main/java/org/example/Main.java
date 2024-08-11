package org.example;

import org.example.entity.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Task> annsTasks=new HashSet<>();
        Set<Task> bobsTasks=new HashSet<>();
        Set<Task> carolsTasks=new HashSet<>();
        Set<Task> unassignedTasks=new HashSet<>();

        Task task1=new Task("project1","description1","ann",  Status.ASSIGNED,Priority.HIGH);
        Task task2=new Task("project2","description2","bob",Status.IN_QUEUE,Priority.MED);
        Task task3=new Task("project3","description3","carol",Status.IN_PROGRESS,Priority.LOW);
        Task task4=new Task("project1","description1","ann",Status.IN_PROGRESS,Priority.LOW);

        annsTasks.add(task1);
        bobsTasks.add(task2);
        carolsTasks.add(task3);
        annsTasks.add(task4);
        carolsTasks.add(task2);

        TaskData taskData=new TaskData(annsTasks,bobsTasks,carolsTasks,unassignedTasks);
        System.out.println(taskData.getTasks("ann"));
        System.out.println(taskData.getDuplicateTasks());
        System.out.println(taskData.getUnion(annsTasks,bobsTasks));


    }
}