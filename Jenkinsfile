pipeline{
    agent any
    stages{
                stage('gitclone') {

        			steps {
        				 git branch: 'main', url: 'https://github.com/bayeserigneseck40/ProjetSIR2022.git'
        			}
        		}

        		stage('dockerBuild') {

        			steps {
        				bat 'docker build -t projetsir2022/groupe2 .'
        			}
        		}

        		stage('Build tag') {

        			steps {
        				bat 'docker tag  projetsir2022/groupe2  projetsir2022/groupe2:latest '
        			}
        		}

        		stage('Push') {

        			steps {
        				withDockerRegistry([credentialsId: "docker-hub" ,url:"" ]){
        				bat 'docker push projetsir2022/groupe2:latest'
        				}
        			}
        		}

    } // stages
 
}
