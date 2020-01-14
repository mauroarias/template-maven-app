pipeline {
    agent any
        tools {
            maven 'maven3'
        }
        triggers {
            pollSCM "* * * * *"
        }
        options {
            timestamps()
            ansiColor("xterm")
        }
    stages {
        stage('test setup') {
            steps {
                sh 'java -version'
                sh 'which java'
                sh 'mvn -version'
                sh 'which mvn'
                sh 'docker-compose --version'
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
//         stage('getting current version') {
//             steps {
//                 echo '=== getting version ==='
//                 sh 'export VERSION=$(mvn help:evaluate -Dexpression=project.version | grep -v "\[")'
//             }
//         }
        stage('Build Docker Image') {
            when {
                branch 'master'
            }
            steps {
                echo '=== Building Docker Image ==='
                sh 'mvn fabric8:build'
            }
        }
//         stage('create tag') {
//             when {
//                 branch 'master'
//             }
//             steps {
//                 echo '=== create git tag ==='
//                 sh 'export VERSION=$(mvn help:evaluate -Dexpression=project.version | grep -v "\[")'
//                 sh 'git tag -a v$VERSION -m "taging version $VERSION"'
//             }
//         }
//         stage('create tag') {
//             when {
//                 branch 'master'
//             }
//             steps {
//                 echo '=== create git tag ==='
//                 sh 'export VERSION=$(mvn help:evaluate -Dexpression=project.version | grep -v "\[")'
//                 sh 'git tag -a v$VERSION -m "taging version $VERSION"'
//             }
//         }


//         mvn help:evaluate -Dexpression=project.version | grep -v '\['
//         stage("prepare next version") {
//             when {
//                 expression { params.RELEASE }
//             }
//             steps {
//             }
//         }





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