/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.openoffice.calc;

import com.sun.star.beans.PropertyValue;
import com.sun.star.beans.XPropertySet;
import com.sun.star.container.XEnumeration;
import com.sun.star.document.XDocumentInfo;
import com.sun.star.document.XDocumentInfoSupplier;
import com.sun.star.frame.XDesktop;
import com.sun.star.frame.XModel;
import com.sun.star.frame.XStorable;
import com.sun.star.io.IOException;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.sheet.*;
import com.sun.star.table.XCell;
import com.sun.star.text.XTextFieldsSupplier;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;
import com.sun.star.util.XModifiable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.semanticwb.openoffice.DocumentType;
import org.semanticwb.openoffice.ErrorLog;
import org.semanticwb.openoffice.NoHasLocationException;
import org.semanticwb.openoffice.OfficeDocument;
import org.semanticwb.openoffice.SaveDocumentFormat;
import org.semanticwb.openoffice.WBAlertException;
import org.semanticwb.openoffice.WBException;
import org.semanticwb.openoffice.WBOfficeException;
import org.semanticwb.openoffice.impress.WB4Impress;

/**
 * Class to wrap a Open Office Calc Document
 * @author victor.lorenzana
 */
public class WB4Calc extends OfficeDocument
{

    private static final String OPENOFFICE_EXTENSION = ".ods";
    private static final String EXCEL_EXTENSION = ".xls";
    private static final String HTML_EXTENSION = ".html";
    private static final String ERROR_NO_SAVE = "No se puede almacenar el documento";
    private static final String FILTER_NAME = "FilterName";
    private static final String OVERRIDE_OPTION = "Overwrite";
    private static final String SCHEMA_FILE = "file:///";
    private final XComponent document;
    private static String tabstrip;

    static
    {
        try
        {
            byte[] buffer = new byte[2048];
            InputStream in = WB4Calc.class.getResourceAsStream("tabstrip.htm");

            int read = in.read(buffer);
            StringBuilder builder = new StringBuilder();
            while (read != -1)
            {
                String temp = new String(buffer, 0, read, "UTF-8");
                builder.append(temp);
                read = in.read(buffer);
            }
            in.close();
            tabstrip = builder.toString();
        }
        catch (java.io.IOException ioe)
        {
            ErrorLog.log(ioe);
        }
    }

    /**
     * Create a representation of a Calc Document
     * @param document Representation of a Calc Document
     * @see XComponent
     */
    public WB4Calc(XComponent document)
    {
        this.document = document;
    }

    /**
     * Create a representation of a Calc Document
     * @param m_xContext Context of Calc Application
     * @throws org.semanticwb.openoffice.WBOfficeException If the Desktop can not be used
     * @see XComponentContext
     */
    public WB4Calc(XComponentContext m_xContext) throws WBOfficeException
    {
        XMultiComponentFactory serviceManager = m_xContext.getServiceManager();
        try
        {
            Object desktop = serviceManager.createInstanceWithContext(
                    "com.sun.star.frame.Desktop", m_xContext);
            XDesktop xdesktop = (XDesktop) UnoRuntime.queryInterface(XDesktop.class, desktop);
            document = xdesktop.getCurrentComponent();
        }
        catch (com.sun.star.uno.Exception e)
        {
            throw new WBOfficeException("Error al obtener el escritorio de Open Office", e);
        }
    }

    /**
     * Gets the Application version string, allways returns 2.4
     * @return Application version String      
     */
    @Override
    public final String getApplicationVersion()
    {
        return "2.4";
    }

    /**
     * Gets all the files that contains a cell
     * @param xcell the XCell to search the files
     * @return List of files found
     * @throws org.semanticwb.openoffice.NoHasLocationException The document has not be saved before
     * @see XCell
     */
    public final List<File> getAttachments(XCell xcell) throws NoHasLocationException
    {
        List<File> attachments = new ArrayList<File>();
        XTextFieldsSupplier xTextFieldsSupplier = (XTextFieldsSupplier) UnoRuntime.queryInterface(XTextFieldsSupplier.class, xcell);
        XEnumeration textFields = xTextFieldsSupplier.getTextFields().createEnumeration();
        while (textFields.hasMoreElements())
        {
            try
            {
                Object textField1 = textFields.nextElement();
                if (textField1 != null)
                {
                    XPropertySet xps = (XPropertySet) UnoRuntime.queryInterface(XPropertySet.class, textField1);
                    if (xps != null)
                    {
                        String path = xps.getPropertyValue("URL").toString();
                        attachments.addAll(this.addLink(path));
                    }
                }
            }
            catch (com.sun.star.uno.Exception nse)
            {
                ErrorLog.log(nse);
            }
        }
        return attachments;
    }

    /**
     * Gets all the files in the document
     * @return List of files in the document
     * @throws org.semanticwb.openoffice.NoHasLocationException The document has not saved before     * 
     */
    @Override
    public final List<File> getAllAttachments() throws NoHasLocationException
    {

        List<File> attachments = new ArrayList<File>();

        XSpreadsheetDocument xSpreadsheetDocument = (XSpreadsheetDocument) UnoRuntime.queryInterface(XSpreadsheetDocument.class, this.document);
        XSpreadsheets xSpreadsheets = xSpreadsheetDocument.getSheets();
        for (String name : xSpreadsheets.getElementNames())
        {
            try
            {
                Object obSpreadsheet = xSpreadsheets.getByName(name);
                XSpreadsheet sheet = (XSpreadsheet) UnoRuntime.queryInterface(XSpreadsheet.class, obSpreadsheet);
                XCellRangesQuery xRangesQuery = (XCellRangesQuery) UnoRuntime.queryInterface(XCellRangesQuery.class, sheet);
                XSheetCellRanges xCellRanges = xRangesQuery.queryContentCells((short) (CellFlags.VALUE | CellFlags.STRING));
                XEnumeration cells = xCellRanges.getCells().createEnumeration();
                while (cells.hasMoreElements())
                {
                    Object ocell = cells.nextElement();
                    XCell xcell = (XCell) UnoRuntime.queryInterface(XCell.class, ocell);
                    attachments.addAll(getAttachments(xcell));
                }
            }
            catch (com.sun.star.uno.Exception upe)
            {
                ErrorLog.log(upe);
            }
        }
        return attachments;
    }

    /**
     * Gets al the custom properties of the document
     * @return A Map of custum properties
     * @throws org.semanticwb.openoffice.WBException If the list of properties are more that four
     */
    @Override
    public final Map<String, String> getCustomProperties() throws WBException
    {
        HashMap<String, String> properties = new HashMap<String, String>();
        XSpreadsheetDocument xtd =
                (XSpreadsheetDocument) UnoRuntime.queryInterface(XSpreadsheetDocument.class, this.document);

        XDocumentInfoSupplier xdis =
                (XDocumentInfoSupplier) UnoRuntime.queryInterface(XDocumentInfoSupplier.class, xtd);
        XDocumentInfo xdi = xdis.getDocumentInfo();
        short index = xdi.getUserFieldCount();
        for (short i = 0; i < index; i++)
        {
            try
            {
                String name = xdi.getUserFieldName(i);
                String value = xdi.getUserFieldValue(i);
                properties.put(name, value);
            }
            catch (com.sun.star.lang.ArrayIndexOutOfBoundsException aibe)
            {
                throw new WBOfficeException("No se puede actualizar la información asociada a la publicación del contenido", aibe);
            }
        }
        return properties;
    }

    /**
     * Gets the type of document
     * @return DocumentType.Excel
     * @see DocumentType
     */
    @Override
    public final DocumentType getDocumentType()
    {
        return DocumentType.EXCEL;
    }

    /**
     * Gets the path of the fisical document
     * @return A File with the fisical path of the document
     * @throws org.semanticwb.openoffice.NoHasLocationException If the document has not been saved
     */
    @Override
    public final File getLocalPath() throws NoHasLocationException
    {
        XModel xtd = (XModel) UnoRuntime.queryInterface(XModel.class, this.document);
        XStorable xStorable = (XStorable) UnoRuntime.queryInterface(XStorable.class, document);
        if (xStorable.hasLocation())
        {
            String path = xtd.getURL();
            if (path.startsWith(SCHEMA_FILE))
            {
                path = path.substring(8);
            }
            return new File(path);
        }
        else
        {
            throw new NoHasLocationException();
        }
    }

    /**
     * Save the document
     * @throws org.semanticwb.openoffice.WBException If the document has not been saved before
     */
    @Override
    public final void save() throws WBException
    {
        try
        {
            XModifiable xModified = (XModifiable) UnoRuntime.queryInterface(XModifiable.class, document);
            if (xModified.isModified())
            {
                XStorable xStorable = (XStorable) UnoRuntime.queryInterface(XStorable.class, document);
                if (!xStorable.isReadonly())
                {
                    xStorable.store();
                }
                else
                {
                    throw new WBAlertException("No se puede almacenar el documento por que es de sólo lectura");
                }
            }

        }
        catch (IOException ioe)
        {
            throw new WBOfficeException(ERROR_NO_SAVE, ioe);

        }
    }

    /**
     * Save the document in selected a format
     * @param dir The path of the file
     * @param format The SaveDocumentFormat to use
     * @return a File with the full path of the new document
     * @throws org.semanticwb.openoffice.WBException If the document can not be saved
     * @throws IllegalArgumentException If the parameter is a file, must be a directory
     */
    @Override
    public final File saveAs(File dir, SaveDocumentFormat format) throws WBException
    {
        File result;
        switch (format)
        {
            case HTML:
                result = this.saveAsHtml(dir);
                break;
            case OFFICE_2003:
                result = saveAsOffice2003(dir);
                break;
            default:
                result = saveAsOpenOffice(dir);
        }
        return result;
    }

    /**
     * Save the couemnt in Open Office format (.ods)
     * @param dir The directory to save the document
     * @return the full path of the new document
     * @throws org.semanticwb.openoffice.WBException If the document can not be saved
     * @throws IllegalArgumentException If the parameter is a file, must be a directory
     */
    private File saveAsOpenOffice(File dir) throws WBException
    {
        if (dir.isFile())
        {
            throw new IllegalArgumentException();
        }
        try
        {
            File docFile = this.getLocalPath();
            int index = docFile.getName().lastIndexOf(".");
            String extension = null;
            if (index != -1)
            {
                extension = docFile.getName().substring(index);
            }
            String name = null;
            if (extension == null)
            {
                name = docFile.getName();
            }
            else
            {
                name = docFile.getName().replace(extension, OPENOFFICE_EXTENSION);
            }
            // guarda el documento en .doc en directorio Temporal
            File DocFile = new File(dir.getPath() + File.separator + name);
            PropertyValue[] storeProps = new PropertyValue[2];
            storeProps[0] = new PropertyValue();
            storeProps[0].Name = FILTER_NAME;
            storeProps[0].Value = "Calc8";

            storeProps[1] = new PropertyValue();
            storeProps[1].Name = OVERRIDE_OPTION;
            storeProps[1].Value = true;
            XStorable xStorable = (XStorable) UnoRuntime.queryInterface(XStorable.class, document);
            if (!dir.exists())
            {
                dir.mkdirs();
            }
            String url = SCHEMA_FILE + DocFile.getPath().replace('\\', '/');
            xStorable.storeToURL(url, storeProps);
            return DocFile;
        }
        catch (IOException ioe)
        {
            throw new WBOfficeException(ERROR_NO_SAVE, ioe);
        }
    }

    /**
     * Save the document in Office 2003 format
     * @param dir File Path directory to save the cocument
     * @return The full path of the new file
     * @throws org.semanticwb.openoffice.WBException
     * @throws IllegalArgumentException If the parameter is a file
     */
    private File saveAsOffice2003(File dir) throws WBException
    {
        if (dir.isFile())
        {
            throw new IllegalArgumentException();
        }
        try
        {
            File docFile = this.getLocalPath();
            int index = docFile.getName().lastIndexOf(".");
            String extension = null;
            if (index != -1)
            {
                extension = docFile.getName().substring(index);
            }
            String name = null;
            if (extension == null)
            {
                name = docFile.getName();
            }
            else
            {
                name = docFile.getName().replace(extension, EXCEL_EXTENSION);
            }
            // guarda el documento en .doc en directorio Temporal
            File DocFile = new File(dir.getPath() + File.separator + name);
            PropertyValue[] storeProps = new PropertyValue[2];
            storeProps[0] = new PropertyValue();
            storeProps[0].Name = FILTER_NAME;
            storeProps[0].Value = "MS Excel 97";

            storeProps[1] = new PropertyValue();
            storeProps[1].Name = OVERRIDE_OPTION;
            storeProps[1].Value = true;
            XStorable xStorable = (XStorable) UnoRuntime.queryInterface(XStorable.class, document);
            if (!dir.exists())
            {
                dir.mkdirs();
            }
            String url = SCHEMA_FILE + DocFile.getPath().replace('\\', '/');
            xStorable.storeToURL(url, storeProps);
            return DocFile;
        }
        catch (IOException ioe)
        {
            throw new WBOfficeException(ERROR_NO_SAVE, ioe);
        }
    }

    /**
     * Save the document in default format
     * @param file The full path of the file, overwrite the document if exists
     * @throws org.semanticwb.openoffice.WBException If can not be saved
     * @throws IllegalArgumentException If the path is a directory
     */
    @Override
    public void save(File file) throws WBException
    {
        if (file.isDirectory())
        {
            throw new IllegalArgumentException();
        }
        try
        {
            PropertyValue[] storeProps = new PropertyValue[2];
            storeProps[0] = new PropertyValue();
            storeProps[0].Name = FILTER_NAME;
            storeProps[0].Value = "Calc8";

            storeProps[1] = new PropertyValue();
            storeProps[1].Name = OVERRIDE_OPTION;
            storeProps[1].Value = true;

            XStorable xStorable = (XStorable) UnoRuntime.queryInterface(XStorable.class, document);
            String url = SCHEMA_FILE + file.getPath().replace('\\', '/');
            xStorable.storeAsURL(url, storeProps);
        }
        catch (IOException wbe)
        {
            throw new WBOfficeException("No se puede gardar el documento", wbe);
        }
    }

    /**
     * Save the document in Html format
     * @param dir Directory to save the document
     * @return The full path of the document
     * @throws org.semanticwb.openoffice.WBException If the document can not be saved
     * @throws IllegalArgumentException If the File is a file and not a directory
     */
    @Override
    public final File saveAsHtml(File dir) throws WBException
    {
        if (dir.isFile())
        {
            throw new IllegalArgumentException();
        }
        try
        {
            File docFile = this.getLocalPath();
            File HTMLfile;
            if (docFile.getName().endsWith(OPENOFFICE_EXTENSION))
            {
                HTMLfile = new File(dir.getPath() + File.separator + docFile.getName().replace(OPENOFFICE_EXTENSION, HTML_EXTENSION));
                String name = docFile.getName().replace(OPENOFFICE_EXTENSION, EXCEL_EXTENSION);
                // guarda el documento en .doc en directorio Temporal
                File DocFile = new File(dir.getPath() + File.separator + name);
                PropertyValue[] storeProps = new PropertyValue[2];
                storeProps[0] = new PropertyValue();
                storeProps[0].Name = FILTER_NAME;
                storeProps[0].Value = "MS Excel 97";

                storeProps[1] = new PropertyValue();
                storeProps[1].Name = OVERRIDE_OPTION;
                storeProps[1].Value = true;
                XStorable xStorable = (XStorable) UnoRuntime.queryInterface(XStorable.class, document);

                if (!dir.exists())
                {
                    dir.mkdirs();
                }
                String url = SCHEMA_FILE + DocFile.getPath().replace('\\', '/');
                xStorable.storeToURL(url, storeProps);
            }
            else
            {
                HTMLfile = new File(dir.getPath() + File.separator + docFile.getName().replace(EXCEL_EXTENSION, HTML_EXTENSION));
            }

            PropertyValue[] storeProps = new PropertyValue[2];
            storeProps[0] = new PropertyValue();
            storeProps[0].Name = FILTER_NAME;
            storeProps[0].Value = "HTML (StarCalc)";

            storeProps[1] = new PropertyValue();
            storeProps[1].Name = OVERRIDE_OPTION;
            storeProps[1].Value = true;


            XStorable xStorable = (XStorable) UnoRuntime.queryInterface(XStorable.class, document);
            if (!dir.exists())
            {
                dir.mkdirs();
            }
            String url = SCHEMA_FILE + HTMLfile.getPath().replace('\\', '/');
            xStorable.storeToURL(url, storeProps);
            return HTMLfile;
        }
        catch (IOException ioe)
        {
            throw new WBOfficeException(ERROR_NO_SAVE, ioe);

        }
    }

    /**
     * Save the properties in custom properties in the document
     * @param properties Properties to save
     * @throws org.semanticwb.openoffice.WBException if the properties are more than four
     */
    @Override
    public final void saveCustomProperties(Map<String, String> properties) throws WBException
    {
        XSpreadsheetDocument xtd =
                (XSpreadsheetDocument) UnoRuntime.queryInterface(XSpreadsheetDocument.class, this.document);
        XDocumentInfoSupplier xdis =
                (XDocumentInfoSupplier) UnoRuntime.queryInterface(XDocumentInfoSupplier.class, xtd);
        XDocumentInfo xdi = xdis.getDocumentInfo();
        short index = 0;
        // solo puede tener 4 propiedades
        for (String key : properties.keySet())
        {
            String value = properties.get(key);
            try
            {
                xdi.setUserFieldName(index, key);
                xdi.setUserFieldValue(index, value);
            }
            catch (com.sun.star.lang.ArrayIndexOutOfBoundsException aibe)
            {
                throw new WBOfficeException("No se puede actualizar la información asociada a la publicación del contenido", aibe);
            }
            index++;
        }
        this.save();
    }

    /**
     * Prepare the html to be published
     * @param htmlFile The full path of the Html document exported by the application
     * @throws IllegalArgumentException If the path is a directory
     */
    public final void prepareHtmlFileToSend(File htmlFile)
    {
        if (htmlFile.isDirectory())
        {
            throw new IllegalArgumentException();
        }
        List<String> sheets=createSheets(htmlFile);
        createTabStrip(htmlFile.getParentFile(),sheets);
    // TODO: Falta implementar    
    }
    private void createTabStrip(File dir,List<String> sheets)
    {
        StringBuilder sheetstable=new StringBuilder(tabstrip);
        
        for(String sheetName : sheets)
        {
            String td="<td bgcolor=\"#FFFFFF\" nowrap><b><small><small>&nbsp;<a href=\"sheet001.htm\" target=\"frSheet\"><font face=\"Arial\" color=\"#000000\">Hoja1</font></a>&nbsp;</small></small></b></td>";
        }
        try
        {
            File tabStrip=new File(dir.getPath()+"/tabscrip.htm");
            FileOutputStream out = new FileOutputStream(tabStrip);
            out.write(sheetstable.toString().getBytes());
            out.close();
        }
        catch (Exception ex)
        {
            ErrorLog.log(ex);
        }
    }
    private void saveTable(String table, File dir, int iSheet,String name)
    {        
        File sheet = new File(dir.getPath() + "/" + name + ".html");        
        try
        {
            FileOutputStream out = new FileOutputStream(sheet);
            out.write(table.getBytes());
            out.close();
        }
        catch (Exception ex)
        {
            ErrorLog.log(ex);
        }
    }

    private List<String> createSheets(File htmlFile)
    {
        List<String> sheets=new ArrayList<String>();
        try
        {
            byte[] buffer = new byte[2048];
            InputStream in = new FileInputStream(htmlFile);

            int read = in.read(buffer);
            StringBuilder builder = new StringBuilder();
            while (read != -1)
            {
                String temp = new String(buffer, 0, read);
                builder.append(temp);
                read = in.read(buffer);
            }
            in.close();
            int iSheet = 0;
            int posInit = 0;
            while (posInit >= 0)
            {
                posInit = builder.indexOf("<A NAME=",posInit);
                if (posInit != -1)
                {
                    posInit = builder.indexOf("<TABLE", posInit + 9);
                    if (posInit != -1)
                    {
                        int posFin = builder.indexOf("</TABLE>", posInit);
                        String table = builder.substring(posInit, posFin + 8);
                        String name = "sheet" + iSheet;
                        saveTable(table, htmlFile.getParentFile(), iSheet,name);
                        sheets.add(name);
                        iSheet++;
                    }
                }
                posInit = builder.indexOf("<A NAME=",posInit);
            }
        }
        catch (Exception ex)
        {
            ErrorLog.log(ex);
        }
        return sheets;
    }

    /**
     * Gets is the document is new, it means that the document has not been saved before
     * @return True if the document is new, false otherwise
     */
    public boolean isNewDocument()
    {
        XStorable xStorable = (XStorable) UnoRuntime.queryInterface(XStorable.class, document);
        return !xStorable.hasLocation();
    }

    /**
     * Gets if the document is readonly or not
     * @return True if the document is readonly or not
     */
    public boolean isReadOnly()
    {
        XStorable xStorable = (XStorable) UnoRuntime.queryInterface(XStorable.class, document);
        return xStorable.isReadonly();
    }

    /**
     * Gets if the document has been modified and can be saves
     * @return True if the document has been modified, false otherwise
     */
    public boolean isModified()
    {
        XModifiable xModified = (XModifiable) UnoRuntime.queryInterface(XModifiable.class, document);
        return xModified.isModified();
    }

    /**
     * Gets the Default extension used by the application
     * @return A string with the default extension, allways returns .ods
     */
    public String getDefaultExtension()
    {
        return OPENOFFICE_EXTENSION;
    }
}
