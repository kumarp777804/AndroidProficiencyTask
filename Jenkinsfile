pipeline {
  agent any
 // options {
    // Stop the build early in case of compile or test failures
 //   skipStagesAfterUnstable()
 // }
  stages {
    stage('Clean') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew clean --info'
      }
    }
    stage('Compile') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew assembleDebug --info'
      }
    }
    
  }
 
}
