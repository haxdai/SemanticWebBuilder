/*
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
 */
package org.semanticwb.security;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class to contain instance security configuration values, to avoid been converting every request
 * @author serch
 */
public class SWBSecurityInstanceValues {
    private int minlength=0;
    private boolean differFromLogin=false;
    private int complexity=0;
    private boolean forceChage=false;
    private int expires=0;
    private int inactive=0;
    private int history=0;
    private boolean sendMail=false;
    private boolean restrict=false;
    private boolean multiple=false;
    private boolean encrypt=false;
    private String complexityExp="";
    private String complexityMsg="";
    private Map<String, LocalSecurityValues> localRepos = new HashMap<String, LocalSecurityValues>();

    public SWBSecurityInstanceValues(Properties props)
    {
        if (null!=props){
            try { minlength = Integer.parseInt(props.getProperty("password/minlength", "0")); } catch (Exception noe) {} //if fails go for default value
            try { differFromLogin = Boolean.parseBoolean(props.getProperty("password/differFromLogin", "false")); } catch (Exception noe) {} //if fails go for default value
            if ("simple".equalsIgnoreCase(props.getProperty("password/complexity", "none"))){complexity=1;}
            if ("complex".equalsIgnoreCase(props.getProperty("password/complexity", "none"))){complexity=2;}
            if ("custom".equalsIgnoreCase(props.getProperty("password/complexity", "none"))){complexity=3;}
            try { forceChage = Boolean.parseBoolean(props.getProperty("password/forceChangeOnFirstLogon", "false")); } catch (Exception noe) {} //if fails go for default value
            try { expires = Integer.parseInt(props.getProperty("password/expiresInDays", "0")); } catch (Exception noe) {} //if fails go for default value
            try { history = Integer.parseInt(props.getProperty("password/noAllowRepeat", "0")); } catch (Exception noe) {} //if fails go for default value
            try { inactive = Integer.parseInt(props.getProperty("account/inactiveInDays", "0")); } catch (Exception noe) {} //if fails go for default value
            try { sendMail = Boolean.parseBoolean(props.getProperty("account/sendMailOnLogon", "false")); } catch (Exception noe) {} //if fails go for default value
            try { restrict = Boolean.parseBoolean(props.getProperty("session/restrictToSingleIP", "false")); } catch (Exception noe) {} //if fails go for default value
            try { multiple = Boolean.parseBoolean(props.getProperty("session/restrictMultipleLogon", "false")); } catch (Exception noe) {} //if fails go for default value
            try { encrypt = Boolean.parseBoolean(props.getProperty("login/encryptData", "false")); } catch (Exception noe) {} //if fails go for default value
            complexityExp = props.getProperty("password/customExp", "");
            complexityMsg = props.getProperty("password/customMsg", "");
            Set<String> repos = new TreeSet();
            for(Object oKey: props.keySet()){
                String key = (String)oKey;
                int idx = key.indexOf(".");
                if (idx>-1){
                    repos.add(key.substring(0,idx));
                }
            }
            for(String repo: repos){
                LocalSecurityValues localsv = new LocalSecurityValues();
                localRepos.put(repo, localsv);
                try { localsv.minlength = Integer.parseInt(props.getProperty(repo+".password/minlength", ""+minlength)); } catch (Exception noe) {} //if fails go for default value
                try { localsv.differFromLogin = Boolean.parseBoolean(props.getProperty(repo+".password/differFromLogin", ""+differFromLogin)); } catch (Exception noe) {} //if fails go for default value
                if ("simple".equalsIgnoreCase(props.getProperty(repo+".password/complexity", "none"))){localsv.complexity=1;}
                if ("complex".equalsIgnoreCase(props.getProperty(repo+".password/complexity", "none"))){localsv.complexity=2;}
                if ("custom".equalsIgnoreCase(props.getProperty(repo+".password/complexity", "none"))){localsv.complexity=3;}
                if (localsv.complexity==0){localsv.complexity=complexity;}
                try { localsv.forceChage = Boolean.parseBoolean(props.getProperty(repo+".password/forceChangeOnFirstLogon", ""+forceChage)); } catch (Exception noe) {} //if fails go for default value
                try { localsv.expires = Integer.parseInt(props.getProperty(repo+".password/expiresInDays", ""+expires)); } catch (Exception noe) {} //if fails go for default value
                try { localsv.history = Integer.parseInt(props.getProperty(repo+".password/noAllowRepeat", ""+history)); } catch (Exception noe) {} //if fails go for default value
                try { localsv.inactive = Integer.parseInt(props.getProperty(repo+".account/inactiveInDays", ""+inactive)); } catch (Exception noe) {} //if fails go for default value
                try { localsv.sendMail = Boolean.parseBoolean(props.getProperty(repo+".account/sendMailOnLogon", ""+sendMail)); } catch (Exception noe) {} //if fails go for default value
                localsv.complexityExp = props.getProperty(repo+".password/customExp", complexityExp);
                localsv.complexityMsg = props.getProperty(repo+".password/customMsg", complexityMsg);
            }
        }
    }

    public int getComplexity(String userRepoId)
    {
        LocalSecurityValues localsv = localRepos.get(userRepoId);
        if(null!=localsv)return localsv.complexity;
        return complexity;
    }

    public boolean isDifferFromLogin(String userRepoId)
    {
        LocalSecurityValues localsv = localRepos.get(userRepoId);
        if(null!=localsv)return localsv.differFromLogin;
        return differFromLogin;
    }

    public boolean isEncrypt()
    {
        return encrypt;
    }

    public int getExpires(String userRepoId)
    {
        LocalSecurityValues localsv = localRepos.get(userRepoId);
        if(null!=localsv)return localsv.expires;
        return expires;
    }

    public boolean isForceChage(String userRepoId)
    {
        LocalSecurityValues localsv = localRepos.get(userRepoId);
        if(null!=localsv)return localsv.forceChage;
        return forceChage;
    }

    public int getInactive(String userRepoId)
    {
        LocalSecurityValues localsv = localRepos.get(userRepoId);
        if(null!=localsv)return localsv.inactive;
        return inactive;
    }

    public int getMinlength(String userRepoId)
    {
        LocalSecurityValues localsv = localRepos.get(userRepoId);
        if(null!=localsv)return localsv.minlength;
        return minlength;
    }

    public boolean isMultiple()
    {
        return multiple;
    }

    public boolean isRestrict()
    {
        return restrict;
    }

    public boolean isSendMail(String userRepoId)
    {
        LocalSecurityValues localsv = localRepos.get(userRepoId);
        if(null!=localsv)return localsv.sendMail;
        return sendMail;
    }

    public int getHistory(String userRepoId)
    {
        LocalSecurityValues localsv = localRepos.get(userRepoId);
        if(null!=localsv)return localsv.history;
        return history;
    }
    
    public String getCustomExp(String userRepoId)
    {
        LocalSecurityValues localsv = localRepos.get(userRepoId);
        if(null!=localsv)return localsv.complexityExp;
        return complexityExp;
    }
    
    public String getCustomMsg(String userRepoId)
    {
        LocalSecurityValues localsv = localRepos.get(userRepoId);
        if(null!=localsv)return localsv.complexityMsg;
        return complexityMsg;
    }
}

class LocalSecurityValues {
    int minlength=0;
    boolean differFromLogin=false;
    int complexity=0;
    boolean forceChage=false;
    int expires=0;
    int inactive=0;
    int history=0;
    boolean sendMail=false;
    String complexityExp="";
    String complexityMsg="";
}