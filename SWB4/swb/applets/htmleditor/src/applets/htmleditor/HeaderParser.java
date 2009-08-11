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
 


package applets.htmleditor;

/* This is useful for the nightmare of parsing multi-part HTTP/RFC822 headers
 * sensibly:
 * From a String like: 'timeout=15, max=5'
 * create an array of Strings:
 * { {"timeout", "15"},
 *   {"max", "5"}
 * }
 * From one like: 'Basic Realm="FuzzFace" Foo="Biz Bar Baz"'
 * create one like (no quotes in literal):
 * { {"basic", null},
 *   {"realm", "FuzzFace"}
 *   {"foo", "Biz Bar Baz"}
 * }
 * keys are converted to lower case, vals are left as is....
 *
 * author Dave Brown
 */


public class HeaderParser
{
    
    /* table of key/val pairs - maxes out at 10!!!!*/
    String raw;
    String[][] tab;
    
    public HeaderParser(String raw)
    {
        this.raw = raw;
        tab = new String[10][2];
        parse();
    }
    
    private void parse()
    {
        
        if (raw != null)
        {
            raw = raw.trim();
            char[] ca = raw.toCharArray();
            int beg = 0, end = 0, i = 0;
            boolean inKey = true;
            boolean inQuote = false;
            int len = ca.length;
            while (end < len)
            {
                char c = ca[end];
                if (c == '=')
                { // end of a key
                    tab[i][0] = new String(ca, beg, end-beg).toLowerCase();
                    inKey = false;
                    end++;
                    beg = end;
                } else if (c == '\"')
                {
                    if (inQuote)
                    {
                        tab[i++][1]= new String(ca, beg, end-beg);
                        inQuote=false;
                        do
                        {
                            end++;
                        } while (end < len && (ca[end] == ' ' || ca[end] == ','));
                        inKey=true;
                        beg=end;
                    } else
                    {
                        inQuote=true;
                        end++;
                        beg=end;
                    }
                } else if (c == ' ' || c == ',')
                { // end key/val, of whatever we're in
                    if (inQuote)
                    {
                        end++;
                        continue;
                    } else if (inKey)
                    {
                        tab[i++][0] = (new String(ca, beg, end-beg)).toLowerCase();
                    } else
                    {
                        tab[i++][1] = (new String(ca, beg, end-beg));
                    }
                    while (end < len && (ca[end] == ' ' || ca[end] == ','))
                    {
                        end++;
                    }
                    inKey = true;
                    beg = end;
                } else
                {
                    end++;
                }
            }
            // get last key/val, if any
            if (--end > beg)
            {
                if (!inKey)
                {
                    if (ca[end] == '\"')
                    {
                        tab[i++][1] = (new String(ca, beg, end-beg));
                    } else
                    {
                        tab[i++][1] = (new String(ca, beg, end-beg+1));
                    }
                } else
                {
                    tab[i][0] = (new String(ca, beg, end-beg+1)).toLowerCase();
                }
            } else if (end == beg)
            {
                if (!inKey)
                {
                    if (ca[end] == '\"')
                    {
                        tab[i++][1] = String.valueOf(ca[end-1]);
                    } else
                    {
                        tab[i++][1] = String.valueOf(ca[end]);
                    }
                } else
                {
                    tab[i][0] = String.valueOf(ca[end]).toLowerCase();
                }
            }
        }
        
    }
    
    public String findKey(int i)
    {
        if (i < 0 || i > 10)
            return null;
        return tab[i][0];
    }
    
    public String findValue(int i)
    {
        if (i < 0 || i > 10)
            return null;
        return tab[i][1];
    }
    
    public String findValue(String key)
    {
        return findValue(key, null);
    }
    
    public String findValue(String k, String Default)
    {
        if (k == null)
            return Default;
        k.toLowerCase();
        for (int i = 0; i < 10; ++i)
        {
            if (tab[i][0] == null)
            {
                return Default;
            } else if (k.equals(tab[i][0]))
            {
                return tab[i][1];
            }
        }
        return Default;
    }
    
    public int findInt(String k, int Default)
    {
        try
        {
            return Integer.parseInt(findValue(k, String.valueOf(Default)));
        } catch (Throwable t)
        {
            return Default;
        }
    }
}




