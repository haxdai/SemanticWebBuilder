package org.semanticwb.tankwar;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


   /**
   * Clase principal. Es la clase que representa a cada uno de los Tanques 
   */
public class Tank extends org.semanticwb.tankwar.base.TankBase 
{
    public Tank(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static Set sortTanksByScore(Iterator it, boolean ascendente) {
        TreeSet set = null;

        if (ascendente) {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                        Tank ob1 = (Tank) (o1);
                        Tank ob2 = (Tank) (o2);
                        int       ret = ob1.getScore()<ob2.getScore()
                                        ? 1
                                        : -1;

                        return ret;
                }
            });
        } else {
            set = new TreeSet(new Comparator() {
                public int compare(Object o1, Object o2) {
                        Tank ob1 = (Tank) (o1);
                        Tank ob2 = (Tank) (o2);
                        int       ret = ob1.getScore()<ob2.getScore()
                                        ? -1
                                        : 1;

                        return ret;
                }
            });
        }

        while (it.hasNext()) {
            set.add(it.next());
        }

        return set;
    }


}
