package com.zoltu

import org.jetbrains.spek.api.Spek
import kotlin.test.assertFails

class SimpleGradlePluginPublishTests : Spek() {
	init {
		given("a plugin") {
			val plugin = SimpleGradlePluginPublish()

			on("calling apply") {

				it("throws an exception") {
					assertFails { plugin.apply(null) }
				}
			}
		}
	}
}
