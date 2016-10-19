package net.apispark.cell30.version1;

import com.fasterxml.jackson.annotation.JsonInclude;
import net.apispark.cell30.version1.resource.server.Folder1FileServerResource;
import net.apispark.cell30.version1.resource.server.Folder1FolderServerResource;

import net.apispark.cell30.version1.resource.server.CompaniesUnwrappedServerResource;
import net.apispark.cell30.version1.resource.server.CompaniesWrappedServerResource;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.Resource;
import org.restlet.routing.Filter;
import org.restlet.routing.Router;
import org.restlet.service.ConverterService;
import org.restlet.service.MetadataService;

import java.io.IOException;
import java.util.logging.Level;

public class TestApplication extends Application {

    public TestApplication() {
        this((Context) null);
    }

    public TestApplication(Context context) {
        super(context);
        setName("WebApi " + this.getClass().getCanonicalName());
        MetadataService metadataService = getMetadataService();

        metadataService.clearExtensions();
        // replaced extensions by media types
        metadataService.addExtension("json", new MediaType("application/json"));
        metadataService.addExtension("xml", new MediaType("application/xml"));
        metadataService.addExtension("xml", new MediaType("text/xml"));
        metadataService.addExtension("application/x-yaml", new MediaType("application/x-yaml"));

        //TODO: not able to handle it in server skeleton (no converter)
//        metadataService.addExtension("application/vdn.product.v1+json", new MediaType("application/vdn.product.v1+json"));

        getConnegService().setStrict(true);

        setConverterService(new ApiConverterService());
    }

    public Restlet createInboundRoot() {
        // Update the logger's name
        getContext().setLogger(this.getClass().getCanonicalName());

        // Initialize firewall
        Router router = new Router(getContext());
        router.attach("/folder1", Folder1FolderServerResource.class);
        router.attach("/folder1/", Folder1FolderServerResource.class);
        router.attach("/folder1/{file}", Folder1FileServerResource.class);
        router.attach("/companies_wrapped", CompaniesWrappedServerResource.class);
        router.attach("/companies_unwrapped", CompaniesUnwrappedServerResource.class);

        return router;
    }

    private static class ApiConverterService extends ConverterService {
        @Override
        public <T> T toObject(Representation source, Class<T> target, Resource resource) throws IOException {
            try {
                return super.toObject(source, target, resource);
            } catch (Exception e) {
                Context.getCurrentLogger()
                        .log(Level.WARNING,
                                "Unable to convert a "
                                        + source
                                        + " representation into an object of class "
                                        + target.getCanonicalName(),
                                e);
            }
            throw new RuntimeException(); //TODO use EntityDeserializationException(e);
        }

        @Override
        public Representation toRepresentation(Object source, Variant target, Resource resource) throws IOException {
            Representation representation = super.toRepresentation(source, target, resource);
            if (representation instanceof JacksonRepresentation) {
                ((JacksonRepresentation) representation).getObjectMapper().setSerializationInclusion(JsonInclude.Include.ALWAYS);
            };
            return representation;
        }
    }
}
