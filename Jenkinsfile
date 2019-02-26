pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew clean --info'
      }
    }
    wrap([$class: 'TimestamperBuildWrapper']) {
    build
}
    
    
    
    
    
  }
 
}
