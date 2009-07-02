package org.semanticwb.nlp.spell;

import java.io.File;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.spell.LuceneDictionary;
import org.apache.lucene.search.spell.PlainTextDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;

/**
 * Wrapper for Lucene @link{SpellChecker} class.
 * Envoltorio para la clase @link{SpellChecker} de Lucene.
 * 
 * @author Hasdai Pacheco {haxdai@gmail.com}
 */
public class SWBSpellChecker {
    /**Lucene SpellChecker object*/
    private SpellChecker checker = null;
    /**Lucene Dictionary to store words for spelling suggestions*/
    private LuceneDictionary spellDict = null;
    /**Directory to store spell indexes*/
    private Directory spellDir = null;
    /**Number of max suggestions to retrieve*/
    private int numSug = 5;

    private static Logger log = SWBUtils.getLogger(SWBSpellChecker.class);

    /**
     * Creates a new instance of a SWBSpellChecker. Builds a Lucene SpellChecker
     * using a Directory containing the displayName of Semantic classes and properties.
     *
     * Crea una nueva instancia de SWBSpellChecker. Construye un corrector
     * ortográfico de Lucene a partir de un Directorio de Lucene que contiene los
     * displayNames de las clases y propiedades semánticas.
     *
     * @param directoryPath path of the Lucene Directory to extract words from.
     * @param fieldName name of the field to take words from.
     */
    public SWBSpellChecker(String directoryPath, String fieldName) {
        indexSpellDir(directoryPath, fieldName);
    }

    /**
     * Creates a new instance of a SWBSpellChecker. Builds a Lucene SpellChecker
     * using a text file containing the displayName of Semantic classes and properties.
     *
     * Crea una nueva instancia de SWBSpellChecker. Construye un corrector
     * ortográfico de Lucene a partir de un archivo de texto que contiene los
     * displayNames de las clases y propiedades semánticas.
     *
     * @param txtDictFilePath path of the text file to extract words from.
     */
    public SWBSpellChecker(String txtDictFilePath) {
        File f = new File(txtDictFilePath);

        if (f.exists()) {
            indexSpellTextFile(f);
        }
    }

    /**
     * Creates and indexes a new Directory for spell checking. This method uses
     * an existing Lucene Directory to create the spelling dictionary.
     * @param dirPath Path of the original index directory.
     * @param fieldName Name of the field which new spell dictionary and index
     * directory will have.
     */
    public void indexSpellDir(String dirPath, String fieldName) {
        try {
            spellDir = new RAMDirectory();
            checker = new SpellChecker(spellDir);
            spellDict = new LuceneDictionary(IndexReader.open(dirPath), fieldName);
            checker.indexDictionary(spellDict);
        } catch (Exception ex) {
           log.error(ex);
        }
    }

    /**
     * Creates and indexes a new Directory for spell checking. This method uses
     * an existing text file to create the spelling dictionary.
     * @param txtDictFile Path of the text file containing the spelling dictionary.
     */
    private void indexSpellTextFile(File txtDictFile) {
         try {
            spellDir = new RAMDirectory();
            checker = new SpellChecker(spellDir);
            checker.indexDictionary(new PlainTextDictionary(txtDictFile));
        } catch (Exception ex) {
            log.error(ex);
        }
    }

    /**
     * Gets the current number of suggestions to obtain from the SpellChecker.
     */
    public int getNumSug() {
        return numSug;
    }

    /**
     * Sets the number of suggestions to obtain from the SpellChecker.
     */
    public void setNumSug(int numSug) {
        this.numSug = numSug;
    }    

    /**
     * Gets a set of words similar to the given input.
     * @param word Wort to have spell check done on.
     * @return Set of words similar to the input string.
     */
    public String[] suggestSimilar(String word) {
        if (checker != null) {
            try {
                if (checker.exist(word)) {
                    return null;
                }
                String res[] = checker.suggestSimilar(word, numSug);
                return res;
            } catch (Exception ex) {
                log.error(ex);
            }
        }
        return null;
    }
}