package org.docsai.smarttree.common.iface

abstract class AlexaInterface {
    val type: String
        get() = "AlexaInterface"
    val version: String
        get() = "3"
    abstract val `interface`: String
}