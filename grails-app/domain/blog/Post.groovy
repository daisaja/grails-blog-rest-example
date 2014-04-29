package blog

import grails.rest.Resource

@Resource(formats=['json', 'xml'])
class Post {
	
	String author
	String title
	String text
	Date created
	
    static constraints = {
		title blank: false
		author blank: false
		text blank: false
		created blank: false
    }
}
