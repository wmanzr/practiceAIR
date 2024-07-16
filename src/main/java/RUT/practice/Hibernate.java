package RUT.practice;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import RUT.practice.Entity.Airfly;
import RUT.practice.Entity.Airplane;
import RUT.practice.Entity.BaseEntity;
import RUT.practice.Entity.Flight;
import RUT.practice.Entity.Passenger;
import RUT.practice.Entity.Seats;
import RUT.practice.Entity.Services;
import RUT.practice.Entity.Ticket;

public class Hibernate {
  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      sessionFactory = buildSessionFactory();
    }

    return sessionFactory;
  }

  private static SessionFactory buildSessionFactory() {
    return new Configuration()
      .addAnnotatedClass(Airplane.class)
      .addAnnotatedClass(Flight.class)
      .addAnnotatedClass(Airfly.class)
      .addAnnotatedClass(BaseEntity.class)
      .addAnnotatedClass(Passenger.class)
      .addAnnotatedClass(Seats.class)
      .addAnnotatedClass(Services.class)
      .addAnnotatedClass(Ticket.class)
      .buildSessionFactory();
  }
}