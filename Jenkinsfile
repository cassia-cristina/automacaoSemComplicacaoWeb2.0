pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }

stages {
stage('Scan') {
steps {
withSonarQubeEnv(installationName: 'sonar') {
 mvn clean install
 mvn sonar:sonar -Dsonar.login=5f2ba8c86038bc20d95c12ae1fa54d089f5b11ee }

      }
    }
  }
}
