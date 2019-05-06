/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofar.beans;

import cofar.entidades.Ingresos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sergio German
 */
@Stateless
public class IngresosFacade extends AbstractFacade<Ingresos> {

    @PersistenceContext(unitName = "COFARPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresosFacade() {
        super(Ingresos.class);
    }
    
}
