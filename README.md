[![Build status](https://ci.appveyor.com/api/projects/status/2pykuorxilg3jfss/branch/master?svg=true)](https://ci.appveyor.com/project/Zoltu/gradle-plugin-simplegradlepluginpublish/branch/master)

# Description
A simplification of the gradle publish plugin.  This is a thin wrapper around the official [plugin-publish](https://plugins.gradle.org/docs/publish-plugin).  For general information about publishing plugins to the gradle plugin repository, check out the [official instructions](https://plugins.gradle.org/docs/submit), just replace step 4 with the usage instructions below.

Differences between this and the official plugin:
* This plugin allows you to provide your gradle publish credentials via any mechanism you desire.
* This plugin doesn't require you to have a tripply nested section for plugin ID and Display Name.
* This plugin doesn't require you provide two URLs that are often the same (VCS and Website).
* The official plugin allows you to publish multiple plugins from a single build script.
* The officila plugin allows you to have a separate website and VCS link.

## Usage
1. Apply the plugin per the instructions [here](https://plugins.gradle.org/plugin/com.zoltu.simple-gradle-plugin-publisher)
1. Add a block like the following to your `build.gradle`:

	```groovy
	simpleGradlePluginPublishConfiguration {
		gradlePublishKey = System.getenv('GRADLE_PUBLISH_KEY')
		gradlePublishSecret = System.getenv('GRADLE_PUBLISH_SECRET')
		vcsUrl = 'https://github.com/Me/MyRepo'
		id = 'namespace.name'
		displayName = 'An unconstrained string.'
		description = 'A long unconstrained string.'
		tags = ['foo', 'bar', 'baz']
	}
	```
1. Execute the `publishPlugins` task.
