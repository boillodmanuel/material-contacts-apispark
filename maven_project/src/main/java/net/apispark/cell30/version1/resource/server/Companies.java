package net.apispark.cell30.version1.resource.server;

import net.apispark.cell30.version1.representation.Address;
import net.apispark.cell30.version1.representation.Company;

import java.util.Arrays;

/**
 * @author Manuel Boillod
 */
public class Companies {

    public static Company COMPANY_1;

    static {
        Address address = new Address();
        address.setCity("nantes");

        Company company = new Company();
        company.setId("123");
        company.setName("restlet");
        company.setTags(Arrays.asList("tag1", "tag2"));
        company.setAddress(address);

        COMPANY_1 = company;
    }
}
