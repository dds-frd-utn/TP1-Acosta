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
import utn.frd.acosta.entity.Cuentas;

/**
 *
 * @author Agustin
 */
@Stateless
public class CuentasFacade extends AbstractFacade<Cuentas> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentasFacade() {
        super(Cuentas.class);
    }
    
    // método creado para listar las cuentas asociadas a un cliente
    public List<Cuentas> cuentasPorCliente(int id) {
        return em.createNamedQuery("Cuentas.findByIdCliente").setParameter("idCliente", id).getResultList();
    }
    
}
