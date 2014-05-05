grails-blog-rest-example [![Build Status](https://travis-ci.org/daisaja/grails-blog-rest-example.svg?branch=master)](https://travis-ci.org/daisaja/grails-blog-rest-example)
====

Simple example to show Grails 2.3.x REST capabilities.

* Content negotiation
* HATEOAS
* HAL

----
## Run
Precondition: installed Java 1.6 and higher

without installed Grails: `$ ./grailsw run-app`

with installed Grails: `$ grails run-app`

## Usage

List resource URI: `http://localhost:8080/grails-blog-rest-example/posts`

Resource URI: `http://localhost:8080/grails-blog-rest-example/posts/1` 


## GET, POST, PUT and DELETE examples

### GET

#### Single result
```JavaScript
$ curl -i -H "Accept: application/json" http://localhost:8080/grails-blog-rest-example/posts/1

HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Wed, 30 Apr 2014 07:08:31 GMT

{
  "id": 1,
  "author": "peter",
  "created": "2014-04-30T07:05:54Z",
  "text": "something something something",
  "title": "A great post about something!"
}
```

#### List
```JavaScript
$ curl -i -H "Accept: application/json" http://localhost:8080/grails-blog-rest-example/posts

HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Wed, 30 Apr 2014 07:06:15 GMT

[
  {
    "id": 1,
    "author": "peter",
    "created": "2014-04-30T07:05:54Z",
    "text": "something something something",
    "title": "A great post about something!"
  },
  {
    "id": 2,
    "author": "michael",
    "created": "2014-04-30T07:05:54Z",
    "text": "everything everything everything",
    "title": "A great post about everything!"
  }
]
```

### POST
```JavaScript
$ curl -i -X POST -H "Content-Type: application/json" -d '{"author": "Paul", "title": "New!", "text": "Very cool!", "created": "2014-04-29T20:53:00Z"}' http://localhost:8080/grails-blog-rest-example/posts

HTTP/1.1 201 Created
Server: Apache-Coyote/1.1
Location: http://localhost:8080/grails-blog-rest-example/posts/4
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Wed, 30 Apr 2014 07:15:30 GMT

{
  "id": 4,
  "author": "Paul",
  "created": "2014-04-29T18:53:00Z",
  "text": "Very cool!",
  "title": "New!"
}

```

### PUT
```JavaScript
$ curl -i -X PUT -H "Content-Type: application/json" -d '{"author": "Paul", "title": "New!", "text": "Very very cool!", "created": "2014-04-29T20:53:00Z"}' http://localhost:8080/grails-blog-rest-example/posts/3

HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Location: http://localhost:8080/grails-blog-rest-example/posts/3
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Wed, 30 Apr 2014 07:15:56 GMT

{
  "id": 3,
  "author": "Paul",
  "created": "2014-04-29T18:53:00Z",
  "text": "Very very cool!",
  "title": "New!"
}

```

### DELETE
```
$ curl -i -X DELETE http://localhost:8080/grails-blog-rest-example/posts/3

HTTP/1.1 204 No Content
Server: Apache-Coyote/1.1
Date: Wed, 30 Apr 2014 07:13:44 GMT

```
## HAL example - GET with links

```JavaScript
$ curl -i -H "Accept: application/hal+json" http://localhost:8080/grails-blog-rest-example/posts/1

HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: application/hal+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Tue, 29 Apr 2014 21:40:40 GMT

{
  "_links": {
    "self": {
      "href": "http://localhost:8080/grails-blog-rest-example/posts/1",
      "hreflang": "de",
      "type": "application/hal+json"
    }
  },
  "author": "peter",
  "created": "2014-04-29T21:35:03.336Z",
  "text": "something something something",
  "title": "A great post about something!"
}
```
```JavaScript
curl -i -H "Accept: application/hal+json" http://localhost:8080/grails-blog-rest-example/posts

HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: application/hal+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Tue, 29 Apr 2014 21:41:36 GMT

{
  "_links": {
    "self": {
      "href": "http://localhost:8080/grails-blog-rest-example/grails-blog-rest-example/posts",
      "hreflang": "de",
      "type": "application/hal+json"
    }
  },
  "_embedded": {
    "post": [
      {
        "_links": {
          "self": {
            "href": "http://localhost:8080/grails-blog-rest-example/posts/1",
            "hreflang": "de",
            "type": "application/hal+json"
          }
        },
        "author": "peter",
        "created": "2014-04-29T21:35:03.336Z",
        "text": "something something something",
        "title": "A great post about something!"
      },
      {
        "_links": {
          "self": {
            "href": "http://localhost:8080/grails-blog-rest-example/posts/2",
            "hreflang": "de",
            "type": "application/hal+json"
          }
        },
        "author": "michael",
        "created": "2014-04-29T21:35:03.473Z",
        "text": "everything everything everything",
        "title": "A great post about everything!"
      }
    ]
  }
}
```


