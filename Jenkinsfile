pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        // Compile the app and its dependencies
        bat  './gradlew clean --info'
      }
    }
    stage('BuildInstall'){
      steps{
        bat 'chmod +x gradlew && ./gradlew --no-daemon --stacktrace clean :app:assembleDebug :app:assembleDebugAndroidTest'
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
