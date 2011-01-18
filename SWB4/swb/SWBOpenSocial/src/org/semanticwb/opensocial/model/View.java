/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.opensocial.model;

import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author victor.lorenzana
 */
public class View {
    private String name="default";
    private int preferredHeight;
    private String type="html";
    private boolean scrolling;
    private int preferredWidth;
    private String content;
    private URL urlcontent;
    public View(String name)
    {
        this.name=name;
    }
    public void setContent(String  content)
    {
        this.content=content;
    }
    public String getContent()
    {
        return content;
    }
    public URL getUrlcontent()
    {
        return urlcontent;
    }
    public void setType(String  type)
    {
        this.type=type;
    }
    public void setUrlContent(URL  urlcontent)
    {
        this.urlcontent=urlcontent;
    }
    public void setScrolling(boolean scrolling)
    {
        this.scrolling=scrolling;
    }
    public void setPreferredWidth(int preferredWidth)
    {
        this.preferredWidth=preferredWidth;
    }
    public void setPreferredHeight(int preferredHeight)
    {
        this.preferredHeight=preferredHeight;
    }
    public String getName()
    {
        return name;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final View other = (View) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 89 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }


    public JSONObject toJSONObject()
    {        
        JSONObject content=new JSONObject();
        try
        {
            content.put("preferredHeight", preferredHeight);
            content.put("type", type);
            content.put("quirks", scrolling);
            content.put("preferredWidth", preferredWidth);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content;
    }
}
