package com.redhat.faces.renderkit;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.sun.faces.renderkit.RenderKitUtils;
import com.sun.faces.renderkit.html_basic.TextRenderer;

public class FileRenderer extends TextRenderer {

    public FileRenderer() {

    }

    public void decode(FacesContext context, UIComponent component) {

        this.rendererParamsNotNull(context, component);
        if (this.shouldDecode(component)) {
            String clientId = this.decodeBehaviors(context, component);
            if (clientId == null) {
                clientId = component.getClientId(context);
            }

            assert clientId != null;

            ExternalContext externalContext = context.getExternalContext();
            Map<String, String> requestMap = externalContext.getRequestParameterMap();
            if (requestMap.containsKey(clientId)) {
                this.setSubmittedValue(component, requestMap.get(clientId));
            }

            HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

            try {
                Collection<Part> parts = request.getParts();
                Iterator i$ = parts.iterator();

                while (i$.hasNext()) {
                    Part cur = (Part) i$.next();
                    if (clientId.equals(cur.getName())) {
                        this.setSubmittedValue(component, cur);
                    }
                }
            } catch (IOException var10) {
                IOException ioe = var10;
                throw new FacesException(ioe);
            } catch (ServletException var11) {
                ServletException se = var11;
                throw new FacesException(se);
            }
        }
    }

    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {

        boolean produceMessage = false;
        UIForm form = RenderKitUtils.getForm(component, context);
        if (null != form) {
            String encType = (String) form.getAttributes().get("enctype");
            if (null == encType || !encType.equals("multipart/form-data")) {
                produceMessage = true;
            }
        } else {
            produceMessage = true;
        }

        if (produceMessage) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "File upload component requires a form with an enctype of multipart/form-data", "File upload component requires a form with an enctype of multipart/form-data");
            context.addMessage(component.getClientId(context), message);
        }

        super.encodeBegin(context, component);
    }

    public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {

        if (submittedValue instanceof Part) {
            Part part = (Part) submittedValue;
            if ((part.getHeader("content-disposition") == null || part.getHeader("content-disposition").endsWith("filename=\"\"")) && part.getSize() <= 0L) {
                return null;
            }
        }

        return submittedValue;
    }

}
