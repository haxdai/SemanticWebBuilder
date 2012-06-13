/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm.resources.version2012;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 * Extrae los datos de un archivo .txt que contiene las coordenadas de la
 * localización de hoteles, manteniendo los datos en memoria. La petición de
 * los datos que se extraen del archivo son entregados en formato JSON
 * @author martha.jimenez
 * 25/05/2012
 */

public class CoordinatesHotels extends GenericAdmResource {

    /* Almacena el log de errores de la clase actual para mostrarlo en SWB */
    static Logger log = SWBUtils.getLogger(CoordinatesHotels.class);

    /* Almacena las coordenadas para mantenerlas en memoria */
    static HashMap coordinates = new HashMap();

    /* Método que se encarga de leer el archivo txt y almacenar las coordenadas en un HashMap,
     cuando el recurso es cargado en memoria. El archivo que lee debe tener el formato UTF-8 */
    @Override
    public void setResourceBase(Resource base) throws SWBResourceException {
        super.setResourceBase(base);
        String pathFile = "";
        if(base.getAttribute("pathFileTxt") != null &&  base.getAttribute("pathFileTxt").trim().length() > 1) {
            pathFile = SWBPortal.getWorkPath() + base.getAttribute("pathFileTxt");
            File file = new File(pathFile);
            try {
                if (!coordinates.isEmpty()) {
                    coordinates.clear();
                }
                InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file),"UTF-8");
                BufferedReader buffer = new BufferedReader(streamReader);
                String line = buffer.readLine().substring(2);
                while (line != null) {
                    String[] data = line.split("\\t");
                    String title = data != null && data.length > 0 ? data[0] : null;
                    String coordinatesHotels = data != null && data.length > 0 ? data[1] : null;
                    if (title != null && coordinatesHotels != null) {
                        coordinates.put(title, coordinatesHotels);
                    }
                    line = buffer.readLine();
                }
            } catch(FileNotFoundException e){
                log.error("FileNotFoundException: " + e);
            } catch(UnsupportedEncodingException e1){
                log.error("UnsupportedEncodingException: " + e1);
            } catch(IOException e2){
                log.error("IOException: " + e2);
            }
        }
    }

    /* Muestra un ejemplo de cómo obtener las coordenadas de los hoteles, y cómo leer
       los elementos que son entregados en formato JSON */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        JSONArray listCoordinatesHotels = getListCoordinatesHotels();
        if(listCoordinatesHotels != null) {
            out.println("<table>");
            out.println("<tr><th>Hotel</th><th>Coordenadas</th></tr>");
            for(int count = 0; count < listCoordinatesHotels.length(); count++) {
                try {
                    JSONObject objCoordinate = listCoordinatesHotels.getJSONObject(count);
                    Iterator itObjCoordinate = objCoordinate.keys();
                    while(itObjCoordinate.hasNext()) {
                        String key = itObjCoordinate.next().toString();
                        String value = objCoordinate.get(key).toString();
                        out.println("<tr><td> " + key + "</td><td>" + value + "</td></tr>");
                    }
                } catch(Exception e) {
                    log.error(e);
                }
            }
            out.println("</table>");
        }
    }

    /* Método que permite obtener las coordenadas de los hoteles en formato JSON*/
    public static JSONArray getListCoordinatesHotels() {
        JSONArray listHotels = new JSONArray();
        if(!coordinates.isEmpty()) {
            Iterator itCoordinates = coordinates.entrySet().iterator();
            while(itCoordinates.hasNext()) {
                JSONObject coordinate = new JSONObject();
                Map.Entry coordinateHotel = (Map.Entry) itCoordinates.next();
                try {
                    String[] coord = coordinateHotel.getValue().toString().split(",");
                    if (coord != null && coord.length == 2) {
                        //coordinate.putOpt(coordinateHotel.getKey().toString(), coordinateHotel.getValue());
                        coordinate.put("name", coordinateHotel.getKey().toString());
                        coordinate.put("latitude", coord[0]);
                        coordinate.put("longitude", coord[1]);
                        coordinate.put("objType", "HotelsMex");
                        listHotels.put(coordinate);
                    }
                } catch(Exception e){
                    log.error(e);
                }
                listHotels.put(coordinate);
            }
        }
        return listHotels;
    }
}
