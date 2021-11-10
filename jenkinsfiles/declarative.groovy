pipeline {
    agent any
    environment {
        recipients = "o.frolov.devops@gmail.com"
    }
     
    stages {
        stage('Ok') {
            steps {
                echo "Ok"
            }
        }
    }
    post {
        always {
            emailext body: 'Build ${BUILD_STATUS}', subject: 'Test', from: 'jenkins.auto.mail.notification@gmail.com', to: "${recipients}"
        }
    }
}
