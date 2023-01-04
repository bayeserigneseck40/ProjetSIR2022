pipeline{
    agent any
    stages{
        stage('Build') {
            steps{
                bat 'docker build -t myrepository/myrepositorydemo:""$BUILD_ID"" .'
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
