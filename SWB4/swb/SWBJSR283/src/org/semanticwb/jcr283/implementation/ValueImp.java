/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.jcr283.implementation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.jcr.Binary;
import javax.jcr.Node;
import javax.jcr.PropertyType;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.ValueFormatException;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;

/**
 *
 * @author victor.lorenzana
 */
public class ValueImp implements Value
{

    static Logger log = SWBUtils.getLogger(ValueImp.class);
    private static SimpleDateFormat iso8601dateFormat =  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private final int type;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Object value;

    ValueImp(Object value, int type)
    {
        this.type = type;

        if (value instanceof InputStream)
        {
            byte[] buffer = new byte[2048];
            InputStream in = (InputStream) value;
            try
            {
                int read = in.read(buffer);
                while (read != -1)
                {
                    out.write(buffer, 0, read);
                    read = in.read(buffer);
                }
                this.value = out;
            }
            catch (IOException ioe)
            {
                throw new IllegalArgumentException(ioe);
            }

        }
        else
        {
            this.value = value;
        }
    }

    public String getString() throws ValueFormatException, IllegalStateException, RepositoryException
    {
        if (value == null)
        {
            return null;
        }
        String valueString = value.toString();
        if (value instanceof Node && type == PropertyType.REFERENCE)
        {
            valueString = ((Node) value).getUUID();
        }
        if (value instanceof Calendar)
        {
            //valueString = iso8601dateFormat.format(((Calendar) value).getTime());
            valueString = SWBUtils.TEXT.iso8601DateFormat(((Calendar) value).getTime());
        }
        return valueString;
    }

    public InputStream getStream() throws IllegalStateException, RepositoryException
    {
        if (value == null)
        {
            return null;
        }
        if (value instanceof ByteArrayOutputStream && type == PropertyType.BINARY)
        {
            ByteArrayOutputStream mout=(ByteArrayOutputStream)value;
            return new ByteArrayInputStream(mout.toByteArray());
        }
        return null;
    }

    public long getLong() throws ValueFormatException, IllegalStateException, RepositoryException
    {
        if (value == null)
        {
            throw new ValueFormatException();
        }
        try
        {
            return Long.parseLong(value.toString());
        }
        catch (NumberFormatException nfe)
        {
            throw new ValueFormatException(nfe);
        }
    }

    public double getDouble() throws ValueFormatException, IllegalStateException, RepositoryException
    {
        if (value == null)
        {
            throw new ValueFormatException();
        }
        try
        {
            return Double.parseDouble(value.toString());
        }
        catch (NumberFormatException nfe)
        {
            throw new ValueFormatException(nfe);
        }
    }

    public Calendar getDate() throws ValueFormatException, IllegalStateException, RepositoryException
    {
        if (value == null)
        {
            return null;
        }
        Calendar calendar = null;
        if (type == PropertyType.DATE && value instanceof Calendar)
        {
            calendar = (Calendar) value;
        }
        else
        {
            String stringDate = getString();
            try
            {
                Date date = SWBUtils.TEXT.iso8601DateParse(stringDate);
                calendar = Calendar.getInstance();
                calendar.setTime(date);
            }
            catch (ParseException pe)
            {
                try
                {
                    Date date = iso8601dateFormat.parse(stringDate);
                    calendar = Calendar.getInstance();
                    calendar.setTime(date);
                }
                catch(ParseException pe2)
                {
                    throw new ValueFormatException(pe);
                }
            }
        }
        return calendar;
    }

    public boolean getBoolean() throws ValueFormatException, IllegalStateException, RepositoryException
    {
        if (value == null)
        {
            throw new ValueFormatException();
        }
        try
        {
            return Boolean.parseBoolean(value.toString());
        }
        catch (NumberFormatException nfe)
        {
            throw new ValueFormatException(nfe);
        }
    }

    public int getType()
    {
        return type;
    }

    public Binary getBinary() throws RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public BigDecimal getDecimal() throws ValueFormatException, RepositoryException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
