/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cofar.beans;

import cofar.entidades.Accionesterapeuticas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sergio German
 */
@Stateless
public class AccionesterapeuticasFacade extends AbstractFacade<Accionesterapeuticas> {

    @PersistenceContext(unitName = "COFARPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccionesterapeuticasFacade() {
        super(Accionesterapeuticas.class);
    }
    
}
