package com.report_system.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String address;
    private String description;
    private Date published;
    private ReportStatus status;
    @ManyToOne
    private Team assignedTeam;
    @ManyToOne
    private Client client;

    public Report(String address, String description, Client client) {
        this.setAddress(address);
        this.setDescription(description);
        this.setClient(client);
        this.setPublished(new Date());
        this.setStatus(ReportStatus.OPEN);
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getPublished() {
        return this.published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public ReportStatus getStatus() {
        return this.status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public Team getAssignedTeam() {
        return this.assignedTeam;
    }

    public void setAssignedTeam(Team assignedTeam) {
        this.assignedTeam = assignedTeam;
    }
}
