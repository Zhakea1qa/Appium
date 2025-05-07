pipeline {
    agent any

    tools {
        gradle 'Gradle_8'
    }

    environment {
        ALLURE_RESULTS = 'build/allure-results'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                echo 'Running tests on Windows...'
                bat 'gradlew.bat clean test'
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
        }

        failure {
            echo 'Build failed.'
        }

        success {
            echo 'Build succeeded.'
        }
    }
}
