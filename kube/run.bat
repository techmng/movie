kubectl apply -f .\deployment.yml
kubectl apply -f .\services.yml
kubectl port-forward service/movie-service 8181:8181