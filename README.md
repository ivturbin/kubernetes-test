# Spring Boot Kubernetes Deployment on Windows with Minikube

This is a test project where I locally deploy a Spring Boot Java application into a Minikube environment running on Windows. The project contains a simple test controller with one endpoint. The Dockerfile builds and runs the project inside a Docker container, which was successfully tested locally with Docker Desktop.

## Getting Started

### 0. Project Setup
- Created a test Spring Boot application with a simple test controller.
- Added a `Dockerfile` with a `docker run` command to build and run the application in a container.
- Successfully ran the container locally using Docker Desktop.

### 1. Installing Chocolatey
To manage installations on Windows, I used [Chocolatey](https://docs.chocolatey.org/en-us/choco/setup/) to simplify the setup process.

### 2. Installing kubectl
Installed kubectl following the instructions from the official Kubernetes docs: [Install kubectl](https://kubernetes.io/ru/docs/tasks/tools/install-kubectl/)
```bash
choco install kubernetes-cli
```

### 3. Installing Minikube
Installed Minikube locally on Windows. You can find the instructions I followed here: [Install Minikube](https://kubernetes.io/ru/docs/tasks/tools/install-minikube/).
```bash
choco install minikube
```

### 4. Starting Minikube and Using kubectl 
After installing Minikube, I followed this simple guide to start working with kubectl and Minikube: [Minikube Setup](https://kubernetes.io/ru/docs/setup/learning-environment/minikube/).
```bash
minikube start
kubectl get po -A
```

### Why Windows?
I prefer doing everything on Windows! Forget the devops folks with Linux and the overpriced developers on Macs. Windows is the real hardcore platform for developers. 😎
