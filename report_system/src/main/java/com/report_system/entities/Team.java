package com.report_system.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany
    private Collection<Employee> members;

    @OneToMany
    private Collection<Report> assignedReports;

    public Team(String name) {
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Employee> getMembers() {
        return this.members;
    }

    public void setMembers(Collection<Employee> members) {
        this.members = members;
    }

    public Collection<Report> getAssignedReports() {
        return this.assignedReports;
    }

    public void setAssignedReports(Collection<Report> assignedReports) {
        this.assignedReports = assignedReports;
    }
}
