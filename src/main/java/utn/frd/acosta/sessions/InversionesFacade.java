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
import utn.frd.acosta.entity.Inversiones;

/**
 *
 * @author Agustin
 */
@Stateless
public class InversionesFacade extends AbstractFacade<Inversiones> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InversionesFacade() {
        super(Inversiones.class);
    }
    
    // método creado para listar las inversiones de una determinada cuenta
    public List<Inversiones> inversionesPorCuenta(int id) {
        return em.createNamedQuery("Inversiones.findByIdCuenta").setParameter("idCuenta", id).getResultList();
    }
    
    // método creado para listar las inversiones de un determinado bono
    public List<Inversiones> inversionesPorBono(int id) {
        return em.createNamedQuery("Inversiones.findByIdBono").setParameter("idBono", id).getResultList();
    }
}
