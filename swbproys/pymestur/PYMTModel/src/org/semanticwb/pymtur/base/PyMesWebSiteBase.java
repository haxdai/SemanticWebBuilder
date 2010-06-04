package org.semanticwb.pymtur.base;


public abstract class PyMesWebSiteBase extends org.semanticwb.model.WebSite implements org.semanticwb.model.Undeleteable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Indexable,org.semanticwb.model.Localeable,org.semanticwb.model.Filterable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Activeable,org.semanticwb.model.Traceable,org.semanticwb.model.Trashable,org.semanticwb.model.FilterableNode
{
    public static final org.semanticwb.platform.SemanticClass swbcomm_MicroSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#MicroSite");
    public static final org.semanticwb.platform.SemanticClass pymtur_MiPymeSitePlus=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymeSitePlus");
    public static final org.semanticwb.platform.SemanticClass pymtur_CategoryPromotionType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#CategoryPromotionType");
    public static final org.semanticwb.platform.SemanticClass pymtur_Nearest=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Nearest");
    public static final org.semanticwb.platform.SemanticClass pymtur_CategoryCuponType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#CategoryCuponType");
    public static final org.semanticwb.platform.SemanticClass pymtur_HospedajeRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#HospedajeRate");
    public static final org.semanticwb.platform.SemanticClass pymtur_MiPymeSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymeSite");
    public static final org.semanticwb.platform.SemanticClass pymtur_TourismType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#TourismType");
    public static final org.semanticwb.platform.SemanticClass pymtur_Instalation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Instalation");
    public static final org.semanticwb.platform.SemanticClass pymtur_Hospedaje=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Hospedaje");
    public static final org.semanticwb.platform.SemanticClass pymtur_ExperienceType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ExperienceType");
    public static final org.semanticwb.platform.SemanticClass pymtur_PaqTemplate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PaqTemplate");
    public static final org.semanticwb.platform.SemanticClass pymtur_Experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Experience");
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
    public static final org.semanticwb.platform.SemanticClass pymtur_Region=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Region");
    public static final org.semanticwb.platform.SemanticClass pymtur_RejectReason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RejectReason");
    public static final org.semanticwb.platform.SemanticClass pymtur_Parameter=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Parameter");
    public static final org.semanticwb.platform.SemanticClass pymtur_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Event");
    public static final org.semanticwb.platform.SemanticClass pymtur_InterestPortalLink=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#InterestPortalLink");
    public static final org.semanticwb.platform.SemanticClass pymtur_EmailText=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#EmailText");
    public static final org.semanticwb.platform.SemanticClass pymtur_Paquete=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Paquete");
    public static final org.semanticwb.platform.SemanticClass pymtur_UnActivationReason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#UnActivationReason");
    public static final org.semanticwb.platform.SemanticClass pymtur_RemoveReason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RemoveReason");
    public static final org.semanticwb.platform.SemanticClass swbcomm_MicroSiteWebPageUtil=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#MicroSiteWebPageUtil");
    public static final org.semanticwb.platform.SemanticClass pymtur_EventType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#EventType");
    public static final org.semanticwb.platform.SemanticClass pymtur_VariantPaqTemplate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#VariantPaqTemplate");
    public static final org.semanticwb.platform.SemanticClass pymtur_SPType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#SPType");
    public static final org.semanticwb.platform.SemanticClass pymtur_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Destination");
    public static final org.semanticwb.platform.SemanticClass pymtur_InteresLink=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#InteresLink");
    public static final org.semanticwb.platform.SemanticClass pymtur_Service=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Service");
    public static final org.semanticwb.platform.SemanticClass pymtur_SPCategory=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#SPCategory");
    public static final org.semanticwb.platform.SemanticClass pymtur_State=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#State");
    public static final org.semanticwb.platform.SemanticClass pymtur_Bank=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Bank");
    public static final org.semanticwb.platform.SemanticClass pymtur_ActivityType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ActivityType");
    public static final org.semanticwb.platform.SemanticClass pymtur_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Activity");
    public static final org.semanticwb.platform.SemanticClass pymtur_PyMesWebSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PyMesWebSite");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PyMesWebSite");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSites(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSites()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite>(it, true);
        }

        public static org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite(String id)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.pymtur.PyMesWebSite ret=null;
            org.semanticwb.platform.SemanticModel model=mgr.getModel(id);
            if(model!=null)
            {
                org.semanticwb.platform.SemanticObject obj=model.getSemanticObject(model.getObjectUri(id,sclass));
                if(obj!=null)
                {
                    ret=(org.semanticwb.pymtur.PyMesWebSite)obj.createGenericInstance();
                }
            }
            return ret;
        }

        public static org.semanticwb.pymtur.PyMesWebSite createPyMesWebSite(String id, String namespace)
        {
            org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
            org.semanticwb.platform.SemanticModel model=mgr.createModel(id, namespace);
            return (org.semanticwb.pymtur.PyMesWebSite)model.createGenericObject(model.getObjectUri(id, sclass), sclass);
        }

        public static void removePyMesWebSite(String id)
        {
            org.semanticwb.pymtur.PyMesWebSite obj=getPyMesWebSite(id);
            if(obj!=null)
            {
                obj.remove();
            }
        }

        public static boolean hasPyMesWebSite(String id)
        {
            return (getPyMesWebSite(id)!=null);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByParentWebSite(org.semanticwb.model.WebSite value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByParentWebSite(org.semanticwb.model.WebSite value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_parentWebSite,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByHomePage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_homePage, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByHomePage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_homePage,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByDefaultTemplate(org.semanticwb.model.Template value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByDefaultTemplate(org.semanticwb.model.Template value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_defaultTemplate,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteBySubModel(org.semanticwb.model.SWBModel value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteBySubModel(org.semanticwb.model.SWBModel value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasSubModel,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByUserRepository(org.semanticwb.model.UserRepository value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByUserRepository(org.semanticwb.model.UserRepository value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_userRepository,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public PyMesWebSiteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.portal.community.MicroSite getMicroSite(String id)
    {
        return org.semanticwb.portal.community.MicroSite.ClassMgr.getMicroSite(id, this);
    }

    public java.util.Iterator<org.semanticwb.portal.community.MicroSite> listMicroSites()
    {
        return org.semanticwb.portal.community.MicroSite.ClassMgr.listMicroSites(this);
    }

    public org.semanticwb.portal.community.MicroSite createMicroSite(String id)
    {
        return org.semanticwb.portal.community.MicroSite.ClassMgr.createMicroSite(id,this);
    }

    public void removeMicroSite(String id)
    {
        org.semanticwb.portal.community.MicroSite.ClassMgr.removeMicroSite(id, this);
    }
    public boolean hasMicroSite(String id)
    {
        return org.semanticwb.portal.community.MicroSite.ClassMgr.hasMicroSite(id, this);
    }

    public org.semanticwb.pymtur.MiPymeSitePlus getMiPymeSitePlus(String id)
    {
        return org.semanticwb.pymtur.MiPymeSitePlus.ClassMgr.getMiPymeSitePlus(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.MiPymeSitePlus> listMiPymeSitePluses()
    {
        return org.semanticwb.pymtur.MiPymeSitePlus.ClassMgr.listMiPymeSitePluses(this);
    }

    public org.semanticwb.pymtur.MiPymeSitePlus createMiPymeSitePlus(String id)
    {
        return org.semanticwb.pymtur.MiPymeSitePlus.ClassMgr.createMiPymeSitePlus(id,this);
    }

    public org.semanticwb.pymtur.MiPymeSitePlus createMiPymeSitePlus()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_MiPymeSitePlus);
        return org.semanticwb.pymtur.MiPymeSitePlus.ClassMgr.createMiPymeSitePlus(String.valueOf(id),this);
    } 

    public void removeMiPymeSitePlus(String id)
    {
        org.semanticwb.pymtur.MiPymeSitePlus.ClassMgr.removeMiPymeSitePlus(id, this);
    }
    public boolean hasMiPymeSitePlus(String id)
    {
        return org.semanticwb.pymtur.MiPymeSitePlus.ClassMgr.hasMiPymeSitePlus(id, this);
    }

    public org.semanticwb.pymtur.CategoryPromotionType getCategoryPromotionType(String id)
    {
        return org.semanticwb.pymtur.CategoryPromotionType.ClassMgr.getCategoryPromotionType(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.CategoryPromotionType> listCategoryPromotionTypes()
    {
        return org.semanticwb.pymtur.CategoryPromotionType.ClassMgr.listCategoryPromotionTypes(this);
    }

    public org.semanticwb.pymtur.CategoryPromotionType createCategoryPromotionType(String id)
    {
        return org.semanticwb.pymtur.CategoryPromotionType.ClassMgr.createCategoryPromotionType(id,this);
    }

    public void removeCategoryPromotionType(String id)
    {
        org.semanticwb.pymtur.CategoryPromotionType.ClassMgr.removeCategoryPromotionType(id, this);
    }
    public boolean hasCategoryPromotionType(String id)
    {
        return org.semanticwb.pymtur.CategoryPromotionType.ClassMgr.hasCategoryPromotionType(id, this);
    }

    public org.semanticwb.pymtur.Nearest getNearest(String id)
    {
        return org.semanticwb.pymtur.Nearest.ClassMgr.getNearest(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.Nearest> listNearests()
    {
        return org.semanticwb.pymtur.Nearest.ClassMgr.listNearests(this);
    }

    public org.semanticwb.pymtur.Nearest createNearest(String id)
    {
        return org.semanticwb.pymtur.Nearest.ClassMgr.createNearest(id,this);
    }

    public org.semanticwb.pymtur.Nearest createNearest()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_Nearest);
        return org.semanticwb.pymtur.Nearest.ClassMgr.createNearest(String.valueOf(id),this);
    } 

    public void removeNearest(String id)
    {
        org.semanticwb.pymtur.Nearest.ClassMgr.removeNearest(id, this);
    }
    public boolean hasNearest(String id)
    {
        return org.semanticwb.pymtur.Nearest.ClassMgr.hasNearest(id, this);
    }

    public org.semanticwb.pymtur.CategoryCuponType getCategoryCuponType(String id)
    {
        return org.semanticwb.pymtur.CategoryCuponType.ClassMgr.getCategoryCuponType(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.CategoryCuponType> listCategoryCuponTypes()
    {
        return org.semanticwb.pymtur.CategoryCuponType.ClassMgr.listCategoryCuponTypes(this);
    }

    public org.semanticwb.pymtur.CategoryCuponType createCategoryCuponType(String id)
    {
        return org.semanticwb.pymtur.CategoryCuponType.ClassMgr.createCategoryCuponType(id,this);
    }

    public void removeCategoryCuponType(String id)
    {
        org.semanticwb.pymtur.CategoryCuponType.ClassMgr.removeCategoryCuponType(id, this);
    }
    public boolean hasCategoryCuponType(String id)
    {
        return org.semanticwb.pymtur.CategoryCuponType.ClassMgr.hasCategoryCuponType(id, this);
    }

    public org.semanticwb.pymtur.HospedajeRate getHospedajeRate(String id)
    {
        return org.semanticwb.pymtur.HospedajeRate.ClassMgr.getHospedajeRate(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.HospedajeRate> listHospedajeRates()
    {
        return org.semanticwb.pymtur.HospedajeRate.ClassMgr.listHospedajeRates(this);
    }

    public org.semanticwb.pymtur.HospedajeRate createHospedajeRate(String id)
    {
        return org.semanticwb.pymtur.HospedajeRate.ClassMgr.createHospedajeRate(id,this);
    }

    public org.semanticwb.pymtur.HospedajeRate createHospedajeRate()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_HospedajeRate);
        return org.semanticwb.pymtur.HospedajeRate.ClassMgr.createHospedajeRate(String.valueOf(id),this);
    } 

    public void removeHospedajeRate(String id)
    {
        org.semanticwb.pymtur.HospedajeRate.ClassMgr.removeHospedajeRate(id, this);
    }
    public boolean hasHospedajeRate(String id)
    {
        return org.semanticwb.pymtur.HospedajeRate.ClassMgr.hasHospedajeRate(id, this);
    }

    public org.semanticwb.pymtur.MiPymeSite getMiPymeSite(String id)
    {
        return org.semanticwb.pymtur.MiPymeSite.ClassMgr.getMiPymeSite(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.MiPymeSite> listMiPymeSites()
    {
        return org.semanticwb.pymtur.MiPymeSite.ClassMgr.listMiPymeSites(this);
    }

    public org.semanticwb.pymtur.MiPymeSite createMiPymeSite(String id)
    {
        return org.semanticwb.pymtur.MiPymeSite.ClassMgr.createMiPymeSite(id,this);
    }

    public org.semanticwb.pymtur.MiPymeSite createMiPymeSite()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_MiPymeSite);
        return org.semanticwb.pymtur.MiPymeSite.ClassMgr.createMiPymeSite(String.valueOf(id),this);
    } 

    public void removeMiPymeSite(String id)
    {
        org.semanticwb.pymtur.MiPymeSite.ClassMgr.removeMiPymeSite(id, this);
    }
    public boolean hasMiPymeSite(String id)
    {
        return org.semanticwb.pymtur.MiPymeSite.ClassMgr.hasMiPymeSite(id, this);
    }

    public org.semanticwb.pymtur.TourismType getTourismType(String id)
    {
        return org.semanticwb.pymtur.TourismType.ClassMgr.getTourismType(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.TourismType> listTourismTypes()
    {
        return org.semanticwb.pymtur.TourismType.ClassMgr.listTourismTypes(this);
    }

    public org.semanticwb.pymtur.TourismType createTourismType(String id)
    {
        return org.semanticwb.pymtur.TourismType.ClassMgr.createTourismType(id,this);
    }

    public org.semanticwb.pymtur.TourismType createTourismType()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_TourismType);
        return org.semanticwb.pymtur.TourismType.ClassMgr.createTourismType(String.valueOf(id),this);
    } 

    public void removeTourismType(String id)
    {
        org.semanticwb.pymtur.TourismType.ClassMgr.removeTourismType(id, this);
    }
    public boolean hasTourismType(String id)
    {
        return org.semanticwb.pymtur.TourismType.ClassMgr.hasTourismType(id, this);
    }

    public org.semanticwb.pymtur.Instalation getInstalation(String id)
    {
        return org.semanticwb.pymtur.Instalation.ClassMgr.getInstalation(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.Instalation> listInstalations()
    {
        return org.semanticwb.pymtur.Instalation.ClassMgr.listInstalations(this);
    }

    public org.semanticwb.pymtur.Instalation createInstalation(String id)
    {
        return org.semanticwb.pymtur.Instalation.ClassMgr.createInstalation(id,this);
    }

    public org.semanticwb.pymtur.Instalation createInstalation()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_Instalation);
        return org.semanticwb.pymtur.Instalation.ClassMgr.createInstalation(String.valueOf(id),this);
    } 

    public void removeInstalation(String id)
    {
        org.semanticwb.pymtur.Instalation.ClassMgr.removeInstalation(id, this);
    }
    public boolean hasInstalation(String id)
    {
        return org.semanticwb.pymtur.Instalation.ClassMgr.hasInstalation(id, this);
    }

    public org.semanticwb.pymtur.Hospedaje getHospedaje(String id)
    {
        return org.semanticwb.pymtur.Hospedaje.ClassMgr.getHospedaje(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajes()
    {
        return org.semanticwb.pymtur.Hospedaje.ClassMgr.listHospedajes(this);
    }

    public org.semanticwb.pymtur.Hospedaje createHospedaje(String id)
    {
        return org.semanticwb.pymtur.Hospedaje.ClassMgr.createHospedaje(id,this);
    }

    public void removeHospedaje(String id)
    {
        org.semanticwb.pymtur.Hospedaje.ClassMgr.removeHospedaje(id, this);
    }
    public boolean hasHospedaje(String id)
    {
        return org.semanticwb.pymtur.Hospedaje.ClassMgr.hasHospedaje(id, this);
    }

    public org.semanticwb.pymtur.ExperienceType getExperienceType(String id)
    {
        return org.semanticwb.pymtur.ExperienceType.ClassMgr.getExperienceType(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.ExperienceType> listExperienceTypes()
    {
        return org.semanticwb.pymtur.ExperienceType.ClassMgr.listExperienceTypes(this);
    }

    public org.semanticwb.pymtur.ExperienceType createExperienceType(String id)
    {
        return org.semanticwb.pymtur.ExperienceType.ClassMgr.createExperienceType(id,this);
    }

    public org.semanticwb.pymtur.ExperienceType createExperienceType()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_ExperienceType);
        return org.semanticwb.pymtur.ExperienceType.ClassMgr.createExperienceType(String.valueOf(id),this);
    } 

    public void removeExperienceType(String id)
    {
        org.semanticwb.pymtur.ExperienceType.ClassMgr.removeExperienceType(id, this);
    }
    public boolean hasExperienceType(String id)
    {
        return org.semanticwb.pymtur.ExperienceType.ClassMgr.hasExperienceType(id, this);
    }

    public org.semanticwb.pymtur.PaqTemplate getPaqTemplate(String id)
    {
        return org.semanticwb.pymtur.PaqTemplate.ClassMgr.getPaqTemplate(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.PaqTemplate> listPaqTemplates()
    {
        return org.semanticwb.pymtur.PaqTemplate.ClassMgr.listPaqTemplates(this);
    }

    public org.semanticwb.pymtur.PaqTemplate createPaqTemplate(String id)
    {
        return org.semanticwb.pymtur.PaqTemplate.ClassMgr.createPaqTemplate(id,this);
    }

    public void removePaqTemplate(String id)
    {
        org.semanticwb.pymtur.PaqTemplate.ClassMgr.removePaqTemplate(id, this);
    }
    public boolean hasPaqTemplate(String id)
    {
        return org.semanticwb.pymtur.PaqTemplate.ClassMgr.hasPaqTemplate(id, this);
    }

    public org.semanticwb.pymtur.Experience getExperience(String id)
    {
        return org.semanticwb.pymtur.Experience.ClassMgr.getExperience(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.Experience> listExperiences()
    {
        return org.semanticwb.pymtur.Experience.ClassMgr.listExperiences(this);
    }

    public org.semanticwb.pymtur.Experience createExperience(String id)
    {
        return org.semanticwb.pymtur.Experience.ClassMgr.createExperience(id,this);
    }

    public org.semanticwb.pymtur.Experience createExperience()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_Experience);
        return org.semanticwb.pymtur.Experience.ClassMgr.createExperience(String.valueOf(id),this);
    } 

    public void removeExperience(String id)
    {
        org.semanticwb.pymtur.Experience.ClassMgr.removeExperience(id, this);
    }
    public boolean hasExperience(String id)
    {
        return org.semanticwb.pymtur.Experience.ClassMgr.hasExperience(id, this);
    }

    public org.semanticwb.pymtur.ServiceProvider getServiceProvider(String id)
    {
        return org.semanticwb.pymtur.ServiceProvider.ClassMgr.getServiceProvider(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviders()
    {
        return org.semanticwb.pymtur.ServiceProvider.ClassMgr.listServiceProviders(this);
    }

    public org.semanticwb.pymtur.ServiceProvider createServiceProvider(String id)
    {
        return org.semanticwb.pymtur.ServiceProvider.ClassMgr.createServiceProvider(id,this);
    }

    public void removeServiceProvider(String id)
    {
        org.semanticwb.pymtur.ServiceProvider.ClassMgr.removeServiceProvider(id, this);
    }
    public boolean hasServiceProvider(String id)
    {
        return org.semanticwb.pymtur.ServiceProvider.ClassMgr.hasServiceProvider(id, this);
    }

    public org.semanticwb.pymtur.Region getRegion(String id)
    {
        return org.semanticwb.pymtur.Region.ClassMgr.getRegion(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.Region> listRegions()
    {
        return org.semanticwb.pymtur.Region.ClassMgr.listRegions(this);
    }

    public org.semanticwb.pymtur.Region createRegion(String id)
    {
        return org.semanticwb.pymtur.Region.ClassMgr.createRegion(id,this);
    }

    public void removeRegion(String id)
    {
        org.semanticwb.pymtur.Region.ClassMgr.removeRegion(id, this);
    }
    public boolean hasRegion(String id)
    {
        return org.semanticwb.pymtur.Region.ClassMgr.hasRegion(id, this);
    }

    public org.semanticwb.pymtur.RejectReason getRejectReason(String id)
    {
        return org.semanticwb.pymtur.RejectReason.ClassMgr.getRejectReason(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.RejectReason> listRejectReasons()
    {
        return org.semanticwb.pymtur.RejectReason.ClassMgr.listRejectReasons(this);
    }

    public org.semanticwb.pymtur.RejectReason createRejectReason(String id)
    {
        return org.semanticwb.pymtur.RejectReason.ClassMgr.createRejectReason(id,this);
    }

    public org.semanticwb.pymtur.RejectReason createRejectReason()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_RejectReason);
        return org.semanticwb.pymtur.RejectReason.ClassMgr.createRejectReason(String.valueOf(id),this);
    } 

    public void removeRejectReason(String id)
    {
        org.semanticwb.pymtur.RejectReason.ClassMgr.removeRejectReason(id, this);
    }
    public boolean hasRejectReason(String id)
    {
        return org.semanticwb.pymtur.RejectReason.ClassMgr.hasRejectReason(id, this);
    }

    public org.semanticwb.pymtur.Parameter getParameter(String id)
    {
        return org.semanticwb.pymtur.Parameter.ClassMgr.getParameter(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.Parameter> listParameters()
    {
        return org.semanticwb.pymtur.Parameter.ClassMgr.listParameters(this);
    }

    public org.semanticwb.pymtur.Parameter createParameter(String id)
    {
        return org.semanticwb.pymtur.Parameter.ClassMgr.createParameter(id,this);
    }

    public void removeParameter(String id)
    {
        org.semanticwb.pymtur.Parameter.ClassMgr.removeParameter(id, this);
    }
    public boolean hasParameter(String id)
    {
        return org.semanticwb.pymtur.Parameter.ClassMgr.hasParameter(id, this);
    }

    public org.semanticwb.pymtur.Event getEvent(String id)
    {
        return org.semanticwb.pymtur.Event.ClassMgr.getEvent(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.Event> listEvents()
    {
        return org.semanticwb.pymtur.Event.ClassMgr.listEvents(this);
    }

    public org.semanticwb.pymtur.Event createEvent(String id)
    {
        return org.semanticwb.pymtur.Event.ClassMgr.createEvent(id,this);
    }

    public org.semanticwb.pymtur.Event createEvent()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_Event);
        return org.semanticwb.pymtur.Event.ClassMgr.createEvent(String.valueOf(id),this);
    } 

    public void removeEvent(String id)
    {
        org.semanticwb.pymtur.Event.ClassMgr.removeEvent(id, this);
    }
    public boolean hasEvent(String id)
    {
        return org.semanticwb.pymtur.Event.ClassMgr.hasEvent(id, this);
    }

    public org.semanticwb.pymtur.InterestPortalLink getInterestPortalLink(String id)
    {
        return org.semanticwb.pymtur.InterestPortalLink.ClassMgr.getInterestPortalLink(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.InterestPortalLink> listInterestPortalLinks()
    {
        return org.semanticwb.pymtur.InterestPortalLink.ClassMgr.listInterestPortalLinks(this);
    }

    public org.semanticwb.pymtur.InterestPortalLink createInterestPortalLink(String id)
    {
        return org.semanticwb.pymtur.InterestPortalLink.ClassMgr.createInterestPortalLink(id,this);
    }

    public org.semanticwb.pymtur.InterestPortalLink createInterestPortalLink()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_InterestPortalLink);
        return org.semanticwb.pymtur.InterestPortalLink.ClassMgr.createInterestPortalLink(String.valueOf(id),this);
    } 

    public void removeInterestPortalLink(String id)
    {
        org.semanticwb.pymtur.InterestPortalLink.ClassMgr.removeInterestPortalLink(id, this);
    }
    public boolean hasInterestPortalLink(String id)
    {
        return org.semanticwb.pymtur.InterestPortalLink.ClassMgr.hasInterestPortalLink(id, this);
    }

    public org.semanticwb.pymtur.EmailText getEmailText(String id)
    {
        return org.semanticwb.pymtur.EmailText.ClassMgr.getEmailText(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.EmailText> listEmailTexts()
    {
        return org.semanticwb.pymtur.EmailText.ClassMgr.listEmailTexts(this);
    }

    public org.semanticwb.pymtur.EmailText createEmailText(String id)
    {
        return org.semanticwb.pymtur.EmailText.ClassMgr.createEmailText(id,this);
    }

    public void removeEmailText(String id)
    {
        org.semanticwb.pymtur.EmailText.ClassMgr.removeEmailText(id, this);
    }
    public boolean hasEmailText(String id)
    {
        return org.semanticwb.pymtur.EmailText.ClassMgr.hasEmailText(id, this);
    }

    public org.semanticwb.pymtur.Paquete getPaquete(String id)
    {
        return org.semanticwb.pymtur.Paquete.ClassMgr.getPaquete(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.Paquete> listPaquetes()
    {
        return org.semanticwb.pymtur.Paquete.ClassMgr.listPaquetes(this);
    }

    public org.semanticwb.pymtur.Paquete createPaquete(String id)
    {
        return org.semanticwb.pymtur.Paquete.ClassMgr.createPaquete(id,this);
    }

    public void removePaquete(String id)
    {
        org.semanticwb.pymtur.Paquete.ClassMgr.removePaquete(id, this);
    }
    public boolean hasPaquete(String id)
    {
        return org.semanticwb.pymtur.Paquete.ClassMgr.hasPaquete(id, this);
    }

    public org.semanticwb.pymtur.UnActivationReason getUnActivationReason(String id)
    {
        return org.semanticwb.pymtur.UnActivationReason.ClassMgr.getUnActivationReason(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.UnActivationReason> listUnActivationReasons()
    {
        return org.semanticwb.pymtur.UnActivationReason.ClassMgr.listUnActivationReasons(this);
    }

    public org.semanticwb.pymtur.UnActivationReason createUnActivationReason(String id)
    {
        return org.semanticwb.pymtur.UnActivationReason.ClassMgr.createUnActivationReason(id,this);
    }

    public org.semanticwb.pymtur.UnActivationReason createUnActivationReason()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_UnActivationReason);
        return org.semanticwb.pymtur.UnActivationReason.ClassMgr.createUnActivationReason(String.valueOf(id),this);
    } 

    public void removeUnActivationReason(String id)
    {
        org.semanticwb.pymtur.UnActivationReason.ClassMgr.removeUnActivationReason(id, this);
    }
    public boolean hasUnActivationReason(String id)
    {
        return org.semanticwb.pymtur.UnActivationReason.ClassMgr.hasUnActivationReason(id, this);
    }

    public org.semanticwb.pymtur.RemoveReason getRemoveReason(String id)
    {
        return org.semanticwb.pymtur.RemoveReason.ClassMgr.getRemoveReason(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.RemoveReason> listRemoveReasons()
    {
        return org.semanticwb.pymtur.RemoveReason.ClassMgr.listRemoveReasons(this);
    }

    public org.semanticwb.pymtur.RemoveReason createRemoveReason(String id)
    {
        return org.semanticwb.pymtur.RemoveReason.ClassMgr.createRemoveReason(id,this);
    }

    public org.semanticwb.pymtur.RemoveReason createRemoveReason()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_RemoveReason);
        return org.semanticwb.pymtur.RemoveReason.ClassMgr.createRemoveReason(String.valueOf(id),this);
    } 

    public void removeRemoveReason(String id)
    {
        org.semanticwb.pymtur.RemoveReason.ClassMgr.removeRemoveReason(id, this);
    }
    public boolean hasRemoveReason(String id)
    {
        return org.semanticwb.pymtur.RemoveReason.ClassMgr.hasRemoveReason(id, this);
    }

    public org.semanticwb.portal.community.MicroSiteWebPageUtil getMicroSiteWebPageUtil(String id)
    {
        return org.semanticwb.portal.community.MicroSiteWebPageUtil.ClassMgr.getMicroSiteWebPageUtil(id, this);
    }

    public java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtils()
    {
        return org.semanticwb.portal.community.MicroSiteWebPageUtil.ClassMgr.listMicroSiteWebPageUtils(this);
    }

    public org.semanticwb.portal.community.MicroSiteWebPageUtil createMicroSiteWebPageUtil(String id)
    {
        return org.semanticwb.portal.community.MicroSiteWebPageUtil.ClassMgr.createMicroSiteWebPageUtil(id,this);
    }

    public void removeMicroSiteWebPageUtil(String id)
    {
        org.semanticwb.portal.community.MicroSiteWebPageUtil.ClassMgr.removeMicroSiteWebPageUtil(id, this);
    }
    public boolean hasMicroSiteWebPageUtil(String id)
    {
        return org.semanticwb.portal.community.MicroSiteWebPageUtil.ClassMgr.hasMicroSiteWebPageUtil(id, this);
    }

    public org.semanticwb.pymtur.EventType getEventType(String id)
    {
        return org.semanticwb.pymtur.EventType.ClassMgr.getEventType(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.EventType> listEventTypes()
    {
        return org.semanticwb.pymtur.EventType.ClassMgr.listEventTypes(this);
    }

    public org.semanticwb.pymtur.EventType createEventType(String id)
    {
        return org.semanticwb.pymtur.EventType.ClassMgr.createEventType(id,this);
    }

    public void removeEventType(String id)
    {
        org.semanticwb.pymtur.EventType.ClassMgr.removeEventType(id, this);
    }
    public boolean hasEventType(String id)
    {
        return org.semanticwb.pymtur.EventType.ClassMgr.hasEventType(id, this);
    }

    public org.semanticwb.pymtur.VariantPaqTemplate getVariantPaqTemplate(String id)
    {
        return org.semanticwb.pymtur.VariantPaqTemplate.ClassMgr.getVariantPaqTemplate(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.VariantPaqTemplate> listVariantPaqTemplates()
    {
        return org.semanticwb.pymtur.VariantPaqTemplate.ClassMgr.listVariantPaqTemplates(this);
    }

    public org.semanticwb.pymtur.VariantPaqTemplate createVariantPaqTemplate(String id)
    {
        return org.semanticwb.pymtur.VariantPaqTemplate.ClassMgr.createVariantPaqTemplate(id,this);
    }

    public void removeVariantPaqTemplate(String id)
    {
        org.semanticwb.pymtur.VariantPaqTemplate.ClassMgr.removeVariantPaqTemplate(id, this);
    }
    public boolean hasVariantPaqTemplate(String id)
    {
        return org.semanticwb.pymtur.VariantPaqTemplate.ClassMgr.hasVariantPaqTemplate(id, this);
    }

    public org.semanticwb.pymtur.SPType getSPType(String id)
    {
        return org.semanticwb.pymtur.SPType.ClassMgr.getSPType(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.SPType> listSPTypes()
    {
        return org.semanticwb.pymtur.SPType.ClassMgr.listSPTypes(this);
    }

    public org.semanticwb.pymtur.SPType createSPType(String id)
    {
        return org.semanticwb.pymtur.SPType.ClassMgr.createSPType(id,this);
    }

    public void removeSPType(String id)
    {
        org.semanticwb.pymtur.SPType.ClassMgr.removeSPType(id, this);
    }
    public boolean hasSPType(String id)
    {
        return org.semanticwb.pymtur.SPType.ClassMgr.hasSPType(id, this);
    }

    public org.semanticwb.pymtur.Destination getDestination(String id)
    {
        return org.semanticwb.pymtur.Destination.ClassMgr.getDestination(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinations()
    {
        return org.semanticwb.pymtur.Destination.ClassMgr.listDestinations(this);
    }

    public org.semanticwb.pymtur.Destination createDestination(String id)
    {
        return org.semanticwb.pymtur.Destination.ClassMgr.createDestination(id,this);
    }

    public void removeDestination(String id)
    {
        org.semanticwb.pymtur.Destination.ClassMgr.removeDestination(id, this);
    }
    public boolean hasDestination(String id)
    {
        return org.semanticwb.pymtur.Destination.ClassMgr.hasDestination(id, this);
    }

    public org.semanticwb.pymtur.InteresLink getInteresLink(String id)
    {
        return org.semanticwb.pymtur.InteresLink.ClassMgr.getInteresLink(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.InteresLink> listInteresLinks()
    {
        return org.semanticwb.pymtur.InteresLink.ClassMgr.listInteresLinks(this);
    }

    public org.semanticwb.pymtur.InteresLink createInteresLink(String id)
    {
        return org.semanticwb.pymtur.InteresLink.ClassMgr.createInteresLink(id,this);
    }

    public org.semanticwb.pymtur.InteresLink createInteresLink()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_InteresLink);
        return org.semanticwb.pymtur.InteresLink.ClassMgr.createInteresLink(String.valueOf(id),this);
    } 

    public void removeInteresLink(String id)
    {
        org.semanticwb.pymtur.InteresLink.ClassMgr.removeInteresLink(id, this);
    }
    public boolean hasInteresLink(String id)
    {
        return org.semanticwb.pymtur.InteresLink.ClassMgr.hasInteresLink(id, this);
    }

    public org.semanticwb.pymtur.Service getService(String id)
    {
        return org.semanticwb.pymtur.Service.ClassMgr.getService(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.Service> listServices()
    {
        return org.semanticwb.pymtur.Service.ClassMgr.listServices(this);
    }

    public org.semanticwb.pymtur.Service createService(String id)
    {
        return org.semanticwb.pymtur.Service.ClassMgr.createService(id,this);
    }

    public org.semanticwb.pymtur.Service createService()
    {
        long id=getSemanticObject().getModel().getCounter(pymtur_Service);
        return org.semanticwb.pymtur.Service.ClassMgr.createService(String.valueOf(id),this);
    } 

    public void removeService(String id)
    {
        org.semanticwb.pymtur.Service.ClassMgr.removeService(id, this);
    }
    public boolean hasService(String id)
    {
        return org.semanticwb.pymtur.Service.ClassMgr.hasService(id, this);
    }

    public org.semanticwb.pymtur.SPCategory getSPCategory(String id)
    {
        return org.semanticwb.pymtur.SPCategory.ClassMgr.getSPCategory(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.SPCategory> listSPCategories()
    {
        return org.semanticwb.pymtur.SPCategory.ClassMgr.listSPCategories(this);
    }

    public org.semanticwb.pymtur.SPCategory createSPCategory(String id)
    {
        return org.semanticwb.pymtur.SPCategory.ClassMgr.createSPCategory(id,this);
    }

    public void removeSPCategory(String id)
    {
        org.semanticwb.pymtur.SPCategory.ClassMgr.removeSPCategory(id, this);
    }
    public boolean hasSPCategory(String id)
    {
        return org.semanticwb.pymtur.SPCategory.ClassMgr.hasSPCategory(id, this);
    }

    public org.semanticwb.pymtur.State getState(String id)
    {
        return org.semanticwb.pymtur.State.ClassMgr.getState(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.State> listStates()
    {
        return org.semanticwb.pymtur.State.ClassMgr.listStates(this);
    }

    public org.semanticwb.pymtur.State createState(String id)
    {
        return org.semanticwb.pymtur.State.ClassMgr.createState(id,this);
    }

    public void removeState(String id)
    {
        org.semanticwb.pymtur.State.ClassMgr.removeState(id, this);
    }
    public boolean hasState(String id)
    {
        return org.semanticwb.pymtur.State.ClassMgr.hasState(id, this);
    }

    public org.semanticwb.pymtur.Bank getBank(String id)
    {
        return org.semanticwb.pymtur.Bank.ClassMgr.getBank(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.Bank> listBanks()
    {
        return org.semanticwb.pymtur.Bank.ClassMgr.listBanks(this);
    }

    public org.semanticwb.pymtur.Bank createBank(String id)
    {
        return org.semanticwb.pymtur.Bank.ClassMgr.createBank(id,this);
    }

    public void removeBank(String id)
    {
        org.semanticwb.pymtur.Bank.ClassMgr.removeBank(id, this);
    }
    public boolean hasBank(String id)
    {
        return org.semanticwb.pymtur.Bank.ClassMgr.hasBank(id, this);
    }

    public org.semanticwb.pymtur.ActivityType getActivityType(String id)
    {
        return org.semanticwb.pymtur.ActivityType.ClassMgr.getActivityType(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.ActivityType> listActivityTypes()
    {
        return org.semanticwb.pymtur.ActivityType.ClassMgr.listActivityTypes(this);
    }

    public org.semanticwb.pymtur.ActivityType createActivityType(String id)
    {
        return org.semanticwb.pymtur.ActivityType.ClassMgr.createActivityType(id,this);
    }

    public void removeActivityType(String id)
    {
        org.semanticwb.pymtur.ActivityType.ClassMgr.removeActivityType(id, this);
    }
    public boolean hasActivityType(String id)
    {
        return org.semanticwb.pymtur.ActivityType.ClassMgr.hasActivityType(id, this);
    }

    public org.semanticwb.pymtur.Activity getActivity(String id)
    {
        return org.semanticwb.pymtur.Activity.ClassMgr.getActivity(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.Activity> listActivities()
    {
        return org.semanticwb.pymtur.Activity.ClassMgr.listActivities(this);
    }

    public org.semanticwb.pymtur.Activity createActivity(String id)
    {
        return org.semanticwb.pymtur.Activity.ClassMgr.createActivity(id,this);
    }

    public void removeActivity(String id)
    {
        org.semanticwb.pymtur.Activity.ClassMgr.removeActivity(id, this);
    }
    public boolean hasActivity(String id)
    {
        return org.semanticwb.pymtur.Activity.ClassMgr.hasActivity(id, this);
    }
}
