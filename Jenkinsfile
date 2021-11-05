pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }

 stage('Build') {
    withSonarQubeEnv('sonar') {
      def mvnHome = tool 'maven-3.5.0'
      sh "'${mvnHome}/bin/mvn' -f backend/pom.xml clean package sonar:sonar"
    }
  }
}

stage("Quality Gate") { 
  timeout(time: 5, unit: 'MINUTES') { 
    def qualityGate = waitForQualityGate() 
      if (qualityGate.status != 'OK') {
        error "O código não está de acordo com as regras do Sonar: ${qualityGate.status}"
      }
  }
}
