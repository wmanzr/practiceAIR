package RUT.practice.Service;

import RUT.practice.Entity.Passenger;

import java.util.List;

public interface PassengerService {

    Passenger findPassengerById(int id);

    List<Passenger> findAllByFisrtnameAndLastname(String firstName, String lastName);

    void ProvidingServicesSpecial(int passengerId);

    void ProvidingServicesFood(int passengerId);
}

