package uk.gov.gds.sor.writeserver

import org.specs2.mutable.Specification
import spray.http.StatusCodes._
import spray.testkit.Specs2RouteTest
import uk.gov.gds.sor.writeserver.model.Schema

class CreateSchemaSpec extends Specification with Specs2RouteTest with SchemaService {
  def actorRefFactory = system
  
  "Schema creation service" should {

    "Not have any schemas present when we first hit it" in {
      Get("/schema") ~> myRoute ~> check {
        responseAs[List[Schema]] must contain("Say hello")
      }
    }

//    "leave GET requests to other paths unhandled" in {
//      Get("/kermit") ~> myRoute ~> check {
//        handled must beFalse
//      }
//    }
//
//    "return a MethodNotAllowed error for PUT requests to the root path" in {
//      Put() ~> sealRoute(myRoute) ~> check {
//        status === MethodNotAllowed
//        responseAs[String] === "HTTP method not allowed, supported methods: GET"
//      }
//    }
  }
}
