# Local Dev Only

This is just for local development only, with Minikube as a local Kubernetes provider.

# Pods setup:

```zsh
# Example:
kubectl apply -f bootstrap/postgres
```

Checking the pods:

```zsh
# List of pods
kubectl get pods -w
# Logs:
kubectl logs podnamehere
```

# Access

```zsh
# Checking service name:
kubectl get all
```

```zsh
# Getting the URL (--url can be omitted)
minikube service --url rabbitmq
```

## Zipkin Load Balancer

Since its service is a load balancer you can tunnel with the actual port 9411. 
Notice how `EXTERNAL_IP` is `<pending>`:

```zsh
kubectl get services
```

With minikube, tunnel by running:

```zsh
minikube tunnel
```

Run the previous command again and access with the hostname and port provided there.



