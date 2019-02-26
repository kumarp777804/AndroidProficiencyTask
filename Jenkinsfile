pipeline {
  agent any
  
  stages {
    stage('Clean') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew clean --info'
      }
    }
    stage('Build'){
      steps{
       bat 'gradlew.bat clean build --debug' 
      }
    }
    stage('BuildAssemble'){
      steps{
       bat './gradlew assembleDebug --debug' 
      }
    }
    stage('BuildStack'){
      steps{
       bat './gradlew build --stacktrace' 
      }
    }
    
 }
    
}
