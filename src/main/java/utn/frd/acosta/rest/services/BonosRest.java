/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.acosta.rest.services;
import javax.ws.rs.Path;
import javax.ejb.EJB;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utn.frd.acosta.entity.Bonos;
import utn.frd.acosta.sessions.BonosFacade;

/**
 *
 * @author Agustin
 */
@Path("/bonos")
public class BonosRest {
    @EJB
    private BonosFacade ejbBonosFacade;

       //obtener todos los bonos
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Bonos> findAll(){
        return ejbBonosFacade.findAll();
    }
    
    //crear bonos
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Bonos bono){
        ejbBonosFacade.create(bono);
    }
    
    //actualizar bonos
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id")long id, Bonos bono){
        ejbBonosFacade.edit(bono);
    }
    
    //eliminar bonos
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id")int id){
        ejbBonosFacade.remove( ejbBonosFacade.find(id) );
    }
    
    //obtener un bono por id
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Bonos findById(@PathParam("id")int id){
        return ejbBonosFacade.find(id);
    }
    
    //obtener un bono por el nombre
    //@GET
    //@Path("/nombre")
    //@Produces({MediaType.APPLICATION_JSON})
    //public Bonos findByNombre(@PathParam("nombre")int nombre){
    //    return ejbBonosFacade.find(nombre);
    //}
}
