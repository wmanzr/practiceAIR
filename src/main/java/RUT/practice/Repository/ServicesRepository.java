package RUT.practice.Repository;

import RUT.practice.Entity.Services;
import org.springframework.stereotype.Repository;


@Repository
public class ServicesRepository extends BaseRepository<Services> {
    
    public ServicesRepository() {
        super(Services.class);
    }
}
