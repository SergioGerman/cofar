package cofar.controladores;

import cofar.entidades.SalidasDetalle;
import cofar.controladores.util.JsfUtil;
import cofar.controladores.util.JsfUtil.PersistAction;
import cofar.beans.SalidasDetalleFacade;

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

@Named("salidasDetalleController")
@SessionScoped
public class SalidasDetalleController implements Serializable {

    @EJB
    private cofar.beans.SalidasDetalleFacade ejbFacade;
    private List<SalidasDetalle> items = null;
    private SalidasDetalle selected;

    public SalidasDetalleController() {
    }

    public SalidasDetalle getSelected() {
        return selected;
    }

    public void setSelected(SalidasDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SalidasDetalleFacade getFacade() {
        return ejbFacade;
    }

    public SalidasDetalle prepareCreate() {
        selected = new SalidasDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SalidasDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SalidasDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SalidasDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SalidasDetalle> getItems() {
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

    public SalidasDetalle getSalidasDetalle(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<SalidasDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SalidasDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SalidasDetalle.class)
    public static class SalidasDetalleControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SalidasDetalleController controller = (SalidasDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "salidasDetalleController");
            return controller.getSalidasDetalle(getKey(value));
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
            if (object instanceof SalidasDetalle) {
                SalidasDetalle o = (SalidasDetalle) object;
                return getStringKey(o.getCodSd());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SalidasDetalle.class.getName()});
                return null;
            }
        }

    }

}
