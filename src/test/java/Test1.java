//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//import org.junit.Test;
//
//public class Test1 {

//    @Test
//    public void testGetUsers() {
//        given()
//                .when()
//                .log().all()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200)
//                .body("page", notNullValue())
//                .body("per_page", notNullValue())
//                .body("total", notNullValue())
//                .body("data.id", not(hasItem(nullValue())));
//    }
//}
