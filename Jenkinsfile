pipeline {
environment {
registry = "bayeserigneseck/myrepository"
registryCredential = 'docker-hub'
dockerImage = ''
}
agent any
stages {
stage('Cloning our Git') {
steps {
git 'https://github.com/bayeserigneseck40/ProjetSIR2022.git'
}
}
stage('Building our image') {
steps{

 bat 'dockerImage = docker.build bayeserigneseck/myrepository ":$BUILD_NUMBER" '
}
}
stage('Deploy our image') {
steps{

 bat 'docker.withRegistry( '', 'docker-hub' )' {
dockerImage.push()
}
}
}
stage('Cleaning up') {
steps{
bat "docker rmi $registry:$BUILD_NUMBER"
}
}
}
}
