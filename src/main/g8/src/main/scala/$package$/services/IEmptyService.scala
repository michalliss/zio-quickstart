package $package$

import zio._

trait IEmptyService:
  def doWork(): ZIO[Any, Throwable, String];

object IEmptyService:
  case class EmptyServiceLive() extends IEmptyService:
    override def doWork(): ZIO[Any, Throwable, String] = ZIO.succeed("hello")

  lazy val live = ZLayer.fromZIO(ZIO.succeed(EmptyServiceLive()))
