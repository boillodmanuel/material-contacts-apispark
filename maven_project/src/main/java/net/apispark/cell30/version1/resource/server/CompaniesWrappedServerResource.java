package net.apispark.cell30.version1.resource.server;

import net.apispark.cell30.version1.representation.Company;
import net.apispark.cell30.version1.representation.FolderRepresentation;
import org.restlet.resource.Get;

import java.util.ArrayList;
import java.util.List;

public class CompaniesWrappedServerResource extends AbstractServerResource {


    @Get("json|xml|application/x-yaml")
    public CompanyList represent() throws Exception {
        CompanyList list = new CompanyList();
        list.getList().add(Companies.COMPANY_1);
        return list;
    }

    public static class CompanyList {
        private List<Company> list = new ArrayList<>();

        @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper(localName = "list")
        @com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty(localName = "Company")
        public List<Company> getList() {
            return list;
        }

        public void setList(List<Company> list) {
            this.list = list;
        }
    }
}
