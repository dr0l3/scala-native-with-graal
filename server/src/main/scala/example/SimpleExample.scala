package example

import java.io.File

import cats.effect.{ ExitCode, IO, IOApp }

object SimpleExample extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    for {
      currentDir <- IO { new File(".") }
      fileIsdir <- IO {
        currentDir.listFiles()
      }
      _ <- IO {
        fileIsdir.foreach(println)
      }
    } yield ExitCode.Success
  }
}
