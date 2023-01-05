pipeline{

	agent any

	environment {
		DOCKERHUB_CREDENTIALS=credentials('docker-hub')
	}

	stages {
	    
	    stage('gitclone') {

			steps {
				git 'https://github.com/bayeserigneseck40/ProjetSIR2022.gitt'
			}
		}

		stage('Build') {

			steps {
				sh 'docker build -t bayeserigneseck/myrepository:latest .'
			}
		}

		stage('Login') {

			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push') {

			steps {
				sh 'docker push bayeserigneseck/myrepository:latest'
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
