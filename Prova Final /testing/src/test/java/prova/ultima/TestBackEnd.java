package prova.ultima;
import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import io.restassured.RestAssured;

public class TestBackEnd {
    
    @Before
    public void loginUser() {
        RestAssured.baseURI = "https://parabank.parasoft.com/parabank/";
        Map<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("username", "us3rn4m3");
        jsonObject.put("password", "p455w0rd");

        given()
                .body(jsonObject)
                .and()
                .when()
                .post("login.html");

    }

    @Test
    // Registro URL
    public void testeRegistroURL() {
        Map<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("customer.firstName", "Jonas");
        jsonObject.put("customer.lastName", "Antunes");
        jsonObject.put("customer.address", "street: rua do fim");
        jsonObject.put("customer.address", "city: andrade");
        jsonObject.put("customer.address", "state: PA");
        jsonObject.put("customer.address", "zipCode: 245325");
        jsonObject.put("customer.phoneNumber", "4523532");
        jsonObject.put("customer.ssn", " 77");
        jsonObject.put("customer.username", "u53rn4m3");
        jsonObject.put("customer.password", "p455w0rdy");

        given()
                .body(new Gson().toJson(jsonObject))
                .and()
                .when()
                .get("register.htm")
                .then()
                .statusCode(200);
    }

    @Test
    public void newAccount() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("customerId", "54354");
        jsonObject.put("newAccountType", "1");
        jsonObject.put("fromAccountId", "454354");


        given()
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when()
                .post("services_proxy/bank/createAccount?customerId=54354&newAccountType=1&fromAccountId=454354")
                .then()
                .statusCode(401);
    }

    @Test
    public void Overview() {
        given()
                .when()
                .get("overview.htm")
                .then()
                .statusCode(500);
    }

    @Test
    public void transferFunds() {
        given()
                .when()
                .post("services_proxy/bank/transfer?fromAccountId=43532&toAccountId=45325&amount=77")
                .then()
                .statusCode(401);
    }

    @Test
    public void MonthlyAcctActivity() {
        given()
                .when()
                .get("services_proxy/bank/accounts/432543/transactions/month/All/type/All")
                .then()
                .statusCode(401);

    }

}
