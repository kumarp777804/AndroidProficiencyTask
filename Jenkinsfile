pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew clean --info'
      }
    }
    stage('Deploy'){
      step{
       bat 'gradlew.bat clean build --info' 
      }
    }
    
 }
    
}
