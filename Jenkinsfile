pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }

stages {
stage('Scan') {
steps {
withSonarQubeEnv(installationName: 'sonar') {
  mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar }

      }
    }
  }
}
