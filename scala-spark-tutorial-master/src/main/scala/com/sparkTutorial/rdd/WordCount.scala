package com.sparkTutorial.rdd

import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark._

object WordCount {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.INFO)

    val conf = new SparkConf()
              .setAppName("wordCounts")
              .setMaster("local[3]")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("in/word_count.text")  // dataset
    val words = lines
                .flatMap(line => line.split(" "))

    val wordCounts = words.countByValue()   // tuple
    for ((word, count) <- wordCounts) println(word + " : " + count)

  }
}
