/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;
import javaQuery.j2ee.tinyURL;
import javax.servlet.http.HttpServletRequest;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.SWBAppObject;
import org.semanticwb.social.Country;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.ModelProperty;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.UserGroupRef;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.social.CountryState;
import org.semanticwb.social.Message;
import org.semanticwb.social.MessageIn;
import org.semanticwb.social.Messageable;
import org.semanticwb.social.Photo;
import org.semanticwb.social.Photoable;
import org.semanticwb.social.PostIn;
import org.semanticwb.social.PostMonitor;
import org.semanticwb.social.PostOut;
import org.semanticwb.social.PostOutNet;
import org.semanticwb.social.Prepositions;
import org.semanticwb.social.PunctuationSign;
import org.semanticwb.social.SentimentWords;
import org.semanticwb.social.SentimentalLearningPhrase;
import org.semanticwb.social.SocialAdmin;
import org.semanticwb.social.SocialMonitorable;
import org.semanticwb.social.SocialNetwork;
import org.semanticwb.social.SocialPFlow;
import org.semanticwb.social.SocialSite;
import org.semanticwb.social.Stream;
import org.semanticwb.social.Video;
import org.semanticwb.social.Videoable;
import org.semanticwb.social.util.lucene.SpanishAnalizer;

/**
 *
 * @author jorge.jimenez
 */

/*
 * Clase de tipo utilerías 
 */
public class SWBSocialUtil implements SWBAppObject {

    /**
     * Holds a reference to a log utility. <p>Mantiene una referencia a la
     * utiler&iacute;a de generaci&oacute;n de bit&aacute;coras.</p>
     */
    private static Logger log = SWBUtils.getLogger(SWBSocialUtil.class);
    /**
     * Holds a reference to an object of this class. <p>Mantiene una referencia
     * a un objeto de esta clase.</p>
     */
    static private SWBSocialUtil instance;
    static ArrayList<String> aDoubles = new ArrayList();
    static HashMap<String, String> hmapChanges = new HashMap();
    //SENTIMENTAL STATATIC CONTANTS
    static public int SENTIMENT_NEUTRAL = 0;
    static public int SENTIMENT_POSITIVE = 1;
    static public int SENTIMENT_NEGATIVE = 2;
    //INTENSITIVE STATATIC CONTANTS
    static public int INTENSITIVE_HIGH = 2;
    static public int INTENSITIVE_MEDIUM = 1;
    static public int INTENSITIVE_LOW = 0;
    static public String MESSAGE="message";
    static public String PHOTO="photo";
    static public String VIDEO="video";
    static public final String CLASSIFYSENTMGS_PROPNAME="classifySentMgs";
    static public double EART_RADIUS_KM = 6371.01;   //Kilometros
    static public double EART_RADIUS_MI = 3958.762079; //Millas
    
    
    //private static Properties prop = new Properties();

    /**
     * Creates a new object of this class.
     */
    public SWBSocialUtil() {
        System.out.println("Entra a SWBSocialUtil/createInstance");
        //createInstance();
        init();
    }

    /**
     * Retrieves a reference to the only one existing object of this class.
     * <p>Obtiene una referencia al &uacute;nico objeto existente de esta
     * clase.</p>
     *
     * @param applicationPath a string representing the path for this
     * application
     * @return a reference to the only one existing object of this class
     */
    /*
    static public synchronized SWBSocialUtil createInstance() {
        //System.out.println("Entra a SWBSocialUtil/createInstance");
        if (instance == null) {
            instance = new SWBSocialUtil();
        }
        return instance;
    }*/
    
    
    public ArrayList getDoublesArray() {
        return aDoubles;
    }

    /*
     * Metodo que regresa phonemas
     */
    public HashMap getChangesMap() {
        return hmapChanges;
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void init() {
        System.out.println("Init de SWBSocialUtil-Jorge");
        //Carga Valores a ArrayList
        aDoubles.add("b");
        aDoubles.add("p");
        aDoubles.add("q");
        aDoubles.add("s");
        aDoubles.add("c");
        aDoubles.add("g");
        aDoubles.add("n");
        aDoubles.add("m");
        aDoubles.add("l");
        aDoubles.add("p");
        aDoubles.add("t");
        aDoubles.add("f");
        aDoubles.add("d");


        //Carga valores a HashMap
        hmapChanges.put("nge", "nje");
        hmapChanges.put("ngi", "nji");
        hmapChanges.put("ch", "ch");
        hmapChanges.put("cc", "ks");
        hmapChanges.put("ci", "si");
        hmapChanges.put("qu", "k");
        hmapChanges.put("w", "gu");
        hmapChanges.put("nn", "n");
        hmapChanges.put("mm", "m");
        hmapChanges.put("ll", "y");
        hmapChanges.put("pp", "p");
        hmapChanges.put("ce", "se");
        hmapChanges.put("q", "k");
        hmapChanges.put("ss", "s");
        hmapChanges.put("ge", "je");
        hmapChanges.put("tt", "t");
        hmapChanges.put("ff", "f");
        hmapChanges.put("v", "b");
        hmapChanges.put("x", "ks");
        hmapChanges.put("z", "s");
        hmapChanges.put("dd", "d");
        hmapChanges.put("gi", "ji");
        hmapChanges.put("bb", "b");
        hmapChanges.put("c", "k");
        
    }

    public static class Strings {

        /**
         * Lee una string y devuelve las palabras que se encuentren dentro.
         *
         * @param text Texto a procesar
         * @return Listado de palabras procesadas
         */
        public static ArrayList<String> stripWordsByLine(String text) {
            StringTokenizer st = new StringTokenizer(text);
            ArrayList<String> words = new ArrayList<String>();
            while (st.hasMoreTokens()) {
                String temp = st.nextToken();
                String word = temp.replaceAll("\\W+", "");
                words.add(word);
            }
            return words;
        }

        /*
         * Elimina signos de puntualcion
         */
        public static String removePuntualSigns(String text, SWBModel model) {
            Iterator<PunctuationSign> itPunctuationSigns = PunctuationSign.ClassMgr.listPunctuationSigns(model);
            while (itPunctuationSigns.hasNext()) {
                PunctuationSign puncSign = itPunctuationSigns.next();
                text = text.replaceAll(puncSign.getPuntuationSign(), "");
            }
            return text;
        }

        /**
         * Lee una string caracter por caracter y si encuentra que existen en el
         * mismo mas de un caracter en mayusculas, entonces lo considera como
         * una palabra (String) intensa y regresa true, de lo contrario regresa
         * false
         *
         * @param word Palabra a procesar, Limitnumber es el limite para
         * considerar una palabra intensa
         * @return True si tiene la palabra mas mayusculas que el número que
         * llega en el parametro Limitnumber o false de lo contrario
         */
        public static boolean isIntensiveWordByUpperCase(String word, int limitNumber) {
            int cont = 0;
            int l = word.length();
            for (int x = 0; x < l; x++) {
                char chr = word.charAt(x);
                if (chr >= 'A' && chr <= 'Z') {
                    cont++;
                    if (cont >= limitNumber) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Replaces accented characters and blank spaces in the string given.
         * Makes the changes in a case sensitive manner, the following are some
         * examples of the changes this method makes: <br>
         *
         * @param txt a string in which the characters are going to be replaced
         * @param replaceSpaces a {@code boolean} indicating if blank spaces are
         * going to be replaced or not
         * @param ch a {@code char} especifica algún caracter de puntuación
         * permitido
         * @return a string similar to {@code txt} but with neither accented or
         * special characters nor symbols in it. un objeto string similar a
         * {@code txt} pero sin caracteres acentuados o especiales y sin
         * s&iacute;mbolos {@literal Á} is replaced by {@literal A} <br>
         * {@literal Ê} is replaced by {@literal E} <br> {@literal Ï} is
         * replaced by {@literal I} <br> {@literal â} is replaced by
         * {@literal a} <br> {@literal ç} is replaced by {@literal c} <br> and
         * blank spaces are replaced by underscore characters, any symbol in
         * {@code txt} other than underscore is eliminated. <p>Reemplaza
         * caracteres acentuados y espacios en blanco en {@code txt}. Realiza
         * los cambios respetando caracteres en may&uacute;sculas o
         * min&uacute;sculas los caracteres en blanco son reemplazados por
         * guiones bajos, cualquier s&iacute;mbolo diferente a gui&oacute;n bajo
         * es eliminado.</p>
         */
        public static String replaceSpecialCharacters(String txt) {
            StringBuilder ret = new StringBuilder();
            String aux = txt;
            //aux = aux.toLowerCase();
            aux = aux.replace('Á', 'A');
            aux = aux.replace('Ä', 'A');
            aux = aux.replace('Å', 'A');
            aux = aux.replace('Â', 'A');
            aux = aux.replace('À', 'A');
            aux = aux.replace('Ã', 'A');

            aux = aux.replace('É', 'E');
            aux = aux.replace('Ê', 'E');
            aux = aux.replace('È', 'E');
            aux = aux.replace('Ë', 'E');

            aux = aux.replace('Í', 'I');
            aux = aux.replace('Î', 'I');
            aux = aux.replace('Ï', 'I');
            aux = aux.replace('Ì', 'I');

            aux = aux.replace('Ó', 'O');
            aux = aux.replace('Ö', 'O');
            aux = aux.replace('Ô', 'O');
            aux = aux.replace('Ò', 'O');
            aux = aux.replace('Õ', 'O');

            aux = aux.replace('Ú', 'U');
            aux = aux.replace('Ü', 'U');
            aux = aux.replace('Û', 'U');
            aux = aux.replace('Ù', 'U');

            //aux = aux.replace('Ñ', 'N');


            aux = aux.replace('Ç', 'C');
            aux = aux.replace('Ý', 'Y');

            aux = aux.replace('á', 'a');
            aux = aux.replace('à', 'a');
            aux = aux.replace('ã', 'a');
            aux = aux.replace('â', 'a');
            aux = aux.replace('ä', 'a');
            aux = aux.replace('å', 'a');

            aux = aux.replace('é', 'e');
            aux = aux.replace('è', 'e');
            aux = aux.replace('ê', 'e');
            aux = aux.replace('ë', 'e');

            aux = aux.replace('í', 'i');
            aux = aux.replace('ì', 'i');
            aux = aux.replace('î', 'i');
            aux = aux.replace('ï', 'i');

            aux = aux.replace('ó', 'o');
            aux = aux.replace('ò', 'o');
            aux = aux.replace('ô', 'o');
            aux = aux.replace('ö', 'o');
            aux = aux.replace('õ', 'o');

            aux = aux.replace('ú', 'u');
            aux = aux.replace('ù', 'u');
            aux = aux.replace('ü', 'u');
            aux = aux.replace('û', 'u');

            //aux = aux.replace('ñ', 'n');

            aux = aux.replace('ç', 'c');
            aux = aux.replace('ÿ', 'y');
            aux = aux.replace('ý', 'y');

            int l = aux.length();
            for (int x = 0; x < l; x++) {
                char chr = aux.charAt(x);
                if (chr == ' ' || (chr >= '0' && chr <= '9') || (chr >= 'a' && chr <= 'z')
                        || (chr >= 'A' && chr <= 'Z') || chr == '_') {
                    ret.append(chr);
                }
            }
            aux = ret.toString();
            return aux;
        }
    }
    /*
    public static class words2Monitor {

        
        public static String[] getCompanyWords(SWBModel model) {
            String words = null;
            String[] awords = null;
            Iterator<WordsToMonitor> itWords2Monitor = WordsToMonitor.ClassMgr.listWordsToMonitors(model);
            while (itWords2Monitor.hasNext()) {
                WordsToMonitor words2monitor = itWords2Monitor.next();
                String wordsTmp = words2monitor.getCompany();
                if (wordsTmp != null) {
                    if (words == null) {
                        words = wordsTmp;
                    } else {
                        words += wordsTmp;
                    }
                }
            }
            if (words != null) {
                awords = words.split("\\;");
            }
            return awords;
        }

        
        public static String[] getCompetitionWords(SWBModel model) {
            String words = null;
            String[] awords = null;
            Iterator<WordsToMonitor> itWords2Monitor = WordsToMonitor.ClassMgr.listWordsToMonitors(model);
            while (itWords2Monitor.hasNext()) {
                WordsToMonitor words2monitor = itWords2Monitor.next();
                String wordsTmp = words2monitor.getCompetition();
                if (wordsTmp != null) {
                    if (words == null) {
                        words = wordsTmp;
                    } else {
                        words += wordsTmp;
                    }
                }
            }
            if (words != null) {
                awords = words.split("\\;");
            }
            return awords;
        }

       
        public static String[] getProductAndServicesWords(SWBModel model) {
            String words = null;
            String[] awords = null;
            Iterator<WordsToMonitor> itWords2Monitor = WordsToMonitor.ClassMgr.listWordsToMonitors(model);
            while (itWords2Monitor.hasNext()) {
                WordsToMonitor words2monitor = itWords2Monitor.next();
                String wordsTmp = words2monitor.getProductsAndServices();
                if (wordsTmp != null) {
                    if (words == null) {
                        words = wordsTmp;
                    } else {
                        words += wordsTmp;
                    }
                }
            }
            if (words != null) {
                awords = words.split("\\;");
            }
            return awords;
        }

       
        public static String[] getOtherWords(SWBModel model) {
            String words = null;
            String[] awords = null;
            Iterator<WordsToMonitor> itWords2Monitor = WordsToMonitor.ClassMgr.listWordsToMonitors(model);
            while (itWords2Monitor.hasNext()) {
                WordsToMonitor words2monitor = itWords2Monitor.next();
                String wordsTmp = words2monitor.getOtherWords();
                if (wordsTmp != null) {
                    if (words == null) {
                        words = wordsTmp;
                    } else {
                        words += wordsTmp;
                    }
                }
            }
            if (words != null) {
                awords = words.split("\\;");
            }
            return awords;
        }

        
        public static String getWords2Monitor(String delimiter, SWBModel model) {
            //Palabras acerca de la compañia
            String words2monitor = "";
            String[] companyWords = getCompanyWords(model);
            if (companyWords != null) {
                for (int i = 0; i < companyWords.length; i++) {
                    System.out.println("companyWord[" + i + "]:" + companyWords[i]);
                    if (words2monitor.length() == 0) {
                        words2monitor = companyWords[i];
                    } else {
                        words2monitor += delimiter + companyWords[i];
                    }
                }
            }
            //Palabras acerca de la competencia
            String[] competitionWords = getCompetitionWords(model);
            if (competitionWords != null) {
                for (int i = 0; i < competitionWords.length; i++) {
                    System.out.println("competitionWords[" + i + "]:" + competitionWords[i]);
                    if (words2monitor.length() == 0) {
                        words2monitor = competitionWords[i];
                    } else {
                        words2monitor += delimiter + competitionWords[i];
                    }
                }
            }
            //Palabras acerca de productos y servicios
            String[] pAndServWords = getProductAndServicesWords(model);
            if (pAndServWords != null) {
                for (int i = 0; i < pAndServWords.length; i++) {
                    System.out.println("pAndServWords[" + i + "]:" + pAndServWords[i]);
                    if (words2monitor.length() == 0) {
                        words2monitor = pAndServWords[i];
                    } else {
                        words2monitor += delimiter + pAndServWords[i];
                    }
                }
            }
            //Palabras acerca de productos y servicios
            String[] otherWords = getOtherWords(model);
            if (otherWords != null) {
                for (int i = 0; i < otherWords.length; i++) {
                    System.out.println("otherWords[" + i + "]:" + otherWords[i]);
                    if (words2monitor.length() == 0) {
                        words2monitor = otherWords[i];
                    } else {
                        words2monitor += delimiter + otherWords[i];
                    }
                }
            }
            return words2monitor;
        }
    }
    * */

    /*
     * Metodo que normaliza una palabra, esto de acuerdo a definición realizada internamente en el área
     */
    public static class Classifier {
        
        
        public static HashMap classifyText(String text)
        {
            float sentimentalTweetValue;
            float IntensiveTweetValue;
            int wordsCont=0;
            //Normalizo
            //System.out.println("ANALISIS-0:"+externalString2Clasify);
            //String text_tmp=text;
            text=SWBSocialUtil.Classifier.normalizer(text).getNormalizedPhrase();

            //System.out.println("ANALISIS-1:"+externalString2Clasify);
            //Se cambia toda la frase a su modo raiz
            text=SWBSocialUtil.Classifier.getRootWord(text);

            //System.out.println("ANALISIS-2:"+externalString2Clasify);

            //Fonetizo
            text=SWBSocialUtil.Classifier.phonematize(text);

            //System.out.println("ANALISIS-3:"+externalString2Clasify);

            //Busco frases en objeto de aprendizaje (SentimentalLearningPhrase)

            HashMap hmapValues=findInLearnigPhrases(text);
            sentimentalTweetValue=((Float)hmapValues.get("sentimentalTweetValue")).floatValue();
            IntensiveTweetValue=((Float)hmapValues.get("IntensiveTweetValue")).floatValue();
            wordsCont=((Integer)hmapValues.get("wordsCont")).intValue();
            text=((String)hmapValues.get("text"));
            
            
            //System.out.println("ANALISIS-4:sentimentalTweetValue:"+sentimentalTweetValue+", IntensiveTweetValue:+"+IntensiveTweetValue+", wordsCont:"+wordsCont);

            //Elimino Caracteres especiales (acentuados)
            text=SWBSocialUtil.Strings.replaceSpecialCharacters(text);

            SocialAdmin socialAdminSite=(SocialAdmin)SWBContext.getAdminWebSite();

            text=SWBSocialUtil.Strings.removePuntualSigns(text, socialAdminSite);

            //System.out.println("ANALISIS-5:sentimentalTweetValue:"+externalString2Clasify);

            ArrayList<String> aListWords=new ArrayList();
            StringTokenizer st = new StringTokenizer(text);
            while (st.hasMoreTokens())
            {
                String word2Find=st.nextToken();
                //System.out.println("Palabra monitorear:"+word2Find);

                if(Prepositions.ClassMgr.getPrepositions(word2Find, socialAdminSite)!=null) //Elimino preposiciones
                {
                    continue;
                }

                String word2FindTmp=word2Find;
                //System.out.println("word2Find:"+word2Find);
                NormalizerCharDuplicate normalizerCharDuplicate=SWBSocialUtil.Classifier.normalizer(word2Find);
                word2Find=normalizerCharDuplicate.getNormalizedPhrase();
                aListWords.add(word2Find);
                //System.out.println("word Normalizada:"+word2Find);
                //Aplicar snowball a la palabra
                //word2Find=SWBSocialUtil.Classifier.getRootWord(word2Find);
                //Se fonematiza la palabra
                //word2Find=SWBSocialUtil.Classifier.phonematize(word2Find);
                System.out.println("word Fonematizada:"+word2Find);
                //SentimentWords sentimentalWordObj=SentimentWords.getSentimentalWordByWord(model, word2Find);
                SentimentWords sentimentalWordObj=SentimentWords.ClassMgr.getSentimentWords(word2Find, socialAdminSite);
                if(sentimentalWordObj!=null) //La palabra en cuestion ha sido encontrada en la BD
                {
                    System.out.println("Palabra Encontrada:"+word2Find);
                    wordsCont++;
                    IntensiveTweetValue+=sentimentalWordObj.getIntensityValue();
                    //Veo si la palabra cuenta con mas de dos caracteres(Normalmente el inicial de la palabra y talvez otro que
                    //hayan escrito por equivocación) en mayusculas
                    //De ser así, se incrementaría el valor para la intensidad

                    if(SWBSocialUtil.Strings.isIntensiveWordByUpperCase(word2FindTmp, 3))
                    {
                        //System.out.println("VENIA PALABRA CON MAYUSCULAS:"+word2Find);
                        IntensiveTweetValue+=1;
                    }
                    //Veo si en la palabra se repiten mas de 2 caracteres para los que se pueden repetir hasta 2 veces (Arrar Doubles)
                    // y mas de 1 cuando no estan dichos caracteres en docho array, si es así entonces se incrementa la intensidad

                    if(normalizerCharDuplicate.isCharDuplicate()){
                        //System.out.println("VENIA PALABRA CON CARACTERES REPETIDOS:"+word2Find);
                        IntensiveTweetValue+=1;
                    }
                    sentimentalTweetValue+=sentimentalWordObj.getSentimentalValue();
                }
            }
            
            ////
            float promSentimentalValue=0; 
            int sentimentalTweetValueType=0;    //Por defecto sería neutro
            if(sentimentalTweetValue>0) //Se revisa de acuerdo al promedio de sentimentalTweetValue/wordsCont, que valor sentimental posee el tweet
            {
                promSentimentalValue=sentimentalTweetValue/wordsCont;
                //post.setPostSentimentalValue(prom);
                //System.out.println("prom final:"+prom);
                if(promSentimentalValue>=4.5) //Si el promedio es mayor de 4.5 (Segun Octavio) es un tweet positivo
                {
                    sentimentalTweetValueType=1;
                }else if(promSentimentalValue<4.5)
                {
                    //System.out.println("Se guarda Post Negativo:"+post.getId()+", valor promedio:"+prom);
                    //post.setPostSentimentalType(2); //Tweet Negativo, valor de 1 (Esto yo lo determiné)
                    sentimentalTweetValueType=2;
                }
            }
            ////
            int intensityTweetValueType=0;    //Por defecto sería un tweet con intensidad baja.
            float promIntensityValue=0; 
            if(IntensiveTweetValue>0)
            {
                promIntensityValue=IntensiveTweetValue/wordsCont;
                if(promIntensityValue>=5.44) //Si el promedio es mayor de 5.44 sería un tweet con intesidad alta, ya que la maxima en intensidad es de 8.16
                {
                    intensityTweetValueType=2;
                }else if(promIntensityValue<5.44 && promIntensityValue>=2.72) //tweet con intensidad media
                {
                    intensityTweetValueType=1;
                }
            }
            
            ////
            
            HashMap hmapValuesReturn=new HashMap();
            hmapValuesReturn.put("promSentimentalValue", promSentimentalValue);
            hmapValuesReturn.put("sentimentalTweetValueType", sentimentalTweetValueType);
            hmapValuesReturn.put("promIntensityValue", promIntensityValue);
            hmapValuesReturn.put("intensityTweetValueType", intensityTweetValueType);
            
            return hmapValuesReturn;
        }
        
        /*
        *Función que barre todas las frases y las busca en el mensaje (PostData)
        *Esto talvez pueda NO pueda ser lo mas optimo.
        *TODO:Ver si encuentra otra forma más optima de hacer esto.
        *
        */
       private static HashMap findInLearnigPhrases(String text)
       {
           //
           float sentimentalTweetValue;
           float IntensiveTweetValue;
           int wordsCont=0;
           //
           int contPositive=0;
           int contNegative=0;
           int result=0;   //Mi inicio sera 0(Neutro) y de ahi se va ha tender a la derecha (positivos) o a la izquierda (Negativos)
           int positiveintensityveResult=0;
           int negativeintensityveResult=0;
           //HashMap sntPhrasesMap=new HashMap();
           Iterator<SentimentalLearningPhrase> itSntPhases=SentimentalLearningPhrase.ClassMgr.listSentimentalLearningPhrases(SWBContext.getAdminWebSite());
           while(itSntPhases.hasNext())
           {
               SentimentalLearningPhrase sntLPhrase=itSntPhases.next();
               System.out.println("Frase Learn:"+sntLPhrase.getPhrase());
               HashMap hmap=new HashMap();
               hmap.put("text", text);
               hmap.put("contOcurr", 0);
               
               hmap=findOccurrencesNumber(sntLPhrase.getPhrase(), hmap);
               text=(String)hmap.get("text");
               int contOcurr=((Integer)hmap.get("contOcurr")).intValue();
               //int contOcurr=findOccurrencesNumber(text, sntLPhrase.getPhrase(), 0);
               System.out.println("sntLPhrase:"+sntLPhrase.getPhrase()+",contOcurrJorge:"+contOcurr+", text:"+text);
               if(contOcurr>0)
               {
                   if(sntLPhrase.getSentimentType()==1) //la frase es positiva
                   {
                       contPositive+=contOcurr;
                       result+=contOcurr;
                       if(sntLPhrase.getIntensityType()==2) //Es intensidad Alta
                       {
                           positiveintensityveResult+=8;   //Yo internamente le doy un 3 como valor (Este yo se lo pongo)
                       }else if(sntLPhrase.getIntensityType()==1) //Es intensidad Media
                       {
                           positiveintensityveResult+=5;   //Yo internamente le doy un 2 como valor (Este yo se lo pongo)
                       }else if(sntLPhrase.getIntensityType()==0) //Es intensidad Baja
                       {
                           positiveintensityveResult+=2;   //Yo internamente le doy un 1 como valor (Este yo se lo pongo)
                       }
                   }else if(sntLPhrase.getSentimentType()==2){ //la frase es Negativa
                       contNegative+=contOcurr;
                       result-=contOcurr;
                       if(sntLPhrase.getIntensityType()==2) //Es intensidad Alta
                       {
                           negativeintensityveResult+=8;   //Yo internamente le doy un 3 como valor (Este yo se lo pongo)
                       }else if(sntLPhrase.getIntensityType()==1) //Es intensidad Media
                       {
                           negativeintensityveResult+=5;   //Yo internamente le doy un 2 como valor (Este yo se lo pongo)
                       }else if(sntLPhrase.getIntensityType()==0) //Es intensidad Baja
                       {
                           negativeintensityveResult+=2;   //Yo internamente le doy un 1 como valor (Este yo se lo pongo)
                       }
                   }
               }
           }
           //System.out.println("result k:"+result);
           //Reglas
           if(result>0)    //Es positivo
           {
               sentimentalTweetValue=7*contPositive;   //El 7 yo lo propongo dado que la númeración va de 0-9 considero que un 7 es la media para los positivos
               IntensiveTweetValue=positiveintensityveResult/contPositive;
               wordsCont=contPositive;
           }else if(result<0){ //Es Negativo
               sentimentalTweetValue=3*contNegative; //El 3 yo lo propongo dado que la númeración va de 0-9 considero que un 3 es la media para los Negativos
               IntensiveTweetValue=negativeintensityveResult/contNegative;
               wordsCont=contNegative;
           }else{ //Es Neutro
               sentimentalTweetValue=0;
               IntensiveTweetValue=0;
               wordsCont=0;
           }

           HashMap mapValues=new HashMap();
           mapValues.put("sentimentalTweetValue", sentimentalTweetValue);
           mapValues.put("IntensiveTweetValue", IntensiveTweetValue);
           mapValues.put("wordsCont", wordsCont);
           mapValues.put("text", text);
           
           return mapValues;
       }

       /*
        * Función que encuentra el número de ocurrencias en una frase
        */
       private static HashMap findOccurrencesNumber(String phrase, HashMap hmap)
       {
           String text=(String)hmap.get("text");
           int contOcurrences=((Integer)hmap.get("contOcurr")).intValue();
           int iocurrence=text.indexOf(phrase);
           if(iocurrence>-1)
           {
               contOcurrences++;
               text=text.substring(0, iocurrence)+text.substring(iocurrence+phrase.length());
               //System.out.println("phrase:"+phrase+",Ocurrencia:"+contOcurrences+",externalString2Clasify:"+externalString2Clasify);
               hmap=new HashMap();
               hmap.put("text", text);
               hmap.put("contOcurr", contOcurrences);
               hmap=findOccurrencesNumber(phrase, hmap);
           }
           
           return hmap;
       }
        
        
        public static String[] getSpanishStopWords()
        {
            String[] stopWords=new SpanishAnalizer().getSpanishStopWords();
            
            //stopWords[stopWords.length+1]="quien";
            
            return stopWords;
        }

        public static NormalizerCharDuplicate normalizer(String in_word) {
            boolean isCharDuplicate = false;
            String tmp = "";
            char[] in_wordArray = in_word.toCharArray();
            for (int i = 0; i < in_wordArray.length; i++) {
                String in_wordChar = String.valueOf(in_wordArray[i]);
                if (tmp.length() > 1) {
                    if (aDoubles.contains(in_wordChar)) {
                        if (tmp.substring(tmp.length() - 2, tmp.length() - 1).equalsIgnoreCase(tmp.substring(tmp.length() - 1)) && (tmp.substring(tmp.length() - 1).equalsIgnoreCase(in_wordChar))) {
                            isCharDuplicate = true;
                            continue;
                        } else {
                            tmp += in_wordChar;
                        }
                    } else {
                        if (tmp.substring(tmp.length() - 1).equalsIgnoreCase(in_wordChar)) {
                            isCharDuplicate = true;
                            continue;
                        } else {
                            tmp += in_wordChar;
                        }
                    }
                } else {
                    tmp += in_wordChar;
                }
            }

            //If que Revisa si los primeros 2 caracteres son iguales, si es así, elimina el Primero.
            if (tmp.length() > 2 && tmp.substring(0, 1).equalsIgnoreCase(tmp.substring(1, 2))) {
                isCharDuplicate = true;
                tmp = tmp.substring(1);
            }
            //If que Revisa si los ultimos 2 caracteres son iguales, si es así, elimina el último.
            if (tmp.length() > 2 && tmp.substring(tmp.length() - 2, tmp.length() - 1).equalsIgnoreCase(tmp.substring(tmp.length() - 1))) {
                isCharDuplicate = true;
                tmp = tmp.substring(0, tmp.length() - 1);
            }

            return new NormalizerCharDuplicate(tmp, isCharDuplicate);

        }

        /*
         * Metodo que regresa el fonema de una palabra, esto de acuerdo a definición
         * realizada internamente en el área.
         */
        public static String phonematize(String phase) {
            if (phase == null || phase.isEmpty()) {
                return phase;
            }
            String tmp = "";
            String out_word = "";
            phase = phase.toLowerCase();

            char[] in_wordArray = phase.toCharArray();
            for (int i = 0; i < in_wordArray.length; i++) {
                String in_wordChar = String.valueOf(in_wordArray[i]);
                if (aDoubles.contains(in_wordChar)) {
                    tmp += in_wordChar;
                    continue;
                } else if (tmp.trim().length() > 0) //Busca sonidos que se representan graficamente con dos caracteres
                {
                    if (hmapChanges.containsKey(tmp + in_wordChar)) {
                        out_word += hmapChanges.get(tmp + in_wordChar);
                        tmp = "";
                        continue;
                    } else if (hmapChanges.containsKey(tmp)) {
                        out_word += hmapChanges.get(tmp) + in_wordChar;
                        tmp = "";
                        continue;
                    }
                    if (hmapChanges.containsKey(in_wordChar)) {
                        if (aDoubles.contains(hmapChanges.get(in_wordChar))) {
                            tmp += hmapChanges.get(in_wordChar);
                            continue;
                        }
                    } else {
                        out_word += tmp + in_wordChar;
                        tmp = "";
                        continue;
                    }
                } else { //Mapea los caracteres con su sonido correspondiente
                    if (hmapChanges.containsKey(in_wordChar)) {
                        if (aDoubles.contains(hmapChanges.get(in_wordChar))) {
                            tmp += hmapChanges.get(in_wordChar);
                            continue;
                        } else {
                            out_word += hmapChanges.get(in_wordChar);
                            tmp = "";
                            continue;
                        }
                    } else if (in_wordChar.equalsIgnoreCase("h")) {  //Elimina la h
                        continue;
                    }
                    out_word += in_wordChar;
                    tmp = "";
                    continue;
                }
            }
            if (tmp.length() > 0) {
                out_word += tmp;
                tmp = "";
            }

            return out_word;
        }

        /*
         public static String getRootWord(String word)
         {
         try
         {
         TokenStream tokenStream = new SpanishAnalizer().tokenStream("word", new StringReader(word));
         //OffsetAttribute offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);
         CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
         while (tokenStream.incrementToken()) {
         String term = charTermAttribute.toString();
         if(term!=null) return term;
         else return word;
         }
         }catch(Exception e){
         log.error(e);
         }
         return word;
         }*/

        /*
         * Metodo que regrasa la raíz de una palabra
         */
        public static String getRootWord(String phrase) {
            String sphrase = "";
            try {
                TokenStream tokenStream = new SpanishAnalizer().tokenStream("word", new StringReader(phrase));
                //OffsetAttribute offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);
                CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
                while (tokenStream.incrementToken()) {
                    String term = charTermAttribute.toString();
                    if (term != null && sphrase.trim().length() > 0) {
                        sphrase += " " + term;
                    } else if (term != null) {
                        sphrase = term;
                    }
                }
            } catch (Exception e) {
                log.error(e);
            }
            if (sphrase.trim().length() > 0) {
                return sphrase;
            } else {
                return phrase;
            }
        }
        
        
        public static String getRootPhrase(String phrase) {
            String sphrase = "";
            try {
                TokenStream tokenStream = new SpanishAnalizer().tokenStreamWOStopWords("word", new StringReader(phrase));
                //OffsetAttribute offsetAttribute = tokenStream.addAttribute(OffsetAttribute.class);
                CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
                while (tokenStream.incrementToken()) {
                    String term = charTermAttribute.toString();
                    if (term != null && sphrase.trim().length() > 0) {
                        sphrase += " " + term;
                    } else if (term != null) {
                        sphrase = term;
                    }
                }
            } catch (Exception e) {
                log.error(e);
            }
            if (sphrase.trim().length() > 0) {
                return sphrase;
            } else {
                return phrase;
            }
        }
        
    }
    
    public static class SocialTopic
    {
        public static ArrayList<User> getUsersbySocialTopic(org.semanticwb.social.SocialTopic socialTopic)
        {
            ArrayList<User> aListUsers=new ArrayList();
            Iterator <UserGroupRef> itUserGrpRef=socialTopic.listUserGroupRefs();
            while(itUserGrpRef.hasNext())
            {
                UserGroupRef userGrpRef=itUserGrpRef.next();
                Iterator<GenericObject> itGenObjs=userGrpRef.getUserGroup().listRelatedObjects();
                while(itGenObjs.hasNext())
                {
                    GenericObject genObj=itGenObjs.next();
                    if(genObj instanceof User)
                    {
                        aListUsers.add((User)genObj);
                    }
                }
            }
            return aListUsers;
        }
    }
    
    
    public static class Util {
        
        /**
         * Metodo que elimina las preposiciones encontradas en un String
         * @param text String en el que se buscaran y eliminaran preposiciones
         * @return String sin preposiciones
         */
        public static String removePrepositions(String text)
        {
            boolean firstTime=true;
            String text2Return="";
            StringTokenizer st = new StringTokenizer(text);
            while (st.hasMoreTokens())
            {
                String word2Find=st.nextToken();
                if(Prepositions.ClassMgr.getPrepositions(word2Find, SWBContext.getAdminWebSite())!=null) //Elimino preposiciones
                {
                    continue;
                }
                if(firstTime)
                {
                    text2Return+=word2Find;
                    firstTime=false;
                }else{
                    text2Return+=" "+word2Find;
                }
            }
            return text2Return;
        }
        
        
        /**
	 * Descarga un fichero jpeg y lo guarda en e:/foto.jpg
	 *
	 * @param args
	 */
	public static File downloadWebFile(String fileUrl, String localPath2save)
        {
            try {
                    // Url con la foto
                    //http://mas.lne.es/fotos/img/2007/10/62/203093470447035b9bc5a095.43783284-foto_verano.jpg
                    URL url = new URL(fileUrl);
                
                    // establecemos conexion
                    URLConnection urlCon = url.openConnection();

                    // Sacamos por pantalla el tipo de fichero
                    System.out.println(urlCon.getContentType());

                    // Se obtiene el inputStream de la foto web y se abre el fichero
                    // local.
                    InputStream is = urlCon.getInputStream();
                    File newLocalFile=new File(localPath2save);
                    
                    newLocalFile.createNewFile();
                    FileOutputStream fos = new FileOutputStream(newLocalFile, true);

                    // Lectura de la foto de la web y escritura en fichero local
                    byte[] array = new byte[1000]; // buffer temporal de lectura.
                    int leido = is.read(array);
                    while (leido > 0) {
                            fos.write(array, 0, leido);
                            leido = is.read(array);
                    }

                    // cierre de conexion y fichero.
                    is.close();
                    fos.close();
                    return newLocalFile;
                } catch (Exception e) {
                        e.printStackTrace();
                }
            return null;
        }
        
        
        
        public static boolean isPointInsideCoodinates(double latitude, double longitude, GeoLocation[] geolocation)
        {
            if(latitude==0 || longitude==0 || geolocation==null) return false;
            
            double south=geolocation[0].getLatitudeInDegrees();
            double west=geolocation[0].getLongitudeInDegrees();
            double north=geolocation[1].getLatitudeInDegrees();
            double east=geolocation[1].getLongitudeInDegrees();
            if(north>=latitude && south<=latitude && east>=longitude && west<=longitude)
            {
                return true;
            }
            return false;
        }
        
        
        public static void sendEmail2UserGroup(UserGroup userGroup, String body)
        {
            //TODO:Ver si se utiliza este metodo e implementarlo de ser el caso.
        }
        
        /*
         * Metodo que obtiene un estado de un país mediante los parametros recibidos
         * @param country país a buscar
         * @param latitude latitude a buscar en un país
         * @param longitude longitude a buscar en un país
         * @return CountryState Estado del país donde encontro las coordenadas
         * @return null si no encontró las coodenadas en ningún estato del país recibido
         */
        public static CountryState getMessageMapState(Country country, float latitude, float longitude)
        {
            if(country!=null && latitude!=0 && longitude!=0)
            {
                Iterator <CountryState> itCountryStates=country.listStatesInvs();
                while(itCountryStates.hasNext())
                {
                    CountryState countryState=itCountryStates.next();
                    //Si se cumple el siguiente if, el mensaje proviene del estado en cuestio.
                    if(countryState.getNorth()>=latitude && countryState.getSouth()<=latitude && 
                            countryState.getEast()>=longitude && countryState.getWest()<=longitude)
                    {
                        return countryState;
                    }
                }
            }
            return null; 
        }
        
        
        /*
         * Metodo que obtiene un país mediante los parametros recibidos
         * @param latitude latitude a buscar en la lista de paises
         * @param longitude longitude a buscar en la lista de paises
         * @return Country que cumple con las coordenadas recibidas
         * @return null si no encontró las coodenadas en ningún país del catálogo
         */
        public static Country getMessageMapCountry(float latitude, float longitude)
        {
            if(latitude!=0 && longitude!=0)
            {
                Iterator <Country> itCountries=Country.ClassMgr.listCountries(SWBContext.getAdminWebSite());
                while(itCountries.hasNext())
                {
                    Country country=itCountries.next();
                    //Si se cumple el siguiente if, el mensaje proviene del estado en cuestio.
                    if(country.getNorth()>=latitude && country.getSouth()<=latitude && 
                            country.getEast()>=longitude && country.getWest()<=longitude)
                    {
                        return country;
                    }
                }
            }
            return null; 
        }
        

        /**
         * Metodo que obtiene el valor de la propiedad que le llega como
         * parametro en un determinado modelo
         *
         * @param model
         * @param propertyID
         * @return
         */
        public static String getModelPropertyValue(SWBModel model, String propertyID) {
            Iterator<ModelProperty> itModelProps = model.listModelProperties();
            while (itModelProps.hasNext()) {
                ModelProperty modelProp = itModelProps.next();
                if (modelProp.getId().equals(propertyID)) {
                    return modelProp.getValue();
                }
            }
            return null;
        }

        //Diferencias entre dos fechas
        //@param fechaInicial La fecha de inicio
        //@param fechaFinal  La fecha de fin
        //@return Retorna el numero de dias entre dos fechas
        public static int Datediff(Date fechaInicial, Date fechaFinal) {

            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
            String fechaInicioString = df.format(fechaInicial);
            try {
                fechaInicial = df.parse(fechaInicioString);
            } catch (ParseException ex) {
            }

            String fechaFinalString = df.format(fechaFinal);
            try {
                fechaFinal = df.parse(fechaFinalString);
            } catch (ParseException ex) {
            }

            long fechaInicialMs = fechaInicial.getTime();
            long fechaFinalMs = fechaFinal.getTime();
            long diferencia = fechaFinalMs - fechaInicialMs;
            double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
            return ((int) dias);
        }

        /*
         * Renplaza tags de emails, documentar este tipo de tags que puede poner el usuario en los mensajes de 
         * correos.
         */
        public static String replaceTags(String message, PostIn postIn, SocialSite socialSite, Stream stream, SocialNetwork socialNetwork) 
        {
            try 
            {
                message = SWBUtils.TEXT.replaceAll(message, "{brand.title}", socialSite.getTitle());
                message = SWBUtils.TEXT.replaceAll(message, "{stream.title}", stream.getTitle());
                message = SWBUtils.TEXT.replaceAll(message, "{net.title}", socialNetwork.getTitle());
                if(postIn.getSocialTopic()!=null)
                {
                    message = SWBUtils.TEXT.replaceAll(message, "{postIn.topic}", postIn.getSocialTopic().getTitle());
                }
                if(postIn.getPostInSocialNetworkUser()!=null)
                {
                    message = SWBUtils.TEXT.replaceAll(message, "{postIn.user}", postIn.getPostInSocialNetworkUser().getSnu_name());
                    message = SWBUtils.TEXT.replaceAll(message, "{postIn.userklout}", ""+postIn.getPostInSocialNetworkUser().getSnu_klout()); 
                }

                message = SWBUtils.TEXT.replaceAll(message, "{post.message}", ((MessageIn) postIn).getMsg_Text());
            } catch (Exception e) {
                log.error(e);
            }

            return message;
        }
        
        /*
         * Regresa el string relacionado con la llave y el lenguaje pasados como parametros
         * TODO:Cargarlo solo una vez desde el metodo init de este singleton y mandar llamar con los parametros.
         */
        public static String getStringFromGenericLocale(String key, String lang)
        {
            String strLocale=SWBUtils.TEXT.getLocaleString("org.semanticwb.social.admin.resources.locales.generic", key,new Locale(lang));
            if(strLocale!=null)
            {
                try
                {
                    return SWBUtils.TEXT.encode(strLocale, "utf8");                    
                }catch(Exception e)
                {
                    return strLocale;
                }                
            }
            return null;
        }
        
        /**
         * Replaces full urls with shorten urls.
         * @param text with full urls
         * @return text with shorten urls
         */
        public static String shortUrl(String urlLong) {
            String parsedMessage = "";
            if (urlLong != null && !urlLong.isEmpty()) {
                String delimiter = " ";
                String[] temp = urlLong.split(delimiter);
                for (int i = 0; i < temp.length; i++) {
                    if ((temp[i].startsWith("http://") || temp[i].startsWith("https://")) && ((temp[i].length() > 9))) {
                        tinyURL tU = new tinyURL();
                        temp[i] = tU.getTinyURL(temp[i]);
                    }
                    parsedMessage += temp[i] + " ";
                }
            }
            return parsedMessage;
        }
        
    }

    public static class PostOutUtil
    {
        
        
        /*
         * Metodo con el que se crea un nuevo objeto de la clase PostOutNet, en el cual se agrega los ids creados 
         * en las diferentes redes sociales a los que se envia un postOut desde swbsocial, esto nos sirve para llevar
         * la trazabilidad de los mensajes enviados.
         */
        public static PostOutNet savePostOutNetID(PostOut postOut, SocialNetwork socialNet, String socialNetMsgId, String error)
        {
            System.out.println("Entra a savePostOutNetID-1");
            PostOutNet postOutNet=null;
            try
            {
                if(postOut==null || socialNet==null) return null;
                WebSite wsite=WebSite.ClassMgr.getWebSite(postOut.getSemanticObject().getModel().getName());
                System.out.println("Entra a savePostOutNetID-2:"+wsite);
                postOutNet=PostOutNet.ClassMgr.createPostOutNet(wsite);
                System.out.println("Entra a savePostOutNetID-3:"+postOutNet);
                postOutNet.setSocialPost(postOut);
                postOutNet.setSocialNetwork(socialNet);
                if(socialNetMsgId!=null)  {
                    postOutNet.setSocialNetMsgID(socialNetMsgId);
                }
                postOutNet.setPo_created(new Date());
                System.out.println("Entra a savePostOutNetID-4:"+postOutNet);
                //Si la red social es de tipo SocialMonitorable, se pone a monitorear el PostOutNet creado.
                if(socialNet instanceof SocialMonitorable)
                {
                    System.out.println("Entra a savePostOutNetID-5:"+socialNet);
                    SWBSocialUtil.PostOutUtil.savePostOutNetToMonitor(postOutNet);
                    System.out.println("Entra a savePostOutNetID-6:"+socialNet);
                }else if(socialNetMsgId!=null && error ==null){
                    postOutNet.setStatus(1);
                }else if(error!=null){
                    postOutNet.setStatus(0);
                    postOutNet.setError(error);
                }
            }catch(Exception e)
            {
                System.out.println(e.getMessage());
                log.error(e);
            }
            System.out.println("Entra a savePostOutNetID-7:"+postOutNet);
            return postOutNet;
        }
        
        
          /*
         * Metodo con el que se graba un PostOutNet para ser monitoreado a la instancia unica de la clase PostMonitor, la cual existe solo para el 
         * sitio de Admin.
         */
        public static void savePostOutNetToMonitor(PostOutNet postOutNet)
        {
            if(postOutNet!=null)
            {
                PostMonitor postMonitor=null;
                //Si existe la única instancia PostMonitor que debe de existir, que es en el sitio de Admin, la toma.
                if(PostMonitor.ClassMgr.listPostMonitors(SWBContext.getAdminWebSite()).hasNext())
                {
                    postMonitor=PostMonitor.ClassMgr.listPostMonitors().next();
                }else{  //De lo contrario la crea
                    postMonitor=PostMonitor.ClassMgr.createPostMonitor(SWBContext.getAdminWebSite());
                }
                //Y le agrega el PostOutNet que llego como parametro desde una Red Social que sea de tipo SocialMonitorable, esto para que sea monitoreado el estatus
                //del PostOut que se encuentra en dicha clase y que ha sido tratado de publicar en dicha red social. El monitoreo se lleva a cabo mediante un Timer en 
                //la clase MonitorMgr
                if(postMonitor!=null)
                {
                    postMonitor.addPostOutNet(postOutNet);
                }
            }
        }
        
        
        
        
        public static void editPostOut(PostOut postout, SocialPFlow socialPFlow, ArrayList<SocialNetwork> aSocialNets, WebSite wsite, String toPost, HttpServletRequest request, SWBActionResponse response) 
        {
            System.out.println("editPostOut-1");
            try {
                SWBFormMgr mgr = null;
                if (toPost.equals("msg")) {
                    mgr = new SWBFormMgr(postout.getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
                } else if (toPost.equals("photo")) {
                    mgr = new SWBFormMgr(postout.getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
                } else if (toPost.equals("video")) {
                    mgr = new SWBFormMgr(postout.getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
                }
                System.out.println("editPostOut-2/mgr:"+mgr);
                if (mgr != null) {
                    mgr.setFilterRequired(false);
                    SemanticObject sobj = mgr.processForm(request);
                    org.semanticwb.social.Post post = (org.semanticwb.social.Post) sobj.createGenericInstance();
                    
                    //Convierto a un post de salida para poderle agregar cada red social a la que se envía dicho post
                    PostOut postOut = (PostOut) post;
                    
                    //Le agrego las redes sociales a las cuales se enviara el postOut, si se creó de una contestación, 
                    //sería solo una red social la que vendría en el parametro "aSocialNets", pero como esto es una edición,
                    //primero elimino las asignaciones de redes sociales que ya tenía.
                    Iterator <SocialNetwork> itSocialNets=postout.listSocialNetworks();
                    while(itSocialNets.hasNext())
                    {
                        postOut.removeSocialNetwork(itSocialNets.next());
                    }
                    //Ahora le asigno las nuevas que llegan por parametro.
                    for(int i=0;i<aSocialNets.size();i++)
                    {
                        SocialNetwork socialNet=aSocialNets.get(i);
                        if(socialNet!=null)
                        {
                            postOut.addSocialNetwork(socialNet);
                        }
                    }
                    System.out.println("editPostOut-3/socialPFlow:"+socialPFlow);
                    
                    //SocialPFlow al que se va ha enviar el nuevo post, si no tiene(que llegue Nulo), entonces se envía el PostOut sin pasar por flujo
                    if (socialPFlow != null) {
                        postOut.getPflowInstance().setPflow(socialPFlow);
                        System.out.println("editPostOut-4");
                    }
                }
            } catch (Exception e) {
                log.error(e);
            }
        }
        

        public static void sendNewPost(PostIn postIn, org.semanticwb.social.SocialTopic socialTopic, SocialPFlow socialPFlow, ArrayList<SocialNetwork> aSocialNets, WebSite wsite, String toPost, HttpServletRequest request, SWBActionResponse response) 
        {
            try {
                //if(postIn==null && socialTopic!=null) wsite=WebSite.ClassMgr.getWebSite(socialTopic.getSemanticObject().getModel().getName());
                //System.out.println("sendNewPost/toPost:"+toPost);
                SWBFormMgr mgr = null;
                if (toPost.equals("msg")) {
                    mgr = new SWBFormMgr(Message.sclass, wsite.getSemanticObject(), null);
                } else if (toPost.equals("photo")) {
                    mgr = new SWBFormMgr(Photo.sclass, wsite.getSemanticObject(), null);
                } else if (toPost.equals("video")) {
                    mgr = new SWBFormMgr(Video.sclass, wsite.getSemanticObject(), null);
                }
                System.out.println("sendNewPost/mgr:"+mgr);
                if (mgr != null) {
                    mgr.setFilterRequired(false);
                    SemanticObject sobj = mgr.processForm(request);
                    org.semanticwb.social.Post post = (org.semanticwb.social.Post) sobj.createGenericInstance();
                    post.setSocialTopic(socialTopic); 
                    //Convierto a un post de salida para poderle agregar cada red social a la que se envía dicho post
                    PostOut postOut = (PostOut) post;
                    //Si el PostOut que se acaba de crear, fue en consecuencia de una respuesta de una PostIn, este se agrega al nuevo PostOut
                    if(postIn!=null)    
                    {
                        postOut.setPostInSource(postIn);
                    }
                    
                    System.out.println("sendNewPost-1");
                    if (toPost.equals("video"))
                    {
                        //Guardado de Categorias
                        System.out.println("sendNewPost-2");
                        if(request.getParameterValues(Video.social_category.getName())!=null)
                        {
                                String values=null;
                                String[] categories=request.getParameterValues(Video.social_category.getName());
                                for(int i=0;i<categories.length;i++)
                                {
                                    String value=categories[i];
                                    System.out.println("sendNewPost-3:"+value);
                                    if(value!=null && value.trim().length()>0)
                                    {
                                        if(i>0)
                                        {
                                            values=values+";"+value;
                                        }else{
                                            values=value;
                                        }
                                    }
                                }
                                System.out.println("sendNewPost-4:"+values);
                                ((Video)postOut).setCategory(values);
                        }
                        
                    }
                    
                    //Le agrego las redes sociales a las cuales se enviara el postOut, si se creó de una contestación, 
                    //sería solo una red social la que vendría en el parametro "aSocialNets"
                    for(int i=0;i<aSocialNets.size();i++)
                    {
                        SocialNetwork socialNet=aSocialNets.get(i);
                        if(socialNet!=null)
                        {
                            postOut.addSocialNetwork(socialNet);
                        }
                    }
                    
                    //Clasificar mensaje de salida, esto siempre y cuando exista la propiedad "classifySentMgs" igual a true en el sitio
                    //en donde se acaba de crear el PostOut
                    String isSentMgstoClassify=SWBSocialUtil.Util.getModelPropertyValue(wsite, SWBSocialUtil.CLASSIFYSENTMGS_PROPNAME);
                    if(isSentMgstoClassify!=null && isSentMgstoClassify.equalsIgnoreCase("true")) //Los mensajes de salida si se deben clasificar por sentimientos e intensidad, tal como los de entrada.
                    {
                        System.out.println("Entra a Clasificar mensaje de Salida...");
                        String text2Classify=null;
                        if(postOut instanceof Video) {
                            Video video=(Video)postOut;
                            if(video.getTitle()!=null)
                            {
                                text2Classify=video.getTitle();
                            }
                            if(video.getDescription()!=null) text2Classify+=" " + video.getDescription();
                        }
                        if(postOut.getMsg_Text()!=null) text2Classify+=" " + postOut.getMsg_Text();    
                        if(postOut.getTags()!=null) text2Classify+=" " + postOut.getTags();
                        if(text2Classify!=null)
                        {
                            HashMap hmapValues=SWBSocialUtil.Classifier.classifyText(text2Classify);
                            float promSentimentalValue=((Float)hmapValues.get("promSentimentalValue")).floatValue();
                            int sentimentalTweetValueType=((Integer)hmapValues.get("sentimentalTweetValueType")).intValue();
                            float promIntensityValue=((Float)hmapValues.get("promIntensityValue")).floatValue();
                            int intensityTweetValueType=((Integer)hmapValues.get("intensityTweetValueType")).intValue();

                            System.out.println("SentimentalData../promSentimentalValue:"+promSentimentalValue);
                            System.out.println("SentimentalData../sentimentalTweetValueType:"+sentimentalTweetValueType);
                            System.out.println("SentimentalData../promIntensityValue:"+promIntensityValue);
                            System.out.println("SentimentalData../intensityTweetValueType:"+intensityTweetValueType);
                            
                            //Guarda valores sentimentales en el PostOut (mensaje de Salida)
                            postOut.setPostSentimentalValue(promSentimentalValue);
                            postOut.setPostSentimentalType(sentimentalTweetValueType);

                            //Guarda valores sentimentales en el PostOut (mensaje de Salida)
                            postOut.setPostIntensityValue(promIntensityValue);
                            postOut.setPostIntesityType(intensityTweetValueType);
                        }
                    }
                    
                    
                    //SocialPFlow al que se va ha enviar el nuevo post, si no tiene(que llegue Nulo), entonces se envía el PostOut sin pasar por flujo
                    if (socialPFlow != null) {
                        System.out.println("Se publicaJ-2");
                        String strMessage=request.getParameter("socialFlowComment");
                        if(strMessage==null) strMessage="";
                        SocialLoader.getPFlowManager().sendResourceToAuthorize(postOut, socialPFlow, strMessage);
                        //sendPostOutToAuthorize(postOut, socialPFlow, socialFlowComment);
                    } else {
                        //Revisa las redes sociales a las cuales se tiene que enviar el Post
                        //String[] socialUris = socialUri.split("\\|");  //Dividir valores
                        System.out.println("Se publicaJ-3");
                        publishPost(postOut);
                    }
                }
            } catch (Exception e) {
                log.error(e);
            }
        }
        
        /*
         * Publica un PostOut que llegue como parametro
         * Publish a PostOut that comes as parameter
         * Los parametros request y response no se utilizan, probar y si funciona así para postear en Flicker y Youtube,
         * despues eliminarlos de los parametros que recibe este metodo.
         */
        public static void publishPost(PostOut postOut) throws SocketException
        {
            //try
            {    
                Iterator<SocialNetwork> itSocialNets = postOut.listSocialNetworks();
                while (itSocialNets.hasNext()) {
                    SocialNetwork socialNet = itSocialNets.next();
                    //SemanticObject semObject = SemanticObject.createSemanticObject(tmp_socialUri, wsite.getSemanticModel());
                    //SocialNetwork socialNet = (SocialNetwork) semObject.createGenericInstance();
                    //Se agrega la red social de salida al post
                    //postOut.addSocialNetwork(socialNet);
                    //Se revisa si es de tipo mensaje, foto o video.
                    if (postOut instanceof Message && socialNet instanceof Messageable) {
                        System.out.println("MENSAJE!!");
                        //TODO: YO CREO QUE LO QUE TENGO QUE HACER AQUI, ES UN THREAD POR CADA UNA DE LAS REDES SOCIALES A LAS QUE SE ENVÍE UN POST
                        Messageable messageable = (Messageable) socialNet;
                        //messageable.postMsg((Message) post, request, response);
                        PostableObj postableObj = new PostableObj(messageable, postOut);
                        SendPostThread sendPostThread = new SendPostThread();
                        sendPostThread.addPostAble(postableObj);
                        sendPostThread.start();
                    } else if (postOut instanceof Photo && socialNet instanceof Photoable) {
                        System.out.println("PHOTO!!");
                        //TODO: YO CREO QUE LO QUE TENGO QUE HACER AQUI, ES UN THREAD POR CADA UNA DE LAS REDES SOCIALES A LAS QUE SE ENVÍE UN POST
                        Photoable photoable = (Photoable) socialNet;
                        //photoable.postPhoto((Photo) post, request, response);
                        PostableObj postableObj = new PostableObj(photoable, postOut);
                        SendPostThread sendPostThread = new SendPostThread();
                        sendPostThread.addPostAble(postableObj);
                        sendPostThread.start();
                    } else if (postOut instanceof Video && socialNet instanceof Videoable) {
                        System.out.println("VIDEO!!");
                        //TODO: YO CREO QUE LO QUE TENGO QUE HACER AQUI, ES UN THREAD POR CADA UNA DE LAS REDES SOCIALES A LAS QUE SE ENVÍE UN POST
                        Videoable videoable = (Videoable) socialNet;
                        //videoable.postVideo((Video) post, request, response);
                        PostableObj postableObj = new PostableObj(videoable, postOut);
                        SendPostThread sendPostThread = new SendPostThread();
                        sendPostThread.addPostAble(postableObj);
                        sendPostThread.start();
                    }
                }
            }//catch(Exception e)
            {
                //log.error(e);
            }
            
        }
        
        
        /**
     * Send resource to authorize.
     * 
     * @param resource the resource
     * @param pflow the pflow
     * @param message the message
     * @param user the user
     */
        /*
    public static void sendPostOutToAuthorize(PostOut postOut, SocialPFlow pflow, String message)
    {
        if (message == null)
        {
            message = "";
        }
        WebSite wsite=WebSite.ClassMgr.getWebSite(postOut.getSemanticObject().getModel().getName());
        //String typeresource = resource.getResourceType().getId();
        System.out.println("wsite:"+wsite+",postOut:"+postOut);
        System.out.println("postOut-1:"+postOut.getSemanticObject().getSemanticClass());
        System.out.println("postOut-2:"+postOut.getSemanticObject().getSemanticClass().listSubClasses());
        SemanticClass semClass=postOut.getSemanticObject().getSemanticClass(); 
        System.out.println("sendPostOutToAuthorize/semClass:"+semClass);
        String typeresource=semClass.getClassId();
        System.out.println("typeresource:"+typeresource);
        Document docflow = SWBUtils.XML.xmlToDom(pflow.getXml());
        Element workflow = (Element) docflow.getElementsByTagName("workflow").item(0);
        NodeList resourceTypes = workflow.getElementsByTagName("resourceType");
        for (int ires = 0; ires < resourceTypes.getLength(); ires++)
        {
            Element eres = (Element) resourceTypes.item(ires);
            String iresw = eres.getAttribute("id");
            System.out.println("iresw:"+iresw);
            if (iresw.equals(typeresource) && wsite.getId().equals(eres.getAttribute("topicmap")))
            {
                int version = (int) Double.parseDouble(workflow.getAttribute("version"));
                System.out.println("iresw-version/typeresource:"+version);
                SocialPFlowInstance instance = SocialPFlowInstance.ClassMgr.createSocialPFlowInstance(wsite);
                System.out.println("iresw-instance:"+instance);
                instance.setPflow(pflow);
                postOut.setPflowInstance(instance);
                instance.setPfinstPostOut(postOut);
                instance.setStatus(1);
                instance.setVersion(version);
                SocialLoader.getPFlowManager().initContent(postOut, pflow, message);
                //initPostOut(postOut, pflow, message);
            }
        }
    }
    * **/

        /**
         * Inits the content.
         *
         * @param postOut the PostOut
         * @param pflow the SocialPFlow
         * @param message the message
         */
    /*
        private static void initPostOut(PostOut postOut, SocialPFlow pflow, String message) {
            SocialPFlowInstance instance = postOut.getPflowInstance();
            String version = String.valueOf(instance.getVersion());
            String activity = null;
            String xml = pflow.getXml(); 
            Document docxml = SWBUtils.XML.xmlToDom(xml);
            NodeList workflows = docxml.getElementsByTagName("workflow");
            for (int i = 0; i < workflows.getLength(); i++) {
                Element workflow = (Element) workflows.item(i);
                version = version + ".0";
                if ((workflow.getAttribute("version")).equals(version)) {
                    Element ecurrentActivity = null;
                    NodeList activities = workflow.getElementsByTagName("activity");
                    if (activities.getLength() > 0) {
                        ecurrentActivity = (Element) activities.item(0);
                        activity = ((Element) activities.item(0)).getAttribute("name");
                    }
                    try {
                        instance.setStep(activity);
                        long tinit = System.currentTimeMillis();
                        instance.setTime(new Date(tinit));
                        if (ecurrentActivity.getAttribute("type").equals("Activity")) {
                            long days = Long.parseLong(ecurrentActivity.getAttribute("days"));
                            long hours = 0;
                            if (ecurrentActivity.getAttribute("hours") != null && !ecurrentActivity.getAttribute("hours").equals("")) {
                                hours = Long.parseLong(ecurrentActivity.getAttribute("hours"));
                            }
                            if (days > 0 || hours > 0) {
                                long milliseconds = ((hours * 3600) + (days * 86400)) * 1000;
                                //TODO agregar control de tiempo
                                //Timestamp timestart = occ.getDbdata().getFlowtime();
                                // long timefirst = timestart.getTime() + milliseconds;
                                // ControlFlow controlFlow = new ControlFlow(occ, new java.util.Date(timefirst), activity);
                                // PFlowSrv.addControlFlow(controlFlow);
                            }
                        }
                    } catch (Exception e) {
                        log.error(e);
                    }
                    String messageType = "I";
                    SocialPFlowMgr.mailToNotify(postOut, activity, messageType, message);
                    //mailToNotify(postOut, activity, messageType, message);
                }

            }
        }
**/

        /**
         * Mail to notify.
         *
         * @param resource the resource
         * @param activityName the activity name
         * @param messageType the message type
         * @param message the message
         */
        /*
        private static void mailToNotify(PostOut postOut, String activityName, String messageType, String message) {
            System.out.println("mailToNotify-1");
            
            User wbuser = postOut.getCreator();
            Locale locale = Locale.getDefault();
            System.out.println("locale:"+locale.getLanguage());
            try {
                ResourceBundle bundle = null;
                try {
                    bundle = ResourceBundle.getBundle("org/semanticwb/social/util/pflow/SocialPFlowMgr", locale);
                } catch (Exception e) {
                    bundle = ResourceBundle.getBundle("org/semanticwb/social/util/pflow/SocialPFlowMgr");
                }
                if (postOut.getPflowInstance() != null) {
                    System.out.println("mailToNotify-1");
                    WebSite wsite=WebSite.ClassMgr.getWebSite(postOut.getSemanticObject().getModel().getName());
                    SocialPFlow flow = postOut.getPflowInstance().getPflow();
                    Document docdef = SWBUtils.XML.xmlToDom(flow.getXml());
                    int version = postOut.getPflowInstance().getVersion();
                    NodeList workflows = docdef.getElementsByTagName("workflow");
                    for (int iworkflow = 0; iworkflow < workflows.getLength(); iworkflow++) {
                        Element eworkflow = (Element) workflows.item(iworkflow);
                        if (eworkflow.getAttribute("version").equals(version + ".0")) {
                            System.out.println("mailToNotify-2");
                            NodeList activities = eworkflow.getElementsByTagName("activity");
                            for (int i = 0; i < activities.getLength(); i++) {
                                Element activity = (Element) activities.item(i);
                                if (i == 0 && messageType.equalsIgnoreCase("I")) {
                                    activityName = activity.getAttribute("name");
                                }
                                if (activity.getAttribute("name").equalsIgnoreCase(activityName)) {
                                    System.out.println("mailToNotify-2");
                                    if (activity.getAttribute("type").equalsIgnoreCase("AuthorActivity")) {
                                        System.out.println("mailToNotify-4");
                                        User user = postOut.getCreator();
                                        String msgMail = bundle.getString("msg1") + " " + postOut.getId() + " " + bundle.getString("msg2") + " '" + postOut.getMsg_Text() + "' " + bundle.getString("msg3") + ".";

                                        msgMail += "\r\n" + bundle.getString("msg4") + ": " + wbuser.getFirstName() + " " + wbuser.getLastName();
                                        msgMail += "\r\n" + bundle.getString("msg5") + ": " + wbuser.getLogin();

                                        msgMail += "\r\n" + bundle.getString("msg6") + ": " + message;
                                        msgMail += "\r\n" + bundle.getString("sitio") + ": " + wsite.getTitle() + ".\r\n";
                                        msgMail += "\r\n" + bundle.getString("paso") + ": " + activityName + ".\r\n";
                                        if (activity.getAttribute("days") != null && activity.getAttribute("hours") != null) {
                                            if (!(activity.getAttribute("days").equals("0") && activity.getAttribute("hours").equals("0"))) {
                                                msgMail += "\r\n" + bundle.getString("msgr1") + " " + activity.getAttribute("days") + " " + bundle.getString("days") + " " + bundle.getString("and") + " " + activity.getAttribute("hours") + " " + bundle.getString("hours") + " .";
                                            }
                                        }
                                        SocialTopic socialTopic = (SocialTopic) postOut.getSocialTopic();
                                        HashMap args = new HashMap();
                                        args.put("language", Locale.getDefault().getLanguage());
                                        msgMail += "\r\n" + bundle.getString("socialTopic") + ": " + socialTopic.getTitle() + ".\r\n";
                                        SWBUtils.EMAIL.sendBGEmail(user.getEmail(), bundle.getString("msg7") + " " + postOut.getId() + " " + bundle.getString("msg8"), msgMail);
                                    } else if (activity.getAttribute("type").equalsIgnoreCase("EndActivity")) {
                                        System.out.println("mailToNotify-5");
                                        User user = postOut.getCreator();
                                        String msgMail = bundle.getString("msg1") + " " + postOut.getId() + " " + bundle.getString("msg2") + " '" + postOut.getMsg_Text() + "' " + bundle.getString("msg9") + ".";
                                        msgMail += "\r\n" + bundle.getString("sitio") + ": " + wsite.getTitle() + ".\r\n";
                                        msgMail += "\r\n" + bundle.getString("paso") + ": " + activityName + ".\r\n";
                                        if (messageType.equalsIgnoreCase("N") && message != null && !message.equalsIgnoreCase("")) {
                                            msgMail += "\r\n" + bundle.getString("msg6") + ": " + message;
                                        }
                                        SocialTopic socialTopic = (SocialTopic) postOut.getSocialTopic();
                                        HashMap args = new HashMap();
                                        args.put("language", Locale.getDefault().getLanguage());
                                        msgMail += "\r\n" + bundle.getString("socialTopic") + ": " + socialTopic.getTitle() + ".\r\n";
                                        SWBUtils.EMAIL.sendBGEmail(user.getEmail(), bundle.getString("msg7") + " " + postOut.getId() + " " + bundle.getString("msg10") + "", msgMail);
                                    } else if (activity.getAttribute("type").equalsIgnoreCase("Activity")) {
                                        System.out.println("mailToNotify-6");
                                        HashSet<User> husers = new HashSet<User>();
                                        NodeList users = activity.getElementsByTagName("user");
                                        for (int j = 0; j < users.getLength(); j++) {
                                            Element user = (Element) users.item(j);
                                            String userid = user.getAttribute("id");
                                            User recuser = SWBContext.getAdminRepository().getUser(userid);
                                            husers.add(recuser);
                                        }
                                        NodeList roles = activity.getElementsByTagName("role");
                                        for (int j = 0; j < roles.getLength(); j++) {
                                            Element erole = (Element) roles.item(j);
                                            try {
                                                //Enumeration eusers = DBUser.getInstance(erole.getAttribute("repository")).getUsers();
                                                Iterator<User> eusers = SWBContext.getUserRepository(erole.getAttribute("repository")).listUsers();
                                                while (eusers.hasNext()) {
                                                    User user = eusers.next();
                                                    Iterator<Role> itroles = user.listRoles();
                                                    while (itroles.hasNext()) {
                                                        Role role = itroles.next();
                                                        if (role.getId().equals(erole.getAttribute("id"))) {
                                                            husers.add(user);
                                                        }
                                                    }
                                                }
                                            } catch (Exception e) {
                                                log.error(e);
                                            }
                                        }
                                        //envía correo
                                        String to = "";
                                        Iterator<User> itusers = husers.iterator();
                                        while (itusers.hasNext()) {
                                            User user = itusers.next();
                                            if (user != null && user.getEmail() != null && to.indexOf(user.getEmail()) == -1) {
                                                to += user.getEmail() + ";";
                                            }
                                        }
                                        if (to.endsWith(";")) {
                                            to = to.substring(0, to.length() - 1);
                                        }
                                        if (!to.equalsIgnoreCase("")) {
                                            System.out.println("mailToNotify-7");
                                            String subject = bundle.getString("msg7") + " " + postOut.getId() + " " + bundle.getString("msg11");
                                            String msg = bundle.getString("msg1") + " " + postOut.getId() + " " + bundle.getString("msg2") + " '" + postOut.getMsg_Text() + "' " + bundle.getString("msg12") + " '" + activityName + "'.\r\n";
                                            msg += "\r\n" + bundle.getString("sitio") + ": " + wsite.getTitle() + ".\r\n";
                                            msg += "\r\n" + bundle.getString("paso") + ": " + activityName + ".\r\n";
                                            SocialTopic socialTopic = (SocialTopic) postOut.getSocialTopic();
                                            HashMap args = new HashMap();
                                            args.put("language", Locale.getDefault().getLanguage());
                                            msg += "\r\n" + bundle.getString("socialTopic") + ": " + socialTopic.getTitle() + ".\r\n";

                                            if ((messageType.equalsIgnoreCase("I") || messageType.equalsIgnoreCase("N")) && message != null && !message.equalsIgnoreCase("")) {
                                                msg += "\r\n" + bundle.getString("msg6") + ": " + message;
                                            }
                                            if (messageType.equalsIgnoreCase("A")) {

                                                // envía correo al creador del contenido
                                                User user = postOut.getCreator();
                                                String msgMail = bundle.getString("sitio") + ": " + wsite.getTitle() + ".\r\n";
                                                msgMail += "\r\n" + bundle.getString("paso") + ": " + activityName + ".\r\n";
                                                //msgMail+=bundle.getString("url")+": "+ObjRes.getAdminUrl()+".\r\n";
                                                msgMail += "\r\n" + bundle.getString("socialTopic") + ": " + socialTopic.getTitle() + ".\r\n";
                                                msgMail += "\r\n" + bundle.getString("msg13") + " " + postOut.getId() + " " + bundle.getString("msg14");

                                                SWBUtils.EMAIL.sendBGEmail(user.getEmail(), bundle.getString("msg13") + " " + postOut.getId() + " " + bundle.getString("msg14"), msgMail);

                                                // avisa al los revisores de la expiración de la revisión delc ontenido
                                                msg += "\r\n" + bundle.getString("msg13") + " " + postOut.getId() + " " + bundle.getString("msg14");
                                            }
                                            if (activity.getAttribute("days") != null && activity.getAttribute("hours") != null) {
                                                System.out.println("mailToNotify-8");
                                                if (!(activity.getAttribute("days").equals("0") && activity.getAttribute("hours").equals("0"))) {
                                                    System.out.println("mailToNotify-9");
                                                    msg += "\r\n" + bundle.getString("msgr1") + " " + activity.getAttribute("days") + " " + bundle.getString("days") + " " + bundle.getString("and") + " " + activity.getAttribute("hours") + " " + bundle.getString("hours") + " .";
                                                }
                                            }
                                            System.out.println("Va a enviar correo...J-to:"+to+",subject:"+subject+",msg:"+msg);
                                            SWBUtils.EMAIL.sendBGEmail(to, subject, msg);
                                            System.out.println("Va a enviar correo...J1");
                                        }
                                    }
                                }
                            }
                        }
                    }

                }

            } catch (Exception e) {
                log.error(e);
                return;
            }
        }
        * */
 
        
    }
    
}
