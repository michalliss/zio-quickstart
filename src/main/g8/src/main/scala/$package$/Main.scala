package $package$

import zio._
import main.services.IEmptyService

object Main extends ZIOAppDefault:

  lazy val app =
    for
      service <- ZIO.service[IEmptyService]
      result  <- service.doWork()
      _       <- Console.printLine(s"Result: \${result}")
    yield ()

  def run = app.provide(IEmptyService.live)
