package RUT.practice.Service;

import RUT.practice.Entity.Passenger;
import RUT.practice.Repository.PassengerRepository;
import RUT.practice.Service.PassengerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PassengerService implements BaseService<Passenger> {

    @Autowired
    private PassengerRepository passengerRepository;
    
    @Override
    public Passenger create(Passenger entity) {
		return passengerRepository.create(entity);
	}

    @Override
	public List<Passenger> getAll() {
		return passengerRepository.getAll();
	}

    @Override
	public Passenger getById(int id) {
		return passengerRepository.getById(id);
	}

    @Override
	public Passenger update(Passenger entity) {
		return passengerRepository.update(entity);
	}
}