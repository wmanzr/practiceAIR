package RUT.practice.Repository.Impl;

import RUT.practice.Entity.Services;
import RUT.practice.Repository.BaseRepository;
import RUT.practice.Repository.ServicesRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ServicesRepositoryImpl extends BaseRepository<Services, Integer> implements ServicesRepository{
    
    public ServicesRepositoryImpl() {
        super(Services.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Services services) {
        super.create(services);
    }

}