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
import utn.frd.acosta.entity.Transacciones;
import utn.frd.acosta.sessions.TransaccionesFacade;

/**
 *
 * @author Agustin
 */
@Path("/transaccion")
public class TransaccionesRest {
    @EJB
    private TransaccionesFacade ejbTransaccionesFacade;

    //obtener todas las transacciones
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transacciones> findAll(){
        return ejbTransaccionesFacade.findAll();
    }
    
    //crear transacciones
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Transacciones transaccion){
        ejbTransaccionesFacade.create(transaccion);
    }
    
    //actualizar transacciones
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id")long id, Transacciones transaccion){
        ejbTransaccionesFacade.edit(transaccion);
    }
    
    //eliminar transacciones
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id")int id){
        ejbTransaccionesFacade.remove( ejbTransaccionesFacade.find(id) );
    }
    
    //obtener una transaccion por id
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Transacciones findById(@PathParam("id")int id){
        return ejbTransaccionesFacade.find(id);
    }
    
    //obtener una transaccion por id emisor
    @GET
    @Path("/emisor/{idEmisor}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transacciones> findByIdEmisor(@PathParam("idEmisor")int id){
        return ejbTransaccionesFacade.transaccionesPorEmisor(id);
    }
    
    //obtener una transaccion por id receptor
    @GET
    @Path("/receptor/{idReceptor}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transacciones> findByIdReceptor(@PathParam("idReceptor")int id){
        return ejbTransaccionesFacade.transaccionesPorReceptor(id);
    }
    
}
