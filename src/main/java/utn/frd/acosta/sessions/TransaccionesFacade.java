/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.acosta.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utn.frd.acosta.entity.Transacciones;

/**
 *
 * @author Agustin
 */
@Stateless
public class TransaccionesFacade extends AbstractFacade<Transacciones> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransaccionesFacade() {
        super(Transacciones.class);
    }
    
     // método creado para listar las transacciones emitidas por un cliente
    public List<Transacciones> transaccionesPorEmisor(int id) {
        return em.createNamedQuery("Transacciones.findByIdEmisor").setParameter("idEmisor", id).getResultList();
    }
    
     // método creado para listar las transacciones recibidas por un cliente
    public List<Transacciones> transaccionesPorReceptor(int id) {
        return em.createNamedQuery("Transacciones.findByIdReceptor").setParameter("idReceptor", id).getResultList();
    }
}
