import blog.Post

class BootStrap {

    def init = { servletContext ->
		new Post(author: 'peter', title: 'A great post about something!', text: 'something something something', created: new Date()).save()
		new Post(author: 'michael', title: 'A great post about everything!', text: 'everything everything everything', created: new Date()).save()
    }
	
    def destroy = {
    }
}
