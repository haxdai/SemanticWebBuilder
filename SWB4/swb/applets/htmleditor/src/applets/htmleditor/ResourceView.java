/*
 * INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet,
 * la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra
 * debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el
 * No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01
 * para la versi�n 3, respectivamente.
 *
 * INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�),
 * en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n;
 * aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n
 * de INFOTEC WebBuilder 3.2.
 *
 * INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita,
 * siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente
 * direcci�n electr�nica:
 *
 *                                          http://www.webbuilder.org.mx
 */


/*
 * ResourceView.java
 *
 * Created on 6 de octubre de 2004, 06:39 PM
 */

package applets.htmleditor;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.*;
import java.net.*;
import java.util.Dictionary;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.event.*;

/**
 *
 * @author Javier Solis Gonzalez
 */
public class ResourceView extends ComponentView implements DocumentListener
{
    
  boolean isSettingAttributes;    
    
  /** indicates whether or not this view is to be shown in its component */
  boolean isVisible = false;    
    
    public ResourceView(Element elem) {
	super(elem);
    }    
    
    public float getMinimumSpan(int axis) {
	if (isVisible) {
	    return super.getMinimumSpan(axis);
	}
	return 0;
    }

    public float getPreferredSpan(int axis) {
	if (isVisible) {
	    return super.getPreferredSpan(axis);
	}
	return 0;
    }

    public float getMaximumSpan(int axis) {
	if (isVisible) {
	    return super.getMaximumSpan(axis);
	}
	return 0;
    }    
    
  /**
   * Establishes the parent view for this view.  This is
   * guaranteed to be called before any other methods if the
   * parent view is functioning properly.  This is also
   * the last method called, since it is called to indicate
   * the view has been removed from the hierarchy as
   * well. When this method is called to set the parent to
   * null, this method does the same for each of its children,
   * propogating the notification that they have been
   * disconnected from the view tree. If this is
   * reimplemented, <code>super.setParent()</code> should
   * be called.
   *
   * @param parent the new parent, or <code>null</code> if the view is
   * 		being removed from a parent
   */
  public void setParent(View parent) {
    if (parent != null) {
      Container host = parent.getContainer();
      if (host != null) {
        isVisible = ((JTextComponent)host).isEditable();
      }
    }
    super.setParent(parent);
  }    
  
  /**
   * Renders using the given rendering surface and area on that
   * surface.  The view may need to do layout and create child
   * views to enable itself to render into the given allocation.
   *
   * @param g the rendering surface to use
   * @param allocation the allocated region to render into
   * @see View#paint
   */
  public void paint(Graphics g, Shape allocation) {
    if (isVisible) {
      super.paint(g,allocation);
      //System.out.println("allocation:"+allocation);
    }
    else {
      setSize(0, 0);
    }
  }  
    
    protected Component createComponent()
    {   
        Element elem=getElement();
        //return new JLabel("Resource");
        JPanel panel=new JPanel();
        panel.setSize(100,100);
        JTextField tf=new JTextField(elem.getName());
        panel.add(tf);
	tf.getDocument().addDocumentListener(this);
        
        panel.setBackground(Color.blue);
        return panel;
    }
    
    /**
     * @return true if the Component is visible.
     */
    public boolean isVisible() {
	return isVisible;
    }    
    
    public void changedUpdate(DocumentEvent e)
    {
        updateModelFromText();        
    }
    
    public void insertUpdate(DocumentEvent e)
    {
        updateModelFromText();        
    }
    
    public void removeUpdate(DocumentEvent e)
    {
        updateModelFromText();        
    }


    
    /**
     * This copies the text from the text component we've created
     * to the Element's AttributeSet we represent.
     * <p>If this is invoked on the event dispatching thread, this
     * directly invokes <code>_updateModelFromText</code>, otherwise
     * <code>SwingUtilities.invokeLater</code> is used to schedule execution
     * of <code>_updateModelFromText</code>.
     */
    void updateModelFromText() {
	if (!isSettingAttributes) {
	    if (SwingUtilities.isEventDispatchThread()) {
		_updateModelFromText();
	    }
	    else {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
			_updateModelFromText();
		    }
		});
	    }
	}
    }

    /**
     * This copies the text from the text component we've created
     * to the Element's AttributeSet we represent.
     */
    void _updateModelFromText() {
	Document doc = getDocument();
	Object name = getElement().getAttributes().getAttribute
	    (StyleConstants.NameAttribute);
	if ((name instanceof HTML.UnknownTag) &&
	    (doc instanceof StyledDocument)) {
	    SimpleAttributeSet sas = new SimpleAttributeSet();
	    JTextComponent textComponent = getTextComponent();
	    if (textComponent != null) {
		String text = textComponent.getText();
		isSettingAttributes = true;
		try {
		    sas.addAttribute(StyleConstants.NameAttribute,
				     new HTML.UnknownTag(text));
		    ((StyledDocument)doc).setCharacterAttributes
			(getStartOffset(), getEndOffset() -
			 getStartOffset(), sas, false);
		}
		finally {
		    isSettingAttributes = false;
		}
	    }
	}
    }
    
    JTextComponent getTextComponent() {
	Component comp = getComponent();

	return (comp == null) ? null : (JTextComponent)((Container)comp).
	                               getComponent(0);
    }    

    
    
}
