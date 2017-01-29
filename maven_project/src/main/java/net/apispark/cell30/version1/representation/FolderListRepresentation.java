package net.apispark.cell30.version1.representation;

import java.util.ArrayList;

public class FolderListRepresentation {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private java.util.List<FolderRepresentation> list;



    @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper(localName = "list")
    @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty(localName = "FolderRepresentation")
    public java.util.List<FolderRepresentation> getList() {
        if (list == null) {
            list = new ArrayList<FolderRepresentation>();
        }
        return list;
    }

    public void setList(java.util.List<FolderRepresentation> list) {
        this.list = list;
    }

}
