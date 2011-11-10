
package com.infotec.swb.resources;

/**
 *
 * @author carlos.ramos
 */
public enum MonthOfYear {
    enero("Enero"),
    febrero("Febrero"),
    marzo("Marzo"),
    abril("Abril"),
    mayo("Mayo"),
    junio("Junio"),
    julio("Julio"),
    agosto("Agosto"),
    septiembre("Septiembre"),
    octubre("Octubre"),
    noviembre("Noviembre"),
    diciembre("Diciembre");
    private String description;

    MonthOfYear(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return this.description;
    }

    public MonthOfYear previus()
    {
        switch (this)
        {
            case enero:
                return enero;
            case febrero:
                return enero;
            case marzo:
                return febrero;
            case abril:
                return marzo;
            case mayo:
                return abril;
            case junio:
                return mayo;
            case julio:
                return junio;
            case agosto:
                return julio;
            case septiembre:
                return agosto;
            case octubre:
                return septiembre;
            case noviembre:
                return octubre;
            case diciembre:
                return noviembre;
            default:
                return null;
        }
    }

    public MonthOfYear next()
    {
        switch (this)
        {
            case enero:
                return febrero;
            case febrero:
                return marzo;
            case marzo:
                return abril;
            case abril:
                return mayo;
            case mayo:
                return junio;
            case junio:
                return julio;
            case julio:
                return agosto;
            case agosto:
                return septiembre;
            case septiembre:
                return octubre;
            case octubre:
                return noviembre;
            case noviembre:
                return diciembre;
            case diciembre:
                return diciembre;
            default:
                return null;
        }
    }

    public boolean hasNext()
    {
        switch (this)
        {
            case diciembre:
                return false;
            default:
                return true;
        }
    }

    public static MonthOfYear valueOf(int value) throws IllegalArgumentException
    {
        switch (value)
        {
            case 0:
                return enero;
            case 1:
                return febrero;
            case 2:
                return marzo;
            case 3:
                return abril;
            case 4:
                return mayo;
            case 5:
                return junio;
            case 6:
                return julio;
            case 7:
                return agosto;
            case 8:
                return septiembre;
            case 9:
                return octubre;
            case 10:
                return noviembre;
            case 11:
                return diciembre;
            default:
                return null;
        }
    }
}
