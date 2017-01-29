package net.apispark;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.restlet.Client;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Protocol;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestClient {

    static TestHost testHost;

    String host  = "http://localhost:8183/api";
    String folderUrl = host + "/folder1";
    String companies_unwrapped = host + "/companies_unwrapped";
    String companies_wrapped = host + "/companies_wrapped";
    String fileUrl = folderUrl + "/1";
    Client client = new Client(Protocol.HTTP);

    @BeforeClass
    public static void initTest() {
        testHost = new TestHost();
        testHost.start();
    }

    @AfterClass
    public static void endTest() {
        testHost.stop();
    }

    // CONTENT NEGO SUR FILESTORE (APPLICABLE ON ENTITY STORE)
    @Test
    public void return_json_by_default_when_no_accept_is_set() {
        // Get a representation of the folder's content
        Request request = new Request(Method.GET, folderUrl);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/json"));
    }

    @Test
    public void return_json_by_default_when_accept_is_all() {
        // Get a representation of the folder's content with json preference
        Request request = new Request(Method.GET, folderUrl);
        request.getClientInfo().accept(MediaType.ALL);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/json"));
    }

    @Test
    public void return_json_when_accept_is_application_json() {
        // Get a representation of the folder's content with json preference
        Request request = new Request(Method.GET, folderUrl);
        request.getClientInfo().accept(MediaType.APPLICATION_JSON);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/json"));
    }

    @Test
    public void return_yaml_when_accept_is_application_x_yaml() {
        // Get a representation of the folder's content with json preference
        Request request = new Request(Method.GET, folderUrl);
        request.getClientInfo().accept(MediaType.APPLICATION_YAML);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/x-yaml"));
    }

//    @Test
//    public void return_vendor_specific_when_accept_is_application_vendor_specific() {
//        // Get a representation of the folder's content with json preference
//        Request request = new Request(Method.GET, folderUrl);
//        request.getClientInfo().accept(new MediaType("application/vdn.product.v1+json"));
//        Response response = client.handle(request);
//        System.out.println(response.getStatus() + " " + response.getEntityAsText());
//        assertThat(response.getStatus().getCode(), is(200));
//        assertThat(response.getEntity().getMediaType().toString(), is("application/vdn.product.v1+json"));
//    }

    @Test
    public void return_application_xml_when_accept_is_application_xml() {
        // Get a representation of the folder's content with xml preference
        Request request = new Request(Method.GET, folderUrl);
        request.getClientInfo().accept(MediaType.APPLICATION_XML);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/xml"));
        // FIXME pb de serialisation des folders en xml
        // Currently is:
        // <FolderListRepresentation><list><list><mediaType>file/x-doc</mediaType><directory>false</directory><name>list.doc</name></list></list></FolderListRepresentation>
        assertThat(response.getEntityAsText(), is("<FolderListRepresentation><list><FolderRepresentation><mediaType>file/x-doc</mediaType><directory>false</directory><name>list.doc</name></FolderRepresentation></list></FolderListRepresentation>"));
    }

    @Test
    public void return_text_xml_when_accept_is_text_xml() {
        // Get a representation of the folder's content with xml preference
        Request request = new Request(Method.GET, folderUrl);
        request.getClientInfo().accept(MediaType.TEXT_XML);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("text/xml"));
    }

    @Test
    public void return_application_xml_when_media_query_param_is_xml() {
        // Get a representation of the folder's content with xml preference
        Request request = new Request(Method.GET, folderUrl + "?media=xml");
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/xml"));
    }

    @Test
    public void return_json_when_media_query_param_is_json() {
        // Get a representation of the folder's content with xml preference
        Request request = new Request(Method.GET, folderUrl + "?media=json");
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/json"));
    }

    @Test
    public void return_application_xml_when_media_query_param_is_xml_even_if_accept_is_application_json() {
        // Get a representation of the folder's content with xml preference
        Request request = new Request(Method.GET, folderUrl + "?media=xml");
        request.getClientInfo().accept(MediaType.APPLICATION_JSON);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/xml"));
    }

    @Test
    public void return_406_when_media_query_param_is_not_accetpable_as_atom() {
        // Get a representation of the folder's content, with unsupported media type
        Request request = new Request(Method.GET, folderUrl);
        request.getClientInfo().accept(MediaType.APPLICATION_ATOM);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(406));
    }

    @Test
    public void return_406_when_media_query_param_is_unknown() {
        // Get a representation of the folder's content with xml preference
        Request request = new Request(Method.GET, folderUrl + "?media=custom");
        request.getClientInfo().accept(MediaType.APPLICATION_JSON);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(406));
    }

    @Test
    public void return_file_content_type_when_accept_is_not_set() {
        // Get a representation of a file
        Request request = new Request(Method.GET, fileUrl);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("text/plain"));
    }


    //TODO to fix
    @Ignore
    @Test
    public void return_file_content_type_and_ignore_accept_when_accept_is_set() {
        // Get a representation of a file with a preference
        // Unsuported case, need a fix in the ConnecterService (a single if to add)
        Request request = new Request(Method.GET, fileUrl);
        request.getClientInfo().accept(MediaType.APPLICATION_ATOM);
        Response response = client.handle(request);
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("text/plain"));
    }

    // input content type POST

    @Test
    public void post_json_and_return_json_by_default_when_no_accept_is_set() {
        // Get a representation of the folder's content
        Request request = new Request(Method.POST, companies_unwrapped);
        request.setEntity("{\"name\":\"restlet\"}", MediaType.APPLICATION_JSON);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/json"));
        assertThat(response.getEntityAsText(), is("{\"name\":\"restlet\"}"));
    }

    @Test
    public void post_json_and_return_json_by_default_when_no_accept_is_json() {
        // Get a representation of the folder's content
        Request request = new Request(Method.POST, companies_unwrapped);
        request.getClientInfo().accept(MediaType.APPLICATION_JSON);
        request.setEntity("{\"name\":\"restlet\"}", MediaType.APPLICATION_JSON);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/json"));
        assertThat(response.getEntityAsText(), is("{\"name\":\"restlet\"}"));
    }


    @Test
    public void post_json_and_return_json_by_default_when_no_accept_is_xml() {
        // Get a representation of the folder's content
        Request request = new Request(Method.POST, companies_unwrapped);
        request.getClientInfo().accept(MediaType.APPLICATION_XML);
        request.setEntity("{\"name\":\"restlet\"}", MediaType.APPLICATION_JSON);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/xml"));
        assertThat(response.getEntityAsText(), is("<Company><name>restlet</name></Company>"));
    }

    // UNWRAPPED / WRAPPED list

    @Test
         public void return_unwrapped_list_in_json() {
        // Get a representation of the folder's content with xml preference
        Request request = new Request(Method.GET, companies_unwrapped);
        request.getClientInfo().accept(MediaType.APPLICATION_JSON);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/json"));
        assertThat(response.getEntityAsText(), is("[{\"tags\":[\"tag1\",\"tag2\"],\"id\":\"123\",\"name\":\"restlet\",\"address\":{\"street\":null,\"zipcode\":null,\"city\":\"nantes\"}}]"));
    }

    @Test
         public void return_unwrapped_list_in_json_by_default() {
        // Get a representation of the folder's content with xml preference
        Request request = new Request(Method.GET, companies_unwrapped);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/json"));
        assertThat(response.getEntityAsText(), is("[{\"tags\":[\"tag1\",\"tag2\"],\"id\":\"123\",\"name\":\"restlet\",\"address\":{\"street\":null,\"zipcode\":null,\"city\":\"nantes\"}}]"));
    }

    @Test
    public void return_unwrapped_list_in_xml() {
        // Get a representation of the folder's content with xml preference
        Request request = new Request(Method.GET, companies_unwrapped);
        request.getClientInfo().accept(MediaType.APPLICATION_XML);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/xml"));
        assertThat(response.getEntityAsText(), is("<list><Company><tags><tags>tag1</tags><tags>tag2</tags></tags><id>123</id><name>restlet</name><address><street/><zipcode/><city>nantes</city></address></Company></list>"));
    }

    @Test
    public void return_wrapped_list_in_json() {
        // Get a representation of the folder's content with xml preference
        Request request = new Request(Method.GET, companies_wrapped);
        request.getClientInfo().accept(MediaType.APPLICATION_JSON);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/json"));
        assertThat(response.getEntityAsText(), is("{\"list\":[{\"tags\":[\"tag1\",\"tag2\"],\"id\":\"123\",\"name\":\"restlet\",\"address\":{\"street\":null,\"zipcode\":null,\"city\":\"nantes\"}}]}"));
    }

    @Test
    public void return_wrapped_list_in_xml() {
        // Get a representation of the folder's content with xml preference
        Request request = new Request(Method.GET, companies_wrapped);
        request.getClientInfo().accept(MediaType.APPLICATION_XML);
        Response response = client.handle(request);
        System.out.println(response.getStatus() + " " + response.getEntityAsText());
        assertThat(response.getStatus().getCode(), is(200));
        assertThat(response.getEntity().getMediaType().toString(), is("application/xml"));
        assertThat(response.getEntityAsText(), is("<CompanyList><list><Company><tags><tags>tag1</tags><tags>tag2</tags></tags><id>123</id><name>restlet</name><address><street/><zipcode/><city>nantes</city></address></Company></list></CompanyList>"));
    }

}
