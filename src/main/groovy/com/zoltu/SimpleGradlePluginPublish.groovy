package com.zoltu

import com.gradle.publish.PublishPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class SimpleGradlePluginPublish implements Plugin<Project> {
	void apply(Project project) {
		if (project == null) return

		// apply the official publish plugin
		project.plugins.apply(PublishPlugin)

		// create the configuration closure that users will populate
		project.extensions.create("simpleGradlePluginPublishConfiguration", SimpleGradlePluginPublishConfiguration)

		// migrate configuration to official plugin before publishPlugins runs
		project.tasks.findByPath("publishPlugins").doFirst { task ->
			if (project.simpleGradlePluginPublishConfiguration.gradlePublishKey == null) throw new Exception("You must include a gradlePublishKey on simpleGradlePluginPublishConfiguration")
			if (project.simpleGradlePluginPublishConfiguration.gradlePublishSecret == null) throw new Exception("You must include a gradlePublishSecret on simpleGradlePluginPublishConfiguration")
			if (project.simpleGradlePluginPublishConfiguration.description == null) throw new Exception("You must include a description on simpleGradlePluginPublishConfiguration")
			if (project.simpleGradlePluginPublishConfiguration.tags == null) throw new Exception("You must include a tags on simpleGradlePluginPublishConfiguration")
			if (project.simpleGradlePluginPublishConfiguration.vcsUrl == null) throw new Exception("You must include a vcsUrl on simpleGradlePluginPublishConfiguration")
			if (project.simpleGradlePluginPublishConfiguration.id == null) throw new Exception("You must include a id on simpleGradlePluginPublishConfiguration")
			if (project.simpleGradlePluginPublishConfiguration.displayName == null) throw new Exception("You must include a displayName on simpleGradlePluginPublishConfiguration")

			System.setProperty("gradle.publish.key", project.simpleGradlePluginPublishConfiguration.gradlePublishKey)
			System.setProperty("gradle.publish.secret", project.simpleGradlePluginPublishConfiguration.gradlePublishSecret)
			project.pluginBundle {
				description = project.simpleGradlePluginPublishConfiguration.description
				tags = project.simpleGradlePluginPublishConfiguration.tags
				vcsUrl = project.simpleGradlePluginPublishConfiguration.vcsUrl
				website = project.simpleGradlePluginPublishConfiguration.vcsUrl
				plugins {
					foo {
						id = project.simpleGradlePluginPublishConfiguration.id
						displayName = project.simpleGradlePluginPublishConfiguration.displayName
					}
				}
			}
		}
	}
}
