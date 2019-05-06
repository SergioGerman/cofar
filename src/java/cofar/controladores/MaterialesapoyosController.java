package cofar.controladores;

import cofar.entidades.Materialesapoyos;
import cofar.controladores.util.JsfUtil;
import cofar.controladores.util.JsfUtil.PersistAction;
import cofar.beans.MaterialesapoyosFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("materialesapoyosController")
@SessionScoped
public class MaterialesapoyosController implements Serializable {

    @EJB
    private cofar.beans.MaterialesapoyosFacade ejbFacade;
    private List<Materialesapoyos> items = null;
    private Materialesapoyos selected;

    public MaterialesapoyosController() {
    }

    public Materialesapoyos getSelected() {
        return selected;
    }

    public void setSelected(Materialesapoyos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private MaterialesapoyosFacade getFacade() {
        return ejbFacade;
    }

    public Materialesapoyos prepareCreate() {
        selected = new Materialesapoyos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MaterialesapoyosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MaterialesapoyosUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MaterialesapoyosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Materialesapoyos> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Materialesapoyos getMaterialesapoyos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Materialesapoyos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Materialesapoyos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Materialesapoyos.class)
    public static class MaterialesapoyosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MaterialesapoyosController controller = (MaterialesapoyosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "materialesapoyosController");
            return controller.getMaterialesapoyos(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Materialesapoyos) {
                Materialesapoyos o = (Materialesapoyos) object;
                return getStringKey(o.getCodMa());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Materialesapoyos.class.getName()});
                return null;
            }
        }

    }

}
