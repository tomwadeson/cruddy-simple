package cruddysimple

import org.http4s.server.blaze.BlazeBuilder

object CruddySimpleServer extends App {

  BlazeBuilder
    .bindHttp(8080)
    .mountService(CruddySimpleService.service, "/")
    .run
    .awaitShutdown()
}
