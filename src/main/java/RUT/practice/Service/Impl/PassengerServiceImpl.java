package RUT.practice.Service.Impl;

import RUT.practice.Entity.Passenger;
import RUT.practice.Repository.PassengerRepository;
import RUT.practice.Service.PassengerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public Passenger findPassengerById(int id) {
        Optional<Passenger> optionalPassenger = passengerRepository.findById(id);
        return optionalPassenger.orElse(null);
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

    @Override
    public List<Passenger> findAllPassenger() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger updatePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public void deletePassengerById(int id) {
        passengerRepository.deleteById(id);
    }
}