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
                  sh 'mvn clean package'
        }
        

    }
  }
}
