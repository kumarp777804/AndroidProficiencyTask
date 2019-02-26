pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew clean --info'
      }
    }
    
    stage('Building'){
      steps{
       bat './gradlew compileDebug --stacktrace --info' 
      }
    }
    
    
    
  }
 
}
