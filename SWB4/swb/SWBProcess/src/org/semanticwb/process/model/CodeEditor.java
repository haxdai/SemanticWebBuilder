package org.semanticwb.process.model;

import javax.servlet.http.HttpServletRequest;
import org.semanticwb.SWBPlatform;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;


public class CodeEditor extends org.semanticwb.process.model.base.CodeEditorBase 
{
    public CodeEditor(org.semanticwb.platform.SemanticObject base) { super(base); }

    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName, String type, String mode, String lang) {
        String value = request.getParameter(propName);
        if (value == null) value = obj.getProperty(prop);
        if (value == null) value = "";
        
        StringBuilder codeMirrorConfig = new StringBuilder();
        codeMirrorConfig.append("{")
          .append("lineNumbers: true")
          .append(", lineWrapping: true")
          .append(", mode: \"text/x-java\"");
        if (!mode.equals("edit") && !mode.equals("create")) {
            codeMirrorConfig.append(", readOnly: true");
        }
        codeMirrorConfig.append("}");
        
        String editorVar = "editor_"+obj.getId()+"_"+propName;
        String textareaId = obj.getURI()+"/"+propName;
        
        StringBuilder sb = new StringBuilder();
          sb.append("<div dojoType=\"dojox.layout.ContentPane\" executeScripts=\"true\">")
            .append("  <textarea name=\"").append(propName).append("\" id=\"").append(textareaId).append("\">").append(value).append("</textarea>")
            .append("  <link rel=\"stylesheet\" href=\"").append(SWBPlatform.getContextPath()).append("/swbadmin/jsp/process/utils/codemirror/lib/codemirror.css\">")
            .append("  <script type=\"dojo/method\">")
            .append("    require({")
            .append("      packages:[{")
            .append("        name: \"codemirror\",")
            .append("        location: \"/swbadmin/jsp/process/utils/codemirror\",")
            .append("        main: \"lib/codemirror\"")
            .append("      }]")
            .append("    },[\"codemirror\",\"codemirror/mode/clike/clike\"], function(CodeMirror) {")
            .append("      var ").append(editorVar).append(" = CodeMirror.fromTextArea(document.getElementById('").append(textareaId).append("'), ").append(codeMirrorConfig.toString()).append(");")
            .append(editorVar).append(".on(\"change\", function(cm){document.getElementById('").append(textareaId).append("').value=cm.getValue();});")
            .append("    });")
            .append("  </script>")
            .append("</div>");
        
        return sb.toString();
    }
}
