fun RepositoryHandler.enableMirror() {
    all {
        if (this is MavenArtifactRepository) {
            val originalUrl = this.url.toString().removeSuffix("/")
            urlMappings[originalUrl]?.let {
                logger.lifecycle("Repository[$url] is mirrored to $it")
                this.setUrl(it)
            }
        }
    }
}

val urlMappings = mapOf(
	"https://repo1.maven.org/maven2" to "https://maven.aliyun.com/repository/central/",
	"https://plugins.gradle.org/m2" to "https://maven.aliyun.com/repository/gradle-plugin/",
	"https://repo.spring.io/libs-milestone" to "https://maven.aliyun.com/repository/spring/",
	"https://repo.spring.io/plugins-release" to "https://maven.aliyun.com/repository/spring-plugin/",
	"https://repo.grails.org/grails/core" to "https://maven.aliyun.com/repository/grails-core/",
	"https://repository.apache.org/snapshots" to "https://maven.aliyun.com/repository/apache-snapshots/",
	"https://repo.maven.apache.org/maven2" to "https://mirrors.tencent.com/nexus/repository/maven-public/",
    "https://dl.google.com/dl/android/maven2" to "https://mirrors.tencent.com/nexus/repository/maven-public/",
    "https://plugins.gradle.org/m2" to "https://mirrors.tencent.com/nexus/repository/gradle-plugins/"
)

gradle.allprojects {
    buildscript {
        repositories.enableMirror()
    }
    repositories.enableMirror()
}

gradle.beforeSettings { 
    pluginManagement.repositories.enableMirror()
    dependencyResolutionManagement.repositories.enableMirror()
}