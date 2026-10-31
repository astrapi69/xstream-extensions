# Overview

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/xstream-extensions/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/xstream-extensions/actions/workflows/gradle.yml)
[![Coverage Status](https://codecov.io/gh/astrapi69/xstream-extensions/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/xstream-extensions)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/xstream-extensions.svg?style=flat)](https://github.com/astrapi69/xstream-extensions/issues)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.astrapi69/xstream-extensions)](https://central.sonatype.com/artifact/io.github.astrapi69/xstream-extensions)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/xstream-extensions.svg)](http://www.javadoc.io/doc/io.github.astrapi69/xstream-extensions)
[![MIT License](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/xstream-extensions?branch=develop)](https://hitsofcode.com/github/astrapi69/xstream-extensions/view?branch=develop)

</div>

Transform objects with xstream to xml and back.

> Please support this project by simply putting a Github <!-- Place this tag where you want the button to render. -->
<a class="github-button" href="https://github.com/astrapi69/xstream-extensions" data-icon="octicon-star" aria-label="Star astrapi69/xstream-extensions on GitHub">
> Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this
>
project [![donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

## Note

No animals were harmed in the making of this library.

## License

The source code comes under the liberal MIT License, making xstream-extensions great for all types of applications.

## gradle dependency

Replace the variable ${latestVersion} with the current latest
version: [![Maven Central](https://img.shields.io/maven-central/v/io.github.astrapi69/xstream-extensions)](https://central.sonatype.com/artifact/io.github.astrapi69/xstream-extensions)

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of xstream-extensions:

define version in file gradle.properties

```
xstreamExtensionsVersion=${latestVersion}
```

or in build.gradle ext area

```
    xstreamExtensionsVersion = "${latestVersion}"
```

then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:xstream-extensions:$xstreamExtensionsVersion")
```

## Maven dependency

The library is on Maven Central. Check out [Maven Central](https://central.sonatype.com/artifact/io.github.astrapi69/xstream-extensions) for the latest release.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of xstream-extensions:

Than you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- xstream-extensions version -->
        <xstream-extensions.version>${latestVersion}</xstream-extensions.version>
            ...
    </properties>
            ...
        <dependencies>
            ...
            <!-- xstream-extensions DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>xstream-extensions</artifactId>
                <version>${xstream-extensions.version}</version>
            </dependency>
            ...
        </dependencies>

## Support this project

If xstream-extensions is useful to you, a star on [GitHub](https://github.com/astrapi69/xstream-extensions) helps others find it.
Sharing it or reporting a bug helps just as much.

If you would like to contribute financially, the channels are on the repository's Sponsor button, which
reads [.github/FUNDING.yml](.github/FUNDING.yml): GitHub Sponsors, Liberapay, Ko-fi and PayPal.

## Semantic Versioning

The versions of xstream-extensions are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit
the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## Want to Help and improve it? ###

The source code for xstream-extensions are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/xstream-extensions/fork](https://github.com/astrapi69/xstream-extensions/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/xstream-extensions/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the xstream-extensions developers with your questions, concerns, comments, bug reports, or
feature requests.

- Feature requests, questions and bug reports can be reported at
  the [issues page](https://github.com/astrapi69/xstream-extensions/issues).

## Similar projects

## Credits
