package org.semanticwb.pymtur.base;


public abstract class PyMesWebSiteBase extends org.semanticwb.model.WebSite implements org.semanticwb.model.FilterableClass,org.semanticwb.model.FilterableNode,org.semanticwb.model.Trashable,org.semanticwb.model.Filterable,org.semanticwb.model.Localeable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Indexable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Activeable
{
    public static final org.semanticwb.platform.SemanticClass swbcomm_MicroSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#MicroSite");
    public static final org.semanticwb.platform.SemanticClass pymtur_MiPymeSitePlus=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymeSitePlus");
    public static final org.semanticwb.platform.SemanticClass pymtur_Nearest=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Nearest");
    public static final org.semanticwb.platform.SemanticClass pymtur_MiPymeSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymeSite");
    public static final org.semanticwb.platform.SemanticClass pymtur_TourismType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#TourismType");
    public static final org.semanticwb.platform.SemanticClass pymtur_Instalation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Instalation");
    public static final org.semanticwb.platform.SemanticClass pymtur_Hospedaje=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Hospedaje");
    public static final org.semanticwb.platform.SemanticClass pymtur_Experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Experience");
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
    public static final org.semanticwb.platform.SemanticClass pymtur_Region=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Region");
    public static final org.semanticwb.platform.SemanticClass pymtur_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Event");
    public static final org.semanticwb.platform.SemanticClass pymtur_RFCable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RFCable");
    public static final org.semanticwb.platform.SemanticClass pymtur_RfcType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RfcType");
    public static final org.semanticwb.platform.SemanticClass swbcomm_MicroSiteWebPageUtil=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#MicroSiteWebPageUtil");
    public static final org.semanticwb.platform.SemanticClass pymtur_EventType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#EventType");
    public static final org.semanticwb.platform.SemanticClass pymtur_SPType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#SPType");
    public static final org.semanticwb.platform.SemanticClass pymtur_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Destination");
    public static final org.semanticwb.platform.SemanticClass pymtur_Service=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Service");
    public static final org.semanticwb.platform.SemanticClass pymtur_SPCategory=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#SPCategory");
    public static final org.semanticwb.platform.SemanticClass pymtur_State=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#State");
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

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByLanguage(org.semanticwb.model.Language language,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_language, language.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByLanguage(org.semanticwb.model.Language language)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(language.getSemanticObject().getModel().listSubjects(swb_language,language.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteBySubModel(org.semanticwb.model.SWBModel hassubmodel,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasSubModel, hassubmodel.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteBySubModel(org.semanticwb.model.SWBModel hassubmodel)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(hassubmodel.getSemanticObject().getModel().listSubjects(swb_hasSubModel,hassubmodel.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByModifiedBy(org.semanticwb.model.User modifiedby)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByParentWebSite(org.semanticwb.model.WebSite parentwebsite,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_parentWebSite, parentwebsite.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByParentWebSite(org.semanticwb.model.WebSite parentwebsite)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(parentwebsite.getSemanticObject().getModel().listSubjects(swb_parentWebSite,parentwebsite.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByUserRepository(org.semanticwb.model.UserRepository userrepository,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_userRepository, userrepository.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByUserRepository(org.semanticwb.model.UserRepository userrepository)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(userrepository.getSemanticObject().getModel().listSubjects(swb_userRepository,userrepository.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByCreator(org.semanticwb.model.User creator)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByHomePage(org.semanticwb.model.WebPage homepage,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_homePage, homepage.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByHomePage(org.semanticwb.model.WebPage homepage)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(homepage.getSemanticObject().getModel().listSubjects(swb_homePage,homepage.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByDefaultTemplate(org.semanticwb.model.Template defaulttemplate,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_defaultTemplate, defaulttemplate.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.PyMesWebSite> listPyMesWebSiteByDefaultTemplate(org.semanticwb.model.Template defaulttemplate)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PyMesWebSite> it=new org.semanticwb.model.GenericIterator(defaulttemplate.getSemanticObject().getModel().listSubjects(swb_defaultTemplate,defaulttemplate.getSemanticObject()));
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

    public org.semanticwb.pymtur.RFCable getRFCable(String id)
    {
        return org.semanticwb.pymtur.RFCable.ClassMgr.getRFCable(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.RFCable> listRFCables()
    {
        return org.semanticwb.pymtur.RFCable.ClassMgr.listRFCables(this);
    }

    public org.semanticwb.pymtur.RFCable createRFCable(String id)
    {
        return org.semanticwb.pymtur.RFCable.ClassMgr.createRFCable(id,this);
    }

    public void removeRFCable(String id)
    {
        org.semanticwb.pymtur.RFCable.ClassMgr.removeRFCable(id, this);
    }
    public boolean hasRFCable(String id)
    {
        return org.semanticwb.pymtur.RFCable.ClassMgr.hasRFCable(id, this);
    }

    public org.semanticwb.pymtur.RfcType getRfcType(String id)
    {
        return org.semanticwb.pymtur.RfcType.ClassMgr.getRfcType(id, this);
    }

    public java.util.Iterator<org.semanticwb.pymtur.RfcType> listRfcTypes()
    {
        return org.semanticwb.pymtur.RfcType.ClassMgr.listRfcTypes(this);
    }

    public org.semanticwb.pymtur.RfcType createRfcType(String id)
    {
        return org.semanticwb.pymtur.RfcType.ClassMgr.createRfcType(id,this);
    }

    public void removeRfcType(String id)
    {
        org.semanticwb.pymtur.RfcType.ClassMgr.removeRfcType(id, this);
    }
    public boolean hasRfcType(String id)
    {
        return org.semanticwb.pymtur.RfcType.ClassMgr.hasRfcType(id, this);
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
