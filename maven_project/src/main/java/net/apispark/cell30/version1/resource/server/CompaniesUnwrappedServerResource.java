package net.apispark.cell30.version1.resource.server;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import net.apispark.cell30.version1.representation.Company;
import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

import java.util.ArrayList;

public class CompaniesUnwrappedServerResource extends AbstractServerResource {


    @Get("json|xml|application/x-yaml")
    public JacksonRepresentation<CompanyList> representAsXml() throws Exception {
        CompanyList list = new CompanyList();
        list.add(Companies.COMPANY_1);

        MediaType mediaType = getPreferredVariant(getVariants()).getMediaType();
        JacksonRepresentation<CompanyList> result = new JacksonRepresentation<>(mediaType, list);

        if (result.getObjectMapper() instanceof XmlMapper) {
            com.fasterxml.jackson.dataformat.xml.XmlMapper xmlMapper = (com.fasterxml.jackson.dataformat.xml.XmlMapper) result.getObjectMapper();
            xmlMapper.setSerializerProvider(new com.restlet.utils.CustomXmlSerializerProvider("list", "Company"));
        }
        return result;
    }

    @Post("json|xml|application/x-yaml")
    public Company echo(Company input) throws Exception {
        return input;
    }

    public class CompanyList extends ArrayList<Company> {
    }

}
