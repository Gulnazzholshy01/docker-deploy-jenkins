pipeline {
    agent  any

    environment {
        DOCKER_TAG = "V.${BUILD_NUMBER}"
        DOCKER_IMAGE_NAME = "myawesomeapp"
        DOCKER_HUB_USERNAME = "gulnaz1357"
    }


    stages {
        stage('imageBuild'){
            steps {
                sh "docker build -t ${DOCKER_HUB_USERNAME}/${DOCKER_IMAGE_NAME}:${DOCKER_TAG} ."
            }

        }


        // stage('imagePush'){

        // }


        // stage('imageRemove'){

        // }
    }
 
}