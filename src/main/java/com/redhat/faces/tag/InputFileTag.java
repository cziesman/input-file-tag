package com.redhat.faces.tag;

import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.MethodExpressionValueChangeListener;
import javax.faces.validator.MethodExpressionValidator;
import javax.faces.webapp.UIComponentELTag;
import javax.servlet.jsp.JspException;

public class InputFileTag extends UIComponentELTag {

    private ValueExpression converter;

    private ValueExpression converterMessage;

    private ValueExpression immediate;

    private ValueExpression required;

    private ValueExpression requiredMessage;

    private MethodExpression validator;

    private ValueExpression validatorMessage;

    private ValueExpression value;

    private MethodExpression valueChangeListener;

    private ValueExpression accesskey;

    private ValueExpression alt;

    private ValueExpression autocomplete;

    private ValueExpression dir;

    private ValueExpression disabled;

    private ValueExpression label;

    private ValueExpression lang;

    private ValueExpression maxlength;

    private ValueExpression onblur;

    private ValueExpression onchange;

    private ValueExpression onclick;

    private ValueExpression ondblclick;

    private ValueExpression onfocus;

    private ValueExpression onkeydown;

    private ValueExpression onkeypress;

    private ValueExpression onkeyup;

    private ValueExpression onmousedown;

    private ValueExpression onmousemove;

    private ValueExpression onmouseout;

    private ValueExpression onmouseover;

    private ValueExpression onmouseup;

    private ValueExpression onselect;

    private ValueExpression readonly;

    private ValueExpression role;

    private ValueExpression size;

    private ValueExpression style;

    private ValueExpression styleClass;

    private ValueExpression tabindex;

    private ValueExpression title;

    public InputFileTag() {

    }

    public void setConverter(ValueExpression expression) {

        this.converter = expression;
    }

    public void setConverterMessage(ValueExpression expression) {

        this.converterMessage = expression;
    }

    public void setImmediate(ValueExpression expression) {

        this.immediate = expression;
    }

    public void setRequired(ValueExpression expression) {

        this.required = expression;
    }

    public void setRequiredMessage(ValueExpression expression) {

        this.requiredMessage = expression;
    }

    public void setValidator(MethodExpression expression) {

        this.validator = expression;
    }

    public void setValidatorMessage(ValueExpression expression) {

        this.validatorMessage = expression;
    }

    public void setValue(ValueExpression expression) {

        this.value = expression;
    }

    public void setValueChangeListener(MethodExpression expression) {

        this.valueChangeListener = expression;
    }

    public void setAccesskey(ValueExpression expression) {

        this.accesskey = expression;
    }

    public void setAlt(ValueExpression expression) {

        this.alt = expression;
    }

    public void setAutocomplete(ValueExpression expression) {

        this.autocomplete = expression;
    }

    public void setDir(ValueExpression expression) {

        this.dir = expression;
    }

    public void setDisabled(ValueExpression expression) {

        this.disabled = expression;
    }

    public void setLabel(ValueExpression expression) {

        this.label = expression;
    }

    public void setLang(ValueExpression expression) {

        this.lang = expression;
    }

    public void setMaxlength(ValueExpression expression) {

        this.maxlength = expression;
    }

    public void setOnblur(ValueExpression expression) {

        this.onblur = expression;
    }

    public void setOnchange(ValueExpression expression) {

        this.onchange = expression;
    }

    public void setOnclick(ValueExpression expression) {

        this.onclick = expression;
    }

    public void setOndblclick(ValueExpression expression) {

        this.ondblclick = expression;
    }

    public void setOnfocus(ValueExpression expression) {

        this.onfocus = expression;
    }

    public void setOnkeydown(ValueExpression expression) {

        this.onkeydown = expression;
    }

    public void setOnkeypress(ValueExpression expression) {

        this.onkeypress = expression;
    }

    public void setOnkeyup(ValueExpression expression) {

        this.onkeyup = expression;
    }

    public void setOnmousedown(ValueExpression expression) {

        this.onmousedown = expression;
    }

    public void setOnmousemove(ValueExpression expression) {

        this.onmousemove = expression;
    }

    public void setOnmouseout(ValueExpression expression) {

        this.onmouseout = expression;
    }

    public void setOnmouseover(ValueExpression expression) {

        this.onmouseover = expression;
    }

    public void setOnmouseup(ValueExpression expression) {

        this.onmouseup = expression;
    }

    public void setOnselect(ValueExpression expression) {

        this.onselect = expression;
    }

    public void setReadonly(ValueExpression expression) {

        this.readonly = expression;
    }

    public void setRole(ValueExpression expression) {

        this.role = expression;
    }

    public void setSize(ValueExpression expression) {

        this.size = expression;
    }

    public void setStyle(ValueExpression expression) {

        this.style = expression;
    }

    public void setStyleClass(ValueExpression expression) {

        this.styleClass = expression;
    }

    public void setTabindex(ValueExpression expression) {

        this.tabindex = expression;
    }

    public void setTitle(ValueExpression expression) {

        this.title = expression;
    }

    public String getRendererType() {

        return "javax.faces.File";
    }

    public String getComponentType() {

        return "javax.faces.HtmlInputFile";
    }

    protected void setProperties(UIComponent uiComponent) {

        super.setProperties(uiComponent);
        UIInput var2 = null;

        try {
            var2 = (UIInput) uiComponent;
        } catch (ClassCastException var4) {
            throw new IllegalStateException("Component " + uiComponent.toString() + " not expected type.  Expected: javax.faces.component.UIInput.  Perhaps you're missing a tag?");
        }

        if (this.converter != null) {
            if (!this.converter.isLiteralText()) {
                var2.setValueExpression("converter", this.converter);
            } else {
                Converter var3 = FacesContext.getCurrentInstance().getApplication().createConverter(this.converter.getExpressionString());
                var2.setConverter(var3);
            }
        }

        if (this.converterMessage != null) {
            var2.setValueExpression("converterMessage", this.converterMessage);
        }

        if (this.immediate != null) {
            var2.setValueExpression("immediate", this.immediate);
        }

        if (this.required != null) {
            var2.setValueExpression("required", this.required);
        }

        if (this.requiredMessage != null) {
            var2.setValueExpression("requiredMessage", this.requiredMessage);
        }

        if (this.validator != null) {
            var2.addValidator(new MethodExpressionValidator(this.validator));
        }

        if (this.validatorMessage != null) {
            var2.setValueExpression("validatorMessage", this.validatorMessage);
        }

        if (this.value != null) {
            var2.setValueExpression("value", this.value);
        }

        if (this.valueChangeListener != null) {
            var2.addValueChangeListener(new MethodExpressionValueChangeListener(this.valueChangeListener));
        }

        if (this.accesskey != null) {
            var2.setValueExpression("accesskey", this.accesskey);
        }

        if (this.alt != null) {
            var2.setValueExpression("alt", this.alt);
        }

        if (this.autocomplete != null) {
            var2.setValueExpression("autocomplete", this.autocomplete);
        }

        if (this.dir != null) {
            var2.setValueExpression("dir", this.dir);
        }

        if (this.disabled != null) {
            var2.setValueExpression("disabled", this.disabled);
        }

        if (this.label != null) {
            var2.setValueExpression("label", this.label);
        }

        if (this.lang != null) {
            var2.setValueExpression("lang", this.lang);
        }

        if (this.maxlength != null) {
            var2.setValueExpression("maxlength", this.maxlength);
        }

        if (this.onblur != null) {
            var2.setValueExpression("onblur", this.onblur);
        }

        if (this.onchange != null) {
            var2.setValueExpression("onchange", this.onchange);
        }

        if (this.onclick != null) {
            var2.setValueExpression("onclick", this.onclick);
        }

        if (this.ondblclick != null) {
            var2.setValueExpression("ondblclick", this.ondblclick);
        }

        if (this.onfocus != null) {
            var2.setValueExpression("onfocus", this.onfocus);
        }

        if (this.onkeydown != null) {
            var2.setValueExpression("onkeydown", this.onkeydown);
        }

        if (this.onkeypress != null) {
            var2.setValueExpression("onkeypress", this.onkeypress);
        }

        if (this.onkeyup != null) {
            var2.setValueExpression("onkeyup", this.onkeyup);
        }

        if (this.onmousedown != null) {
            var2.setValueExpression("onmousedown", this.onmousedown);
        }

        if (this.onmousemove != null) {
            var2.setValueExpression("onmousemove", this.onmousemove);
        }

        if (this.onmouseout != null) {
            var2.setValueExpression("onmouseout", this.onmouseout);
        }

        if (this.onmouseover != null) {
            var2.setValueExpression("onmouseover", this.onmouseover);
        }

        if (this.onmouseup != null) {
            var2.setValueExpression("onmouseup", this.onmouseup);
        }

        if (this.onselect != null) {
            var2.setValueExpression("onselect", this.onselect);
        }

        if (this.readonly != null) {
            var2.setValueExpression("readonly", this.readonly);
        }

        if (this.role != null) {
            var2.setValueExpression("role", this.role);
        }

        if (this.size != null) {
            var2.setValueExpression("size", this.size);
        }

        if (this.style != null) {
            var2.setValueExpression("style", this.style);
        }

        if (this.styleClass != null) {
            var2.setValueExpression("styleClass", this.styleClass);
        }

        if (this.tabindex != null) {
            var2.setValueExpression("tabindex", this.tabindex);
        }

        if (this.title != null) {
            var2.setValueExpression("title", this.title);
        }
    }

    public int doStartTag() throws JspException {

        try {
            return super.doStartTag();
        } catch (Exception var3) {
            Object var2;
            for (var2 = var3; ((Throwable) var2).getCause() != null; var2 = ((Throwable) var2).getCause()) {
            }

            throw new JspException((Throwable) var2);
        }
    }

    public int doEndTag() throws JspException {

        try {
            return super.doEndTag();
        } catch (Exception var3) {
            Object var2;
            for (var2 = var3; ((Throwable) var2).getCause() != null; var2 = ((Throwable) var2).getCause()) {
            }

            throw new JspException((Throwable) var2);
        }
    }

    public void release() {

        super.release();
        this.converter = null;
        this.converterMessage = null;
        this.immediate = null;
        this.required = null;
        this.requiredMessage = null;
        this.validator = null;
        this.validatorMessage = null;
        this.value = null;
        this.valueChangeListener = null;
        this.accesskey = null;
        this.alt = null;
        this.autocomplete = null;
        this.dir = null;
        this.disabled = null;
        this.label = null;
        this.lang = null;
        this.maxlength = null;
        this.onblur = null;
        this.onchange = null;
        this.onclick = null;
        this.ondblclick = null;
        this.onfocus = null;
        this.onkeydown = null;
        this.onkeypress = null;
        this.onkeyup = null;
        this.onmousedown = null;
        this.onmousemove = null;
        this.onmouseout = null;
        this.onmouseover = null;
        this.onmouseup = null;
        this.onselect = null;
        this.readonly = null;
        this.role = null;
        this.size = null;
        this.style = null;
        this.styleClass = null;
        this.tabindex = null;
        this.title = null;
    }

    public String getDebugString() {

        return "id: " + this.getId() + " class: " + this.getClass().getName();
    }

}
