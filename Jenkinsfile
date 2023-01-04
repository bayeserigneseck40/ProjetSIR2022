pipeline{
    agent any
    stages{
        stage('Build') {
            steps{
                bat 'printenv'
                bat 'docker build -t bayeserigneseck/myrepository:""$BUILD_ID"" .'
            }
        }
        stage ('publish') {
            steps{
                  withDockerRegistry([credentialsId:"docker-hub",url:"" ]){
                  bat 'docker push bayeserigneseck/myrepository:""$BUILD_ID"" '
            }
                
            }
        }

    } // stages



}
