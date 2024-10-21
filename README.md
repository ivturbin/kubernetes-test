# Spring Boot Kubernetes Deployment on Windows with Minikube

This is a test project where I locally deploy a Spring Boot Java application into a Minikube environment running on Windows. The project contains a simple test controller with one endpoint. The Dockerfile builds and runs the project inside a Docker container, which was successfully tested locally with Docker Desktop.
All the following commands run in Windows Powershell as administrator.
## Environment Setup

### 0. Chocolatey
To manage installations on Windows, I used [Chocolatey](https://docs.chocolatey.org/en-us/choco/setup/) to simplify the setup process.

### 1. Project
- A Spring Boot application with a simple test controller.
- `Dockerfile` with a `docker run` command to build and run the application in a container.
- Successfully ran the container locally using Docker Desktop.

### 2. Docker Desktop
- for images building.
```bash
choco install docker-desktop
```

### 3. kubectl
- for cluster management.
Instructions from the official Kubernetes docs: [Install kubectl](https://kubernetes.io/ru/docs/tasks/tools/install-kubectl/)
```bash
choco install kubernetes-cli
```

### 4. Minikube
- little kubernetes himself.
Docs again: [Install Minikube](https://kubernetes.io/ru/docs/tasks/tools/install-minikube/).
```bash
choco install minikube
```

## Work with Kubernetes

### 1. Build docker image
Switch your shell to use Minikube's Docker daemon first:

```bash
minikube -p minikube docker-env --shell powershell | Invoke-Expression
```
Then from the project root directory:
```bash
docker build -t kubernetes-test-image . 
```

### 2. Start Minikube
Docs: [Minikube Setup](https://kubernetes.io/ru/docs/setup/learning-environment/minikube/).
```bash
minikube start --driver=hyperv
```
Btw, you can use [Lens](https://k8slens.dev/) to observe your cluster. 
After the command ran you will be able to find a configuration file at C:\Users\{User}\.kube\config (in my case).

### 3. Configure a deployment
Go to \deploy directory and run:
```bash
kubectl apply -f .\deployment.yaml
```
Then check the result:
```bash
kubectl get pods
```
Result should be like
```bash
NAME                                          READY   STATUS    RESTARTS   AGE
kubernetes-test-deployment-6d76f759fc-nlr9f   1/1     Running   0          6m58s
```
### 4. Configure a service
In the save directory run:
```bash
kubectl apply -f .\service.yaml
```
Result should be like
```bash
NAME                      TYPE        CLUSTER-IP    EXTERNAL-IP   PORT(S)          AGE
kubernetes                ClusterIP   10.96.0.1     <none>        443/TCP          8m7s
kubernetes-test-service   NodePort    10.98.90.12   <none>        8080:30007/TCP   7m5s
```
Done, you have your service deployed at minikube cluster.

### 5. Other commands
Get url of your service:
```bash
minikube service kubernetes-test-service --url
```
Stop the cluster:
```bash
minikube stop
```
Delete all the traces of the cluster:
```bash
minikube delete
```

## Questions

### What is next
Gonna go deep in kubernetes - try replicas, use Gatling or JMeter and look how it works under load.

### Why Windows
I prefer doing everything on Windows! Forget the devops folks with Linux and the overpriced developers on Macs. Windows is the real hardcore platform for developers. 😎
