pipeline{
 agent any 
 stages{
  stage('build'){
   steps{
    bat 'docker build -t bayeserigneseck/myrepository:""$BUILD_ID"" .'
   }
  }
  stage('Publish'){
   steps{
    witnDockerRegistry([credentialsId: "docker-hub", url:"" ]){
     bat 'docker push bayeserigneseck/myrepository:""$BUILD_ID"" '
    }
   }
  }
 }
}
