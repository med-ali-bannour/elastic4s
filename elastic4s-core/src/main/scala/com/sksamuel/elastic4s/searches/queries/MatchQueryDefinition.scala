package com.sksamuel.elastic4s.searches.queries

import com.sksamuel.elastic4s.analyzers.Analyzer
import com.sksamuel.exts.OptionImplicits._

case class MatchQueryDefinition(field: String,
                                value: Any,
                                analyzer: Option[String] = None,
                                boost: Option[Double] = None,
                                cutoffFrequency: Option[Double] = None,
                                fuzziness: Option[Double] = None,
                                fuzzyRewrite: Option[String] = None,
                                fuzzyTranspositions: Option[Boolean] = None,
                                lenient: Option[Boolean] = None,
                                maxExpansions: Option[Int] = None,
                                minimumShouldMatch: Option[String] = None,
                                op: Option[String] = None,
                                prefixLength: Option[Int] = None,
                                queryName: Option[String] = None,
                                slop: Option[Int] = None,
                                zeroTerms: Option[String] = None) extends QueryDefinition {

  def analyzer(an: String): MatchQueryDefinition = copy(analyzer = an.some)
  def analyzer(an: Analyzer): MatchQueryDefinition = copy(analyzer = an.name.some)

  @deprecated("for phrase queries use match phrase query", "5.0.0")
  def slop(s: Int): MatchQueryDefinition = copy(slop = s.some)

  def boost(boost: Double): MatchQueryDefinition = copy(boost = boost.some)
  def cutoffFrequency(f: Double): MatchQueryDefinition = copy(cutoffFrequency = f.some)
  def lenient(lenient: Boolean): MatchQueryDefinition = copy(lenient = lenient.some)
  def fuzziness(fuzziness: Double): MatchQueryDefinition = copy(fuzziness = fuzziness.some)
  def fuzzyRewrite(fuzzyRewrite: String): MatchQueryDefinition = copy(fuzzyRewrite = fuzzyRewrite.some)
  def prefixLength(prefixLength: Int): MatchQueryDefinition = copy(prefixLength = prefixLength.some)

  @deprecated("use lenient(Boolean)", "5.0.0")
  def setLenient(l: Boolean): MatchQueryDefinition = lenient(l)

  def fuzzyTranspositions(f: Boolean): MatchQueryDefinition =
    copy(fuzzyTranspositions = f.some)

  def maxExpansions(max: Int): MatchQueryDefinition = copy(maxExpansions = max.some)

  def minimumShouldMatch(min: String): MatchQueryDefinition = copy(minimumShouldMatch = min.some)

  def withAndOperator() = operator("AND")
  def withOrOperator() = operator("OR")
  def operator(op: String): MatchQueryDefinition = copy(op = op.some)

  def queryName(queryName: String): MatchQueryDefinition = copy(queryName = queryName.some)

  def zeroTermsQuery(zeroTerms: String): MatchQueryDefinition = copy(zeroTerms = zeroTerms.some)
}
