def call(String Project, String ImageTag, String DockerHubUser){
  echo "This is pushing the image to Docker Hub"
  withCredentials([
      usernamePassword(
      credentialsId:"dockerHubCred", 
      passwordVariable:"dockerHubPass", 
      usernameVariable:"dockerHubUser")
  ]){
      sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
      sh "docker image tag notes-app:latest ${env.dockerHubUser}/notes-app:latest"
      sh "docker push ${env.dockerHubUser}/notes-app:latest"
  }
}
