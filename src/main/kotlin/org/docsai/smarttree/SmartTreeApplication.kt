package org.docsai.smarttree

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["org.docsai.smarttree"])
class SmartTreeApplication {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SmartTreeApplication::class.java)
        }
    }

}