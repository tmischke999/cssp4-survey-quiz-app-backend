### Copied Spring Backend recommended by Matt

H2 console is embedded http://localhost:8080/h2-console/  

Userid = sa  
Password = password



#get all products  
curl http://localhost:8080/products  
#get product by name  
curl http://localhost:8080/products/soccer-ball  
#delete by product name  
curl -X "DELETE" http://localhost:8080/products/soccer-ball  


Sample JSON for POST   
	 {  
	 	"id": "1",  
	 	"name": "ball",  
	 	"category": "outdoor",  
	 	"description": "ball to toss around",  
	 	"price": "10"  
	 }  