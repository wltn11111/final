plugins {
    id("org.siouan.frontend-jdk11") version "6.0.0"
}

frontend {
    nodeDistributionProvided.set(true)
    yarnEnabled.set(true)
    yarnVersion.set("1.22.19")

    assembleScript.set("run build")
    checkScript.set("run test")
}