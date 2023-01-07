pipeline{
    agent any
    tools{
        maven "3.6.3"
    }
    stages{
        stage('Source') {
            steps{
                git branch: 'main', url: 'https://github.com/bayeserigneseck40/ProjetSIR2022.git'
            }
        }
        stage ('Build') {
            steps{
                bat 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install'
            }
        }
        stage ('SonarQube Analysis') {
            steps{
                bat 'mvn sonar:sonar'
            }
        }

            stage ('Deploy') {
                    input{
                        message 'voulez vous faire le deployment'
                    }
                    steps{
                    bat 'echo "Build termine"'
                    }
                }
                    stage ('Notifier') {
                            steps{
                                bat 'echo "Build termine"'
                            }
                        }
                   stage('gitclone') {

        			steps {
        				 git branch: 'main', url: 'https://github.com/bayeserigneseck40/ProjetSIR2022.git'
        			}
        		}

        		stage('Build') {

        			steps {
        				bat 'docker build -t projetsir2022/projet2022 .'
        			}
        		}


        		stage('Build tag') {

        			steps {
        				bat 'docker tag  projetsir2022/projet2022  projetsir2022/projet2022:groupe2 '
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

post {
		always {
			bat 'docker logout'
		}
	}



}
