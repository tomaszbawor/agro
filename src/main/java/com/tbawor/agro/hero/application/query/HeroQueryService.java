package com.tbawor.agro.hero.application.query;

import com.tbawor.agro.hero.domain.Hero;
import com.tbawor.agro.hero.domain.HeroRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroQueryService {

    private final HeroRepository repository;

    @Autowired
    public HeroQueryService(HeroRepository repository) {
        this.repository = repository;
    }

    public List<Hero> listAllHeroes() {
        ArrayList<Hero> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }
}
