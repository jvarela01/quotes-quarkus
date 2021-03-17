package com.jvarela;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.FormParam;

import java.util.List;

@Path("/quotes")
@ApplicationScoped
@Produces("application/json")
public class QuotesResource {
    @Inject
    QuotesRepository quotesRepository;

    @GET
    @Path("/all")
    public List<Quotes> getAll(){
        return quotesRepository.listAll();
    }

    @GET
    @Path("/random")
    public Quotes getRandomQuote()
    {
        Long quotesSize=quotesRepository.count();
        int randomIdQuote=(int)(Math.random()*(quotesSize-1)+1);
        return quotesRepository.findById(randomIdQuote);
    }

    @POST
    @Path("/add")
    @Transactional
    public Response addNewQuote(@FormParam("quote") String quote, @FormParam("author") String author){
        Quotes newQuote=new Quotes();
        newQuote.setQuote(quote);
        newQuote.setAuthor(author);
        quotesRepository.persist(newQuote);
        //return Response.ok(newQuote).status(201).build();
        return Response.ok("Quote Saved").status(201).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
}