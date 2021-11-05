pipeline {
  agent any
  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }

 stage('Build') {
    withSonarQubeEnv('sonar') {
      mvn install
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
