/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.sieps.search;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.sieps.Busqueda;
import org.semanticwb.sieps.Busquedas;
import org.semanticwb.sieps.Empresa;
import org.semanticwb.sieps.EmpresaInteres;
import org.semanticwb.sieps.Producto;

/**
 *
 * @author victor.lorenzana
 */
public class SearchResource extends GenericResource
{

    private static Logger log = SWBUtils.getLogger(SearchResource.class);
    /**
     * Variables que determinan el tipo de resultado consultado.
     */
    private static final int TIPO_EMPRESA = 1,
            TIPO_PRODUCTO = 2,
            TIPO_WEBPAGE = 3;

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        String action = response.getAction();
        User user = response.getUser();
        boolean isUser = (user != null && user.isSigned());
        String mensaje = "";
        SWBModel webSite = getResourceBase().getWebSite();
        response.setMode(SWBParamRequest.Mode_VIEW);

        String query = request.getParameter("currentQuery");
        try
        {
            if (isUser)
            {
                if ("guardaConsulta".equals(action))
                {
                    // Crea el objeto búsqueda...
                    Busqueda busqueda = Busqueda.ClassMgr.createBusqueda(webSite);
                    busqueda.setSeach(query);
                    // Crea el objeto búsquedas (ligado a un usuario)...
                    Busquedas busquedasUsr = Busquedas.ClassMgr.createBusquedas(webSite);
                    busquedasUsr.addBusqueda(busqueda);
                    busquedasUsr.setUsuario(user);
                    mensaje = "La búsqueda ha sido agregada a su carpeta";

                }
                else if ("guardaEmpresas".equals(action))
                {
                    String[] empresas = request.getParameterValues("chkEmpresas");
                    if (empresas != null && empresas.length > 0)
                    {
                        for (String uriEmpresa : empresas)
                        {
                            if (uriEmpresa != null)
                            {
                                //Recupera la empresa...
                                Empresa emp = Empresa.ClassMgr.createEmpresa(uriEmpresa, webSite);
                                //Crea la empresa de interés..
                                EmpresaInteres empresaInteres = EmpresaInteres.ClassMgr.createEmpresaInteres(webSite);
                                //Añade empresa...
                                empresaInteres.addEmpresa(emp);
                                //Añade usuario...
                                empresaInteres.setUsuario(user);
                            }
                            mensaje = "Las empresas han sido agregadas a su carpeta";
                        }
                    }
                }
                else
                {
                    super.processAction(request, response);
                }
            }
            else
            {
                mensaje = "El usuario debe de estar firmado en el sistema";
            }
        }
        catch (Exception e)
        {
            log.error(e);
            mensaje = "Imposible agregar a carpeta por el momento";
        }
        response.setRenderParameter("act", "results");
        response.setRenderParameter("query", query);
        response.setRenderParameter("mensaje", mensaje);
        return;
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String path = "/swbadmin/jsp/sieps/resultsEmpresa.jsp";
        RequestDispatcher dis = null;
        User user = paramRequest.getUser();
        try
        {
            if (paramRequest.getCallMethod() == SWBParamRequest.Call_STRATEGY)
            {
                path = "/swbadmin/jsp/sieps/search.jsp";

            }
            else
            {
                String act = request.getParameter("act");
                if ("detail".equals(act))
                {
                    String uri = request.getParameter("uri");
                    if (uri != null && uri.length() > 0)
                    {

                        SemanticObject semanticObject = SemanticObject.createSemanticObject(URLDecoder.decode(uri, "UTF-8"));
                        GenericObject genericObject = semanticObject.createGenericInstance();
                        int tipoResultadoDetalle = determinaTipoResultados(semanticObject);
                        request.setAttribute("obj", genericObject);
                        path = (TIPO_EMPRESA == tipoResultadoDetalle)
                                ? "/swbadmin/jsp/sieps/detailEmpresa.jsp"
                                : "/swbadmin/jsp/sieps/detailProducto.jsp";
                    }
                }
                else if ("busquedaproductos".equals(act))
                {
                    StringBuilder sb = new StringBuilder("productos ");
                    Enumeration names = request.getParameterNames();
                    while (names.hasMoreElements())
                    {
                        String name = names.nextElement().toString();
                        if (name!=null && !"opc".equalsIgnoreCase(name) && !"wbseach".equalsIgnoreCase(name) && !"busquedaproductos".equalsIgnoreCase(name))
                        {
                            String[] values = request.getParameterValues(name);
                            if (values != null)
                            {
                                int i = 1;
                                for (String value : values)
                                {
                                    if (value!=null && !"".equals(value) && !"all".equals(value))
                                    {
                                        if (i > 1)
                                        {
                                            sb.append(" y que ");
                                        }
                                        if("palabraClave".equalsIgnoreCase(name))
                                        {
                                            sb.append(" cuya ");
                                            sb.append("nombre");
                                            sb.append(" es ");
                                            sb.append(value);
                                        }
                                        else
                                        {
                                            sb.append(" cuya ");
                                            sb.append(name);
                                            sb.append(" es ");
                                            sb.append(value);
                                        }
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                    String query = sb.toString();
                    NLSearcher searcher = new NLSearcher("es");
                    Iterator<SemanticObject> results = searcher.search(query, paramRequest.getWebPage().getWebSite(), paramRequest.getUser());

                    List<SemanticObject> listSemObj = construyeColeccionSemObjs(results);

                    int tipoResultados = determinaTipoResultados(listSemObj);

                    if (TIPO_EMPRESA == tipoResultados)
                    {
                        List<Empresa> listEmpresas = contruyeColeccionEmpresas(listSemObj);
                        //El usuario tiene empresas de interés ...
                        request.setAttribute("results", listEmpresas);

                        boolean isAllEmpInt = isAllEmpresasInteres(listEmpresas, getResourceBase().getWebSite(), user);
                        request.setAttribute("isAllEmpInt", isAllEmpInt);
                        request.setAttribute("query", query);
                        path = "/swbadmin/jsp/sieps/resultsEmpresa.jsp";
                    }
                    else if (TIPO_PRODUCTO == tipoResultados)
                    {
                        List<Producto> listProductos = contruyeColeccionProductos(listSemObj);
                        request.setAttribute("results", listProductos);
                        request.setAttribute("query", query);
                        path = "/swbadmin/jsp/sieps/resultsProducto.jsp";
                    }
                    else if (TIPO_WEBPAGE == tipoResultados)
                    {
                        List<Producto> listProductos = contruyeColeccionProductos(listSemObj);
                        request.setAttribute("results", listProductos);
                        request.setAttribute("query", query);
                        path = "/swbadmin/jsp/sieps/resultsWebPage.jsp";
                    }
                    

                }
                else if ("busquedaempresas".equals(act))
                {
                    StringBuilder sb = new StringBuilder("productos ");
                    Enumeration names = request.getParameterNames();
                    while (names.hasMoreElements())
                    {
                        String name = names.nextElement().toString();
                        if (name!=null && !"opc".equalsIgnoreCase(name) && !"wbseach".equalsIgnoreCase(name) && !"busquedaempresas".equalsIgnoreCase(name))
                        {
                            String[] values = request.getParameterValues(name);
                            if (values != null)
                            {
                                int i = 1;
                                for (String value : values)
                                {
                                    if (value!=null && !"".equals(value) && !"all".equals(value))
                                    {
                                        if (i > 1)
                                        {
                                            sb.append(" y que ");
                                        }
                                        if("palabraClave".equalsIgnoreCase(name))
                                        {
                                            sb.append(" cuya ");
                                            sb.append("nombre");
                                            sb.append(" es ");
                                            sb.append(value);
                                        }
                                        else
                                        {
                                            sb.append(" cuya ");
                                            sb.append(name);
                                            sb.append(" es ");
                                            sb.append(value);
                                        }
                                       
                                        
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                    String query = sb.toString();
                    NLSearcher searcher = new NLSearcher("es");
                    Iterator<SemanticObject> results = searcher.search(query, paramRequest.getWebPage().getWebSite(), paramRequest.getUser());

                    List<SemanticObject> listSemObj = construyeColeccionSemObjs(results);

                    int tipoResultados = determinaTipoResultados(listSemObj);

                    if (TIPO_EMPRESA == tipoResultados)
                    {
                        List<Empresa> listEmpresas = contruyeColeccionEmpresas(listSemObj);
                        //El usuario tiene empresas de interés ...
                        request.setAttribute("results", listEmpresas);

                        boolean isAllEmpInt = isAllEmpresasInteres(listEmpresas, getResourceBase().getWebSite(), user);
                        request.setAttribute("isAllEmpInt", isAllEmpInt);
                        request.setAttribute("query", query);
                        path = "/swbadmin/jsp/sieps/resultsEmpresa.jsp";
                    }
                    else if (TIPO_PRODUCTO == tipoResultados)
                    {
                        List<Producto> listProductos = contruyeColeccionProductos(listSemObj);
                        request.setAttribute("results", listProductos);
                        request.setAttribute("query", query);
                        path = "/swbadmin/jsp/sieps/resultsProducto.jsp";
                    }
                    else if (TIPO_WEBPAGE == tipoResultados)
                    {
                        List<Producto> listProductos = contruyeColeccionProductos(listSemObj);
                        request.setAttribute("results", listProductos);
                        request.setAttribute("query", query);
                        path = "/swbadmin/jsp/sieps/resultsWebPage.jsp";
                    }
                }
                else if ("results".equals(act))
                {
                    String query = request.getParameter("query");
                    NLSearcher searcher = new NLSearcher("es");
                    Iterator<SemanticObject> results = searcher.search(query, paramRequest.getWebPage().getWebSite(), paramRequest.getUser());

                    List<SemanticObject> listSemObj = construyeColeccionSemObjs(results);

                    int tipoResultados = determinaTipoResultados(listSemObj);

                    if (TIPO_EMPRESA == tipoResultados)
                    {
                        List<Empresa> listEmpresas = contruyeColeccionEmpresas(listSemObj);
                        //El usuario tiene empresas de interés ...                        
                        request.setAttribute("results", listEmpresas);

                        boolean isAllEmpInt = isAllEmpresasInteres(listEmpresas, getResourceBase().getWebSite(), user);
                        request.setAttribute("isAllEmpInt", isAllEmpInt);
                        request.setAttribute("query", query);

                        path = "/swbadmin/jsp/sieps/resultsEmpresa.jsp";
                    }
                    else if (TIPO_PRODUCTO == tipoResultados)
                    {
                        List<Producto> listProductos = contruyeColeccionProductos(listSemObj);
                        request.setAttribute("results", listProductos);
                        request.setAttribute("query", query);
                        path = "/swbadmin/jsp/sieps/resultsProducto.jsp";
                    }
                    else if (TIPO_WEBPAGE == tipoResultados)
                    {
                        List<Producto> listProductos = contruyeColeccionProductos(listSemObj);
                        request.setAttribute("results", listProductos);
                        request.setAttribute("query", query);
                        path = "/swbadmin/jsp/sieps/resultsWebPage.jsp";
                    }

                }
                else if ("cat".equals(act))
                {
                    String uri = request.getParameter("uri");

                    if (uri != null && uri.length() > 0)
                    {
                        SemanticObject semanticObject = SemanticObject.createSemanticObject(URLDecoder.decode(uri, "UTF-8"));
                        GenericObject genericObject = semanticObject.createGenericInstance();
                        int tipoResultadoDetalle = determinaTipoResultados(semanticObject);
                        request.setAttribute("obj", genericObject);
                        path = (TIPO_EMPRESA == tipoResultadoDetalle)
                                ? "/swbadmin/jsp/sieps/catprod.jsp"
                                : "/swbadmin/jsp/sieps/catempresa.jsp";
                    }

                }
                else if ("empresassimilares".equals(act))
                {
                    String uri = request.getParameter("uri");

                    if (uri != null && uri.length() > 0)
                    {
                        SemanticObject semanticObject = SemanticObject.createSemanticObject(URLDecoder.decode(uri, "UTF-8"));
                        GenericObject genericObject = semanticObject.createGenericInstance();
                        int tipoResultadoDetalle = determinaTipoResultados(semanticObject);
                        request.setAttribute("obj", genericObject);
                        path = (TIPO_EMPRESA == tipoResultadoDetalle)
                                ? "/swbadmin/jsp/sieps/empresassimilares.jsp"
                                : "/swbadmin/jsp/sieps/productossimilares.jsp";
                    }

                }
                else
                {
                    path = "/swbadmin/jsp/sieps/resultsEmpresa.jsp";
                }
            }
            dis = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);

        }
        catch (Exception e)
        {
            log.error(e);
            dis = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            try
            {
                dis.include(request, response);
            }
            catch (Exception ex)
            {
                log.error(ex);
            }

        }

    }

    /**
     * Obtiene una colección de instancias de tipo Empresa a partir de un conjunto de objetos semánticos
     * @param semObjects Iterador sobre una colección de objetos semánticos
     * @return Colección con la información
     */
    private List<Empresa> contruyeColeccionEmpresas(List<SemanticObject> semObjects)
    {
        List<Empresa> results = Collections.emptyList();
        if (!semObjects.isEmpty())
        {
            results = new ArrayList<Empresa>(semObjects.size());
            for (SemanticObject so : semObjects)
            {
                GenericObject go = so.createGenericInstance();
                if (go instanceof Empresa)
                {
                    results.add((Empresa) go);
                }
            }
        }
        return results;
    }

    /**
     * Obtiene una colección de instancias de tipo Productos a partir de un conjunto de objetos semánticos
     * @param semObjects Iterador sobre una colección de objetos semánticos
     * @return Colección con la información
     */
    private List<Producto> contruyeColeccionProductos(List<SemanticObject> semObjects)
    {
        List<Producto> results = Collections.emptyList();
        if (!semObjects.isEmpty())
        {
            results = new ArrayList<Producto>(semObjects.size());
            for (SemanticObject so : semObjects)
            {
                GenericObject go = so.createGenericInstance();
                if (go instanceof Producto)
                {
                    results.add((Producto) go);
                }
            }

        }
        return results;
    }

    /**
     * Determina el tipo real de los elementos que integran una colección de objetos semánticos
     * @param results Iterador sobre una colección de objetos semánticos
     * @return identificador de tipo de resultado
     */
    private int determinaTipoResultados(List<SemanticObject> results)
    {
        int tipoRes = -1;
        if (!results.isEmpty())
        {
            SemanticObject so = results.get(0);
            GenericObject go = so.createGenericInstance();
            if (go instanceof Empresa)
            {
                tipoRes = TIPO_EMPRESA;
            }
            else if (go instanceof Producto)
            {
                tipoRes = TIPO_PRODUCTO;
            }
            else if (go instanceof WebPage)
            {
                tipoRes = TIPO_WEBPAGE;
            }
            else
            {
                tipoRes = -1;
            }
        }
        return tipoRes;
    }

    /**
     * Determina el tipo real de un objeto semántico
     * @param semanticObject Objeto semántico
     * @return identificador de tipo de resultado
     */
    private int determinaTipoResultados(SemanticObject semanticObject)
    {
        int tipoRes = -1;
        if (semanticObject != null)
        {
            GenericObject go = semanticObject.createGenericInstance();
            if (go instanceof Empresa)
            {
                tipoRes = TIPO_EMPRESA;
            }
            else if (go instanceof Producto)
            {
                tipoRes = TIPO_PRODUCTO;
            }
            else
            {
                tipoRes = -1;
            }
        }
        return tipoRes;
    }

    private List<SemanticObject> construyeColeccionSemObjs(Iterator<SemanticObject> results)
    {
        List<SemanticObject> semObjs = Collections.emptyList();
        if (results != null)
        {
            semObjs = new ArrayList<SemanticObject>();
            while (results.hasNext())
            {
                SemanticObject semanticObject = results.next();
                if (semObjs != null)
                {
                    semObjs.add(semanticObject);
                }
            }
        }
        return semObjs;
    }

    public static boolean isEmpresasInteres(User user, SWBModel model, String uriEmpresa)
    {

        boolean isEmprInteres = false;

        try
        {
            if (user == null)
            {
                throw new IllegalArgumentException("Argumento user nulo");
            }
            Empresa empresa = (Empresa) SemanticObject.createSemanticObject(uriEmpresa).createGenericInstance();
            if (empresa != null)
            {

                Iterator<EmpresaInteres> interes = EmpresaInteres.ClassMgr.listEmpresaIntereses(model);

                if (interes != null)
                {
                    while (interes.hasNext())
                    {
                        EmpresaInteres empresaInteres = interes.next();
                        if (empresaInteres != null)
                        {
                            User userInteres = empresaInteres.getUsuario();
                            isEmprInteres = (userInteres != null && user.getURI() != null
                                    && user.getURI().equals(userInteres.getURI()));
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
        return isEmprInteres;
    }

    public static void limpiaEmpresasInteres(User user, SWBModel model, List<Empresa> empresas)
    {

        try
        {
            if (user == null)
            {
                throw new IllegalArgumentException("Argumento user nulo");
            }

            for (Empresa empresa : empresas)
            {
                if (empresa != null)
                {
                    Iterator<EmpresaInteres> interes = EmpresaInteres.ClassMgr.listEmpresaIntereses(model);
                    if (interes != null)
                    {
                        while (interes.hasNext())
                        {
                            EmpresaInteres empresaInteres = interes.next();
                            if (empresaInteres != null)
                            {
                                User userInteres = empresaInteres.getUsuario();
                                boolean isEmprInteres = (userInteres != null && user.getURI() != null
                                        && user.getURI().equals(userInteres.getURI()));
                                if (isEmprInteres)
                                {
                                    EmpresaInteres.ClassMgr.removeEmpresaInteres(empresaInteres.getId(), model);
                                }
                            }
                        }
                    }
                }
            }

        }
        catch (Exception e)
        {
            log.error(e);
        }
        return;
    }

    private boolean isAllEmpresasInteres(List<Empresa> empresas, SWBModel webSite, User user)
    {

        boolean isAllEmpresas = true;
        try
        {
            int numEmpInt = 0;

            //Empresas de interes usr...
            List<String> listIdsEmpresaIntereses = new ArrayList<String>();

            Iterator<EmpresaInteres> interes = EmpresaInteres.ClassMgr.listEmpresaIntereses();

            while (interes.hasNext())
            {
                EmpresaInteres empInt = interes.next();
                User userEmptInt = empInt.getUsuario();
                if (userEmptInt.getURI().equals(user.getURI()))
                {
                    String id = empInt.getEmpresa().getId();
                    if (!listIdsEmpresaIntereses.contains(id))
                    {
                        listIdsEmpresaIntereses.add(id);
                    }
                }
            }
            //La empresa de interes existe en el conjunto resultado
            for (String id : listIdsEmpresaIntereses)
            {
                for (Empresa empresa : empresas)
                {
                    if (empresa.getURI().equals(id))
                    {
                        ++numEmpInt;
                    }
                }
            }

            isAllEmpresas = (numEmpInt == empresas.size());
        }
        catch (Exception e)
        {
            log.error(e);
        }

        return isAllEmpresas;

    }
}
