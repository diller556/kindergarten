package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.repositories.ParentRepo;
import kg.mega.kindergarten.services.ParentService;
import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl implements ParentService {

    public final ParentRepo parentRepo;

    public ParentServiceImpl(ParentRepo parentRepo) {
        this.parentRepo = parentRepo;
    }
}
