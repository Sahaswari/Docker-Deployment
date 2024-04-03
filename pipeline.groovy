pipeline{
  agent.any

  stages{
    stage('Dockerize the application'){
      stage{
        script{
          sh 'docker build -t sample .'
        }
      }
    }
    stage('Verify the image'){
      stage{
        script{
          sh 'docker images'
        }
      }
    }
    stage('Run the docker image'){
      stage{
        script{
          sh 'docker run --name flask_app  -p 8000:5000 sample'
        }
      }
    }
  }
}
