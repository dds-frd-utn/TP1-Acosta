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
import utn.frd.acosta.entity.Cuentas;
import utn.frd.acosta.sessions.CuentasFacade;

/**
 *
 * @author Agustin
 */
@Path("/cuenta")
public class CuentasRest {
    @EJB
    private CuentasFacade ejbCuentasFacade;

    //obtener todas las cuentas
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cuentas> findAll(){
        return ejbCuentasFacade.findAll();
    }
    
    //crear cuentas
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Cuentas cuenta){
        ejbCuentasFacade.create(cuenta);
    }
    
    //actualizar cuentas
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public void edit(@PathParam("id")int id, Cuentas cuenta){
        ejbCuentasFacade.edit(cuenta);
    }
    
    //eliminar cuentas
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public void remove(@PathParam("id")int id){
        ejbCuentasFacade.remove( ejbCuentasFacade.find(id) );
    }
    
    //obtener una cuenta por id
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Cuentas findById(@PathParam("id")int id){
        return ejbCuentasFacade.find(id);
    }

    //obtener una cuenta por id cliente
    @GET
    @Path("/titular/{idCliente}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cuentas> findByIdCliente(@PathParam("idCliente")int id){
        return ejbCuentasFacade.cuentasPorCliente(id);
    }
}
