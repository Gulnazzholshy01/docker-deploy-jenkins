pipeline {
    agent any

    environment {
        EC2_IP = "54.159.95.219"
        CONTAINER_NAME = "myawesomeapp"
    }

    parameters {
        string (name: 'IMAGE_URL', defaultValue: '', description: 'Passed upstream job' )
    }

    stages {
        stage('runContainer') {
            steps {
                script{
                    sshagent(['jenkins-private-key']) {
                        def runContainer = "docker run -d -p 8080:8080 --name $CONTAINER_NAME $params.IMAGE_URL"
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@$EC2_IP $runContainer"
                    }
                }
            }
        }
    }
}


