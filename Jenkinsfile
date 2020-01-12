pipeline {
    agent any
//     agent {
//         docker {
//             image 'maven:3-alpine'
//             args '-v /root/.m2:/root/.m2'
//         }
//     }
        tools {
            Maven 'maven'
            Docker 'docker'
        }
    stages {
        stage('test java installation') {
            steps {
                sh 'java -version'
                sh 'which java'
            }
        }
        stage('test maven installation') {
            steps {
                sh 'mvn -version'
                sh 'which mvn'
            }
        }
        stage('test docker installation') {
            steps {
                sh 'docker --version'
                sh 'which docker'
            }
        }
//         stage('Initialize'){
//             def dockerHome = tool 'docker'
//             env.PATH = "${dockerHome}/bin:${env.PATH}"
//         }
        stage('Build Application') {
            steps {
                echo '=== Building Application ==='
//                 def mvnHome = tool 'mvn'
//                 env.PATH = "${dockerHome}/bin:${env.PATH}"
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