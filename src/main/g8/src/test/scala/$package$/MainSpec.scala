package $package$

import zio._
import zio.test._
import io.github.scottweaver.zio.testcontainers.postgres.ZPostgreSQLContainer
import javax.sql.DataSource
import com.dimafeng.testcontainers.PostgreSQLContainer

object MainSpec extends JUnitRunnableSpec:

  def spec = suite("Test environment")(
    test("Assertions work") {
      assert(40 + 2)(equalTo(42))
    },
    test("Testcontainers work") {
      for {
        ds <- ZIO.service[DataSource]
        pg <- ZIO.service[PostgreSQLContainer]
        _  <- Console.printLine(s"Container ip: \${pg.containerIpAddress}").orDie
      } yield assertTrue(true)
    }.provide(ZPostgreSQLContainer.Settings.default, ZPostgreSQLContainer.live)
  )
