package com.sksamuel.elastic4s.searches.queries

import org.elasticsearch.index.query.QueryBuilders

case class TypeQueryDefinition(`type`: String) extends QueryDefinition {
  val builder = QueryBuilders.typeQuery(`type`)
}
