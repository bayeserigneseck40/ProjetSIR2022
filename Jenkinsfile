pipeline{
    agent any
  tools{
    maven "3.6.3"
  }
  stages{
    stage('source'){
      steps{
        git branch:'main',url: 'https://github.com/bayeserigneseck40/ProjetSIR2022.git'
      }
      
    }
    stage('build'){
        steps{
                  bat 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
        }
    }
    stage('SonarQube Analysis'){
        steps{
              bat 'mvn sonar:sonar'
        }
    }
     
  }
}