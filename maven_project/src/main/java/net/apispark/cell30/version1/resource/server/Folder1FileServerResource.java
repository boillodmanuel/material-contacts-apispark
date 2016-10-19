package net.apispark.cell30.version1.resource.server;

import org.restlet.data.MediaType;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.representation.Variant;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Options;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.service.MetadataService;

import java.nio.file.Files;
import java.nio.file.Path;

public class Folder1FileServerResource extends AbstractServerResource {

    @Override
    protected void doInit() throws ResourceException {
        super.doInit();
        setNegotiated(false);
    }

    @Get
    public Representation represent() throws Exception {
        return new StringRepresentation("dodelidoudodelidoutititatatoto");
    }

    @Put
    public Representation store(Representation bean) throws Exception {
        return bean;
    }

    @Delete
    public void remove() throws Exception {
    }

    @Options
    public void getOptions() {
    }
}
