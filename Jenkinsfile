pipeline {
    agent any

    environment {
        ALLURE_RESULTS = 'build/allure-results'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

//         stage('Build and Test') {
//             steps {
//                 echo 'Running Gradle via gradlew.bat...'
//                 bat 'gradlew.bat clean test'
//             }
//         }

        stage('Create  new file'){
        steps{
                            script {
                                 writeFile file: 'hello.txt', text: 'Hello from Jenkins!'
                            }
        }
        }
        stage('Allure Report') {
            steps {
                allure includeProperties: false,
                       jdk: '',
                       results: [[path: "${env.ALLURE_RESULTS}"]]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/build/allure-results/**/*', fingerprint: true
            archiveArtifacts artifacts: 'hello.txt', fingerprint: true
        }

        failure {
            echo 'Build failed.'
        }

        success {
            echo 'Build succeeded.'
        }
    }
}
