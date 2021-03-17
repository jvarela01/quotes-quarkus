package com.jvarela;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class QuotesRepository implements PanacheRepository<Quotes>{
    
    public Quotes findById(int id){
        return find("id",id).firstResult();
    }
}
