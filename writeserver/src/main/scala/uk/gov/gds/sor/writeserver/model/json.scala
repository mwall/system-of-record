package uk.gov.gds.sor.writeserver.model

import spray.json.DefaultJsonProtocol

object JsonProtocols extends DefaultJsonProtocol {
  implicit val schemaFormat = jsonFormat2(Schema)
}
