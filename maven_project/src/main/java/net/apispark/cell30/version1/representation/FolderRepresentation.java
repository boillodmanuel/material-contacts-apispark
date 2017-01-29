package net.apispark.cell30.version1.representation;

import java.util.ArrayList;

public class FolderRepresentation {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private String mediaType;


    public FolderRepresentation() {}

    public FolderRepresentation(String mediaType, Boolean directory, String name) {
        this.mediaType = mediaType;
        this.directory = directory;
        this.name = name;
    }

    @com.fasterxml.jackson.annotation.JsonProperty("mediaType")
    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }


    private Boolean directory;

    
    @com.fasterxml.jackson.annotation.JsonProperty("directory")
    public Boolean getDirectory() {
        return directory;
    }

    public void setDirectory(Boolean directory) {
        this.directory = directory;
    }


    private String name;

    
    @com.fasterxml.jackson.annotation.JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
