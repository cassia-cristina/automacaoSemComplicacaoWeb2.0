pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }

stages {
stage('SonarQube analysis') {
steps {
withSonarQubeEnv(installationName: 'sonar') {
  sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar' }

      }
    }
  }
}
