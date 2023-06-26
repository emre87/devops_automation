pipeline {
    agent any
    tools {
        maven 'maven3'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/emre87/devops_automation']]])
                bat 'mvn clean install'
                bat 'mvn spring-boot:run'
            }
        }



        stage('Build docker image') {
            steps {
                script {
                    bat 'docker build -t emredemiralay/devops-integration .'
                }
            }
        }

     stage('Push image to Hub') {
    steps {
        script {
            withCredentials([string(credentialsId: 'docherhub-pwd', variable: 'dockerhubpwd')]) {
                bat "docker login -u emredemiralay -p %dockerhubpwd%"
            }
            bat "docker push emredemiralay/devops-integration"
        }
    }
    }


    stage('Deploy to k8s') {
    steps {
        script {
            kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'k8configpwd')
            }
        }
    }
}



}




