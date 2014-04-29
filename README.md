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
    "class": "blog.Post",
    "id": 1,
    "author": "peter",
    "created": "2014-04-29T20:53:00Z",
    "text": "something something something",
    "title": "A great post about something!"
  },
  {
    "class": "blog.Post",
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




