<%-- 
    Document   : pdf
    Created on : 20-mar-2012, 15:42:45
    Author     : carlos.ramos
--%><%@page import="com.infotec.cvi.swb.resources.reports.ImprimirCV"%><%@page contentType="application/pdf" pageEncoding="ISO-8859-1"%><%@page import="com.infotec.eworkplace.swb.*
        ,com.infotec.eworkplace.swb.Telefono.TipoTelefono
        ,com.itextpdf.text.*
        ,com.itextpdf.text.pdf.*
        ,java.io.IOException
        ,java.util.Iterator
        ,java.util.Locale
        ,java.util.Date
        ,java.text.SimpleDateFormat
        ,com.infotec.cvi.swb.*
        ,org.semanticwb.*
        ,org.semanticwb.model.*
        ,org.semanticwb.portal.api.*
        ,org.w3c.dom.*" %><%@page import="static com.infotec.cvi.swb.resources.reports.ImprimirCV.*"%><jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/><%
    User user = paramRequest.getUser();
    if(!user.isSigned())
        return;
    
    WebSite wsite = paramRequest.getWebPage().getWebSite();
    CV cv = CV.ClassMgr.getCV(user.getId(), wsite) ;
    org.w3c.dom.Document dom = cv.toDom(user);
    
    SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), wsite);
    Node nNode = dom.getElementsByTagName("persona").item(0);
    org.w3c.dom.Element person = (org.w3c.dom.Element)nNode;
    
    String fullName = person.getElementsByTagName("nombre").item(0).getChildNodes().item(0).getNodeValue();
    String curp = "";
    if(person.getElementsByTagName("curp").item(0)!=null)
        curp = person.getElementsByTagName("curp").item(0).getChildNodes().item(0).getNodeValue();
    String rfc = user.getLogin();
    String birthday = person.getElementsByTagName("nacimiento").item(0).getChildNodes().item(0).getNodeValue();
    String gender = person.getElementsByTagName("genero").item(0).getChildNodes().item(0).getNodeValue();
    String state = person.getElementsByTagName("estado").item(0).getChildNodes().item(0).getNodeValue();
    String nationality = person.getElementsByTagName("nacionalidad").item(0).getChildNodes().item(0).getNodeValue();
    boolean fm2 = person.getElementsByTagName("fm2").item(0)==null?false:true;
    String sLabor = person.getElementsByTagName("situacion").item(0).getChildNodes().item(0).getNodeValue();
    String availability = null;
    if( person.getElementsByTagName("disponibilidad").item(0)!=null ) {
        availability = person.getElementsByTagName("disponibilidad").item(0).getChildNodes().item(0).getNodeValue();
    }
    
    String email = user.getEmail();
    String facebook="", twitter="", linkedin="", skype="", msn="";
    String phnMobile="", phnJob="", phnHome="", phnOther="";
    nNode = dom.getElementsByTagName("medio_contacto").item(0);
    if(nNode!=null) {
        org.w3c.dom.Element contact = (org.w3c.dom.Element)nNode;
        NodeList nList = contact.getElementsByTagName("telefono");
        for(int i=0; i<nList.getLength(); i++) {
            org.w3c.dom.Element telefono = (org.w3c.dom.Element)nList.item(i);
            if(telefono!=null) {
                try {
                    String num = telefono.getElementsByTagName("numero").item(0).getChildNodes().item(0).getNodeValue();
                    Telefono.TipoTelefono tipo = Telefono.TipoTelefono.valueOf(telefono.getAttribute("tipo"));
                    if(Telefono.TipoTelefono.Movil == tipo) {
                        phnMobile = num;
                        try {
                            String lada = telefono.getElementsByTagName("lada").item(0).getChildNodes().item(0).getNodeValue();
                            phnMobile = "("+lada+") "+phnMobile;
                        }catch(Exception e) {
                        }
                    }else if(Telefono.TipoTelefono.Trabajo == tipo) {
                        phnJob = num;
                        try {
                            String lada = telefono.getElementsByTagName("lada").item(0).getChildNodes().item(0).getNodeValue();
                            phnJob = "("+lada+") "+phnJob;
                        }catch(Exception e){
                        }
                        try {
                            String ext = telefono.getElementsByTagName("lada").item(0).getChildNodes().item(0).getNodeValue();
                            phnJob = phnJob+" x."+ext;
                        }catch(Exception e) {
                        }
                    }else if(Telefono.TipoTelefono.Fijo == tipo) {
                        phnHome = num;
                        try {
                            String lada = telefono.getElementsByTagName("lada").item(0).getChildNodes().item(0).getNodeValue();
                            phnHome = "("+lada+") "+phnHome;
                        }catch(Exception e) {
                        }
                        try {
                            String ext = telefono.getElementsByTagName("lada").item(0).getChildNodes().item(0).getNodeValue();
                            phnHome = phnHome+" x."+ext;
                        }catch(Exception e) {
                        }
                    }else if(Telefono.TipoTelefono.Recados == tipo) {
                        phnOther = num;
                        try {
                            String lada = telefono.getElementsByTagName("lada").item(0).getChildNodes().item(0).getNodeValue();
                            phnOther = "("+lada+") "+phnOther;
                        }catch(Exception e) {
                        }
                        try {
                            String ext = telefono.getElementsByTagName("lada").item(0).getChildNodes().item(0).getNodeValue();
                            phnOther = phnOther+" x."+ext;
                        }catch(Exception e) {
                        }
                    }
                }catch(Exception e) {
                }
            }
        }
//System.out.println("----telefonos.");
        
        if(contact.getElementsByTagName("facebook").item(0)!=null && contact.getElementsByTagName("facebook").item(0).getChildNodes().item(0)!=null)
            facebook = contact.getElementsByTagName("facebook").item(0).getChildNodes().item(0).getNodeValue();
        if(contact.getElementsByTagName("twitter").item(0)!=null && contact.getElementsByTagName("twitter").item(0).getChildNodes().item(0)!=null)
            twitter = contact.getElementsByTagName("twitter").item(0).getChildNodes().item(0).getNodeValue();
        if(contact.getElementsByTagName("linkedin").item(0)!=null && contact.getElementsByTagName("linkedin").item(0).getChildNodes().item(0)!=null)
            linkedin = contact.getElementsByTagName("linkedin").item(0).getChildNodes().item(0).getNodeValue();
        if(contact.getElementsByTagName("skype").item(0)!=null && contact.getElementsByTagName("skype").item(0).getChildNodes().item(0)!=null)
            skype = contact.getElementsByTagName("skype").item(0).getChildNodes().item(0).getNodeValue();
        if(contact.getElementsByTagName("msn").item(0)!=null && contact.getElementsByTagName("msn").item(0).getChildNodes().item(0)!=null)
            msn = contact.getElementsByTagName("msn").item(0).getChildNodes().item(0).getNodeValue();
    }
    
    Locale locale = new Locale(user.getLanguage());
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy", locale);
    
    com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.LETTER);
    document.setMargins(70, 50, 34, 24);
    try {
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        
        Paragraph paragraph = new Paragraph("Curriculum Vitae Infotec",FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, BaseColor.DARK_GRAY));
        paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        paragraph.setSpacingBefore(2);
        paragraph.setSpacingAfter(12);
        document.add(paragraph);
        
        paragraph = new Paragraph("México, D.F. A "+sdf.format(new Date()),FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY));
        paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
        paragraph.setSpacingBefore(2);
        paragraph.setSpacingAfter(12);
        document.add(paragraph);
        
        PdfPTable nstd;
        PdfPCell icell;
        
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new int[]{1,3,3});
        table.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        PdfPCell cell;
        
        String path;
        if(user.getPhoto()==null)
            path = SWBPortal.getWorkPath()+"/models/"+wsite.getId()+"/css/user.jpg";
        else
            path = SWBPortal.getWorkPath()+profile.getWorkPath()+"/"+user.getPhoto();     
        
        cell = new PdfPCell(Image.getInstance(path), true);
        cell.setBorder(PdfPCell.NO_BORDER);
        //cell.setRowspan(5);
        cell.setRowspan(6);
        table.addCell(cell);
        
        cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        paragraph = new Paragraph(fullName, FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, b));
        paragraph.setIndentationLeft(10);
        cell.addElement(paragraph);
        cell.setColspan(2);
        table.addCell(cell);
        
        cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        paragraph = new Paragraph("RFC: "+rfc.toUpperCase(locale), FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD, BaseColor.GRAY));
        paragraph.setIndentationLeft(10);
        cell.addElement(paragraph);
        cell.setColspan(2);
        table.addCell(cell);
        
        cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        paragraph = new Paragraph("CURP: "+curp.toUpperCase(locale), FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD, BaseColor.GRAY));
        paragraph.setIndentationLeft(10);
        cell.addElement(paragraph);
        cell.setColspan(2);
        table.addCell(cell);
        
        cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        paragraph = new Paragraph();
        paragraph.setIndentationLeft(10);
        Chunk chnk;
        chnk = new Chunk("Fecha de nacimiento: "+birthday, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        paragraph.add(new Chunk(", ", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY)));
        chnk = new Chunk("Lugar de nacimiento: "+state, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        paragraph.add(new Chunk(", ", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY)));
        chnk = new Chunk("Nacionalidad: "+nationality, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        /*paragraph.add(new Chunk(", ", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY)));
        chnk = new Chunk("Género: "+gender, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);*/
        cell.addElement(paragraph);
        cell.setColspan(2);
        table.addCell(cell);
          
        cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        paragraph = new Paragraph();
        paragraph.setIndentationLeft(10);
        /*chnk = new Chunk("Nacionalidad: "+nationality, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        paragraph.add(new Chunk(", ", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY)));*/
        chnk = new Chunk("Género: "+gender, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        cell.addElement(paragraph);
        cell.setColspan(2);
        table.addCell(cell);      
        
        cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        paragraph = new Paragraph();
        paragraph.setIndentationLeft(10);
        chnk = new Chunk("Situación: "+sLabor, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        if(availability!=null) {
            paragraph.add(new Chunk(", ", FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY)));
            chnk = new Chunk("Disponibilidad en días hábiles: "+availability, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
            paragraph.add(chnk);
        }
        cell.addElement(paragraph);
        cell.setColspan(2);
        table.addCell(cell);
        
        //telefonos
        nstd = new PdfPTable(8);
        nstd.setWidthPercentage(100);
        nstd.setWidths(new int[]{1,5,1,5,1,5,1,5});
        icell = new PdfPCell(Image.getInstance(SWBPortal.getWorkPath()+"/models/"+wsite.getId()+"/css/ico-cel.jpg"), false);
        icell.setBorder(PdfPCell.NO_BORDER);
        icell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        nstd.addCell(icell);
        icell = new PdfPCell();
        icell.setBorder(PdfPCell.NO_BORDER);
        icell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        paragraph = new Paragraph();
        chnk = new Chunk(phnMobile, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        icell.addElement(paragraph);
        nstd.addCell(icell);
        //
        icell = new PdfPCell(Image.getInstance(SWBPortal.getWorkPath()+"/models/"+wsite.getId()+"/css/ico-telofic.jpg"), false);
        icell.setBorder(PdfPCell.NO_BORDER);
        icell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        nstd.addCell(icell);
        icell = new PdfPCell();
        icell.setBorder(PdfPCell.NO_BORDER);
        icell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        paragraph = new Paragraph();
        chnk = new Chunk(phnJob, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        icell.addElement(paragraph);
        nstd.addCell(icell);
        //
        icell = new PdfPCell(Image.getInstance(SWBPortal.getWorkPath()+"/models/"+wsite.getId()+"/css/ico-telcasa.jpg"), false);
        icell.setBorder(PdfPCell.NO_BORDER);
        nstd.addCell(icell);
        icell = new PdfPCell();
        icell.setBorder(PdfPCell.NO_BORDER);
        icell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        paragraph = new Paragraph();
        chnk = new Chunk(phnHome, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        icell.addElement(paragraph);
        nstd.addCell(icell);
        //
        icell = new PdfPCell(Image.getInstance(SWBPortal.getWorkPath()+"/models/"+wsite.getId()+"/css/ico-telreca.jpg"), false);
        icell.setBorder(PdfPCell.NO_BORDER);
        nstd.addCell(icell);
        icell = new PdfPCell();
        icell.setBorder(PdfPCell.NO_BORDER);
        icell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        paragraph = new Paragraph();
        chnk = new Chunk(phnOther, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        icell.addElement(paragraph);
        nstd.addCell(icell);  
        
        cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setColspan(3);
        cell.addElement(nstd);
        table.addCell(cell);
        // telefonos
        
        //email y redes
        nstd = new PdfPTable(6);
        nstd.setWidthPercentage(100);
        nstd.setWidths(new int[]{1,5,1,5,1,5});
        icell = new PdfPCell(Image.getInstance(SWBPortal.getWorkPath()+"/models/"+wsite.getId()+"/css/ico-mail.jpg"), false);
        icell.setBorder(PdfPCell.NO_BORDER);
        icell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        nstd.addCell(icell);
        icell = new PdfPCell();
        icell.setBorder(PdfPCell.NO_BORDER);
        icell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        paragraph = new Paragraph();
        chnk = new Chunk(email, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        icell.addElement(paragraph);
        nstd.addCell(icell);
        //
        icell = new PdfPCell(Image.getInstance(SWBPortal.getWorkPath()+"/models/"+wsite.getId()+"/css/ico-fb.jpg"), false);
        icell.setBorder(PdfPCell.NO_BORDER);
        icell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        nstd.addCell(icell);
        icell = new PdfPCell();
        icell.setBorder(PdfPCell.NO_BORDER);
        icell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        paragraph = new Paragraph();
        chnk = new Chunk(facebook, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        icell.addElement(paragraph);
        nstd.addCell(icell);
        //
        icell = new PdfPCell(Image.getInstance(SWBPortal.getWorkPath()+"/models/"+wsite.getId()+"/css/ico-twit.jpg"), false);
        icell.setBorder(PdfPCell.NO_BORDER);
        icell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        nstd.addCell(icell);
        icell = new PdfPCell();
        icell.setBorder(PdfPCell.NO_BORDER);
        icell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        paragraph = new Paragraph();
        chnk = new Chunk(twitter, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        icell.addElement(paragraph);
        nstd.addCell(icell);
        
        cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setColspan(3);
        cell.addElement(nstd);
        table.addCell(cell);
        //email y redes
        
        //linkedin
        nstd = new PdfPTable(6);
        nstd.setWidthPercentage(100);
        nstd.setWidths(new int[]{1,5,1,5,1,5});
        icell = new PdfPCell(Image.getInstance(SWBPortal.getWorkPath()+"/models/"+wsite.getId()+"/css/ico-in.jpg"), false);
        icell.setBorder(PdfPCell.NO_BORDER);
        nstd.getDefaultCell().setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
        nstd.addCell(icell);
        icell = new PdfPCell();
        icell.setBorder(PdfPCell.NO_BORDER);
        icell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        paragraph = new Paragraph();
        chnk = new Chunk(linkedin, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        icell.addElement(paragraph);
        nstd.getDefaultCell().setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
        nstd.addCell(icell);
        //
        icell = new PdfPCell(Image.getInstance(SWBPortal.getWorkPath()+"/models/"+wsite.getId()+"/css/ico-sky.jpg"), false);
        icell.setBorder(PdfPCell.NO_BORDER);
        nstd.getDefaultCell().setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
        nstd.addCell(icell);
        icell = new PdfPCell();
        icell.setBorder(PdfPCell.NO_BORDER);
        paragraph = new Paragraph();
        chnk = new Chunk(skype, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        icell.addElement(paragraph);
        nstd.getDefaultCell().setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
        nstd.addCell(icell);
        //
        icell = new PdfPCell(Image.getInstance(SWBPortal.getWorkPath()+"/models/"+wsite.getId()+"/css/ico-msn.jpg"), true);
        icell.setBorder(PdfPCell.NO_BORDER);
        nstd.getDefaultCell().setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
        nstd.addCell(icell);
        icell = new PdfPCell();
        icell.setBorder(PdfPCell.NO_BORDER);
        paragraph = new Paragraph();
        chnk = new Chunk(msn, FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.GRAY));
        paragraph.add(chnk);
        icell.addElement(paragraph);
        nstd.getDefaultCell().setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
        nstd.addCell(icell);
        
        cell = new PdfPCell();
        cell.setBorder(PdfPCell.NO_BORDER);
        cell.setColspan(3);
        cell.addElement(nstd);
        table.addCell(cell);
        //linkedin
        
        document.add(table);
        
        //formacion academica
        paragraph = new Paragraph("Formación académica",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.b));
        paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
        paragraph.setSpacingBefore(10);
        paragraph.setSpacingAfter(6);
        document.add(paragraph);
        //escolaridad
        nNode = dom.getElementsByTagName("grados_academicos").item(0);
        if(nNode!=null) {
            paragraph = new Paragraph("Escolaridad",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.h4));
            paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            paragraph.setSpacingBefore(4);
            paragraph.setSpacingAfter(2);
            document.add(paragraph);
            
            org.w3c.dom.Element grados_academicos = (org.w3c.dom.Element)nNode;
            NodeList nList = grados_academicos.getElementsByTagName("grado");
            if(nList!=null && nList.getLength()>0) {
                List list = new List(List.UNORDERED);
                for(int i=0; i<nList.getLength(); i++) {
                    org.w3c.dom.Element grado = (org.w3c.dom.Element)nList.item(i);
                    if(grado!=null) {
                        StringBuilder content = new StringBuilder();
                        if(grado.getElementsByTagName("nivel").item(0)!=null) {
                            content.append(grado.getElementsByTagName("nivel").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                        }
                        if(grado.getElementsByTagName("carrera").item(0)!=null) {
                            content.append(grado.getElementsByTagName("carrera").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                        }
                        if(grado.getElementsByTagName("institucion").item(0)!=null) {
                            content.append(grado.getElementsByTagName("institucion").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                        }
                        if(grado.getElementsByTagName("situacion").item(0)!=null) {
                            content.append(grado.getElementsByTagName("situacion").item(0).getChildNodes().item(0).getNodeValue());
                        }
                        if(grado.getElementsByTagName("periodo").item(0)!=null) {
                            content.append(" (").append(grado.getElementsByTagName("periodo").item(0).getChildNodes().item(0).getNodeValue()).append(" años)");
                        }
                        ListItem item = new ListItem(content.toString(),FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY));
                        list.add(item);
                    }
                }
                document.add(list);
            }
        }
        //estudios superiores
        nNode = dom.getElementsByTagName("estudios_superiores").item(0);
        if(nNode!=null) {
            paragraph = new Paragraph("Estudios superiores",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.h4));
            paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            paragraph.setSpacingBefore(4);
            paragraph.setSpacingAfter(2);
            document.add(paragraph);
            
            org.w3c.dom.Element estudios_superiores = (org.w3c.dom.Element)nNode;
            NodeList nList = estudios_superiores.getElementsByTagName("estudio");
            if(nList!=null && nList.getLength()>0) {
                List list = new List(List.UNORDERED);
                for(int i=0; i<nList.getLength(); i++) {
                    org.w3c.dom.Element estudio = (org.w3c.dom.Element)nList.item(i);
                    if(estudio!=null) {
                        StringBuilder content = new StringBuilder();
                        if(estudio.getElementsByTagName("nombre").item(0)!=null) {
                            content.append(estudio.getElementsByTagName("nombre").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                        }
                        if(estudio.getElementsByTagName("periodo").item(0)!=null) {
                            content.append(estudio.getElementsByTagName("periodo").item(0).getChildNodes().item(0).getNodeValue()).append(" años, ");
                        }
                        if(estudio.getElementsByTagName("avance").item(0)!=null) {
                            content.append(estudio.getElementsByTagName("avance").item(0).getChildNodes().item(0).getNodeValue()).append("% de avance");
                        }
                        ListItem item = new ListItem(content.toString(),FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY));
                        list.add(item);
                    }
                }
                document.add(list);
            }
        }
        //diplomados
        nNode = dom.getElementsByTagName("diplomados").item(0);
        if(nNode!=null) {
            paragraph = new Paragraph("Diplomados, cursos y certificaciones",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.h4));
            paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            paragraph.setSpacingBefore(4);
            paragraph.setSpacingAfter(2);
            document.add(paragraph);
            
            org.w3c.dom.Element diplomados = (org.w3c.dom.Element)nNode;
            NodeList nList = diplomados.getElementsByTagName("diplomado");
            if(nList!=null && nList.getLength()>0) {
                List list = new List(List.UNORDERED);
                for(int i=0; i<nList.getLength(); i++) {
                    org.w3c.dom.Element diplomado = (org.w3c.dom.Element)nList.item(i);
                    if(diplomado!=null) {
                        StringBuilder content = new StringBuilder();
                        if(diplomado.getElementsByTagName("nombre").item(0)!=null) {
                            content.append(diplomado.getElementsByTagName("nombre").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                        }
                        if(diplomado.getElementsByTagName("institucion").item(0)!=null) {
                            content.append(diplomado.getElementsByTagName("institucion").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                        }
                        if(diplomado.getElementsByTagName("inicio").item(0)!=null) {
                            content.append("De ").append(diplomado.getElementsByTagName("inicio").item(0).getChildNodes().item(0).getNodeValue());
                        }
                        if(diplomado.getElementsByTagName("fin").item(0)!=null) {
                            content.append(" A ").append(diplomado.getElementsByTagName("fin").item(0).getChildNodes().item(0).getNodeValue());
                        }
                        if(diplomado.getElementsByTagName("documento").item(0)!=null) {
                            content.append(" (").append(diplomado.getElementsByTagName("documento").item(0).getChildNodes().item(0).getNodeValue()).append(")");
                        }
                        ListItem item = new ListItem(content.toString(),FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY));
                        list.add(item);
                    }
                }
                document.add(list);
            }
        }
        //cursos tic
        nNode = dom.getElementsByTagName("cursos_tic").item(0);
        if(nNode!=null) {
            paragraph = new Paragraph("Cursos especializados en TIC",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.h4));
            paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            paragraph.setSpacingBefore(4);
            paragraph.setSpacingAfter(2);
            document.add(paragraph);
            
            org.w3c.dom.Element cursos = (org.w3c.dom.Element)nNode;
            NodeList nList = cursos.getElementsByTagName("curso");
            if(nList!=null && nList.getLength()>0) {
                List list = new List(List.UNORDERED);
                for(int i=0; i<nList.getLength(); i++) {
                    org.w3c.dom.Element curso = (org.w3c.dom.Element)nList.item(i);
                    if(curso!=null) {
                        StringBuilder content = new StringBuilder();
                        if(curso.getElementsByTagName("nombre").item(0)!=null) {
                            content.append(curso.getElementsByTagName("nombre").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                        }
                        if(curso.getElementsByTagName("institucion").item(0)!=null) {
                            content.append(curso.getElementsByTagName("institucion").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                        }
                        if(curso.getElementsByTagName("inicio").item(0)!=null) {
                            content.append("De ").append(curso.getElementsByTagName("inicio").item(0).getChildNodes().item(0).getNodeValue());
                        }
                        if(curso.getElementsByTagName("fin").item(0)!=null) {
                            content.append(" A ").append(curso.getElementsByTagName("fin").item(0).getChildNodes().item(0).getNodeValue());
                        }
                        if(curso.getElementsByTagName("documento").item(0)!=null) {
                            content.append(" (").append(curso.getElementsByTagName("documento").item(0).getChildNodes().item(0).getNodeValue()).append(")");
                        }
                        ListItem item = new ListItem(content.toString(),FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY));
                        list.add(item);
                    }
                }
                document.add(list);
            }
        }
        //idiomas
        nNode = dom.getElementsByTagName("idiomas").item(0);
        if(nNode!=null) {
            paragraph = new Paragraph("Idiomas",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.h4));
            paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            paragraph.setSpacingBefore(4);
            paragraph.setSpacingAfter(2);
            document.add(paragraph);
            
            org.w3c.dom.Element idiomas = (org.w3c.dom.Element)nNode;
            NodeList nList = idiomas.getElementsByTagName("idioma");
            if(nList!=null && nList.getLength()>0) {
                List list = new List(List.UNORDERED);
                for(int i=0; i<nList.getLength(); i++) {
                    org.w3c.dom.Element idioma = (org.w3c.dom.Element)nList.item(i);
                    if(idioma!=null) {
                        StringBuilder content = new StringBuilder();
                        if(idioma.getElementsByTagName("nombre").item(0)!=null) {
                            content.append(idioma.getElementsByTagName("nombre").item(0).getChildNodes().item(0).getNodeValue()).append(": ");
                        }
                        if(idioma.getElementsByTagName("conversacion").item(0)!=null) {
                            content.append("Conversación ").append(idioma.getElementsByTagName("conversacion").item(0).getChildNodes().item(0).getNodeValue()).append("%, ");
                        }
                        if(idioma.getElementsByTagName("lectura").item(0)!=null) {
                            content.append("lectura ").append(idioma.getElementsByTagName("lectura").item(0).getChildNodes().item(0).getNodeValue()).append("%, ");
                        }
                        if(idioma.getElementsByTagName("escritura").item(0)!=null) {
                            content.append("escritura ").append(idioma.getElementsByTagName("escritura").item(0).getChildNodes().item(0).getNodeValue()).append("%");
                        }
                        ListItem item = new ListItem(content.toString(),FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY));
                        list.add(item);
                    }
                }
                document.add(list);
            }
        }
        //experiencia
        paragraph = new Paragraph("Experiencia",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.b));
        paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
        paragraph.setSpacingBefore(10);
        paragraph.setSpacingAfter(6);
        document.add(paragraph);
        //experiencia laboral
        nNode = dom.getElementsByTagName("laborales").item(0);
        if(nNode!=null) {
            paragraph = new Paragraph("Experiencia laboral",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.h4));
            paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            paragraph.setSpacingBefore(4);
            paragraph.setSpacingAfter(2);
            document.add(paragraph);
            
            org.w3c.dom.Element laborales = (org.w3c.dom.Element)nNode;
            NodeList nList = laborales.getElementsByTagName("laboral");
            if(nList!=null && nList.getLength()>0) {
                List list = new List(List.UNORDERED);
                for(int i=0; i<nList.getLength(); i++) {
                    org.w3c.dom.Element laboral = (org.w3c.dom.Element)nList.item(i);
                    if(laboral!=null) {
                        StringBuilder content = new StringBuilder();
                        if(laboral.getElementsByTagName("empresa").item(0)!=null) {
                            content.append(laboral.getElementsByTagName("empresa").item(0).getChildNodes().item(0).getNodeValue()).append(". ");
                        }
                        if(laboral.getElementsByTagName("inicio").item(0)!=null) {
                            content.append("Desde ").append(laboral.getElementsByTagName("inicio").item(0).getChildNodes().item(0).getNodeValue());
                        }
                        if(laboral.getElementsByTagName("fin").item(0)!=null) {
                            content.append(" hasta ").append(laboral.getElementsByTagName("fin").item(0).getChildNodes().item(0).getNodeValue()).append(". ");
                        }
                        if(laboral.getElementsByTagName("cargo").item(0)!=null) {
                            content.append("Funciones: ").append(laboral.getElementsByTagName("cargo").item(0).getChildNodes().item(0).getNodeValue());
                        }
                        if(laboral.getElementsByTagName("jefe").item(0)!=null) {
                            content.append("Jefe inmediato: ").append(laboral.getElementsByTagName("jefe").item(0).getChildNodes().item(0).getNodeValue()).append(" ");
                        }
                        if(laboral.getElementsByTagName("telefono").item(0)!=null) {
                            org.w3c.dom.Element telefono = (org.w3c.dom.Element)nList.item(0);
                            if(telefono!=null) {
                                String num = telefono.getElementsByTagName("numero").item(0).getChildNodes().item(0).getNodeValue();
                                try {
                                    String lada = telefono.getElementsByTagName("lada").item(0).getChildNodes().item(0).getNodeValue();
                                    num = "("+lada+") "+num;
                                }catch(Exception e){
                                }
                                try {
                                    String ext = telefono.getElementsByTagName("lada").item(0).getChildNodes().item(0).getNodeValue();
                                    num = num+" x."+ext;
                                }catch(Exception e) {
                                }
                                content.append(num);
                            }
                            content.append(laboral.getElementsByTagName("telefono").item(0).getChildNodes().item(0).getNodeValue());
                        }
                        ListItem item = new ListItem(content.toString(),FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY));
                        list.add(item);
                    }
                }
                document.add(list);
            }
        }
        //talento y expertise
        nNode = dom.getElementsByTagName("talentos").item(0);
        if(nNode!=null) {
            paragraph = new Paragraph("Áreas de talento o expertise",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.h4));
            paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            paragraph.setSpacingBefore(4);
            paragraph.setSpacingAfter(2);
            document.add(paragraph);
            
            org.w3c.dom.Element talentos = (org.w3c.dom.Element)nNode;
            NodeList nList = talentos.getElementsByTagName("talento");
            if(nList!=null && nList.getLength()>0) {
                List list = new List(List.UNORDERED);
                for(int i=0; i<nList.getLength(); i++) {
                    org.w3c.dom.Element talento = (org.w3c.dom.Element)nList.item(i);
                    if(talento!=null) {
                        StringBuilder content = new StringBuilder();
                        if(talento.getElementsByTagName("nombre").item(0)!=null) {
                            content.append(talento.getElementsByTagName("nombre").item(0).getChildNodes().item(0).getNodeValue()).append(": ");
                        }
                        if(talento.getElementsByTagName("habilidad").item(0)!=null) {
                            content.append(talento.getElementsByTagName("habilidad").item(0).getChildNodes().item(0).getNodeValue());
                        }
                        if(talento.getElementsByTagName("lectura").item(0)!=null) {
                            content.append(" (").append(talento.getElementsByTagName("tiempo").item(0).getChildNodes().item(0).getNodeValue()).append(" años)");
                        }
                        ListItem item = new ListItem(content.toString(),FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY));
                        list.add(item);
                    }
                }
                document.add(list);
            }
        }
        //distinciones
        nNode = dom.getElementsByTagName("distinciones").item(0);
        if(nNode!=null) {
            paragraph = new Paragraph("Distinciones y reconocimientos",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.h4));
            paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            paragraph.setSpacingBefore(4);
            paragraph.setSpacingAfter(2);
            document.add(paragraph);
            
            org.w3c.dom.Element distinciones = (org.w3c.dom.Element)nNode;
            NodeList nList = distinciones.getElementsByTagName("distincion");
            if(nList!=null && nList.getLength()>0) {
                List list = new List(List.UNORDERED);
                for(int i=0; i<nList.getLength(); i++) {
                    org.w3c.dom.Element distincion = (org.w3c.dom.Element)nList.item(i);
                    if(distincion!=null) {
                        StringBuilder content = new StringBuilder();
                        if(distincion.getElementsByTagName("nombre").item(0)!=null) {
                            content.append(distincion.getElementsByTagName("nombre").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                        }
                        if(distincion.getElementsByTagName("otorgante").item(0)!=null) {
                            content.append(distincion.getElementsByTagName("otorgante").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                        }
                        if(distincion.getElementsByTagName("fecha").item(0)!=null) {
                            content.append(distincion.getElementsByTagName("fecha").item(0).getChildNodes().item(0).getNodeValue());
                        }
                        ListItem item = new ListItem(content.toString(),FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY));
                        list.add(item);
                    }
                }
                document.add(list);
            }
        }
        //competencias
        nNode = dom.getElementsByTagName("competencias").item(0);
        if(nNode!=null) {
            paragraph = new Paragraph("Competencias",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.b));
            paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            paragraph.setSpacingBefore(10);
            paragraph.setSpacingAfter(6);
            document.add(paragraph);
            paragraph = new Paragraph("Autoevaluación de competencias",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.h4));
            paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            paragraph.setSpacingBefore(4);
            paragraph.setSpacingAfter(2);
            document.add(paragraph);
            
            org.w3c.dom.Element competencias = (org.w3c.dom.Element)nNode;
            NodeList nList = competencias.getElementsByTagName("competencia");
            if(nList!=null && nList.getLength()>0) {
                List list = new List(List.UNORDERED);
                for(int i=0; i<nList.getLength(); i++) {
                    org.w3c.dom.Element competencia = (org.w3c.dom.Element)nList.item(i);
                    if(competencia!=null) {
                        StringBuilder content = new StringBuilder();
                        if(competencia.getChildNodes().item(0)!=null) {
                            content.append(competencia.getChildNodes().item(0).getNodeValue());
                        }
                        ListItem item = new ListItem(content.toString(),FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY));
                        list.add(item);
                    }
                }
                document.add(list);
            }
        }
        //investigacion
        nNode = dom.getElementsByTagName("investigacion_docencia").item(0);
        if(nNode!=null) {
            paragraph = new Paragraph("Investigación y docencia",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.b));
            paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
            paragraph.setSpacingBefore(10);
            paragraph.setSpacingAfter(6);
            document.add(paragraph);
            //docencia
            nNode = dom.getElementsByTagName("docencias").item(0);
            if(nNode!=null) {
                paragraph = new Paragraph("Docencia",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.h4));
                paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
                paragraph.setSpacingBefore(4);
                paragraph.setSpacingAfter(2);
                document.add(paragraph);
                
                org.w3c.dom.Element docencias = (org.w3c.dom.Element)nNode;
                NodeList nList = docencias.getElementsByTagName("docencia");
                if(nList!=null && nList.getLength()>0) {
                    List list = new List(List.UNORDERED);
                    for(int i=0; i<nList.getLength(); i++) {
                        org.w3c.dom.Element docencia = (org.w3c.dom.Element)nList.item(i);
                        if(docencia!=null) {
                            StringBuilder content = new StringBuilder();
                            if(docencia.getElementsByTagName("asignatura").item(0)!=null) {
                                content.append(docencia.getElementsByTagName("asignatura").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                            }
                            if(docencia.getElementsByTagName("institucion").item(0)!=null) {
                                content.append(docencia.getElementsByTagName("institucion").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                            }
                            if(docencia.getElementsByTagName("nivel").item(0)!=null) {
                                content.append(docencia.getElementsByTagName("nivel").item(0).getChildNodes().item(0).getNodeValue());
                            }
                            ListItem item = new ListItem(content.toString(),FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY));
                            list.add(item);
                        }
                    }
                    document.add(list);
                }
            }
            //investigacion
            nNode = dom.getElementsByTagName("investigaciones").item(0);
            if(nNode!=null) {
                paragraph = new Paragraph("Investigación",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.h4));
                paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
                paragraph.setSpacingBefore(4);
                paragraph.setSpacingAfter(2);
                document.add(paragraph);
                
                org.w3c.dom.Element investigaciones = (org.w3c.dom.Element)nNode;
                NodeList nList = investigaciones.getElementsByTagName("investigacion");
                if(nList!=null && nList.getLength()>0) {
                    List list = new List(List.UNORDERED);
                    for(int i=0; i<nList.getLength(); i++) {
                        org.w3c.dom.Element investigacion = (org.w3c.dom.Element)nList.item(i);
                        if(investigacion!=null) {
                            StringBuilder content = new StringBuilder();
                            if(investigacion.getElementsByTagName("empresa").item(0)!=null) {
                                content.append(investigacion.getElementsByTagName("empresa").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                            }
                            if(investigacion.getElementsByTagName("area").item(0)!=null) {
                                content.append(investigacion.getElementsByTagName("area").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                            }
                            if(investigacion.getElementsByTagName("tiempo").item(0)!=null) {
                                content.append(investigacion.getElementsByTagName("tiempo").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                            }
                            if(investigacion.getElementsByTagName("cargo").item(0)!=null) {
                                content.append(investigacion.getElementsByTagName("cargo").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                            }
                            if(investigacion.getElementsByTagName("jefe").item(0)!=null) {
                                content.append("Jefe inmediato: ").append(investigacion.getElementsByTagName("jefe").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                            }
                            if(investigacion.getElementsByTagName("institucion").item(0)!=null) {
                                content.append(investigacion.getElementsByTagName("institucion").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                            }
                            if(investigacion.getElementsByTagName("sni").item(0)!=null) {
                                content.append("SNI Conacyt: ").append(investigacion.getElementsByTagName("sni").item(0).getChildNodes().item(0).getNodeValue());
                            }
                            ListItem item = new ListItem(content.toString(),FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY));
                            list.add(item);
                        }
                    }
                    document.add(list);
                }
            }
            //publicaciones
            nNode = dom.getElementsByTagName("publicaciones").item(0);
            if(nNode!=null) {
                paragraph = new Paragraph("Publicaciones",FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, ImprimirCV.h4));
                paragraph.setAlignment(com.itextpdf.text.Element.ALIGN_LEFT);
                paragraph.setSpacingBefore(4);
                paragraph.setSpacingAfter(2);
                document.add(paragraph);
                
                org.w3c.dom.Element publicaciones = (org.w3c.dom.Element)nNode;
                NodeList nList = publicaciones.getElementsByTagName("publicacion");
                if(nList!=null && nList.getLength()>0) {
                    List list = new List(List.UNORDERED);
                    for(int i=0; i<nList.getLength(); i++) {
                        org.w3c.dom.Element publicacion = (org.w3c.dom.Element)nList.item(i);
                        if(publicacion!=null) {
                            StringBuilder content = new StringBuilder();
                            if(publicacion.getElementsByTagName("titulo").item(0)!=null) {
                                content.append(publicacion.getElementsByTagName("titulo").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                            }
                            if(publicacion.getElementsByTagName("medio").item(0)!=null) {
                                content.append(publicacion.getElementsByTagName("medio").item(0).getChildNodes().item(0).getNodeValue()).append(", ");
                            }
                            if(publicacion.getElementsByTagName("fecha").item(0)!=null) {
                                content.append(publicacion.getElementsByTagName("fecha").item(0).getChildNodes().item(0).getNodeValue());
                            }
                            ListItem item = new ListItem(content.toString(),FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY));
                            list.add(item);
                        }
                    }
                    document.add(list);
                }
            }
        }
    }catch(Exception e) {
        e.printStackTrace(System.out);
        log.error(e);
    }finally {
        if(document!=null && document.isOpen())
            document.close();
    }
    
%>