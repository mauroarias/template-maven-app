pipeline {
    agent any
        tools {
            maven 'maven3'
        }
    stages {
        stage('Initialize'){
            def dockerHome = tool 'myDocker'
             env.PATH = "${dockerHome}/bin:${env.PATH}"
        }
        stage('test setup') {
            steps {
                sh 'java -version'
                sh 'which java'
                sh 'mvn -version'
                sh 'which mvn'
                sh 'docker --version'
                sh 'which docker'
            }
        }
        stage('Build Application') {
            steps {
                echo '=== Building Application ==='
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test Application') {
            steps {
                echo '=== Testing Application ==='
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Build Docker Image') {
            when {
                branch 'master'
            }
            steps {
                echo '=== Building Docker Image ==='
                script {
                    app = docker.build("mauroarias/template-maven-app")
                }
            }
        }
//         stage('Push Docker Image') {
//             when {
//                 branch 'master'
//             }
//             steps {
//                 echo '=== Pushing Petclinic Docker Image ==='
//                 script {
//                     GIT_COMMIT_HASH = sh (script: "git log -n 1 --pretty=format:'%H'", returnStdout: true)
//                     SHORT_COMMIT = "${GIT_COMMIT_HASH[0..7]}"
//                     docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials') {
//                         app.push("$SHORT_COMMIT")
//                         app.push("latest")
//                     }
//                 }
//             }
//         }
//         stage('Remove local images') {
//             steps {
//                 echo '=== Delete the local docker images ==='
//                 sh("docker rmi -f ibuchh/petclinic-spinnaker-jenkins:latest || :")
//                 sh("docker rmi -f ibuchh/petclinic-spinnaker-jenkins:$SHORT_COMMIT || :")
//             }
//         }
    }
}