pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew clean build --info'
      }
    }
    
    
    stage('Sonar') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew --info sonarqube'
      }
    }
    
    
    stage('Testing') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew clean --info'
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
