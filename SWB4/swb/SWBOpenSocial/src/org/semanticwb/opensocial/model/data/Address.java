package org.semanticwb.opensocial.model.data;

import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.opensocial.util.Scape;


public class Address extends org.semanticwb.opensocial.model.data.base.AddressBase implements JSONConvertible
{
    public Address(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public JSONObject toJSONObject(Scape scape)
    {
        JSONObject obj=new JSONObject();
        try
        {
            obj.put("formatted", scape.scape(this.getFormatted()));
        }
        catch(JSONException jse)
        {
            jse.printStackTrace();
        }
        return obj;
    }

    @Override
    public String toString()
    {
        if(this.getFormatted()!=null)
        {
            return this.getFormatted();
        }
        return super.toString();
    }
}
