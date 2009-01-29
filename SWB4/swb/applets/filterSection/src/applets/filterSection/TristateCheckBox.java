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
 * TristateCheckBox.java
 *
 * Created on 10 de enero de 2005, 11:31 AM
 */

package applets.filterSection;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.ActionMapUIResource;
import java.awt.event.*;
/**
 * Clase que representa un checkbox con tres estados.
 * @author Victor Lorenzana
 */
public class TristateCheckBox extends JCheckBox {
  /** This is a type-safe enumerated type */
  public static class State { private State() { } }
  public static final State NOT_SELECTED = new State();
  public static final State SELECTED = new State();
  public static final State DONT_CARE = new State();

  private final TristateDecorator model;

  public TristateCheckBox(String text, Icon icon, State initial){
    super(text, icon);
    // Add a listener for when the mouse is pressed
    super.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        grabFocus();
        model.nextState();
      }
    });
    // Reset the keyboard action map
    ActionMap map = new ActionMapUIResource();
    map.put("pressed", new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        grabFocus();
        model.nextState();
      }
    });
    map.put("released", null);
    SwingUtilities.replaceUIActionMap(this, map);
    // set the model to the adapted model
    model = new TristateDecorator(getModel());
    setModel(model);
    setState(initial);
  }
  public TristateCheckBox(String text, State initial) {
    this(text, null, initial);
  }
  public TristateCheckBox(String text) {
    this(text, DONT_CARE);
  }
   
  public void nextState() {
      State current = getState();
      if (current == NOT_SELECTED) {
        setState(SELECTED);
      } else if (current == SELECTED) {
        setState(DONT_CARE);
      } else if (current == DONT_CARE) {
        setState(NOT_SELECTED);
      }
   }
    
  public TristateCheckBox() {
    this(null);
  }

  /** No one may add mouse listeners, not even Swing! */
  public void addMouseListener(MouseListener l) { }
  /**
   * Set the new state to either SELECTED, NOT_SELECTED or
   * DONT_CARE.  If state == null, it is treated as DONT_CARE.
   */
  public void setState(State state) { model.setState(state); }
  /** Return the current state, which is determined by the
   * selection status of the model. */
  public State getState() { return model.getState(); }
  public void setSelected(boolean b) {
    if (b) {
      setState(SELECTED);
    } else {
      setState(NOT_SELECTED);
    }
  }
  /**
   * Exactly which Design Pattern is this?  Is it an Adapter,
   * a Proxy or a Decorator?  In this case, my vote lies with the
   * Decorator, because we are extending functionality and
   * "decorating" the original model with a more powerful model.
   */
  private class TristateDecorator implements ButtonModel {
    private final ButtonModel other;
    private TristateDecorator(ButtonModel other) {
      this.other = other;
    }
    private void setState(State state) {
      if (state == NOT_SELECTED) {
        other.setArmed(false);
        setPressed(false);
        setSelected(false);
      } else if (state == SELECTED) {
        other.setArmed(false);
        setPressed(false);
        setSelected(true);
      } else { // either "null" or DONT_CARE
        other.setArmed(true);
        setPressed(true);
        setSelected(true);
      }
    }
    /**
     * The current state is embedded in the selection / armed
     * state of the model.
     * 
     * We return the SELECTED state when the checkbox is selected
     * but not armed, DONT_CARE state when the checkbox is
     * selected and armed (grey) and NOT_SELECTED when the
     * checkbox is deselected.
     */
    public State getState() {
      if (isSelected() && !isArmed()) {
        // normal black tick
        return SELECTED;
      } else if (isSelected() && isArmed()) {
        // don't care grey tick
        return DONT_CARE;
      } else {
        // normal deselected
        return NOT_SELECTED;
      }
    }
    /** We rotate between NOT_SELECTED, SELECTED and DONT_CARE.*/
    public void nextState() {
      State current = getState();
      if (current == NOT_SELECTED) {
        setState(SELECTED);
      } else if (current == SELECTED) {
        setState(DONT_CARE);
      } else if (current == DONT_CARE) {
        setState(NOT_SELECTED);
      }
    }
    /** Filter: No one may change the armed status except us. */
    public void setArmed(boolean b) {
    }
    /** We disable focusing on the component when it is not
     * enabled. */
    public void setEnabled(boolean b) {
      setFocusable(b);
      other.setEnabled(b);
    }
    /** All these methods simply delegate to the "other" model
     * that is being decorated. */
    public boolean isArmed() { return other.isArmed(); }
    public boolean isSelected() { return other.isSelected(); }
    public boolean isEnabled() { return other.isEnabled(); }
    public boolean isPressed() { return other.isPressed(); }
    public boolean isRollover() { return other.isRollover(); }
    public void setSelected(boolean b) { other.setSelected(b); }
    public void setPressed(boolean b) { other.setPressed(b); }
    public void setRollover(boolean b) { other.setRollover(b); }
    public void setMnemonic(int key) { other.setMnemonic(key); }
    public int getMnemonic() { return other.getMnemonic(); }
    public void setActionCommand(String s) {
      other.setActionCommand(s);
    }
    public String getActionCommand() {
      return other.getActionCommand();
    }
    public void setGroup(ButtonGroup group) {
      other.setGroup(group);
    }
    public void addActionListener(ActionListener l) {
      other.addActionListener(l);
    }
    public void removeActionListener(ActionListener l) {
      other.removeActionListener(l);
    }
    public void addItemListener(ItemListener l) {
      other.addItemListener(l);
    }
    public void removeItemListener(ItemListener l) {
      other.removeItemListener(l);
    }
    public void addChangeListener(ChangeListener l) {
      other.addChangeListener(l);
    }
    public void removeChangeListener(ChangeListener l) {
      other.removeChangeListener(l);
    }
    public Object[] getSelectedObjects() {
      return other.getSelectedObjects();
    }
  }
}

