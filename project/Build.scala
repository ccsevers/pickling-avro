import sbt._
import Keys._

import org.scalastyle.sbt.ScalastylePlugin

import com.typesafe.sbt.SbtScalariform._
import scalariform.formatter.preferences._

object PicklingavroBuild extends Build {

  lazy val root = Project(
    id = "root",
    base = file("."),
    settings = commonSettings
  ) aggregate(
    binary
  )

  lazy val binary = Project(
    id = "pickling-avro-binary",
    base = file("binary"),
    settings = commonSettings
  )

  lazy val commonSettings = Project.defaultSettings ++
                            ScalastylePlugin.Settings ++
                            scalariformSettings ++
                            customFormatSettings

  def customFormatSettings = Seq(
    ScalariformKeys.preferences := FormattingPreferences()
      .setPreference(IndentWithTabs, false)
      .setPreference(IndentSpaces, 2)
      .setPreference(DoubleIndentClassDeclaration, true)
      .setPreference(MultilineScaladocCommentsStartOnFirstLine, false)
      .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, true)
      .setPreference(PreserveDanglingCloseParenthesis, true)
      .setPreference(CompactControlReadability, true)
      .setPreference(AlignSingleLineCaseStatements, true)
      .setPreference(PreserveSpaceBeforeArguments, true)
      .setPreference(SpaceBeforeColon, false)
      .setPreference(SpaceInsideBrackets, false)
      .setPreference(SpaceInsideParentheses, false)
      .setPreference(SpacesWithinPatternBinders, true)
      .setPreference(FormatXml, true)
  )

}
