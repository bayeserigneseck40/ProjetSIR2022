pipeline{

	agent any


	stages {
	    
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
		
		stage('Build deployment') {

			steps {
				bat 'kubectl create deployment projetsir2022main --image=projetsir2022/projet2022 '
				bat 'kubectl expose deployment projetsir2022main --type=NodePort --port 8085 '
				
			}
		}
	   }

	post {
		always {
			bat 'docker logout'
		}
	}

}
