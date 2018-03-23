package io.kotlintest.tables

import com.univocity.parsers.common.record.Record
import com.univocity.parsers.csv.CsvFormat
import io.kotlintest.matchers.gt
import io.kotlintest.runner.junit5.specs.WordSpec
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe

class CsvDataSourceTest : WordSpec() {
  init {
    "CsvDataSource" should {
      "read data from csv file" {
        val source = CsvDataSource(javaClass.getResourceAsStream("/user_data.csv"), CsvFormat())
        val table = source.createTable<Long, String, String>(
            { it: Record -> Row3(it.getLong("id"), it.getString("name"), it.getString("location")) },
            { it: Array<String> -> Headers3(it[0], it[1], it[2]) }
        )
        forAll(table) { a, b, c ->
          a shouldBe gt(0)
          b shouldNotBe null
          c shouldNotBe null
        }
      }
    }
  }
}