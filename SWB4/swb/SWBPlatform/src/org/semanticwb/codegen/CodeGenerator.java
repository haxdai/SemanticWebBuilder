/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.codegen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.semanticwb.Logger;
import org.semanticwb.SWBContext;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Topic;
import org.semanticwb.model.TopicClass;
import org.semanticwb.model.TopicProperty;
import org.semanticwb.platform.SemanticMgr;

/**
 *
 * @author Victor Lorenzana
 */
public class CodeGenerator
{

    private static Logger log = SWBUtils.getLogger(Topic.class);
    private File m_Directory;
    private String m_Package;

    public CodeGenerator(File pDirectory, String pPackage)
    {
        this(pDirectory);
        this.m_Package = pPackage;

    }

    public CodeGenerator(File pDirectory)
    {
        if ( pDirectory.exists() && pDirectory.isFile() )
        {
            throw new IllegalArgumentException("The path " + pDirectory.getPath() + " is not a directory");
        }
        this.m_Directory = pDirectory;
    }

    private String getPackage(TopicClass tpc)
    {
        StringBuilder sPackage = new StringBuilder();
        try
        {
            URI uri = new URI(tpc.getURI());
            sPackage.append(uri.getHost());
        }
        catch ( URISyntaxException use )
        {
            log.error(use);
        }
        return sPackage.toString();
    }

    private File createPackage() throws CodeGeneratorException
    {
        if ( !this.m_Package.equals("") )
        {
            File dir = new File(this.m_Directory.getPath() + File.separatorChar + this.m_Package.replace('.', File.separatorChar));
            if ( !dir.exists() && !dir.mkdirs() )
            {
                throw new CodeGeneratorException("The directory " + dir.getPath() + " was not possible to create");
            }
            return dir;
        }
        return this.m_Directory;
    }

    private void saveFile(File file, String code) throws CodeGeneratorException
    {
        try
        {
            FileOutputStream out = new FileOutputStream(file);
            out.write(code.getBytes());
            out.close();
        }
        catch ( IOException ioe )
        {
            throw new CodeGeneratorException("The File " + file.getPath() + " was not possible to create", ioe);
        }
    }

    private void createClass(TopicClass tpc) throws CodeGeneratorException
    {
        if ( m_Package == null )
        {
            m_Package = getPackage(tpc);
        }
        File dir = createPackage();
        StringBuilder javaClassContent = new StringBuilder();
        if ( !m_Package.equals("") )
        {
            javaClassContent.append("package " + m_Package + ";\r\n");
            javaClassContent.append("\r\n");
        }
        javaClassContent.append("import java.util.Date;\r\n");
        javaClassContent.append("import org.semanticwb.SWBContext;\r\n");
        javaClassContent.append("import org.semanticwb.model.Topic;\r\n");
        javaClassContent.append("import com.hp.hpl.jena.rdf.model.Resource;\r\n");
        javaClassContent.append("import java.util.Collection;\r\n");
        javaClassContent.append("\r\n");
        javaClassContent.append("public class " + tpc.getName() + " extends Topic\r\n");
        javaClassContent.append("{\r\n");
        javaClassContent.append("    public " + tpc.getName() + "(Resource res)\r\n");
        javaClassContent.append("    {\r\n");
        javaClassContent.append("        super(res);\r\n");
        javaClassContent.append("    }\r\n");
        insertProperties(tpc, javaClassContent);
        javaClassContent.append("}\r\n");
        File fileClass = new File(dir.getPath() + File.separatorChar + tpc.getName() + ".java");
        saveFile(fileClass, javaClassContent.toString());

    }

    private static String toUpperCase(String data)
    {
        String letter = data.substring(0, 1);
        return letter.toUpperCase() + data.substring(1);
    }

    private void insertProperties(TopicClass tpc, StringBuilder javaClassContent)
    {
        Iterator<TopicProperty> tppit = tpc.listProperties();
        while (tppit.hasNext())
        {
            TopicProperty tpp = tppit.next();
            if ( tpp.isObjectProperty() )
            {
                if ( tpp.getRangeClass() != null && tpp.getRangeClass().getURI() != null )
                {
                    try
                    {
                        URI uri = new URI(tpp.getRangeClass().getURI());
                        String objectName=uri.getFragment();
                        /*if(objectName.startsWith("has"))
                        {
                            objectName=objectName.substring(3);
                        }*/
                        objectName = toUpperCase(objectName);
                        javaClassContent.append("    public Collection<"+ objectName +"> list" + objectName + "()\r\n");
                        javaClassContent.append("    {\r\n");
                        javaClassContent.append("    }\r\n");
                        
                        
                        javaClassContent.append("    public void add"+objectName+"("+objectName+" "+objectName.toLowerCase()+")\r\n");
                        javaClassContent.append("    {\r\n");
                        javaClassContent.append("    }\r\n");
                        
                        javaClassContent.append("    public void removeAll"+objectName+"()\r\n");
                        javaClassContent.append("    {\r\n");
                        javaClassContent.append("    }\r\n");
    
                        javaClassContent.append("    public "+objectName+" get"+objectName+"()\r\n");
                        javaClassContent.append("    {\r\n");
                        javaClassContent.append("        return getProperty(SWBContext.getSemanticMgr().getVocabulary()." + tpp.getName() + ");\r\n");
                        javaClassContent.append("    }\r\n");
    
                    }
                    catch ( URISyntaxException usie )
                    {
                        log.error(usie);
                    }
                }
            }
            else if ( tpp.isDataTypeProperty() )
            {
                try
                {
                    URI uri = new URI(tpp.getRangeDataType().getURI());
                    String type = "void";
                    String prefix = "get";
                    if ( uri.getFragment().equals("string") )
                    {
                        type = "String";
                    }
                    else if ( uri.getFragment().equals("int") )
                    {
                        type = "int";
                    }
                    else if ( uri.getFragment().equals("int") )
                    {
                        type = "int";
                    }
                    else if ( uri.getFragment().equals("boolean") )
                    {
                        type = "boolean";
                        prefix = "is";
                    }
                    else if ( uri.getFragment().equals("dateTime") )
                    {
                        type = "Date";
                    }
                    else
                    {
                        type = "void";
                    }
                    String methodName = toUpperCase(tpp.getName());

                    javaClassContent.append("    public " + type + " " + prefix + methodName + "()\r\n");
                    javaClassContent.append("    {\r\n");
                    javaClassContent.append("        return getProperty(SWBContext.getSemanticMgr().getVocabulary()." + tpp.getName() + ");\r\n");
                    javaClassContent.append("    }\r\n");

                    javaClassContent.append("    public WebPage set" + methodName + "(" + type + " " + tpp.getName() + ")\r\n");
                    javaClassContent.append("    {\r\n");
                    javaClassContent.append("        setProperty(SWBContext.getSemanticMgr().getVocabulary()." + tpp.getName() + ", " + tpp.getName() + ");\r\n");
                    javaClassContent.append("    }\r\n");
                //out.println("-->DataTypeProp:" + tpp.getName() + "\t" + tpp.getRangeDataType());
                }
                catch ( URISyntaxException usie )
                {
                    log.error(usie);
                }
            }
        }
    }

    public void generateCode() throws CodeGeneratorException
    {
        if ( m_Directory.exists() && m_Directory.isFile() )
        {
            throw new CodeGeneratorException("The path " + m_Directory.getPath() + " is not a directory");
        }
        if ( !m_Directory.exists() )
        {
            if ( !m_Directory.mkdirs() )
            {
                throw new CodeGeneratorException("The path " + m_Directory.getPath() + " was not possible to create");
            }
        }
        SemanticMgr mgr = SWBContext.getSemanticMgr();
        Iterator<TopicClass> tpcit = mgr.getVocabulary().listTopicClasses();
        while (tpcit.hasNext())
        {
            TopicClass tpc = tpcit.next();
            createClass(tpc);
        }
        createVocabulary();
    }

    private void createVocabulary() throws CodeGeneratorException
    {
        StringBuilder javaClassContent = new StringBuilder();
        javaClassContent.append("package "+ m_Package +";\r\n\r\n");
        javaClassContent.append("import org.semanticwb.platform.SWBVocabulary;\r\n");
        javaClassContent.append("import org.semanticwb.model.TopicClass;\r\n");
        javaClassContent.append("import org.semanticwb.model.TopicProperty;\r\n\r\n");
        javaClassContent.append("public class Vocabulary extends SWBVocabulary\r\n");
        javaClassContent.append("{\r\n");
        javaClassContent.append("\r\n\r\n// Classes\r\n");
        SemanticMgr mgr = SWBContext.getSemanticMgr();
        Iterator<TopicClass> tpcit = mgr.getVocabulary().listTopicClasses();
        while (tpcit.hasNext())
        {
            TopicClass tpc = tpcit.next();
            javaClassContent.append("    public TopicClass " + tpc.getName() + ";\r\n");
        }

        
        javaClassContent.append("\r\n\r\n\r\n//Properties\r\n");
        HashSet<String> properties=new HashSet<String>();
        tpcit = mgr.getVocabulary().listTopicClasses();
        while (tpcit.hasNext())
        {
            TopicClass tpc = tpcit.next();
            Iterator<TopicProperty> tppit = tpc.listProperties();
            while (tppit.hasNext())
            {
                TopicProperty tpp = tppit.next();
                if(!properties.contains(tpp.getName()))
                {
                    properties.add(tpp.getName());
                    javaClassContent.append("    public TopicProperty " + tpp.getName() + ";\r\n");
                }
            }
        }

        
        javaClassContent.append("    @Override\r\n");
        javaClassContent.append("    public void init()\r\n");
        javaClassContent.append("    {\r\n");
        javaClassContent.append("\r\n\r\n        // Classes\r\n");
        tpcit = mgr.getVocabulary().listTopicClasses();
        while (tpcit.hasNext())
        {
            TopicClass tpc = tpcit.next();
            javaClassContent.append("        "+ tpc.getName() +"=getTopicClass(URI+\""+ tpc.getName() +"\");\r\n");
        }
                
        javaClassContent.append("\r\n\r\n\r\n        //Properties\r\n");
        tpcit = mgr.getVocabulary().listTopicClasses();
        while (tpcit.hasNext())
        {
            TopicClass tpc = tpcit.next();
            Iterator<TopicProperty> tppit = tpc.listProperties();
            while (tppit.hasNext())
            {
                TopicProperty tpp = tppit.next();
                javaClassContent.append("        "+ tpp.getName() +"=getTopicProperty(URI+\""+tpp.getName()+"\");\r\n");
            }
        }
        javaClassContent.append("    }\r\n");

        javaClassContent.append("}\r\n");
        File dir = createPackage();
        File fileClass = new File(dir.getPath() + File.separatorChar + "Vocabulary.java");
        saveFile(fileClass, javaClassContent.toString());
    }
}
