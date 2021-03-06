package com.intel.analytics.zoo.pipeline.deepspeech2.util

import scopt.OptionParser


object parser {
  val parser = new OptionParser[DeepSpeech2InferenceParam]("DeepSpeech2 Inference") {
    head("DS2 inference example")
    opt[String]('d', "dataPath")
      .text("data path (.wav or .flac files). Both local file and HDFS are accepted.")
      .action((v, p) => p.copy(dataPath = v))
      .required()
    opt[String]('m', "modelPath")
      .text("Path to load the model. For instance: /path/ds2.model")
      .action((v, p) => p.copy(modelPath = v))
      .required()
    opt[Int]('p', "partitionNum")
      .text("partition number. Default is 4.")
      .action((v, p) => p.copy(partition = v))
    opt[Int]('n', "num")
      .text("file number. Default is 8")
      .action((v, p) => p.copy(numFile = v))
    opt[Int]('s', "segment")
      .text("audio segment length in seconds. Default is 30")
      .action((v, p) => p.copy(segment = v))
  }
}

case class DeepSpeech2InferenceParam(
  dataPath: String = null,
  modelPath: String = null,
  partition: Int = 4,
  numFile: Int = 8,
  segment: Int = 30)
