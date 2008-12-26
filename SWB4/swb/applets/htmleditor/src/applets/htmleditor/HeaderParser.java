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




