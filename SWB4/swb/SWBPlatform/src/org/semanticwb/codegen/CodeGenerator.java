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
package org.semanticwb.codegen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.platform.SemanticMgr;
import static org.semanticwb.SWBUtils.TEXT.*;
// TODO: Auto-generated Javadoc
/**
 * The Class CodeGenerator.
 * 
 * @author Victor Lorenzana
 */
public class CodeGenerator
{
    
    /** The Constant SEMANTIC_ITERATOR_FULL_NAME. */
    private static final String SEMANTIC_ITERATOR_FULL_NAME="org.semanticwb.platform.SemanticIterator";
    
    /** The Constant MODEL_FULL_NAME. */
    private static final String MODEL_FULL_NAME = "org.semanticwb.platform.SemanticModel";
    
    /** The Constant SEMANTIC_MANANGER_FULL_NAME. */
    private static final String SEMANTIC_MANANGER_FULL_NAME = "org.semanticwb.platform.SemanticMgr";
    
    /** The Constant SEMANTIC_MODEL_FULL_NAME. */
    private static final String SEMANTIC_MODEL_FULL_NAME = "org.semanticwb.model.SWBModel";
    
    /** The Constant SEMANTIC_PROPERTY_FULL_NAME. */
    private static final String SEMANTIC_PROPERTY_FULL_NAME = "org.semanticwb.platform.SemanticProperty";
    
    /** The Constant GET_SEMANTIC_CLASS. */
    private static final String GET_SEMANTIC_CLASS = ".getSemanticMgr().getVocabulary().getSemanticClass(\"";
    
    /** The Constant SEMANTIC_PLATFORM_FULL_NAME. */
    private static final String SEMANTIC_PLATFORM_FULL_NAME="org.semanticwb.SWBPlatform";
    
    /** The Constant GENERIC_ITERATOR_FULL_NAME. */
    private static final String GENERIC_ITERATOR_FULL_NAME="org.semanticwb.model.GenericIterator";
    
    /** The Constant SEMANTIC_LITERAL_FULL_NAME. */
    private static final String SEMANTIC_LITERAL_FULL_NAME="org.semanticwb.platform.SemanticLiteral";

    /** The Constant UTIL_ITERATOR_FULL_NAME. */
    private static final String UTIL_ITERATOR_FULL_NAME="java.util.Iterator";
    
    /** The Constant GENERIC_OBJECT_FULL_NAME. */
    private static final String GENERIC_OBJECT_FULL_NAME="org.semanticwb.model.GenericObject";
    
    /** The Constant JENA_ITERATOR_FULL_NAME. */
    private static final String JENA_ITERATOR_FULL_NAME="com.hp.hpl.jena.rdf.model.StmtIterator";
    
    /** The Constant SEMANTIC_OBJECT_FULL_NAME. */
    private static final String SEMANTIC_OBJECT_FULL_NAME="org.semanticwb.platform.SemanticObject";
    
    /** The Constant SEMANTIC_CLASS_FULL_NAME. */
    private static final String SEMANTIC_CLASS_FULL_NAME="org.semanticwb.platform.SemanticClass";

    /** The Constant GLOBAL_CLASS_NAME. */
    private static final String GLOBAL_CLASS_NAME = "ClassMgr";
    /** The Constant CLOSE_BLOCK. */
    private static final String CLOSE_BLOCK = "    }";
    /** The Constant END_OF_METHOD. */
    private static final String END_OF_METHOD = "();";
    /** The Constant ENTER. */
    private static final String ENTER = "\r\n";
    /** The Constant OPEN_BLOCK. */
    private static final String OPEN_BLOCK = "    {";
    /** The Constant PUBLIC. */
    private static final String PUBLIC = "    public ";
    /** The Constant TYPE_BOOLEAN. */
    private static final String TYPE_BOOLEAN = "boolean";
    /** The Constant TYPE_BYTE. */
    private static final String TYPE_BYTE = "byte";
    /** The Constant TYPE_DATE_TIME. */
    private static final String TYPE_DATE_TIME = "dateTime";
    /** The Constant TYPE_BINARY. */
    private static final String TYPE_BINARY = "base64Binary";
    /** The Constant TYPE_DATE. */
    private static final String TYPE_DATE = "date";
    /** The Constant TYPE_DOUBLE. */
    private static final String TYPE_DOUBLE = "double";
    /** The Constant TYPE_FLOAT. */
    private static final String TYPE_FLOAT = "float";
    /** The Constant TYPE_INT. */
    private static final String TYPE_INT = "int";
    /** The Constant TYPE_LONG. */
    private static final String TYPE_LONG = "long";
    /** The Constant TYPE_SHORT. */
    private static final String TYPE_SHORT = "short";
    /** The Constant TYPE_VOID. */
    private static final String TYPE_VOID = "void";
    /** The log. */
    private static Logger log = SWBUtils.getLogger(SemanticObject.class);
    /** Flag to set generation of virtual classes from ontology definition */
    private boolean generateVirtualClasses=false;


    /*public CodeGenerator(File pDirectory, String pPackage)
    {
    this(pDirectory);
    this.m_Package = pPackage;
    }*/
    /**
     * Instantiates a new code generator.
     */
    public CodeGenerator()
    {
    }

    /**
     * Tells the {@CodeGenerator} to output source code for virtual (compiled in memory) classes.
     * @param generateVirtualClasses 
     */
    public void setGenerateVirtualClasses(boolean generateVirtualClasses)
    {
        this.generateVirtualClasses = generateVirtualClasses;
    }

    /**
     * Gets the flag for virtual class generation from the {@CodeGenerator}.
     * @return true if the {@CodeGenerator} is set to output source code from virtual (compiled in memory) classes, false otherwise.
     */
    public boolean isGenerateVirtualClasses()
    {
        return generateVirtualClasses;
    }

    /**
     * Creates the package folders in file system.
     * 
     * @param spackage the package full namespace
     * @param pDirectory the directory where to output surce code for the package
     * @return the file
     * @throws CodeGeneratorException the code generator exception
     */
    private File createPackage(String spackage, File pDirectory) throws CodeGeneratorException
    {
        File createPackage = pDirectory;
        if (spackage != null && !spackage.equals(""))
        {
            File dir = new File(pDirectory.getPath() + File.separatorChar + spackage.replace('.', File.separatorChar));
            if (!dir.exists() && !dir.mkdirs())
            {
                throw new CodeGeneratorException("The directory " + dir.getPath() + " was not possible to create");
            }
            createPackage = dir;
        }
        return createPackage;
    }

    /**
     * Writes source code to a file.
     * 
     * @param file the target {@File}.
     * @param code Source code to write.
     * @throws CodeGeneratorException the code generator exception
     */
    private void saveFile(File file, String code) throws CodeGeneratorException
    {
        try
        {
            FileOutputStream out = new FileOutputStream(file);
            out.write(code.getBytes());
            out.close();
        }
        catch (IOException ioe)
        {
            throw new CodeGeneratorException("The File " + file.getPath() + " was not possible to create", ioe);
        }
    }
    

    /**
     * Generate code by namespace.
     * 
     * @param namespace the namespace
     * @param createSWBcontent whether to create a SWBContext
     * @param pDirectory the souce code output directory.
     * @throws CodeGeneratorException the code generator exception
     */
    public void generateCodeByNamespace(String namespace, boolean createSWBcontent, File pDirectory) throws CodeGeneratorException
    {
        String prefix = null;
        SemanticMgr mgr = SWBPlatform.getSemanticMgr();
        Iterator<SemanticClass> tpcit = mgr.getVocabulary().listSemanticClasses();
        while (tpcit.hasNext())
        {
            SemanticClass tpc = tpcit.next();
            boolean create = false;
            if (namespace == null)
            {
                create = true;
            }
            else
            {
                if (tpc.getURI() != null)
                {
                    String strnamespace = namespace;
                    if (!strnamespace.endsWith("#"))
                    {
                        strnamespace += "#";
                    }
                    strnamespace += tpc.getName();
                    if (tpc.getURI().equals(strnamespace.toString()))
                    {
                        prefix = tpc.getPrefix();
                        create = true;
                    }
                }

            }
            if (create)
            {
                if (pDirectory.exists() && pDirectory.isFile())
                {
                    throw new CodeGeneratorException("The path " + pDirectory.getPath() + " is not a directory");
                }
                if (!pDirectory.exists())
                {
                    if (!pDirectory.mkdirs())
                    {
                        throw new CodeGeneratorException("The path " + pDirectory.getPath() + " was not possible to create");
                    }
                }
                if (tpc.isSWBInterface())
                {
                    createInterfaceBase(tpc, pDirectory);
                }
                else if (tpc.isSWBSemanticResource())
                {
                    createSemanticResourceBase(tpc, pDirectory);
                }
                else if (tpc.isSWBClass() || tpc.isSWBModel() || tpc.isSWBFormElement())
                {
                    createClassBase(tpc, pDirectory);
                }
            }
        }
        if (createSWBcontent)
        {
            if (prefix != null)
            {
                createSWBContextBase(prefix, pDirectory);
                createSWBContext(prefix, pDirectory);
            }
        }
    }

    /*public void generateCode(URI namespace, boolean createSWBContext,File pDirectory) throws CodeGeneratorException
    {        
    SemanticMgr mgr = SWBPlatform.getSemanticMgr();
    Iterator<SemanticClass> tpcit = mgr.getVocabulary().listSemanticClasses();
    while (tpcit.hasNext())
    {
    SemanticClass tpc = tpcit.next();
    boolean create = false;
    if (namespace == null)
    {
    create = true;
    }
    else
    {
    try
    {
    URI tpcNamespace = new URI(tpc.getURI());
    String strnamespace = namespace.toString();
    if (!strnamespace.endsWith("#"))
    {
    strnamespace += "#";
    }
    strnamespace += tpc.getName();
    if (tpcNamespace.toString().equals(strnamespace.toString()))
    {
    create = true;
    }
    }
    catch (Exception e)
    {
    e.printStackTrace();
    create = false;
    }
    }
    if (create)
    {
    if (pDirectory.exists() && pDirectory.isFile())
    {
    throw new CodeGeneratorException("The path " + pDirectory.getPath() + " is not a directory");
    }
    if (!pDirectory.exists())
    {
    if (!pDirectory.mkdirs())
    {
    throw new CodeGeneratorException("The path " + pDirectory.getPath() + " was not possible to create");
    }
    }
    if (tpc.isSWBInterface())
    {
    createInterface(tpc, pDirectory);
    }
    else if (tpc.isSWBSemanticResource())
    {
    createSemanticResourceBase(tpc, pDirectory);
    }
    else if (tpc.isSWBClass() || tpc.isSWBModel() || tpc.isSWBFormElement())
    {
    createClassBase(tpc, pDirectory);
    }
    }
    }
    if (createSWBContext)
    {
    createSWBContextBase("", pDirectory);
    createSWBContext("", pDirectory);
    }
    }*/
    
    /**
     * Checks whether a class definition in the input ontology meets the conditions to generate source code. Throws an exception if one of the conditions is not met.
     * 
     * @param clazz the {@SemanticClass} wrapper object from the ontology class definition.
     * @throws CodeGeneratorException the code generator exception
     */
    private void checkClass(SemanticClass clazz) throws CodeGeneratorException
    {
        if(clazz.getCodePackage()==null)
        {
            throw new CodeGeneratorException("The code package for Semantic class " + clazz.getURI() + " is not defined\r\n");
        }
        Iterator<SemanticClass> tpcit = clazz.listSuperClasses(true);
        while (tpcit.hasNext())
        {
            SemanticClass tpc = tpcit.next();
            if (clazz.isSWBInterface() && tpc.isSWBClass())
            {
                throw new CodeGeneratorException("The Semantic class " + clazz.getURI() + " is an interface and its parent is a class\r\n");
            }
            /*if(clazz.isSWBClass() && tpc.isSWBInterface())
            {
            throw new CodeGeneratorException("The semantic class "+ clazz.getURI() +" is a class and its parent is an interface");
            }*/
        }
        Iterator<SemanticProperty> properties=clazz.listProperties();
        while(properties.hasNext())
        {
            SemanticProperty tpp=properties.next();
            if(tpp.isObjectProperty())
            {
                try
                {
                    if (tpp.isString() || tpp.isXML() || tpp.isInt() || tpp.isFloat() || tpp.isDouble() || tpp.isLong() || tpp.isByte() || tpp.isShort() || tpp.isBoolean() || tpp.isDateTime() || tpp.isDate())
                    {
                        throw new CodeGeneratorException("The property "+tpp+" for semantic class " + clazz + " is defined as Object Property, but the type is "+ tpp.getRange() +" \r\n");
                    }
                }
                catch(Exception e)
                {
                    throw new CodeGeneratorException("The property "+tpp+" has an error\r\n",e);
                }


            }
            if(tpp.isDataTypeProperty())
            {
                if (!(tpp.isBinary() ||  tpp.isString() || tpp.isXML() || tpp.isInt() || tpp.isFloat() || tpp.isDouble() || tpp.isLong() || tpp.isByte() || tpp.isShort() || tpp.isBoolean() || tpp.isDateTime() || tpp.isDate()))
                {
                    throw new CodeGeneratorException("The property "+tpp+" for semantic class " + clazz + " is defined as DataType Property, but the type is "+ tpp.getRange() +" \r\n");
                }
            }
        }
    }

    /**
     * Generates the source code from an input ontology definition.
     * 
     * @param prefix the ontology prefix used to generate source code.
     * @param createSWBContext whether to create a SWBContext.
     * @param pDirectory the target directory for the source code.
     * @throws CodeGeneratorException the code generator exception
     */
    public void generateCode(String prefix, boolean createSWBContext, File pDirectory) throws CodeGeneratorException
    {

         //System.out.println("Prefix:"+prefix);
        SemanticMgr mgr = SWBPlatform.getSemanticMgr();
        Iterator<SemanticClass> tpcit = mgr.getVocabulary().listSemanticClasses();
        while (tpcit.hasNext())
        {
            SemanticClass tpc = tpcit.next();
           //System.out.println("SemClass:"+tpc.toString());
            //System.out.println("SemClass:"+tpc.getClassName());
            //System.out.println("TPC.getPrefix:"+tpc.getPrefix());
            if (prefix == null || (prefix.equals(tpc.getPrefix())))
            {
                checkClass(tpc);
            }
        }
        tpcit = mgr.getVocabulary().listSemanticClasses();        
        while (tpcit.hasNext())
        {
            SemanticClass tpc = tpcit.next();            
            boolean create = false;
            if (prefix == null)
            {
                create = true;
            }
            else
            {
                if (prefix.equals(tpc.getPrefix()))
                {
                    create = true;
                }
            }
            if (create)
            {
                if (pDirectory.exists() && pDirectory.isFile())
                {
                    throw new CodeGeneratorException("The path " + pDirectory.getPath() + " is not a directory");
                }
                if (!pDirectory.exists())
                {
                    if (!pDirectory.mkdirs())
                    {
                        throw new CodeGeneratorException("The path " + pDirectory.getPath() + " was not possible to create");
                    }
                }
                if (tpc.isSWBInterface())
                {
                    createInterfaceBase(tpc, pDirectory);
                }
                else if (tpc.isSWBSemanticResource())
                {
                    createSemanticResourceBase(tpc, pDirectory);
                }
                else if (tpc.isSWBClass() || tpc.isSWBModel() || tpc.isSWBFormElement())
                {
                    createClassBase(tpc, pDirectory);
                }
            }
        }
        if (createSWBContext)
        {
            createSWBContextBase(prefix, pDirectory);
            createSWBContext(prefix, pDirectory);
        }
    }

    /**
     * Gets the {@SemanticClass}es that a {@SemanticClass} inherits, according to the ontology definition.
     * 
     * @param tpc the {@SemanticClass} wrapper for a class definition in the input ontology.
     * @return the interfaces
     */
    private HashSet<SemanticClass> getInterfaces(SemanticClass tpc)
    {
        HashSet<SemanticClass> interfaces = new HashSet<SemanticClass>();
        Iterator<SemanticClass> it = tpc.listSuperClasses();
        while (it.hasNext())
        {
            SemanticClass clazz = it.next();
            if (clazz.isSWBInterface())
            {
                interfaces.add(clazz);
            }
        }
        return interfaces;
    }

    /**
     * Gets a string with the {@SemanticClass}es that a {@SemanticClass} inherits, according to the ontology definition.
     * 
     * @param tpc the {@SemanticClass} wrapper for a class definition in the input ontology.
     * @param isextends whether to prefix the result string with "extends". Defaults to "implements".
     * @return the interfaces as a string
     */
    private String getInterfacesAsString(SemanticClass tpc, boolean isextends)
    {
        StringBuilder interfaces = new StringBuilder();
        Iterator<SemanticClass> it = tpc.listSuperClasses();
        while (it.hasNext())
        {
            SemanticClass clazz = it.next();
            if (clazz.isSWBInterface())
            {
                interfaces.append(clazz.getCanonicalName()).append(",");
            }
        }
        if (interfaces.length() > 0)
        {
            if (isextends)
            {
                interfaces.insert(0, "extends ");
            }
            else
            {
                interfaces.insert(0, "implements ");
            }
            interfaces.deleteCharAt(interfaces.length() - 1);
        }
        return interfaces.toString();
    }

    /**
     * Same as method getInterfaces.
     * Gets the {@SemanticClass}es that a {@SemanticClass} inherits, according to the ontology definition.
     * 
     * @param tpc the {@SemanticClass} wrapper for a class definition in the input ontology.
     * @return the interfaces
     */
    private static HashSet<SemanticClass> listInterfaces(SemanticClass tpc)
    {
        HashSet<SemanticClass> interfaces = new HashSet<SemanticClass>();
        Iterator<SemanticClass> it = tpc.listSuperClasses();
        while (it.hasNext())
        {
            SemanticClass clazz = it.next();
            if (clazz.isSWBInterface())
            {
                interfaces.add(clazz);
            }
        }
        return interfaces;
    }

    /**
     * Creates the SWBContext class.
     * 
     * @param prefix the ontology prefix to use in code generation.
     * @param pDirectory the target directory for source code.
     * @throws CodeGeneratorException the code generator exception
     */
    private void createSWBContext(String prefix, File pDirectory) throws CodeGeneratorException
    {
        // si existe no debe reemplazarlo
        String SWBContextClsName = "SWBContext";
        SemanticMgr mgr = SWBPlatform.getSemanticMgr();
        String spackage = mgr.getCodePackage().getPackage(prefix);
        File dir = createPackage(spackage, pDirectory);
        dir = new File(dir.getPath() + File.separatorChar);
        File fileClass = new File(dir.getPath() + File.separatorChar + SWBContextClsName + ".java");
        if (!fileClass.exists())
        {
            StringBuilder javaClassContent = new StringBuilder();
            if (!spackage.equals(""))
            {
                javaClassContent.append("package ").append(spackage).append(";").append(ENTER);
                javaClassContent.append(ENTER);
            }            
            javaClassContent.append("import org.semanticwb.SWBUtils;").append(ENTER);
            javaClassContent.append("import org.semanticwb.model.base.SWBContextBase;").append(ENTER).append(ENTER);
            javaClassContent.append("public class SWBContext extends SWBContextBase").append(ENTER);
            javaClassContent.append("{").append(ENTER);

            javaClassContent.append("    private static org.semanticwb.Logger log=SWBUtils.getLogger(SWBContext.class);").append(ENTER);
            javaClassContent.append("    private static SWBContext instance=null;").append(ENTER);

            javaClassContent.append("    static public synchronized SWBContext createInstance()").append(ENTER);
            javaClassContent.append("    {").append(ENTER);
            javaClassContent.append("        if (instance == null)").append(ENTER);
            javaClassContent.append("        {").append(ENTER);
            javaClassContent.append("            instance = new SWBContext();").append(ENTER);
            javaClassContent.append("        }").append(ENTER);
            javaClassContent.append("        return instance;").append(ENTER);
            javaClassContent.append("    }").append(ENTER);

            javaClassContent.append("    private SWBContext()").append(ENTER);
            javaClassContent.append("    {").append(ENTER);
            javaClassContent.append("        log.event(\"Initializing SemanticWebBuilder Context...\");").append(ENTER);
            javaClassContent.append("    }").append(ENTER);

            javaClassContent.append("}");
            saveFile(fileClass, javaClassContent.toString());
        }
    }

    /**
     * Creates the SWBContextBase class.
     * 
     * @param prefix the ontology prefix to use in code generation.
     * @param pDirectory the output directory for the source code.
     * @throws CodeGeneratorException the code generator exception
     */
    private void createSWBContextBase(String prefix, File pDirectory) throws CodeGeneratorException
    {
        // Debe reemplazarlo siempre
        SemanticMgr mgr = SWBPlatform.getSemanticMgr();
        String spackage = mgr.getCodePackage().getPackage(prefix);
        String ClsName = "SWBContextBase";
        File dir = createPackage(spackage, pDirectory);
        dir = new File(dir.getPath() + File.separatorChar + "base");
        StringBuilder javaClassContent = new StringBuilder();
        File fileClass = new File(dir.getPath() + File.separatorChar + ClsName + ".java");
        if (!spackage.equals(""))
        {
            javaClassContent.append("package ").append(spackage).append(".base;").append(ENTER);
            javaClassContent.append(ENTER);
        }
        javaClassContent.append("import ").append(UTIL_ITERATOR_FULL_NAME).append(";").append(ENTER);
        javaClassContent.append("import org.semanticwb.model.*;").append(ENTER);
        javaClassContent.append("import ").append(SEMANTIC_PLATFORM_FULL_NAME).append(";").append(ENTER);
        javaClassContent.append("import ").append(SEMANTIC_MANANGER_FULL_NAME).append(";").append(ENTER);
        javaClassContent.append("import ").append(MODEL_FULL_NAME).append(";").append(ENTER);
        javaClassContent.append("import ").append(SEMANTIC_OBJECT_FULL_NAME).append(";").append(ENTER);
        javaClassContent.append("import ").append(SEMANTIC_CLASS_FULL_NAME).append(";").append(ENTER);


        javaClassContent.append("public class SWBContextBase").append(ENTER);
        javaClassContent.append("{").append(ENTER);

        javaClassContent.append("    private static ").append(SEMANTIC_MANANGER_FULL_NAME).append(" mgr=").append(SEMANTIC_PLATFORM_FULL_NAME).append(".getSemanticMgr();").append(ENTER);

        Iterator<SemanticClass> tpcit = mgr.getVocabulary().listSemanticClasses();
        while (tpcit.hasNext())
        {
            SemanticClass tpc = tpcit.next();

            if (tpc.isSWBModel())
            {
                javaClassContent.append("    public static final SemanticClass ").append(tpc.getPrefix()).append("_").append(tpc.getUpperClassName()).append("=").append(SEMANTIC_PLATFORM_FULL_NAME).append(GET_SEMANTIC_CLASS).append(tpc.getURI()).append("\");").append(ENTER);
                javaClassContent.append(ENTER);
                javaClassContent.append("    public static ").append(tpc.getCanonicalName()).append(" get").append(tpc.getUpperClassName()).append("(String name)").append(ENTER);
                javaClassContent.append("    {").append(ENTER);
                javaClassContent.append("        return ").append(tpc.getCanonicalName()).append(".").append(GLOBAL_CLASS_NAME).append(".get").append(tpc.getUpperClassName()).append("(name);").append(ENTER);
                javaClassContent.append("    }").append(ENTER);
                javaClassContent.append(ENTER);
                javaClassContent.append("    public static ").append(UTIL_ITERATOR_FULL_NAME).append("<").append(tpc.getCanonicalName()).append("> list").append(tpc.getNameInPlural()).append("()").append(ENTER);
                javaClassContent.append("    {").append(ENTER);
                javaClassContent.append("        return (").append(UTIL_ITERATOR_FULL_NAME).append("<").append(tpc.getCanonicalName()).append(">)").append(tpc.getPrefix()).append("_").append(tpc.getUpperClassName()).append(".listGenericInstances();").append(ENTER);
                javaClassContent.append("    }").append(ENTER);
                javaClassContent.append(ENTER);
                javaClassContent.append("    public static void remove").append(tpc.getUpperClassName()).append("(String name)").append(ENTER);
                javaClassContent.append("    {").append(ENTER);
                javaClassContent.append("        ").append(tpc.getCanonicalName()).append("." + GLOBAL_CLASS_NAME + ".remove").append(tpc.getUpperClassName()).append("(name);" + ENTER);
                javaClassContent.append("    }" + ENTER);
                javaClassContent.append(ENTER);
                javaClassContent.append("    public static ").append(tpc.getCanonicalName()).append(" create").append(tpc.getUpperClassName()).append("(String name, String namespace)" + ENTER);
                javaClassContent.append("    {" + ENTER);
                javaClassContent.append("       return ").append(tpc.getCanonicalName()).append("." + GLOBAL_CLASS_NAME + ".create").append(tpc.getUpperClassName()).append("(name, namespace);" + ENTER);
                javaClassContent.append("    }" + ENTER);
            }
        }
        javaClassContent.append("}" + ENTER);

        saveFile(fileClass, javaClassContent.toString());
    }

    /**
     * Creates a SemanticResource source code.
     * 
     * @param tpc the {@SemanticClass} wrapper for the {@SemanticResource} definition in the input ontology.
     * @param pDirectory the target directory for the source code.
     * @throws CodeGeneratorException the code generator exception
     */
    private void createSemanticResource(SemanticClass tpc, File pDirectory) throws CodeGeneratorException
    {

        File dir = createPackage(tpc.getCodePackage(), pDirectory);
        File fileClass = new File(dir.getPath() + File.separatorChar + tpc.getUpperClassName() + ".java");
        File fileClass2 = new File(dir.getPath() + File.separatorChar + tpc.getUpperClassName() + ".groovy");
        if (!fileClass.exists() && !fileClass2.exists())
        {
            StringBuilder javaClassContent = new StringBuilder();
            if (tpc.getCodePackage()!=null && !tpc.getCodePackage().equals(""))
            {
                javaClassContent.append("package ").append(tpc.getCodePackage()).append(";" + ENTER);
                javaClassContent.append("" + ENTER);
            }
            javaClassContent.append(ENTER);
            javaClassContent.append("import java.io.IOException;" + ENTER);
            javaClassContent.append("import java.io.PrintWriter;" + ENTER);
            javaClassContent.append("import javax.servlet.http.*;" + ENTER);
            javaClassContent.append("import org.semanticwb.portal.api.*;" + ENTER);

            javaClassContent.append(ENTER);
            javaClassContent.append("public class ").append(tpc.getUpperClassName()).append(" extends ").append(tpc.getCodePackage()).append(".base.").append(tpc.getUpperClassName()).append("Base " + ENTER);
            javaClassContent.append("{" + ENTER);

            javaClassContent.append(ENTER);

            javaClassContent.append("    public ").append(tpc.getUpperClassName()).append("()" + ENTER);
            javaClassContent.append("    {" + ENTER);
            javaClassContent.append("    }" + ENTER);

            javaClassContent.append(ENTER);


            javaClassContent.append("   /**"+ ENTER);
            javaClassContent.append("   * Constructs a ").append(tpc.getUpperClassName()).append(" with a SemanticObject"+ ENTER);
            javaClassContent.append("   * @param base The SemanticObject with the properties for the ").append(tpc.getUpperClassName()).append(""+ ENTER);
            javaClassContent.append("   */"+ ENTER);

            javaClassContent.append("    public ").append(tpc.getUpperClassName()).append("("+SEMANTIC_OBJECT_FULL_NAME+" base)" + ENTER);
            javaClassContent.append("    {" + ENTER);
            javaClassContent.append("        super(base);" + ENTER);
            javaClassContent.append("    }" + ENTER);


            javaClassContent.append(ENTER);
            javaClassContent.append("    @Override" + ENTER);
            javaClassContent.append("    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException" + ENTER);
            javaClassContent.append("    {" + ENTER);
            javaClassContent.append("        PrintWriter out=response.getWriter();" + ENTER);
            javaClassContent.append("        out.println(\"Hello ").append(tpc.getUpperClassName()).append("...\");");
            javaClassContent.append("    }" + ENTER);
            javaClassContent.append(ENTER);
            javaClassContent.append("}" + ENTER);
            saveFile(fileClass, javaClassContent.toString());
        }
    }

    /**
     * Creates a SemanticResourceBase source code for a SemanticResource.
     * 
     * @param tpc the {@SemanticClass} wrapper for the {@SemanticResource} definition in the input ontology.
     * @param pDirectory the target directory for the source code.
     * @throws CodeGeneratorException the code generator exception
     */
    private void createSemanticResourceBase(SemanticClass tpc, File pDirectory) throws CodeGeneratorException
    {
        String exts = "org.semanticwb.portal.api.GenericSemResource";
        File dir = createPackage(tpc.getCodePackage(), pDirectory);
        SemanticClass parent = null;
        Iterator<SemanticClass> it = tpc.listSuperClasses(true);
        while (it.hasNext())
        {
            parent = it.next();
            if (parent.isSWBSemanticResource())
            {
                exts = parent.getCanonicalName();
                break;
            }
            else
            {
                parent = null;
            }
        }
        dir = new File(dir.getPath() + File.separatorChar + "base");
        if (!dir.exists())
        {
            dir.mkdirs();
        }
        StringBuilder javaClassContent = new StringBuilder();
        if (tpc.getCodePackage()!=null && !tpc.getCodePackage().equals(""))
        {
            javaClassContent.append("package ").append(tpc.getCodePackage()).append(".base;" + ENTER);
            javaClassContent.append("" + ENTER);
        }
        javaClassContent.append(ENTER);
        javaClassContent.append("public abstract class ").append(tpc.getUpperClassName()).append("Base extends ").append(exts).append(" ").append(getInterfacesAsString(tpc, false)).append("" + ENTER);
        javaClassContent.append("{" + ENTER);
        HashSet<SemanticClass> staticClasses = new HashSet<SemanticClass>();
        HashSet<SemanticProperty> staticProperties = new HashSet<SemanticProperty>();
        Iterator<SemanticProperty> properties = tpc.listProperties();

        //javaClassContent.append("    public static class " + GLOBAL_CLASS_NAME + ENTER);
        //javaClassContent.append("    {" + ENTER);

        while (properties.hasNext())
        {
            SemanticProperty tpp = properties.next();
            boolean isInClass = false;
            Iterator<SemanticClass> classes = tpc.listSuperClasses(true);
            while (classes.hasNext())
            {
                SemanticClass superclass = classes.next();
                if (superclass.isSWBClass() || superclass.isSWBModel() || superclass.isSWBFormElement())
                {
                    Iterator<SemanticProperty> propInterfaces = superclass.listProperties();
                    while (propInterfaces.hasNext())
                    {
                        SemanticProperty propSuperClass = propInterfaces.next();
                        if (propSuperClass.equals(tpp))
                        {
                            isInClass = true;
                            break;
                        }
                    }
                    if (isInClass)
                    {
                        break;
                    }
                }
            }
            if (!isInClass)
            {
                SemanticClass range = tpp.getRangeClass();
                if (range != null)
                {
                    if (!staticClasses.contains(range))
                    {
                        javaClassContent.append("    public static final " + SEMANTIC_CLASS_FULL_NAME + " ").append(range.getPrefix()).append("_").append(range.getUpperClassName()).append("=" + SEMANTIC_PLATFORM_FULL_NAME + GET_SEMANTIC_CLASS).append(range.getURI()).append("\");" + ENTER);
                        staticClasses.add(range);
                    }
                }

                if (!staticProperties.contains(tpp))
                {
                    javaClassContent.append("    public static final "+SEMANTIC_PROPERTY_FULL_NAME+" ").append(tpp.getPrefix()).append("_").append(tpp.getName()).append("="+SEMANTIC_PLATFORM_FULL_NAME+".getSemanticMgr().getVocabulary().getSemanticProperty(\"").append(tpp.getURI()).append("\");" + ENTER);
                    //staticProperties.add(tpp);
                }
            }
        }

        if (!staticClasses.contains(tpc))
        {
            javaClassContent.append("    public static final " + SEMANTIC_CLASS_FULL_NAME + " ").append(tpc.getPrefix()).append("_").append(tpc.getUpperClassName()).append("=" + SEMANTIC_PLATFORM_FULL_NAME + GET_SEMANTIC_CLASS).append(tpc.getURI()).append("\");" + ENTER);
            staticClasses.add(tpc);
        }

        javaClassContent.append("    public static final " + SEMANTIC_CLASS_FULL_NAME + " sclass=" + SEMANTIC_PLATFORM_FULL_NAME + GET_SEMANTIC_CLASS).append(tpc.getURI()).append("\");" + ENTER);

        //javaClassContent.append("    }" + ENTER);

        javaClassContent.append(ENTER);

        javaClassContent.append("    public ").append(tpc.getUpperClassName()).append("Base()" + ENTER);
        javaClassContent.append("    {" + ENTER);
        javaClassContent.append("    }" + ENTER);

        javaClassContent.append(ENTER);

        javaClassContent.append("   /**"+ ENTER);
        javaClassContent.append("   * Constructs a ").append(tpc.getUpperClassName()).append("Base with a SemanticObject"+ ENTER);
        javaClassContent.append("   * @param base The SemanticObject with the properties for the ").append(tpc.getUpperClassName()).append(""+ ENTER);
        javaClassContent.append("   */"+ ENTER);

        javaClassContent.append("    public ").append(tpc.getUpperClassName()).append("Base("+SEMANTIC_OBJECT_FULL_NAME+" base)" + ENTER);
        javaClassContent.append("    {" + ENTER);
        javaClassContent.append("        super(base);" + ENTER);
        javaClassContent.append("    }" + ENTER);

        javaClassContent.append(ENTER);

        javaClassContent.append("    /*" + ENTER);
        javaClassContent.append("     * @see java.lang.Object#hashCode()" + ENTER);
        javaClassContent.append("     */" + ENTER);
        javaClassContent.append("    @Override" + ENTER);
        javaClassContent.append("    public int hashCode() " + ENTER);
        javaClassContent.append("    {" + ENTER);
        javaClassContent.append("        return getSemanticObject().hashCode();" + ENTER);
        javaClassContent.append("    }" + ENTER);

        javaClassContent.append(ENTER);

        javaClassContent.append("    /*" + ENTER);
        javaClassContent.append("     * @see java.lang.Object#equals(java.lang.Object)" + ENTER);
        javaClassContent.append("     */" + ENTER);
        javaClassContent.append("    @Override" + ENTER);
        javaClassContent.append("    public boolean equals(Object obj) " + ENTER);
        javaClassContent.append("    {" + ENTER);
        javaClassContent.append("        if(obj==null)return false;" + ENTER);
        javaClassContent.append("        return hashCode()==obj.hashCode();" + ENTER);
        javaClassContent.append("    }" + ENTER);

        insertPropertiesToClass(tpc, javaClassContent, null, "SemanticObject");

        javaClassContent.append("}" + ENTER);
        File fileClass = new File(dir.getPath() + File.separatorChar + tpc.getUpperClassName() + "Base.java");
        saveFile(fileClass, javaClassContent.toString());
        createSemanticResource(tpc, pDirectory);
    }

    /**
     * Creates the source code for an object's base class.
     * 
     * @param tpc the {@SemanticClass} wrapper for the object definition in the input ontology.
     * @param usesufix whether to use "base" suffix in code generation.
     * @return a string with the source code for the base class.
     * @throws CodeGeneratorException the code generator exception
     */
    public String createClassBase(SemanticClass tpc,boolean usesufix) throws CodeGeneratorException
    {
        String exts = "org.semanticwb.model.base.GenericObjectBase";
        if (tpc.isSWBFormElement())
        {
            exts = "org.semanticwb.model.base.FormElementBase";
        }
        SemanticClass parent = null;
        Iterator<SemanticClass> it = tpc.listSuperClasses(true);
        while (it.hasNext())
        {
            parent = it.next();
            //EHSP-31032016 - Check parent chain for virtual classes and add them to extends
            if (parent.isSWBClass() || parent.isSWBModel() || parent.isSWBFormElement() || (parent.isSWBVirtualClass() && isGenerateVirtualClasses()))
            {
                exts = parent.getCanonicalName();
                break;
            }
            else
            {
                parent = null;
            }
        }

        StringBuilder javaClassContent = new StringBuilder();
        if (tpc.getCodePackage()!=null && !tpc.getCodePackage().equals(""))
        {
            if(usesufix)
                javaClassContent.append("package ").append(tpc.getCodePackage()).append(".base;" + ENTER);
            else
                javaClassContent.append("package ").append(tpc.getCodePackage()).append(";" + ENTER);


            javaClassContent.append("" + ENTER);
        }
        javaClassContent.append(ENTER);

        if(tpc.getComment(null)!=null)
        {
            javaClassContent.append("   /**"+ ENTER);
            javaClassContent.append("   * ").append(tpc.getComment(null)).append(" "+ ENTER);
            javaClassContent.append("   */"+ ENTER);
        }
        if(usesufix)
        {
            javaClassContent.append("public abstract class ").append(tpc.getUpperClassName()).append("Base extends ").append(exts).append(" ").append(getInterfacesAsString(tpc, false)).append("" + ENTER);
        }
        else
        {
            javaClassContent.append("public class ").append(tpc.getUpperClassName()).append(" extends ").append(exts).append(" ").append(getInterfacesAsString(tpc, false)).append("" + ENTER);
        }

        javaClassContent.append("{" + ENTER);
        HashSet<SemanticClass> staticClasses = new HashSet<SemanticClass>();
        HashSet<SemanticProperty> staticProperties = new HashSet<SemanticProperty>();
        Iterator<SemanticProperty> properties = tpc.listProperties();
        HashSet<SemanticClass> interfaces = getInterfaces(tpc);

        while (properties.hasNext())
        {
            SemanticProperty tpp = properties.next();

            boolean isInClass = false;
            Iterator<SemanticClass> classes = tpc.listSuperClasses(true);
            while (classes.hasNext())
            {
                SemanticClass superclass = classes.next();
                if (superclass.isSWBClass() || superclass.isSWBModel() || superclass.isSWBFormElement())
                {
                    Iterator<SemanticProperty> propInterfaces = superclass.listProperties();
                    while (propInterfaces.hasNext())
                    {
                        SemanticProperty propSuperClass = propInterfaces.next();
                        if (propSuperClass.equals(tpp))
                        {
                            isInClass = true;
                            break;
                        }
                    }
                    if (isInClass)
                    {
                        break;
                    }
                }
            }
            if (!isInClass)
            {
                for (SemanticClass ointerface : interfaces)
                {
                    Iterator<SemanticProperty> propInterfaces = ointerface.listProperties();
                    while (propInterfaces.hasNext())
                    {
                        SemanticProperty propSuperClass = propInterfaces.next();
                        if (propSuperClass.equals(tpp))
                        {
                            isInClass = true;
                            break;
                        }
                    }
                    if (isInClass)
                    {
                        break;
                    }
                }
            }


            if (!isInClass)
            {
                SemanticClass range = tpp.getRangeClass();
                if (range != null)
                {
                    if (!staticClasses.contains(range))
                    {
                        if(range.getComment()!=null)
                        {
                            javaClassContent.append("   /**"+ ENTER);
                            javaClassContent.append("   * ").append(range.getComment()).append(ENTER);
                            javaClassContent.append("   */"+ ENTER);
                        }
                        javaClassContent.append("    public static final " + SEMANTIC_CLASS_FULL_NAME + " ").append(range.getPrefix()).append("_").append(range.getUpperClassName()).append("=" + SEMANTIC_PLATFORM_FULL_NAME + GET_SEMANTIC_CLASS).append(range.getURI()).append("\");" + ENTER);
                        staticClasses.add(range);
                    }
                }

                if (!staticProperties.contains(tpp))
                {
                    if(tpp.getComment()!=null)
                    {
                        javaClassContent.append("   /**"+ ENTER);
                        javaClassContent.append("   * ").append(tpp.getComment()).append(ENTER);
                        javaClassContent.append("   */"+ ENTER);
                    }
                    javaClassContent.append("    public static final " + SEMANTIC_PROPERTY_FULL_NAME + " ").append(tpp.getPrefix()).append("_").append(tpp.getName()).append("=" + SEMANTIC_PLATFORM_FULL_NAME + ".getSemanticMgr().getVocabulary().getSemanticProperty(\"").append(tpp.getURI()).append("\");" + ENTER);
                    staticProperties.add(tpp);
                }
            }
        }




        if (tpc.isSWBModel())
        {
            Iterator<SemanticClass> classesOfModel = tpc.listModelClasses();
            while (classesOfModel.hasNext())
            {
                SemanticClass clazzOfModel = classesOfModel.next();
                if (clazzOfModel != null)
                {
                    if (!staticClasses.contains(clazzOfModel))
                    {
                        if(clazzOfModel.getComment(null)!=null)
                        {
                            javaClassContent.append("   /**"+ ENTER);
                            javaClassContent.append("   * ").append(clazzOfModel.getComment(null)).append(ENTER);
                            javaClassContent.append("   */"+ ENTER);
                        }
                        javaClassContent.append("    public static final " + SEMANTIC_CLASS_FULL_NAME + " ").append(clazzOfModel.getPrefix()).append("_").append(clazzOfModel.getUpperClassName()).append("=" + SEMANTIC_PLATFORM_FULL_NAME + GET_SEMANTIC_CLASS).append(clazzOfModel.getURI()).append("\");" + ENTER);
                        staticClasses.add(clazzOfModel);
                    }
                }
            }
        }
        if (!staticClasses.contains(tpc))
        {
            if(tpc.getComment(null)!=null)
            {
                javaClassContent.append("   /**"+ ENTER);
                javaClassContent.append("   * ").append(tpc.getComment(null)).append(ENTER);
                javaClassContent.append("   */"+ ENTER);
            }
            javaClassContent.append("    public static final " + SEMANTIC_CLASS_FULL_NAME + " ").append(tpc.getPrefix()).append("_").append(tpc.getUpperClassName()).append("=" + SEMANTIC_PLATFORM_FULL_NAME + GET_SEMANTIC_CLASS).append(tpc.getURI()).append("\");" + ENTER);
            staticClasses.add(tpc);
        }

        javaClassContent.append("   /**"+ ENTER);
        javaClassContent.append("   * The semantic class that represents the currentObject"+ ENTER);
        javaClassContent.append("   */"+ ENTER);

        javaClassContent.append("    public static final " + SEMANTIC_CLASS_FULL_NAME + " sclass=" + SEMANTIC_PLATFORM_FULL_NAME + GET_SEMANTIC_CLASS).append(tpc.getURI()).append("\");" + ENTER);

        javaClassContent.append(ENTER);
        javaClassContent.append("    public static class " + GLOBAL_CLASS_NAME + ENTER);
        javaClassContent.append("    {" + ENTER);


        String fullpathClass = tpc.getCanonicalName();



        javaClassContent.append("       /**"+ ENTER);
        javaClassContent.append("       * Returns a list of ").append(tpc.getUpperClassName()).append(" for a model"+ ENTER);
        javaClassContent.append("       * @param model Model to find"+ ENTER);
        javaClassContent.append("       * @return Iterator of ").append(fullpathClass).append(ENTER);
        javaClassContent.append("       */"+ ENTER);

        javaClassContent.append(ENTER);
        javaClassContent.append("        public static " + UTIL_ITERATOR_FULL_NAME + "<").append(fullpathClass).append("> list").append(tpc.getNameInPlural()).append("("+SEMANTIC_MODEL_FULL_NAME+" model)" + ENTER);
        javaClassContent.append("        {" + ENTER);
        javaClassContent.append("            "+UTIL_ITERATOR_FULL_NAME+" it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);" + ENTER);
        javaClassContent.append("            return new " + GENERIC_ITERATOR_FULL_NAME + "<").append(fullpathClass).append(">(it, true);" + ENTER);
        javaClassContent.append("        }" + ENTER);

        javaClassContent.append("       /**"+ ENTER);
        javaClassContent.append("       * Returns a list of ").append(fullpathClass).append(" for all models"+ ENTER);        
        javaClassContent.append("       * @return Iterator of ").append(fullpathClass).append(ENTER);
        javaClassContent.append("       */"+ ENTER);


        javaClassContent.append(ENTER);
        javaClassContent.append("        public static " + UTIL_ITERATOR_FULL_NAME + "<").append(fullpathClass).append("> list").append(tpc.getNameInPlural()).append("()" + ENTER);
        javaClassContent.append("        {" + ENTER);
        javaClassContent.append("            "+UTIL_ITERATOR_FULL_NAME+" it=sclass.listInstances();" + ENTER);
        javaClassContent.append("            return new " + GENERIC_ITERATOR_FULL_NAME + "<").append(fullpathClass).append(">(it, true);" + ENTER);
        javaClassContent.append("        }" + ENTER);



        if (tpc.isAutogenId())
        {
            javaClassContent.append(ENTER);
            javaClassContent.append("        public static ").append(fullpathClass).append(" create").append(tpc.getUpperClassName()).append("("+SEMANTIC_MODEL_FULL_NAME+" model)" + ENTER);
            javaClassContent.append("        {" + ENTER);
            javaClassContent.append("            long id=model.getSemanticObject().getModel().getCounter(sclass);" + ENTER);
            javaClassContent.append("            return ").append(fullpathClass).append("." + GLOBAL_CLASS_NAME + ".create").append(tpc.getUpperClassName()).append("(String.valueOf(id), model);" + ENTER);
            javaClassContent.append("        }" + ENTER);

        }
        if (tpc.isSWBModel())
        {
            javaClassContent.append("       /**"+ ENTER);
            javaClassContent.append("       * Gets a ").append(fullpathClass).append(""+ ENTER);
            javaClassContent.append("       * @param id Identifier for ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       * @return A ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       */");

            javaClassContent.append(ENTER);
            javaClassContent.append("        public static ").append(fullpathClass).append(" get").append(tpc.getUpperClassName()).append("(String id)" + ENTER);
            javaClassContent.append("        {" + ENTER);
            javaClassContent.append("            "+SEMANTIC_MANANGER_FULL_NAME+" mgr="+SEMANTIC_PLATFORM_FULL_NAME+".getSemanticMgr();" + ENTER);
            javaClassContent.append("            ").append(fullpathClass).append(" ret=null;" + ENTER);
            javaClassContent.append("            "+MODEL_FULL_NAME+" model=mgr.getModel(id);" + ENTER);
            javaClassContent.append("            if(model!=null)" + ENTER);
            javaClassContent.append("            {" + ENTER);
            javaClassContent.append("                "+SEMANTIC_OBJECT_FULL_NAME+" obj=model.getSemanticObject(model.getObjectUri(id,sclass));" + ENTER);
            javaClassContent.append("                if(obj!=null)" + ENTER);
            javaClassContent.append("                {" + ENTER);
            
            javaClassContent.append("                    org.semanticwb.model.GenericObject gobj=obj.createGenericInstance();" + ENTER);
            javaClassContent.append("                    if(gobj instanceof ").append(fullpathClass).append(")" + ENTER);
            javaClassContent.append("                    {" + ENTER);
            javaClassContent.append("                        ret=(").append(fullpathClass).append(")gobj;" + ENTER);
            javaClassContent.append("                    }" + ENTER);
            
            //javaClassContent.append("                    ret=(" + fullpathClass + ")obj.createGenericInstance();" + ENTER);
            
            javaClassContent.append("                }" + ENTER);
            javaClassContent.append("            }" + ENTER);
            javaClassContent.append("            return ret;" + ENTER);
            javaClassContent.append("        }" + ENTER);


            javaClassContent.append("       /**"+ ENTER);
            javaClassContent.append("       * Create a ").append(fullpathClass).append(""+ ENTER);
            javaClassContent.append("       * @param id Identifier for ").append(fullpathClass).append(ENTER);            
            javaClassContent.append("       * @return A ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       */");
            
            javaClassContent.append(ENTER);
            javaClassContent.append("        public static ").append(fullpathClass).append(" create").append(tpc.getUpperClassName()).append("(String id, String namespace)" + ENTER);
            javaClassContent.append("        {" + ENTER);
            javaClassContent.append("            "+SEMANTIC_MANANGER_FULL_NAME+" mgr="+SEMANTIC_PLATFORM_FULL_NAME+".getSemanticMgr();" + ENTER);
            javaClassContent.append("            "+MODEL_FULL_NAME+" model=mgr.createModel(id, namespace);" + ENTER);
            javaClassContent.append("            return (").append(fullpathClass).append(")model.createGenericObject(model.getObjectUri(id,sclass),sclass);" + ENTER);
            javaClassContent.append("        }" + ENTER);


            javaClassContent.append("       /**"+ ENTER);
            javaClassContent.append("       * Remove a ").append(fullpathClass).append(""+ ENTER);
            javaClassContent.append("       * @param id Identifier for ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       */");

            javaClassContent.append(ENTER);
            javaClassContent.append("        public static void remove").append(tpc.getUpperClassName()).append("(String id)" + ENTER);
            javaClassContent.append("        {" + ENTER);
            javaClassContent.append("            ").append(fullpathClass).append(" obj=get").append(tpc.getUpperClassName()).append("(id);" + ENTER);
            javaClassContent.append("            if(obj!=null)" + ENTER);
            javaClassContent.append("            {" + ENTER);
            javaClassContent.append("                obj.remove();" + ENTER);
            javaClassContent.append("            }" + ENTER);
            javaClassContent.append("        }" + ENTER);

            javaClassContent.append("       /**"+ ENTER);
            javaClassContent.append("       * Returns true if exists a ").append(fullpathClass).append(""+ ENTER);
            javaClassContent.append("       * @param id Identifier for ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       * @return true if the ").append(fullpathClass).append(" exists, false otherwise"+ ENTER);
            javaClassContent.append("       */"+ ENTER);

            javaClassContent.append(ENTER);
            javaClassContent.append("        public static boolean has").append(tpc.getUpperClassName()).append("(String id)" + ENTER);
            javaClassContent.append("        {" + ENTER);
            javaClassContent.append("            return (get").append(tpc.getUpperClassName()).append("(id)!=null);" + ENTER);
            javaClassContent.append("        }" + ENTER);
        }
        else
        {
            javaClassContent.append("       /**"+ ENTER);
            javaClassContent.append("       * Gets a ").append(fullpathClass).append(""+ ENTER);
            javaClassContent.append("       * @param id Identifier for ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       * @param model Model of the ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       * @return A ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       */");

            javaClassContent.append(ENTER);
            javaClassContent.append("        public static ").append(fullpathClass).append(" get").append(tpc.getUpperClassName()).append("(String id, "+SEMANTIC_MODEL_FULL_NAME+" model)" + ENTER);
            javaClassContent.append("        {" + ENTER);
            javaClassContent.append("            return (").append(fullpathClass).append(")"+"model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);" + ENTER);
            javaClassContent.append("        }" + ENTER);

            javaClassContent.append("       /**"+ ENTER);
            javaClassContent.append("       * Create a ").append(fullpathClass).append(""+ ENTER);
            javaClassContent.append("       * @param id Identifier for ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       * @param model Model of the ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       * @return A ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       */");

            javaClassContent.append(ENTER);
            javaClassContent.append("        public static ").append(fullpathClass).append(" create").append(tpc.getUpperClassName()).append("(String id, "+SEMANTIC_MODEL_FULL_NAME+" model)" + ENTER);
            javaClassContent.append("        {" + ENTER);
            javaClassContent.append("            return (").append(fullpathClass).append(")"+"model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);" + ENTER);
            javaClassContent.append("        }" + ENTER);

            javaClassContent.append("       /**"+ ENTER);
            javaClassContent.append("       * Remove a ").append(fullpathClass).append(""+ ENTER);
            javaClassContent.append("       * @param id Identifier for ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       * @param model Model of the ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       */");
            
            javaClassContent.append(ENTER);
            javaClassContent.append("        public static void remove").append(tpc.getUpperClassName()).append("(String id, "+SEMANTIC_MODEL_FULL_NAME+" model)" + ENTER);
            javaClassContent.append("        {" + ENTER);
            javaClassContent.append("            "+"model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));" + ENTER);
            javaClassContent.append("        }" + ENTER);

            javaClassContent.append("       /**"+ ENTER);
            javaClassContent.append("       * Returns true if exists a ").append(fullpathClass).append(""+ ENTER);
            javaClassContent.append("       * @param id Identifier for ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       * @param model Model of the ").append(fullpathClass).append(ENTER);
            javaClassContent.append("       * @return true if the ").append(fullpathClass).append(" exists, false otherwise"+ ENTER);
            javaClassContent.append("       */"+ ENTER);

            javaClassContent.append(ENTER);
            javaClassContent.append("        public static boolean has").append(tpc.getUpperClassName()).append("(String id, "+SEMANTIC_MODEL_FULL_NAME+" model)" + ENTER);
            javaClassContent.append("        {" + ENTER);
            javaClassContent.append("            return (get").append(tpc.getUpperClassName()).append("(id, model)!=null);" + ENTER);
            javaClassContent.append("        }" + ENTER);
        }

        Iterator<SemanticProperty> tppit = tpc.listProperties();
        while (tppit.hasNext())
        {
            SemanticProperty tpp = tppit.next();
            if (tpp.isObjectProperty() && !tpp.isNotCodeGeneration())
            {
                //if (!isPropertyOfParent(tpp, parent))
                //{
                SemanticClass tpcToReturn = tpp.getRangeClass();
                if (tpcToReturn != null && tpcToReturn.getURI() != null && tpcToReturn.isSWB())
                {
                    String nameList = tpp.getPropertyCodeName();
                    if (nameList.startsWith("has"))
                    {
                        nameList = nameList.substring(3);
                    }

                    javaClassContent.append("       /**"+ ENTER);
                    javaClassContent.append("       * Gets all ").append(fullpathClass).append(" with a determined ").append(toUpperCase(nameList)).append(""+ ENTER);
                    javaClassContent.append("       * @param value ").append(toUpperCase(nameList)).append(" of the type ").append(tpcToReturn.getCanonicalName()).append(""+ ENTER);
                    javaClassContent.append("       * @param model Model of the ").append(fullpathClass).append(""+ ENTER);
                    javaClassContent.append("       * @return Iterator with all the ").append(fullpathClass).append(""+ ENTER);
                    javaClassContent.append("       */"+ ENTER);

                    javaClassContent.append(ENTER);
                    javaClassContent.append("        public static " + UTIL_ITERATOR_FULL_NAME + "<").append(tpc.getCanonicalName()).append("> list").append(tpc.getUpperClassName()).append("By").append(toUpperCase(nameList)).append("(").append(tpcToReturn.getCanonicalName()).append(" " + "value" + ","+SEMANTIC_MODEL_FULL_NAME+" model)" + ENTER);
                    javaClassContent.append("        {" + ENTER);
                    javaClassContent.append("            " + GENERIC_ITERATOR_FULL_NAME + "<").append(tpc.getCanonicalName()).append("> it=new " + GENERIC_ITERATOR_FULL_NAME + "(model.getSemanticObject().getModel().listSubjectsByClass(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", " + "value" + ".getSemanticObject(),sclass));" + ENTER);
                    javaClassContent.append("            return it;" + ENTER);
                    javaClassContent.append("        }" + ENTER);


                     javaClassContent.append("       /**"+ ENTER);
                    javaClassContent.append("       * Gets all ").append(fullpathClass).append(" with a determined ").append(toUpperCase(nameList)).append(""+ ENTER);
                    javaClassContent.append("       * @param value ").append(toUpperCase(nameList)).append(" of the type ").append(tpcToReturn.getCanonicalName()).append(""+ ENTER);
                    javaClassContent.append("       * @return Iterator with all the ").append(fullpathClass).append(""+ ENTER);
                    javaClassContent.append("       */"+ ENTER);


                    javaClassContent.append(ENTER);
                    javaClassContent.append("        public static " + UTIL_ITERATOR_FULL_NAME + "<").append(tpc.getCanonicalName()).append("> list").append(tpc.getUpperClassName()).append("By").append(toUpperCase(nameList)).append("(").append(tpcToReturn.getCanonicalName()).append(" " + "value" + ")" + ENTER);
                    javaClassContent.append("        {" + ENTER);
                    javaClassContent.append("            " + GENERIC_ITERATOR_FULL_NAME + "<").append(tpc.getCanonicalName()).append("> it=new " + GENERIC_ITERATOR_FULL_NAME + "(" + "value" + ".getSemanticObject().getModel().listSubjectsByClass(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append("," + "value" + ".getSemanticObject(),sclass));" + ENTER);
                    javaClassContent.append("            return it;" + ENTER);
                    javaClassContent.append("        }" + ENTER);
                }
                //}
            }
        }

        javaClassContent.append("    }" + ENTER); // ennd ClassMgr


        if(usesufix)
        {
            javaClassContent.append(ENTER);
            javaClassContent.append("    public static ").append(tpc.getUpperClassName()).append("Base.ClassMgr get").append(tpc.getUpperClassName()).append("ClassMgr()"+ ENTER);
            javaClassContent.append("    {"+ ENTER);
            javaClassContent.append("        return new ").append(tpc.getUpperClassName()).append("Base.ClassMgr();"+ ENTER);
            javaClassContent.append("    }"+ ENTER);
        }else
        {
            javaClassContent.append(ENTER);
            javaClassContent.append("    public static ").append(tpc.getUpperClassName()).append(".ClassMgr get").append(tpc.getUpperClassName()).append("ClassMgr()"+ ENTER);
            javaClassContent.append("    {"+ ENTER);
            javaClassContent.append("        return new ").append(tpc.getUpperClassName()).append(".ClassMgr();"+ ENTER);
            javaClassContent.append("    }"+ ENTER);
        }
        

        javaClassContent.append(ENTER);
        if(usesufix)
        {
            javaClassContent.append("   /**"+ ENTER);
            javaClassContent.append("   * Constructs a ").append(tpc.getUpperClassName()).append("Base with a SemanticObject"+ ENTER);
            javaClassContent.append("   * @param base The SemanticObject with the properties for the ").append(tpc.getUpperClassName()).append(""+ ENTER);
            javaClassContent.append("   */"+ ENTER);
            javaClassContent.append(PUBLIC).append(tpc.getUpperClassName()).append("Base("+SEMANTIC_OBJECT_FULL_NAME+" base)" + ENTER);
        }
        else
        {
            javaClassContent.append("   /**"+ ENTER);
            javaClassContent.append("   * Constructs a ").append(tpc.getUpperClassName()).append(" with a SemanticObject"+ ENTER);
            javaClassContent.append("   * @param base The SemanticObject with the properties for the ").append(tpc.getUpperClassName()).append(""+ ENTER);
            javaClassContent.append("   */"+ ENTER);
            javaClassContent.append(PUBLIC).append(tpc.getUpperClassName()).append("("+SEMANTIC_OBJECT_FULL_NAME+" base)" + ENTER);
        }

        javaClassContent.append(OPEN_BLOCK + ENTER);
        javaClassContent.append("        super(base);" + ENTER);
        javaClassContent.append(CLOSE_BLOCK + ENTER);

        insertPropertiesToClass(tpc, javaClassContent, parent);



        if (tpc.isSWBModel())
        {
            insertPropertiesToModel(tpc, javaClassContent);
        }
        else
        {
            if (parent == null)
            {
                javaClassContent.append(ENTER);
                javaClassContent.append("    public void remove()" + ENTER);
                javaClassContent.append("    {" + ENTER);
                javaClassContent.append("        getSemanticObject().remove();" + ENTER);
                javaClassContent.append("    }" + ENTER);

                javaClassContent.append(ENTER);
                javaClassContent.append("    public "+UTIL_ITERATOR_FULL_NAME+"<"+GENERIC_OBJECT_FULL_NAME+"> listRelatedObjects()" + ENTER);
                javaClassContent.append("    {" + ENTER);

                javaClassContent.append("        return new "+GENERIC_ITERATOR_FULL_NAME+"(getSemanticObject().listRelatedObjects(),true);" + ENTER);
                javaClassContent.append("    }" + ENTER);
            }
            insertLinkToClass4Model(tpc, javaClassContent, parent);
        }
        javaClassContent.append("}" + ENTER);
        return javaClassContent.toString();
    }
    
    /**
     * Writes to a file the source code for an object's base class.
     * 
     * @param tpc the {@SemanticClass} wrapper for the object definition in the input ontology.
     * @param pDirectory the target directory for source code.
     * @throws CodeGeneratorException the code generator exception
     */
    private void createClassBase(SemanticClass tpc, File pDirectory) throws CodeGeneratorException
    {

        String code=createClassBase(tpc,true);
        File dir = createPackage(tpc.getCodePackage(), pDirectory);
        dir = new File(dir.getPath() + File.separatorChar + "base");

        if (!dir.exists())
        {
            dir.mkdirs();
        }
        File fileClass = new File(dir.getPath() + File.separatorChar + tpc.getUpperClassName() + "Base.java");
        try
        {
            System.out.println("Creando clase "+fileClass.getCanonicalPath());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        saveFile(fileClass, code);
        SemanticClass parent = null;
        Iterator<SemanticClass> it = tpc.listSuperClasses(true);
        while (it.hasNext())
        {
            parent = it.next();
            if (parent.isSWBClass() || parent.isSWBModel() || parent.isSWBFormElement())
            {                
                break;
            }
            else
            {
                parent = null;
            }
        }
        createClass(tpc, parent, pDirectory);
    }

    /**
     * Writes the source code for an object's class.
     * 
     * @param tpc the {@SemanticClass} wrapper for the object definition in the input ontology.
     * @param parent the parent
     * @param pDirectory the target directory for the source code
     * @throws CodeGeneratorException the code generator exception
     */
    private void createClass(SemanticClass tpc, SemanticClass parent, File pDirectory) throws CodeGeneratorException
    {
        String sPackage = tpc.getCodePackage();
        File dir = createPackage(sPackage, pDirectory);
        File fileClass = new File(dir.getPath() + File.separatorChar + tpc.getUpperClassName() + ".java");
        File fileClass2 = new File(dir.getPath() + File.separatorChar + tpc.getUpperClassName() + ".groovy");
        if (!fileClass.exists() && !fileClass2.exists())
        {
            StringBuilder javaClassContent = new StringBuilder();
            if (!sPackage.equals(""))
            {
                javaClassContent.append("package ").append(sPackage).append(";" + ENTER);
                javaClassContent.append("" + ENTER);
            }

            javaClassContent.append(ENTER);
            if(tpc.getComment(null)!=null)
            {
                javaClassContent.append("   /**"+ ENTER);
                javaClassContent.append("   * ").append(tpc.getComment(null)).append(" "+ ENTER);
                javaClassContent.append("   */"+ ENTER);
            }
            javaClassContent.append("public class ").append(tpc.getUpperClassName()).append(" extends ").append(tpc.getCodePackage()).append(".base.").append(tpc.getUpperClassName()).append("Base " + ENTER);



            javaClassContent.append("{" + ENTER);
            javaClassContent.append(PUBLIC).append(tpc.getUpperClassName()).append("("+SEMANTIC_OBJECT_FULL_NAME+" base)" + ENTER);
            javaClassContent.append(OPEN_BLOCK + ENTER);
            javaClassContent.append("        super(base);" + ENTER);
            javaClassContent.append(CLOSE_BLOCK + ENTER);
            //insertPropertiesToClass(tpc, javaClassContent);
            javaClassContent.append("}" + ENTER);
            saveFile(fileClass, javaClassContent.toString());
        }
    }

    /**
     * Writes the source code for a {@SWBInterface} object.
     * 
     * @param tpc the {@SemanticClass} wrapper for the {@SWBInterface} definition in the input ontology.
     * @param pDirectory the target directory for the source code
     * @throws CodeGeneratorException the code generator exception
     */
    private void createInterface(SemanticClass tpc, File pDirectory) throws CodeGeneratorException
    {
        File dir = createPackage(tpc.getCodePackage(), pDirectory);
        StringBuilder javaClassContent = new StringBuilder();

        if (tpc.getCodePackage()!=null && !tpc.getCodePackage().equals(""))
        {
            javaClassContent.append("package ").append(tpc.getCodePackage()).append(";" + ENTER);
            javaClassContent.append("" + ENTER);
        }

        if(tpc.getComment(null)!=null)
        {
            javaClassContent.append("   /**"+ ENTER);
            javaClassContent.append("   * ").append(tpc.getComment(null)).append(" "+ ENTER);
            javaClassContent.append("   */"+ ENTER);
        }
        javaClassContent.append("public interface ").append(tpc.getUpperClassName()).append(" extends ").append(tpc.getCodePackage()).append(".base.").append(tpc.getUpperClassName()).append("Base" + ENTER);
        javaClassContent.append("{" + ENTER);
        javaClassContent.append("}" + ENTER);
        File fileClass = new File(dir.getPath() + File.separatorChar + tpc.getUpperClassName() + ".java");
        boolean exists = false;
        if (fileClass.exists())
        {
            exists = true;
        }
        //exists=false;
        if (!exists)
        {
            saveFile(fileClass, javaClassContent.toString());
        }
    }
    
    /**
     * Writes the source code for a {@SWBInterface} base class.
     * 
     * @param tpc the {@SemanticClass} wrapper for the {@SWBInterface} definition in the input ontology.
     * @param pDirectory the target directory for the source code
     * @throws CodeGeneratorException the code generator exception
     */
    private void createInterfaceBase(SemanticClass tpc, File pDirectory) throws CodeGeneratorException
    {
        File dir = createPackage(tpc.getCodePackage() + ".base", pDirectory);
        StringBuilder javaClassContent = new StringBuilder();
        if (tpc.getCodePackage()!=null && !tpc.getCodePackage().equals(""))
        {
            javaClassContent.append("package ").append(tpc.getCodePackage()).append(".base;" + ENTER);
            javaClassContent.append("" + ENTER);
        }
        HashSet<SemanticClass> interfaces = getInterfaces(tpc);
        if(tpc.getComment(null)!=null)
        {
            javaClassContent.append("   /**"+ ENTER);
            javaClassContent.append("   * ").append(tpc.getComment(null)).append(" "+ ENTER);
            javaClassContent.append("   */"+ ENTER);
        }
        if (interfaces.isEmpty())
        {

            javaClassContent.append("public interface ").append(tpc.getUpperClassName()).append("Base extends "+GENERIC_OBJECT_FULL_NAME+ ENTER);
        }
        else
        {
            javaClassContent.append("public interface ").append(tpc.getUpperClassName()).append("Base ").append(getInterfacesAsString(tpc, true)).append(ENTER);
        }
        javaClassContent.append("{" + ENTER);
        HashSet<SemanticClass> staticClasses = new HashSet<SemanticClass>();
        Iterator<SemanticProperty> properties = tpc.listProperties();
        HashSet<String> rangeNames = new HashSet<String>();
        while (properties.hasNext())
        {
            SemanticProperty tpp = properties.next();
            SemanticClass range = tpp.getRangeClass();
            if (range != null)
            {
                if (!staticClasses.contains(range))
                {
                    boolean isInSuperInterface = false;
                    for (SemanticClass cInterface : interfaces)
                    {
                        Iterator<SemanticProperty> propertiesInterface = cInterface.listProperties();
                        while (propertiesInterface.hasNext())
                        {
                            SemanticProperty tppInterface = propertiesInterface.next();
                            SemanticClass rangeInterface = tppInterface.getRangeClass();
                            if (rangeInterface != null && rangeInterface.equals(range))
                            {
                                isInSuperInterface = true;
                                break;
                            }
                        }
                        if (isInSuperInterface)
                        {
                            break;
                        }
                    }
                    if (!isInSuperInterface)
                    {
                        String name = range.getPrefix() + "_" + range.getUpperClassName();
                        if (!rangeNames.contains(name))
                        {
                            if(range.getComment(null)!=null)
                            {
                                javaClassContent.append("   /**"+ ENTER);
                                javaClassContent.append("   * ").append(range.getComment(null)).append(" "+ ENTER);
                                javaClassContent.append("   */"+ ENTER);
                            }
                            javaClassContent.append("    public static final " + SEMANTIC_CLASS_FULL_NAME + " ").append(name).append("=" + SEMANTIC_PLATFORM_FULL_NAME + GET_SEMANTIC_CLASS).append(range.getURI()).append("\");" + ENTER);
                            rangeNames.add(name);
                        }
                    }

                    staticClasses.add(range);
                }
            }
            boolean isInSuperInterface = false;
            for (SemanticClass cInterface : interfaces)
            {
                Iterator<SemanticProperty> propertiesInterface = cInterface.listProperties();
                while (propertiesInterface.hasNext())
                {
                    SemanticProperty tppInterface = propertiesInterface.next();
                    if (tppInterface.equals(tpp))
                    {
                        isInSuperInterface = true;
                        break;
                    }
                }
                if (isInSuperInterface)
                {
                    break;
                }
            }
            if (!isInSuperInterface)
            {
                String name = tpp.getPrefix() + "_" + tpp.getName();
                if (!rangeNames.contains(name))
                {
                    if(tpp.getComment(null)!=null)
                    {
                        javaClassContent.append("   /**"+ ENTER);
                        javaClassContent.append("   * ").append(tpp.getComment(null)).append(" "+ ENTER);
                        javaClassContent.append("   */"+ ENTER);
                    }
                    javaClassContent.append("    public static final " + SEMANTIC_PROPERTY_FULL_NAME + " ").append(name).append("=" + SEMANTIC_PLATFORM_FULL_NAME + ".getSemanticMgr().getVocabulary().getSemanticProperty(\"").append(tpp.getURI()).append("\");" + ENTER);
                    rangeNames.add(name);
                }

            }
        }
        String name = tpc.getPrefix() + "_" + tpc.getUpperClassName();
        if (!rangeNames.contains(name))
        {
            if(tpc.getComment(null)!=null)
            {
                javaClassContent.append("   /**"+ ENTER);
                javaClassContent.append("   * ").append(tpc.getComment(null)).append(" "+ ENTER);
                javaClassContent.append("   */"+ ENTER);
            }
            javaClassContent.append("    public static final " + SEMANTIC_CLASS_FULL_NAME + " ").append(name).append("=" + SEMANTIC_PLATFORM_FULL_NAME + GET_SEMANTIC_CLASS).append(tpc.getURI()).append("\");" + ENTER);
            rangeNames.add(name);
        }
        insertPropertiesToInterface(tpc, javaClassContent);
        javaClassContent.append("}" + ENTER);
        File fileClass = new File(dir.getPath() + File.separatorChar + tpc.getUpperClassName() + "Base" + ".java");
        try
        {
            System.out.println("Creando interface "+fileClass.getCanonicalPath());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        saveFile(fileClass, javaClassContent.toString());
        createInterface(tpc, pDirectory);
    }

    /**
     * Injects method definitions to manage object properties to an interface.
     * 
     * @param tpc the {@SemanticClass} wrapper for the {@SWBInterface} definition in the input ontology.
     * @param javaClassContent the java class content
     */
    private void insertPropertiesToInterface(SemanticClass tpc, StringBuilder javaClassContent)
    {
        Iterator<SemanticProperty> tppit = tpc.listProperties();
        while (tppit.hasNext())
        {
            SemanticProperty tpp = tppit.next();
            boolean isInClass = false;
            Iterator<SemanticClass> classes = tpc.listSuperClasses(true);
            while (classes.hasNext())
            {
                SemanticClass superclass = classes.next();
                if (superclass.isSWBInterface())
                {
                    Iterator<SemanticProperty> propInterfaces = superclass.listProperties();
                    while (propInterfaces.hasNext())
                    {
                        SemanticProperty propSuperClass = propInterfaces.next();
                        if (propSuperClass.equals(tpp))
                        {
                            isInClass = true;
                            break;
                        }
                    }
                    if (isInClass)
                    {
                        break;
                    }
                }
            }
            if (!isInClass)
            {

                if (tpp.isObjectProperty())
                {                    
                    String classToReturn=null;
                    SemanticClass cls = tpp.getRangeClass();
                    if (cls != null && cls.isSWB())
                    {
                        SemanticClass tpcToReturn = tpp.getRangeClass();
                        classToReturn=tpcToReturn.getCanonicalName();                        
                    }
                    else if (tpp.getRange() != null)
                    {
                        classToReturn=SEMANTIC_OBJECT_FULL_NAME;
                    }
                    String objectName = tpp.getPropertyCodeName(); //tpp.getLabel();
                    if (objectName == null)
                    {
                        objectName = tpp.getName();
                    }
                    objectName = toUpperCase(objectName);

                    if (objectName.toLowerCase().startsWith("has"))
                    {
                       SemanticClass clsrange = tpp.getRangeClass();
                        if (clsrange != null && clsrange.getURI() != null && clsrange.isSWB())
                        {
                            // son varios
                            objectName = objectName.substring(3);
                            javaClassContent.append(ENTER);
                            javaClassContent.append("    public " + GENERIC_ITERATOR_FULL_NAME + "<").append(classToReturn).append("> list").append(getPlural(objectName)).append("();" + ENTER);
                            javaClassContent.append("    public boolean has").append(objectName).append("(").append(classToReturn).append(" " + "value" + ");" + ENTER);
                            if (tpp.isInheritProperty())
                            {
                                javaClassContent.append("    public " + GENERIC_ITERATOR_FULL_NAME + "<").append(classToReturn).append("> listInherit").append(getPlural(objectName)).append("();" + ENTER);
                            }
                        }
                        else
                        {
                            // son varios
                            objectName = objectName.substring(3);
                            javaClassContent.append(ENTER);
                            javaClassContent.append("    public " + SEMANTIC_ITERATOR_FULL_NAME + "<").append(classToReturn).append("> list").append(getPlural(objectName)).append("();" + ENTER);
                            //TODO
                            //javaClassContent.append("    public boolean has" + objectName + "(" + pack + "." + valueToReturn + " " + "value" + ");" + ENTER);
                            if (tpp.isInheritProperty())
                            {
                                javaClassContent.append("    public " + SEMANTIC_ITERATOR_FULL_NAME + "<").append(classToReturn).append("> listInherit").append(getPlural(objectName)).append("();" + ENTER);
                            }
                        }

                        if (!tpp.hasInverse())
                        {
                            javaClassContent.append(ENTER);

                            javaClassContent.append("   /**"+ENTER);
                            javaClassContent.append("   * Adds the ").append(objectName).append(ENTER);
                            javaClassContent.append("   * @param value An instance of ").append(classToReturn).append(ENTER);
                            javaClassContent.append("   */"+ENTER);

                            javaClassContent.append("    public void add").append(objectName).append("(").append(classToReturn).append(" " + "value" + ");" + ENTER);
                            javaClassContent.append(ENTER);

                            javaClassContent.append("   /**"+ENTER);
                            javaClassContent.append("   * Remove all the values for the property ").append(objectName).append(ENTER);
                            javaClassContent.append("   */"+ENTER);

                            javaClassContent.append("    public void removeAll").append(objectName).append("();" + ENTER);
                            javaClassContent.append(ENTER);

                            javaClassContent.append("   /**"+ENTER);
                            javaClassContent.append("   * Remove a value from the property ").append(objectName).append(ENTER);
                            javaClassContent.append("   * @param value An instance of ").append(classToReturn).append(ENTER);
                            javaClassContent.append("   */"+ENTER);

                            javaClassContent.append("    public void remove").append(objectName).append("(").append(classToReturn).append(" " + "value" + ");" + ENTER);
                            javaClassContent.append(ENTER);

                            javaClassContent.append("/**"+ENTER);
                            javaClassContent.append("* Gets the ").append(objectName).append(ENTER);
                            javaClassContent.append("* @return a instance of ").append(classToReturn).append(ENTER);
                            javaClassContent.append("*/"+ENTER);

                            javaClassContent.append(PUBLIC).append(classToReturn).append(" get").append(objectName).append("();" + ENTER);
                        }
                    }
                    else
                    {
                        javaClassContent.append(ENTER);
                        String parameterName = "value";

                        javaClassContent.append("   /**"+ENTER);
                        javaClassContent.append("   * Sets a value from the property ").append(objectName).append(ENTER);
                        javaClassContent.append("   * @param value An instance of ").append(classToReturn).append(ENTER);
                        javaClassContent.append("   */"+ENTER);

                        javaClassContent.append("    public void set").append(objectName).append("(").append(classToReturn).append(" ").append(parameterName).append(");" + ENTER);
                        javaClassContent.append(ENTER);

                        javaClassContent.append("   /**"+ENTER);
                        javaClassContent.append("   * Remove the value from the property ").append(objectName).append(ENTER);
                        javaClassContent.append("   */"+ENTER);

                        javaClassContent.append("    public void remove").append(objectName).append("();" + ENTER);
                        javaClassContent.append(ENTER);
                        javaClassContent.append(PUBLIC).append(classToReturn).append(" get").append(objectName).append("();" + ENTER);
                    }

                }
                else if (tpp.isDataTypeProperty())
                {


                    String objectName = tpp.getPropertyCodeName(); //tpp.getLabel();
                    if (objectName == null)
                    {
                        objectName = tpp.getName();
                    }
                    objectName = toUpperCase(objectName);
                    if (objectName.toLowerCase().startsWith("has"))
                    {
                        String type = TYPE_VOID;
                        if (tpp.isString() || tpp.isXML())
                        {
                            type = "String";
                        }
                        else if (tpp.isInt())
                        {
                            type = TYPE_INT;
                        }
                        else if (tpp.isFloat())
                        {
                            type = TYPE_FLOAT;
                        }
                        else if (tpp.isDouble())
                        {
                            type = TYPE_DOUBLE;
                        }
                        else if (tpp.isLong())
                        {
                            type = TYPE_LONG;
                        }
                        else if (tpp.isByte())
                        {
                            type = TYPE_BYTE;
                        }
                        else if (tpp.isShort())
                        {
                            type = TYPE_SHORT;
                        }
                        else if (tpp.isBoolean())
                        {
                            type = TYPE_BOOLEAN;
                        }
                        else if (tpp.isDateTime() || tpp.isDate())
                        {
                            type = "java.util.Date";
                        }
                        else
                        {
                            throw new IllegalArgumentException("Data type '" + tpp.getRange() + "' is no supported");
                        }
                        // son varios

                        objectName = objectName.substring(3);
                        javaClassContent.append(ENTER);

                        javaClassContent.append("    public " + UTIL_ITERATOR_FULL_NAME + "<").append(type).append("> list").append(getPlural(objectName)).append("();" + ENTER);


                        if (!tpp.hasInverse())
                        {
                            javaClassContent.append(ENTER);
                            javaClassContent.append("    public void add").append(objectName).append("(").append(type).append(" value);" + ENTER);
                            javaClassContent.append("    public void removeAll").append(objectName).append("();" + ENTER);
                            javaClassContent.append("    public void remove").append(objectName).append("(").append(type).append(" value);" + ENTER);
                        }
                    }
                    else
                    {
                        String type = TYPE_VOID;
                        String prefix = "get";
                        String getMethod = "getProperty";
                        String setMethod = "setProperty";
                        if (tpp.isString() || tpp.isXML())
                        {
                            type = "String";
                            getMethod = "getProperty";
                            setMethod = "setProperty";
                        }
                        else if (tpp.isInt())
                        {
                            type = TYPE_INT;
                            getMethod = "getIntProperty";
                            setMethod = "setIntProperty";
                        }
                        else if (tpp.isFloat())
                        {
                            type = TYPE_FLOAT;
                            getMethod = "getFloatProperty";
                            setMethod = "setFloatProperty";
                        }
                        else if (tpp.isDouble())
                        {
                            type = TYPE_DOUBLE;
                            getMethod = "getDoubleProperty";
                            setMethod = "setDoubleProperty";
                        }
                        else if (tpp.isLong())
                        {
                            type = TYPE_LONG;
                            getMethod = "getLongProperty";
                            setMethod = "setLongProperty";
                        }
                        else if (tpp.isByte())
                        {
                            type = TYPE_BYTE;
                            getMethod = "getByteProperty";
                            setMethod = "setByteProperty";
                        }
                        else if (tpp.isShort())
                        {
                            type = TYPE_SHORT;
                            getMethod = "getShortProperty";
                            setMethod = "setShortProperty";
                        }
                        else if (tpp.isBoolean())
                        {
                            type = TYPE_BOOLEAN;
                            prefix = "is";
                            getMethod = "getBooleanProperty";
                            setMethod = "setBooleanProperty";
                        }
                        else if (tpp.isDateTime() || tpp.isDate())
                        {
                            type = "java.util.Date";
                            getMethod = "getDateProperty";
                            setMethod = "setDateProperty";
                        }
                        else if (tpp.isBinary())
                        {
                            type = "java.io.InputStream";
                            getMethod = "getInputStreamProperty";
                            setMethod = "setInputStreamProperty";
                        }
                        else
                        {
                            throw new IllegalArgumentException("Data type '" + tpp.getRange() + "' is no supported");
                        }

                        getMethod = "get" + "SemanticObject" + "()." + getMethod;
                        setMethod = "get" + "SemanticObject" + "()." + setMethod;

                        String label = tpp.getPropertyCodeName(); //tpp.getLabel();
                        if (label == null)
                        {
                            label = tpp.getName();
                        }
                        String methodName = toUpperCase(label);
                        String propertyName = tpp.getName();
                        if (propertyName.equals("protected"))
                        {
                            propertyName = "_" + propertyName;
                        }
                        javaClassContent.append(ENTER);
                        if (type.equals("java.io.InputStream"))
                        {
                            javaClassContent.append(PUBLIC).append(type).append(" ").append(prefix).append(methodName).append("() throws Exception;" + ENTER);
                        }
                        else
                        {
                            javaClassContent.append(PUBLIC).append(type).append(" ").append(prefix).append(methodName).append("();" + ENTER);
                        }                        

                        javaClassContent.append(ENTER);
                        if (type.equals("java.io.InputStream"))
                        {
                            javaClassContent.append(PUBLIC + "void set").append(methodName).append("(").append(type).append(" " + "value" + ",String name) throws Exception;" + ENTER);
                        }
                        else
                        {
                            javaClassContent.append(PUBLIC + "void set").append(methodName).append("(").append(type).append(" " + "value" + ");" + ENTER);
                        }                        

                        if (tpp.isLocaleable())
                        {
                            javaClassContent.append(ENTER);
                            javaClassContent.append(PUBLIC).append(type).append(" ").append(prefix).append(methodName).append("(String lang);" + ENTER);
                            if (type.equals("String"))
                            {
                                javaClassContent.append(ENTER);
                                javaClassContent.append(PUBLIC).append(type).append(" ").append(prefix).append("Display").append(methodName).append("(String lang);" + ENTER);
                            }

                            javaClassContent.append(ENTER);
                            javaClassContent.append(PUBLIC + "void set").append(methodName).append("(").append(type).append(" ").append(tpp.getName()).append(", String lang);" + ENTER);

                        }
                    }
                }
            }
        }
    }

    /**
     * Insert link to class4 model.
     * 
     * @param tpcls the tpcls
     * @param javaClassContent the java class content
     * @param parent the parent
     */
    private void insertLinkToClass4Model(SemanticClass tpcls, StringBuilder javaClassContent, SemanticClass parent)
    {
        //if ( parent == null ) // Already exists this method in the parent class
        {
            Iterator<SemanticClass> tpcit = tpcls.listOwnerModels();
            while (tpcit.hasNext())
            {
                SemanticClass tpc = tpcit.next();
                javaClassContent.append(ENTER);
                javaClassContent.append("   /**"+ ENTER);
                javaClassContent.append("   * Gets the ").append(tpc.getUpperClassName()).append(ENTER);
                javaClassContent.append("   * @return a instance of ").append(tpc.getCanonicalName()).append(ENTER);
                javaClassContent.append("   */"+ ENTER);
                javaClassContent.append("    public ").append(tpc.getCanonicalName()).append(" get").append(tpc.getUpperClassName()).append("()" + ENTER);
                javaClassContent.append("    {" + ENTER);
                javaClassContent.append("        return (").append(tpc.getCanonicalName()).append(")getSemanticObject().getModel().getModelObject().createGenericInstance();" + ENTER);
                javaClassContent.append("    }" + ENTER);
            }
        }
    }

    

    /**
     * Insert properties to model.
     * 
     * @param tpcls the tpcls
     * @param javaClassContent the java class content
     */
    private void insertPropertiesToModel(SemanticClass tpcls, StringBuilder javaClassContent)
    {

        Iterator<SemanticClass> tpcit = tpcls.listModelClasses();
        while (tpcit.hasNext())
        {

            SemanticClass tpc = tpcit.next();
            javaClassContent.append(ENTER);

            javaClassContent.append("    public ").append(tpc.getCanonicalName()).append(" get").append(tpc.getUpperClassName()).append("(String id)" + ENTER);
            javaClassContent.append("    {" + ENTER);
            javaClassContent.append("        return ").append(tpc.getCanonicalName()).append("." + GLOBAL_CLASS_NAME + ".get").append(tpc.getUpperClassName()).append("(id, this);" + ENTER);
            javaClassContent.append("    }" + ENTER);
            javaClassContent.append(ENTER);

            javaClassContent.append("    public " + UTIL_ITERATOR_FULL_NAME + "<").append(tpc.getCanonicalName()).append("> list").append(tpc.getNameInPlural()).append("()" + ENTER);
            javaClassContent.append("    {" + ENTER);
            javaClassContent.append("        return ").append(tpc.getCanonicalName()).append("." + GLOBAL_CLASS_NAME + ".list").append(tpc.getNameInPlural()).append("(this);" + ENTER);
            javaClassContent.append("    }" + ENTER);

            javaClassContent.append(ENTER);
            javaClassContent.append("    public ").append(tpc.getCanonicalName()).append(" create").append(tpc.getUpperClassName()).append("(String id)" + ENTER);
            javaClassContent.append("    {" + ENTER);
            javaClassContent.append("        return ").append(tpc.getCanonicalName()).append("." + GLOBAL_CLASS_NAME + ".create").append(tpc.getUpperClassName()).append("(id,this);" + ENTER);
            javaClassContent.append("    }" + ENTER);

            if (tpc.isAutogenId())
            {
                javaClassContent.append(ENTER);
                javaClassContent.append("    public ").append(tpc.getCanonicalName()).append(" create").append(tpc.getUpperClassName()).append("()" + ENTER);
                javaClassContent.append("    {" + ENTER);
                javaClassContent.append("        long id=getSemanticObject().getModel().getCounter(").append(tpc.getPrefix()).append("_").append(tpc.getUpperClassName()).append(");" + ENTER);
                javaClassContent.append("        return ").append(tpc.getCanonicalName()).append("." + GLOBAL_CLASS_NAME + ".create").append(tpc.getUpperClassName()).append("(String.valueOf(id),this);" + ENTER);
                javaClassContent.append("    } " + ENTER);



            }
            javaClassContent.append(ENTER);
            javaClassContent.append("    public void remove").append(tpc.getUpperClassName()).append("(String id)" + ENTER);
            javaClassContent.append("    {" + ENTER);
            javaClassContent.append("        ").append(tpc.getCanonicalName()).append("." + GLOBAL_CLASS_NAME + ".remove").append(tpc.getUpperClassName()).append("(id, this);" + ENTER);
            javaClassContent.append("    }" + ENTER);

            javaClassContent.append("    public boolean has").append(tpc.getUpperClassName()).append("(String id)" + ENTER);
            javaClassContent.append("    {" + ENTER);
            javaClassContent.append("        return ").append(tpc.getCanonicalName()).append("." + GLOBAL_CLASS_NAME + ".has").append(tpc.getUpperClassName()).append("(id, this);" + ENTER);
            javaClassContent.append("    }" + ENTER);
        }

    }

    /**
     * Checks if is property of parent.
     * 
     * @param tpp the tpp
     * @param parent the parent
     * @return true, if is property of parent
     */
    private boolean isPropertyOfParent(SemanticProperty tpp, SemanticClass parent)
    {
        boolean isPropertyOfParent = false;
        if (parent != null)
        {
            Iterator<SemanticProperty> properties = parent.listProperties();
            while (properties.hasNext())
            {
                SemanticProperty propertyOfParent = properties.next();
                if (getNameOfProperty(propertyOfParent).equals(getNameOfProperty(tpp)))
                {
                    isPropertyOfParent = true;
                    break;
                }
            }
        }
        return isPropertyOfParent;
    }

    /**
     * Gets the name of property.
     * 
     * @param tpp the tpp
     * @return the name of property
     */
    private String getNameOfProperty(SemanticProperty tpp)
    {
        String objectName = tpp.getPropertyCodeName();//tpp.getLabel();
        if (objectName == null)
        {
            objectName = tpp.getName();
        }
        return objectName;
    }

    /**
     * Insert data type property.
     * 
     * @param tpc the tpc
     * @param tpp the tpp
     * @param javaClassContent the java class content
     * @param semanticObject the semantic object
     */
    private void insertDataTypeProperty(SemanticClass tpc, SemanticProperty tpp, StringBuilder javaClassContent, String semanticObject)
    {
        String objectName = tpp.getPropertyCodeName();
        if (objectName == null)
        {
            objectName = tpp.getName();
        }
        objectName = toUpperCase(objectName);

        if (objectName.toLowerCase().startsWith("has"))
        {
            String type = TYPE_VOID;
            if (tpp.isString() || tpp.isXML())
            {
                type = "String";
            }
            else if (tpp.isInt())
            {
                type = TYPE_INT;
            }
            else if (tpp.isFloat())
            {
                type = TYPE_FLOAT;
            }
            else if (tpp.isDouble())
            {
                type = TYPE_DOUBLE;
            }
            else if (tpp.isLong())
            {
                type = TYPE_LONG;
            }
            else if (tpp.isByte())
            {
                type = TYPE_BYTE;
            }
            else if (tpp.isShort())
            {
                type = TYPE_SHORT;
            }
            else if (tpp.isBoolean())
            {
                type = TYPE_BOOLEAN;
            }
            else if (tpp.isDateTime() || tpp.isDate())
            {
                type = "java.util.Date";
            }
            else
            {
                throw new IllegalArgumentException("Data type '" + tpp.getRange() + "' is no supported");
            }
            // son varios

            objectName = objectName.substring(3);
            javaClassContent.append(ENTER);

            javaClassContent.append("    public " + UTIL_ITERATOR_FULL_NAME + "<").append(type).append("> list").append(getPlural(objectName)).append("()" + ENTER);
            javaClassContent.append(OPEN_BLOCK + ENTER);


            javaClassContent.append("        java.util.ArrayList<").append(type).append("> values=new java.util.ArrayList<").append(type).append(">();" + ENTER);
            javaClassContent.append("        " + UTIL_ITERATOR_FULL_NAME + "<" + SEMANTIC_LITERAL_FULL_NAME + "> it=getSemanticObject().listLiteralProperties(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(");" + ENTER);
            javaClassContent.append("        while(it.hasNext())" + ENTER);
            javaClassContent.append("        {" + ENTER);
            javaClassContent.append("                "+SEMANTIC_LITERAL_FULL_NAME+" literal=it.next();" + ENTER);
            javaClassContent.append("                values.add(literal.getString());" + ENTER);
            javaClassContent.append("        }" + ENTER);
            javaClassContent.append("        return values.iterator();" + ENTER);

            javaClassContent.append(CLOSE_BLOCK + ENTER);

            if (!tpp.hasInverse())
            {
                javaClassContent.append(ENTER);
                javaClassContent.append("    public void add").append(objectName).append("(").append(type).append(" value)" + ENTER);
                javaClassContent.append(OPEN_BLOCK + ENTER);
                javaClassContent.append("        get").append(semanticObject).append("().addLiteralProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", new "+SEMANTIC_LITERAL_FULL_NAME+"(value));" + ENTER);
                javaClassContent.append(CLOSE_BLOCK + ENTER);
                javaClassContent.append(ENTER);
                javaClassContent.append("    public void removeAll").append(objectName).append("()" + ENTER);
                javaClassContent.append(OPEN_BLOCK + ENTER);
                javaClassContent.append("        get").append(semanticObject).append("().removeProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(");" + ENTER);
                javaClassContent.append(CLOSE_BLOCK + ENTER);
                javaClassContent.append(ENTER);
                javaClassContent.append("    public void remove").append(objectName).append("(").append(type).append(" value)" + ENTER);
                javaClassContent.append(OPEN_BLOCK + ENTER);
                javaClassContent.append("        get").append(semanticObject).append("().removeLiteralProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(",new org.semanticwb.platform.SemanticLiteral(value));" + ENTER);
                javaClassContent.append(CLOSE_BLOCK + ENTER);
            }

        }
        else
        {
            String type = TYPE_VOID;
            String prefix = "get";
            String getMethod = "getProperty";
            String setMethod = "setProperty";
            if (tpp.isString() || tpp.isXML())
            {
                type = "String";
                getMethod = "getProperty";
                setMethod = "setProperty";
            }
            else if (tpp.isInt())
            {
                type = TYPE_INT;
                getMethod = "getIntProperty";
                setMethod = "setIntProperty";
            }
            else if (tpp.isFloat())
            {
                type = TYPE_FLOAT;
                getMethod = "getFloatProperty";
                setMethod = "setFloatProperty";
            }
            else if (tpp.isDouble())
            {
                type = TYPE_DOUBLE;
                getMethod = "getDoubleProperty";
                setMethod = "setDoubleProperty";
            }
            else if (tpp.isLong())
            {
                type = TYPE_LONG;
                getMethod = "getLongProperty";
                setMethod = "setLongProperty";
            }
            else if (tpp.isByte())
            {
                type = TYPE_BYTE;
                getMethod = "getByteProperty";
                setMethod = "setByteProperty";
            }
            else if (tpp.isShort())
            {
                type = TYPE_SHORT;
                getMethod = "getShortProperty";
                setMethod = "setShortProperty";
            }
            else if (tpp.isBoolean())
            {
                type = TYPE_BOOLEAN;
                prefix = "is";
                getMethod = "getBooleanProperty";
                setMethod = "setBooleanProperty";
            }
            else if (tpp.isDateTime() || tpp.isDate())
            {
                type = "java.util.Date";
                getMethod = "getDateProperty";
                setMethod = "setDateProperty";
            }
            else if (tpp.isBinary())
            {
                type = "java.io.InputStream";
                getMethod = "getInputStreamProperty";
                setMethod = "setInputStreamProperty";
            }
            else
            {
                throw new IllegalArgumentException("Data type '" + tpp.getRange() + "' is no supported, from class:" + tpc + ", property:" + tpp);
            }

            getMethod = "get" + semanticObject + "()." + getMethod;
            setMethod = "get" + semanticObject + "()." + setMethod;

            String label = tpp.getPropertyCodeName(); //tpp.getLabel();
            if (label == null)
            {
                label = tpp.getName();
            }
            String methodName = toUpperCase(label);
            String propertyName = tpp.getName();
            if (propertyName.equals("protected"))
            {
                propertyName = "_" + propertyName;
            }
            javaClassContent.append(ENTER);
            if (type.equals("java.io.InputStream"))
            {
                javaClassContent.append(PUBLIC).append(type).append(" ").append(prefix).append(methodName).append("() throws Exception" + ENTER);
            }
            else
            {
                javaClassContent.append("/**"+ ENTER);
                javaClassContent.append("* Gets the ").append(methodName).append(" property"+ ENTER);
                javaClassContent.append("* @return ").append(type).append(" with the ").append(methodName).append(""+ ENTER);
                javaClassContent.append("*/"+ ENTER);

                javaClassContent.append(PUBLIC).append(type).append(" ").append(prefix).append(methodName).append("()" + ENTER);
            }
            javaClassContent.append(OPEN_BLOCK + ENTER);
            if (tpp.isExternalInvocation())
            {
                javaClassContent.append("        //Override this method in ").append(tpc.getUpperClassName()).append(" object" + ENTER);
                javaClassContent.append("        return ").append(getMethod).append("(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(",false);" + ENTER);
            }
            else
            {
                javaClassContent.append("        return ").append(getMethod).append("(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(");" + ENTER);
            }
            javaClassContent.append(CLOSE_BLOCK + ENTER);

            javaClassContent.append(ENTER);
            if (type.equals("java.io.InputStream"))
            {
                javaClassContent.append(PUBLIC + "void set").append(methodName).append("(").append(type).append(" " + "value" + ",String name) throws Exception" + ENTER);
            }
            else
            {
                javaClassContent.append("/**"+ ENTER);
                javaClassContent.append("* Sets the ").append(methodName).append(" property"+ ENTER);
                javaClassContent.append("* @param value long with the ").append(methodName).append(ENTER);
                javaClassContent.append("*/"+ ENTER);
                javaClassContent.append(PUBLIC + "void set").append(methodName).append("(").append(type).append(" " + "value" + ")" + ENTER);
            }
            javaClassContent.append(OPEN_BLOCK + ENTER);
            if (tpp.isExternalInvocation())
            {
                javaClassContent.append("        //Override this method in ").append(tpc.getUpperClassName()).append(" object" + ENTER);
                if (type.equals("java.io.InputStream"))
                {
                    javaClassContent.append("        throw new org.semanticwb.SWBMethodImplementationRequiredException();" + ENTER);
                }
                else
                {
                    javaClassContent.append("        ").append(setMethod).append("(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", " + "value" + ",false);" + ENTER);
                }
            }
            else
            {
                if (type.equals("java.io.InputStream"))
                {
                    javaClassContent.append("        ").append(setMethod).append("(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", " + "value" + ",name);" + ENTER);
                }
                else
                {
                    javaClassContent.append("        ").append(setMethod).append("(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", " + "value" + ");" + ENTER);
                }
            }
            javaClassContent.append(CLOSE_BLOCK + ENTER);

            if (tpp.isLocaleable())
            {
                javaClassContent.append(ENTER);
                javaClassContent.append(PUBLIC).append(type).append(" ").append(prefix).append(methodName).append("(String lang)" + ENTER);
                javaClassContent.append(OPEN_BLOCK + ENTER);
                if (tpp.isExternalInvocation())
                {
                    javaClassContent.append("        //Override this method in ").append(tpc.getUpperClassName()).append(" object" + ENTER);
                    javaClassContent.append("        return ").append(getMethod).append("(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", null, lang,false);" + ENTER);

                }
                else
                {
                    javaClassContent.append("        return ").append(getMethod).append("(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", null, lang);" + ENTER);
                }
                javaClassContent.append(CLOSE_BLOCK + ENTER);

                if (type.equals("String"))
                {
                    javaClassContent.append(ENTER);
                    javaClassContent.append(PUBLIC).append(type).append(" ").append(prefix).append("Display").append(methodName).append("(String lang)" + ENTER);
                    javaClassContent.append(OPEN_BLOCK + ENTER);
                    javaClassContent.append("        return " + "get").append(semanticObject).append("().getLocaleProperty" + "(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", lang);" + ENTER);
                    javaClassContent.append(CLOSE_BLOCK + ENTER);
                }

                javaClassContent.append(ENTER);
                javaClassContent.append(PUBLIC + "void set").append(methodName).append("(").append(type).append(" ").append(tpp.getName()).append(", String lang)" + ENTER);
                javaClassContent.append(OPEN_BLOCK + ENTER);
                if (tpp.isExternalInvocation())
                {

                    javaClassContent.append("        //Override this method in ").append(tpc.getUpperClassName()).append(" object" + ENTER);
                    javaClassContent.append("        ").append(setMethod).append("(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", ").append(tpp.getName()).append(", lang,false);" + ENTER);

                }
                else
                {
                    javaClassContent.append("        ").append(setMethod).append("(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", ").append(tpp.getName()).append(", lang);" + ENTER);
                }
                javaClassContent.append(CLOSE_BLOCK + ENTER);
            }
        }

    }

    /**
     * Insert object property.
     * 
     * @param tpc the tpc
     * @param tpp the tpp
     * @param javaClassContent the java class content
     * @param semanticObject the semantic object
     */
    private void insertObjectProperty(SemanticClass tpc, SemanticProperty tpp, StringBuilder javaClassContent, String semanticObject)
    {
        SemanticClass cls = tpp.getRangeClass();
        //System.out.println(cls.isSWB()+" "+cls.isSWBVirtualClass()+" "+isGenerateVirtualClasses());
        if (cls != null && cls.getURI() != null && (cls.isSWB() || (cls.isSWBVirtualClass() && isGenerateVirtualClasses())))
        {
            String objectName = tpp.getPropertyCodeName();
            if (objectName == null)
            {
                objectName = tpp.getName();
            }
            objectName = toUpperCase(objectName);
            SemanticClass tpcToReturn = tpp.getRangeClass();
            if (objectName.toLowerCase().startsWith("has"))
            {
                // son varios
                objectName = objectName.substring(3);



                javaClassContent.append("   /**"+ ENTER);
                javaClassContent.append("   * Gets all the ").append(tpcToReturn.getCanonicalName()).append(""+ ENTER);
                javaClassContent.append("   * @return A GenericIterator with all the ").append(tpcToReturn.getCanonicalName()).append(""+ ENTER);
                javaClassContent.append("   */"+ ENTER);

                javaClassContent.append(ENTER);
                javaClassContent.append("    public " + GENERIC_ITERATOR_FULL_NAME + "<").append(tpcToReturn.getCanonicalName()).append("> list").append(getPlural(objectName)).append("()" + ENTER);
                javaClassContent.append(OPEN_BLOCK + ENTER);
                javaClassContent.append("        return new " + GENERIC_ITERATOR_FULL_NAME + "<").append(tpcToReturn.getCanonicalName()).append(">(getSemanticObject().listObjectProperties(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append("));" + ENTER);
                javaClassContent.append(CLOSE_BLOCK + ENTER);
                javaClassContent.append(ENTER);

                javaClassContent.append("   /**"+ ENTER);
                javaClassContent.append("   * Gets true if has a ").append(objectName).append(""+ ENTER);
                javaClassContent.append("   * @param value ").append(tpcToReturn.getCanonicalName()).append(" to verify"+ ENTER);
                javaClassContent.append("   * @return true if the ").append(tpcToReturn.getCanonicalName()).append(" exists, false otherwise"+ ENTER);
                javaClassContent.append("   */"+ ENTER);

                javaClassContent.append("    public boolean has").append(objectName).append("(").append(tpcToReturn.getCanonicalName()).append(" " + "value" + ")" + ENTER);
                javaClassContent.append(OPEN_BLOCK + ENTER);
                javaClassContent.append("        boolean ret=false;" + ENTER);
                javaClassContent.append("        if(" + "value" + "!=null)" + ENTER);
                javaClassContent.append("        {" + ENTER);
                javaClassContent.append("           ret=get").append(semanticObject).append("().hasObjectProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append("," + "value" + ".getSemanticObject());" + ENTER);
                javaClassContent.append("        }" + ENTER);
                javaClassContent.append("        return ret;" + ENTER);
                javaClassContent.append(CLOSE_BLOCK + ENTER);
                if (tpp.isInheritProperty())
                {

                    javaClassContent.append(ENTER);

                    javaClassContent.append("   /**"+ ENTER);
                    javaClassContent.append("   * Gets all the ").append(getPlural(objectName)).append(" inherits"+ ENTER);
                    javaClassContent.append("   * @return A GenericIterator with all the ").append(tpcToReturn.getCanonicalName()).append(""+ ENTER);
                    javaClassContent.append("   */"+ ENTER);

                    javaClassContent.append("    public " + GENERIC_ITERATOR_FULL_NAME + "<").append(tpcToReturn.getCanonicalName()).append("> listInherit").append(getPlural(objectName)).append("()" + ENTER);
                    javaClassContent.append(OPEN_BLOCK + ENTER);
                    javaClassContent.append("        return new " + GENERIC_ITERATOR_FULL_NAME + "<").append(tpcToReturn.getCanonicalName()).append(">(getSemanticObject().listInheritProperties(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append("));" + ENTER);
                    javaClassContent.append(CLOSE_BLOCK + ENTER);
                }

                if (!tpp.hasInverse())
                {
                    javaClassContent.append("   /**"+ ENTER);
                    javaClassContent.append("   * Adds a ").append(objectName).append(""+ ENTER);
                    javaClassContent.append("   * @param value ").append(tpcToReturn.getCanonicalName()).append(" to add"+ ENTER);
                    javaClassContent.append("   */"+ ENTER);

                    javaClassContent.append(ENTER);
                    javaClassContent.append("    public void add").append(objectName).append("(").append(tpcToReturn.getCanonicalName()).append(" " + "value" + ")" + ENTER);
                    javaClassContent.append(OPEN_BLOCK + ENTER);
                    javaClassContent.append("        get").append(semanticObject).append("().addObjectProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", " + "value" + ".getSemanticObject());" + ENTER);
                    javaClassContent.append(CLOSE_BLOCK + ENTER);


                    javaClassContent.append("   /**"+ ENTER);
                    javaClassContent.append("   * Removes all the ").append(objectName).append(""+ ENTER);
                    javaClassContent.append("   */"+ ENTER);



                    javaClassContent.append(ENTER);
                    javaClassContent.append("    public void removeAll").append(objectName).append("()" + ENTER);
                    javaClassContent.append(OPEN_BLOCK + ENTER);
                    javaClassContent.append("        get").append(semanticObject).append("().removeProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(");" + ENTER);
                    javaClassContent.append(CLOSE_BLOCK + ENTER);

                    javaClassContent.append("   /**"+ ENTER);
                    javaClassContent.append("   * Removes a ").append(objectName).append(""+ ENTER);
                    javaClassContent.append("   * @param value ").append(tpcToReturn.getCanonicalName()).append(" to remove"+ ENTER);
                    javaClassContent.append("   */"+ ENTER);

                    javaClassContent.append(ENTER);
                    javaClassContent.append("    public void remove").append(objectName).append("(").append(tpcToReturn.getCanonicalName()).append(" " + "value" + ")" + ENTER);
                    javaClassContent.append(OPEN_BLOCK + ENTER);
                    javaClassContent.append("        get").append(semanticObject).append("().removeObjectProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append("," + "value" + ".getSemanticObject());" + ENTER);
                    javaClassContent.append(CLOSE_BLOCK + ENTER);
                }
            }
            else
            {
                javaClassContent.append("   /**"+ ENTER);
                javaClassContent.append("   * Sets the value for the property ").append(objectName).append(ENTER);
                javaClassContent.append("   * @param value ").append(objectName).append(" to set"+ ENTER);
                javaClassContent.append("   */"+ ENTER);

                javaClassContent.append(ENTER);
                javaClassContent.append("    public void set").append(objectName).append("(").append(tpcToReturn.getCanonicalName()).append(" " + "value" + ")" + ENTER);
                javaClassContent.append(OPEN_BLOCK + ENTER);
                javaClassContent.append("        if(value!=null)" + ENTER);
                javaClassContent.append("        {" + ENTER);
                javaClassContent.append("            get").append(semanticObject).append("().setObjectProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", " + "value" + ".getSemanticObject());" + ENTER);
                javaClassContent.append("        }else" + ENTER);
                javaClassContent.append("        {" + ENTER);
                javaClassContent.append("            remove").append(objectName).append("();" + ENTER);
                javaClassContent.append("        }" + ENTER);
                javaClassContent.append(CLOSE_BLOCK + ENTER);


                javaClassContent.append("   /**"+ ENTER);
                javaClassContent.append("   * Remove the value for ").append(objectName).append(" property"+ ENTER);
                javaClassContent.append("   */"+ ENTER);
                javaClassContent.append(ENTER);
                javaClassContent.append("    public void remove").append(objectName).append("()" + ENTER);
                javaClassContent.append(OPEN_BLOCK + ENTER);
                javaClassContent.append("        get").append(semanticObject).append("().removeProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(");" + ENTER);
                javaClassContent.append(CLOSE_BLOCK + ENTER);
            }

            String nameList = tpp.getPropertyCodeName();
            if (nameList.startsWith("has"))
            {
                nameList = nameList.substring(3);
            }

            javaClassContent.append(ENTER);

            javaClassContent.append("   /**"+ ENTER);
            javaClassContent.append("   * Gets the ").append(objectName).append(""+ ENTER);
            javaClassContent.append("   * @return a ").append(tpcToReturn.getCanonicalName()).append(""+ ENTER);
            javaClassContent.append("   */"+ ENTER);

            javaClassContent.append(PUBLIC).append(tpcToReturn.getCanonicalName()).append(" get").append(objectName).append("()" + ENTER);
            javaClassContent.append(OPEN_BLOCK + ENTER);
            javaClassContent.append("         ").append(tpcToReturn.getCanonicalName()).append(" ret=null;" + ENTER);
            javaClassContent.append("         " + SEMANTIC_OBJECT_FULL_NAME + " obj=getSemanticObject().getObjectProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(");" + ENTER);
            javaClassContent.append("         if(obj!=null)" + ENTER);
            javaClassContent.append("         {" + ENTER);
            javaClassContent.append("             ret=(").append(tpcToReturn.getCanonicalName()).append(")obj.createGenericInstance();" + ENTER);
            javaClassContent.append("         }" + ENTER);
            javaClassContent.append("         return ret;" + ENTER);
            javaClassContent.append(CLOSE_BLOCK + ENTER);
        }
        else if (tpp.getRange() != null)
        {
            String classToReturn=SEMANTIC_OBJECT_FULL_NAME;
            String objectName = tpp.getPropertyCodeName(); //tpp.getLabel();
            if (objectName == null)
            {
                objectName = tpp.getName();
            }
            objectName = toUpperCase(objectName);

            if (objectName.toLowerCase().startsWith("has"))
            {
                // son varios
                objectName = objectName.substring(3);
                javaClassContent.append(ENTER);
                javaClassContent.append("    public " + SEMANTIC_ITERATOR_FULL_NAME + "<").append(classToReturn).append("> list").append(getPlural(objectName)).append("()" + ENTER);
                javaClassContent.append(OPEN_BLOCK + ENTER);
//                
                javaClassContent.append("        " + JENA_ITERATOR_FULL_NAME + " stit=getSemanticObject().getRDFResource().listProperties(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(".getRDFProperty());" + ENTER);
                javaClassContent.append("        return new " + SEMANTIC_ITERATOR_FULL_NAME + "<").append(classToReturn).append(">(stit);" + ENTER);
//               
                javaClassContent.append(CLOSE_BLOCK + ENTER);

                if (!tpp.hasInverse())
                {
                    javaClassContent.append(ENTER);
                    javaClassContent.append("    public void add").append(objectName).append("(").append(classToReturn).append(" " + "value" + ")" + ENTER);
                    javaClassContent.append(OPEN_BLOCK + ENTER);
                    javaClassContent.append("        get").append(semanticObject).append("().addObjectProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", " + "value" + ");" + ENTER);
                    javaClassContent.append(CLOSE_BLOCK + ENTER);

                    javaClassContent.append(ENTER);
                    javaClassContent.append("    public void removeAll").append(objectName).append("()" + ENTER);
                    javaClassContent.append(OPEN_BLOCK + ENTER);
                    javaClassContent.append("        get").append(semanticObject).append("().removeProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(");" + ENTER);
                    javaClassContent.append(CLOSE_BLOCK + ENTER);

                    javaClassContent.append(ENTER);
                    javaClassContent.append("    public void remove").append(objectName).append("(").append(classToReturn).append(" value)" + ENTER);
                    javaClassContent.append(OPEN_BLOCK + ENTER);
                    javaClassContent.append("        get").append(semanticObject).append("().removeObjectProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(",value);" + ENTER);
                    javaClassContent.append(CLOSE_BLOCK + ENTER);
                }
            }
            else
            {
                javaClassContent.append(ENTER);
                javaClassContent.append("    public void set").append(objectName).append("(").append(classToReturn).append(" " + "value" + ")" + ENTER);
                javaClassContent.append(OPEN_BLOCK + ENTER);
                javaClassContent.append("        get").append(semanticObject).append("().setObjectProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(", " + "value" + ");" + ENTER);
                javaClassContent.append(CLOSE_BLOCK + ENTER);

                javaClassContent.append(ENTER);
                javaClassContent.append("    public void remove").append(objectName).append("()" + ENTER);
                javaClassContent.append(OPEN_BLOCK + ENTER);
                javaClassContent.append("        get").append(semanticObject).append("().removeProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(");" + ENTER);
                javaClassContent.append(CLOSE_BLOCK + ENTER);
            }

            javaClassContent.append(ENTER);
            javaClassContent.append("/**"+ ENTER);
            javaClassContent.append("* Gets the ").append(objectName).append(" property"+ ENTER);
            javaClassContent.append("* @return the value for the property as ").append(classToReturn).append(""+ ENTER);
            javaClassContent.append("*/"+ ENTER);

            javaClassContent.append(PUBLIC).append(classToReturn).append(" get").append(objectName).append("()" + ENTER);
            javaClassContent.append(OPEN_BLOCK + ENTER);
            javaClassContent.append("         ").append(classToReturn).append(" ret=null;" + ENTER);
            javaClassContent.append("         ret=get").append(semanticObject).append("().getObjectProperty(").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(");" + ENTER);
            javaClassContent.append("         return ret;" + ENTER);
            javaClassContent.append(CLOSE_BLOCK + ENTER);
        }
    }

    /**
     * Insert properties to class.
     * 
     * @param tpc the tpc
     * @param javaClassContent the java class content
     * @param parent the parent
     */
    private void insertPropertiesToClass(SemanticClass tpc, StringBuilder javaClassContent, SemanticClass parent)
    {
        insertPropertiesToClass(tpc, javaClassContent, parent, null);
    }

    /**
     * Insert properties to class.
     * 
     * @param tpc the tpc
     * @param javaClassContent the java class content
     * @param parent the parent
     * @param semanticObject the semantic object
     */
    private void insertPropertiesToClass(SemanticClass tpc, StringBuilder javaClassContent, SemanticClass parent, String semanticObject)
    {
        if (semanticObject == null)
        {
            semanticObject = "SemanticObject";
        }
        Iterator<SemanticProperty> tppit = tpc.listProperties();
        while (tppit.hasNext())
        {
            SemanticProperty tpp = tppit.next();
            if (!isPropertyOfParent(tpp, parent))
            {
                if (tpp.isObjectProperty())
                {
                    insertObjectProperty(tpc, tpp, javaClassContent, semanticObject);
                }
                else if (tpp.isDataTypeProperty())
                {
                    insertDataTypeProperty(tpc, tpp, javaClassContent, semanticObject);
                }
            }
        }
    }

    /**
     * Creates the vocabulary.
     * 
     * @param pPackage the package
     * @param pDirectory the directory
     * @throws CodeGeneratorException the code generator exception
     */
    public void createVocabulary(String pPackage, File pDirectory) throws CodeGeneratorException
    {
        StringBuilder javaClassContent = new StringBuilder();
        String sPackage = pPackage;
        javaClassContent.append("package ").append(sPackage).append(";\r\n" + ENTER);
        javaClassContent.append("import "+SEMANTIC_PLATFORM_FULL_NAME+";" + ENTER);
        javaClassContent.append("import org.semanticwb.platform.SemanticVocabulary;" + ENTER);
        javaClassContent.append("import "+SEMANTIC_CLASS_FULL_NAME+";" + ENTER);
        javaClassContent.append("import "+SEMANTIC_PROPERTY_FULL_NAME+";" + ENTER);
        javaClassContent.append("import java.util.Hashtable;" + ENTER);
        //javaClassContent.append("import static org.semanticwb.platform.SemanticVocabulary.URI;\r\n" + ENTER);
        javaClassContent.append("public class SWBVocabulary" + ENTER);
        javaClassContent.append("{" + ENTER);
        javaClassContent.append("\r\n\r\n    //Classes" + ENTER);
        SemanticMgr mgr = SWBPlatform.getSemanticMgr();
        Iterator<SemanticClass> tpcit = mgr.getVocabulary().listSemanticClasses();
        while (tpcit.hasNext())
        {
            SemanticClass tpc = tpcit.next();
            javaClassContent.append("    public final SemanticClass ").append(tpc.getPrefix()).append("_").append(tpc.getUpperClassName()).append(";" + ENTER);
        }

        javaClassContent.append("\r\n\r\n\r\n    //Properties" + ENTER);
        HashSet<String> properties = new HashSet<String>();
        tpcit = mgr.getVocabulary().listSemanticClasses();
        while (tpcit.hasNext())
        {
            SemanticClass tpc = tpcit.next();
            Iterator<SemanticProperty> tppit = tpc.listProperties();
            while (tppit.hasNext())
            {
                SemanticProperty tpp = tppit.next();
                if (!properties.contains(tpp.getPrefix() + "_" + tpp.getName()))
                {
                    properties.add(tpp.getPrefix() + "_" + tpp.getName());
                    javaClassContent.append("    public final " + SEMANTIC_PROPERTY_FULL_NAME + " ").append(tpp.getPrefix()).append("_").append(tpp.getName()).append(";" + ENTER);
                }
            }
        }
        javaClassContent.append("\r\n" + ENTER);
        //javaClassContent.append("    @Override"+ENTER);
        javaClassContent.append("    public SWBVocabulary()" + ENTER);
        javaClassContent.append("    {\r\n" + ENTER);
        javaClassContent.append("         SemanticVocabulary vocabulary=SWBPlatform.getSemanticMgr().getVocabulary();" + ENTER);
        javaClassContent.append("        // Classes" + ENTER);
        tpcit = mgr.getVocabulary().listSemanticClasses();
        Hashtable<String, String> namespaces = new Hashtable<String, String>();
        while (tpcit.hasNext())
        {
            SemanticClass tpc = tpcit.next();
            int pos = tpc.getURI().indexOf("#");
            String uri = tpc.getURI();
            if (pos != -1)
            {
                uri = uri.substring(0, pos + 1);
            }
            namespaces.put(tpc.getPrefix(), uri);
            javaClassContent.append("        ").append(tpc.getPrefix()).append("_").append(tpc.getUpperClassName()).append("=vocabulary.getSemanticClass(\"").append(tpc.getURI()).append("\");" + ENTER);
        }


        javaClassContent.append("\r\n\r\n\r\n        //Properties" + ENTER);
        tpcit = mgr.getVocabulary().listSemanticClasses();
        properties = new HashSet<String>();
        while (tpcit.hasNext())
        {
            SemanticClass tpc = tpcit.next();
            /*Iterator<SemanticProperty> requiredProperties=tpc.listRequiredProperties();
            while(requiredProperties.hasNext())
            {
            SemanticProperty tpp = requiredProperties.next();
            String propertyName=tpp.getPrefix() + "_" + tpp.getName();
            if ( !properties.contains(propertyName) )
            {
            properties.add(propertyName);
            if ( !tpp.getURI().equals("#") )
            {
            int pos = tpp.getURI().indexOf("#");
            String uri = tpp.getURI();
            if ( pos != -1 )
            {
            uri = uri.substring(0, pos+1);
            }
            namespaces.put(tpp.getPrefix(), uri);
            }
            javaClassContent.append("        " + propertyName + "=vocabulary.getSemanticProperty(\"" + tpp.getURI() + "\");" + ENTER);
            }
            }*/
            Iterator<SemanticProperty> tppit = tpc.listProperties();
            while (tppit.hasNext())
            {
                SemanticProperty tpp = tppit.next();
                String propertyName = tpp.getPrefix() + "_" + tpp.getName();
                if (!properties.contains(propertyName))
                {
                    properties.add(propertyName);
                    if (!tpp.getURI().equals("#"))
                    {
                        int pos = tpp.getURI().indexOf("#");
                        String uri = tpp.getURI();
                        if (pos != -1)
                        {
                            uri = uri.substring(0, pos + 1);
                        }
                        namespaces.put(tpp.getPrefix(), uri);
                    }
                    javaClassContent.append("        ").append(propertyName).append("=vocabulary.getSemanticProperty(\"").append(tpp.getURI()).append("\");" + ENTER);
                }
            }
        }
        javaClassContent.append(CLOSE_BLOCK + ENTER);
        javaClassContent.append("\r\n\r\n\r\n        //ListUris" + ENTER);
        javaClassContent.append("              public Hashtable<String,String> listUris()" + ENTER);
        javaClassContent.append("              {" + ENTER);
        javaClassContent.append("                     Hashtable<String,String> namespaces=new Hashtable<String, String>();" + ENTER);
        for (String prefix : namespaces.keySet())
        {
            String uri = namespaces.get(prefix);
            javaClassContent.append("                 namespaces.put(\"").append(prefix).append("\",\"").append(uri).append("\");" + ENTER);
        }
        javaClassContent.append("                     return namespaces;" + ENTER);
        javaClassContent.append("              }" + ENTER);
        javaClassContent.append("}" + ENTER);

        File dir = createPackage(sPackage, pDirectory);
        File fileClass = new File(dir.getPath() + File.separatorChar + "SWBVocabulary.java");
        saveFile(fileClass, javaClassContent.toString());
    }
}
