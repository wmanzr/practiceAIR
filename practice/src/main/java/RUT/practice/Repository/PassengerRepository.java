package RUT.practice.Repository;

import RUT.practice.Entity.Passenger;

public interface PassengerRepository {

    public Passenger getById(int passengerId);

}