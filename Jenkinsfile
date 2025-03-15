pipeline {
    agent  any

    environment {
        DOCKER_TAG = "V.${BUILD_NUMBER}"
        DOCKER_IMAGE_NAME = "myawesomeapp"
        DOCKER_HUB_USERNAME = "gulnaz1357"
        IMAGE_URL = "${DOCKER_HUB_USERNAME}/${DOCKER_IMAGE_NAME}:${DOCKER_TAG}"
    }


    stages {
        stage('imageBuild'){
            steps {
                sh "docker build -t ${IMAGE_URL} ."
            }
        }
        stage('imagePush'){
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh "docker login -u $USER"
                    sh "docker push ${IMAGE_URL} "
                }
            }
        }
    }
}