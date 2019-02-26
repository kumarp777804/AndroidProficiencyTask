pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        // Compile the app and its dependencies
        bash  './gradlew clean --info'
      }
    }
    
    stage('Building'){
      steps{
       bash './gradlew compileDebug --stacktrace --info' 
      }
    }
    
    
    
  }
 
}
