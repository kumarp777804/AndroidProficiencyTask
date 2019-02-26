pipeline {
  agent any
 // options {
    // Stop the build early in case of compile or test failures
 //   skipStagesAfterUnstable()
 // }
  stages {
    stage('Build') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew clean --info'
      }
    }
    stage('Sonar') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew assembleDebug --info'
      }
    }
    stage('Testing') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew assembleDebug --info'
      }
    }
    stage('deployment') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew assembleDebug --info'
      }
    }
    
  }
 
}
