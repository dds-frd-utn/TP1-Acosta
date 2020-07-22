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
import utn.frd.acosta.entity.Inversiones;
import utn.frd.acosta.sessions.InversionesFacade;

/**
 *
 * @author Agustin
 */
@Path("/inversiones")
public class InversionesRest {
    @EJB
    private InversionesFacade ejbInversionesFacade;

       //obtener todas las inversiones
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Inversiones> findAll(){
        return ejbInversionesFacade.findAll();
    }
    
    //crear inversiones
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Inversiones inversion){
        ejbInversionesFacade.create(inversion);
    }
    
    //actualizar inversiones
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id")long id, Inversiones inversion){
        ejbInversionesFacade.edit(inversion);
    }
    
    //eliminar inversiones
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id")int id){
        ejbInversionesFacade.remove( ejbInversionesFacade.find(id) );
    }
    
    //obtener una inversion por id
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Inversiones findById(@PathParam("id")int id){
        return ejbInversionesFacade.find(id);
    }

    //obtener las inversiones de una cuenta
    @GET
    @Path("/cuenta/{idCuenta}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Inversiones> findByIdCuenta(@PathParam("idCuenta")int id){
        return ejbInversionesFacade.inversionesPorCuenta(id);
    }
    
    //obtener una inversion por id bono
    @GET
    @Path("/bono/{idBono}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Inversiones> findByIdBono(@PathParam("idBono")int id){
        return ejbInversionesFacade.inversionesPorBono(id);
    }
}

