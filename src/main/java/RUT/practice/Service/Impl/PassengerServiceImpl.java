package RUT.practice.Service.Impl;

import RUT.practice.Entity.Passenger;
import RUT.practice.Repository.PassengerRepository;
import RUT.practice.Service.PassengerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public Passenger findPassengerById(int id) {
        return passengerRepository.findPassengerById(id);
    }

    @Override
    public List<Passenger> findAllByFisrtnameAndLastname(String firstName, String lastName) {
        return passengerRepository.findAllByFisrtnameAndLastname(firstName, lastName);
    }

    @Override
    @Transactional
    public void ProvidingServicesSpecial(int passengerId) {
        passengerRepository.ProvidingServicesSpecial(passengerId);
    }

    @Override
    @Transactional
    public void ProvidingServicesFood(int passengerId) {
        passengerRepository.ProvidingServicesFood(passengerId);
    }
}