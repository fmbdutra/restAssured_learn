package br.com.dextra.Test_RestAssured_Java_Rest;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class TestAPI {
	
	@Test
	public void abc() {
		String uriBase = "https://postman-echo.com/get";
		
		given()
		.relaxedHTTPSValidation()
		.param("foo1", "bar1")
		.param("foo2", "bar2")
		.when()
		.get(uriBase)
		.then()
		.statusCode(200) //Retorna Status da Página
		.contentType(ContentType.JSON) //Formato da resposta
		.body("headers.host", is("postman-echo.com")) //chave host
		.body("args.foo1", containsString("bar")); //Chave "foo1" contem valor "bar"
	}
}

