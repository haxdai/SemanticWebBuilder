package org.semanticwb.model.base;

import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import org.semanticwb.model.base.GenericObjectBase;
import org.semanticwb.model.SWBVocabulary;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.*;
import com.hp.hpl.jena.rdf.model.*;
import org.semanticwb.*;
import org.semanticwb.platform.*;

public class TextAreaBase extends FormElementBase 
{
    public static SWBVocabulary vocabulary=SWBContext.getVocabulary();

    public TextAreaBase(SemanticObject base)
    {
        super(base);
    }

    public int getRows()
    {
        return getSemanticObject().getIntProperty(vocabulary.swbxf_textAreaRows);
    }

    public void setRows(int textAreaRows)
    {
        getSemanticObject().setLongProperty(vocabulary.swbxf_textAreaRows, textAreaRows);
    }

    public int getCols()
    {
        return getSemanticObject().getIntProperty(vocabulary.swbxf_textAreaCols);
    }

    public void setCols(int textAreaCols)
    {
        getSemanticObject().setLongProperty(vocabulary.swbxf_textAreaCols, textAreaCols);
    }

    public void remove()
    {
        getSemanticObject().remove();
    }

    public Iterator<GenericObject> listRelatedObjects()
    {
        return new GenericIterator((SemanticClass)null, getSemanticObject().listRelatedObjects(),true);
    }
}
