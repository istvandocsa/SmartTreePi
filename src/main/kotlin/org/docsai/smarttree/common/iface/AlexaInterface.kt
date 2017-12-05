package org.docsai.smarttree.common.iface

abstract class AlexaInterface {
    val type: String
        get() = "AlexaInterface"
    val version: String
        get() = "3"
    abstract val `interface`: String
    abstract val properties: InterfaceProperties<Map<String, String>>
    val proactivelyReported: Boolean = false
    val retrievable: Boolean = false
}