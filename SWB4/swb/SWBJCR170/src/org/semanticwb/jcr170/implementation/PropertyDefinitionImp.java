/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.jcr170.implementation;

import javax.jcr.PropertyType;
import javax.jcr.Value;
import javax.jcr.nodetype.NodeType;
import javax.jcr.nodetype.PropertyDefinition;
import javax.jcr.version.OnParentVersionAction;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.repository.BaseNode;

/**
 *
 * @author victor.lorenzana
 */
public class PropertyDefinitionImp implements PropertyDefinition
{
    static Logger log=SWBUtils.getLogger(PropertyDefinitionImp.class);
    private final String name;
    private int requiredType = PropertyType.UNDEFINED;
    private boolean multiple = true;
    private boolean isProtected = false;
    private boolean mandatory = false,autocreated=false;
    private int onParentVersion=OnParentVersionAction.COPY;
    PropertyDefinitionImp(String name)
    {
        this.name = name;
    }

    PropertyDefinitionImp(SessionImp session, SemanticProperty property)
    {
        this.name = property.getPrefix() + ":" + property.getName();
        multiple = BaseNode.isMultiple(property);
        int type = PropertyType.UNDEFINED;
        if ( property.isObjectProperty() )
        {
            type = PropertyType.REFERENCE;
        }
        else
        {
            if ( property.isBoolean() )
            {
                type = PropertyType.BOOLEAN;
            }
            else if ( property.isDate() || property.isDateTime() )
            {
                type = PropertyType.DATE;
            }
            else if ( property.isLong() || property.isInt() )
            {
                type = PropertyType.LONG;
            }
            else if ( property.isString() )
            {
                type = PropertyType.STRING;
            }
            else if ( property.isFloat() )
            {
                type = PropertyType.DOUBLE;
            }
            else if ( property.isBinary() )
            {
                type=PropertyType.BINARY;
            }
        }
        this.requiredType = type;
        mandatory=session.getRootBaseNode().isMandatory(property);
        autocreated=session.getRootBaseNode().isAutocreated(property);
        String svalue=session.getRootBaseNode().getOnParentVersion(property);
        if(svalue!=null)
        {
            onParentVersion=OnParentVersionAction.valueFromName(svalue);
        }
        isProtected=session.getRootBaseNode().isProtected(property);
    }

    public void setRequiredType(int requiredType)
    {
        this.requiredType = requiredType;
    }

    public int getRequiredType()
    {
        return requiredType;
    }

    public void setMultiple(boolean multiple)
    {
        this.multiple = multiple;
    }

    public String[] getValueConstraints()
    {
        return null;
    }

    public Value[] getDefaultValues()
    {
        return null;
    }

    public boolean isMultiple()
    {
        return multiple;
    }

    public NodeType getDeclaringNodeType()
    {
        return null;
    }

    public String getName()
    {
        return name;
    }

    public boolean isAutoCreated()
    {
        return autocreated;
    }

    public boolean isMandatory()
    {
        return mandatory;
    }

    public int getOnParentVersion()
    {
        return onParentVersion;
    }

    public boolean isProtected()
    {
        return isProtected;
    }
    @Override
    public String toString()
    {
        return name;
    }
   
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 29 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final PropertyDefinitionImp other = (PropertyDefinitionImp) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name))
        {
            return false;
        }
        return true;
    }
}
