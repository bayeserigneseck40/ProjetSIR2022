pipeline{
    agent any
    stages{
        stage('Build') {
            steps{
                bat 'docker build -t bayeserigneseck/myrepository:""$BUILD_ID"" .'
            }
        }
        stage ('publish') {
            steps{
                  withDockerRegistry([credentialsId:"docker-hub",url:"" ]){
                  bat 'docker push myrepository/myrepositorydemo:""$BUILD_ID"" '
            }
                
            }
        }

    } // stages



}
