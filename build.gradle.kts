plugins {
    kotlin("jvm") version "2.4.10"
    application
}

kotlin {
    jvmToolchain(17)
}

// Every submission declares `class Solution` (or MinStack, TimeMap, ...), so they cannot be
// compiled together. Only one submission is compiled at a time, chosen with:
//
//   ./gradlew run -Pproblem=binary-search                  -> latest submission-N.kt
//   ./gradlew run -Pproblem=binary-search -Psubmission=0   -> submission-0.kt
//
// Any other .kt file in the problem folder (e.g. Main.kt with `fun main()`) is compiled
// alongside it. Without -Pproblem, the `playground/` folder is used.
val problem = providers.gradleProperty("problem").orNull
val submission = providers.gradleProperty("submission").orNull
val submissionRegex = Regex("""submission-(\d+)\.kt""")

sourceSets.main {
    java.setSrcDirs(emptyList<Any>())
    resources.setSrcDirs(emptyList<Any>())
    kotlin.setSrcDirs(listOf("playground"))
    kotlin.include("**/*.kt")
}

if (problem != null) {
    val dir = rootDir.listFiles().orEmpty()
        .map { File(it, problem) }
        .firstOrNull { it.isDirectory }
        ?: throw GradleException("Problem folder '$problem' not found")

    val submissions = dir.listFiles { f -> submissionRegex.matches(f.name) }.orEmpty()
        .sortedBy { submissionRegex.matchEntire(it.name)!!.groupValues[1].toInt() }
    if (submissions.isEmpty()) throw GradleException("No Kotlin submissions in '$dir'")

    val chosen = if (submission == null) submissions.last()
    else submissions.find { it.name == "submission-$submission.kt" }
        ?: throw GradleException("submission-$submission.kt not found in '$dir'")

    logger.lifecycle("Compiling ${chosen.relativeTo(rootDir)}")

    // NeetCode's editor implicitly imports java.util.* (PriorityQueue, Stack.peek, ...),
    // so compile a copy of the submission with that import prepended.
    val prepareSubmission = tasks.register("prepareSubmission") {
        val output = layout.buildDirectory.dir("submission")
        inputs.file(chosen)
        outputs.dir(output)
        doLast {
            val outDir = output.get().asFile.apply { deleteRecursively(); mkdirs() }
            File(outDir, "Submission.kt").writeText("import java.util.*\n\n" + chosen.readText())
        }
    }

    sourceSets.main {
        kotlin.setSrcDirs(listOf(dir))
        kotlin.srcDir(prepareSubmission)
        kotlin.exclude { submissionRegex.matches(it.name) }
    }
}

application {
    mainClass = "MainKt"
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
