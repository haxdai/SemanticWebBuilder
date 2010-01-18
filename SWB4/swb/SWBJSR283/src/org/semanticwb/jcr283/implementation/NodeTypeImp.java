/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.jcr283.implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.nodetype.NoSuchNodeTypeException;
import javax.jcr.nodetype.NodeDefinition;
import javax.jcr.nodetype.NodeType;
import javax.jcr.nodetype.NodeTypeIterator;
import javax.jcr.nodetype.PropertyDefinition;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.jcr283.repository.model.Base;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticLiteral;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;

/**
 *
 * @author victor.lorenzana
 */
public class NodeTypeImp implements NodeType
{

    private static final String ALL = "*";
    private static final String ISQUERYABLE = "http://www.jcp.org/jcr/1.0#isQueryable";
    private static Logger log = SWBUtils.getLogger(NodeTypeImp.class);
    private final SemanticClass clazz;
    private final HashMap<String, PropertyDefinitionImp> propertyDefinitions = new HashMap<String, PropertyDefinitionImp>();
    private final HashMap<String, NodeDefinitionImp> childnodeDefinitions = new HashMap<String, NodeDefinitionImp>();
    private final HashSet<NodeTypeImp> supertypes = new HashSet<NodeTypeImp>();
    private final HashSet<NodeTypeImp> aditionalSuperTypes = new HashSet<NodeTypeImp>();
    private final HashSet<SemanticClass> subtypes = new HashSet<SemanticClass>();
    private final boolean isMixin;
    private final boolean isQueryable;
    private final boolean isAbstract;
    private final boolean hasOrderableChildNodes;
    private final String primaryItemName;

    
    public NodeTypeImp(SemanticClass clazz)
    {
        this(clazz,null);
    }
    public NodeTypeImp(SemanticClass clazz,HashSet<NodeTypeImp> aditionalSuperTypes)
    {
        if(aditionalSuperTypes!=null)
        {
            aditionalSuperTypes.addAll(aditionalSuperTypes);
        }
        this.clazz = clazz;
        loadPropertyDefinitions();
        loadChildNodeDefinitions();
        loadSuperTypes();
        loadSubTypes();
        SemanticProperty prop = getSemanticProperty(Property.JCR_IS_MIXIN);
        SemanticLiteral value = clazz.getRequiredProperty(prop);
        if (value == null)
        {
            isMixin = false;
        }
        else
        {
            isMixin = value.getBoolean();
        }
        prop = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(ISQUERYABLE);
        value = clazz.getRequiredProperty(prop);
        if (value == null)
        {
            isQueryable = false;
        }
        else
        {
            isQueryable = value.getBoolean();
        }
        prop = getSemanticProperty(Property.JCR_IS_ABSTRACT);
        value = clazz.getRequiredProperty(prop);
        if (value == null)
        {
            isAbstract = false;
        }
        else
        {
            isAbstract = value.getBoolean();
        }
        prop = getSemanticProperty(Property.JCR_HAS_ORDERABLE_CHILD_NODES);
        value = clazz.getRequiredProperty(prop);
        if (value == null)
        {
            hasOrderableChildNodes = false;
        }
        else
        {
            hasOrderableChildNodes = value.getBoolean();
        }

        prop = getSemanticProperty(Property.JCR_PRIMARY_ITEM_NAME);
        value = clazz.getRequiredProperty(prop);
        if (value == null)
        {
            primaryItemName = null;
        }
        else
        {
            primaryItemName = value.getString();
        }

    }
    public static SemanticProperty getSemanticProperty(String name)
    {
        name=name.replace("{","");
        name=name.replace("}","#");
        return SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(name);
    }
    private void loadSuperTypes()
    {
        NodeTypeManagerImp manager = new NodeTypeManagerImp();
        Iterator<SemanticClass> classes = clazz.listSuperClasses();
        while (classes.hasNext())
        {
            SemanticClass superClazz = classes.next();
            if (superClazz.isSubClass(Base.sclass) || superClazz.equals(Base.sclass))
            {
                try
                {
                    NodeTypeImp superNodeType = (NodeTypeImp)manager.getNodeType(superClazz.getPrefix() + ":" + superClazz.getName());
                    supertypes.add(superNodeType);
                }
                catch (NoSuchNodeTypeException nsnte)
                {
                    log.error(nsnte);
                    NodeTypeManagerImp.loadNodeType(clazz);
                }
                catch (RepositoryException re)
                {
                    log.error(re);
                }
            }
        }

    }

    private void loadPropertyDefinitions()
    {
        SemanticProperty prop = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.jcp.org/jcr/1.0#propertyDefinition");
        Iterator<SemanticObject> values = clazz.listObjectRequiredProperties(prop);
        while (values.hasNext())
        {
            SemanticObject propertyDefinition = values.next();
            PropertyDefinitionImp pd = new PropertyDefinitionImp(propertyDefinition,this);
            propertyDefinitions.put(pd.getName(), pd);
        }
        Iterator<SemanticProperty> props = clazz.listProperties();
        while (props.hasNext())
        {
            PropertyDefinitionImp pd = new PropertyDefinitionImp(props.next());
            propertyDefinitions.put(pd.getName(), pd);
        }
    }

    private void loadChildNodeDefinitions()
    {
        SemanticProperty prop = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.jcp.org/jcr/1.0#childNodeDefinition");
        Iterator<SemanticObject> values = clazz.listObjectRequiredProperties(prop);
        while (values.hasNext())
        {
            SemanticObject childDefinition = values.next();
            NodeDefinitionImp nodeDefinitionImp = new NodeDefinitionImp(childDefinition,this);
            childnodeDefinitions.put(nodeDefinitionImp.getName(), nodeDefinitionImp);
        }

    }

    public NodeType[] getSupertypes()
    {
        HashSet<NodeTypeImp> getSupertypes=new HashSet<NodeTypeImp>();
        getSupertypes.addAll(this.supertypes);
        getSupertypes.addAll(this.aditionalSuperTypes);
        return getSupertypes.toArray(new NodeType[getSupertypes.size()]);
    }

    private void loadSubTypes()
    {

        Iterator<SemanticClass> classes = SWBPlatform.getSemanticMgr().getVocabulary().listSemanticClasses();
        while (classes.hasNext())
        {
            SemanticClass oclazz = classes.next();
            if (oclazz.isSubClass(clazz))
            {
                subtypes.add(oclazz);
            }
        }
    }

    public SemanticClass getSemanticClass()
    {
        return clazz;
    }

    public NodeType[] getDeclaredSupertypes()
    {
        return this.supertypes.toArray(new NodeType[this.supertypes.size()]);
    }
    public NodeTypeIterator getSubtypes()
    {
        return new NodeTypeIteratorImp(subtypes);
    }

    public NodeTypeIterator getDeclaredSubtypes()
    {        
        return new NodeTypeIteratorImp(subtypes);
    }

    public boolean isNodeType(String nodeTypeName)
    {
        if (clazz.equals(Base.sclass) || clazz.isSubClass(Base.sclass))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public PropertyDefinition[] getPropertyDefinitions()
    {
        return propertyDefinitions.values().toArray(new PropertyDefinition[propertyDefinitions.size()]);
    }

    public NodeDefinition[] getChildNodeDefinitions()
    {
        return childnodeDefinitions.values().toArray(new NodeDefinition[childnodeDefinitions.size()]);
    }

    public boolean canSetProperty(String propertyName, Value value)
    {
        return canSetProperty(propertyName, new Value[]
                {
                    value
                });
    }

    public boolean canSetProperty(String propertyName, Value[] values)
    {
        for (PropertyDefinitionImp propertyDefinition : propertyDefinitions.values())
        {
            if (propertyDefinition.getName().equals(ALL))
            {
                if (values.length > 1 && !propertyDefinition.isMultiple())
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
        }
        PropertyDefinitionImp propertyDefinition = propertyDefinitions.get(propertyName);
        if (propertyDefinition == null)
        {
            return false;
        }
        if (values.length > 1 && !propertyDefinition.isMultiple())
        {
            return false;
        }
        for (Value value : values)
        {
            if (!isCompatibleValue(propertyDefinition.getRequiredType(), value.getType()))
            {
                return false;
            }
        }
        return true;
    }

    private boolean isCompatibleValue(int requeredType, int type)
    {
        boolean isCompatibleValue = false;
        if (requeredType == type)
        {
            return true;
        }
        //TODO: revisar con que otros datos es compatible
        return isCompatibleValue;
    }

    public boolean canAddChildNode(String childNodeName)
    {
        return canAddChildNode(childNodeName, null);
    }

    public boolean canAddChildNode(String childNodeName, String nodeTypeName)
    {
        for (NodeDefinitionImp childNodeDefinition : this.childnodeDefinitions.values())
        {
            if (childNodeDefinition.getName().equals(ALL))
            {
                if (nodeTypeName == null)
                {
                    nodeTypeName = childNodeDefinition.getDefaultPrimaryTypeName();
                }
                if (nodeTypeName != null)
                {
                    String names[] = childNodeDefinition.getRequiredPrimaryTypeNames();
                    for (String name : names)
                    {
                        if (name.equals(nodeTypeName))
                        {
                            return true;
                        }
                    }
                }

            }
        }
        NodeDefinitionImp childNodeDefinition = this.childnodeDefinitions.get(childNodeName);
        if (childNodeDefinition == null)
        {
            return false;
        }
        else
        {
            if (nodeTypeName == null)
            {
                nodeTypeName = childNodeDefinition.getDefaultPrimaryTypeName();
            }
            if (nodeTypeName != null)
            {
                String names[] = childNodeDefinition.getRequiredPrimaryTypeNames();
                for (String name : names)
                {
                    if (name.equals(nodeTypeName))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean canRemoveItem(String itemName)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean canRemoveNode(String nodeName)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean canRemoveProperty(String propertyName)
    {
        for (PropertyDefinitionImp propertyDefinition : propertyDefinitions.values())
        {
            if (propertyDefinition.getName().equals(ALL))
            {
                if (propertyDefinition.isProtected())
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
        }
        PropertyDefinitionImp propertyDefinition = propertyDefinitions.get(propertyName);
        if (propertyDefinition == null)
        {
            return false;
        }
        else
        {
            if (propertyDefinition.isProtected())
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }

    public String getName()
    {
        return clazz.getPrefix() + ":" + clazz.getName();
    }

    public String[] getDeclaredSupertypeNames()
    {
        HashSet<String> names = new HashSet<String>();
        NodeTypeIterator nodeTypeIteratorImp = this.getDeclaredSubtypes();
        while (nodeTypeIteratorImp.hasNext())
        {
            names.add(nodeTypeIteratorImp.nextNodeType().getName());
        }
        return names.toArray(new String[names.size()]);
    }

    public boolean isAbstract()
    {
        return isAbstract;
    }

    public boolean isMixin()
    {
        return isMixin;
    }

    public boolean hasOrderableChildNodes()
    {
        return hasOrderableChildNodes;
    }

    public boolean isQueryable()
    {
        return isQueryable;
    }

    public String getPrimaryItemName()
    {
        return primaryItemName;
    }

    public PropertyDefinition[] getDeclaredPropertyDefinitions()
    {
        // TODO: revisar
        return this.getPropertyDefinitions();
    }

    public NodeDefinition[] getDeclaredChildNodeDefinitions()
    {
        // TODO: revisar
        return this.getChildNodeDefinitions();
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
        final NodeTypeImp other = (NodeTypeImp) obj;
        if ((this.clazz == null || !this.clazz.equals(other.clazz)))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 89 * hash + (this.clazz != null ? this.clazz.hashCode() : 0);
        return hash;
    }
}
