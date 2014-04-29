grails-blog-rest-example [![Build Status](https://travis-ci.org/daisaja/grails-blog-rest-example.svg?branch=master)](https://travis-ci.org/daisaja/grails-blog-rest-example)
========================

Simple example to show Grails 2.3.x REST capabilities.

* Content negotiation
* HATEOAS
* HAL

------------------------------------------------------------
## Run ##

without installed Grails: `./grailsw run-app`

with installed Grails: `grails run-app`

------------------------------------------------------------

## Usage ##

See list of all available posts: `http://localhost:8080/grails-blog-rest-example/posts`

will return:

```
[
  {
    "id": 1,
    "author": "peter",
    "created": "2014-04-29T20:53:00Z",
    "text": "something something something",
    "title": "A great post about something!"
  },
  {
    "id": 2,
    "author": "michael",
    "created": "2014-04-29T20:53:00Z",
    "text": "everything everything everything",
    "title": "A great post about everything!"
  }
]
```

Select single one: `http://localhost:8080/grails-blog-rest-example/posts/1` 

will return:

```
{
  "id": 1,
  "author": "peter",
  "created": "2014-04-29T20:53:00Z",
  "text": "something something something",
  "title": "A great post about something!"
}
```


## POST, PUT and DELETE examples ##

```
$ curl -i -X POST -H "Content-Type: application/json" -d '{"author": "Paul", "title": "New!", "text": "Very cool!", "created": "2014-04-29T20:53:00Z"}' http://localhost:8080/grails-blog-rest-example/posts

```
```
$ curl -i -X PUT -H "Content-Type: application/json" -d '{"author": "Paul", "title": "New!", "text": "Very very cool!", "created": "2014-04-29T20:53:00Z"}' http://localhost:8080/grails-blog-rest-example/posts/3

```
```
$ curl -i -X DELETE http://localhost:8080/grails-blog-rest-example/posts/3

```

## HAL example ##

```
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
```
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


