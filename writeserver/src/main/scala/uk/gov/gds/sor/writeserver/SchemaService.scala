package uk.gov.gds.sor.writeserver

import java.util.Date

import spray.http.MediaTypes._
import spray.httpx.SprayJsonSupport
import spray.routing._
import uk.gov.gds.sor.sprayserver.ServiceActor
import uk.gov.gds.sor.writeserver.model.Schema

class SchemaServiceActor extends ServiceActor with SchemaService {
  def receive = runRoute(myRoute)
}

// this trait defines our service behavior independently from the service actor
trait SchemaService extends HttpService with SprayJsonSupport {

  import uk.gov.gds.sor.writeserver.model.JsonProtocols._

  val myRoute =
    path("schema") {
      get {
        respondWithMediaType(`application/json`) {
          complete {
            val result: Schema = Schema(name = "foo", creationTimstamp = new Date().getTime)

            result
          }
        }
      }
    }
}