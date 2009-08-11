/**  
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración, 
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de 
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes 
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y 
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación 
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; 
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. 
* 
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 
 


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

