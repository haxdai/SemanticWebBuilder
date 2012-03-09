package com.infotec.cvi.swb.resources.reports;

import com.infotec.cvi.swb.Academia;
import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.Candidato;
import com.infotec.eworkplace.swb.Persona;
import com.infotec.eworkplace.swb.SWProfile;
import com.infotec.eworkplace.swb.Telefono;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author rene.jara
 */
public class ImprimirCV extends GenericResource {
    private static Logger log = SWBUtils.getLogger(ImprimirCV.class);
    public static final String Mode_PDF = "pdf";
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String mode = paramRequest.getMode();
        if(Mode_PDF.equals(mode))
            doPdf(request, response, paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }


    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String basePath = "/work/models/" + paramsRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        User user = paramsRequest.getUser();

        RequestDispatcher dis = request.getRequestDispatcher(basePath + "/viewCV.jsp");
        try {
            request.setAttribute("paramRequest", paramsRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }
    
    public void doPdf(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("application/pdf");
        
        User user = paramRequest.getUser();
        if(!user.isSigned())
            return;
        
        WebSite ws = paramRequest.getWebPage().getWebSite();
        Persona persona = Persona.ClassMgr.getPersona(user.getId(), ws);
        Candidato candidato = Candidato.ClassMgr.getCandidato(user.getId(), ws);
        CV cv = CV.ClassMgr.getCV(user.getId(), ws);
        SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), ws);

        Academia academia = null;
        if (cv != null) {
            academia = cv.getAcademia();
        }
        String fullName = "";
        String curp = "";
        String birthday = "";
        String gender = "";
        String state = "";
        String nationality = "";
        boolean fm2 = false;
        String sLabor = "";
        String availability = "";
        String email = "";
        String facebook = "";
        String skype = "";
        String msn = "";
        String linkedin = "";
        String twitter = "";
        Locale locale = new Locale(user.getLanguage());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy", locale);
        if (user.getFullName() != null) {
            fullName = user.getFullName();
        }
        if (user.getEmail() != null) {
            email = user.getEmail();
        }

        if (persona != null) {
            if (persona.getCurp() != null) {
                curp = persona.getCurp();
            }
            if (persona.isGenero() == true) {
                gender = "Femenino";
            } else {
                gender = "Masculino";
            }
            if (persona.getNacimiento() != null) {
                birthday = sdf.format(persona.getNacimiento());
            }
            if (persona.getNacionalidad() != null) {
                nationality = persona.getNacionalidad().getTitle();
            }
            fm2 = persona.isFM2();
            if (persona.getFacebook() != null) {
                facebook = persona.getFacebook();
            }
            if (persona.getSkype() != null) {
                skype = persona.getSkype();
            }
            if (persona.getMsn() != null) {
                msn = persona.getMsn();
            }
            if (persona.getLinkedin() != null) {
                linkedin = persona.getLinkedin();
            }
            if (persona.getTwitter() != null) {
                twitter = persona.getTwitter();
            }
        }

        if (candidato != null) {
            switch (candidato.getSituacionLaboral()) {
                case 1:
                    sLabor = "Empleado";
                    break;
                case 2:
                    sLabor = "Desempleado";
                    break;
                case 3:
                    sLabor = "Estudiante";
                    break;
                case 4:
                    sLabor = "Jubilado";
                    break;
            }
            availability = Integer.toString(candidato.getDisponibilidad());
            if (candidato.getDisponibilidad() == 1) {
                availability += " día";
            } else {
                availability += " dias";
            }
        }
        
//        try {
//            Document document = new Document();
//            PdfWriter.getInstance(document, response.getOutputStream());
//            document.open();
//            document.add(new Paragraph("Hello World"));
//            document.add(new Paragraph(new Date().toString()));
//            document.close();
//        } catch (DocumentException de) {
//        throw new IOException(de.getMessage());
//        }
        Document document = new Document(PageSize.LETTER);
        try {
            //PdfWriter.getInstance(document, new FileOutputStream("c:/hello.pdf"));
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            
            Phrase phrase = new Phrase();
            Chunk chnk = new Chunk("Curriculum Vitae Infotec",FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, Color.LIGHT_GRAY));
            phrase.setLeading(25f);
            phrase.add(chnk);
            phrase.add(Chunk.NEWLINE);
            Paragraph paragraph = new Paragraph(phrase);
            document.add(paragraph);
            
            final String pimg;
            if(user.getPhoto()==null)
                pimg = SWBPortal.getWorkPath()+"/models/"+ws.getId()+"/css/user.jpg";
            else
                pimg = SWBPortal.getWorkPath()+profile.getWorkPath()+"/"+user.getPhoto();            
            
//            paragraph = new Paragraph();
//            phrase = new Phrase(curp.toUpperCase(locale), FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, Color.DARK_GRAY));
//            paragraph.add(phrase);
//            document.add(paragraph);
            
            paragraph = new Paragraph();
            Image photo = Image.getInstance(pimg);
            photo.setAlignment(Image.ALIGN_LEFT | Image.TEXTWRAP);
            photo.setBorder(Image.BOX);
            photo.setBorderWidth(10f);
            photo.setBorderColor(Color.WHITE);
            paragraph.add(photo);
            phrase = new Phrase();
            chnk = new Chunk(fullName,FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, Color.BLUE));
            phrase.add(chnk);
            phrase.add(Chunk.NEWLINE);
            chnk = new Chunk(curp.toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.DARK_GRAY));
            phrase.add(chnk);
            phrase.add(Chunk.NEWLINE);
            chnk = new Chunk(birthday+", ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.DARK_GRAY));
            phrase.add(chnk);
            chnk = new Chunk(state+", ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.DARK_GRAY));
            phrase.add(chnk);
            chnk = new Chunk(nationality+", ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.DARK_GRAY));
            phrase.add(chnk);
            chnk = new Chunk(gender, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.DARK_GRAY));
            phrase.add(chnk);
            phrase.add(Chunk.NEWLINE);
            paragraph.add(phrase);
            phrase = new Phrase();
            chnk = new Chunk(sLabor+", ", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.DARK_GRAY));
            phrase.add(chnk);
            chnk = new Chunk(availability+",", FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.DARK_GRAY));
            phrase.add(chnk);
            paragraph.add(phrase);
            document.add(paragraph);
            
                       
/*if (persona != null) {
    paragraph = new Paragraph();
    PdfPTable table = new PdfPTable(2);
    
    Iterator<Telefono> itt = persona.listTelefonos();
    while (itt.hasNext()) {
        Telefono te = itt.next();
        String lada = te.getLada() > 0 ? "(" + te.getLada() + ")" : "";
        String numero = te.getNumero() > 0 ? "" + te.getNumero() : "";
        String exten = te.getExtension() > 0 ? "Ext:" + te.getExtension() : "";
        String tipo = te.getTipo() != null ? te.getTipo() : "";
        
        PdfPCell cell = new PdfPCell();
        cell.setBorder(0);
        Image img = getImage(SWBPortal.getWorkPath()+"/models/"+ws.getId()+"/css/ico-telreca.jpg");
        img.scalePercent(40f);
        cell.addElement(img);
        chnk = new Chunk(lada+numero+exten, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, Color.DARK_GRAY));
        cell.addElement(chnk);
//        phrase = new Phrase();
//        chnk = new Chunk(lada+numero+exten, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.DARK_GRAY));
//        phrase.add(chnk);
//        cell.addElement(phrase);
        table.addCell(cell);
    }
    if(!email.isEmpty()) {
        PdfPCell cell = new PdfPCell(getImage(SWBPortal.getWorkPath()+"/models/"+ws.getId()+"/css/ico-mail.jpg"));
        phrase = new Phrase();
        chnk = new Chunk(email, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.DARK_GRAY));
        phrase.add(chnk);
        cell.addElement(phrase);
        table.addCell(cell);
    }
    if(!facebook.isEmpty()) {
        PdfPCell cell = new PdfPCell(getImage(SWBPortal.getWorkPath()+"/models/"+ws.getId()+"/css/ico-fb.jpg"));
        phrase = new Phrase();
        chnk = new Chunk(facebook, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.DARK_GRAY));
        phrase.add(chnk);
        cell.addElement(phrase);
        table.addCell(cell);
    }
    if(!twitter.isEmpty()) {
        PdfPCell cell = new PdfPCell(getImage(SWBPortal.getWorkPath()+"/models/"+ws.getId()+"/css/ico-twit.jpg"));
        phrase = new Phrase();
        chnk = new Chunk(twitter, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.DARK_GRAY));
        phrase.add(chnk);
        cell.addElement(phrase);
        table.addCell(cell);
    }
    if(!skype.isEmpty()) {
        PdfPCell cell = new PdfPCell(getImage(SWBPortal.getWorkPath()+"/models/"+ws.getId()+"/css/ico-sky.jpg"));
        phrase = new Phrase();
        chnk = new Chunk(skype, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.DARK_GRAY));
        phrase.add(chnk);
        cell.addElement(phrase);
        table.addCell(cell);
    }
    if(!linkedin.isEmpty()) {
        PdfPCell cell = new PdfPCell(getImage(SWBPortal.getWorkPath()+"/models/"+ws.getId()+"/css/ico-in.jpg"));
        phrase = new Phrase();
        chnk = new Chunk(linkedin, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL, Color.DARK_GRAY));
        phrase.add(chnk);
        cell.addElement(phrase);
        table.addCell(cell);
    }
    paragraph.add(Chunk.NEWLINE);
    paragraph.add(table);
    document.add(paragraph);
}*/
            

            
            document.close();
        }catch(Exception e) {
            e.printStackTrace(System.out);
            log.error(e);
        }
    }
    
    private Image getImage(final String path) throws Exception {
        Image img = Image.getInstance(path);
        img.setAlignment(Image.ALIGN_LEFT | Image.TEXTWRAP);
        img.setBorder(Image.BOX);
        img.setBorderWidthLeft(3f);
        img.setBorderWidthRight(2f);
        img.setBorderWidthTop(1f);
        img.setBorderWidthBottom(1f);
        img.setBorderColor(Color.WHITE);
        return img;
    }
}
