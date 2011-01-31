package org.semanticwb.mask.base;

import java.util.Collections;
import java.util.List;
import org.semanticwb.SWBUtils;


public abstract class MessageBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty mascara_read=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/mascara#read");
    public static final org.semanticwb.platform.SemanticProperty mascara_msg=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/mascara#msg");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty mascara_from=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/mascara#from");
    public static final org.semanticwb.platform.SemanticProperty mascara_created=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/mascara#created");
    public static final org.semanticwb.platform.SemanticProperty mascara_to=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/mascara#to");
    public static final org.semanticwb.platform.SemanticProperty mascara_subject=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/mascara#subject");
    public static final org.semanticwb.platform.SemanticClass mascara_Message=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/mascara#Message");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/mascara#Message");

    public static class ClassMgr
    {
       /**
       * Returns a list of Message for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.mask.Message
       */

        public static java.util.Iterator<org.semanticwb.mask.Message> listMessages(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.mask.Message>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.mask.Message for all models
       * @return Iterator of org.semanticwb.mask.Message
       */

        public static java.util.Iterator<org.semanticwb.mask.Message> listMessages()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.mask.Message>(it, true);
        }

        public static org.semanticwb.mask.Message createMessage(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.mask.Message.ClassMgr.createMessage(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.mask.Message
       * @param id Identifier for org.semanticwb.mask.Message
       * @param model Model of the org.semanticwb.mask.Message
       * @return A org.semanticwb.mask.Message
       */
        public static org.semanticwb.mask.Message getMessage(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.mask.Message)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.mask.Message
       * @param id Identifier for org.semanticwb.mask.Message
       * @param model Model of the org.semanticwb.mask.Message
       * @return A org.semanticwb.mask.Message
       */
        public static org.semanticwb.mask.Message createMessage(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.mask.Message)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.mask.Message
       * @param id Identifier for org.semanticwb.mask.Message
       * @param model Model of the org.semanticwb.mask.Message
       */
        public static void removeMessage(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

       /**
       * Returns true if exists a org.semanticwb.mask.Message
       * @param id Identifier for org.semanticwb.mask.Message
       * @param model Model of the org.semanticwb.mask.Message
       * @return true if the org.semanticwb.mask.Message exists, false otherwise
       */

        public static boolean hasMessage(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMessage(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.mask.Message with a determined From
       * @param value From of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.mask.Message
       * @return Iterator with all the org.semanticwb.mask.Message
       */

        public static java.util.Iterator<org.semanticwb.mask.Message> listMessageByFrom(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.mask.Message> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(mascara_from, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.mask.Message with a determined From
       * @param value From of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.mask.Message
       */

        public static java.util.Iterator<org.semanticwb.mask.Message> listMessageByFrom(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.mask.Message> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(mascara_from,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.mask.Message with a determined To
       * @param value To of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.mask.Message
       * @return Iterator with all the org.semanticwb.mask.Message
       */

        public static java.util.Iterator<org.semanticwb.mask.Message> listMessageByTo(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.mask.Message> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(mascara_to, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.mask.Message with a determined To
       * @param value To of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.mask.Message
       */

        public static java.util.Iterator<org.semanticwb.mask.Message> listMessageByTo(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.mask.Message> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(mascara_to,value.getSemanticObject(),sclass));
            return it;
        }

        public static void removeRangeByTo(org.semanticwb.model.User to, org.semanticwb.model.SWBModel model, int fromIndex, int toIndex) throws IndexOutOfBoundsException {
            List<org.semanticwb.mask.Message> l = SWBUtils.Collections.copyIterator(listMessageByTo(to, model));
            Collections.sort(l, new org.semanticwb.mask.Message.MessageSortByCreatedDate());
            System.out.println("removeRangeByTo....to="+to.getName()+" list.size="+l.size());
            for(int i=fromIndex; i<toIndex; i++) {
                org.semanticwb.mask.Message m = l.get(i);
                if(m!=null)
                    m.remove();
                l.remove(i);
            }
        }

        public static void removeRangeByFrom(org.semanticwb.model.User from, org.semanticwb.model.SWBModel model, int fromIndex, int toIndex) throws IndexOutOfBoundsException {
            List<org.semanticwb.mask.Message> l = SWBUtils.Collections.copyIterator(listMessageByFrom(from, model));
            Collections.sort(l, new org.semanticwb.mask.Message.MessageSortByCreatedDate());
            System.out.println("removeRangeByFrom....from="+from.getName()+" list.size="+l.size());
            for(int i=fromIndex; i<toIndex; i++) {
                org.semanticwb.mask.Message m = l.get(i);
                if(m!=null)
                    m.remove();
                l.remove(i);
            }
        }
    }

   /**
   * Constructs a MessageBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Message
   */
    public MessageBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Read property
* @return boolean with the Read
*/
    public boolean isRead()
    {
        return getSemanticObject().getBooleanProperty(mascara_read);
    }

/**
* Sets the Read property
* @param value long with the Read
*/
    public void setRead(boolean value)
    {
        getSemanticObject().setBooleanProperty(mascara_read, value);
    }

/**
* Gets the Msg property
* @return String with the Msg
*/
    public String getMsg()
    {
        return getSemanticObject().getProperty(mascara_msg);
    }

/**
* Sets the Msg property
* @param value long with the Msg
*/
    public void setMsg(String value)
    {
        getSemanticObject().setProperty(mascara_msg, value);
    }
   /**
   * Sets the value for the property From
   * @param value From to set
   */

    public void setFrom(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(mascara_from, value.getSemanticObject());
        }else
        {
            removeFrom();
        }
    }
   /**
   * Remove the value for From property
   */

    public void removeFrom()
    {
        getSemanticObject().removeProperty(mascara_from);
    }

   /**
   * Gets the From
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getFrom()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(mascara_from);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(mascara_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(mascara_created, value);
    }
   /**
   * Sets the value for the property To
   * @param value To to set
   */

    public void setTo(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(mascara_to, value.getSemanticObject());
        }else
        {
            removeTo();
        }
    }
   /**
   * Remove the value for To property
   */

    public void removeTo()
    {
        getSemanticObject().removeProperty(mascara_to);
    }

   /**
   * Gets the To
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getTo()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(mascara_to);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Subject property
* @return String with the Subject
*/
    public String getSubject()
    {
        return getSemanticObject().getProperty(mascara_subject);
    }

/**
* Sets the Subject property
* @param value long with the Subject
*/
    public void setSubject(String value)
    {
        getSemanticObject().setProperty(mascara_subject, value);
    }
}
