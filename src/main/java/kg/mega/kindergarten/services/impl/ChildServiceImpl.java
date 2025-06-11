package kg.mega.kindergarten.services.impl;

import kg.mega.kindergarten.repositories.ChildRepo;
import kg.mega.kindergarten.services.ChildService;
import org.springframework.stereotype.Service;

@Service
public class ChildServiceImpl implements ChildService {

    public final ChildRepo childRepo;

    public ChildServiceImpl(ChildRepo childRepo) {
        this.childRepo = childRepo;
    }
}
