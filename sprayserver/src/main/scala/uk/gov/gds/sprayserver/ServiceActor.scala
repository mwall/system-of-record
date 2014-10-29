package uk.gov.gds.sor.sprayserver

import akka.actor.Actor

trait ServiceActor extends Actor {
  def actorRefFactory = context
}

