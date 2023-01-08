pipeline{
    agent any
   
                   stage('gitclone') {

        			steps {
        				 git branch: 'main', url: 'https://github.com/bayeserigneseck40/ProjetSIR2022.git'
        			}
        		}

        		stage('dockerBuild') {

        			steps {
        				bat 'docker build -t projetsir2022/projet2022 .'
        			}
        		}

        		stage('Build tag') {

        			steps {
        				bat 'docker tag  projetsir2022/projet2022  projetsir2022/groupe2:latest '
        			}
        		}

        		stage('Push') {

        			steps {
        				withDockerRegistry([credentialsId: "docker-hub" ,url:"" ]){
        				bat 'docker push projetsir2022/projet2022:groupe2'
        				}
        			}
        		}

    } // stages
  post{ 
    aborted{
    echo "Sending message to agent"
    }
    failure{
      echo "Sending message to agent"
    }
  }





}
