## Sukuawali backend -REST Points

- ### Show all items

```http request
GET http://localhost:8080/sukuas/all
```

- ### Add new item

```http request
POST http://localhost:8080/sukuas/add
Content-Type: application/json
```

```json
{
  "name": "White leg prawn",
  "description": "Super delicious",
  "price": 490,
  "imageURL": "https://example.com/image/2/jpg",
  "quantity": 1
}
```

- ### Update existing item

```http request
PUT http://localhost:8080/sukuas/update
Content-Type: application/json
```

```json
{
  "id": 1,
  "name": "Tiger fish large",
  "description": "Super delicious",
  "price": 250,
  "imageURL": "https://example.com/image/1/jpg",
  "quantity": 1
}
```

- ### Place a new order

```http request
POST http://localhost:8080/orders/add
Content-Type: application/json
```

```json
{
  "location": "Patia",
  "items": [
    {
      "id": 1,
      "name": "White leg prawn",
      "description": "Super delicious",
      "price": 490,
      "imageURL": "https://example.com/image/2/jpg",
      "quantity": 1
    }
  ],
  "deliveryCharges": 30,
  "totalAmount": 500
}
```

- ### Order delivered

```http request
PUT http://localhost:8080/orders/delivered/{id}
```

- ### User registration

```http request
PUT http://localhost:8080/users/register
Content-Type: application/json
```

```json
{
  "username": "ultra2",
  "password": "ultra2",
  "isActive": true,
  "roles": [
    {
      "role": "USER"
    },
    {
      "role": "ADMIN"
    }
  ]
}

```
```http request
DELETE http://localhost:8080/users/delete/{user_id}
```

#### Only ADMIN can add new users && DELIVERY_GUY can complete the delivery