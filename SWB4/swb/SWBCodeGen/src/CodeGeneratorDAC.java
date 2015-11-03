
import java.io.File;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.codegen.CodeGenerator;
import org.semanticwb.codegen.CodeGeneratorException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge.jimenez
 */
public class CodeGeneratorDAC {
public static void main(String[] args) {
        new CodeGeneratorDAC().codeGen(args);
    }

    public void codeGen(String[] args) {
        String base = SWBUtils.getApplicationPath();
        SWBPlatform.createInstance();
        //SWBPlatform.getSemanticMgr().initializeDB();
        SWBPlatform.getSemanticMgr().addBaseOntology(base + "/../../../web/WEB-INF/owl/swb.owl");
        SWBPlatform.getSemanticMgr().addBaseOntology(base + "/../../../../DAC/web/WEB-INF/owl/ext/dac.owl");
        SWBPlatform.getSemanticMgr().loadBaseVocabulary();
        //SWBPlatform.getSemanticMgr().loadDBModels();
        SWBPlatform.getSemanticMgr().getOntology().rebind();

        try {
            String path = getClass().getResource("/").getPath().replaceAll("%20", " ");
            File dir = new File(path + ".../../../../../../DAC/DACModel/src");
            CodeGenerator codeGeneration = new CodeGenerator();
            codeGeneration.generateCode("dac", false, dir);
            System.out.println("Generación de clases completa");
        } catch (CodeGeneratorException cge) {
            System.out.println("ERROORRRR....");
            cge.printStackTrace();
        }
    }
}