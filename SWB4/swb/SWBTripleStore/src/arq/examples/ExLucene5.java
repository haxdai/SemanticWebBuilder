/**  
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración, 
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de 
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes 
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y 
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación 
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; 
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. 
* 
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 
 
/*
 * (c) Copyright 2006, 2007, 2008 Hewlett-Packard Development Company, LP
 * All rights reserved.
 * [See end of file]
 */

package arq.examples;

import java.io.StringReader;

import com.hp.hpl.jena.query.ARQ;
import com.hp.hpl.jena.query.larq.IndexBuilderNode;
import com.hp.hpl.jena.query.larq.IndexLARQ;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.sparql.util.StringUtils;
import com.hp.hpl.jena.sparql.util.Utils;

/** Example code to index subjects by some external content.
 *  Pattern 3. 
 * 
 * @author Andy Seaborne
 */

public class ExLucene5
{
    
    public static void main(String[] a) throws Exception
    {
        System.out.println("ARQ Example: "+Utils.classShortName(ExLucene5.class)) ;
        System.out.println("ARQ: "+ARQ.VERSION) ;
        System.out.println() ;
        
        Model model = ModelFactory.createDefaultModel() ;

        IndexLARQ index = buildIndexExternalContent(model) ;
        
        // Search for string 
        String searchString = "+document" ;
        
        // This time, find documents with a matching DC title. 
        String queryString = StringUtils.join("\n", new String[]{
            "PREFIX pf:     <http://jena.hpl.hp.com/ARQ/property#>",
            "SELECT ?doc {" ,
            "    ?doc pf:textMatch '"+searchString+"'.",
            "}"
        }) ;
        
        // Two of three docuemnts should match. 
        ExLucene1.performQuery(model, index, queryString) ;
        index.close() ;
    }
    
    static IndexLARQ buildIndexExternalContent(Model model)
    {
        // ---- Create index builder
        IndexBuilderNode larqBuilder = new IndexBuilderNode();
        
        Resource r1 = ResourceFactory.createResource("http://example/r1") ;
        Resource r2 = ResourceFactory.createResource("http://example/r2") ;
        Resource r3 = ResourceFactory.createResource("http://example/r3") ;
        Resource r4 = ResourceFactory.createResource("http://example/r4") ;
        Literal  lit1 = ResourceFactory.createPlainLiteral("doc") ;
        
        // ---- Index based on some external content 
        
        
        larqBuilder.index(r1, new StringReader("document")) ;   // Just to show a Stringreader is possible
        larqBuilder.index(r2, "document") ;
        larqBuilder.index(r3, "slideshow") ;
        larqBuilder.index(r4, "codebase") ;
        larqBuilder.index(lit1, "document") ;
        
        // Note that the model is untouched - the index exists outside of any model statements.
        // The application is responsible for keeping 
        // ---- 
        
        larqBuilder.closeWriter() ;
        IndexLARQ index = larqBuilder.getIndex() ;
        
//        NodeIterator iter = index.searchModelByIndex(model, "document") ;
//        for ( ; iter.hasNext() ; )
//            System.out.println("Found: "+FmtUtils.stringForRDFNode((RDFNode)iter.next())) ;
        
        return index ;
    }

}

/*
 * (c) Copyright 2006, 2007, 2008 Hewlett-Packard Development Company, LP
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */