import scalariform.formatter.preferences._

name := "leetcode"
version := "1.0"
scalaVersion := "2.13.1"

scalariformPreferences := scalariformPreferences.value
    .setPreference(AlignSingleLineCaseStatements, true)
    .setPreference(DoubleIndentConstructorArguments, true)
    .setPreference(DanglingCloseParenthesis, Preserve)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.1" % "test"

findbugsReportType := Some(FindbugsReport.Html)

addCommandAlias("lint", "scalastyle")
