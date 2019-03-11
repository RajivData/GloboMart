# GloboMart

<h2><b>1.ProductCatalog</b></h2>

<p>- Add product details</p>
<pre>	POST-http://localhost:8080/product-catalog/product
		Request Body
		{
		"productName": "Puma full sleeve shirt",
		"productType": "TSHIRT"
		}
</pre>

<p>- Get Product details by id </p>
<pre>	GET -http://localhost:8080/product-catalog/product/4
		{
		"productId": 4,
		"productName": "Puma Sport Tshirt",
		"productType": "TSHIRT"
		}</pre>

<p>- Get Product details by productType</p>
<pre>   GET- http://localhost:8080/product-catalog/product/?product_type=TSHIRT
		[
		{
		"productId": 1,
		"productName": "Puma Sport Tshirt",
		"productType": "TSHIRT"
		},
		{
		"productId": 2,
		"productName": "Puma full sleeve shirt",
		"productType": "TSHIRT"
		}
		]
</pre>

<p>- Delete product details</p>
<pre>	DELETE-http://localhost:8080/product-catalog/productDelete/1
		
		Product Deleted
</pre>



<h2><b>Pricedetails</b></h2>
<p>- Add product price</p>
<pre>	POST - http://localhost:8181/price-details/price
		Request Body
		{
		"productId":1,
		"price":1200.00,
		"tax":125.75
		}
</pre>
<p>- Get product by product id</p>

<pre>	GET- http://localhost:8181/price-details/price/1
		Response
		{
		"id": 1,
		"productId": 1,
		"price": 1200,
		"tax": 125.75,
		"totalPrice": 1325.75
		}
		</pre>