/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.portal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.junit.*;
import org.semanticwb.SWBException;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBContext;
import org.semanticwb.platform.SemanticModel;
import org.semanticwb.model.catalogs.*;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.VersionInfo;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.SWBResource;
import org.semanticwb.portal.api.SWBResourceException;
//import org.semanticwb.portal.resources.HTMLContent;

/**
 *
 * @author serch
 */
public class TestDemoEMex {

        @BeforeClass
    public static void setUpClass() throws Exception
    {
        //SWBPlatform.setUseDB(false);
        SWBPlatform.createInstance(null);
    //SWBPlatform.
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

//    //@Test
//    public void configUserRec() throws SQLException
//    {
//
//        UserRepository repository = null;
//        repository = SWBContext.getUserRepository("nuevo_usr");
//      //  repository.setUserRepSecurityQuestionList("1:Pasaporte num|2:Licencia num|3:nombre de tu mascota","es");
//      //  repository.setUserRepSecurityQuestionList("1:Passport number|2:Drivers number|3:petsname","en");
//System.out.println("inicio...");
//        repository.createDateTimeExtendedAttribute("fechaNac");
//System.out.println("creado fecha nac");
//        String [] sex = new String[3];
//        sex[0] = "hombre:mujer";
//        sex[1] = "es|hombre:mujer";
//        sex[2] = "en|man:woman";
//
//        repository.createListExtendedAttribute("sexo", sex);
//System.out.println("creado sexo");
//      String [] al = new String[3];
//        al[0] = "primaria:secundaria:preparatoria:universidad:maestria:doctorado";
//        al[1] = "es|primaria:secundaria:preparatoria:universidad:maestria:doctorado";
//        al[2] = "en|elementary:13-15grade:high:university:degree:doctordegre";
//        repository.createListExtendedAttribute("grado", al);
//System.out.println("Creado grado");
//
//        repository.createStringExtendedAttribute("ciudad");
//System.out.println("Creado ciudad");
//        al = new String[3];
//        al[0] = "empleado:estudiante:hogar:otro:por mi cuenta";
//        al[1] = "es|empleado:estudiante:hogar:otro:por mi cuenta";
//        al[2] = "en|employed:student:home:other:at my own";
//        repository.createListExtendedAttribute("ocupacion", al);
//System.out.println("Creado ocupacion");
//        Connection con = SWBUtils.DB.getConnection("catalogs", "Conexion Carga CP's");
//        PreparedStatement ps = con.prepareStatement("select entidad_federativa from entidad_relacion order by id_entidad_federativa2");
//        ResultSet rs = ps.executeQuery();
//        String cadena="";
//        while (rs.next()){
//            cadena = cadena + rs.getString(1) +":";
//        }
//        rs.close();
//        ps.close();
//        con.close();
//        cadena = cadena.substring(1, cadena.length()-1);
//System.out.println("cadena: "+cadena);
//        al[0]=cadena;
//        al[1]="es|"+cadena;
//        al[2]="en|"+cadena;
//        repository.createListExtendedAttribute("estado", al);
//System.out.println("Creado estado");
//    }

//@Test
public void userdemo() throws SWBException{
    UserRepository repository = null;
        repository = SWBContext.getUserRepository("nuevo_usr");
        User user = repository.getUserByLogin("serch");
        System.out.println("Login: "+user.getLogin());
        user.setExtendedAttribute("estado", "Guanajuato");
        user.setExtendedAttribute("sexo", "hombre");
        user.setExtendedAttribute("grado", "universidad");
        Calendar cal = Calendar.getInstance();
        cal.set(1974, 4, 8);
        user.setExtendedAttribute("fechaNac", cal.getTime());
        user.setExtendedAttribute("ciudad", "México");
        user.setFirstName("Edgar");
}

    @Test
    public void pages() throws SWBResourceException
    {
        WebSite site = SWBContext.getWebSite("nuevo");
        WebPage home = site.getHomePage();
        for (int x = 0; x < 5; x++)
        {
            WebPage page = site.createWebPage("page" + x);
            page.setTitle("Page" + x);
            page.setParent(home);
            page.setActive(true);
         //   page.addParentWebPage(home);
            for (int y = 0; y < 5; y++)
            {
                WebPage ipage = site.createWebPage("page" + x + "_" + y);
                ipage.setTitle("Page" + x + "." + y);
                ipage.setParent(page);
                ipage.setActive(true);
                //ipage.addParentWebPage(page);
             /*   SemanticModel model =ipage.getSemanticObject().getModel();
                long id=model.getCounter(Resource.sclass);
                SemanticObject so =     model.createSemanticObjectById(""+id,Resource.sclass);
                Resource resource = (Resource)so.getGenericInstance();

                String textToSave = "que te puedo decir";
               // VersionInfo version = new VersionInfo(resource.getSemanticObject());
                String filename = null;
                int versionNumber = 0;//version.getVersionNumber();
                versionNumber = 1;
                if (textToSave != null) {
            try {
                //Quito de una de las dos rutas el directorio -work-, ya que
                //las dos lo tienen.
                File filePath = new File(SWBPlatform.getWorkPath().substring(0,
                        SWBPlatform.getWorkPath().lastIndexOf("/") + 1)
                        + "/work" + resource.getWorkPath() + "/" + versionNumber);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                File file = new File(SWBPlatform.getWorkPath().substring(0,
                        SWBPlatform.getWorkPath().lastIndexOf("/") + 1)
                        +  "/work" + resource.getWorkPath() + "/" + versionNumber + "/index.html");
                filename = file.getName();
                FileWriter writer = new FileWriter(file);

                writer.write(textToSave);
                writer.flush();
                writer.close();
               // version.setVersionFile(filename);
               // version.setVersionNumber(versionNumber);

                ipage.addResource(resource);
                } catch (Exception e) {

            }
       /*

        Resource resource = paramRequest.getResourceBase();
        String contentPath = (String) request.getSession().getAttribute("directory");
        String textToSave = request.getParameter("EditorDefault");
        boolean deleteTmp = (request.getParameter("operation") != null
                             && !"".equals(request.getParameter("operation")))
                            ? true : false;
        String filename = null;
        boolean textSaved = false;
        VersionInfo version = new VersionInfo(resource.getSemanticObject());
        int versionNumber = version.getVersionNumber();
        int versionToDelete = versionNumber;
        String directoryToRemove = SWBPlatform.getWorkPath()
                + resource.getWorkPath() + "/"
                + (versionToDelete > 1 ? versionToDelete : 1) + "/tmp";
        String directoryToCreate = SWBPlatform.getWorkPath()
                + resource.getWorkPath() + "/" + (versionNumber + 1) + "/images";

        //Siempre se crea una nueva version al guardar
        versionNumber++;
        if (textToSave != null) {
            try {
                //Quito de una de las dos rutas el directorio -work-, ya que
                //las dos lo tienen.
                File filePath = new File(SWBPlatform.getWorkPath().substring(0,
                        SWBPlatform.getWorkPath().lastIndexOf("/") + 1)
                        + contentPath);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                File file = new File(SWBPlatform.getWorkPath().substring(0,
                        SWBPlatform.getWorkPath().lastIndexOf("/") + 1)
                        + contentPath + "/index.html");
                filename = file.getName();
                FileWriter writer = new FileWriter(file);

                //Si estaba en directorio temporal, modificar rutas de archivos asociados
                if (deleteTmp) {
                    textToSave = textToSave.replaceAll(
                            SWBPlatform.getWebWorkPath()
                            + resource.getWorkPath() + "/"
                            + (version.getVersionNumber() > 1 ? version.getVersionNumber() : 1)
                            + "/tmp/images",
                            SWBPlatform.getWebWorkPath()
                            + resource.getWorkPath() + "/"
                            + versionNumber + "/images");
                }

                writer.write(textToSave);
                writer.flush();
                writer.close();
                version.setVersionFile(filename);
                version.setVersionNumber(versionNumber);
                //TODO: Revisar si esto es correcto. Forzosamente se debe fijar
                //la editada como la actual?
                //resource.setActualVersion(versionNumber);
                //resource.setLastVersion(versionNumber);
                textSaved = true;
                if (deleteTmp) {
                    File imagesDirectory = new File(directoryToRemove + "/images");
                    //eliminar el directorio tmp de la version anterior
                    if (imagesDirectory.exists()
                            && SWBUtils.IO.createDirectory(directoryToCreate)) {

                        //Copia los archivos del directorio tmp al de la nueva version
                        for (String strFile : imagesDirectory.list()) {
                            SWBUtils.IO.copy(imagesDirectory.getPath() + "/" + strFile,
                                    directoryToCreate + "/" + strFile, false,
                                    "", "");
                        }
                    }
                    SWBUtils.IO.removeDirectory(directoryToRemove);
                }
            } catch (Exception e) {
                log.error("Al escribir el archivo", e);
            }
        }
        PrintWriter out = response.getWriter();
        if (textSaved) {
            out.println("El contenido ha sido guardado exit&oacute;samente");
        } else {
            out.println("Se produjo un error al almacenar la información, intente de nuevo.");
        }
        out.close();
        * /

                //SWBPortal.getResourceMgr().createSWBResource(SWBPortal.getResourceMgr());
            }*/
            }
        }
    }
}
