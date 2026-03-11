package com.klef.fsad.exam;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shipment")
public class Shipment 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipment_id")
    private int id;

    @Column(name = "shipment_name", nullable = false, length = 100)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "shipment_date")
    private Date date;

    @Column(name = "shipment_status", length = 50)
    private String status;

    @Column(name = "source_location", length = 100)
    private String source;

    @Column(name = "destination_location", length = 100)
    private String destination;

    @Column(name = "weight")
    private double weight;

    @Column(name = "cost")
    private double cost;

    public Shipment() 
    {
    }

    public Shipment(String name, Date date, String status, String source, String destination, double weight, double cost) 
    {
        this.name = name;
        this.date = date;
        this.status = status;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.cost = cost;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public Date getDate() 
    {
        return date;
    }

    public void setDate(Date date) 
    {
        this.date = date;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getSource() 
    {
        return source;
    }

    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getDestination() 
    {
        return destination;
    }

    public void setDestination(String destination) 
    {
        this.destination = destination;
    }

    public double getWeight() 
    {
        return weight;
    }

    public void setWeight(double weight) 
    {
        this.weight = weight;
    }

    public double getCost() 
    {
        return cost;
    }

    public void setCost(double cost) 
    {
        this.cost = cost;
    }

    @Override
    public String toString() 
    {
        return "Shipment [id=" + id + ", name=" + name + ", date=" + date + ", status=" + status +
                ", source=" + source + ", destination=" + destination + ", weight=" + weight + ", cost=" + cost + "]";
    }
}