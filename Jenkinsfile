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
				bat 'docker build -t bayeserigneseck/myrepository:latest .'
			}
		}
		
		

		stage('Login') {

			steps {
				bat 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push') {

			steps {
				withDockerRegistry([credentialsId: "docker-hub" ,url:"" ]){
				bat 'docker push bayeserigneseck/myrepository:latest'
				}
			}
		}
	}

	post {
		always {
			bat 'docker logout'
		}
	}

}
