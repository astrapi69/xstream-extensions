## Change log
----------------------

Version 1.2-SNAPSHOT
-------------

ADDED:

- releases go to Maven Central through the Central Portal, as in the rest of the family: the
  `com.gradleup.nmcp` plugin uploads, the maintainer releases each deployment in the Portal, and a
  `RELEASE-*` tag runs the new `publish.yml`. The OSSRH staging endpoint this project published to
  is shut down, and its settings are gone; the build no longer needs OSSRH credentials to
  configure. Signing follows the key: in CI from `GPG_PRIVATE_KEY`, with `GPG_KEY_ID` naming the
  signing subkey, and a release without a key is refused (#2)
- new libs.versions.toml file for new automatic catalog versions update
- new test dependency mockito-core

CHANGED:

- update gradle to new version 8.8
- update of dependency lombok to new patch version 1.18.32
- update of gradle plugin dependency io.freefair.gradle:lombok-plugin to new minor version 8.6
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new minor version 0.51.0
- update of gradle plugin dependency org.ajoberstar.grgit:grgit-gradle to new minor version 5.2.2
- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new beta version 7.0.0.BETA1
- update of dependency xml-api to new minor version 1.4
- update of dependency xstream to new patch version 1.4.21, which fixes CVE-2024-47072; release 1.1 shipped with 1.4.19 (#4)
- update of test dependency test-object to new minor version 7.2
- update of dependency file-worker to new minor version 11.6
- update of dependency jettison to new minor version 1.5.4
- update of test dependency silly-collection to new major version 21
- update of test dependency junit-jupiter-api to new minor version 5.11.0-M2
- update of test dependency 'com.github.meanbeanlib:meanbean' to new version 3.0.0-M9

Version 1.1
-------------

ADDED:

- all required package-info.java files
- new converter class that transforms a xml file to a java object
- new extension class that transforms a xml file to a java object

CHANGED:

- update gradle to new version 7.6-rc-2
- update of gradle plugin dependency com.github.ben-manes.versions.gradle.plugin to new minor version 0.43.0
- update of gradle plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new minor version 6.11.0
- update of gradle plugin dependency io.freefair.gradle:lombok-plugin to new minor version 6.5.1
- update of dependency xml-api to new minor version 1.4
- update of dependency file-worker to new minor version 11.5.1
- update of dependency jettison to new minor version 1.5.1
- update of dependency throwable to new minor version 2.3
- update of test dependency test-object to new minor version 7.2
- update of test dependency silly-collection to new minor version 20.1
- update of test dependency junit-jupiter-api to new minor version 5.9.1

Version 1
-------------

ADDED:

- new CHANGELOG.md file created
- new converter classes for transform from xml string to object and back

Notable links:
[keep a changelog](http://keepachangelog.com/en/1.0.0/) Don’t let your friends dump git logs into changelogs
