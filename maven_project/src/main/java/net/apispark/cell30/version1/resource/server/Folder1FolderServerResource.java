package net.apispark.cell30.version1.resource.server;

import net.apispark.cell30.version1.representation.FolderListRepresentation;
import net.apispark.cell30.version1.representation.FolderRepresentation;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Options;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

public class Folder1FolderServerResource extends AbstractServerResource {


    @Get("json|xml|application/x-yaml")
    public FolderListRepresentation represent() throws Exception {
        FolderListRepresentation bean = new FolderListRepresentation();
        bean.getList().add(new FolderRepresentation("file/x-doc", false, "list.doc"));
        return bean;
    }

}
