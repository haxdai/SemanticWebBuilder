package org.semanticwb.ecosikan.innova;


public class Category extends org.semanticwb.ecosikan.innova.base.CategoryBase {


    public enum CategoryOfIdea {
        Opened("Abierto"),
        Revise("En revisión"),
        Revised("Revisado"),
        Running("En ejecución"),
        Executed("Ejecutado");
        private String description;
        CategoryOfIdea(String description) {
            this.description = description;
        }
        public String getDescription() {
            return this.description;
        }
        public CategoryOfIdea next() {
            switch(this) {
                case Opened:
                    return Revise;
                case Revise:
                    return Revised;
                case Revised:
                    return Running;
                case Running:
                    return Executed;
                case Executed:
                    return null;
                default:
                    return null;
            }
        }
        public boolean hasNext() {
            switch(this) {
                case Executed:
                    return false;
                default:
                    return true;
            }
        }
    }

    public Category(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
