package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.text.SimpleDateFormat;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;

        try 
        {
            factory = new Configuration().configure().buildSessionFactory();
            session = factory.openSession();

            // I. Insert records using persistent object
            tx = session.beginTransaction();

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            Shipment s1 = new Shipment(
                    "Electronics Parcel",
                    sdf.parse("10-03-2026"),
                    "Dispatched",
                    "Hyderabad",
                    "Vijayawada",
                    15.5,
                    1200.00
            );

            Shipment s2 = new Shipment(
                    "Furniture Package",
                    sdf.parse("11-03-2026"),
                    "In Transit",
                    "Chennai",
                    "Bangalore",
                    45.0,
                    3500.00
            );

            Shipment s3 = new Shipment(
                    "Medical Supplies",
                    sdf.parse("12-03-2026"),
                    "Pending",
                    "Mumbai",
                    "Pune",
                    20.0,
                    2000.00
            );

            session.persist(s1);
            session.persist(s2);
            session.persist(s3);

            tx.commit();
            System.out.println("Shipment records inserted successfully");

            // II. Delete the record based on ID using HQL with named parameter
            tx = session.beginTransaction();

            int deleteId = 2; // change this ID as needed

            String hql = "delete from Shipment s where s.id = :sid";
            Query<?> query = session.createQuery(hql);
            query.setParameter("sid", deleteId);

            int result = query.executeUpdate();

            tx.commit();

            if (result > 0)
                System.out.println("Shipment record deleted successfully for ID = " + deleteId);
            else
                System.out.println("No Shipment record found with ID = " + deleteId);
        } 
        catch (Exception e) 
        {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } 
        finally 
        {
            if (session != null)
                session.close();
            if (factory != null)
                factory.close();
        }
    }
}