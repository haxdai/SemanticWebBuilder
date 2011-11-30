
package org.semanticwb.promexico.utils;


import java.util.Comparator;
import org.semanticwb.promexico.New;


/**
 * Compara fechas de publicaci&oacute;n de dos noticias para determinar cual es m&aacute;s reciente
 * @author jose.jimenez
 */
public class NewsPublicationDateComparator implements Comparator {


    /**
     * Compara las fechas de publicaci&oacute;n de dos noticias y determina cual es m&aacute;s reciente
     * @param news1 primer noticia cuya fecha de publicaci&oacute;n se va a comparar
     * @param news2 segunda noticia cuya fecha de publicaci&oacute;n se va a comparar
     * @return un entero negativo, cero o un entero positivo de acuerdo a si la
     *         fecha de publicaci&oacute;n de la segunda noticia es anterior,
     *         igual o posterior que el primero.
     */
    public int compare(Object news1, Object news2) {

        int comparacion;
        Long d1 = new Long(0L);
        Long d2 = new Long(0L);
        if (news1 != null && ((New) news1).getPublicationDate() != null) {
            d1 = ((New) news1).getPublicationDate().getTime();
        }
        if (news2 != null && ((New) news2).getPublicationDate() != null) {
            d2 = ((New) news2).getPublicationDate().getTime();
        }
        comparacion = d2.compareTo(d1);
        return comparacion;
    }
}
