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
