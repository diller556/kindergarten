package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.repositories.AgeGroupRepo;
import kg.mega.kindergarten.services.AgeGroupService;
import org.springframework.stereotype.Service;

@Service
public class AgeGroupServiceImpl implements AgeGroupService {

    public final AgeGroupRepo ageGroupRepo;

    public AgeGroupServiceImpl(AgeGroupRepo ageGroupRepo) {
        this.ageGroupRepo = ageGroupRepo;
    }

}
